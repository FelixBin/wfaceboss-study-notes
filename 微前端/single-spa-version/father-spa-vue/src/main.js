import Vue from 'vue'
import App from './App.vue'
import {registerApplication, start} from 'single-spa'

import router from './router'


Vue.config.productionTip = false

// async function loadScript(url) {
//     return new Promise((resolve, reject) => {
//         let script = document.createElement('script');
//         script.srC = url;
//         script.onload = resolve;
//         script.onerror = reject;
//         document.head.appendChild(script);
//     })
// }

registerApplication('myVueApp', async () => {
        console.log("加载模块")

    },
    //用户切换到/vue的路径下，我需要加载刚才定义的async内容
    location => location.pathname.startsWith('/vue'),
)
start(); //开启运用

new Vue({
    router,
    render: h => h(App)
}).$mount('#app')
