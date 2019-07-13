// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import axios from 'axios'
import ElementUI from 'element-ui'
import store from './store'
import 'element-ui/lib/theme-chalk/index.css';

Vue.config.productionTip = false
Vue.use(ElementUI)
Vue.prototype.$axios = axios
Vue.prototype.$store = store

// router.beforeEach((to, from, next) => {
//   console.log('钩子触发')
//   console.log(store.state.UserInfo.toString() === '')
//   if(store.state.UserInfo.toString() === '') {
//     const userInfo = localStorage.getItem('userInfo')
//     if (userInfo) {
//       store.state.UserInfo = JSON.parse(userInfo)
//     } else {
//       console.log('未登录')
//     }
//   }
//   next()
// })

new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
