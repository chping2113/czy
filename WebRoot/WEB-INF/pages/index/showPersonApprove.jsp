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
<link href="css/xydengji.css"  rel="stylesheet" type="text/css"/>

<title>从业个人信用档案</title>

</head>

<body>
  <div class="content_dj">
        <div class="content_topbg"></div>

   <div class="main_text_da">
    <div class="title_dj1"> 安徽省工程建设领域从业个人信用档案</div>
    <div class="title_h401">从业个人基本信息</div>
    
    <table cellpadding="0" cellspacing="0" class="shengpi_list01" >
    <tr>
    <th width="15%">姓名</th>
    <td width="35%">${per.name }</td>
    <th width="15%">性别</td>
    <td width="35%">${per.sex=='m'?'男':'女'}</td>
    </tr>
    <tr>
	  <th>证件类型</td>
	  <td>${per.certificateType=='a'?'身份证':'证件' }</td>
	  <th>证件号码</td>
	  <td>${per.certificateCode }</td>
	  </tr>
	 <tr>
	  <th>联系电话</td>
	  <td>${per.tel }</td>
	  <th>邮件</td>
	  <td>${per.email }</td>
	  </tr>
    </table>
    <s:if test="#personQualificationList.size > 0">
    <div class="title_h401">执业资格证</div>
    <s:iterator value="personQualificationList" var="personQualification">
   <table cellpadding="0" cellspacing="0" class="shengpi_list01" >
    <tr>
      <th width="15%">证书名称</td>
    <td width="35%">${personQualification.name }</td>
    <th width="15%">编号</td>
    <td width="35%">${personQualification.code }</td>
    </tr>
    <tr>
      <th>有效起始日期</th>
    <td><s:date name="#personQualification.beginDate" format="yyyy-MM-dd"/></td>
    <th>有效到期日期</th>
    <td><s:date name="#personQualification.endDate" format="yyyy-MM-dd"/></td>
    </tr>
    <tr>
      <th>核发机关</th>
    <td>${personQualification.auditOrgan }</td>
    <th>核发日期</th>
    <td><s:date name="#personQualification.auditDate" format="yyyy-MM-dd"/></td>
    </tr>
    <tr>
     <th>证书状态</th>
    <td colspan="3">${personQualification.qualificationState }</td>
    </tr>
    </table>
    </s:iterator>
    </s:if>
    
    <s:if test="#personHonorList.size > 0">
    <div class="title_h401">良好行为信息</div>
    <s:iterator value="personHonorList" var="personHonor">
   <table cellpadding="0" cellspacing="0" class="shengpi_list01" >
    <tr>
      <th width="15%">发布机构</th>
    <td width="35%">${personHonor.site.name }</td>
    <th width="15%">颁发机构</th>
    <td width="35%">${personHonor.honorOrgan }</td>
    </tr>
    <tr>
      <th>荣誉文书编号</th>
    <td>${personHonor.honorCode }</td>
    <th>荣誉认证日期</th>
    <td><s:date name="#personHonor.honorDate" format="yyyy-MM-dd"/></td>
    </tr>
    <tr>
      <th>荣誉内容</th>
    <td colspan="3">${personHonor.honorContent }</td>
    </tr>
    </table>
    </s:iterator>
    </s:if>
    
    <s:if test="#personBadrecordList.size > 0">
    <div class="title_h401">不良行为信息</div>
    <s:iterator value="personBadrecordList" var="personBadrecord">
    <s:if test="#personBadrecord.type == 1">
    <table cellpadding="0" cellspacing="0" class="shengpi_list01" >
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
    <td>${personBadrecord.personIllegal.punishObject }</td>
    </tr>
    <tr>
    <th>执行期限</th>
    <td>${personBadrecord.personIllegal.executionPeriod }</td>
    <th>法院判决结果</th>
    <td>${personBadrecord.personIllegal.adjudgeResult }</td>
    </tr>
    </table>
    </s:if>
    
    <s:elseif test="#personBadrecord.type == 2">
    <table cellpadding="0" cellspacing="0" class="shengpi_list01" >
    <tr>
    <th width="15%">不良行为类型</th>
    <td width="35%">行政处罚信息</td>
    <th width="15%">发布机构</th>
    <td width="35%">${personBadrecord.site.name }</td>
    </tr>
    <tr>
    <th>处罚种类</th>
    <td>${personBadrecord.personPunish.punishType }</td>
    <th>处罚机关</th>
    <td>${personBadrecord.personPunish.punishOrgan }</td>
    </tr>
    <tr>
    <th>处罚对象</th>
    <td>${personBadrecord.personPunish.punishObject }</td>
    <th>处罚事由</th>
    <td>${personBadrecord.personPunish.punishReason }</td>
    </tr>
    <tr>
    <th>处罚依据</th>
    <td>${personBadrecord.personPunish.punishGist }</td>
    <th>处罚内容</th>
    <td>${personBadrecord.personPunish.punishContent }</td>
    </tr>
    <tr>
    <th>处罚日期</th>
    <td><s:date name="#personBadrecord.personPunish.punishDate" format="yyyy-MM-dd"/></td>
    <th>处罚执行情况</th>
    <td>${personBadrecord.personPunish.punishExecution }</td>
    </tr>
    </table>
    </s:elseif>
    </s:iterator>
    </s:if>
    
    </div>
  
        <div class="content_topbg"></div>
  </div>
  </div><!--content DIV-->
</body>
</html>
