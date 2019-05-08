// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
// import router from './router'
import $ from 'jquery'
import 'bootstrap/dist/js/bootstrap.min'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'font-awesome/css/font-awesome.css'
import 'summernote'
import 'summernote/dist/lang/summernote-zh-CN'
import 'summernote/dist/summernote'
import 'summernote/dist/summernote.css'
import 'layui-layer/dist/layer.js'
import Vuex from 'vuex'
import store from './vuex/store'
Vue.use(Vuex)

import { Swipe, SwipeItem } from 'vue-swipe'  // 加这里
Vue.component('swipe', Swipe)  // 加这里
Vue.component('swipe-item', SwipeItem) // 加这里

// 引用API文件
import api from './assets/js/api.js'
// 将API方法绑定到全局
Vue.prototype.$api = api
Vue.config.productionTip = false
//定义一个全局Bus来传递参数。兄弟组件间的传参。
Vue.prototype.eventBus=new Vue();

import  'lib-flexible'

// 引用路由插件
import VueRouter from 'vue-router'
// 试用路由插件
Vue.use(VueRouter)
//引入路由配置文件
import routes from './router/router'
// 使用配置文件规则
const router = new VueRouter({
  // mode: 'history',
  mode:'hash',
  base: __dirname,
  routes: routes });


Vue.prototype.$goRoute=function (index) {
  this.$router.push(index);
}


/* eslint-disable no-new */
// new Vue({
//   el: '#app',
//   router,
//   components: { App },
//   template: '<App/>',
//   methods:{
//   }
// })

const app = new Vue({
  router: router,
  store,
  render: h => h(App),
  created:function () {
    if(localStorage.getItem("loginStatus")!=true){
      localStorage.setItem("loginStatus",false);
    }
    if(localStorage.getItem("nickName")==null){
      localStorage.setItem("nickName",'');
    }
    this.$store.commit('isLogin',localStorage.getItem("loginStatus"));
    this.$store.commit('newName',localStorage.getItem("nickName"));
  }

}).$mount('#app') ;

router.beforeEach((to, from, next) => {
  if (to.meta.requireAuth) {  // 判断该路由是否需要登录权限
    if (app.$store.state.loginStatus==1) {  // 通过vuex state获取当前的token是否存在
      next();
    }
    else {
      layer.alert("请先登录！");
      next({
        path: '/',
        query: {redirect: to.fullPath}  // 将跳转的路由path作为参数，登录成功后跳转到该路由
      })
    }
  }
  else {
    next();
  }
});
