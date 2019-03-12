<template>
  <div id="emtion">
    <navHeader></navHeader>
    <div id="content">
      <div class="container-fluid">
        <ul class="col-sm-12 col-xs-12">
          <li class="co-sm-2 col-xs-4"><a></a></li>
        </ul>
      </div>
    </div>
  </div>

</template>

<script>
  import api from "../assets/js/api";
  import header from '../components/publicHead'
    export default {
        name: "Emoticon",
        components:{
        navHeader:header
      },
      data(){
          return{
            typeList:[]
          }
      },
      methods:{
          getTypeList:function () {

          }
      },
      beforeCreate:function () {
        var _this=this;
        var data={
          pageNo:1,
          pageSize:10
        };
        api.post("/emotion-type/list",data,function (result) {
          if(result.code==1){
            debugger;
            _this.typeList=result.data.list;
          }
          else
            layer.alert("无分类信息！",{
              title:'查询',
              icon:5
            });
        });
      }
    }

</script>

<style scoped>

</style>
