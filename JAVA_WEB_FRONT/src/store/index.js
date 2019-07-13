import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

/** 状态定义 */
export const state = {
	portUrl : "http://47.102.220.25:8080/JAVA_WEB/",
	// portUrl : "http://localhost:8080/JAVA_WEB_Web_exploded/",
	UserInfo:'',
	hasUserInfo:false,
	isLogin:false,
	PID:0,
}

export default new Vuex.Store({
    state,
})
