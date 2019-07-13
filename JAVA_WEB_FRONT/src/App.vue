<template>
  <div>
    <el-menu
      :default-active="'1'"
      mode="horizontal"
    >
      <el-menu-item index="1"><router-link to="/">首页</router-link></el-menu-item>
      <el-menu-item index="2" v-if="$store.state.UserInfo.toString() !== ''"><router-link to="/account">个人中心</router-link></el-menu-item>
			<el-menu-item index="3" v-if="$store.state.isLogin === true"><el-button type="danger" @click='logout' router-link to="/"  icon="el-icon-delete" circle></el-button></el-menu-item>
			
		</el-menu>
    <div id="app">
      <router-view />
    </div>
  </div>
</template>

<script>
import Home from "./components/home.vue";

export default {
  name: "App",
  data() {
    return {
    };
  },
  components: {
		Home,
	},
	methods:{
		logout: function(e) {
			this.$store.state.isLogin = false;
			this.$store.state.hasUserInfo = false;
			this.$store.state.UserInfo = '';
		},
	}
};
</script>

<style>
#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: left;
  color: #2c3e50;
  padding: 0;
  width: 80%;
  margin: 3em 10%;
}
#user {
  width: 2em;
  height: 2em;
  border-radius: 50%;
}
html, body {
  margin: 0;
  height: 0;
  width: 100%;
}
a {
  text-decoration: none;
}
</style>
