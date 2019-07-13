<template>
	<ol>
	<el-divider></el-divider>
    <li v-for="post in posts">
		<router-link :to="'/post/'+post.pid">
    	{{post.pcontents}}
		</router-link>
		
		<span style="color:gold;">发帖时间:{{post.ptimes}}</span>
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
		}
	  },
	  methods:{
		
	  },
	  created(){
		  // this.getAllPost();
	  }
	  
}
</script>

<style>
</style>
