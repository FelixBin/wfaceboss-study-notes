import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/components/Home'
import About from '@/components/About'

Vue.use(Router)


const routes =
    [
        {
            path: '/',
            name: 'Home',
            component: Home

        }, {
        path: '/about',
        name: 'About',
        component: About

    },
    ]

const router = new Router({
    mode: 'history',
    base: '/vue',
    routes
})


export default router