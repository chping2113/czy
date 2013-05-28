<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/include/core.jsp"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理-帐号基本信息</title>

<script type="text/javascript" src="js/verifyCode.js"></script>

<script type="text/javascript">
$(function(){
	if("${loginType}"==0){
		$("#tab0").show();
	}else if("${loginType}"==1){
		$("#tab1").show();
	}else if("${loginType}"==2){
		$("#tab2").show();
	}else if("${loginType}"==3){
		$("#tab3").show();
	}else{
		$("#tab4").show();
	}
});

</script>

</head>

<body >
<div class="add_news">
	<div class="add_top">帐户基本信息</div>
	<form id="addForm" method="post" >
	
    <table id="tab0" style="display:none" cellpadding="0" cellspacing="0" class="table_add">
     <tr>
      <th width="28%">帐号</th>
      <td>${model.code }</td>
     </tr>
     
     <tr>
      <th width="28%">所属角色</th>
      <td>${model.role.name }</td>
     </tr>
     
     <tr>
      <th width="28%">组织机构</th>
      <td>${model.site.name }</td>
     </tr>
      <tr>
      <th width="28%">姓名</th>
      <td>${model.name }</td>
     </tr> <tr>
      <th width="28%">联系电话</th>
      <td>${model.tel }</td>
     </tr>
     <tr>
      <th width="28%">电子邮件</th>
      <td>${model.email }</td>
     </tr>
     
     <tr>
      <th width="28%">创建时间</th>
      <td><s:date name="model.createTime" format="yyyy-MM-dd" /></td>
     </tr>
     
    
     <tr>
      <th width="28%">有效状态</th>
      <td>${model.state == 1 ? "有效" : "无效" }</td>
     </tr>
    </table>
    
    
    
    <table id="tab4" style="display:none" cellpadding="0" cellspacing="0" class="table_add">
     <tr>
      <td>用户未登录</td>
     </tr>
    </table>
    
    </form>
</div> 
 
</body>
</html>
