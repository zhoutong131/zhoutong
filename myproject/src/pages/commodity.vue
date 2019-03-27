<template>
    <div id="goods" class="col-lg-7 col-md-9 col-sm-10">
      <i class="icon-search fa fa-search"></i><input type="text" class="search form-control"><button class="mr-20 btn btn-default"> 查找</button>
      <div class="line-style"></div>
      <div class="row">
        <div class="goods-item col-lg-3 col-md-5 col-sm-5">
          <img src="../../static/imgs/a.jpg" >
          <span class="price"><i class="fa fa-cny"></i>288</span>
          <router-link class="goods-name" to="goods-detail">阿姐家 情侣装2018夏装新款一字领短袖雪纺衫上衣鱼尾半身裙套装</router-link>
        </div>
        <div class="goods-item col-lg-3 col-md-5 col-sm-5">
          <img src="../../static/imgs/a.jpg" >
          <span class="price"><i class="fa fa-cny"></i>288</span>
          <router-link class="goods-name" to="goods-detail">阿姐家 情侣装2018夏装新款一字领短袖雪纺衫上衣鱼尾半身裙套装</router-link>
        </div>
        <div class="goods-item col-lg-3 col-md-5 col-sm-5">
          <img src="../../static/imgs/a.jpg" >
          <span class="price"><i class="fa fa-cny"></i>288</span>
          <router-link class="goods-name" to="goods-detail">阿姐家 情侣装2018夏装新款一字领短袖雪纺衫上衣鱼尾半身裙套装</router-link>
        </div>
        <div class="goods-item col-lg-3 col-md-5 col-sm-5">
          <img src="../../static/imgs/a.jpg" >
          <span class="price"><i class="fa fa-cny"></i>288</span>
          <router-link class="goods-name" to="goods-detail">阿姐家 情侣装2018夏装新款一字领短袖雪纺衫上衣鱼尾半身裙套装</router-link>
        </div>
        <div class="goods-item col-lg-3 col-md-5 col-sm-5">
          <img src="../../static/imgs/a.jpg" >
          <span class="price"><i class="fa fa-cny"></i>288</span>
          <router-link class="goods-name" to="goods-detail">阿姐家 情侣装2018夏装新款一字领短袖雪纺衫上衣鱼尾半身裙套装</router-link>
        </div>

      </div>
    </div>
</template>

<script>
    export default {
      name: "commodity",
    }
</script>

<style scoped>
#goods{
  float: none;
  margin: 0 auto;
  text-align: left;
  position: relative;
}
.price{display: block;margin:10px;font-size: 20px;color:#00aeef;font-weight: bold}
.mr-20{margin-left: 20px;}
.icon-search{
  position: absolute;
  left: 24px;
  top: 8px;
  font-size: 18px;
}
  .search{
    padding-left: 30px;
    display: inline-block;
    width: 40%;
  }
.line-style{margin-top:20px;width: 100%;border-bottom: 1px solid #00aeef;}
  .goods-item{
    border: 1px solid transparent;
    /*加一个相同大小的透明边框，使hover效果的边框出现后里面的内容不会出现偏移*/
    margin: 10px 20px;
    padding: 10px;
  }
  .goods-item:hover{
    border: 1px solid #00aeef;
  }
  .goods-item img{
    cursor: pointer;
    display: block;
    width: 100%;
    height:240px;
  }
  .goods-name{
    overflow: hidden;
    text-overflow:ellipsis;
    display: -webkit-box;
    -webkit-box-orient: vertical;
    -webkit-line-clamp: 2;
  }

</style>
