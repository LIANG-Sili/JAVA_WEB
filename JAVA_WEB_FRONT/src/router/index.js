import Vue from 'vue'
import Router from 'vue-router'
import home from '@/components/home'
import post from '@/components/post'
import account from '@/components/account'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'home',
      component: home
    },
		// {
		// 	path:'/',
		// 	name:'login',
		// 	component:login,
		// }
		{
			path:'/post/:id',
			name:'post',
			component:post
    },
    {
      path: '/account',
      name: 'account',
      component: account
    }
  ]
})
