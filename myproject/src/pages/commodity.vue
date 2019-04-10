<template>
    <div id="goods" class=" col-md-10 col-sm-11">
      <i class="icon-search fa fa-search"></i><input type="text" class="search form-control" @keyup.enter="search" v-model="keyword" placeholder="请输入商品名称或者描述"><button @click="search" class="mr-20 btn btn-default"> 查找</button>
      <div class="line-style"></div>
      <div class="row max-hei">
        <div v-for="good in goods"  class="goods-item col-lg-3 col-md-5 col-sm-5">
          <img @click="toDetail(good)" :src="$api.root+good.goods_img" />
          <div class="goods-head">
            <span class="price"><i class="fa fa-cny"></i>{{good.goods_price}}</span><span class="right-stock">库存：{{good.stock}}</span>
          </div>
          <a class="goods-name" @click="toDetail(good)">{{good.goods_name}}</a>
        </div>
      </div>
      <pagination :total="total" :display="pageSize" :current-page='current' @pagechange="pagechange"></pagination>
    </div>
</template>

<script>
  import pagination from '../components/pagination';
    export default {
      name: "commodity",
      data(){
        return{
          total:4,
          current:1,
          pageSize:6,
          goods:[],
          keyword:''
        }
      },
      components:{pagination},
      methods:{
        toDetail:function(good){
          this.$router.push({name:'goodDetail', params: good})
        },
        search:function(){
          this.pagechange(1);
        },
        pagechange:function (current1) {
          let self=this;
          let config={
            pageNo:current1+"",
            pageSize: self.pageSize+"",
            keyword:self.keyword
          }
          this.$api.post('/goods/list',config,function (res) {
            if(res.code!=1){
              layer.msg("无商品展示！")
            }
            else{
              self.goods=res.data.list;
            }
          });
        }
      },
      created() {
        let self=this;
        let config={
          pageNo:'1',
          pageSize: self.pageSize+""
        }
        this.$api.post('/goods/list',config,function (res) {
          if(res.code!=1){
            layer.msg("无商品展示！")
          }
          else{
            if(res.code!=1){
              layer.msg("无商品展示！")
            }
            else{
              self.goods=res.data.list;
              self.total=res.data.total;
            }
          }
        });
      }
    }
</script>

<style scoped>
  .max-hei{
    min-height: 710px;
  }
#goods{
  float: none;
  margin: 0 auto;
  text-align: left;
  position: relative;
}
.goods-head{margin-top: 10px;}
.price{margin:10px;font-size: 20px;color:#00aeef;font-weight: bold}
.right-stock{float:right;padding-top: 4px;}
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
    width: 320px;
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
    font-size:18px;
    text-align: center;
    color:#00aeef;
    margin-top: 10px;
    overflow: hidden;
    text-overflow:ellipsis;
    display: -webkit-box;
    /*! autoprefixer: off */
    -webkit-box-orient: vertical;
    /* autoprefixer: on */
    -webkit-line-clamp: 2;
  }

</style>
