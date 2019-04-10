<template>
    <div id="newGood">
      <div class="row oneline  col-md-10 col-sm-11">
        <div class="form-group col-md-6 col-sm-6">
          <div class="col-md-4 col-sm-4 pd_t"><span>商品名：</span><i style="color:red;">*</i></div>
          <div class="col-md-8 col-sm-8"><input type="text" class="form-control" v-model="good_name"></div>
        </div>
        <div class="form-group col-md-6 col-sm-6">
          <div class="col-md-4 col-sm-4 pd_t"><span>库存：</span><i style="color:red;">*</i></div>
          <div class="col-md-8 col-sm-8"><input type="number" class="form-control" v-model="stock"></div>
        </div>
      </div>
      <div class="row oneline col-lg-8 col-md-10 col-sm-11">
        <div class="form-group col-md-6 col-sm-6">
          <div class="col-md-4 col-sm-4 pd_t"><span>售价：</span><i style="color:red;">*</i></div>
          <div class="col-md-8 col-sm-8"><input type="text" class="form-control" v-model="good_price"></div>
        </div>
        <div class="form-group col-md-6 col-sm-6">
        </div>
      </div>
      <div class="row oneline col-lg-8 col-md-10 col-sm-11">
        <div class="col-md-2 col-sm-2 pd_t"><span>商品描述：</span><i style="color:red;">*</i></div>
        <div class="col-md-8 col-sm-8"><textarea class="form-control" v-model="goods_desc" rows="4"></textarea></div>
      </div>
      <div class="row oneline col-lg-8 col-md-10 col-sm-11">
        <div class="col-md-2 col-sm-2 pd_t" style="padding-top: 16px"><span>商品图片：</span><i style="color:red;">*</i></div>
        <div class="col-md-8 col-sm-8"><upload :uploadType="'img'" imgWidth="180px" imgHeight="120px" @upload="getImgUrl"></upload></div>
      </div>
      <div class="row" style="margin-top: 60px">
        <button  @click="submit" class="btn btn-success">上架新品</button>
      </div>

    </div>
</template>

<script>
  // import header from '../components/publicHead'
  import upload from '../components/upload'
    export default {
      name: "newGood",
      components:{
        upload,
      },
      data(){
        return{
          article_title:'',
          goods_img:'',
          good_name:'',
          stock:'',
          good_price:'',
          goods_desc:''
        }
      },
      methods:{
        getImgUrl:function(data){
          this.goods_img=data;
        },
        submit:function () {
          // let author_id=JSON.parse(localStorage.getItem("user")).id;
          let self=this;
          let data={
            goods_name:self.good_name,
            goods_desc:self.goods_desc,
            goods_img:self.goods_img,
            goods_price:self.good_price,
            stock:self.stock
          }
          self.$api.post("/goods/add-goods",data,function (res) {
            if(res.code==1)
            {
              layer.msg("成功添加！");
              self.$goRoute("/");
            }
            else {layer.msg("发布失败！")}
          })
        }
      },
      mounted() {
      }

    }
</script>

<style scoped>
.oneline{float: none;margin: 0 auto;}
  .pd_t{padding-top: 8px}
</style>
