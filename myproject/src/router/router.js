//加载模板文件
import index from '../pages/index'
import list from '../pages/list'
import emtion from '../pages/Emoticon'
import myarticle from '../pages/myarticle'
import goodDetail from '../pages/goodDetail'
import userCenter from '../pages/userCenter'
import commodity from '../pages/commodity'
import newGood from '../pages/newGood'
import articleDetail from '../pages/articleDetail'
import goBang from '../pages/goBang'
//路由规则设置
export default [
  {
    path: '/',
    component: index,
    name:'index',
    meta: {
      requireAuth: false // 添加该字段，表示进入这个路由是需要登录的
    }
  },
  {
    path: '/list',
    component: list,
    name:'list',
    meta: {
      requireAuth: true // 添加该字段，表示进入这个路由是需要登录的
    }
  },
  {
    path: '/emtion',
    component: emtion,
    name:'emtion',
    meta: {
      requireAuth: true // 添加该字段，表示进入这个路由是需要登录的
    }
  },
  {
    path: '/myarticle',
    component: myarticle,
    name:'myarticle',
    meta: {
      requireAuth: true // 添加该字段，表示进入这个路由是需要登录的
    }
  },
  {
    path:'/good-detail',
    component:goodDetail,
    name:'goodDetail',
    meta:{
      requireAuth:true
    }
  },
  {
    path:'/user-center',
    component:userCenter,
    name:'userCenter',
    meta:{
      requireAuth:false
    }
  },
  {
    path:'/commodity',
    component:commodity,
    name:'commodity',
    meta:{
      requireAuth:false
    }
  },
  {
    path:'/newGood',
    component:newGood,
    name:'newGood',
    meta:{
      requireAuth:false
    }
  },
  {
    path:'/article-detail',
    component:articleDetail,
    name:'articleDetail',
    meta:{
      requireAuth:true
    }
  },
  {
    path:'/goBang',
    component:goBang,
    name:'goBang',
    meta:{
      requireAuth:true
    }
  }

]
