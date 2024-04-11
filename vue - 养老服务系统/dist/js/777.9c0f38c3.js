"use strict";(self["webpackChunkvue"]=self["webpackChunkvue"]||[]).push([[777],{6371:function(t,e,i){i.d(e,{Z:function(){return c}});var s=function(){var t=this,e=t._self._c;return e("div",[e("div",{staticClass:"card",staticStyle:{margin:"10px 0"}},[e("div",{staticStyle:{"font-size":"20px","font-weight":"bold","margin-bottom":"15px"}},[t._v("评论 "+t._s(t.commentCount))]),e("div",{staticStyle:{"margin-bottom":"20px"}},[e("el-input",{attrs:{type:"textarea",placeholder:"请输入评论内容"},model:{value:t.form.content,callback:function(e){t.$set(t.form,"content",e)},expression:"form.content"}}),e("div",{staticStyle:{"margin-top":"5px","text-align":"right"}},[e("el-button",{attrs:{type:"primary"},on:{click:function(e){return t.addComment(null)}}},[t._v("评论")])],1)],1),e("div",t._l(t.commentList,(function(i){return e("div",{key:i.id,staticStyle:{display:"flex","grid-gap":"15px","margin-bottom":"20px"}},[e("img",{staticStyle:{width:"50px",height:"50px","border-radius":"50%"},attrs:{src:i.avatar,alt:""}}),e("div",{staticStyle:{flex:"1"}},[e("div",{staticStyle:{"margin-bottom":"5px",color:"#666"}},[t._v(t._s(i.userName))]),e("div",{staticStyle:{"margin-bottom":"5px"}},[t._v(t._s(i.content))]),e("div",{staticStyle:{"font-size":"13px",color:"#666","margin-bottom":"10px"}},[e("span",[t._v(t._s(i.time))]),e("span",{class:{highLight:i.showReply},staticStyle:{margin:"0 20px",cursor:"pointer"},on:{click:function(e){return t.handleReply(i)}}},[e("i",{staticClass:"el-icon-s-comment"}),t._v("回复 ")]),t.user.id===i.userId?e("span",{staticStyle:{cursor:"pointer"},on:{click:function(e){return t.del(i.id)}}},[e("i",{staticClass:"el-icon-delete"}),t._v("删除 ")]):t._e()]),i.showReply?e("div",{staticStyle:{"margin-bottom":"10px"}},[e("el-input",{attrs:{type:"textarea",placeholder:"请输入回复内容"},model:{value:i.reply,callback:function(e){t.$set(i,"reply",e)},expression:"item.reply"}}),e("div",{staticStyle:{"margin-top":"5px","text-align":"right"}},[e("el-button",{attrs:{type:"primary",size:"mini"},on:{click:function(e){return t.addComment(i)}}},[t._v("回复")])],1)],1):t._e(),i.children.length?e("div",t._l(i.children,(function(s){return e("div",{key:s.id,staticStyle:{display:"flex","grid-gap":"15px","margin-bottom":"10px"}},[e("img",{staticStyle:{width:"50px",height:"50px","border-radius":"50%"},attrs:{src:s.avatar,alt:""}}),e("div",{staticStyle:{flex:"1"}},[e("div",{staticStyle:{"margin-bottom":"5px",color:"#666"}},[t._v(t._s(s.userName)+" "),s.replyUser&&s.replyUser!==i.userName?e("span",[t._v("回复 "+t._s(s.replyUser))]):t._e()]),e("div",{staticStyle:{"margin-bottom":"5px"}},[t._v(t._s(s.content))]),e("div",{staticStyle:{"font-size":"13px",color:"#666","margin-bottom":"10px"}},[e("span",[t._v(t._s(s.time))]),e("span",{class:{highLight:s.showReply},staticStyle:{margin:"0 20px",cursor:"pointer"},on:{click:function(e){return t.handleReply(s)}}},[e("i",{staticClass:"el-icon-s-comment"}),t._v("回复 ")]),t.user.id===s.userId?e("span",{staticStyle:{cursor:"pointer"},on:{click:function(e){return t.del(s.id)}}},[e("i",{staticClass:"el-icon-delete"}),t._v("删除 ")]):t._e()]),s.showReply?e("div",{staticStyle:{"margin-bottom":"10px"}},[e("el-input",{attrs:{type:"textarea",placeholder:"请输入回复内容"},model:{value:s.reply,callback:function(e){t.$set(s,"reply",e)},expression:"sub.reply"}}),e("div",{staticStyle:{"margin-top":"5px","text-align":"right"}},[e("el-button",{attrs:{type:"primary",size:"mini"},on:{click:function(e){return t.addComment(s)}}},[t._v("回复")])],1)],1):t._e()])])})),0):t._e()])])})),0)])])},n=[],o={name:"CommentComponent",props:{fid:null,module:null},data(){return{commentCount:0,form:{},commentList:[],user:JSON.parse(localStorage.getItem("xm-user")||"{}")}},created(){this.loadComment()},methods:{del(t){this.$confirm("您确定删除吗？","确认删除",{type:"warning"}).then((e=>{this.$request.delete("/comment/deepDelete/"+t).then((t=>{"200"===t.code?(this.$message.success("操作成功"),this.loadComment()):this.$message.error(t.msg)}))})).catch((()=>{}))},handleReply(t){this.$set(t,"showReply",!t.showReply)},addComment(t){this.form.module=this.module,this.form.fid=this.fid,this.form.userId=this.user.id,t&&(this.form.pid=t.id,this.form.content=t.reply),this.$request.post("/comment/add",this.form).then((t=>{"200"===t.code?(this.$message.success("操作成功"),this.form={},this.loadComment()):this.$message.error(t.msg)}))},loadComment(){this.$request.get("/comment/selectTree/"+this.fid+"/"+this.module).then((t=>{this.commentList=t.data||[]})),this.$request.get("/comment/selectCount/"+this.fid+"/"+this.module).then((t=>{this.commentCount=t.data||0}))}}},r=o,a=i(3736),l=(0,a.Z)(r,s,n,!1,null,"46864b4b",null),c=l.exports},2777:function(t,e,i){i.r(e),i.d(e,{default:function(){return m}});var s=function(){var t=this,e=t._self._c;return e("div",{staticClass:"main-content",staticStyle:{width:"60%"}},[e("div",{staticClass:"card"},[e("div",{staticStyle:{"margin-bottom":"20px","font-size":"22px","font-weight":"bold","text-align":"center"}},[t._v(t._s(t.news.title))]),e("div",{staticStyle:{color:"#666","text-align":"center"}},[e("span",{staticStyle:{"margin-right":"20px"}},[t._v("发布时间："+t._s(t.news.time))]),e("span",[t._v("浏览量："),e("span",{staticStyle:{color:"red"}},[t._v(t._s(t.news.count))])])]),e("div",{staticStyle:{margin:"30px 0",padding:"0 20px"}},[e("div",{staticClass:"w-e-text",staticStyle:{"line-height":"26px","text-indent":"2rem"}},[e("div",{domProps:{innerHTML:t._s(t.news.content)}})])])]),e("Comment",{attrs:{fid:t.id,module:"news"}})],1)},n=[],o=i(6371),r={name:"NewsDetail",components:{Comment:o.Z},data(){return{id:this.$route.query.id,news:{}}},created(){this.$request.put("/news/updateCount/"+this.id).then((t=>{this.load()}))},methods:{load(){this.$request.get("/news/selectById/"+this.id).then((t=>{this.news=t.data||{}}))}}},a=r,l=i(3736),c=(0,l.Z)(a,s,n,!1,null,"d7c13d32",null),m=c.exports}}]);
//# sourceMappingURL=777.9c0f38c3.js.map