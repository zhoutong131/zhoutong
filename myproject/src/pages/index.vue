<template>
    <div id="indexpage">
      <navHeader></navHeader>
      <nBanner></nBanner>
      <div style="clear: both"></div>
      <div id="content">
        <div class="leftContent">
          <div class="article">
            <h2>最新文章</h2>
          </div>
          <div class="article_content">
            <figure class="article_img">
              <img src="../../static/imgs/a.jpg"/>
            </figure>
            <div class="article_right">
              <h3><router-link to="list">文章标题</router-link></h3>
              <p>文章内容,jhsdahdiuashduiashduashduisaaaaaaaaaaaaaaaaaaaadusa</p>
            </div>
            <div style="clear: both"></div>
            <div class="article_foot">
              <span class="foot_line"><i class="fa fa-bookmark-o"></i> 周童 </span>
              <span class="foot_line"><i class="fa fa-clock-o"></i>2019-03-11 </span>
              <span class="foot_line"><i class="fa fa-commenting-o"></i>评论（10） </span>
              <span class="foot_line"><i class="fa fa-eye"></i>浏览（189） </span>
            </div>
          </div>
        </div>
        <div class="search">
          <h2>关于我</h2>
          <p>2017年毕业，软件技术专业。姓名：周童</p>
          <h2>联系我</h2>
          <img src="../../static/imgs/wechat.png" alt="我本人的微信二维码"/>
        </div>
      </div>
      <div id="foot">本站内容来自互联网，如有侵权请联系本人（右上角留言）删除！</div>

      </div>

</template>

<script>
  import header from '../components/publicHead'
  import banner from '../components/Banner'
  export default {
    name: "index",
    components:{
      navHeader:header,
      nBanner:banner
    }
  }
</script>

<style scoped>
   #content{
     width: 80%;
     margin: 0 auto;
  }
   .leftContent{
     width: 60%;
     float: left;
   }
   .article{
     border-bottom: 5px solid red;
   }
   .article_content{
     width: 100%;
     height: 180px;
     margin: 20px 0;
   }
   .article_img{
     width: 30%;
     float: left;
   }
   .article_right{
     width: 65%;
     margin-left: 3%;
     float: left;
     text-align: left;
   }
   .article_right:after{
     display: block;
     content: '';
     clear: both;
   }
   .article_foot{
     width: 68%;
     float: right;
     text-align: left;
   }
   .article_foot .foot_line{
     margin: 0 2%;
   }
   .article_foot .foot_line i{margin-right: 10px}
   .article_right h3{
     margin: 0 0 10px 0;
     font-size: 16px;
     font-weight: bold;
   }
   .article_img img{
     width: 100%;
     height:180px;
   }
   .search{
     margin-top: 20px;
     width: 30%;
     float:left;
     text-align: left;
     margin-left: 6%;
   }
   .search img{width: 50%}
   .article h2{
     text-align: left;
   }
   #content:after{
     display: block;
     content: '';
     clear: both;
   }
  #foot{
    padding-top: 60px;
    font-size: 16px;
    /*position: absolute;*/
    /*bottom:0;*/
    width: 100%;
    height:110px;
    background: url("/static/imgs/grass.png");
    background-size: 100% 100%;
  }

</style>
