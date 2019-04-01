//加载模板文件
import index from '../pages/index'
import list from '../pages/list'
import emtion from '../pages/Emoticon'
import myarticle from '../pages/myarticle'
import articleDetail from '../pages/articleDetail'
import userCenter from '../pages/userCenter'
import commodity from '../pages/commodity'
import newGood from '../pages/newGood';
//路由规则设置
export default [
  {
    path: '/',
    component: index,
    meta: {
      requireAuth: false // 添加该字段，表示进入这个路由是需要登录的
    }
  },
  {
    path: '/list',
    component: list,
    meta: {
      requireAuth: true // 添加该字段，表示进入这个路由是需要登录的
    }
  },
  {
    path: '/emtion',
    component: emtion,
    meta: {
      requireAuth: true // 添加该字段，表示进入这个路由是需要登录的
    }
  },
  {
    path: '/myarticle',
    component: myarticle,
    meta: {
      requireAuth: true // 添加该字段，表示进入这个路由是需要登录的
    }
  },
  {
    path:'/article-detail',
    component:articleDetail,
    meta:{
      requireAuth:true
    }
  },
  {
    path:'/user-center',
    component:userCenter,
    meta:{
      requireAuth:false
    }
  },
  {
    path:'/commodity',
    component:commodity,
    meta:{
      requireAuth:false
    }
  },
  {
    path:'/newGood',
    component:newGood,
    meta:{
      requireAuth:false
    }
  }

]
