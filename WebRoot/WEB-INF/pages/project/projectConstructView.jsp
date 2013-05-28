<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/include/core.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>安徽项目公开网-项目公开信息</title>
	<script type="text/javascript">

	function doSubmit(approveState){
		$("#approveState").val(approveState);
		$("#projectConstructAddForm").submit();
	}
	</script>
	<style type="text/css">
		label {
			padding:8px 0px 8px 3px;
			/*font-weight:bolder;*/
		}
	</style>
</head>
<body>
   <div class="right_main">
   <s:if test="type==8">
    <div class="add_top">发布重点项目&nbsp;&gt;查看</div>
    </s:if>
   <s:else>
   
    <div class="add_top">发布项目公开信息&nbsp;&gt;&nbsp;发布建设管理信息&nbsp;&gt;查看</div>
   </s:else>
     <div id="projectBaseDiv">
     <br/>
    <img src="images/left_go.gif"/><label  style="margin-top: 3px;margin-bottom: 10px;">项目信息概要</label>
		<table cellpadding="0" cellspacing="0" class="table_add" style="margin-top: 3px;margin-bottom: 10px;TABLE-LAYOUT:fixed; ">
		
    
      <tr>
      <td  width="15%">项目编号</td>
      <td>	
      ${code }
	  	
	  </td>
      </tr>
     <tr>
      <td>项目名称</td>
      <td>
      ${name }
	  </td>
      </tr> 
      <s:if test="construct.name != ''">	
     <tr>
      <td width="15%">建设单位</td>
      <td>
    ${construct.name }
   
     
	  </td>
      </tr>  
      </s:if>
      <s:else>
      
      <tr>
      <td width="15%">建设单位</td>
      <td>
    ${constructName }
   
     
	  </td>
      </tr>  
      
      
      </s:else>
      <tr>
      <td width="15%">
      <s:if test="session.loginUser==null">审核机构
   
   </s:if>
   <s:else>
    发布机构
   
   </s:else>
      </td>
      <td>
     
      	${site.name }
	  </td>
      </tr>
      <tr>
      <td>发布时间</td>
      <td><s:date name="createTime" format="yyyy-MM-dd"/></td>
      </tr>
      
      
      <s:if test="construct == null">	
       <tr>
      <td >发布人员</td>
      <td>
      <s:if test="type==1">
	  	
            姓名:${session.loginUser.name }&nbsp;&nbsp;帐号:${session.loginUser.code }
	  	</s:if>
	  	<s:else>
            姓名:${createUser.name }&nbsp;&nbsp;帐号:${createUser.code }
	  	
	  	
	  	</s:else>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	  
	  </td>
      </tr> 
      </s:if>
      
     <tr>
      <td>审核人员</td>
      <td>
      
      <s:if test="approveUser!=null">
         姓名:${approveUser.name }&nbsp;&nbsp;帐号:${approveUser.code }
      </s:if>
   <s:else>
   所有审核人员
   </s:else>
	  </td>
      </tr>
		</table>
	</div>
	 <form action="project/projectConstruct_add.action" id="projectConstructAddForm" method="post">
    <div id="baseInfoDiv">
    <img src="images/left_go.gif"/><label>基本信息表</label>
		<table cellpadding="0" cellspacing="0" class="table_add" style="margin-top: 3px;margin-bottom: 10px;TABLE-LAYOUT:fixed;">
			
			<tr>
				<td  width="15%">建设单位</td>
				<td>
					${projectConstruct.baseInfo.constructCompany}
				</td>
				
			</tr>
			<tr>
			<td>项目投资</td>
				<td >
					${util:showAll(projectConstruct.baseInfo.money) }
				</td>
			</tr>
			
			<tr>
				<td >项目经理</td>
				<td ><input type="hidden" name="id" id="id" value="${projectConstruct.id }"/>
					<input type="hidden" name="projectId" id="projectId" value="${projectId }"/>
					<input type="hidden" name="approveState" id="approveState" value="0"/>
					<input type="hidden" name="type" id="type" value="${type }"/>
					${projectConstruct.baseInfo.manager}
				</td>
				
			</tr>
			
			<tr>
			<td>项目概况</td>
				<td >    
				<pre>${projectConstruct.baseInfo.memo }</pre>
	  	
					
				</td>
			</tr>
			<tr>
				<td >建设起始时间</td>
				<td>
					<s:date name='projectConstruct.baseInfo.constructBeginDate' format="yyyy-MM-dd"/>
				</td>
				
			</tr>
			<tr>
			<td >建设结束时间</td>
				<td>
					<s:date name='projectConstruct.baseInfo.constructEndDate' format="yyyy-MM-dd"/>
				</td>
			</tr>
			<tr>
			<td >从业单位</td>
				<td  >
					${projectConstruct.baseInfo.otherCompanys}
				</td>
			
				
			</tr>
		</table>
	</div>
	
	<div id="bidInfoDiv">
	<img src="images/left_go.gif"/><label>招标投标信息表</label>
		<table cellpadding="0" cellspacing="0" class="table_add" style="margin-top: 3px;margin-bottom: 10px;TABLE-LAYOUT:fixed;">
			<tr>
				<td width="15%">招标事项</td>
				<td width="85%">
				<pre>${projectConstruct.bidInfo.bidItem }</pre>
	  	
					
				</td>
			</tr>
			<tr>
				<td>招标公告</td>
				<td>
				<pre>${projectConstruct.bidInfo.bidNotice }</pre>
	  	
					
				</td>
			</tr>
			<tr>
				<td>投标资格预审公告</td>
				<td>
				<pre>${projectConstruct.bidInfo.bidApporve }</pre>
	  	
					
				</td>
			</tr>
			<tr>
				<td>中标结果</td>
				<td>
				<pre>${projectConstruct.bidInfo.bidResult }</pre>
	  	
				
					
				</td>
			</tr>
		</table>
	</div>
	
	<div id="landInfoDiv">
    <img src="images/left_go.gif"/><label>征地拆迁信息表</label>
		<table cellpadding="0" cellspacing="0" class="table_add" style="margin-top: 3px;margin-bottom: 10px;TABLE-LAYOUT:fixed;">
			<tr>
				<td width="15%">征地拆迁负责人</td>
				<td >
					${projectConstruct.landInfo.chargePerson}
				</td>
				
			</tr>
			<tr>
			<td width="15%">负责人联系方式</td>
				<td >
					${projectConstruct.landInfo.link}
				</td>
			</tr>
			<tr>
				<td>项目用地审批意见</td>
				<td >
				<pre>${projectConstruct.landInfo.approve }</pre>
	  	
				
					
				</td>
			</tr>
			<tr>
				<td>项目涉及征地、拆迁公告</td>
				<td >
				<pre>${projectConstruct.landInfo.landNotice }</pre>
	  	
					
				</td>
			</tr>
			<tr>
				<td>工作方法原则</td>
				<td >
				<pre>${projectConstruct.landInfo.principle }</pre>
	  	
					
				</td>
			</tr>
			<tr>
				<td>已支付的拆迁补偿费用总额</td>
				<td >
					${util:showAll(projectConstruct.landInfo.recoupMoney)}
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
	</div>
	
	<div id="changesInfoDiv">
    <img src="images/left_go.gif"/><label>重大设计变更信息表</label>
		<table cellpadding="0" cellspacing="0" class="table_add" style="margin-top: 3px;margin-bottom: 10px;TABLE-LAYOUT:fixed;">
			<tr>
				<td width="15%">项目变更时间</td>
				<td colspan="3">
					<s:date name='projectConstruct.changesInfo.changeDate' format="yyyy-MM-dd"/>
				</td>
				<!-- 
				<td width="15%">资金变更</td>
				<td width="35%">
					${projectConstruct.changesInfo.changeMoney}
				</td> -->
			</tr>
			<tr>
				<td>审批单位</td>
				<td colspan="3">
				<pre></pre>
	  	
					
				</td>
			</tr>
			<tr>
				<td>变更原因</td>
				<td colspan="3">
				<pre>${projectConstruct.changesInfo.changeResean }</pre>
	  	
					
				</td>
			</tr>
			<tr>
				<td>设计变更管理依据</td>
				<td colspan="3">
				<pre>${projectConstruct.changesInfo.changeBasis }</pre>
	  	
					
				</td>
			</tr>
			<tr>
				<td>变更内容</td>
				<td colspan="3">
				<pre>${projectConstruct.changesInfo.changeContent }</pre>
	  	
					
				</td>
			</tr>
		</table>
	</div>
	
	<div id="construtInfoDiv">
	<img src="images/left_go.gif"/><label>施工管理信息表</label>
		<table cellpadding="0" cellspacing="0" class="table_add" style="margin-top: 3px;margin-bottom: 10px;TABLE-LAYOUT:fixed;">
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
					<td>&nbsp;${projectConstruct.construtInfo.oneYear }</td>
					<td>${projectConstruct.construtInfo.yiFirPlan }</td>
					<td>${projectConstruct.construtInfo.yiFirFinish }</td>
					<td>${projectConstruct.construtInfo.yiLiangPlan }</td>
					<td>${projectConstruct.construtInfo.yiLiangFinish }</td>
					<td>${projectConstruct.construtInfo.yiThiPlan }</td>
					<td>${projectConstruct.construtInfo.yiThiFinish }</td>
					<td>${projectConstruct.construtInfo.yiForPlan }</td>
					<td>${ projectConstruct.construtInfo.yiForFinish }</td>
				</tr>
				<tr>
					<td>&nbsp;${projectConstruct.construtInfo.twoYear }</td>
					<td>${ProjectConstruct.construtInfo.twoFirPlan }</td>
					<td>${projectConstruct.construtInfo.twoFirFinish }</td>
					<td>${projectConstruct.construtInfo.twoSecPlan }</td>
					<td>${projectConstruct.construtInfo.twoSecFinish }</td>
					<td>${projectConstruct.construtInfo.twoThiPlan }</td>
					<td>${projectConstruct.construtInfo.twoThiFinish }</td>
					<td>${projectConstruct.construtInfo.twoForPlan }</td>
					<td>${projectConstruct.construtInfo.twoForFinish }</td>
				</tr>
		</table>
	</div>
	
	<div id="contractInfoDiv">
	<img src="images/left_go.gif"/><label>合同履约信息表</label>
		<table cellpadding="0" cellspacing="0" class="table_add" style="margin-top: 3px;margin-bottom: 10px;TABLE-LAYOUT:fixed;">
			<tr>
				<td width="15%">施工单位项目考核</td>
				<td width="85%">
				<pre>${projectConstruct.contractInfo.projectExamine }</pre>
	  	
					
				</td>
			</tr>
			<tr>
				<td>参建单位主要相关人员按合同履约到场信息</td>
				<td>
				<pre>${projectConstruct.contractInfo.contractPresent }</pre>
	  	
					
				</td>
			</tr>
			<!-- 
			<tr>
				<td>建设单位按合同支付资金情况</td>
				<td>
					${projectConstruct.contractInfo.payment }
				</td>
			</tr> -->
			<tr>
				<td>设备材料采购情况</td>
				<td>
				<pre>${projectConstruct.contractInfo.moneyUse }</pre>
	  	
					
				</td>
			</tr>
		</table>
	</div>
	
	<div id="safeCheckInfoDiv">
	<img src="images/left_go.gif"/><label>质量安全检查信息表</label>
		<table cellpadding="0" cellspacing="0" class="table_add" style="margin-top: 3px;margin-bottom: 10px;TABLE-LAYOUT:fixed;">
			<tr>
				<td width="15%">工程项目质量安全监督机构及质量安全监督负责人</td>
				<td width="85%">
				<pre>${projectConstruct.safeCheckInfo.chargePerson }</pre>
	  	
					
				</td>
			</tr>
			<tr>
				<td>项目质量鉴定、评定结果</td>
				<td>
				<pre>${projectConstruct.safeCheckInfo.checkContent }</pre>
	  	
					
				</td>
			</tr>
			<!-- 
			<tr>
				<td>项目质量鉴定</td>
				<td>
					${projectConstruct.safeCheckInfo.identifyResult }
				</td>
			</tr>  -->
		</table>
	</div>
	
	<div id="moneyInfoDiv">
	<img src="images/left_go.gif"/><label>资金管理信息表</label>
		<table cellpadding="0" cellspacing="0" class="table_add" style="margin-top: 3px;margin-bottom: 10px;TABLE-LAYOUT:fixed;">
			<tr>
				<td width="15%">项目资金到位情况</td>
				<td width="85%">
				<pre>${projectConstruct.moneyInfo.moneyPresent }</pre>
	  	
					
				</td>
			</tr>
			<tr>
				<td>项目资金使用情况</td>
				<td>
				<pre>${projectConstruct.moneyInfo.moneyPayment }</pre>
	  	
					
				</td>
			</tr>
			<!-- 
			<tr>
				<td>资金概预算执行情况</td>
				<td>
					${projectConstruct.moneyInfo.budgetExecution }
				</td>
			</tr> -->
		</table>
	</div>
	<div id="acceptanceInfoDiv">
	<img src="images/left_go.gif"/><label>交竣工验收信息表</label>
		<table cellpadding="0" cellspacing="0" class="table_add" style="margin-top: 3px;margin-bottom: 10px;TABLE-LAYOUT:fixed;">
			<tr>
				<td width="15%">交竣工验收时间</td>
				<td width="85%">
				<s:date name='projectConstruct.acceptanceInfo.acceptanceTime' format="yyyy-MM-dd"/>
				
				</td>
			</tr>
			<tr>
				<td>交竣工验收结果</td>
				<td>
				<pre>${projectConstruct.acceptanceInfo.acceptanceResult }</pre>
	  	
					
				</td>
			</tr>
			<tr>
				<td>征地补偿和移民安置、水保、环保、档案、消防等专项验收时间信息及结果信息</td>
				<td>
				<pre>${projectConstruct.acceptanceInfo.reportCheck }</pre>
	  	
					
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
				<s:date name='projectConstruct.acceptanceInfo.payTime' format="yyyy-MM-dd"/>
				
				</td>
			</tr>
			
		</table>
	</div>
	
	<div id="constructCompanyInfoDiv">
	<img src="images/left_go.gif"/><label>从业单位行为信息</label>
		<table cellpadding="0" cellspacing="0" class="table_add" style="margin-top: 3px;margin-bottom: 10px;TABLE-LAYOUT:fixed;">
			<tr>
				<td width="15%">信用等级信息</td>
				<td width="85%">
				<pre>${projectConstruct.constructCompanyInfo.companyCredit }</pre>
	  	
					
				</td>
			</tr>
			<tr>
				<td>良好行为信息</td>
				<td>
				<pre>${projectConstruct.constructCompanyInfo.companyHonor }</pre>
	  	
					
				</td>
			</tr>
			<tr>
				<td>不良行为信息</td>
				<td>
				<pre>${projectConstruct.constructCompanyInfo.companyBadrecord }</pre>
	  	
					
				</td>
			</tr>
		</table>
	</div>
	
	<div id="constructPersonInfoDiv">
	<img src="images/left_go.gif"/><label>从业人员行为信息</label>
		<table cellpadding="0" cellspacing="0" class="table_add" style="margin-top: 3px;margin-bottom: 10px;TABLE-LAYOUT:fixed;">
			<tr>
				<td width="15%">良好行为信息</td>
				<td width="85%">
				<pre>${projectConstruct.constructPersonInfo.personHonor }</pre>
	  	
					
				</td>
			</tr>
			<tr>
				<td>不良行为信息</td>
				<td>
				<pre>${projectConstruct.constructPersonInfo.personBadrecord }</pre>
	  	
					
				</td>
			</tr>
		</table>
	</div>
	<div id="auditStatisticsDiv">
	<div class="main_text"><img src="images/left_go.gif"/><label>审计统计结果信息</label></div>
		<table cellpadding="0" cellspacing="0" class="table_add" style="margin-top: 3px;margin-bottom: 10px;TABLE-LAYOUT:fixed;">
			<tr>
				<td width="15%">审计统计结果信息</td>
				<td width="85%">
				<pre>${projectConstruct.auditStatistics.auditStatistics }</pre>
	  	
					
				</td>
			</tr>
		</table>
	</div>
	
	
    </form>
    <div class="add_savebtn">
    <!-- 
    <s:if test="projectConstruct.state!=1">
    	<s:if test="canAccessURL('project/approvePublic')">
    	<a href="javascript:doSubmit('1')"><img src="images/approvePass.gif" border="0"/></a>
    	</s:if>
    	</s:if> -->
    	<a href="javascript:history.back()"><img src="images/back00.gif" border="0" /></a>
    </div>
    
 </div>  <!--right_main-->

</body>