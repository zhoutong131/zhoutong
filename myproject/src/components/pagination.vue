<template>
  <nav>
    <div class="blank"></div>
    <ul class="pagination">
      <li :class="{'disabled': current == 1}"><a href="javascript:;" @click="setCurrent(current - 1)"> « </a></li>
      <li :class="{'disabled': current == 1}"><a href="javascript:;" @click="setCurrent(1)"> 首页 </a></li>
      <li v-for="p in grouplist" :class="{'active': current == p.val}"><a href="javascript:;"
                                                                          @click="setCurrent(p.val)"> {{ p.text }} </a>
      </li>
      <li></li>
      <li :class="{'disabled': current == page}"><input type="number" :placeholder="'共'+page+'页'" class="form-control topage" v-model="topage"><a href="javascript:;" @click="setCurrent(Number(topage))"> Go </a></li>
      <li :class="{'disabled': current == page}"><a href="javascript:;" @click="setCurrent(page)"> 尾页 </a></li>
      <li :class="{'disabled': current == page}"><a href="javascript:;" @click="setCurrent(current + 1)"> »</a></li>
    </ul>
  </nav>
</template>

<script>
    export default {
        name: "pagination",
      data(){
          return{
            current:this.currentPage,
            topage:''
          }
      },
      props:{
        total: {// 数据总条数
          type: Number,
          default: 0
        },
        display: {// 每页显示条数
          type: Number,
          default: 10
        },
        currentPage: {// 当前页码
          type: Number,
          default: 1
        },
        pagegroup: {// 分页条数
          type: Number,
          default: 5,
          coerce: function (v) {
            v = v > 0 ? v : 5;
            return v % 2 === 1 ? v : v + 1;
          }
        }
      },
      computed: {
        page: function () { // 总页数
          return Math.ceil(this.total / this.display);
          // 返回大于等于参数x的最小整数,即对浮点数向上取整
        },
        grouplist: function () { // 获取分页页码
          var len = this.page, temp = [], list = [], count = Math.floor(this.pagegroup / 2), center = this.current;
          if (len <= this.pagegroup) {
            while (len--) {
              temp.push({text: this.page - len, val: this.page - len});
            };
            return temp;
          }
          while (len--) {
            temp.push(this.page - len);
          };
          var idx = temp.indexOf(center);
          (idx < count) && ( center = center + count - idx);
          (this.current > this.page - count) && ( center = this.page - count);
          temp = temp.splice(center - count - 1, this.pagegroup);
          do {
            var t = temp.shift();
            list.push({
              text: t,
              val: t
            });
          } while (temp.length);
          if (this.page > this.pagegroup) {
            (this.current > count + 1) && list.unshift({text: '...', val: list[0].val - 1});
            (this.current < this.page - count) && list.push({text: '...', val: list[list.length - 1].val + 1});
          }
          return list;
        }
      },
      methods: {
        setCurrent: function (idx) {
          if (this.current != idx && idx > 0 && idx < this.page + 1) {
            this.current = idx;
            this.$emit('pagechange', this.current);//子组件向父组件pagechange传递参数当前要跳转的页码
          }
          this.topage='';
        }
      }
    }
</script>

<style lang="less">
  /*.blank{*/
    /*height: 80px;*/
  /*}*/
  .pagination {
    /**/
    overflow: hidden;
    display: table;
    /*margin: 0 auto;*/
    /*width: 100%;*/
    height: 50px;

  li {
    float: left;
    /*height: 30px;*/
    border-radius: 5px;
    margin: 3px;
    color: #666 !important;
  &
  :hover {
    background: #000 !important;color: #fff !important;

  a {
    color: #fff !important;
  }
  }
  a {
    display: block;
    width: 40px;
    height: 34px;
    text-align: center;
    line-height: 34px;
    font-size: 14px;
    border-radius: 5px;
    text-decoration: none;
    background: none;
    color:#000;
    padding: 0 !important;
  }
    .topage{
      display: block;
      float: left;
      width: 100px;
      height: 34px;
      margin-right: 10px;
      border-radius: 5px;
      background: none !important;
      outline: none;
      color: #000 !important;
    }
  }
  .active {
    background: #000 !important;

  a {
    color: #fff !important;
    background: none !important;
    border-color: #000 !important;
  }

  }
  }
</style>
