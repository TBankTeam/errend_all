"use strict";(self["webpackChunkvue"]=self["webpackChunkvue"]||[]).push([[270],{1270:function(e,t,a){a.r(t),a.d(t,{default:function(){return u}});var s=function(){var e=this,t=e._self._c;return t("div",{staticClass:"main-content"},[t("div",{staticStyle:{"font-size":"20px","margin-bottom":"20px"}},[e._v("我预约的服务")]),t("div",{staticClass:"table"},[t("el-table",{attrs:{size:"medium",data:e.tableData,strip:""},on:{"selection-change":e.handleSelectionChange}},[t("el-table-column",{attrs:{label:"服务",prop:"serveName"}}),t("el-table-column",{attrs:{prop:"time",label:"预约时间"}}),t("el-table-column",{attrs:{prop:"status",label:"审核状态"},scopedSlots:e._u([{key:"default",fn:function(a){return["待审核"===a.row.status?t("el-tag",{attrs:{type:"primary"}},[e._v("待审核")]):e._e(),"审核通过"===a.row.status?t("el-tag",{attrs:{type:"success"}},[e._v("审核通过")]):e._e(),"审核拒绝"===a.row.status?t("el-tag",{attrs:{type:"danger"}},[e._v("审核拒绝")]):e._e()]}}])}),t("el-table-column",{attrs:{prop:"reason",label:"审核意见"}}),t("el-table-column",{attrs:{label:"操作",align:"center",width:"180"},scopedSlots:e._u([{key:"default",fn:function(a){return["审核通过"!==a.row.status?t("el-button",{attrs:{size:"mini",type:"danger",plain:""},on:{click:function(t){return e.del(a.row.id)}}},[e._v("取消预约")]):e._e()]}}])})],1),t("div",{staticStyle:{margin:"10px 0"}},[t("el-pagination",{attrs:{background:"","current-page":e.pageNum,"page-sizes":[5,10,20],"page-size":e.pageSize,layout:"total, prev, pager, next",total:e.total},on:{"current-change":e.handleCurrentChange}})],1)],1)])},r=[],l={name:"FrontReserve",data(){return{tableData:[],pageNum:1,pageSize:10,total:0,userName:null,fromVisible:!1,form:{},user:JSON.parse(localStorage.getItem("xm-user")||"{}"),ids:[]}},created(){this.load(1)},methods:{del(e){this.$confirm("您确定取消吗？","确认取消",{type:"warning"}).then((t=>{this.$request.delete("/reserve/delete/"+e).then((e=>{"200"===e.code?(this.$message.success("操作成功"),this.load(1)):this.$message.error(e.msg)}))})).catch((()=>{}))},handleSelectionChange(e){this.ids=e.map((e=>e.id))},delBatch(){this.ids.length?this.$confirm("您确定批量删除这些数据吗？","确认删除",{type:"warning"}).then((e=>{this.$request.delete("/reserve/delete/batch",{data:this.ids}).then((e=>{"200"===e.code?(this.$message.success("操作成功"),this.load(1)):this.$message.error(e.msg)}))})).catch((()=>{})):this.$message.warning("请选择数据")},load(e){e&&(this.pageNum=e),this.$request.get("/reserve/selectPage",{params:{pageNum:this.pageNum,pageSize:this.pageSize,userName:this.userName}}).then((e=>{this.tableData=e.data?.list,this.total=e.data?.total}))},reset(){this.userName=null,this.load(1)},handleCurrentChange(e){this.load(e)}}},n=l,i=a(3736),o=(0,i.Z)(n,s,r,!1,null,"fa6ed420",null),u=o.exports}}]);
//# sourceMappingURL=270.62c0cc06.js.map