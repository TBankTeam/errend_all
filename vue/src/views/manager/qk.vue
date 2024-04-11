<template>
  <div>
<!--    <div class="search">-->
<!--      <el-input placeholder="请输入账号查询" style="width: 200px" v-model="username"></el-input>-->
<!--      <el-button type="info" plain style="margin-left: 10px" @click="load(1)">查询</el-button>-->
<!--      <el-button type="warning" plain style="margin-left: 10px" @click="reset">重置</el-button>-->
<!--    </div>-->
    <div >
<!--      <h2>嵌入CSDN</h2>-->
      <br>
      <iframe
          ref="myFrame"
          src="http://43.139.97.90:5100/#/home"
          frameborder="0"
          width="100%"
          height="900"
      ></iframe>

<!--      <iframe id="child" src='https://www.csdn.net'  width="1600px" height="800px" frameborder="0" scrolling="0" ></iframe>-->
<!--      <iframe id="child" src='http://43.139.97.90:5002/WeBASE-Front/#/home'  width="1600px" height="800px" frameborder="0" scrolling="0" ></iframe>-->
<!--      <iframe id="child" style="WIDTH: 496px; HEIGHT: 1525px " src='http://43.139.97.90:5002/WeBASE-Front/#/home'  frameborder="0" scrolling="0" security="restricted" sandbox="allow-scripts allow-same-origin allow-popups"></iframe>-->
<!--      <iframe-->
<!--          ref="myFrame"-->
<!--          src="http://192.168.86.3:3006/#/login"-->
<!--          frameborder="0"-->
<!--          width="100%"-->
<!--          height="700"-->
<!--      ></iframe>-->
    </div>






  </div>
</template>

<script>

export default {
  methods: {
    load() {
      let myFrame = this.$refs["myFrame"];
      myFrame.onload = function () {
        let iframeWin = myFrame.contentWindow;
        // 填充账号、密码和验证码
        iframeWin.document.querySelector('input[type="text"]').value = 'admin';
        iframeWin.document.querySelector('input[type="password"]').value = 'Ab1234';
        iframeWin.document.querySelector('input[type="vercode"]').value = '8888';
        // 触发登录按钮点击事件
        iframeWin.document.querySelector('.login-submit').click();

        // 登录成功后跳转到指定页面
        iframeWin.onload = function() {
          // 修改 iframe 的 src 属性来跳转页面
          myFrame.src = 'http://192.168.86.3:5000/#/home';
        };
      };
    },
    reset() {
      // 重置输入框内容
      this.username = '';
    }
  }


  // data() {
  //   return {};
  // },
  // created() {},
  // mounted() {
  //   this.iframeInit();
  // },
  // computed: {},
  // methods: {
  //   iframeInit() {
  //     let myFrame = this.$refs["myFrame"];
  //     if (myFrame.attachEvent) {
  //       //兼容浏览器判断
  //       myFrame.attachEvent("onload", function () {
  //         let iframeWin = myFrame.contentWindow;
  //         iframeWin.postMessage(
  //             { router: "/home", user: "admin", password: "Ab1234",vercode: 8888 },
  //             "*"
  //         );
  //         //data传递的参数   *写成子页面的域名或者是ip
  //       });
  //     } else {
  //       myFrame.onload = function () {
  //         let iframeWin = myFrame.contentWindow;
  //         iframeWin.postMessage(
  //             { router: "/home", user: "admin", password: "Ab1234",vercode: 8888 },
  //             "*"
  //         );
  //       };
  //     }
  //   },
  // },
};
</script>

<style scoped>

</style>