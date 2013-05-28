<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/include/core.jsp"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理-修改密码</title>
<script type="text/javascript" src="js/system/password.js"></script>

<script type="text/javascript">
$(function(){
	if("${loginType}"==0){
		$("#tab0").show();
		$.brady.validator.validate("addForm", validator_config0); //初始化表单验证构架
	}else if("${loginType}"==1){
		$("#tab1").show();
		$.brady.validator.validate("addForm", validator_config1); //初始化表单验证构架
	}else if("${loginType}"==2){
		$("#tab2").show();
		$.brady.validator.validate("addForm", validator_config2); //初始化表单验证构架
	}else if("${loginType}"==3){
		$("#tab3").show();
		$.brady.validator.validate("addForm", validator_config3); 
	}
	else{
		$("#tab4").show();
	}
});

//$(function(){
//	$.brady.validator.validate("addForm", validator_config); //初始化表单验证构架
//});
</script>

</head>

<body>
<div class="add_news">
	<div class="add_top">修改密码</div>
	<form id="addForm" action="system/account_editPassword.action" method="post">
	
    <table id="tab0" style="display:none" cellpadding="0" cellspacing="0" class="table_add">
     <tr>
      <th width="36%">键入您当前的密码</th>
      <td><input type="password" id="password0" name="password"/></td>
     </tr>
      
     <tr>
      <th width="36%">输入一个新密码</th>
      <td><input type="password" id="new_password0" name="newPassword"/></td>
     </tr>
     
     <tr>
      <th width="36%">再次输入密码以确认</th>
      <td><input type="password" id="confirm_password0" name="confirmPassword"/></td>
     </tr>
    </table>
    
    <table id="tab1" style="display:none" cellpadding="0" cellspacing="0" class="table_add">
     <tr>
      <th width="36%">键入您当前的密码</th>
      <td><input type="password" id="password1" name="password"/></td>
     </tr>
      
     <tr>
      <th width="36%">输入一个新密码</th>
      <td><input type="password" id="new_password1" name="newPassword"/></td>
     </tr>
     
     <tr>
      <th width="36%">再次输入密码以确认</th>
      <td><input type="password" id="confirm_password1" name="confirmPassword"/></td>
     </tr>
    </table>
    
        <table id="tab2" style="display:none" cellpadding="0" cellspacing="0" class="table_add">
     <tr>
      <th width="36%">键入您当前的密码</th>
      <td><input type="password" id="password2" name="password"/></td>
     </tr>
      
     <tr>
      <th width="36%">输入一个新密码</th>
      <td><input type="password" id="new_password2" name="newPassword"/></td>
     </tr>
     
     <tr>
      <th width="36%">再次输入密码以确认</th>
      <td><input type="password" id="confirm_password2" name="confirmPassword"/></td>
     </tr>
    </table>
    
    <table id="tab3" style="display:none" cellpadding="0" cellspacing="0" class="table_add">
     <tr>
      <th width="36%">键入您当前的密码</th>
      <td><input type="password" id="password3" name="password"/></td>
     </tr>
      
     <tr>
      <th width="36%">输入一个新密码</th>
      <td><input type="password" id="new_password3" name="newPassword"/></td>
     </tr>
     
     <tr>
      <th width="36%">再次输入密码以确认</th>
      <td><input type="password" id="confirm_password3" name="confirmPassword"/></td>
     </tr>
    </table>
    
    <table id="tab4" style="display:none" cellpadding="0" cellspacing="0" class="table_add">
     <tr>
      <td>用户没有登录或其他错误，请联系管理员！</td>
     </tr>
    </table>
    
    <div class="add_savebtn">
      <a href="javascript:doSave(${loginType})"><img src="images/save.gif" border="0"/></a>
      <!--a href="javascript:history.back();"><img src="images/index/back_02.gif" border="0" /></a-->
    </div>
    </form>
</div> 
 <brady:message />  
  <brady:dialog title="信用档案查询" onClickOK="doSave()" width="650" height="340"/>
  <brady:confirm />   
</body>
</html>
