<template>
  <div class="container">
    <div style="height: 60px; background-color: white">
      <div style="width: 60%; height: 100%; display: flex; align-items: center; margin:  0 auto">
        <img src="@/assets/imgs/logo.png" alt="" style="width: 40px">
        <span style="color: #2A60C9; font-size: 24px; font-weight: bold; margin-left: 10px">社区养老系统</span>
      </div>
    </div>
    <div style="height: calc(100vh - 60px); width: 60%; margin:  0 auto; display: flex; align-items: center">
      <div style="flex: 1">
        <img src="@/assets/imgs/login.png" alt="" style="width: 90%; border-radius: 5px;">
      </div>
      <div style="width: 350px; padding: 50px 30px; box-shadow:  0 0 10px rgba(0, 0, 0 ,.1); background-color: white; border-radius: 5px;">
        <div style="text-align: center; font-size: 22px; margin-bottom: 30px; font-weight: bold; color: #2A60C9">欢 迎 注 册</div>
        <el-form :model="form" :rules="rules" ref="formRef">
          <el-form-item prop="username">
            <el-input prefix-icon="el-icon-user" placeholder="请输入账号" v-model="form.username"></el-input>
          </el-form-item>
          <el-form-item prop="password">
            <el-input prefix-icon="el-icon-lock" placeholder="请输入密码" show-password  v-model="form.password"></el-input>
          </el-form-item>
          <el-form-item prop="confirmPassword">
            <el-input prefix-icon="el-icon-lock" placeholder="请确认密码" show-password  v-model="form.confirmPassword"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button style="width: 100%; background-color: #2A60C9; border-color: #2A60C9; color: white" @click="register">注 册</el-button>
          </el-form-item>
          <div style="display: flex; align-items: center">
            <div style="flex: 1"></div>
            <div style="flex: 1; text-align: right">
              已有账号？请 <a href="/register">登录</a>
            </div>
          </div>
        </el-form>
      </div>
    </div>

  </div>
</template>

<script>
export default {
  name: "Register",
  data() {
    // 验证码校验
    const validatePassword = (rule, confirmPass, callback) => {
      if (confirmPass === '') {
        callback(new Error('请确认密码'))
      } else if (confirmPass !== this.form.password) {
        callback(new Error('两次输入的密码不一致'))
      } else {
        callback()
      }
    }
    return {
      form: { role: 'USER' },
      rules: {
        username: [
          { required: true, message: '请输入账号', trigger: 'blur' },
        ],
        password: [
          { required: true, message: '请输入密码', trigger: 'blur' },
        ],
        confirmPassword: [
          { validator: validatePassword, trigger: 'blur' }
        ]
      }
    }
  },
  created() {

  },
  methods: {
    register() {
      this.$refs['formRef'].validate((valid) => {
        if (valid) {
          // 验证通过
          this.$request.post('/register', this.form).then(res => {
            if (res.code === '200') {
              this.$router.push('/login')  // 跳转登录
              this.$message.success('注册成功')
            } else {
              this.$message.error(res.msg)
            }
          })
        }
      })
    }
  }
}
</script>

<style scoped>
.container {
  height: 100vh;
  overflow: hidden;
  background-color: #f8f8f8;
}
a {
  color: #2a60c9;
}
</style>