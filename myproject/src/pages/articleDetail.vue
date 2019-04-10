<template>
    <div id="articleDetail" class="col-md-10 col-sm-11">

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
        alert(acticalId);
        //获取传过来的id,请求文章详情。
        let self=this;
        let data={
          articalId:articalId
        }
        self.$api.post('',data,function () {
          
        })
      }
    }
</script>

<style scoped>
/*.articleDetail{wi}*/
</style>
