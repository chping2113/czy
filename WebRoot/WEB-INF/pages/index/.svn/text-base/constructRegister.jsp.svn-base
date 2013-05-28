<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/include/core.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>项目建设单位注册</title>
<link href="css/jxw_main.css"  rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="js/jquery.brady-min.js"></script>
<script type="text/javascript" src="js/constructRegister.js"></script>
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
      <div class="twopage_left_topc"></div>
      <div class="twopage_left_P">
      <p>
       <span>一、如何注册项目建设单位帐号？</span><br />
		每个工程建设领域内的建设单位都可以在本系统内注册一个项目建设单位帐户，然后由相关的政府部门审核后，才能登录到本系统。<br /> 
		注册项目建设单位帐号时，必须按系统要求认真准确地填写各项信息，然后提交信息即可。<br /> 
		注意：为了正常使用本系统，在注册时，请一定填写一个有效的邮箱地址。
 	  </p>
	  </div>
 	</div>
 	
    </div> <!--left_middle-->
    <div class="right_middle">
    <div class="twopage_top"><span class="span_left">项目建设单位注册 </span></div>
    <div class="tousu_rightlist01">
    
    <form id="addForm" action="pub_constructRegisterAdd.action" method="post">
    <table cellpadding="0" cellspacing="0" class="tousu_table01" >
    
    <tr>
      <th width="20%">登录账号</th>
      <td><input type="text" name="construct.code" id="code" class="zhuce_list_input" maxlength="11"/>
         
      </td>
    </tr>
    
    <tr>
      <th width="20%">建设单位名称</th>
      <td><input type="text" name="construct.name" id="name" class="zhuce_list_input" maxlength="100"/>
         
      </td>
    </tr>
    
    <tr>
      <th>密码</th>
      <td><input type="password" name="construct.password" id="password" class="zhuce_list_input"/>
         
      </td>
    </tr>
    
    <tr>
      <th>密码确认</th>
      <td><input type="password" name="comfirm_pw" id="comfirm_pw" class="zhuce_list_input"/>
         
      </td>
    </tr>
    
    <tr>
      <th>组织机构代码</th>
      <td><input type="text" name="construct.concode" id="concode" class="zhuce_list_input" maxlength="11"/>
         
      </td>
    </tr>
    
    <tr>
      <th>联系人</th>
      <td><input type="text" name="construct.linkman" id="linkman" class="zhuce_list_input"  maxlength="20"/>
         
      </td>
    </tr>
    
    <tr>
      <th>联系电话</th>
      <td><input type="text" name="construct.tel" id="tel" class="zhuce_list_input"  maxlength="20"/>
         
      </td>
    </tr>
    
    <tr>
      <th>邮件</th>
      <td><input type="text" name="construct.email" id="email" class="zhuce_list_input"  maxlength="50"/>
        
      </td>
    </tr>

    </table>
    </form>
    
    <div class="zhuce_btn" align="center">
      <a href="javascript:doSave()"><img src="images/index/OK.gif" border="0"/></a>
      <a href="pub_index.action"><img src="images/index/back_02.gif" border="0" /></a>
    </div>
    
  </div>
  </div><!--content DIV-->
</div>
 <div class="bottom">
${session_homePage.footer }

</div> <!--bottom DIV-->
  </div>
  
</body>
</html>
