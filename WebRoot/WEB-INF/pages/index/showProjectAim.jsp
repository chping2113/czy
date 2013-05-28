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


<title>

招投标信息

</title>

</head>

<body>
  <div class="content">
    
  <img src="logo_images/${projectAim.site.code }.jpg"  style="width: 960px;margin-top: 20px;" />
  <div class="main_text">
    <div class="title">※
招投标信息</div>
    <div class="title_sp">
    <h4>项目信息概要</h4>
    <p>
    <table cellpadding="0" cellspacing="0" class="shengpi_list" >
    <tr>
    <th width="15%">项目编码</th>
    <td >${projectAim.code }</td>
    </tr>
    <tr>
    <th width="15%">项目名称</th>
    <td>${projectAim.name }</td>  
    </tr>   
    <tr>
    <th width="15%">建设单位</th>
    <td>${projectAim.constructName}</td>  
    </tr>   
    <tr>
    <th>发布机构</th>
    <td width="35%">${projectAim.site.name }</td>
    </tr>
    <tr>
    <th>发布时间</th>
    <td><s:date name='#projectAim.createTime' format='yyyy-MM-dd'/></td>
    </tr>
    </table>
    </p>
    </div>
    <s:if test="#projectAim.aimItem != ''">
    <div class="title_sp">
    <h4>招标事项</h4>
    <p ><pre style="white-space: pre-wrap; white-space: -moz-pre-wrap;white-space: -pre-wrap;white-space: -o-pre-wrap; word-wrap: break-word;">${projectAim.aimItem }</pre></p>
    </div>
    </s:if>
    
    
    
    <s:if test="#projectAim.notice != ''">
        <div class="title_sp">
    <h4>招标公告</h4>
    <p><pre style="white-space: pre-wrap; white-space: -moz-pre-wrap;white-space: -pre-wrap;white-space: -o-pre-wrap; word-wrap: break-word;">${projectAim.notice }</pre></p>
    </div>
    </s:if>
    
    <s:if test="#projectAim.statusNotice != ''">
        <div class="title_sp">
    <h4>投标资格预审公告</h4>
    <p><pre style="white-space: pre-wrap; white-space: -moz-pre-wrap;white-space: -pre-wrap;white-space: -o-pre-wrap; word-wrap: break-word;">${projectAim.statusNotice }</pre></p>
    </div>
    </s:if>
    
    <s:if test="#projectAim.bidResult != ''">
        <div class="title_sp">
    <h4>中标结果</h4>
    <p><pre style="white-space: pre-wrap; white-space: -moz-pre-wrap;white-space: -pre-wrap;white-space: -o-pre-wrap; word-wrap: break-word;">${projectAim.bidResult }</pre></p>
    </div>
    </s:if>
    
    
    </div>    <!-- close button -->
    	<div style="text-align:center;"><a href="javascript:close()"><img src="images/index/back.gif" border="0" /></a></div>
    
  </div><!--content DIV-->
  <brady:query paramName="queryCode"/>
</body>
</html>
