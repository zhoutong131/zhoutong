<template>
    <div id="article_page">
      <navHeader></navHeader>
      <div class="main_content col-md-9 col-sm-10">
        <div class="row first_row1">
          <div class="form-group">
            <div class="col-md-4 col-sm-5 pd_t"><span>文章标题：</span><i style="color:red;">*</i></div>
            <div class="col-md-8 col-sm-7"><input type="text" class="form-control" v-model="article_title"></div>
          </div>
        </div>
      </div>
    </div>
</template>

<script>
  import header from '../components/publicHead'
    export default {
      name: "article_page",
      components:{
        navHeader:header,
      },
      data(){
        return{
          article_title:''
        }
      }
    }
</script>

<style scoped>
  #article_page{
    width: 100%;
  }
.main_content{
  float: none;
  margin: 0 auto;
}
  .first_row1{
    width: 50%;
    margin: 0 auto;
  }
  .pd_t{padding-top: 8px;}
</style>
