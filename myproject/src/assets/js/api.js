// 配置API接口地址
var root = 'http://localhost:9090/mypro/'
// 引用axios
var axios = require('axios')
// 自定义判断元素类型JS
function toType (obj) {
  return ({}).toString.call(obj).match(/\s([a-zA-Z]+)/)[1].toLowerCase()
}
// 参数过滤函数
function filterNull (o) {
  for (var key in o) {
    if (o[key] == null) {
      delete o[key]
    }
    if (toType(o[key]) == 'string') {
      o[key] = o[key].trim()
    } else if (toType(o[key]) == 'object') {
      o[key] = filterNull(o[key])
    } else if (toType(o[key]) == 'array') {
      o[key] = filterNull(o[key])
    }
  }
  return o
}
/*
  接口处理函数
  这个函数每个项目都是不一样的，我现在调整的是适用于
  https://cnodejs.org/api/v1 的接口，如果是其他接口
  需要根据接口的参数进行调整。参考说明文档地址：
  https://cnodejs.org/topic/5378720ed6e2d16149fa16bd
  主要是，不同的接口的成功标识和失败提示是不一致的。
  另外，不同的项目的处理方法也是不一致的，这里出错就是简单的alert
*/

function apiAxios (method, url, params, success) {
  if (params) {
    params = filterNull(params)
  };
  var token=JSON.parse(localStorage.getItem("user")).token,
   account=JSON.parse(localStorage.getItem("user")).account;
  axios({
    method: method,
    url: url,
    headers:{
      'account':account,
      'token':token
    },
    data: method == 'POST' || method == 'PUT' ? params : null,
    params: method == 'GET' || method == 'DELETE' ? params : null,
    baseURL: root,
    withCredentials: false
  })
    .then(function (res) {
      success(res.data)
    })
    .catch(function (err) {
      let res = err.response
      if (err) {
        console.log('api error, HTTP CODE: ' + res.status)
      }
    })
}
function apiAxiosNotoken (method, url, params, success) {
  if (params) {
    params = filterNull(params)
  }
  axios({
    method: method,
    url: url,
    data: method == 'POST' || method == 'PUT' ? params : null,
    params: method == 'GET' || method == 'DELETE' ? params : null,
    baseURL: root,
    withCredentials: false
  })
    .then(function (res) {
          success(res.data)
    })
    .catch(function (err) {
      let res = err.response
      if (err) {
        debugger;
        console.log('api error, HTTP CODE: ' + res.status)
      }
    })
}
  function uploadFileApi(url,data,success) {
    this.$http.post(url, data, {
      headers: {
        'Content-Type': 'multipart/form-data'
      }
    })
      .then(function (res) {
        success(res.data)
      })
      .catch(function (err) {
        let res = err.response
        if (err) {
          console.log('api error, HTTP CODE: ' + res.status)
        }
      })
  }
// 返回在vue模板中的调用接口
export default {
  get: function (url, params, success) {
    return apiAxios('GET', url, params, success)
  },
  post: function (url, params, success) {
    return apiAxios('POST', url, params, success)
  },
  put: function (url, params, success) {
    return apiAxios('PUT', url, params, success)
  },
  delete: function (url, params, success) {
    return apiAxios('DELETE', url, params, success)
  },
  postFornoToken:function(url, params, success){
    return apiAxiosNotoken('POST', url, params, success)
  },
  uploadFile:function (url, params, success) {
    return uploadFileApi(url,params,success)
  }
}
