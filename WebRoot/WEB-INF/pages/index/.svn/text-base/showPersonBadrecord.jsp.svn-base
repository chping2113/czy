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
     <div class="top">
      <img src="images/index/guohui02.png" /> <span>安徽项目公开网</span>    </div>
  <div class="main_text">
    <div class="title">※良好信用信息公开  &gt; ${personBadrecord.person.name }</div>
    <div class="title_h4">（一）个人基本信息</div>
    
    <table cellpadding="0" cellspacing="0" class="shengpi_list" >
    <tr>
    <th width="15%">姓名</th>
    <td width="35%">${personBadrecord.person.name }</td>
    <th width="15%">性别</th>
    <td width="35%">${personBadrecord.person.sex=='m'?'男':'女'}</td>
    </tr>
    <tr>
    <th>证件类型</th>
    <td>${personBadrecord.person.certificateType=='a'?'身份证':'证件' }</td>
    <th>证件号码</th>
    <td>${personBadrecord.person.certificateCode }</td>
    </tr>
    <tr>
      <th>联系电话</th>
      <td>${personBadrecord.person.tel }</td>
      <th>邮件</th>
      <td>${personBadrecord.person.email }</td>
    </tr>
    </table>
    <div class="title_h4">（二）个人不良行为信息</div>
    <s:if test="#personBadrecord.type == 1">
   <table cellpadding="0" cellspacing="0" class="shengpi_list" >
    <tr>
      <th width="15%">不良行为类型</th>
    <td width="35%">违法信息</td>
    <th width="15%">发布机构</th>
    <td width="35%">${personBadrecord.site.name }</td>
    </tr>
    <tr>
      <th>判决机关</th>
    <td>${personBadrecord.personIllegal.adjudgeOrgan }</td>
    <th>处罚对象</th>
    <td>${personBadrecord.personIllegal.executionPeriod }</td>
    </tr>
    <tr>
     <th>法院判决结果</th>
    <td colspan="3">${personBadrecord.personIllegal.adjudgeResult }</td>
    </tr>
    </table>
    </s:if>
    <s:elseif test="#personBadrecord.type == 2">
    <table cellpadding="0" cellspacing="0" class="shengpi_list" >
    <tr>
      <th width="15%">不良行为类型</th>
    <td width="35%">个人行政处罚信息</td>
    <th width="15%">发布机构</th>
    <td width="35%">${personBadrecord.site.name }</td>
    </tr>
    <tr>
      <th>处罚机关</th>
    <td>${personBadrecord.personPunish.punishOrgan }</td>
    <th>处罚对象</th>
    <td>${personBadrecord.personPunish.punishObject }</td>
    </tr>
    <tr>
      <th>处罚事由</th>
    <td>${personBadrecord.personPunish.punishReason }</td>
    <th>处罚种类</th>
    <td>${personBadrecord.personPunish.punishType }</td>
    </tr>
    <tr>
      <th>处罚日期</th>
    <td><s:date name="#personBadrecord.personPunish.punishDate" format="yyyy-MM-dd" /></td>
    <th>处罚执行情况</th>
    <td>${personBadrecord.personPunish.punishExecution }</td>
    </tr>
    <tr>
      <th>处罚依据</th>
    <td>${personBadrecord.personPunish.punishGist }</td>
    <th>处罚内容</th>
    <td>${personBadrecord.personPunish.punishContent }</td>
    </tr>
    </table>
    </s:elseif>
    </div>
  </div><!--content DIV-->
</body>
</html>
