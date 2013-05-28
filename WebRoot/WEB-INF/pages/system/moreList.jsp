<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/include/core.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>安徽项目公开网-发布信息统计</title>
	<link rel="stylesheet" href="css/zTreeStyle/zTreeStyle.css" type="text/css">
	
	<script type="text/javascript" src="js/system/user.js"></script>
	<script type="text/javascript" src="js/jquery-ztree-2.4.min.js"></script>
	<script type="text/javascript">
		var pageNo = "${pageNo}";
		function doSubmit(){
			var url = "system/user_checkEmail.action";
			var param = {"email":$("#email").val(),"editId":$("#id").val()};
			$.post(url, param, function(date) {
				if(date=='err'){
					alert("该邮箱已经被使用，请重新输入!");
					return false ;
				}else{
					$("#addForm").submit();
				}
			});
		}

		$(function() {
			
			$("#startTime").datepicker({
				changeYear:true,
				changeMonth: true,
				onSelect: function(dateText, inst) {
					$("#createTime").blur();
				}
			});

			$("#endTime").datepicker({
				changeYear:true,
				changeMonth: true,
				onSelect: function(dateText, inst) {
					$("#endTime").blur();
				}
			});
		});
	</script>
</head>
<body>
   <div class="right_main">
   <form action="system/release_query.action" method="post">
    <div class="add_top">您当前的位置：系统管理 > 发布信息统计</div>
      时间：<input  type="text" name="startTime" id="startTime" class="calendar input_text" value="<s:date name='startTime' format='yyyy-MM-dd'/>"  readonly="readonly"/>
     
       <input type="text" name="endTime" id="endTime" class="calendar input_text" value="<s:date name='endTime' format='yyyy-MM-dd'/>"   readonly="readonly"/>
       <select id="userId" name="userId" class="input_text">
      		<option value="0">请选择一个用户</option>
      		<s:iterator value="#userList" var="r">
      		<option value="${r.id }" ${r.id == userId  ? "selected" :"" }>${r.code }</option>
      		</s:iterator>
      	</select>
       &nbsp;&nbsp;&nbsp;&nbsp;
       <input type="image" src="imgage/search2.gif" class="search_img" />
    </form>
    <table cellpadding="0" cellspacing="0" class="table_list">

     <s:iterator value="#dataCountList" var="dc" status="status1">
     
  <tr><th width="15%">用户</th><td>${dc.user.code }</td></tr>
  <tr><th>项目审批信息</th><td>${dc.projectApproveCount }</td></tr>
  <tr><th>建设管理信息</th><td>${dc.projectConstructCount }</td></tr>
  <tr><th>土地权信息</th><td>${dc.projectLandCount }</td></tr>
  <tr><th>矿业权信息</th><td>${dc.projectMiningCount }</td></tr>
  <tr><th>招投标信息</th><td>${dc.projectAimCount }</td></tr>
  <tr><th>单位信用等级公告</th><td>${dc.companyCreditCount }</td></tr>
  <tr><th>单位基本信息</th><td>${dc.companyInfoCount }</td></tr>
  <tr><th>单位资质信息</th><td>${dc.companyQualificationCount }</td></tr>
  <tr><th>个人资质信息</th><td>${dc.personQualificationCount }</td></tr>
  <tr><th>单位良好信息</th><td>${dc.companyHonorCount }</td></tr>
  <tr><th>单位不良信息</th><td>${dc.companyBadrecordCount }</td></tr>
  <tr><th>总数</th><td>${dc.allCount }</td></tr>
 
    
     </s:iterator>
     </table>
   
    <div class="add_savebtn">
    
    	<a href="javascript:history.back()"><img src="images/back00.gif" border="0" /></a>
    	</div>
 </div>  <!--right_main-->
 
 <brady:dialog title="政府部门帐户信息维护" onClickOK="doSubmit()" width="650" height="360"/>
 <brady:confirm />
</body>