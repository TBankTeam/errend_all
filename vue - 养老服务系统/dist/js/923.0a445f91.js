"use strict";(self["webpackChunkvue"]=self["webpackChunkvue"]||[]).push([[923],{3923:function(e,t,a){a.r(t),a.d(t,{default:function(){return m}});var r=function(){var e=this,t=e._self._c;return t("div",[t("div",{staticClass:"search"},[t("el-input",{staticStyle:{width:"200px"},attrs:{placeholder:"请输入标题查询"},model:{value:e.name,callback:function(t){e.name=t},expression:"name"}}),t("el-button",{staticStyle:{"margin-left":"10px"},attrs:{type:"info",plain:""},on:{click:function(t){return e.load(1)}}},[e._v("查询")]),t("el-button",{staticStyle:{"margin-left":"10px"},attrs:{type:"warning",plain:""},on:{click:e.reset}},[e._v("重置")])],1),t("div",{staticClass:"operation"},[t("el-button",{attrs:{type:"primary",plain:""},on:{click:e.handleAdd}},[e._v("新增")]),t("el-button",{attrs:{type:"danger",plain:""},on:{click:e.delBatch}},[e._v("批量删除")])],1),t("div",{staticClass:"table"},[t("el-table",{attrs:{data:e.tableData,strip:""},on:{"selection-change":e.handleSelectionChange}},[t("el-table-column",{attrs:{type:"selection",width:"55",align:"center"}}),t("el-table-column",{attrs:{prop:"id",label:"序号",width:"70",align:"center",sortable:""}}),t("el-table-column",{attrs:{prop:"name",label:"名称"}}),t("el-table-column",{attrs:{prop:"cover",label:"封面"},scopedSlots:e._u([{key:"default",fn:function(e){return[t("el-image",{staticStyle:{width:"60px",height:"40px"},attrs:{"preview-src-list":[e.row.cover],src:e.row.cover}})]}}])}),t("el-table-column",{attrs:{prop:"descr",label:"简介","show-overflow-tooltip":""}}),t("el-table-column",{attrs:{prop:"start",label:"开始日期"}}),t("el-table-column",{attrs:{prop:"end",label:"结束时间"}}),t("el-table-column",{attrs:{label:"查看详情"},scopedSlots:e._u([{key:"default",fn:function(a){return[t("el-button",{on:{click:function(t){return e.preview(a.row.content)}}},[e._v("查看内容")])]}}])}),t("el-table-column",{attrs:{prop:"address",label:"地址"}}),t("el-table-column",{attrs:{label:"操作",align:"center",width:"180"},scopedSlots:e._u([{key:"default",fn:function(a){return[t("el-button",{attrs:{size:"mini",type:"primary",plain:""},on:{click:function(t){return e.handleEdit(a.row)}}},[e._v("编辑")]),t("el-button",{attrs:{size:"mini",type:"danger",plain:""},on:{click:function(t){return e.del(a.row.id)}}},[e._v("删除")])]}}])})],1),t("div",{staticClass:"pagination"},[t("el-pagination",{attrs:{background:"","current-page":e.pageNum,"page-sizes":[5,10,20],"page-size":e.pageSize,layout:"total, prev, pager, next",total:e.total},on:{"current-change":e.handleCurrentChange}})],1)],1),t("el-dialog",{attrs:{name:"公益活动",visible:e.fromVisible,width:"50%","close-on-click-modal":!1,"destroy-on-close":""},on:{"update:visible":function(t){e.fromVisible=t}}},[t("el-form",{ref:"formRef",staticStyle:{"padding-right":"50px"},attrs:{model:e.form,"label-width":"100px",rules:e.rules}},[t("el-form-item",{attrs:{label:"名称",prop:"name"}},[t("el-input",{attrs:{placeholder:"名称"},model:{value:e.form.name,callback:function(t){e.$set(e.form,"name",t)},expression:"form.name"}})],1),t("el-form-item",{attrs:{label:"封面",prop:"cover"}},[t("el-upload",{staticClass:"avatar-uploader",attrs:{action:e.$baseUrl+"/files/upload",headers:{token:e.user.token},"list-type":"picture","on-success":e.handleCoverSuccess}},[t("el-button",{attrs:{type:"primary"}},[e._v("上传封面")])],1)],1),t("el-form-item",{attrs:{label:"简介",prop:"descr"}},[t("el-input",{attrs:{type:"textarea",placeholder:"简介"},model:{value:e.form.descr,callback:function(t){e.$set(e.form,"descr",t)},expression:"form.descr"}})],1),t("el-form-item",{attrs:{label:"地址",prop:"address"}},[t("el-input",{attrs:{type:"textarea",placeholder:"地址"},model:{value:e.form.address,callback:function(t){e.$set(e.form,"address",t)},expression:"form.address"}})],1),t("el-form-item",{attrs:{label:"开始日期",prop:"start"}},[t("el-date-picker",{staticStyle:{width:"100%"},attrs:{"value-format":"yyyy-MM-dd",format:"yyyy-MM-dd",placeholder:"开始日期"},model:{value:e.form.start,callback:function(t){e.$set(e.form,"start",t)},expression:"form.start"}})],1),t("el-form-item",{attrs:{label:"结束日期",prop:"end"}},[t("el-date-picker",{staticStyle:{width:"100%"},attrs:{"value-format":"yyyy-MM-dd",format:"yyyy-MM-dd",placeholder:"结束时间"},model:{value:e.form.end,callback:function(t){e.$set(e.form,"end",t)},expression:"form.end"}})],1),t("el-form-item",{attrs:{label:"活动详情",prop:"content"}},[t("div",{attrs:{id:"editor"}})])],1),t("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[t("el-button",{on:{click:function(t){e.fromVisible=!1}}},[e._v("取 消")]),t("el-button",{attrs:{type:"primary"},on:{click:e.save}},[e._v("确 定")])],1)],1),t("el-dialog",{attrs:{title:"文章内容",visible:e.fromVisible1,width:"50%","close-on-click-modal":!1,"destroy-on-close":""},on:{"update:visible":function(t){e.fromVisible1=t}}},[t("div",{staticClass:"w-e-text"},[t("div",{domProps:{innerHTML:e._s(e.content)}})]),t("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[t("el-button",{on:{click:function(t){e.fromVisible1=!1}}},[e._v("关 闭")])],1)])],1)},s=[],i=a(7438),l=a.n(i),o={name:"Activity",data(){return{tableData:[],pageNum:1,pageSize:10,total:0,name:null,fromVisible:!1,form:{},user:JSON.parse(localStorage.getItem("xm-user")||"{}"),rules:{name:[{required:!0,message:"请输入标题",trigger:"blur"}],descr:[{required:!0,message:"请输入简介",trigger:"blur"}],address:[{required:!0,message:"请输入地址",trigger:"blur"}],start:[{required:!0,message:"请选择开始日期",trigger:"blur"}],end:[{required:!0,message:"请选择结束日期",trigger:"blur"}]},ids:[],content:"",fromVisible1:!1}},created(){this.load(1)},methods:{handleAdd(){this.form={},this.fromVisible=!0,this.setRichText("")},handleEdit(e){this.form=JSON.parse(JSON.stringify(e)),this.fromVisible=!0,this.setRichText(this.form.content)},save(){this.$refs.formRef.validate((e=>{e&&(this.form.content=this.editor.txt.html(),this.$request({url:this.form.id?"/activity/update":"/activity/add",method:this.form.id?"PUT":"POST",data:this.form}).then((e=>{"200"===e.code?(this.$message.success("保存成功"),this.load(1),this.fromVisible=!1):this.$message.error(e.msg)})))}))},del(e){this.$confirm("您确定删除吗？","确认删除",{type:"warning"}).then((t=>{this.$request.delete("/activity/delete/"+e).then((e=>{"200"===e.code?(this.$message.success("操作成功"),this.load(1)):this.$message.error(e.msg)}))})).catch((()=>{}))},handleSelectionChange(e){this.ids=e.map((e=>e.id))},delBatch(){this.ids.length?this.$confirm("您确定批量删除这些数据吗？","确认删除",{type:"warning"}).then((e=>{this.$request.delete("/activity/delete/batch",{data:this.ids}).then((e=>{"200"===e.code?(this.$message.success("操作成功"),this.load(1)):this.$message.error(e.msg)}))})).catch((()=>{})):this.$message.warning("请选择数据")},load(e){e&&(this.pageNum=e),this.$request.get("/activity/selectPage",{params:{pageNum:this.pageNum,pageSize:this.pageSize,name:this.name}}).then((e=>{this.tableData=e.data?.list,this.total=e.data?.total}))},reset(){this.name=null,this.load(1)},handleCurrentChange(e){this.load(e)},handleCoverSuccess(e){this.form.cover=e.data},setRichText(e){this.$nextTick((()=>{this.editor=new(l())("#editor"),this.editor.config.uploadImgServer=this.$baseUrl+"/files/editor/upload",this.editor.config.uploadFileName="file",this.editor.config.uploadImgHeaders={token:this.user.token},this.editor.config.uploadImgParams={type:"img"},this.editor.create(),this.editor.txt.html(e)}))},preview(e){this.content=e,this.fromVisible1=!0}}},n=o,c=a(3736),d=(0,c.Z)(n,r,s,!1,null,"69e9aa9e",null),m=d.exports}}]);
//# sourceMappingURL=923.0a445f91.js.map