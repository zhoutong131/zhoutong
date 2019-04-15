<template>
    <div id="goBang">
      <div class="chessboard">
        <table>
          <tr v-for="x in 15">
            <td v-for="y in 15"></td>
          </tr>
        </table>
      </div>
      <div class="control-panel">
        <button class="btn btn-default" @click="agin()">再来一局</button>
      </div>
    </div>
</template>

<script>
    export default {
      name: "goBang",
      data(){
        return{
          chessColor:'black',
          iswin:false
        }
      },
      mounted:function () {
        let self=this;
        let ifDrag=true,dom=document.getElementsByTagName("table")[0];
        dom.addEventListener("mousedown", function () {
          ifDrag = true;
        })
        dom.addEventListener("mousemove", function () {
          ifDrag = false;
        })
        dom.addEventListener("mouseup", function (ev) {
          //判断是否有拖拽动作
          if (ifDrag) {
            //add marker
            self.playChess(ev.srcElement);
          }
          else {
            //
          }
        })
      },
      methods: {
        agin:function(){
          let doms=document.getElementsByTagName("td");
          for(let i=0;i<doms.length;i++){
            doms[i].style.background="";
          };
          this.iswin=false;
        },
        changeColor:function(){
          let nextColor=self.chessColor;
          if(self.chessColor=='black')
            self.chessColor='white';
          else
            self.chessColor='black';
          return nextColor;
        },
        playChess: function (dom) {
          // alert(color);
          if(this.iswin)
          {
            layer.alert("游戏已经结束！");
            return false;
          }
          //判断该td有没有背景图片
          if(dom.style.background.indexOf("black")>0||dom.style.background.indexOf("white")>0){
            layer.alert("不能在同一位置下棋！");return false;
          }
          else{
            let color=this.changeColor();//判断下一颗棋子的颜色
            // dom.style.background="url(../../static/imgs/"+color+".png) no-repeat center";
            dom.setAttribute('style',"background:url(../../static/imgs/"+color+".png) no-repeat center;background-size:contain;")
          }
          this.judge(dom);
            //判断有没有赢
        },
        judge:function (mydom) {
          let tds=document.getElementsByTagName("td");
          let line=['','','',''],//四个方向
          thisChess={
            x: mydom.cellIndex,
            y: mydom.parentElement.rowIndex,
            color: '0'
          };//当前棋子的颜色。
          for(let i=0;i<225;i++){
           let tmp = {
              x: tds[i].cellIndex,
              y: tds[i].parentElement.rowIndex,
              color: '0'
            };
            //判断循环的棋子的颜色
            if (tds[i].style.background.indexOf('black') >= 0) {
              tmp.color = 'b';
            } else if (tds[i].style.background.indexOf('white') >= 0) {
              tmp.color = 'w';
            }
            if(tmp.x==thisChess.x){
              line[0]+=tmp.color;//纵向上的颜色
            }
            if(tmp.y==thisChess.y){
              line[1]+=tmp.color;//横向棋子颜色
            }
            if((thisChess.x+thisChess.y)==(tmp.x+tmp.y)){
              line[2]+=tmp.color;//左斜线上的颜色
            }
            if((thisChess.x-tmp.x) == (thisChess.y-tmp.y)){
              line[3]+=tmp.color;//右斜线上的颜色
            }
          }

          let wincolor='';
          for(let i=0;i<4;i++){
            if(line[i].indexOf('bbbbb')>0){
              wincolor='b';
              this.iswin=true;
            }
            if(line[i].indexOf('wwwww')>0){
              wincolor='w';
              this.iswin=true;
            }
          }
          if(wincolor=='b'){
            layer.alert("黑色胜了！");
            return false;
          }
          else if(wincolor=='w'){
            layer.alert("白色胜了!");
            return false;
          }
          else return true;
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
  .control-panel{
    width: 600px;
    margin: 0 auto;
    border: 1px dashed #000;
  }
  .chessboard table{
    width: 100%;
    height: 100%;
  }
.chessboard tr td{border: none;cursor: pointer}
  @media screen and (max-width: 600px){
    .chessboard{
      width: 10rem;
      height: 10rem;
      padding-top:0.2rem;
      padding-left:0.2rem;
      border: none;
      background: url("../../static/imgs/chessboard.jpg") no-repeat;
      background-size:100% 100%;
    }
    .control-panel{
      width: 10rem;
      border: 0.02rem dashed #000;
    }
  }
</style>
