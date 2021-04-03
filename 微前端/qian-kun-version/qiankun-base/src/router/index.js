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
    routes
})


export default router