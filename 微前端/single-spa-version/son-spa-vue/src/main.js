import Vue from 'vue'
import App from './App.vue'
import singlespaVue from 'single-spa-vue'
import router from './router'

Vue.config.productionTip = false


const appOptions = {
    el: '#vue',//挂载到父应用中的id为vue的标签中
    router,
    render: h => h(App)
}


//vueLifeCycle(包装后的生命周期)对应这三个方法botstrap mount unmount
const vueLifeCycle = singlespaVue({
    Vue,
    appOptions
})


//协议接入，子应用定义好协议，父应用调用这些方法
export const bootstrap = vueLifeCycle.bootstrap()
export const mount = vueLifeCycle.mount
export const unmount = vueLifeCycle.unmount
