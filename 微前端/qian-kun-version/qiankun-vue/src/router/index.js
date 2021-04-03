import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/components/Home'

Vue.use(Router)


export default new Router({
  mode: 'history',
  base: '/vue',
  routes: [
    {
      path: '/',
      name: 'Home',
      component: Home
    }
  ]
})
