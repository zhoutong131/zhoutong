<template>
    <div id="articleDetail" class="col-md-10 col-sm-11">
      <h1 class="title_name">{{artical.article_name}}</h1>
      <div class="article_info">
        <span>作者：{{artical.author_name}}</span>
        <span>发布时间：{{artical.publish_time}}</span>
        <span>评论：{{artical.comment_num}}</span>
      </div>
      <div class="article_content" v-html="artical.article_content">
        {{artical.article_content}}
      </div>
    </div>
</template>

<script>
    export default {
      name: "articleDetail",
      data(){
        return{
          artical:{}

        }
      },
      methods:{

      },
      beforeCreate() {
        let articalId=this.$route.query.articalId;
        //获取传过来的id,请求文章详情。
        let self=this;
        let data={articalId:articalId};
        self.$api.get('/article/article-detail',data,function (res) {
          if(res.code==1){self.artical=res.data;}
          else if(res.code=='1005'){
            layer.alert("身份信息已过期，请重新登录！");
            self.$goRoute("/");
            return false;
          }
        });
        //下面获取评论列表

      }
    }
</script>

<style scoped>
/*.articleDetail{wi}*/
  #articleDetail{
    font-size: 16px;
    background: url("../../static/imgs/book_bak.jpg") no-repeat;
    background-size: 100% 100%;
    padding: 40px 40px;
    float: none;
    margin: 0 auto;
    min-height: 600px;
  }
  .title_name{font-size: 24px;}
  .article_info{ width: 60%;margin: 0 auto;padding: 20px;border: 1px dashed #000; border-radius: 5px;}
  .article_info span{margin: 10px;}
  .article_content{padding: 0 10%}
</style>
