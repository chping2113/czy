<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/include/core.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>忘记密码</title>
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="js/jquery.brady-min.js"></script>
<link href="css/jxw_main.css"  rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="js/password.js"></script>

<script type="text/javascript">
	$(function(){
		$.brady.validator.validate("addForm", validator_config); //初始化表单验证构架
	});
</script>
</head>

<body>
<div class="content">
<jsp:include page="${headPath }" />
<div class="middle">
    <div class="left_middle">
    
    <div class="twopage_left">
      <div class="twopage_left_toppwd"></div>
      <div class="twopage_left_P">
      <p>
       <span>一、如何找回密码？</span><br />
	   如果您忘记了本系统的登录密码，可以通过使用“找回密码”功能来取回系统的密码。<br/>首先在找回密码界面上输入您的用户名，
	   然后输入你注册账号时使用的邮箱，系统出于安全性要求，会为您重新分配一个新密码，然后把密码发送到您注册帐户时所指定的邮箱中。<br/>
	 建议您通过新密码登录系统后，重新设定您的登录密码。<br /> 
 	  </p>
	  </div>
 	</div>
 	
    </div> <!--left_middle-->
    <div class="right_middle">
    <div class="twopage_top"><span class="span_left">${loginType == 0 ? "帐户" : (loginType == 1 ? "帐户" : (loginType == 2 ? "账户" : "帐户")) }找回密码</span></div>
    <div class="tousu_rightlist01">
    
  <form id="addForm" action="pub_subPassword.action" method="post">
    <table cellpadding="0" cellspacing="0" class="tousu_table01" >
    	<tr>
      		<th width="20%">帐号:</th>
      		<td><input type="text" name="code" id="username" class="zhuce_list_input" maxlength="20"/>
      		</td>
    	</tr>
    	<tr>
      		<th width="20%">邮箱:</th>
      		<td><input type="text" name="email" id="useremail" class="zhuce_list_input" maxlength="50"/>
      		</td>
    	</tr>
		<tr>
      		<th width="20%">类型:</th>
      		<td>
      			<label><input type="radio" name="state" value="0" id="RadioGroup_0" class="user_text_radio" ${(empty state or state == 0) ? "checked" : "" }/>政府机关单位</label>
           		<label><input type="radio" name="state" value="3" id="RadioGroup_1" class="user_text_radio" ${state == 3 ? "checked" : "" }/>项目建设单位</label>
           		<label><input type="radio" name="state" value="1" id="RadioGroup_1" class="user_text_radio" ${state == 1 ? "checked" : "" }/>从业单位</label>
           		<label><input type="radio" name="state" value="2" id="RadioGroup_2" class="user_text_radio" ${state == 2 ? "checked" : "" }/>从业个人</label>
      		</td>
    	</tr>
    </table>
  </form>
  <div class="img_ok" align="center">
  	<a href="javascript:doSave()"><img src="images/index/OK.gif"/></a>
  	<a href="javascript:history.back()"><img src="images/index/back_02.gif" border="0" /></a>
  </div>
  </div>
  </div><!--content DIV-->
</div>
 <div class="bottom">
${session_homePage.footer }

</div> <!--bottom DIV-->
</div><!--content DIV-->

</body>
</html>
