<template>
  <div v-if="uploadType=='head'" class="avatar" :style="`width:${imgWidth};height:${imgHeight};`" >
    <div @mouseover="showBg=true" @mouseleave="showBg=false">
      <div class="bg" v-if="showBg" >点击上传</div>
      <input type="file" class="input-file" name="avatar" ref="avatarInput" @change="changeImage($event)" accept="image/gif,image/jpeg,image/jpg,image/png">
      <img :src="avatar?avatar:require('../../static/imgs/login-icon.png')" alt="" style="width: 100%;height: 80%" name="avatar">
    </div>
    <div class="text" @click="upload" v-if="file">确定上传</div>
  </div>
  <div v-else-if="uploadType=='img'" class="avatar mt-20"  >
    <div class="col-md-3 col-sm-3">
      <div id="selectimg">
        <input v-show="flag" type="file" class="input-file img-upload" name="avatar" ref="avatarInput"  @change="changeImage($event)" accept="image/gif,image/jpeg,image/jpg,image/png">
        <button class="btn btn-default btn-select-img"> 选择图片</button>
      </div>
    </div>
    <div class="col-md-4 col-sm-4">
      <div class="preview_img">
        <img :src="avatar?avatar:require('../../static/imgs/a.jpg')" :style="`width:${imgWidth};height:${imgHeight};`" alt="" name="avatar">
        <button class="btn btn-success btn-upload"  @click="upload" v-if="file">确定上传</button>
      </div>
    </div>
    <div class="col-md-5 col-sm-4">
      <span style="color: red;">只能上传一张图片，不上传则默认你的文章风景图。</span>
    </div>

  </div>
</template>

<script>
  export default {
    name: 'upload',
    data(){
      return{
        avatar: '',
        file: '',
        showBg: false,
        flag:true
      }
    },
    props: ["uploadType", "imgUrl", "imgWidth", "imgHeight"],
    created(){
      this.avatar = this.imgUrl
    },
    methods: {
      changeImage: function(e){
        let file = e.target.files[0];
        if(file) {
          this.file = file
          let reader = new FileReader()
          let that = this
          reader.readAsDataURL(file)
          reader.onload= function(e){
            // 这里的this 指向reader
            that.avatar = this.result
          }
        }
      },
      upload: function(){
        let files = this.$refs.avatarInput.files
        let fileData = {}
        if(files instanceof Array) {
          fileData = files[0]
        } else {
          fileData = this.file
        }
        // console.log('fileData', typeof fileData, fileData)
        let data = new FormData()
        data.append('file', fileData)
        data.append('operaType', this.uploadType)
        var self=this;
        self.$api.uploadFile("/article/upload-img",data,function (res) {
          layer.msg("图片上传成功！");
          self.file=false;//把确认上传按钮隐藏。
          self.flag=false;//不能选择图片
          self.$emit("upload", res.data );//把上传图片相对地址传递给父组件
        })
        // this.$store.dispatch('UPLOAD_HEAD', data)
        //   .then(res => {
        //     console.log(res)
        //     this.file = '';
        //     let data = res.data.data;
        //     this.$emit("upload", data );
        //     this.$message({
        //       type: "success",
        //       message: "上传成功！"
        //     })
        //   }).catch(err => {
        //   console.log(err)
        //   if(err.data.msg){
        //     this.$message({
        //       type: "error",
        //       message: err.data.msg
        //     })
        //   }else {
        //     this.$message({
        //       type: "error",
        //       message: "上传失败"
        //     })
        //   }
        // })
      }
    }
  }
</script>


<style lang="less"  scope>
  .avatar {
    cursor: pointer;
    position: relative;
    .input-file {
      width: 100%;
      height: 80%;
      position: absolute;
      top: 0;
      left: 0;
      opacity: 0;
      cursor: pointer;
      font-size: 0;
    }
    #selectimg{
      width: 100px;
      height:40px;
      position: relative;
      margin: 0 auto;
      /*float:left;*/
    }
    .preview_img{float: left}
    .img-upload{
      width: 100%;
      float: left;
    }
    .btn-upload{  display: block;margin: 10px auto 0 auto;}
    /*.btn-select-img{*/
      /*width: 100%;*/
      /*flaot:left;*/
    /*}*/
    .bg {
      width: 100%;
      height: 100%;
      color: #fff;
      background-color: rgba(0,0,0,0.3);
      text-align: center;
      cursor: pointer;
      position: absolute;
      padding-top: 20px;
      top: 0;
      left: 0;

    }
    .text {
      width: 100%;
      height: 20%;
      padding-top: 10px;
      color: lightblue;
    }
  }
  .mt-20{margin-top: 20px}
</style>
