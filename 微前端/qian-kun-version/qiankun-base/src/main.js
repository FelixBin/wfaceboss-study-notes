// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'

import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';

Vue.use(ElementUI);

import {registerMicroApps, start} from "qiankun"

Vue.config.productionTip = false

const apps = [
  {
    name: 'qiankun-vue',//应用名称
    entry: 'http://localhost:10000',//默认会加载这个html 解析里面的js 动态执行（子应用必须支持跨域）
    container: '#vue',//容器名
    activeRule: '/vue',//激活的路径
    props:{a:1}
  },
  {
    name: 'reactApp',
    entry: 'http://localhost:20000',
    container: '#react',
    activeRule: '/react'
  }
]
registerMicroApps(apps);//注册应用
start();//开启


/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  render: h => h(App)
}).$mount("#app")
