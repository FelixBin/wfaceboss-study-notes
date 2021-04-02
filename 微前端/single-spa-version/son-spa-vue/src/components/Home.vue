<template>
  <div>
    <div>
     <div>
       我是Home页面
     </div>
      <div>
        <router-link to="/about">我是about页面</router-link>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'Home',
  props: {
    msg: String
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
