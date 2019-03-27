<template>
  <div id="app">
    <pubHead></pubHead>
    <router-view/>
  </div>
</template>

<script>
  import pubHead from './components/publicHead'
export default {
  name: 'App',
  components:{pubHead}
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
</style>
