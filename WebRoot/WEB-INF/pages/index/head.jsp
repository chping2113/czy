<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="top">
   <div class="logo">
   		<img src="imgage/ahlogo.jpg" />
   </div>
   <div class="nav">
	 <a href="pub_index.action?message=1" id="${message=='1'||message==null?'curTab':'' }">首  页</a>
	 <a href="pub_listNewsByCatelogId.action?catelogId=17&message=2" id="${message=='2'?'curTab':'' }">组织机构</a>
	 <a href="pub_listNewsByCatelogId.action?catelogId=18&message=3" id="${message=='3'?'curTab':'' }">工作动态</a>
	 <a href="pub_navProjectPublic.action?message=4" id="${message=='4'?'curTab':'' }">项目信息公开</a>
	 <a href="pub_navCreditPublic.action?message=5" id="${message=='5'?'curTab':'' }">诚信信息公开</a> 
	 <a href="pub_listNewsByCatelogId.action?catelogId=19&message=6" id="${message=='6'?'curTab':'' }">法律法规</a> 
	 <a href="pub_showComplaint.action?message=7" id="${message=='7'?'curTab':'' }">投诉举报</a> 
	</div>
 </div>