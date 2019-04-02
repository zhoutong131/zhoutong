import Vue from 'vue'
import Vuex from 'vuex'
Vue.use(Vuex)
const store= new Vuex.Store({
  state:{
    nickName:'',
    loginStatus:0,
  },
  mutations:{
    newName(state,msg){
      state.nickName=msg;
      localStorage.setItem("nickName",msg)
    },
    isLogin(state,msg){
      state.loginStatus=msg;
      localStorage.setItem("loginStatus",msg)
    }
  }

})
export default store
