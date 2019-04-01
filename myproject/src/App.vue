<template>
  <div id="app">
    <pubHead></pubHead>
    <router-view v-if="isRouterAlive"/>
  </div>
</template>

<script>
  import pubHead from './components/publicHead'
export default {
  name: 'App',
  components:{pubHead},
  provide () {
    return {
      reload: this.reload
    }
  },
  data () {
    return {
      isRouterAlive: true
    }
  },
  methods: {
    reload () {
      this.isRouterAlive = false
      this.$nextTick(function () {
        this.isRouterAlive = true
      })
    }
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  /*margin-top: 60px;*/
}
html {
  height: 100%;
}
body {
  min-height: 100%;
}
</style>
