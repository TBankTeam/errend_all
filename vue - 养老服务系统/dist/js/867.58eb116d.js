"use strict";(self["webpackChunkvue"]=self["webpackChunkvue"]||[]).push([[867],{9867:function(e,t,s){s.r(t),s.d(t,{default:function(){return l}});var r=function(){var e=this,t=e._self._c;return t("div",{staticClass:"main-content"},[t("div",[t("el-row",{attrs:{gutter:10}},e._l(e.serveList,(function(s){return t("el-col",{key:s.id,attrs:{span:6}},[t("div",{staticClass:"card"},[t("img",{staticStyle:{width:"100%",height:"150px"},attrs:{src:s.cover,alt:""}}),t("div",{staticStyle:{margin:"5px 0"}},[e._v(e._s(s.name))]),t("div",{staticStyle:{"margin-bottom":"10px",color:"#666","font-size":"13px"}},[e._v(e._s(s.descr))]),t("div",{staticStyle:{"text-align":"right"}},[t("el-button",{attrs:{type:"primary"},on:{click:function(t){return e.addReserve(s.id)}}},[e._v("预约服务")])],1)])])})),1)],1)])},a=[],i={name:"FrontServe",data(){return{serveList:[],user:JSON.parse(localStorage.getItem("xm-user")||"{}")}},created(){this.load()},methods:{addReserve(e){this.$request.post("/reserve/add",{serveId:e,userId:this.user.id}).then((e=>{"200"===e.code?this.$message.success("预约成功"):this.$message.error(e.msg)}))},load(){this.$request.get("/serve/selectAll").then((e=>{this.serveList=e.data||[]}))}}},n=i,c=s(3736),d=(0,c.Z)(n,r,a,!1,null,"ae3e2cd0",null),l=d.exports}}]);
//# sourceMappingURL=867.58eb116d.js.map