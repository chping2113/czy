<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/include/core.jsp"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>


<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>" />
<title><decorator:title default="安徽项目公开网" /></title>

<link href="css/ah_main.css" rel="stylesheet" />
<link href="css/styles.css" rel="stylesheet" />
<link href="css/humanity/jquery-ui.css" rel="stylesheet" />

<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.6.min.js"></script>
<script type="text/javascript" src="js/jquery.ui.datepicker-zh-CN.js"></script>
<script type="text/javascript" src="js/jquery.brady-min.js"></script>

<decorator:head />
</head>

<body>
<div class="content">
  <div class="top">
   <div class="logo">
   		<s:if test="session.session_site.code=='anhui'"><img src="images/index/ahlogo.jpg" /></s:if>
   		<s:else><img src="zhuanlan_template/${session_site.code }/images/logo.jpg" /></s:else>
   </div>
   <s:if test="session.session_site.code=='anhui'">
   
   <div class="nav">
	 <a href="pub_index.action?message=1" id="${message=='1'||message==null?'curTab':'' }">首  页</a>
	 <a href="pub_listNewsByCatelogId.action?catelogId=17&message=2" id="${message=='2'?'curTab':'' }">组织机构</a>
	 <a href="pub_listNewsByCatelogId.action?catelogId=18&message=3" id="${message=='3'?'curTab':'' }">工作动态</a>
	 <a href="pub_navProjectPublic.action?message=4" id="${message=='4'?'curTab':'' }">项目信息公开</a>
	 <a href="pub_navCreditPublic.action?message=5" id="${message=='5'?'curTab':'' }">诚信信息公开</a> 
	 <a href="pub_listNewsByCatelogId.action?catelogId=19&message=6" id="${message=='6'?'curTab':'' }">法律法规</a> 
	 <a href="pub_showComplaint.action?message=7" id="${message=='7'?'curTab':'' }">投诉举报</a> 
	</div>
	 
	</s:if>
 </div><!--top DIV-->
 
 <div class="middle">
 	<%-- 在此插入被加载的内容 --%>
   	<decorator:body />  
 </div><!--middle DIV-->
 
 <div class="bottom">
${session_homePage.footer }

</div> <!--bottom DIV-->
 
  
</div><!--content DIV-->
</body>
</html>
