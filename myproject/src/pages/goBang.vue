<template>
    <div id="goBang">
      <div class="chessboard">
        <table>
          <tr v-for="x in 15">
            <td v-for="y in 15"></td>
          </tr>
        </table>
      </div>
    </div>
</template>

<script>
    export default {
      name: "goBang",
      data(){
        return{

        }
      },
      mounted:function () {
        let self=this;
        document.getElementsByTagName("table")[0].onclick=function (ev) {
          self.playChess(ev.srcElement);
        }
      },
      methods: {
        playChess: function (dom) {
            let color="";
            debugger;
            //判断该td有没有背景图片
            if(dom.style.background.indexOf("black")>0||dom.style.background.indexOf("white")>0){
              layer.alert("不能在同一位置下棋！");return false;
            }
            else
              dom.style.background="../../static/imgs/"+color+".png";
        }
      }
    }
</script>

<style scoped>
  .chessboard{
    width: 600px;
    height: 600px;
    margin: 0 auto;
    padding-top:6px;
    padding-left:6px;
    border: none;
    background: url("../../static/imgs/chessboard.jpg") no-repeat;
    background-size:100% 100%;
  }
  .chessboard table{
    width: 100%;
    height: 100%;
  }
.chessboard tr td{border: none;cursor: pointer}
</style>
