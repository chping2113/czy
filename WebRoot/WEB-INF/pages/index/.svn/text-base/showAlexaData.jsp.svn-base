<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<link href="css/zhuce.css"  rel="stylesheet" type="text/css"/>
<style type="text/css">
.nav{ width:754px; height:25px; background:url(../images/search_bg.jpg);}
.nav ul{ list-style-type:none;}

.nav ul li{ float:left; line-height:25px; text-align:center;}

.nav ul li a{ display:block; width:90px;height:25px; color:#A1CCF8; font-size:12px;  text-decoration:none;}


#curTab{display:block; color:#79280D; height:25px; background:#A1CCF8; }
</style>

<title>安徽省政府网站粘度指数监测</title>

</head>

<body>

  <div class="content">
  <div class="main_text">
    <div class="title" align="center">安徽省政府网站粘度指数监测<br /><font style="font-weight: normal;" size="2">(最近一周平均数据)</font> </div>
    
    <div class="nav">
	<ul>
	<li><a href="pub_getAlexaData.action?message=1" id="${message=='1'||message==null?'curTab':'' }">省直单位</a></li>
	<li><a href="pub_getAlexaData.action?message=2" id="${message=='2'?'curTab':'' }">市县政府</a></li>
	<li><a href="pub_getAlexaData.action?message=3" id="${message=='3'?'curTab':'' }">高等院校</a></li>
	<li><a href="pub_getAlexaData.action?message=4" id="${message=='4'?'curTab':'' }">各省(市、区)</a></li>
	<li><a href="pub_getAlexaData.action?message=5" id="${message=='5'?'curTab':'' }">中央部委</a></li>
	<li><a href="pub_getAlexaData.action?message=6" id="${message=='6'?'curTab':'' }">其他网站</a></li>
	</ul>
	</div>
    
    <table width="100%" cellspacing="0" cellpadding="0" bordercolor="#A1CCF8" border="1" style="border-collapse:collapse;">
	    <tr height="22" bgcolor="#A1CCF8" align="center">
	    	<td>
			<b>监测单位</b>
			</td>
			<td>
			<b>每百万人中访问人数</b>
			</td>
			<td>
			<b>每百万人访问页面中访问本站的页面数</b>
			</td>
			<td>
			<b>平均每个访问者浏览的页面数</b>
			</td>
	    </tr>
	    <s:iterator value="#alexaList" var="alexa">
	    <tr height="22" bgcolor="#ffffff" align="center" onmouseout="this.style.backgroundColor='#ffffff'" onmouseover="this.style.backgroundColor='#CCFFCC'" style="background-color: rgb(255, 255, 255);">
			<td>${alexa.title}</td>
			<td>${alexa.person}</td>
			<td>${alexa.page}</td>
			<td>${alexa.personPage}</td>
		</tr>
		<!--tr height="22" bgcolor="#F2F6FF" align="center" onmouseout="this.style.backgroundColor='#F2F6FF'" onmouseover="this.style.backgroundColor='#CCFFCC'" style="background-color: rgb(242, 246, 255);">
			<td>${alexa.title}</td>
			<td>${alexa.person}</td>
			<td>${alexa.page}</td>
			<td>${alexa.personPage}</td>
		</tr>  -->
		</s:iterator>
	</table>
    
    <div>
	<table width="100%" align="center">
		<tr>
		<td align="center">数据来源于Alexa官方网站</td>
		</tr>
	</table>
	</div>
    <br />
     <!-- close button -->
    	<div style="text-align:center;"><a href="javascript:close()"><img src="images/index/back.gif" border="0" /></a></div>
    
    </div>
    
   
  </div><!--content DIV-->


</body>
</html>
