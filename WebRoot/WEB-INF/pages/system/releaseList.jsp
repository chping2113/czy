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
      日期：<input style="width:150px;" type="text" name="startTime" id="startTime" class="calendar input_text" value="<s:date name='startTime' format='yyyy-MM-dd'/>"  readonly="readonly"/>
     --
       <input  style="width:150px;" type="text" name="endTime" id="endTime" class="calendar input_text" value="<s:date name='endTime' format='yyyy-MM-dd'/>"   readonly="readonly"/>
       <select id="userId" name="userId" class="input_text">
      		<option value="0">请选择一个用户</option>
      		<s:iterator value="#userList" var="r">
      		<option value="${r.id }" ${r.id == userId  ? "selected" :"" }>${r.code }</option>
      		</s:iterator>
      	</select>
       &nbsp;&nbsp;&nbsp;&nbsp;
       <input type="image" src="imgage/search2.gif" class="search_img" align="middle"/>
    </form>
    <table cellpadding="0" cellspacing="0" class="table_list">
    <tr>
      <th >用户</th>
      <th>角色</th>
      <th >项目审批信息</th>
      <th >建设管理信息</th>
      <th >土地权信息</th>
  			<th>矿业权信息</th>
  			<th>招投标信息</th>
      <th>操作</th>
     </tr>
     <s:iterator value="#dataCountList" var="dc" status="status1">
     <tr>
      <td>${dc.user.code }</td>
      <td>${dc.user.role.name }</td>
      <td>${dc.projectApproveCount }</td>
  			<td>${dc.projectConstructCount }</td>
  			<td>${dc.projectLandCount }</td>
  			<td>${dc.projectMiningCount }</td>
  			<td>${dc.projectAimCount }</td>
  			<td class="table_list_add"><a href="system/release_more.action?userId=${dc.user.id }&startTimeStr=<s:date name='startTime' format='yyyy-MM-dd'/>&endTimeStr=<s:date name='endTime' format='yyyy-MM-dd'/>">详细</a></td>
     </tr>
     </s:iterator>
     </table>
   
    
 </div>  <!--right_main-->
 
 <brady:dialog title="政府部门帐户信息维护" onClickOK="doSubmit()" width="650" height="360"/>
 <brady:confirm />
</body>