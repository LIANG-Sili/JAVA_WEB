<template>
	<ol>
	<el-divider></el-divider>
    <li v-for="post in posts">
		<router-link :to="'/post/'+post.pid">
    	{{post.pcontents}}
		</router-link>
<!-- 		{{getUser(post.pbelongUserID)}}
 -->		
		<span style="color:seagreen;">发帖ID : {{post.pbelongUserID}}</span>
		<span style="color:pink;">发帖时间:{{post.ptimes}}</span>
		<el-divider></el-divider>
    </li>
  </ol>
</template>

<script>
	export default {
	  name: 'postpage',
	  props:['posts'],
	  data(){
		return {
			// username:'',
		}
	  },
	  methods:{
		// getUser : function (id){
		// 	this.$axios.post(this.$store.state.portUrl+"user/getUserByUID",{UID:id}).then(res=>{
		// 		if(res.data.code === 0)
		// 		{
		// 			this.username = res.data.User.uname;
		// 		}
		// 	}).catch(err=>{
		// 		console.log(err);
		// 	});
		// },
	  },
	  created(){
		  // this.getAllPost();
	  }
	  
}
</script>

<style>
</style>
