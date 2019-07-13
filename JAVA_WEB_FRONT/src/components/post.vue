<template>
	<el-card class="box-card">
  <div slot="header" class="clearfix">
    <span>{{post.pcontents}}</span>
    <el-button v-show="$store.state.UserInfo !== ''" @click="dialogVisible = true" type="primary" icon="el-icon-edit" circle></el-button>
			<el-dialog
	  title="回帖!"
	  :visible.sync="dialogVisible"
	  width="30%"
	  :before-close="closeDialog">
	  <el-input
	  type="textarea"
	  :autosize="{ minRows: 2, maxRows: 4}"
	  placeholder="请输入内容"
	  v-model="pcontents">
	</el-input>
	  <span slot="footer" class="dialog-footer">
	    <el-button @click="closeDialog">取 消</el-button>
	    <el-button type="primary" @click="addComments">回 帖</el-button>
	  </span>
	  </el-dialog>
	  <!-- <el-button type="warning" icon="el-icon-star-off" circle @click="addCollection"></el-button> -->
	<!-- <el-button type="warning" icon="el-icon-star-off" circle></el-button> -->
  </div>
  
  <div v-for="comment in comments" class="text item">
    <h1>{{comment.pcontents}}</h1>
			{{getUser(comment.pbelongUserID)}}
	回帖人 : {{username}}
	回帖时间 : {{comment.ptimes}}
	
  </div>
</el-card>
</template>

<script>
	export default{
		name:"post",
		data(){
			return{
				PID:this.$route.params.id,
				post:"",
				comments:"",
				dialogVisible: false,
				username:'',
				pcontents:'',
				canDel:false,
				visible:false,
			}
		},
		created() {
			this.$axios.post(this.$store.state.portUrl+"post/getPost",{PID:this.PID}).then(res=>{
				if(res.data.code === 0)
				{
					this.$axios.post(this.$store.state.portUrl+"post/checkCanDel",{UName:this.$store.state.UserInfo.uname,PID:this.PID}).then(res=>{
						this.canDel = res.data.code;
					});
					console.log(res.data.Post);
					this.post = res.data.Post;
					this.getComments(this.PID);
				}
				else
				{
					// 404界面
				}
			}).catch(err=>{
				console.log(err);
			})
		},
		methods:{
			closeDialog:function(e){
				this.pcontents = '';
				this.dialogVisible = false;
			},
			getUser : function (id){
				this.$axios.post(this.$store.state.portUrl+"user/getUserByUID",{UID:id}).then(res=>{
					if(res.data.code === 0)
					{
						this.username = res.data.User.uname;
					}
				}).catch(err=>{
					console.log(err);
				});
			},
			addComments : function(e){
				this.$axios.post(this.$store.state.portUrl+"post/addPost",{PUserName:this.$store.state.UserInfo.uname,PBelongPostID:parseInt(this.PID),PContents:this.pcontents,PType:1}).then(res=>{
					this.dialogVisible = false;
					if(res.data.code === 0)
					{
						this.getComments(this.PID);
						 this.$message({
							type: 'success',
							message: '回贴成功!'
						  });
					}
					else
					{
						this.$message.error('回贴失败...');
					}
				}).catch(err=>{
					console.log(err);
				}).catch(err=>{
				console.log(err);
			});
			},
			// addCollection(e){
			// 	this.$axios.post(this.$store.state.portUrl+"post/addPost",{PUserName:this.$store.state.UserInfo.uname,PBelongPostID:parseInt(this.PID),PContents:this.pcontents,PType:1}).then(res=>{
			// 			this.dialogVisible = false;
			// 			if(res.data.code === 0)
			// 			{
			// 				this.getComments(this.PID);
			// 				 this.$message({
			// 					type: 'success',
			// 					message: '回贴成功!'
			// 				  });
			// 			}
			// 			else
			// 			{
			// 				this.$message.error('回贴失败...');
			// 			}
			// 		}).catch(err=>{
			// 			console.log(err);
			// 		}).catch(err=>{
			// 		console.log(err);
			// 	});
			// 	
			// },
			getComments:function(id){
				this.$axios.post(this.$store.state.portUrl+"post/selectPostReplyAll",{PID:this.PID}).then(res=>{
					if(res.data.code === 0)
					{
						this.comments = res.data.List;
					}
				}).catch(err=>{
				console.log(err);
			})
			},
			delComments:function(e){
				
		},
		
	}
}
</script>

<style>
	 .text {
    font-size: 14px;
  }

  .item {
    padding: 18px 0;
  }

  .box-card {
    width: 480px;
  }
</style>
