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

<title>项目公开新闻</title>

</head>

<body>
  <div class="content">
   <s:if test="#news.createUser.site.code!=340000099">
  <img src="logo_images/${news.createUser.site.code }.jpg"  style="width: 960px;margin-top: 20px;" />
  </s:if>
  <s:else>
  <img src="logo_images/340000000.jpg"  style="width: 960px;margin-top: 20px;" />
  </s:else>
  <div class="main_text">
    <div class="title">※${news.catelog.title }</div>
    <div class="news_content">
    <div class="title_h3">${news.title }</div>
    <p class="p_note"><span>「来源：${news.orgFrom }」</span><span>「发布日期：<s:date name="#news.createTime" format="yyyy-MM-dd"/>」</span><span>「阅读次数：${news.hitCount }次」</span><span>「管理员：${news.createUser.code }」</span><span>「发布机构：${news.createUser.site.name }」</span></p> 
    <p class="p_body">${news.content }</p>
     <s:if test="#attachFileList!=null">附件：</s:if>
    <s:iterator value="#attachFileList" var="attachFile" status="statusb" >
    	<br/> <a href="info/download.action?id=${id }">${attachFile.realName }</a> 
    </s:iterator>
    </div>
    
     <!-- close button -->
    	<div style="text-align:center;"><a href="javascript:close()"><img src="images/index/back.gif" border="0" /></a></div>
    
    </div>
    
   
  </div><!--content DIV-->


</body>
</html>
