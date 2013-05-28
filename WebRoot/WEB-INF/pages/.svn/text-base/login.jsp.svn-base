<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/include/core.jsp"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理登录</title>
<link href="css/login.css"  rel="stylesheet" type="text/css"/>
	<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
	<script type="text/javascript" src="js/verifyCode.js"></script>
	<script type="text/javascript">

		function doSubmit() {
			//if($.brady.validator.validateForm("loginForm")) {
				$("#loginForm").submit();
			//}
			
		}
		function changeKey(){
			  if (event.keyCode==13) { 
				  doSubmit();
			  } 
		}
		
	</script>
</head>

<body >
<div class="content">
<div style="width:880px; margin:0px auto;">
 <div class="main_img">
   <div class="login_text">
     <div class="login_top"> 后台管理登录</div>
     <div class="login_bottom">
     <form id="loginForm" action="pub_login.action" method="post">
       <div class="err_msg">&nbsp;${message }</div>
       <div class="bottom_p">
         <p>用户名
             <input name="code" type="text" value="" class="input" />
         </p>
         <p>密<span>码</span>
             <input name="password" type="password" value=""  class="input" onkeydown="changeKey()"/>
         </p>
        
        <!-- <p>类<span>型</span>   -->
         <%-- 
             <input name="state" type="radio" value="0" ${(empty state) or (state == 0) ? "checked" : "" }/>政府部门
             <input name="state" type="radio" value="1" ${state == 1 ? "checked" : "" }/>从业单位
             <input name="state" type="radio" value="2" ${state == 2 ? "checked" : "" }/>从业个人
         --%>
             <!--  <select name="state" class="input">
             	<option value="0" ${(empty state) or (state == 0) ? "selected" : "" }>政府机关单位</option>
             	<option value="3" ${state == 3 ? "selected" : "" }>项目建设单位</option>
             	<option value="1" ${state == 1 ? "selected" : "" }>从业单位</option>
             	<option value="2" ${state == 2 ? "selected" : "" }>从业个人</option>
             </select>
         </p>-->
         <!-- 屏蔽验证码 -->
         
       <p>
         
                                        验证码<span></span>        
          <input type="text" height="20" name="rand" size="10" >  
          <img alt="code..." name="input" id="randImage"   src="image.jsp" width="70" height="20" border="1" align="absmiddle">
      
          <a href="javascript:loadimage(0);" style="text-decoration:none"><font color="#fbdc4e">看不清点我</font></a>  
        
         </p>   
         
         <div class="login_btn"><a href="javascript:doSubmit()" ><img src="images/login/login.gif" /></a></div>
       </div>
     </form>
       <p class="botton_text">版本 2011V2.1</p>
       <%-- 
       <p><a href="pub_dataImport.action?message=shenpi" target="_blank">数据导入</a></p>
       --%>
     </div>
     <div class="alpha_bg"></div>
   </div>
 </div>

</div>
</div>
</body>
</html>
