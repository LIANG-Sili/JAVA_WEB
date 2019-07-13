<template>
  <el-tabs type="border-card">
		 <el-tab-pane label="我的资料">
			 <h2>
			       <el-card>
			     用户名:{{myInfo.puserName}}
			     <div class="clear"></div>
					 </el-card>
					  <el-card>
					 个人简介:{{myInfo.pstatement}}
					 <el-button type="primary" icon="el-icon-edit" circle @click="editStatement"></el-button>
					 <div class="clear"></div>
					 </el-card>
					  <el-card>
					 个人邮箱:{{myInfo.pemail}}
					 <el-button type="primary" icon="el-icon-edit" circle @click="editEmail"></el-button>
					 <div class="clear"></div>
			   </el-card>
			 </h2>
			  </el-tab-pane>
    <el-tab-pane label="我的贴子">
      <el-card v-for="o in myPost" :key="o">
        {{o.ptimes}} : {{o.pcontents}}
        <el-button type="danger" icon="el-icon-delete" @click="del(o.pid)" circle class="button" ></el-button>
        <div class="clear"></div>
      </el-card>
    </el-tab-pane>
    <el-tab-pane label="我的回复">
			<el-card v-for="o in myReply" :key="o">
        {{o.ptimes}} : {{o.pcontents}}
        <el-button type="danger" icon="el-icon-delete" @click="del(o.pid)" circle class="button"></el-button>
        <div class="clear"></div>
      </el-card>
			</el-tab-pane>
  </el-tabs>
</template>
<script>
export default {
  name: "account",
  data() {
    return {
      myPost: [],
      myReply: [],
      myInfo: []
    };
  },
	methods:{
		editStatement() {
        this.$prompt('请输入更改个人简介', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
        }).then(({ value }) => {
          	this.$axios.post(this.$store.state.portUrl+"user/updateProfile",{PScore:0,UName:this.myInfo.puserName,PEmail:this.myInfo.pemail,PStatement:value}).then(res=>{
          	this.$axios.post(this.$store.state.portUrl+"/user/getProfile", {
          	    UName: this.$store.state.UserInfo.uname,
          	  })
          	 .then(res => {
          							console.log(res.data.Profile);
          	   this.myInfo = res.data.Profile;
          	 });
          	this.$message({
          	  type: 'success',
          	  message: '更改个人简介成功' 
          	});
						})
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '取消输入'
          });       
        });
    },
		editEmail() {
		    this.$prompt('请输入更改邮箱', '提示', {
		      confirmButtonText: '确定',
		      cancelButtonText: '取消',
		      inputPattern: /[\w!#$%&'*+/=?^_`{|}~-]+(?:\.[\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\w](?:[\w-]*[\w])?\.)+[\w](?:[\w-]*[\w])?/,
		      inputErrorMessage: '邮箱格式不正确'
		    }).then(({ value }) => {
					this.$axios.post(this.$store.state.portUrl+"user/updateProfile",{PScore:0,UName:this.myInfo.puserName,PStatement:this.myInfo.pstatement,PEmail:value}).then(res=>{
						this.$axios
						  .post(this.$store.state.portUrl+"/user/getProfile", {
						    UName: this.$store.state.UserInfo.uname,
						  })
						 .then(res => {
												console.log(res.data.Profile);
						   this.myInfo = res.data.Profile;
						 });
						this.$message({
						  type: 'success',
						  message: '更改邮箱成功' 
						});
					}).catch(err=>{
						console.log(err);
					});
		    }).catch(() => {
		      this.$message({
		        type: 'info',
		        message: '取消输入'
		      });       
		    });
		  },
		del(id){
				this.$confirm('此操作将永久删除该贴子, 是否继续?', '！！！', {
				  confirmButtonText: '确定',
				  cancelButtonText: '取消',
				  type: 'warning'
				}).then(() => {
					
				this.$axios.post(this.$store.state.portUrl+"post/delPost",{PID:id,PUserName:this.$store.state.UserInfo.uname}).then(res=>{
						if(res.data.code === 0)
						{
							this.$axios
							  .post(this.$store.state.portUrl+"/post/selectUserPostAll", {
							    UName: this.$store.state.UserInfo.uname,
							  })
							  .then(res => {
							    this.myPost = res.data.List;
							  });
								this.$axios
								  .post(this.$store.state.portUrl+"/post/selectUserReplyAll", {
								    UName: this.$store.state.UserInfo.uname,
								  })
								 .then(res => {
								   this.myReply = res.data.List;
								 });
								 this.$axios
								   .post(this.$store.state.portUrl+"/user/getProfile", {
								     UName: this.$store.state.UserInfo.uname,
								   })
								  .then(res => {
										console.log(res.data.Profile);
								    this.myInfo = res.data.Profile;
								  });
							 this.$message({
								type: 'success',
								message: '删贴成功!'
							 });
						}
					}).catch(err=>{
					console.log(err);
				});
				 
				}).catch(() => {
				  this.$message({
					type: 'info',
					message: '已取消删除'
				  });          
				});
		},
	},
  mounted() {
    this.$nextTick(() => {
      this.$axios
        .post(this.$store.state.portUrl+"/post/selectUserPostAll", {
          UName: this.$store.state.UserInfo.uname,
        })
        .then(res => {
          this.myPost = res.data.List;
        });
				this.$axios
				  .post(this.$store.state.portUrl+"/post/selectUserReplyAll", {
				    UName: this.$store.state.UserInfo.uname,
				  })
				 .then(res => {
				   this.myReply = res.data.List;
				 });
				 this.$axios
				   .post(this.$store.state.portUrl+"/user/getProfile", {
				     UName: this.$store.state.UserInfo.uname,
				   })
				  .then(res => {
						console.log(res.data.Profile);
				    this.myInfo = res.data.Profile;
				  });
    });
  }
};
</script>
<style scoped>
.button {
  float: right;
}
.clear {
  clear: both;
}
</style>

