<template>
    <div id="articleDetail">
      <!--<header1></header1>-->
      <h1>{{}}</h1>
    </div>
</template>

<script>
  // import header1 from '../components/publicHead'
    export default {
      name: "articleDetail",
      components:{
          // header1
      },
      data(){
        return{
        }
      },
      created() {
        debugger;
        alert(this.$route.params.article_name)
      }
    }
</script>

<style scoped>

</style>
