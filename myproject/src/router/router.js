//加载模板文件

// / /下面2行代码，没有指定webpackChunkName，每个组件打包成一个js文件。
const index = () => import(/* webpackChunkName: 'index' */'../pages/index')
const list = () => import(/* webpackChunkName: 'list' */'../pages/list')
const emtion = () => import(/* webpackChunkName: 'Emoticon' */'../pages/Emoticon')
const myarticle = () => import(/* webpackChunkName: 'myarticle' */'../pages/myarticle')
const goodDetail = () => import(/* webpackChunkName: 'goodDetail' */'../pages/goodDetail')
const userCenter = () => import(/* webpackChunkName: 'userCenter' */'../pages/userCenter')
const commodity = () => import(/* webpackChunkName: 'commodity' */'../pages/commodity')
const newGood = () => import(/* webpackChunkName: 'newGood' */'../pages/newGood')
const articleDetail = () => import(/* webpackChunkName: 'articleDetail' */'../pages/articleDetail')
const goBang = () => import(/* webpackChunkName: 'goBang' */'../pages/goBang')

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
