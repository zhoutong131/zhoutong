<template>
    <div id="goodDetail" class="col-lg-8 col-md-9 col-sm-10">
      <div class="good-content">
        <img class="good-img" :src="$api.root+good.goods_img" alt="商品图片"/>
        <div class="text-content">
          <h1 class="good-name">{{good.goods_name}}</h1>
        </div>
      </div>
    </div>
</template>

<script>
    export default {
      name: "goodDetail",
      data(){
        return{
          good:{}
        }
      },
      mounted() {
        let good=this.$route.params;
        if(good.goods_name!=null){
          this.good=good;
          localStorage.setItem("good",JSON.stringify(good));
        }
        else{
          this.good=JSON.parse(localStorage.getItem("good"));
        }
      },
      beforeDestroy() {
        localStorage.removeItem("good");
      }
    }
</script>

<style scoped>
  #goodDetail{
    float: none;
    margin: 0 auto;
  }
  .good-content{
    display: flex;
    flex-direction: row;
  }
  .good-img{flex:1}
  .text-content{flex: 4}

</style>
