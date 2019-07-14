<template>
	<div class="home">
		<div v-show="!$store.state.isLogin">
						  <el-button round @click="loginVisitor">以游客身份登陆</el-button>
			<el-radio-group v-model="radio">
				<el-radio-button label="登陆"></el-radio-button>
				<el-radio-button label="注册"></el-radio-button>
			</el-radio-group>
			<div v-show="radio === '登陆'">

				<el-input v-model="username" placeholder="用户名"></el-input>
				<el-input v-model="password" placeholder="密码"></el-input>

				<el-button type="primary" @click="login">登陆</el-button>
			</div>
			<div v-show="radio === '注册'">

				<el-input v-model="username" placeholder="用户名"></el-input>
				<el-input v-model="password" placeholder="密码"></el-input>

				<el-button type="primary" @click="register">注册</el-button>
			</div>
		</div>



		<div v-show="$store.state.isLogin">
			
			<div style="margin-top: 15px;">
  <el-input placeholder="请输入内容" v-model="input" clearable class="input-with-select">
    <el-select v-model="value" slot="prepend" placeholder="请选择">
    	<el-option v-for="item in options" :key="item.value" :label="item.label" :value="item.value">
    	</el-option>
    </el-select>
	<el-button @click="search" slot="append" icon="el-icon-search"></el-button>
  </el-input>
</div>

			

			

		<postpage :posts = 'posts'/>


			<el-button v-show="$store.state.UserInfo !== ''" type="success" round @click="dialogVisible = true">点我发表文章</el-button>
			<el-dialog title="发帖!" :visible.sync="dialogVisible" width="30%" :before-close="closeDialog">
				<el-input type="textarea" :autosize="{ minRows: 2, maxRows: 4}" placeholder="请输入内容" v-model="pcontents">
				</el-input>
				<span slot="footer" class="dialog-footer">
					<el-button @click="closeDialog">取 消</el-button>
					<el-button type="primary" @click="addPost">发 帖</el-button>
				</span>
			</el-dialog>
		</div>
	</div>
</template>

<script>
	import postpage from "./postpage"
	export default {
		name: 'HelloWorld',
		data() {
			return {
				options: [{
					value: '选项1',
					label: '用户名字'
				}, {
					value: '选项2',
					label: '贴子关键字'
				}, ],
				input: '',
				value: '',
				posts: '',
				radio: 1,
				username: 'hehe',
				password: '123456',
				dialogVisible: false,

				pcontents: '',
			}
		},
		components: {
			postpage: postpage,
		},
		methods: {
			loginVisitor:function(e){
				this.$store.state.hasUserInfo = true;
				this.$store.state.isLogin = true;
				this.getAllPost();
			},
			closeDialog: function(e) {
				this.pcontents = '';
				this.dialogVisible = false;
				this.getAllPost();
			},
			addPost: function(e) {
				this.$axios.post(this.$store.state.portUrl + "post/addPost", {
					PUserName: this.$store.state.UserInfo.uname,
					PBelongPostID: 0,
					PContents: this.pcontents,
					PType: 0
				}).then(res => {
					this.dialogVisible = false;
					if (res.data.code === 0) {
						this.pcontents = '';
						this.dialogVisible = false;
						this.getAllPost();
						this.$message({
							type: 'success',
							message: '发贴成功!'
						});
					} else {
						this.$message.error('发贴失败...');
					}
				}).catch(err => {
					console.log(err);
				});

			},
			getAllPost: function() {
				this.$axios.get(this.$store.state.portUrl + "post/selectPostAll").then(res => {
					if (res.data.code === 0) {
						this.posts = res.data.List;
					} else {
						this.$message.error('获取贴子失败...');
					}
				}).catch(err => {
					console.log(err);
				})
			},
			login: function(e) {
				this.$axios.post(this.$store.state.portUrl + "user/login", {
						UName: this.username,
						UPassword: this.password
					}).then(res => {
					if (res.data.code === 0) {
						this.$store.state.UserInfo = res.data.User;
						this.$store.state.hasUserInfo = true;
						this.$store.state.isLogin = true;
						this.getAllPost();
						this.$message({
							type: 'success',
							message: '登陆成功!'
						});
					} else {
						this.$message.error('登陆失败!');
					}
				}).catch(err => {
					console.log(err);
				})
			},
			register: function(e) {
				this.$axios.post(this.$store.state.portUrl + "user/register", {
					UName: this.username,
					UPassword: this.password
				}).then(res => {
					if (res.data.code === 0) {
						this.$store.state.UserInfo = res.data.User;
						this.$store.state.hasUserInfo = true;
						this.$store.state.isLogin = true;
						this.getAllPost();
						this.$message({
							type: 'success',
							message: '注册成功!'
						});
					} else {
						this.$message.error('注册失败!');
					}
				}).catch(err => {
					console.log(err);
				})
			},
			logout: function(e) {
				this.$store.state.isLogin = false;
				this.$store.state.hasUserInfo = false;
				this.$store.state.UserInfo = '';
			},
			search: function(e) {
				if (this.value === "选项1") {
					this.$axios.post(this.$store.state.portUrl + "post/selectUserPostAll", {
						UName: this.input
					}).then(res => {
						if (res.data.code === 0) {
							this.posts = res.data.List;
							this.$message({
								type: 'success',
								message: '搜索成功!'
							});
						} else {
							this.$message.error('搜索失败!');
						}
					}).catch(err => {
						console.log(err);
					})
				} else if (this.value === "选项2") {
					this.$axios.post(this.$store.state.portUrl + "post/getPostContent", {
						content: this.input
					}).then(res => {
						if (res.data.code === 0) {
							this.posts = res.data.List;
							this.$message({
								type: 'success',
								message: '搜索成功!'
							});
						} else {
							this.$message.error('搜索失败!');
						}
					}).catch(err => {
						console.log(err);
					})
				}
			}
		},
		mounted() {
		    this.getAllPost();
		 }
	}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
	h1,
	h2 {
		font-weight: normal;
	}

	ul {
		list-style-type: none;
		padding: 0;
	}

	li {
		display: inline-block;
		margin: 0 10px;
	}

	a {
		color: #42b983;
	}
	
	 .el-select .el-input {
    width: 130px;
  }
  .input-with-select .el-input-group__prepend {
    background-color: #fff;
  }
</style>
