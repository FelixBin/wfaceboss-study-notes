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




