<template>
  <div id="head">
    <div id="nav_login" class="mobile-login ">
      <ul v-if="this.$store.state.loginStatus.toString()==1?true:false" class="right-ban">
        <li><img class="login-icon" src="/static/imgs/login-icon.png"/></li>
        <li class="login-name"><a >{{this.$store.state.nickName.toString()}}</a><i class="fa fa-angle-down"></i>
          <ul class="user-info">
            <li><router-link to="user-center">个人中心</router-link></li>
            <li><router-link to="myarticle">写文章</router-link></li>
            <li><router-link to="newGood">添加商品</router-link></li>
            <li><a style="cursor: pointer;" @click="logout()">注销</a></li>
          </ul>
        </li>
      </ul>
      <ul v-else class="right-ban">
        <li><a style="cursor: pointer" @click="openLogin()">登录</a></li>
        <li>|</li>
        <li><a style="cursor: pointer" @click="openregister()">注册</a></li>
      </ul>
    </div>
    <header id="header" class="mobile-logo">
      <div class="navbar navbar-inverse" role="banner">
        <div class="mynav-header  col-md-10 col-sm-11">
          <div class="navbar-header">
            <a class="navbar-brand"  href="#">
              <h1 style="float:left"><img src="/static/imgs/logo.png" alt="logo"></h1>
              <div class="logo-title" @click="$goRoute('/')">
                <h2>梧桐树</h2>
                <h3>www.zhoutong.online</h3>
              </div>
            </a>

          </div>
          <ul class="myNavigation">
            <li><router-link to="/">首页</router-link></li>
            <li><router-link to="/commodity">二手商品</router-link></li>
            <li><router-link to="/user-center">个人中心</router-link></li>
            <li><router-link to="/user-center">我的文章</router-link></li>
          </ul>
        </div>
      </div>
    </header>
    <ul class="mobile-navigation">
      <li><router-link to="/">首页</router-link></li>
      <li><router-link to="/commodity">二手商品</router-link></li>
      <li><router-link to="/user-center">我的文章</router-link></li>
      <li><router-link to="/user-center">个人中心</router-link></li>
    </ul>
    <!-- 模态框（Modal） -->
    <div class="modal fade" id="LoginModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static">
      <div class="modal-dialog">
        <div class="modal-content">
          <!--登陆框头部-->
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
              ×
            </button>
            <h4 class="modal-title" id="myModalLabel">
              登录
            </h4>
          </div>
          <!--登陆框中间部分(from表单)-->
          <div class="modal-body">
            <form @submit.prevent="login()">
              <div class="row">
                <div class="col-sm-6 col-xs-8 account-input">
                  <label><i class="glyphicon glyphicon-user"></i></label>
                  <input type="text" v-model="account" class="form-control" placeholder="请输入账号" required/>
                </div>
              </div>
              <div class="row" style="margin-top: 20px">
                <div class="col-sm-6 col-xs-8 account-input">
                  <label><i class="glyphicon glyphicon-pencil"></i></label>
                  <input type="password" v-model="password" class="form-control" placeholder="请输入密码" required/>
                </div>
              </div>
              <div class="row" style="margin-top: 10px">
                <div class="col-sm-6 col-xs-8 account-input">
                  <a style="float: left;cursor: pointer">忘记密码？</a>
                  <a style="float: right;cursor: pointer" @click="openregister()"> 注册帐号</a>
                </div>
              </div>
              <button type="submit" class="btn btn-primary btn-position">登录</button>
            </form>
          </div>
        </div>
      </div>
    </div>
    <!-- 模态框（Modal） -->
    <div class="modal fade" id="registernModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static">
      <div class="modal-dialog">
        <div class="modal-content">
          <!--登陆框头部-->
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
              ×
            </button>
            <h4 class="modal-title" id="registerModalLabel">
              注册
            </h4>
          </div>
          <!--注册框中间部分(from表单)-->
          <div class="modal-body">
            <!--<form @submit.prevent="register()">-->
              <div class="row">
                <div class="col-sm-6 col-xs-8 account-input">
                  <label><i class="glyphicon glyphicon-user"></i></label>
                  <input type="text" v-model="registeraccount" class="form-control" placeholder="账号(6-18位不重复字母或数字)" required/>
                </div>
              </div>
              <div class="row" style="margin-top: 20px">
                <div class="col-sm-6 col-xs-8 account-input">
                  <label><i class="glyphicon glyphicon-pencil"></i></label>
                  <input type="text" v-model="nickname" class="form-control" placeholder="昵称（1-10位）" required/>
                </div>
              </div>
              <div class="row" style="margin-top: 20px">
                <div class="col-sm-6 col-xs-8 account-input">
                  <label><i class="glyphicon glyphicon-pencil"></i></label>
                  <input type="password" v-model="registerpassword" class="form-control" placeholder="密码(6-18位数字或字母)" required/>
                </div>
              </div>
              <div class="row" style="margin-top: 20px">
                <div class="col-sm-6 col-xs-8 account-input">
                  <label><i class="glyphicon glyphicon-pencil"></i></label>
                  <input type="password" v-model="confirmpassword" class="form-control" placeholder="确认密码" required/>
                </div>
              </div>
              <div class="row" style="margin-top: 20px">
                <div class="col-sm-6 col-xs-8 account-input">
                  <label><i class="glyphicon glyphicon-pencil"></i></label>
                  <input type="text" v-model="email" class="form-control" placeholder="邮箱" required/>
                </div>
              </div>
              <div class="row" style="margin-top: 20px">
                <div class="col-sm-6 col-xs-8" style="float: none;margin:0 auto">
                  <div class="col-sm-7 col-xs-8">
                    <input type="text"v-model="verificationCode" class="form-control" placeholder="验证码" required/>
                  </div>
                  <div class="col-sm-5 col-xs-4">
                    <button id="getCode" type="button" @click="getVerCode()" class="btn btn-success">获取验证码</button>
                  </div>
                </div>
              </div>
              <button type="button" @click="register()" class="btn btn-primary btn-position">注册</button>
            <!--</form>-->
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  import api from "../assets/js/api";
    export default {
      name: "publicHead",
      inject:['reload'],
      data () {
        return {
          registeraccount:'',
          registerpassword:'',
          confirmpassword:'',
          verificationCode:'',
          myCode:'',
          email:'',
          nickname:'',
          account:'',
          password:''
        }
      },
      methods:{
        register:function(){
          var Regx = /^[A-Za-z0-9]*$/;
          if (!Regx.test(this.registeraccount)) {
            layer.alert("请输入字母或数字！",{
              icon:0
            });
            return false;
          }
          if(!(this.registeraccount.length>=6&&this.registeraccount.length<=18))
          {
            layer.alert("账号大于6位，小于18位！",{
              icon:0
            });
            return false;
          };
          if(!(this.nickname.length>=1&&this.nickname.length<=10))
          {
            layer.alert("昵称1-10位！",{
              icon:0
            });
            return false;
          };
          if (!Regx.test(this.registerpassword)) {
            layer.alert("请输入字母或数字！",{
              icon:0
            });
            return false;
          }
          if(!(this.registerpassword.length>=6&&this.registerpassword.length<=18))
          {
            layer.alert("密码6-18位！",{
              icon:0
            });
            return false;
          };
          if(this.registerpassword!=this.confirmpassword){
            layer.alert("请确认密码一致！",{
              icon:0
            });
            return false;
          }
          if(this.verificationCode==undefined||this.verificationCode==null||this.verificationCode=='')
          {
            layer.alert("请填写验证码！",{
              icon:0
            });
            return false;
          };
          if(this.verificationCode!=this.myCode){
            layer.alert("验证码不匹配！",{
              icon:0
            });
            this.verificationCode="";
            $("#getCode").attr("disabled",false);
            $("#getCode").text("重新发送");
            return false;
          };
          var data={
            account:this.registeraccount,
            nick_name:this.nickname,
            password:this.registerpassword,
            email:this.email
          };
          api.postFornoToken("/user/register",data,function (result) {
            if(result.code==1){
              layer.msg("注册成功！");
              $("#registernModal").modal('hide');
            }
            else{
              layer.msg(result.message);
            }
          })

        },
        getVerCode:function(){
          var headself=this;
          var reg = new RegExp("^[a-z0-9A-Z]+[- | a-z0-9A-Z . _]+@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-z]{2,}$");
          if(!reg.test(this.email))
          {
            layer.alert("邮箱地址格式不正确！请填写正确的邮箱地址",{
              icon:0
            })
            return false;
          }
          $("#getCode").attr("disabled",true);
          $("#getCode").text("等待中。。");
          var data={
            email:this.email
          };
          api.postFornoToken("/user/send-email",data,function (result) {
            if(result.code==1){
              headself.myCode=result.data;
              layer.msg("验证码已发送至您的邮箱，请注意查收！");
              $("#getCode").text("已发送！");
            }
            else{
              layer.alert("邮箱不存在！",{
                title:'提示信息',
                icon:5
              });
            }
          })
        },
        openLogin:function () {
          $("#LoginModal").modal('show');
        },
        login:function () {
          var headself=this;
          var data={
            account:this.account,
            password:this.password
          };
          api.postFornoToken("/user/login",data,function (result) {
            if(result.code==1){
              headself.$store.commit('isLogin',"1");
              headself.$store.commit('newName',result.data.nick_name);
              localStorage.setItem("user",JSON.stringify(result.data));
              $("#LoginModal").modal('hide');
              headself.reload();
            }
            else
              layer.alert("登录失败，账号或密码错误！",{
                title:'登录信息',
                icon:5
              });
          });
        },
        logout:function () {
          this.$store.commit('isLogin',"0");
          localStorage.clear();
          this.$goRoute('/');
        },
        openregister:function () {
          $("#LoginModal").modal('hide');
          $("#registernModal").modal('show');
        },
        selected:function (e) {
          let dom=e.currentTarget;
          $(dom).addClass("active");
          $(".nav li").each(function (i,item) {
            if(item!=dom) {
              $(item).removeClass("active");
              $(item).addClass("dropdown");
            }
          })
        }
      }
    }

</script>

<style scoped>
  #head{font-size: 14px;}
  .mynav-header{float:none;margin: 0 auto}
  .mynav-header:after{display: block;content: '';clear: both;}
  .login-name:hover>ul.user-info{
    display: block;
    -webkit-animation: fadeInUp 400ms;
    animation: fadeInUp 400ms;
  }
  .user-info{
    display: none;
    right: 0px;
    top: 40px;
    padding: 0;
    /* display: none; */
    position: absolute;
    width: 100px;
    border: 1px solid #27d;
    z-index: 100;
  }
  .user-info li{
    /* margin-top: 10px; */
    clear: both;
    height: 30px;
    width: 100%;
    padding-top: 4px;
    text-align: left;
  }
  .user-info li a{
    width: 100%;
  }
  .login-name{
    height:40px;
    position: relative;
    margin-top: 6px;
    z-index: 100;
  }
  .login-name a{
    display: block;
    float:left;
    cursor: pointer;
    margin-right: 6px;
    color:#000;
    max-width:80px;
    word-break: keep-all;
    white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis;

  }
  .login-icon{
    width: 40px;
    height: 40px;
    border-radius: 20px;
  }
  #nav_login{
    float: right;
    margin: 10px 20px 0 0;
  }
  #nav_login .right-ban li{
    float:left;
    list-style: none;
    margin-left: 10px;
  }
  #nav_login .right-ban li a{

  }
  .logo-title{
    float:left;
    margin-left:10px
  }
  .logo-title h2,.logo-title h3{
    color: #9d9d9d !important;
    text-align: left;
    margin: 0;
    padding: 0;
  }
  #header{
    padding: 50px 0 30px 0;
  }
  #header .navbar {
    background: #fff;
    border: 0;
    margin-bottom: 0;
  }
  #header .navbar-inverse .container {
    position: relative;
  }
  #header .navbar-brand {
    padding: 0;
    margin-left: 0;
  }
  #header .navbar-brand h1 {
    padding: 0;
    margin: 0;
  }
  #header .navbar-inverse .navbar-nav li.active > a, #header .navbar-inverse .navbar-nav li.active > a:focus, #header .navbar-nav.navbar-right li > a:hover, .navbar-inverse .navbar-nav > .open > a {
    background-color: inherit;
    border: 0;
    color: #00aeef;
  }
  #header .navbar-nav.navbar-right >li a {
    color: #000;
    font-size: 12px;
    padding: 20px;
    text-transform: uppercase;
    font-weight: 300;
  }
  ul.mobile-navigation{display: none}
  ul.myNavigation{margin: 0 auto;float: left;}
  ul.myNavigation li{list-style: none;float: left;font-size: 18px;padding: 16px 24px;margin-top: 20px;}
  ul.myNavigation li a{color: #000;text-decoration: none}
  ul.myNavigation li a:hover{border-bottom: 3px solid #00aeef}
  @media only screen and (min-width: 768px){
    ul.sub-menu {
      position: absolute;
      top: 60px;
      left: 0;
      background: #fff;
      padding: 10px 0;
      width: 240px;
      box-shadow: none;
      display: none;
      z-index: 999;
      border: 1px solid #00aeef;
    }
    #header .navbar-nav li ul.sub-menu li a {
      padding-left: 20px;
    }
  }
  ul.sub-menu {
    display: none;
    list-style: none;
    padding: 0;
    margin: 0;
  }

  #header .navbar-nav li ul.sub-menu li a {
    color: #818285;
    padding: 5px 0;
    font-size: 13px;
    display: block;
    text-transform: capitalize;
  }
  #header .navbar-nav.navbar-right >li a {
    color: #000;
    font-size: 16px;
    font-weight: normal !important;
    padding: 20px;
    text-transform: uppercase;
    /*font-weight: 300;*/
  }
  .search {
    position: absolute;
    top: 20px;
    right: 0;
    z-index: 1;
  }
  .search i {
    color: #00aeef;
    cursor: pointer;
    position: absolute;
    right: 10px;
    top: 2px;
  }
  .field-toggle {
    position: relative;
    top: 30px;
    right: 15px;
    display: none;
    height: 50px;
  }
  .search-form {
    padding-left: 10px;
    height: 40px;
    font-size: 18px;
    color: #818285;
    font-weight: 300;
    outline: none;
    border: 1px solid #00aeef;
    margin-top: 20px;
    border-radius: 4px;
  }
  .account-input{
    position: relative;
    float: none;
    margin: 0 auto;
  }
  .account-input label{
    position: absolute;
    left: 26px;
    top: 10px;
  }
  .account-input label i{
    color: #27d;
  }
  .account-input input{
    height:40px;
    padding-left: 36px;
    border:1px solid #27d;
  }
  .btn-position{
    margin: 30px;
    width: 100px;
  }
  @media screen and (max-width: 600px){
    .mobile-login{display: none}
    .mobile-logo{width: 100%;height:2.4rem; padding:0.4rem 0 0 0.8rem !important;}
    ul.myNavigation{display: none}
    ul.mobile-navigation{display:block;padding: 0; padding-left: 0.1rem;}
    ul.mobile-navigation:after{display: block;content: '';clear: both}
    ul.mobile-navigation li{list-style: none;float:left;padding: 0.2rem 0.3rem;}
    ul.mobile-navigation li:hover{border-bottom: 2px solid #1397dc;}
    ul.mobile-navigation li a{font-size: 16px;color: #000;text-decoration: none}
    .logo-title h2{font-size: 0.8rem}
    .logo-title h3{font-size: 0.6rem}

  }
</style>
