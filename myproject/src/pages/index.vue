 <template>
    <div id="indexpage">
      <!--<navHeader></navHeader>-->
      <nBanner></nBanner>
      <div style="clear: both"></div>
      <div id="content" class=" col-md-10 col-sm-11">
        <div class="leftContent">
          <div class="article">
            <h2>最新文章</h2>
          </div>
          <div class="article_content" v-for="item in articles">
            <figure class="article_img" v-if="item.article_img==1" @click="$router.push({name:'articleDetail',query:{articalId:item.id}})">
              <img src="../../static/imgs/a.jpg"/>
            </figure>
            <figure  v-else class="article_img" >
              <img :src="$api.root+item.article_img" @click="$router.push({name:'articleDetail',query:{articalId:item.id}})"/>
            </figure>
            <div class="article_right">
              <h3><router-link :to="{path:'/article-detail',query:{articalId:item.id}}">{{item.article_name}}</router-link></h3>
              <div style="clear: both"></div>
              <div class="content_class">{{transfer(item.article_content)}}</div>
            </div>
            <div style="clear: both"></div>
            <div class="article_foot">
              <span class="foot_line"><i class="fa fa-bookmark-o"></i> {{item.author_name}} </span>
              <span class="foot_line"><i class="fa fa-clock-o"></i>{{item.publish_time}}</span>
              <span class="foot_line"><i class="fa fa-commenting-o"></i>评论（{{item.comment_num}}） </span>
              <span class="foot_line"><i class="fa fa-eye"></i>浏览（{{item.brow_num}}） </span>
            </div>
          </div>
          <router-link class="more-info" to="ariticals">更多文章>></router-link>
        </div>
        <div class="search">
          <h2>关于我</h2>
          <p>2017年毕业，软件技术专业。姓名：XX</p>
          <h2>联系我</h2>
          <img src="../../static/imgs/wechat.png" alt="我本人的微信二维码"/>
        </div>
      </div>

      <div id="foot">本站内容来自互联网，如有侵权请联系本人（右上角留言）删除！</div>

      </div>

</template>

<script>
  // import header from '../components/publicHead'
  import banner from '../components/Banner'
  export default {
    name: "index",
    components:{
      // navHeader:header,
      nBanner:banner
    },
    data(){
      return{
        articles:[],
        xx:'121'
      }
    },
    methods:{
      transfer:function (content) {
        let div=document.createElement('div');
        div.innerHTML=content;
        let res=div.innerText||div.textContent;
        return res;
      }
    },
    created() {
      let self=this;
      self.$api.get("/article/five-article",null,function (res) {
        if(res.code==1){
          self.articles=res.data;
        }
      })
    }
  }
</script>

<style scoped>
#indexpage{font-size: 14px;}
   #content{
     /*width: 80%;*/
     float: none;
     margin: 0 auto;
  }
   .content_class{
     display: -webkit-box;
     /*! autoprefixer: off */
     -webkit-box-orient: vertical;
     /* autoprefixer: on */
     -webkit-line-clamp: 3;
     overflow: hidden;
     line-height: 36px;
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
     margin-top: 20px;
     margin-bottom: 60px;
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
     margin: 0 5px;
   }
   .article_foot .foot_line i{margin-right: 5px}
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
   @media screen and (max-width: 600px){
     h2 h3{font-size: 0.9rem}
     p{font-size: 0.4rem}
     #content{
       width: 9rem;
       margin: 0 auto;
     }
     .leftContent{
       width: 9rem;
     }
     .article h2 {
       text-align: left;
       font-size: 0.7rem;
     }
     .article_content{width: 9rem;height:5.2rem;margin-bottom: 0 }
     .article_img{width: 4rem; height: 4.2rem}
     .article_img img{ width: 4rem; height: 4.2rem}
     .article_right{width: 4.4rem;margin-left: 0.3rem}
     .article_right h3{font-size: 0.5rem;margin-top: 0.3rem;display: -webkit-box; /*! autoprefixer: off */-webkit-box-orient: vertical; /* autoprefixer: on */-webkit-line-clamp: 1;overflow: hidden;}
     .article_foot{width:9rem;margin-top:0.4rem;font-size: 0.36rem}
     .article_foot .foot_line{margin:0 0.03rem}
     .article_foot .foot_line i{margin-right: 0.1rem}
     .more-info{font-size: 0.45rem;display: block;margin-top: 0.3rem;}
     .content_class{font-size: 0.4rem;line-height: 0.8rem}
     .search{width: 9rem;margin: 0 auto;text-align: center;}
   }

</style>
