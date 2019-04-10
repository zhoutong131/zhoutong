<template>
  <swipe class="my-swipe  col-md-10 col-sm-11" :options="swiperOption">
    <swipe-item class="slide1">1</swipe-item>
    <swipe-item class="slide2">2</swipe-item>
    <swipe-item class="slide3">3</swipe-item>
    <swipe-item class="slide4">3</swipe-item>
  </swipe>
</template>

<script>
    export default {
        name: "Banner",
      data () {
        return {

          swiperOption:{
            direction:'vertical',
            speed:3000,
            autoplay:{
              delay:1,
              autoplayDisableOnInteraction:false
            },
            loop:false,
            spaceBetween:0,
            slidesPerView:8,
            allowTouchMove:false
          },
        }
      }
    }
</script>

<style>
  /*//注意:不要加scoped,会污染样式，导航的小圆点就不显示了*/
  @import 'vue-swipe/dist/vue-swipe.css';
  .my-swipe {
    float: none;
    margin: 0 auto;
    height: 500px;
    /*color: #fff;*/
    /*font-size: 30px;*/
    /*text-align: center;*/
  }

  .slide1 {
    background:url("/static/imgs/banner1.jpg") no-repeat ;
    background-size: 100% 100%;
  }

  .slide2 {
    background:url("/static/imgs/banner2.jpg") no-repeat ;
    background-size: 100% 100%;
  }

  .slide3 {
    background:url("/static/imgs/banner3.jpg") no-repeat ;
    background-size: 100% 100%;
  }
  .slide4 {
    background:url("/static/imgs/banner4.jpg") no-repeat ;
    background-size: 100% 100%;
  }
  @media screen and (max-width: 600px){
    .my-swipe{width: 100%;height:6rem}
  }
</style>
