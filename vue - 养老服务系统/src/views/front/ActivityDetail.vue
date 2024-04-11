<template>
  <div class="main-content" style="width: 60%">
    <div class="card">
      <div style="display: flex; grid-gap: 20px;">
        <img :src="activity.cover" alt="" style="width: 50%">
        <div style="flex: 1">
          <div style="font-size: 22px; margin-bottom: 40px">{{activity.name }}</div>
          <div class="item"><span style="color: #333">活动简介：</span>{{activity.descr }}</div>
          <div class="item"><span style="color: #333">活动日期：</span>{{ activity.start }} ~ {{ activity.end }}</div>
          <div class="item"><span style="color: #333">活动地址：</span>{{ activity.address }}</div>
          <div>
            <el-button @click="handleSign" size="medium" type="primary" v-if="activity.status === '未报名'" >开始报名</el-button>
            <el-button size="medium" type="primary" v-if="activity.status === '已报名'" disabled key="sign">已报名</el-button>
            <el-button size="medium" type="primary" v-if="activity.status === '未开始'" disabled key="notstart">活动未开始</el-button>
            <el-button size="medium" type="primary" v-if="activity.status === '已结束'" disabled key="notend">活动已结束</el-button>
          </div>
        </div>
      </div>

      <div style="margin: 50px 0">
        <div style="margin-bottom: 30px; font-size: 22px; font-weight: bold; text-align: center">- 活动详情 -</div>
        <div class="w-e-text" style="line-height: 26px">
          <div v-html="activity.content"></div>
        </div>
      </div>

    </div>

    <Comment :fid="id" module="activity" />

    <el-dialog userName="报名信息" :visible.sync="fromVisible" width="40%" :close-on-click-modal="false" destroy-on-close>
      <el-form label-width="100px" style="padding-right: 50px" :model="form" :rules="rules" ref="formRef">
        <el-form-item prop="phone" label="手机号">
          <el-input v-model="form.phone" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="fromVisible = false">取 消</el-button>
        <el-button type="primary" @click="sign">确 定</el-button>
      </div>
    </el-dialog>

  </div>
</template>

<script>
import Comment from "@/components/Comment";
export default {
  name: "ActivityDetail",
  components: {Comment},
  data() {
    return {
      id: this.$route.query.id,
      activity: {},
      fromVisible: false,
      form: {},
      user: JSON.parse(localStorage.getItem('xm-user') || '{}'),
      rules: {
        phone: [
          { required: true, message: '手机号必填', trigger: 'blur' }
        ]
      }
    }
  },
  created() {
    this.load()
  },
  methods: {
    sign() {
      this.$request.post('/activitySign/add', this.form).then(res => {
        if (res.code === '200') {
          this.$message.success('报名成功')
          this.fromVisible = false
          this.load()
        } else {
          this.$message.error(res.msg)
        }
      })
    },
    handleSign() {
      this.form = {}
      this.form.userId = this.user.id
      this.form.activityId = this.id
      this.fromVisible = true
    },
    load() {
      this.$request.get('/activity/selectById/' + this.id).then(res => {
        this.activity = res.data || {}
      })
    }
  }
}
</script>

<style scoped>
.item {
  color: #666; margin-bottom: 40px
}
</style>