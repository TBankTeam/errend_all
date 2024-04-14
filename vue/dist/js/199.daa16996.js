"use strict";(self["webpackChunkvue"]=self["webpackChunkvue"]||[]).push([[199],{6199:function(e,t,a){a.r(t),a.d(t,{default:function(){return u}});var s=function(){var e=this,t=e._self._c;return t("div",[t("div",{staticClass:"search"},[t("el-input",{staticStyle:{width:"200px"},attrs:{placeholder:"请输入账号查询"},model:{value:e.username,callback:function(t){e.username=t},expression:"username"}}),t("el-input",{staticStyle:{width:"200px","margin-left":"10px"},attrs:{placeholder:"请输入姓名查询"},model:{value:e.name,callback:function(t){e.name=t},expression:"name"}}),t("el-button",{staticStyle:{"margin-left":"10px"},attrs:{type:"info",plain:""},on:{click:function(t){return e.load(1)}}},[e._v("查询")]),t("el-button",{staticStyle:{"margin-left":"10px"},attrs:{type:"warning",plain:""},on:{click:e.reset}},[e._v("重置")])],1),t("div",{staticClass:"operation"},[t("el-button",{attrs:{type:"primary",plain:""},on:{click:e.handleAdd}},[e._v("新增")]),t("el-button",{attrs:{type:"danger",plain:""},on:{click:e.delBatch}},[e._v("批量删除")])],1),t("div",{staticClass:"table"},[t("el-table",{attrs:{data:e.tableData,strip:""},on:{"selection-change":e.handleSelectionChange}},[t("el-table-column",{attrs:{type:"selection",width:"55",align:"center"}}),t("el-table-column",{attrs:{prop:"id",label:"序号",width:"70",align:"center",sortable:""}}),t("el-table-column",{attrs:{label:"头像"},scopedSlots:e._u([{key:"default",fn:function(a){return[t("div",{staticStyle:{display:"flex","align-items":"center"}},[a.row.avatar?t("el-image",{staticStyle:{width:"40px",height:"40px","border-radius":"50%"},attrs:{src:a.row.avatar,"preview-src-list":[a.row.avatar]}}):e._e()],1)]}}])}),t("el-table-column",{attrs:{prop:"username",label:"账号"}}),t("el-table-column",{attrs:{prop:"name",label:"姓名"}}),t("el-table-column",{attrs:{prop:"phone",label:"电话"}}),t("el-table-column",{attrs:{prop:"age",label:"年龄"}}),t("el-table-column",{attrs:{prop:"sex",label:"性别"}}),t("el-table-column",{attrs:{prop:"account",label:"账户余额"}}),t("el-table-column",{attrs:{prop:"status",label:"状态",formatter:e.setStatus}}),t("el-table-column",{attrs:{label:"操作",align:"center",width:"180"},scopedSlots:e._u([{key:"default",fn:function(a){return[t("el-button",{attrs:{size:"mini",type:"primary",plain:""},on:{click:function(t){return e.handleEdit(a.row)}}},[e._v("编辑")]),t("el-button",{attrs:{size:"mini",type:"danger",plain:""},on:{click:function(t){return e.del(a.row.id)}}},[e._v("删除")])]}}])})],1),t("div",{staticClass:"pagination"},[t("el-pagination",{attrs:{background:"","current-page":e.pageNum,"page-sizes":[5,10,20],"page-size":e.pageSize,layout:"total, prev, pager, next",total:e.total},on:{"current-change":e.handleCurrentChange}})],1)],1),t("el-dialog",{attrs:{title:"用户",visible:e.fromVisible,width:"40%","close-on-click-modal":!1,"destroy-on-close":""},on:{"update:visible":function(t){e.fromVisible=t}}},[t("el-form",{ref:"formRef",staticStyle:{"padding-right":"50px"},attrs:{model:e.form,"label-width":"100px",rules:e.rules}},[t("el-form-item",{attrs:{label:"头像"}},[t("el-upload",{staticClass:"avatar-uploader",attrs:{action:e.$baseUrl+"/files/upload",headers:{token:e.user.token},"list-type":"picture","on-success":e.handleAvatarSuccess}},[t("el-button",{attrs:{type:"primary"}},[e._v("上传头像")])],1)],1),t("el-form-item",{attrs:{label:"用户名",prop:"username"}},[t("el-input",{attrs:{placeholder:"用户名"},model:{value:e.form.username,callback:function(t){e.$set(e.form,"username",t)},expression:"form.username"}})],1),t("el-form-item",{attrs:{label:"密码",prop:"password"}},[t("el-input",{attrs:{placeholder:"密码"},model:{value:e.form.password,callback:function(t){e.$set(e.form,"password",t)},expression:"form.password"}})],1),t("el-form-item",{attrs:{label:"姓名",prop:"name"}},[t("el-input",{attrs:{placeholder:"姓名"},model:{value:e.form.name,callback:function(t){e.$set(e.form,"name",t)},expression:"form.name"}})],1),t("el-form-item",{attrs:{label:"电话",prop:"phone"}},[t("el-input",{attrs:{placeholder:"电话"},model:{value:e.form.phone,callback:function(t){e.$set(e.form,"phone",t)},expression:"form.phone"}})],1),t("el-form-item",{attrs:{label:"身份证号",prop:"id_number"}},[t("el-input",{attrs:{placeholder:"身份证号"},model:{value:e.form.id_number,callback:function(t){e.$set(e.form,"id_number",t)},expression:"form.id_number"}})],1),t("el-form-item",{attrs:{label:"年龄",prop:"age"}},[t("el-input",{attrs:{placeholder:"年龄"},model:{value:e.form.age,callback:function(t){e.$set(e.form,"age",t)},expression:"form.age"}})],1),t("el-form-item",{attrs:{label:"性别",prop:"sex"}},[t("el-radio-group",{model:{value:e.form.sex,callback:function(t){e.$set(e.form,"sex",t)},expression:"form.sex"}},[t("el-radio",{attrs:{label:"男"}}),t("el-radio",{attrs:{label:"女"}})],1)],1),t("el-form-item",{attrs:{id:"status",label:"状态",prop:"status"}},[t("el-select",{attrs:{placeholder:"请选择"},model:{value:e.form.status,callback:function(t){e.$set(e.form,"status",t)},expression:"form.status"}},e._l(e.statusInfo,(function(e){return t("el-option",{key:e.value,attrs:{label:e.label,value:e.value}})})),1)],1)],1),t("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[t("el-button",{on:{click:function(t){e.fromVisible=!1}}},[e._v("取 消")]),t("el-button",{attrs:{type:"primary"},on:{click:e.save}},[e._v("确 定")])],1)],1)],1)},l=[],r={name:"User",data(){return{statusInfo:[{value:"1",label:"启用"},{value:"2",label:"审核中"},{value:"5",label:"审核未通过"},{value:"3",label:"冻结"},{value:"4",label:"删除"}],tableData:[],pageNum:1,pageSize:10,total:0,username:null,name:null,fromVisible:!1,form:{},user:JSON.parse(localStorage.getItem("xm-user")||"{}"),rules:{username:[{required:!0,message:"请输入账号",trigger:"blur"}]},ids:[]}},created(){this.load(1)},methods:{handleAdd(){this.form={},this.fromVisible=!0,document.getElementById("status").style.visibility="hidden"},handleEdit(e){this.form=JSON.parse(JSON.stringify(e)),this.fromVisible=!0,this.form.password="******",1===this.form.status?this.form.status="启用":2===this.form.status?this.form.status="审核中":5===this.form.status?this.form.status="审核未通过":3===this.form.status?this.form.status="冻结":4===this.form.status&&(this.form.status="删除"),document.getElementById("status").style.visibility="visilbe"},save(){this.$refs.formRef.validate((e=>{e&&this.$request({url:this.form.id?"/user/update":"/user/add",method:this.form.id?"PUT":"POST",data:this.form}).then((e=>{"200"===e.code?(this.$message.success("保存成功"),this.load(1),this.fromVisible=!1):this.$message.error(e.msg)}))}))},del(e){this.$confirm("您确定删除吗？","确认删除",{type:"warning"}).then((t=>{this.$request.delete("/user/delete/"+e).then((e=>{"200"===e.code?(this.load(1),this.$message.success("操作成功")):this.$message.error(e.msg)}))})).catch((()=>{}))},handleSelectionChange(e){this.ids=e.map((e=>e.id))},delBatch(){this.ids.length?this.$confirm("您确定批量删除这些数据吗？","确认删除",{type:"warning"}).then((e=>{this.$request.delete("/user/delete/batch",{data:this.ids}).then((e=>{"200"===e.code?(this.$message.success("操作成功"),this.load(1)):this.$message.error(e.msg)}))})).catch((()=>{})):this.$message.warning("请选择数据")},load(e){e&&(this.pageNum=e),this.$request.get("/user/selectPage",{params:{pageNum:this.pageNum,pageSize:this.pageSize,username:this.username,name:this.name}}).then((e=>{this.tableData=e.data?.list,this.total=e.data?.total}))},reset(){this.username=null,this.name=null,this.load(1)},handleCurrentChange(e){this.load(e)},handleAvatarSuccess(e,t,a){this.form.avatar=e.data},setStatus(e){return 1===e.status?"启用":2===e.status?"审核中":3===e.status?"冻结":4===e.status?"删除":5===e.status?"审核未通过":""}}},i=r,o=a(3736),n=(0,o.Z)(i,s,l,!1,null,"30e1a0f0",null),u=n.exports}}]);
//# sourceMappingURL=199.daa16996.js.map