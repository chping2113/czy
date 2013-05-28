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

<s:if test="title==1">
项目审批信息
</s:if>
<s:else>
十大重点示范项目公开
</s:else>
</title>

</head>

<body>
  <div class="content">
  <img src="logo_images/${projectApprove.site.code }.jpg"  style="width: 960px;margin-top: 20px;" />
  <div class="main_text">
    <div class="title">※<s:if test="title==1">
项目审批信息
</s:if>
<s:else>
十大重点示范项目公开
</s:else></div>
    <div class="title_sp">
    <h4>项目信息概要</h4>
    <p>
    <table cellpadding="0" cellspacing="0" class="shengpi_list" >
    <tr>
    <th width="15%">项目编码</th>
    <td >${projectApprove.code }</td>
    </tr>
    <tr>
    <th width="15%">项目名称</th>
    <td>${projectApprove.name }</td>  
    </tr>   
    <tr>
    <th width="15%">建设单位</th>
    <td>${projectApprove.constructName}</td>  
    </tr>   
    <tr>
    <th>发布机构</th>
    <td width="35%">${projectApprove.site.name }</td>
    </tr>
    <tr>
    <th>发布时间</th>
    <td><s:date name='#projectApprove.createTime' format='yyyy-MM-dd'/></td>
    </tr>
    </table>
    </p>
    </div>
    <s:if test="#projectApprove.plan != '' && #projectApprove.plan != null ">
    <div class="title_sp">
    <h4>项目规划审批结果信息</h4>
    <p ><pre style="white-space: pre-wrap; white-space: -moz-pre-wrap;white-space: -pre-wrap;white-space: -o-pre-wrap; word-wrap: break-word;">${projectApprove.plan }</pre></p>
    
    <s:if test="#planOrganName!=null && #planOrganName != ''">
    <p  style="margin-right:100px;" align="right">	—— ${planOrganName }</p>
    </s:if>
    <s:else>
    <p  style="margin-right:100px;" align="right">	—— ${projectApprove.site.name }</p>
    </s:else>
    </div>
    </s:if>
    <s:if test="#projectApprove.propose != '' && #projectApprove.propose != null ">
    <div class="title_sp">
    <h4>项目建议书批复结果信息</h4>
    <p ><pre style="white-space: pre-wrap; white-space: -moz-pre-wrap;white-space: -pre-wrap;white-space: -o-pre-wrap; word-wrap: break-word;">${projectApprove.propose }</pre></p>
    
    <s:if test="#proposeOrganName!=null && #proposeOrganName != ''">
    <p  style="margin-right:100px;" align="right">	—— ${proposeOrganName }</p>
    </s:if>
    <s:else>
    <p  style="margin-right:100px;" align="right">	—— ${projectApprove.site.name }</p>
    </s:else>
    </div>
    </s:if>
    
    
    
    <s:if test="#projectApprove.feasibility != '' && #projectApprove.feasibility != null ">
        <div class="title_sp">
    <h4>可行性研究报告批复结果(资金报告批复结果信息)</h4>
    <p><pre style="white-space: pre-wrap; white-space: -moz-pre-wrap;white-space: -pre-wrap;white-space: -o-pre-wrap; word-wrap: break-word;">${projectApprove.feasibility }</pre></p>
   <s:if test="#feasibilityOrganName!=null && #feasibilityOrganName != ''">
    <p  style="margin-right:100px;" align="right">	—— ${feasibilityOrganName }</p>
    </s:if>
    <s:else>
    <p  style="margin-right:100px;" align="right">	—— ${projectApprove.site.name }</p>
    </s:else>
   
    </div>
    </s:if>
      
    <s:if test="#projectApprove.approveResult != '' && #projectApprove.approveResult != null">
    <div class="title_sp">
    <h4>项目核准结果信息</h4>
    <p><pre style="white-space: pre-wrap; white-space: -moz-pre-wrap;white-space: -pre-wrap;white-space: -o-pre-wrap; word-wrap: break-word;">${projectApprove.approveResult }</pre></p>
     <s:if test="#approveResultOrganName!=null && #approveResultOrganName != ''">
    <p  style="margin-right:100px;" align="right">	—— ${approveResultOrganName }</p>
    </s:if>
    <s:else>
    <p  style="margin-right:100px;" align="right">	—— ${projectApprove.site.name }</p>
    </s:else>
    
    </div>
    </s:if>
    <s:if test="#projectApprove.design != '' &&  #projectApprove.design != null ">
        <div class="title_sp">
    <h4>设计方案报告批复结果</h4>
    <p><pre style="white-space: pre-wrap; white-space: -moz-pre-wrap;white-space: -pre-wrap;white-space: -o-pre-wrap; word-wrap: break-word;">${projectApprove.design }</pre></p>
    <s:if test="#designOrganName!=null && #designOrganName != ''">
    <p  style="margin-right:100px;" align="right">	—— ${designOrganName }</p>
    </s:if>
    <s:else>
    <p  style="margin-right:100px;" align="right">	—— ${projectApprove.site.name }</p>
    </s:else>
   
    </div>
    </s:if>
    
    <s:if test="#projectApprove.energy != '' && #projectApprove.energy != null ">
        <div class="title_sp">
    <h4>节能评估审查批复结果信息</h4>
    <p><pre style="white-space: pre-wrap; white-space: -moz-pre-wrap;white-space: -pre-wrap;white-space: -o-pre-wrap; word-wrap: break-word;">${projectApprove.energy }</pre></p>
   <s:if test="#energyOrganName!=null && #energyOrganName != ''">
    <p  style="margin-right:100px;" align="right">	—— ${energyOrganName }</p>
    </s:if>
    <s:else>
    <p  style="margin-right:100px;" align="right">	—— ${projectApprove.site.name }</p>
    </s:else>
    
    </div>
    </s:if>
    
    <s:if test="#projectApprove.address != ''  && #projectApprove.address != null ">
        <div class="title_sp">
    <h4>规划选址意见批复结果信息</h4>
    <p><pre style="white-space: pre-wrap; white-space: -moz-pre-wrap;white-space: -pre-wrap;white-space: -o-pre-wrap; word-wrap: break-word;">${projectApprove.address }</pre></p>
   <s:if test="#addressOrganName!=null && #addressOrganName != ''">
    <p  style="margin-right:100px;" align="right">	—— ${addressOrganName }</p>
    </s:if>
    <s:else>
    <p  style="margin-right:100px;" align="right">	—— ${projectApprove.site.name }</p>
    </s:else>
    </div>
    </s:if>
    
    <s:if test="#projectApprove.land != '' && #projectApprove.land != null ">
    <div class="title_sp">
    <h4>用地批复文件结果信息</h4>
    <p><pre style="white-space: pre-wrap; white-space: -moz-pre-wrap;white-space: -pre-wrap;white-space: -o-pre-wrap; word-wrap: break-word;">${projectApprove.land }</pre></p>
  
	<s:if test="#landOrganName!=null && #landOrganName != ''">
    <p  style="margin-right:100px;" align="right">	—— ${landOrganName }</p>
    </s:if>
    <s:else>
    <p  style="margin-right:100px;" align="right">	—— ${projectApprove.site.name }</p>
    </s:else>

    </div>
    </s:if>
    
    <s:if test="#projectApprove.environment != '' && #projectApprove.environment != null">
    <div class="title_sp">
    <h4>环境影响评价审批结果信息</h4>
    <p><pre style="white-space: pre-wrap; white-space: -moz-pre-wrap;white-space: -pre-wrap;white-space: -o-pre-wrap; word-wrap: break-word;">${projectApprove.environment }</pre></p>
  
	<s:if test="#environmentOrganName!=null && #environmentOrganName != ''">
    <p  style="margin-right:100px;" align="right">	—— ${environmentOrganName }</p>
    </s:if>
    <s:else>
    <p  style="margin-right:100px;" align="right">	—— ${projectApprove.site.name }</p>
    </s:else>

    </div>
    </s:if>
    
    
    <s:if test="#projectApprove.startReports != '' && #projectApprove.startReports != null">
    <div class="title_sp">
    <h4>施工许可(开工报告)审批信息</h4>
    <p><pre style="white-space: pre-wrap; white-space: -moz-pre-wrap;white-space: -pre-wrap;white-space: -o-pre-wrap; word-wrap: break-word;">${projectApprove.startReports }</pre></p>
  
	<s:if test="#startReportsOrganName!=null && #startReportsOrganName != ''">
    <p  style="margin-right:100px;" align="right">	—— ${startReportsOrganName }</p>
    </s:if>
    <s:else>
    <p  style="margin-right:100px;" align="right">	—— ${projectApprove.site.name }</p>
    </s:else>

    </div>
    </s:if>
  
  
    </div>    <!-- close button -->
    	<div style="text-align:center;"><a href="javascript:close()"><img src="images/index/back.gif" border="0" /></a></div>
    
  </div><!--content DIV-->
  <brady:query paramName="queryCode"/>
</body>
</html>
