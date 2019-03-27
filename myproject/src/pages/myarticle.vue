<template>
    <div id="article_page">
      <!--<navHeader></navHeader>-->
        <div class="row first_row1">
          <div class="form-group">
            <div class="col-md-3 col-sm-3 pd_t"><span>文章标题：</span><i style="color:red;">*</i></div>
            <div class="col-md-9 col-sm-9"><input type="text" class="form-control" v-model="article_title"></div>
          </div>
        </div>
        <div class="row first_row1">
          <upload :uploadType="'img'" imgWidth="180px" imgHeight="120px" @upload="getImgUrl"></upload>
        </div>
        <div class="row second_row">
          <div class="form-group">
            <div class="col-md-2 col-sm-3 pd_t"><span>文章内容：</span><i style="color:red;">*</i></div>
            <div class="col-md-10 col-sm-9">
              <div id="summernote"  ></div>
            </div>
          </div>
        </div>
      <div class="row">
        <button  @click="submit" class="btn btn-success">提交文章</button>
      </div>

    </div>
</template>

<script>
  // import header from '../components/publicHead'
  import upload from '../components/upload'
    export default {
      name: "article_page",
      components:{
        // navHeader:header,
        upload,
      },
      data(){
        return{
          article_title:'',
          article_img:''
        }
      },
      methods:{
        getImgUrl:function(data){
          this.article_img=data;
        },
        submit:function () {
          let content=$('#summernote').summernote('code');
          let author_id=JSON.parse(localStorage.getItem("user")).id;
          let self=this;
          console.log(this.article_img);
          debugger;
          let data={
            author_id:author_id,
            article_name:this.article_title,
            article_img:this.article_img,
            article_content:content,
          }
          self.$api.post("/article/add-article",data,function (res) {
            if(res.code==1)
            {
              layer.msg("成功发布文章！");
              self.$goRoute("/");
            }
            else {layer.msg("发布失败！")}
          })
        }
      },
      mounted() {
        $('#summernote').summernote({
          lang: 'zh-CN',
          placeholder: '请输入内容',
          height: 500,
          htmlMode: true,
          toolbar: [
            ['style', ['bold', 'italic', 'underline', 'clear']],
            ['fontsize', ['fontsize']],
            ['fontname', ['fontname']],
            ['color', ['color']],
            // ['para', ['ul', 'ol', 'paragraph']],
            // $('#summernote').summernote('justifyLeft');
            ['para', ['ul', 'ol', 'paragraph', 'lineheight']],//对齐方式
            ['insert', ['link', 'picture']],
            ['fullscreen',['fullscreen']], //全屏

            ['table',['table']], //插入表格
            ['hr',['hr']],//插入水平线
            ['video',['video']], //插入视频
          ],
          fontSizes: ['8', '9', '10', '11', '12', '14', '18', '24', '36'],
          fontNames: [
            'Arial', 'Arial Black', 'Comic Sans MS', 'Courier New',
            'Helvetica Neue', 'Helvetica', 'Impact', 'Lucida Grande',
            'Tahoma', 'Times New Roman', 'Verdana'
          ],
          callbacks: {
            onImageUpload: function(file) {  //图片默认以二进制的形式存储到数据库，调用此方法将请求后台将图片存储到服务器，返回图片请求地址到前端

              //将图片放入Formdate对象中
              var formData = new FormData();
              //‘picture’为后台获取的文件名，file[0]是要上传的文件
              formData.append("picture", file[0]);
              // $.ajax({
              //   type:'post',
              //   url:'请求后台地址',
              //   cache: false,
              //   data:formData,
              //   processData: false,
              //   contentType: false,
              //   dataType:'text', //请求成功后，后台返回图片访问地址字符串，故此以text格式获取，而不是json格式
              //   success: function(picture) {
              //     $('#summernote').summernote('insertImage',picture);
              //   },
              //   error:function(){
              //     alert("上传失败");
              //   }
              // });
            }
          }
        })
        $('#summernote').summernote('justifyLeft');
      }

    }
</script>

<style scoped>
  #article_page{
    width: 100%;
  }
  @media screen and (max-width: 1960px){
    .first_row1{
      width:60%;
      margin:20px auto 0 auto;
    }
    .second_row{
      width:70%;
      margin: 20px auto 0 auto;
    }
  }
  @media screen and (max-width: 1100px){
    .first_row1{
      width:80%;
      margin:20px auto 0 auto;
    }
    .second_row{
      width:86%;
      margin: 20px auto 0 auto;
    }
  }

  .pd_t{padding-top: 8px;}
</style>
