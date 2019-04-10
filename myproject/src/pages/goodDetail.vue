<template>
    <div id="goodDetail" class=" col-md-10 col-sm-11">
      <div class="good-content">
        <img class="good-img" :src="$api.root+good.goods_img" alt="商品图片"/>
        <div class="text-content">
          <h3 class="good-name">{{good.goods_name}}</h3>
          <p class="good-desc"><span>描述:</span>{{good.goods_desc}}</p>
          <div class="good-bottom">
            <p>库存:{{good.stock}}</p>
            <span>数量:</span><input type="number" class="form-control numberInput" min="0" v-model="amount"/>

            <div class="btn-bottom"><button class="btn btn-success">直接购买</button><button class="btn btn-success">加入购物车</button></div>
          </div>
        </div>
      </div>
      <h3>买家评论</h3>
      <div class="bottom-line"></div>
    </div>
</template>

<script>
    export default {
      name: "goodDetail",
      data(){
        return{
          amount:'',
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
    text-align: left;
    float: none;
    margin: 0 auto;
    font-size: 16px;
  }
  .good-content{
    position: relative;
    display: flex;
    flex-direction: row;
  }
  .good-content:after{display:block;content:'';clear: both}
  .good-img{width: 300px;height: 400px;margin: 20px 0 0 40px}
  .good-desc{margin-top:20px;font-size: 16px}
  .text-content{padding:10px 0 0 20px; }
  .text-content h3{text-align: left}
  .good-bottom{position: absolute;bottom: 0;text-align: left}
  .numberInput{width: 80px;height: 40px;display: inline-block}
  .btn-bottom{margin-top: 20px;}
  .btn-bottom button{margin: 0 40px}
  .bottom-line{width: 100%;border-bottom: 1px solid #00aeef}

</style>
