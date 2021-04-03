<template>
  <div >
    <el-menu :router="true" mode="horizontal">
      <!--基座可以放自己的路由-->
      <el-menu-item index="/">首页</el-menu-item>
      <!--引用其他子应用-->
      <el-menu-item index="/vue">vue子应用</el-menu-item>
      <el-menu-item index="/react">react子应用</el-menu-item>
    </el-menu>
    <router-view v-show="$route.name"></router-view>
    <div v-show="!$route.name" id="vue"></div>
    <div v-show="!$route.name" id="react"></div>
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
