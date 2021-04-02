# 一、single-spa
##1 创建两个项目并安装single-spa：

- son-spa-vue 

```
vue create son-spa-vue 
```

```
npm install single-spa-vue
```

- father-spa-vue

```
vue create father-spa-vue
```

```
npm install single-spa
```



2.子应用操作

App.vue文件
```app.vue文件

<template>
  <div id="app">
    <router-view/>
  </div>
</template>

<script>

export default {
  name: 'App',
  components: {
    
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>

```


main.js

```
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
export const bootstrap = vueLifeCycle.bootstrap
export const mount = vueLifeCycle.mount
export const unmount = vueLifeCycle.unmount
export default vueLifeCycle;

```

3.将子应用打包成一个个的lib去给父应用使用

每个子应用根目录新建vue.config.js文件

```
// 配置将子应用打包成一个个的lib去给父应用使用

module.exports = {
    configureWebpack: {
        output: {
            library: 'singleVue',
            libraryTarget: 'umd'//umd模块作用，window.singleVue.bootstrap/mount/unmount，将这些挂在window上
        },
        devServer: {
            port: 10000
        }
    }
}
```

4. 路由

若安装无默认安装路由，需自己安装

- 安装

```
npm install vue-router  --save-dev 
```

- src 目录下 新建 router 目录，目录下新建 index.js
  
```
import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/components/Home'

Vue.use(Router)


const routes =
[
{
path: '/',
name: 'Home',
component: Home

        }
    ]

const router = new Router({
mode: 'history',
base: '/vue',
routes
})


export default router 
  ```

  

- 在main.js中导入

```
import router from './router'
```


- 组件创建

  在components目录下新建组件

  ```
  <template>
    <div>
     <div>
       Home页面
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
  
  ```

- 在router下的index.js文件中导入组件

```
import Home from '@/components/Home'
```

- 使用
  启动子应用
  启动父应用



