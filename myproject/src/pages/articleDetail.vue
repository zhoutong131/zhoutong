<template>
    <div id="articleDetail" class="col-md-10 col-sm-11">
      <h1>{{artical.article_name}}</h1>
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
      created() {
        let articalId=this.$route.query.articalId;
        alert(articalId);
        //获取传过来的id,请求文章详情。
        let self=this;
        let data={
          articalId:articalId
        }
        self.$api.get('/article/article-detail',data,function (res) {
          debugger;
          if(res.code==1){
            self.artical=res.data;
          }
          
        })
      }
    }
</script>

<style scoped>
/*.articleDetail{wi}*/
</style>
