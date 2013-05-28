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
项目建设管理信息
</s:if>
<s:else>
十大重点示范项目公开
</s:else></title>


</head>

<body>
  <div class="content">
  
  <img src="logo_images/${projectConstruct.site.code }.jpg"  style="width: 960px;margin-top: 20px;" />
  <div class="main_text">
    <div class="title">※<s:if test="title==1">
项目建设管理信息
</s:if>
<s:else>
十大重点示范项目公开
</s:else></div>
    <div class="title_sp">
    <h4>项目信息概要</h4>
    <p>
    <table cellpadding="0" cellspacing="0" class="shengpi_list" style=" TABLE-LAYOUT:   fixed;">
    <tr>
    <td width="20%">项目编码</td>
    <td colspan="3">${projectConstruct.code }</td>
    </tr>
    <tr>
    <td>项目名称</td>
    <td colspan="3">${projectConstruct.name }</td>
    </tr>
    
    <s:if test="#projectConstruct.construct.name != ''">
    <tr>
    <td>建设单位</td>
    <td colspan="3">${projectConstruct.construct.name }</td>
    </tr>
    </s:if>
    <s:else>
    <tr>
    <td>建设单位</td>
    <td colspan="3">${projectConstruct.constructName }</td>
    </tr>
    </s:else>
    <tr>
    <td>发布机构</td>
    <td colspan="3">${projectConstruct.site.name}</td>
    </tr>
    <tr>
    <td>发布时间</td>
    <td colspan="3"><s:date name='#projectConstruct.createTime' format='yyyy-MM-dd'/></td>
    </tr>
    </table>
    </p>
    </div>
 
    <s:if test="#projectConstruct.baseInfo.constructCompany != '' 
    	|| #projectConstruct.baseInfo.manager != '' 
    	|| #projectConstruct.baseInfo.memo != '' 
    	|| #projectConstruct.baseInfo.otherCompanys != '' 
    ">
    <div class="title_sp">
    <h4>项目基本信息表</h4>
    <p>
    	<table cellpadding="0" cellspacing="0" class="shengpi_list"  style=" TABLE-LAYOUT:   fixed;" >
			
			<tr>
				<td  width="20%">建设单位</td>
				<td>
					${projectConstruct.baseInfo.constructCompany}
				</td>
				
			</tr>
			<tr>
			<td width="20%">项目投资</td>
				<td >
					${util:showAll(projectConstruct.baseInfo.money) }
				</td>
			</tr>
			<tr>
				<td width="20%">项目经理</td>
				<td >
					${projectConstruct.baseInfo.manager}
				</td>
				
			</tr>
			
			<tr>
			
				<td>项目概况</td>
				<td >
					<pre style="white-space: pre-wrap; white-space: -moz-pre-wrap;white-space: -pre-wrap;white-space: -o-pre-wrap; word-wrap: break-word;">${projectConstruct.baseInfo.memo }</pre>
				</td>
			</tr>
			<tr>
				<td>建设起始时间</td>
				<td>
					<s:date name='#projectConstruct.baseInfo.constructBeginDate'format="yyyy-MM-dd"/>
				</td>
				
			</tr>
			<tr>
			<td>建设结束时间</td>
				<td>
					<s:date name='#projectConstruct.baseInfo.constructEndDate' format="yyyy-MM-dd"/>
				</td>
			</tr>
			<tr>
			
				<td>从业单位</td>
				<td >
					${projectConstruct.baseInfo.otherCompanys}
				</td>
			
			
			</tr>
		</table>
    </p>
    </div>
    </s:if>
    
    <s:if test="#projectConstruct.bidInfo.bidItem != ''  
    	|| #projectConstruct.bidInfo.bidNotice != '' 
    	|| #projectConstruct.bidInfo.bidApporve != '' 
    	|| #projectConstruct.bidInfo.bidResult != '' 
	">
    <div class="title_sp">
    <h4>招标投标信息表</h4>
    <p>
    	<table cellpadding="0" cellspacing="0" class="shengpi_list" style=" TABLE-LAYOUT:   fixed;" >
			<tr>
				<td width="20%">招标事项</td>
				<td width="80%" >
					<pre style="white-space: pre-wrap;white-space: -moz-pre-wrap;white-space: -pre-wrap;white-space: -o-pre-wrap;word-wrap: break-word;  ">${projectConstruct.bidInfo.bidItem }</pre>
				</td>
			</tr>
			<tr>
				<td>招标公告</td>
				<td >
					<pre style="white-space: pre-wrap; white-space: -moz-pre-wrap;white-space: -pre-wrap;white-space: -o-pre-wrap; word-wrap: break-word;">${projectConstruct.bidInfo.bidNotice }</pre>
				</td>
			</tr>
			<tr>
				<td>投标资格预审公告</td>
				<td >
					<pre style="white-space: pre-wrap; white-space: -moz-pre-wrap;white-space: -pre-wrap;white-space: -o-pre-wrap; word-wrap: break-word;">${projectConstruct.bidInfo.bidApporve }</pre>
				</td>
			</tr>
			<tr>
				<td>中标结果</td>
				<td >
					<pre style="white-space: pre-wrap; white-space: -moz-pre-wrap;white-space: -pre-wrap;white-space: -o-pre-wrap; word-wrap: break-word;">${projectConstruct.bidInfo.bidResult }</pre>
				</td>
			</tr>
		</table>
    </p>
    </div>
    </s:if>
    
    <s:if test="#projectConstruct.landInfo.chargePerson != ''  
    	|| #projectConstruct.landInfo.link != '' 
    	|| #projectConstruct.landInfo.approve != '' 
    	|| #projectConstruct.landInfo.landNotice != '' 
    	|| #projectConstruct.landInfo.principle != '' 
    ">
        <div class="title_sp">
    <h4>征地拆迁信息表</h4>
    <p>
    	<table cellpadding="0" cellspacing="0" class="shengpi_list" style=" TABLE-LAYOUT:   fixed;">
			<tr>
				<td width="20%">征地拆迁负责人</td>
				<td >
					<pre style="white-space: pre-wrap; white-space: -moz-pre-wrap;white-space: -pre-wrap;white-space: -o-pre-wrap; word-wrap: break-word;">${projectConstruct.landInfo.chargePerson}</pre>
				</td>
				
			</tr>
			<tr>
			<td width="20%">负责人联系方式</td>
				<td >
					${projectConstruct.landInfo.link}
				</td>
			</tr>
			<tr>
				<td>项目用地审批意见</td>
				<td colspan="3" >
					<pre style="white-space: pre-wrap; white-space: -moz-pre-wrap;white-space: -pre-wrap;white-space: -o-pre-wrap; word-wrap: break-word;">${projectConstruct.landInfo.approve }</pre>
				</td>
			</tr>
			<tr>
				<td>项目涉及征地、拆迁公告</td>
				<td colspan="3" >
					<pre style="white-space: pre-wrap; white-space: -moz-pre-wrap;white-space: -pre-wrap;white-space: -o-pre-wrap; word-wrap: break-word;">${projectConstruct.landInfo.landNotice }</pre>
				</td>
			</tr>
			<tr>
				<td>工作方法原则</td>
				<td colspan="3" >
					<pre style="white-space: pre-wrap; white-space: -moz-pre-wrap;white-space: -pre-wrap;white-space: -o-pre-wrap; word-wrap: break-word;">${projectConstruct.landInfo.principle }</pre>
				</td>
			</tr>
			<tr>
				<td>已支付的拆迁补偿费用总额</td>
				<td colspan="3" >
					
					<pre style="white-space: pre-wrap; white-space: -moz-pre-wrap;white-space: -pre-wrap;white-space: -o-pre-wrap; word-wrap: break-word;">${util:showAll(projectConstruct.landInfo.recoupMoney) }</pre>
				</td>
			</tr>
			<!-- 
			<tr>
				<td>项目设计征地</td>
				<td colspan="3">
					${projectConstruct.landInfo.landDesign }
				</td>
			</tr> -->
		</table>
    </p>
    </div>
    </s:if>
    
    <s:if test="#projectConstruct.changesInfo.changeDate != null
    	|| #projectConstruct.changesInfo.changeResean != '' 
    	|| #projectConstruct.changesInfo.changeBasis != '' 
    	|| #projectConstruct.changesInfo.changeContent != '' 
    ">
        <div class="title_sp">
    <h4>重大设计变更信息表</h4>
    <p>
    	<table cellpadding="0" cellspacing="0" class="shengpi_list" style=" TABLE-LAYOUT:   fixed;">
			<tr>
				<td width="20%">项目变更时间</td>
				<td  colspan="3">
					<s:date name='#projectConstruct.changesInfo.changeDate' format="yyyy-MM-dd"/>
				</td>
				<!-- 
				<td width="20%">资金变更</td>
				<td width="30%">
					${projectConstruct.changesInfo.changeMoney}
				</td> -->
			</tr>
			<tr>
				<td>审批单位</td>
				<td colspan="3" >
					<pre style="white-space: pre-wrap; white-space: -moz-pre-wrap;white-space: -pre-wrap;white-space: -o-pre-wrap; word-wrap: break-word;"></pre>
				</td>
			</tr>
			<tr>
				<td>变更原因</td>
				<td colspan="3" >
					<pre style="white-space: pre-wrap; white-space: -moz-pre-wrap;white-space: -pre-wrap;white-space: -o-pre-wrap; word-wrap: break-word;">${projectConstruct.changesInfo.changeResean }</pre>
				</td>
			</tr>
			<tr>
				<td>设计变更管理依据</td>
				<td colspan="3" >
					<pre style="white-space: pre-wrap; white-space: -moz-pre-wrap;white-space: -pre-wrap;white-space: -o-pre-wrap; word-wrap: break-word;">${projectConstruct.changesInfo.changeBasis }</pre>
				</td>
			</tr>
			<tr>
				<td>变更内容</td>
				<td colspan="3" >
					<pre style="white-space: pre-wrap; white-space: -moz-pre-wrap;white-space: -pre-wrap;white-space: -o-pre-wrap; word-wrap: break-word;">${projectConstruct.changesInfo.changeContent }</pre>
				</td>
			</tr>
		</table>
    </p>
    </div>
    </s:if>
  
     <s:if test="#projectConstruct.construtInfo.oneYear != '' 
     "> 
   
        <div class="title_sp">
    <h4>施工管理信息表</h4>
    <p>
    	<table cellpadding="0" cellspacing="0" class="shengpi_list" >
			<tr>
					<td rowspan="2" >年度</td>
					<td colspan="2" >一季度</td>
					<td colspan="2" >二季度</td>
					<td colspan="2" >三季度</td>
					<td colspan="2" >四季度</td>
				</tr>
				<tr>
					<td>投资完成额(单位:万元)</td>
					<td>占总投资比重(%)</td>
					<td>投资完成额(单位:万元)</td>
					<td>占总投资比重(%)</td>
					<td>投资完成额(单位:万元)</td>
					<td>占总投资比重(%)</td>
					<td>投资完成额(单位:万元)</td>
					<td>占总投资比重(%)</td>
				</tr>
				<tr>
					<td>${projectConstruct.construtInfo.oneYear }</td>
					<td>${projectConstruct.construtInfo.yiFirPlan }</td>
					<td>${projectConstruct.construtInfo.yiFirFinish }</td>
					<td>${projectConstruct.construtInfo.yiLiangPlan }</td>
					<td>${projectConstruct.construtInfo.yiLiangFinish }</td>
					<td>${projectConstruct.construtInfo.yiThiPlan }</td>
					<td>${projectConstruct.construtInfo.yiThiFinish }</td>
					<td>${projectConstruct.construtInfo.yiForPlan }</td>
					<td>${projectConstruct.construtInfo.yiForFinish }</td>
				</tr>
				<tr>
					<td>${projectConstruct.construtInfo.twoYear }</td>
					<td>${projectConstruct.construtInfo.twoFirPlan }</td>
					<td>${projectConstruct.construtInfo.twoFirFinish }</td>
					<td>${projectConstruct.construtInfo.twoSecPlan }</td>
					<td>${projectConstruct.construtInfo.twoSecFinish }</td>
					<td>${projectConstruct.construtInfo.twoThiPlan }</td>
					<td>${projectConstruct.construtInfo.twoThiFinish }</td>
					<td>${projectConstruct.construtInfo.twoForPlan }</td>
					<td>${projectConstruct.construtInfo.twoForFinish }</td>
				</tr>
		</table>
    </p>
    </div>
</s:if>

    <s:if test="#projectConstruct.contractInfo.projectExamine != '' 
    	|| #projectConstruct.contractInfo.contractPresent != '' 
    	|| #projectConstruct.contractInfo.moneyUse != '' 
    ">
            <div class="title_sp">
    <h4>合同履约信息表</h4>
    <p>
    	<table cellpadding="0" cellspacing="0" class="shengpi_list" style=" TABLE-LAYOUT:   fixed;">
			<tr>
				<td width="20%">施工单位项目考核</td>
				<td width="80%" >
					<pre style="white-space: pre-wrap; white-space: -moz-pre-wrap;white-space: -pre-wrap;white-space: -o-pre-wrap; word-wrap: break-word;">${projectConstruct.contractInfo.projectExamine }</pre>
				</td>
			</tr>
			<tr>
				<td>参建单位主要相关人员按合同履约到场信息</td>
				<td >
					<pre style="white-space: pre-wrap; white-space: -moz-pre-wrap;white-space: -pre-wrap;white-space: -o-pre-wrap; word-wrap: break-word;">${projectConstruct.contractInfo.contractPresent }</pre>
				</td>
			</tr>
			<!--
			<tr>
				<td>建设单位按合同支付资金情况</td>
				<td>
					${projectConstruct.contractInfo.payment }
				</td>
			</tr>  -->
			<tr>
				<td>设备材料采购情况</td>
				<td>
					<pre style="white-space: pre-wrap; white-space: -moz-pre-wrap;white-space: -pre-wrap;white-space: -o-pre-wrap; word-wrap: break-word;">${projectConstruct.contractInfo.moneyUse }</pre>
				</td>
			</tr>
		</table>
    </p>
    </div>
    </s:if>
    
    <s:if test="#projectConstruct.safeCheckInfo.chargePerson != ''  
    	|| #projectConstruct.safeCheckInfo.checkContent != '' 
    ">
     <div class="title_sp">
    <h4>质量安全检查信息表</h4>
    <p>
    	<table cellpadding="0" cellspacing="0" class="shengpi_list" style=" TABLE-LAYOUT:   fixed;">
			<tr>
				<td width="20%">工程项目质量安全监督机构及质量安全监督负责人</td>
				<td width="80%" >
					${projectConstruct.safeCheckInfo.chargePerson }
				</td>
			</tr>
			<tr>
				<td>项目质量鉴定、评定结果</td>
				<td >
					<pre style="white-space: pre-wrap; white-space: -moz-pre-wrap;white-space: -pre-wrap;white-space: -o-pre-wrap; word-wrap: break-word;">${projectConstruct.safeCheckInfo.checkContent }</pre>
				</td>
			</tr>
			<!-- 
			<tr>
				<td>项目质量鉴定</td>
				<td>
					${projectConstruct.safeCheckInfo.identifyResult }
				</td>
			</tr> -->
		</table>
    </p>
    </div>
    </s:if>
    
    <s:if test="#projectConstruct.moneyInfo.moneyPresent != '' 
    	|| #projectConstruct.moneyInfo.moneyPayment != '' 
    ">
    <div class="title_sp">
    <h4>资金管理信息表</h4>
    <p>
    	<table cellpadding="0" cellspacing="0" class="shengpi_list" style=" TABLE-LAYOUT:   fixed;">
			<tr>
				<td width="20%">项目资金到位情况</td>
				<td width="80%" >
					<pre style="white-space: pre-wrap; white-space: -moz-pre-wrap;white-space: -pre-wrap;white-space: -o-pre-wrap; word-wrap: break-word;">${projectConstruct.moneyInfo.moneyPresent }</pre>
				</td>
			</tr>
			
			<tr>
				<td>项目资金使用情况</td>
				<td >
					<pre style="white-space: pre-wrap; white-space: -moz-pre-wrap;white-space: -pre-wrap;white-space: -o-pre-wrap; word-wrap: break-word;">${projectConstruct.moneyInfo.moneyPayment }</pre>
				</td>
			</tr><!-- 
			<tr>
				<td>资金概预算执行情况</td>
				<td>
					${projectConstruct.moneyInfo.budgetExecution }
				</td>
			</tr> -->
		</table>
    </p>
    </div>
    </s:if>
   
    <s:if test="#projectConstruct.acceptanceInfo.acceptanceResult != '' 
    	|| #projectConstruct.acceptanceInfo.reportCheck != '' 
    "> 
    <div class="title_sp">
    <h4>交竣工验收信息表</h4>
    <p>
    	<table cellpadding="0" cellspacing="0" class="shengpi_list" style=" TABLE-LAYOUT:   fixed;">
			<tr>
				<td width="20%">交竣工验收时间</td>
				<td >
				<s:date name='#projectConstruct.acceptanceInfo.acceptanceTime' format="yyyy-MM-dd"/>
				
				</td>
			</tr>
			<tr>
				<td>交竣工验收结果</td>
				<td >
					<pre style="white-space: pre-wrap; white-space: -moz-pre-wrap;white-space: -pre-wrap;white-space: -o-pre-wrap; word-wrap: break-word;">${projectConstruct.acceptanceInfo.acceptanceResult }</pre>
				</td>
			</tr>
			<tr>
				<td>征地补偿和移民安置、水保、环保、档案、消防等专项验收时间信息及结果信息</td>
				<td >
					<pre style="white-space: pre-wrap; white-space: -moz-pre-wrap;white-space: -pre-wrap;white-space: -o-pre-wrap; word-wrap: break-word;">${projectConstruct.acceptanceInfo.reportCheck }</pre>
				</td>
			</tr>
			<!--  
			<tr>
				<td>消防单位项目验收报告</td>
				<td>
					${projectConstruct.acceptanceInfo.fireReport }
				</td>
			</tr>
			<tr>
				<td>征地补偿和移民安置</td>
				<td>
					${projectConstruct.acceptanceInfo.supervisionReport }
				</td>
			</tr>
			<tr>
				<td>环保单位项目验收报告</td>
				<td>
					${projectConstruct.acceptanceInfo.environmentReport }
				</td>
			</tr>
			<tr>
				<td>档案验收</td>
				<td>
					${projectConstruct.acceptanceInfo.documentAcceptance }
				</td>
			</tr>
			<tr>
				<td>水保等专项验收时间及结果信息</td>
				<td>
					${projectConstruct.acceptanceInfo.acceptanceReport }
				</td>
			</tr>
			-->
			<tr>
				<td>交付使用时间</td>
				<td>
				<s:date name='#projectConstruct.acceptanceInfo.payTime' format="yyyy-MM-dd"/>
				
				</td>
			</tr>
			
		</table>
    </p>
    </div>
    </s:if>
    
    
    <s:if test="#projectConstruct.constructCompanyInfo.companyCredit != '' 
    	|| #projectConstruct.constructCompanyInfo.companyHonor != '' 
    	|| #projectConstruct.constructCompanyInfo.companyBadrecord != '' 
    "> 
    <div class="title_sp">
    <h4>从业单位行为信息表</h4>
    <p>
    	<table cellpadding="0" cellspacing="0" class="shengpi_list" style=" TABLE-LAYOUT:   fixed;">
			<tr>
				<td width="20%">信用等级信息</td>
				<td width="80%" >
					<pre style="white-space: pre-wrap; white-space: -moz-pre-wrap;white-space: -pre-wrap;white-space: -o-pre-wrap; word-wrap: break-word;">${projectConstruct.constructCompanyInfo.companyCredit }</pre>
				</td>
			</tr>
			<tr>
				<td>良好行为信息</td>
				<td >
					<pre style="white-space: pre-wrap; white-space: -moz-pre-wrap;white-space: -pre-wrap;white-space: -o-pre-wrap; word-wrap: break-word;">${projectConstruct.constructCompanyInfo.companyHonor }</pre>
				</td>
			</tr>
			<tr>
				<td>不良行为信息</td>
				<td >
					<pre style="white-space: pre-wrap; white-space: -moz-pre-wrap;white-space: -pre-wrap;white-space: -o-pre-wrap; word-wrap: break-word;">${projectConstruct.constructCompanyInfo.companyBadrecord }</pre>
				</td>
			</tr>
		</table>
    </p>
    </div>
    </s:if>
    
      <s:if test="#projectConstruct.constructPersonInfo.personHonor != '' 
    	|| #projectConstruct.constructPersonInfo.personBadrecord != '' 
      "> 
   <div class="title_sp">
    <h4>从业人员行为信息表</h4>
    <p>
    	<table cellpadding="0" cellspacing="0" class="shengpi_list" style=" TABLE-LAYOUT:   fixed;">
			<tr>
				<td width="20%">良好行为信息</td>
				<td width="80%" >
					<pre style="white-space: pre-wrap; white-space: -moz-pre-wrap;white-space: -pre-wrap;white-space: -o-pre-wrap; word-wrap: break-word;">${projectConstruct.constructPersonInfo.personHonor }</pre>
				</td>
			</tr>
			<tr>
				<td>不良行为信息</td>
				<td >
					<pre style="white-space: pre-wrap; white-space: -moz-pre-wrap;white-space: -pre-wrap;white-space: -o-pre-wrap; word-wrap: break-word;">${projectConstruct.constructPersonInfo.personBadrecord }</pre>
				</td>
			</tr>
		</table>
    </p>
    </div>
    </s:if>
    <s:if test="#projectConstruct.auditStatistics.auditStatistics != '' && #projectConstruct.auditStatistics.auditStatistics != null"> 
   <div class="title_sp">
    <h4>审计统计结果信息表</h4>
    <p>
    	<table cellpadding="0" cellspacing="0" class="shengpi_list" style=" TABLE-LAYOUT:   fixed;">
			<tr>
				<td width="20%">审计统计结果信息</td>
				<td width="80%" >
					<pre style="white-space: pre-wrap; white-space: -moz-pre-wrap;white-space: -pre-wrap;white-space: -o-pre-wrap; word-wrap: break-word;">${projectConstruct.auditStatistics.auditStatistics }</pre>
				</td>
			</tr>
		</table>
    </p>
    </div>
    </s:if>
    
    
    
    </div>    <!-- close button -->
    	<div style="text-align:center;"><a href="javascript:close()"><img src="images/index/back.gif" border="0" /></a></div>
    
  </div><!--content DIV-->


</body>
</html>
