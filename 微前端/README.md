#一、为什么需要微前端?
##1.What?什么是微前端?
![img.png](img/img.png)
微前端就是将不同的功能按照不同的维度拆分成多个子应用。通过主应用来加载这些子应用

微前端的核心在于**拆**, 拆完后再**合**!

##2、why?为什么去使用他?
- 不同团队间开发同一个应用技术栈不同怎么破？
- 希望每个团队都可以独立开发，独立部署怎么破？
- 项目中还需要老的应用代码怎么破？

们是不是可以将一个应用划分成若干个子应用，再将子应用打包成一个个的lib呢？当路径切换时加载不同的子应用，这样每个子应用都是独立的，技术栈也就不用再做限制了！从而解决了前端协同开发的问题。

##3、How?怎样落地微前端?
![img_1.png](img/img_1.png)

Single-spa诞生于2018年，是一个用于前端微服务化的JavaScript前端解决方案  (本身没有处理样式隔离、js执行隔离)  实现了路由劫持和应用加载；
019年 qiankun基于Single-spa, 提供了更加开箱即用的 API  （single-spa + sandbox + import-html-entry），它 做到了技术栈无关，并且接入简单

>子应用可以独立构建，运行时动态加载，主子应用完全解耦，并且技术栈无关，靠的是协议接入（这里提前强调一下：子应用必须导出 bootstrap、mount、unmount三个方法）

###应用间如何通信？

- 基于URL来进行数据传递，但是这种传递消息的方式能力较弱；

- 基于CustomEvent实现通信；

- 基于props主子应用间通信；

- 使用全局变量、Redux进行通信。

###如何处理公共依赖？

- CDN - externals
- webpack联邦模块

#四、实战

# single-spa实战
## 1 创建两个项目并安装single-spa：

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

//(子应用模式)vueLifeCycle(包装后的生命周期)对应这三个方法botstrap mount unmount
const vueLifeCycle = singlespaVue({
    Vue,
    appOptions
})

// （非子应用模式）在非子应用中正常挂载应用
if(!window.singleSpaNavigate){
    delete appOptions.el;
    new Vue(appOptions).$mount('#app');
}

//如果是父应用引用我
// if(window.singleSpaNavigate){
//     __webpack_public_path__ = 'http://localhost:10000/'
// }


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
  

#qiankun实战
新建`qian-kun-version`目录，然后在该目录下分别创建`qiankun-base`、`qiankun-vue`、`qiankun-react`项目。

打开控制台，cd 到`qian-kun-version`目录下，分别:

- 创建`qiankun-base`

```
vue create qiankun-base
```

- 创建`qiankun-vue`

```
vue create qiankun-vue
```

- 创建`qiankun-react`

```
npm install -g create-react-app
```


```
create-react-app qiankun-react
```

##主应用编写

- 安装element ui

```
npm i element-ui -S
```

- 安装qiankun
```angular2html
npm i qiankun -S

```

- App.vue文件
```
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


```
- main.js文件(注册子应用)
```
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
    name: 'qiankun-react',
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

```

## vue子应用

- main.js文件
```
// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import './public-path';
import Vue from 'vue'
import App from './App'
import router from './router'

Vue.config.productionTip = false

let instance = null;

function render() {
    instance = new Vue({
        router,
        render: h => h(App)
    }).$mount('#app')//这里是挂载到自己的html中 基座会拿到这个挂载后的html 将其插入进去
}


//独立运行微应用
if (!window.__POWERED_BY_QIANKUN__) {
    render();
}


//子组件的协议
export async function bootstrap() {
}

export async function mount(props) {//挂载时渲染
    render(props);
}

export async function unmount() {//卸载应用
    instance.$destroy();
    instance = null;
}

```

- 在 src 目录新增 public-path.js

```
if (window.__POWERED_BY_QIANKUN__) {
    // eslint-disable-next-line no-undef
    __webpack_public_path__ = window.__INJECTED_PUBLIC_PATH_BY_QIANKUN__;
}

```

- 打包配置修改（`vue.config.js`）

该应用根目录新建`vue.config.js`

```
// 配置将子应用打包成一个个的lib去给父应用使用

module.exports={
    devServer:{
        port:10000,
        headers:{
            'Access-Control-Allow-Origin':'*'//允许访问跨域
        }
    },
    configureWebpack:{
        output:{
            library:'qiankun-vue',
            libraryTarget:'umd'
        }
    }
}

```

## react子应用

- `index.js`文件

```
import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';


function render() {
    ReactDOM.render(
        <React.StrictMode>
            <App/>
        </React.StrictMode>,
        document.getElementById('root')
    );
}

if (!window.__POWERED_BY_QIANKUN__) {
    render()
}

export async function bootstrap() {
}

export async function mount() {
    render();
}

export async function unmount() {
    ReactDOM.unmountComponentAtNode(document.getElementById("root"));
}



```

- 在 `src` 目录新增 `public-path.js`：

```
if (window.__POWERED_BY_QIANKUN__) {
  __webpack_public_path__ = window.__INJECTED_PUBLIC_PATH_BY_QIANKUN__;
}

```

- 修改 `webpack` 配置

安装插件 `@rescripts/cli`，当然也可以选择其他的插件，例如 `react-app-rewired`

```
npm i -D @rescripts/cli
```

根目录新增 `.rescriptsrc.js`

```
const { name } = require('./package');

module.exports = {
  webpack: config => {
    config.output.library = `${name}-[name]`;
    config.output.libraryTarget = 'umd';
    config.output.jsonpFunction = `webpackJsonp_${name}`;
    config.output.globalObject = 'window';

    return config;
  },

  devServer: _ => {
    const config = _;

    config.headers = {
      'Access-Control-Allow-Origin': '*',
    };
    config.historyApiFallback = true;
    config.hot = false;
    config.watchContentBase = false;
    config.liveReload = false;

    return config;
  },
};

```

- 修改 `package.json`：

```
 "start": "rescripts start",
"build": "rescripts build",
"test": "rescripts test",
```








  




