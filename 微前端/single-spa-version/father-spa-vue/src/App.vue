<template>
  <div id="app">
    <router-link to="/vue">加载vue应用</router-link>

    <!--子应用加载的位置，名称vue与之前子应用定义的el值一致-->
    <div id="vue"></div>
  </div>
</template>

<script>

export default {
  name: 'App',
  components: {}
}
</script>

<style>

</style>
