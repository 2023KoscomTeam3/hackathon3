import Vue from "vue";
import VueRouter from "vue-router"
import Home from './views/Home';
import About from './views/About';
import Login from './views/LoginPage';

Vue.use(VueRouter);

const router = new VueRouter({
    mode : 'history',
    routes : [
        {
            path:'/home', 
            component: Home
        },
        {
            path:'/about', 
            component: About
        },
        {
            path:'/login',
            component: Login 
        }
    ]
});

export default router;