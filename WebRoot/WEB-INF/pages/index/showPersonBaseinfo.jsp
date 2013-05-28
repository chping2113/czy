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


<title>个人基本信息</title>

</head>

<body>
  <div class="content">
     <div class="top">
      <img src="images/index/guohui02.png" /> <span>安徽项目公开网</span>    </div>
  <div class="main_text">
    <div class="title">※ 个人基本信息</div>
    <table cellpadding="0" cellspacing="0" class="shengpi_list" >
    <tr>
    <th width="15%">姓名</th>
    <td colspan="3">${personBaseinfo.name }</td>
    </tr>
    <tr>
    <th>个人代码</th>
    <td>${personBaseinfo.code }</td>
    <th>所属单位</th>
    <td>${personBaseinfo.dept }</td>
    </tr>
    <tr>
    <th>性别</th>
    <td>${personBaseinfo.sex }</td>
    <th width="15%">证件类型</th>
    <td width="35%">${personBaseinfo.certificateType}</td>
    </tr> <tr>
    
    <th>证件号码</th>
    <td width="35%">${personBaseinfo.certificateCode }</td>
    <th>联系电话</th>
    
    <td width="35%">${personBaseinfo.tel }</td>
    
    </tr>
    <tr>
    
    <th>审核机构</th>
    <td width="35%"></td>
    <th>审核状态</th>
    
    <td width="35%">
    <s:if test="#personBaseinfo.state==0">未审核</s:if>
    <s:elseif test="#personBaseinfo.state==1">审核通过</s:elseif>
    <s:elseif test="#personBaseinfo.state==2">审核未通过</s:elseif>
    </td>
    
    </tr>
    <tr>
    <th>注册时间</th>
    <td width="35%"><s:date name='#personBaseinfo.registerTime' format='yyyy-MM-dd'/></td>
    <th>是否有效</th>
    <td width="35%">
    <s:if test="#personBaseinfo.validState==0">无效</s:if>
    <s:elseif test="#personBaseinfo.validState==1">有效</s:elseif>
    </td>
    </tr>
    </table>
    
    <br/>
    <!-- close button -->
    	<div style="text-align:center;"><a href="javascript:close()"><img src="images/index/back.gif" border="0" /></a></div>
    
    </div>
  </div><!--content DIV-->
  <brady:query paramName="queryCode"/>
</body>
</html>
