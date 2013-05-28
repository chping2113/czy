<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/include/core.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>安徽项目公开网-项目公开信息</title>
	<script type="text/javascript">
		jQuery(function() {
			$("#createTime").datepicker({
				changeYear:true,
				changeMonth: true,
				onSelect: function(dateText, inst) {
					$("#createTime").blur();
				}
			});$("#constructBeginDate").datepicker({
				changeYear:true,
				changeMonth: true,
				onSelect: function(dateText, inst) {
					$("#constructBeginDate").blur();
				}
			});
			$("#constructEndDate").datepicker({
				changeYear:true,
				changeMonth: true,
				onSelect: function(dateText, inst) {
					$("#constructEndDate").blur();
				}
			});
			$("#changesInfo_changeDate").datepicker({
				changeYear:true,
				changeMonth: true,
				onSelect: function(dateText, inst) {
					$("#changesInfo_changeDate").blur();
				}
			});
			$("#acceptanceTime").datepicker({
				changeYear:true,
				changeMonth: true,
				onSelect: function(dateText, inst) {
					$("#acceptanceTime").blur();
				}
			});
			$("#payTime").datepicker({
				changeYear:true,
				changeMonth: true,
				onSelect: function(dateText, inst) {
					$("#payTime").blur();
				}
			});
			var type="${type}";
			if(type==3 || type==6){
				$.brady.validator.validate("projectConstructAddForm", validator_projectConstruct2);
			}else{
				$.brady.validator.validate("projectConstructAddForm", validator_projectConstruct);
			}
			
		});
		function doSubmit(approveState){	
			$("#approveState").val(approveState);
			var id="${approveUser.id}";
			var type="${type}";
			var state="${state}";
			var siteId=$("#siteId").val();
			
			if(siteId==""){
				alert("审核机构不能为空!");
				return;
			}
			if(approveState==3 && state!=3){
				if(id=="")
					id=0;
				var loadContentUrl = "project/projectLand_approveUser.action?userId="+id+"&siteId="+siteId;
				showDialog(loadContentUrl, "btn_ok_close","#projectConstructAddForm","");
			}else{
				$("#projectConstructAddForm").submit();
			}
		}
	</script>
	<style type="text/css">
		label {
			padding:8px 0px 8px 3px;
			/*font-weight:bolder;*/
		}
		.input_text_large2 { border:1px solid #cac098;
             width:500px;
			 padding:0px 5px;
			 height:22px;		 
}
	</style>
</head>
<body>
   <div class="right_main">
    <div class="add_top">
    <s:if test="type==3">项目信息公开&nbsp;&gt;&nbsp;发布建设管理信息&nbsp;&gt;审核</s:if>
    <s:elseif test="type==6">待办工作&nbsp;&gt;&nbsp;建设管理信息审批&nbsp;&gt;审核</s:elseif>
    <s:elseif test="type==2">建设管理信息录入&nbsp;&gt;修改</s:elseif>
    <s:else>建设管理信息录入&nbsp;&gt;添加</s:else>
   </div>
    <form action="project/projectConstruct_add.action" id="projectConstructAddForm" method="post">
         <div id="projectBaseDiv">
    <div class="main_text"><img src="images/left_go.gif"/><label>信息概要</label></div>
		<table cellpadding="0" cellspacing="0" class="table_add" style="margin-top: 3px;margin-bottom: 10px;">
		<input type="hidden" name="pageNo" value="${empty pageNo ? '1' : pageNo}" />	
   
      <s:if test="state==1 ">
       <tr>
      <td>编号</td>
      <td>	
      <input type="hidden" name="userId" id="userId" value="${userId}"/>
      <input type="text" name="code2" id="code2" class="input_text" value="${code }" maxlength="40" readonly="readonly"/>
	  	
	
	  </td>
      </tr>
     <tr>
      <td>名称</td>
      <td>
      <input type="text" name="name" id="name" class="input_text" value="${name }" maxlength="40"  readonly="readonly"/>
	  </td>
      </tr>
     <s:if test="session.loginUser==null">
     <tr>
      <td width="15%" align="left">建设单位</td>
      <td>${session.loginConstruct.name }
   
     
	  </td>
      </tr>  
   </s:if>
   <s:else>
    <tr>
      <td width="15%" align="left">建设单位</td>
      <td>
     
      <s:if test="construct.name != ''">
      
    <input type="text" name="constructName" id="constructName" class="input_text" value="${construct.name }" maxlength="100" />	
      </s:if>
      <s:else>
      
    <input type="text" name="constructName" id="constructName" class="input_text" value="${constructName }" maxlength="100" />
      </s:else>
	  </td>
      </tr>  
   
   
   
   </s:else> 
     <tr>
      <td width="15%">
      <s:if test="session.loginUser==null">审核机构
   
   </s:if>
   <s:else>
    发布机构
   
   </s:else></td>
      <td>
      	<input type="hidden" name="siteId" id="siteId" value="${site.id }"  />
      	<input type="text"  class="input_text" name="siteName" id="siteName" value="${site.name }" readonly="readonly"/>
      
    	<span id="fail_msg_span"></span>
	  </td>
      </tr>
     
     <s:if test="session.loginUser!=null"> 
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
      <td>发布时间</td>
      <td>
      <input type="text"  class="input_text" value="<s:date name='createTime' format='yyyy-MM-dd' />" readonly="readonly"/>
      </td>
      </tr>
      </s:if>
      <s:else>
      <tr>
      <td>项目编号</td>
      <td>	
      <input type="text" name="code" id="code" class="input_text" value="${code }" maxlength="40"/>
	  	
	  </td>
      </tr>
     <tr>
      <td align="left">项目名称</td>
      <td>
      <input type="text" name="name" id="name" class="input_text" value="${name }" maxlength="40"/>
	  </td>
      </tr>
      <s:if test="session.loginUser==null">
     <tr>
      <td width="15%" align="left">建设单位</td>
      <td>${session.loginConstruct.name }
   
     
	  </td>
      </tr>  
   </s:if>
   <s:else>
    <tr>
      <td width="15%" align="left">建设单位</td>
      <td>
    
      <s:if test="construct.name != ''">
      
    <input type="text" name="constructName" id="constructName" class="input_text" value="${construct.name }" maxlength="100" />	
      </s:if>
      <s:else>
      
    <input type="text" name="constructName" id="constructName" class="input_text" value="${constructName }" maxlength="100" />
      </s:else>
	  </td>
      </tr>  
   
   </s:else>
     <tr>
      <td width="15%">
      <s:if test="session.loginUser==null">审核机构
   
   </s:if>
   <s:else>
    发布机构
   
   </s:else></td>
      <td>
     
   <s:if test="session.loginUser==null">
      	<input type="hidden" name="siteId" id="siteId" value="${site.id }"/>
      	<input type="text"  class="input_text" name="siteName" id="siteName" value="${site.name }" readonly="readonly"/>
      	<a href="javascript:doShowQueryWindow('system/site_searchOrganForQucikZL.action','doQueryOK','siteId','siteName','名称')">
    		<img src="images/query.png" border="0" />
    	</a>
    	<span id="fail_msg_span"></span>
    	</s:if>
    	<s:else>
    	
      	<input type="hidden" name="siteId" id="siteId" value="${session.loginUser.site.id}"/>
      	<input type="text"  class="input_text"  value="${session.loginUser.site.name }" readonly="readonly"/>
    	</s:else>
	  </td>
      </tr>
      
      
     <s:if test="session.loginUser!=null"> 
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
      <td>发布时间</td>
      <td>
      <input type="text" name="createTime" id="createTime" class="calendar input_text" value="<s:date name='createTime' format='yyyy-MM-dd' />" readonly="readonly"/>
      </td>
      </tr>
      </s:else>
    
		</table>
	</div>
    <div id="baseInfoDiv">
    <div class="main_text"><img src="images/left_go.gif"/><label>基本信息表</label></div>
		<table cellpadding="0" cellspacing="0" class="table_add" style="margin-top: 3px;margin-bottom: 10px;">
			
			<tr>
				<td>建设单位</td>
				<td>
					<input type="text" name="baseInfo.constructCompany" id="constructCompany" value="${projectConstruct.baseInfo.constructCompany}" maxlength="30" class="input_text_large2"/>
				</td>
				
			</tr>
			<tr>
			<td width="15%">项目投资</td>
				<td >
					<input type="text" name="baseInfo.money" id="baseInfo_money" value="${util:showAll(projectConstruct.baseInfo.money) }" class="input_text_large2" maxlength="15"/>
					<span id=bm_msg_span ></span>
				</td>
			</tr>
			
			<tr>
				<td width="15%">项目经理</td>
				<td >
					<input type="text" name="baseInfo.manager" id="manager" value="${projectConstruct.baseInfo.manager}" maxlength="10" class="input_text_large2"/>
					<input type="hidden" name="id" id="id" value="${projectConstruct.id }"/>
					<input type="hidden" name="projectId" id="projectId" value="${projectId }"/>
					<input type="hidden" name="approveState" id="approveState" value="0"/>
					<input type="hidden" name="type" id="type" value="${type }"/>
				</td>
				
			</tr>
			<tr>
			<td>项目概况</td>
				<td >
					<input type="text" name="baseInfo.memo" id="memo" value="${projectConstruct.baseInfo.memo }" class="input_text_large2"/>
				</td>
			</tr>
			<tr>
				<td>建设起始时间</td>
				<td>
					<input type="text" name="projectConstruct.baseInfo.constructBeginDate" id="constructBeginDate" value="<s:date name='projectConstruct.baseInfo.constructBeginDate' format='yyyy-MM-dd'/>" class="calendar input_text_large2" readonly="readonly"/>
				</td>
				
			</tr>
			<tr>
			<td>建设结束时间</td>
				<td>
					<input type="text" name="projectConstruct.baseInfo.constructEndDate" id="constructEndDate" value="<s:date name='projectConstruct.baseInfo.constructEndDate' format='yyyy-MM-dd'/>" class="calendar input_text_large2" readonly="readonly"/>
				</td>
			</tr>
			<tr>
			
				<td >从业单位</td>
				<td colspan="3">
				<textarea name="projectConstruct.baseInfo.otherCompanys" id="otherCompanys" class="input_text_area" style="width: 500px;height: 50px;">${projectConstruct.baseInfo.otherCompanys }</textarea>
				</td>
			
				
			</tr>
		</table>
	</div>
	
	<div id="bidInfoDiv">
	<div class="main_text"><img src="images/left_go.gif"/><label>招标投标信息表</label></div>
		<table cellpadding="0" cellspacing="0" class="table_add" style="margin-top: 3px;margin-bottom: 10px;">
			<tr>
				<td width="15%">招标事项</td>
				<td width="85%">
					<textarea name="projectConstruct.bidInfo.bidItem" id="bidItem" class="input_text_area" style="width: 500px;height: 50px;">${projectConstruct.bidInfo.bidItem }</textarea>
				</td>
			</tr>
			<tr>
				<td>招标公告</td>
				<td>
					<textarea name="projectConstruct.bidInfo.bidNotice" id="bidNotice" class="input_text_area" style="width: 500px;height: 50px;">${projectConstruct.bidInfo.bidNotice }</textarea>
				</td>
			</tr>
			<tr>
				<td>投标资格预审公告</td>
				<td>
					<textarea name="projectConstruct.bidInfo.bidApporve" id="bidApporve" class="input_text_area" style="width: 500px;height: 50px;">${projectConstruct.bidInfo.bidApporve }</textarea>
				</td>
			</tr>
			<tr>
				<td>中标结果</td>
				<td>
					<textarea name="projectConstruct.bidInfo.bidResult" id="bidResult" class="input_text_area" style="width: 500px;height: 50px;">${projectConstruct.bidInfo.bidResult }</textarea>
				</td>
			</tr>
		</table>
	</div>
	
	<div id="landInfoDiv">
    <div class="main_text"><img src="images/left_go.gif"/><label>征地拆迁信息表</label></div>
		<table cellpadding="0" cellspacing="0" class="table_add" style="margin-top: 3px;margin-bottom: 10px;">
			<tr>
				<td width="15%">征地拆迁负责人</td>
				<td >
					<input type="text" name="projectConstruct.landInfo.chargePerson" value="${projectConstruct.landInfo.chargePerson}" maxlength="10" class="input_text_large2"/>
				</td>
				
			</tr>
			<tr>
			<td width="15%">负责人联系方式</td>
				<td>
					<input type="text" name="projectConstruct.landInfo.link" value="${projectConstruct.landInfo.link}" maxlength="100" class="input_text_large2"/>
				</td>
			</tr>
			<tr>
				<td>项目用地审批意见</td>
				<td colspan="3">
					<textarea name="projectConstruct.landInfo.approve" class="input_text_area" style="width: 500px;height: 50px;">${projectConstruct.landInfo.approve }</textarea>
				</td>
			</tr>
			<tr>
				<td>项目涉及征地、拆迁公告</td>
				<td colspan="3">
					<textarea name="projectConstruct.landInfo.landNotice" class="input_text_area" style="width: 500px;height: 50px;">${projectConstruct.landInfo.landNotice }</textarea>
				</td>
			</tr>
			<tr>
				<td>工作方法原则</td>
				<td colspan="3">
					<textarea name="projectConstruct.landInfo.principle" class="input_text_area" style="width: 500px;height: 50px;">${projectConstruct.landInfo.principle }</textarea>
				</td>
			</tr>
			<tr>
				<td>已支付的拆迁补偿费用总额</td>
				<td colspan="3">
					<input type="text" name="projectConstruct.landInfo.recoupMoney" id="landInfo_recoupMoney" value="${util:showAll(projectConstruct.landInfo.recoupMoney)}" class="input_text_large2" maxlength="15"/>
				</td>
			</tr>
			<!--  
			<tr>
				<td>项目设计征地</td>
				<td colspan="3">
					<textarea name="projectConstruct.landInfo.landDesign" class="input_text_area" style="width: 500px;height: 50px;">${projectConstruct.landInfo.landDesign }</textarea>
				</td>
			</tr>-->
		</table>
	</div>
	
	<div id="changesInfoDiv">
    <div class="main_text"><img src="images/left_go.gif"/><label>重大设计变更信息表</label></div>
		<table cellpadding="0" cellspacing="0" class="table_add" style="margin-top: 3px;margin-bottom: 10px;">
			<tr>
				<td width="15%">项目变更时间</td>
				<td colspan="3">
					<input type="text" id="changesInfo_changeDate" name="projectConstruct.changesInfo.changeDate" value="<s:date name='projectConstruct.changesInfo.changeDate' format='yyyy-MM-dd'/>" class="calendar input_text_large2" readonly="readonly"/>
				</td>
				<!--  
				<td width="15%">资金变更</td>
				<td width="35%">
					<input type="text" name="projectConstruct.changesInfo.changeMoney" value="${projectConstruct.changesInfo.changeMoney}" class="input_text"/>
				</td>-->
			</tr>
			<tr>
				<td>审批单位</td>
				<td colspan="3">
					<input type="text" name="projectConstruct.changesInfo.approveOrgan" value="" class="input_text_large2" maxlength="50"/>
				</td>
			</tr>
			<tr>
				<td>变更原因</td>
				<td colspan="3">
					<textarea name="projectConstruct.changesInfo.changeResean" class="input_text_area" style="width: 500px;height: 50px;">${projectConstruct.changesInfo.changeResean }</textarea>
				</td>
			</tr>
			<tr>
				<td>设计变更管理依据</td>
				<td colspan="3">
					<textarea name="projectConstruct.changesInfo.changeBasis" class="input_text_area" style="width: 500px;height: 50px;">${projectConstruct.changesInfo.changeBasis }</textarea>
				</td>
			</tr>
			<tr>
				<td>变更内容</td>
				<td colspan="3">
					<textarea name="projectConstruct.changesInfo.changeContent" class="input_text_area" style="width: 500px;height: 50px;">${projectConstruct.changesInfo.changeContent }</textarea>
				</td>
			</tr>
		</table>
	</div>
	
	<div id="construtInfoDiv">
	<div class="main_text"><img src="images/left_go.gif"/><label>施工管理信息表</label></div>
		<table cellpadding="0" cellspacing="0" class="table_add" style="margin-top: 3px;margin-bottom: 10px;">
	
			
				<tr>
					<td rowspan="2" >年度</td>
					<td colspan="2" >一季度</td>
					<td colspan="2" >二季度</td>
					<td colspan="2" >三季度</td>
					<td colspan="2" >四季度</td>
					<td rowspan="4" width="16%"></td>
				</tr>
				<tr>
					<td>投资完成额(单位:万元)</td>
					<td>占总投资比重(%)</td>
					<td>投资完成额(单位:万元)</td>
					<td>占总投资比重(%)</td>
					<td>投资完成额(单位:万元)</td>
					<td>占总投资比重(%)</td>
					<td>投资完成额(单位:万元)</td>
					<td >占总投资比重(%)</td>
				</tr>
				<tr>
					<td><input type="text" name="projectConstruct.construtInfo.oneYear" value="${projectConstruct.construtInfo.oneYear }" style="width:40px;" class="input_text" maxlength="20"/></td>
					<td><input type="text" name="projectConstruct.construtInfo.yiFirPlan" value="${projectConstruct.construtInfo.yiFirPlan }" style="width:40px;" class="input_text" maxlength="20"/></td>
					<td><input type="text" name="projectConstruct.construtInfo.yiFirFinish" value="${projectConstruct.construtInfo.yiFirFinish }" style="width: 40px;" class="input_text" maxlength="20"/></td>
					<td><input type="text" name="projectConstruct.construtInfo.yiLiangPlan" value="${projectConstruct.construtInfo.yiLiangPlan }" style="width: 40px;" class="input_text" maxlength="20"/></td>
					<td><input type="text" name="projectConstruct.construtInfo.yiLiangFinish" value="${projectConstruct.construtInfo.yiLiangFinish }" style="width: 40px;" class="input_text" maxlength="20"/></td>
					<td><input type="text" name="projectConstruct.construtInfo.yiThiPlan" value="${projectConstruct.construtInfo.yiThiPlan }" style="width: 40px;" class="input_text" maxlength="20"/></td>
					<td><input type="text" name="projectConstruct.construtInfo.yiThiFinish" value="${projectConstruct.construtInfo.yiThiFinish }" style="width: 40px;"class="input_text" maxlength="20"/></td>
					<td><input type="text" name="projectConstruct.construtInfo.yiForPlan" value="${projectConstruct.construtInfo.yiForPlan }" style="width: 40px;" class="input_text"  maxlength="20"/></td>
					<td><input type="text" name="projectConstruct.construtInfo.yiForFinish" value="${ projectConstruct.construtInfo.yiForFinish }" style="width: 40px;" class="input_text" maxlength="20"/></td>
				</tr>
				<tr>
					<td><input type="text" name="projectConstruct.construtInfo.twoYear" value="${projectConstruct.construtInfo.twoYear }" style="width:40px;" class="input_text"  maxlength="20"/></td>
					<td><input type="text" name="projectConstruct.construtInfo.twoFirPlan" value="${projectConstruct.construtInfo.twoFirPlan }" style="width: 40px;" class="input_text" maxlength="20"/></td>
					<td><input type="text" name="projectConstruct.construtInfo.twoFirFinish" value="${projectConstruct.construtInfo.twoFirFinish }" style="width: 40px;" class="input_text" maxlength="20"/></td>
					<td><input type="text" name="projectConstruct.construtInfo.twoSecPlan" value="${projectConstruct.construtInfo.twoSecPlan }" style="width: 40px;" class="input_text" maxlength="20"/></td>
					<td><input type="text" name="projectConstruct.construtInfo.twoSecFinish" value="${projectConstruct.construtInfo.twoSecFinish }" style="width: 40px;" class="input_text" maxlength="20"/></td>
					<td><input type="text" name="projectConstruct.construtInfo.twoThiPlan" value="${projectConstruct.construtInfo.twoThiPlan }" style="width: 40px;" class="input_text" maxlength="20"/></td>
					<td><input type="text" name="projectConstruct.construtInfo.twoThiFinish" value="${projectConstruct.construtInfo.twoThiFinish }" style="width: 40px;" class="input_text" maxlength="20"/></td>
					<td><input type="text" name="projectConstruct.construtInfo.twoForPlan" value="${projectConstruct.construtInfo.twoForPlan }" style="width: 40px;" class="input_text" maxlength="20"/></td>
					<td><input type="text" name="projectConstruct.construtInfo.twoForFinish" value="${ projectConstruct.construtInfo.twoForFinish }" style="width: 40px;" class="input_text" maxlength="20"/></td>
				</tr>
		</table>
	</div>
	
	<div id="contractInfoDiv">
	<div class="main_text"><img src="images/left_go.gif"/><label>合同履约信息表</label></div>
		<table cellpadding="0" cellspacing="0" class="table_add" style="margin-top: 3px;margin-bottom: 10px;">
			<tr>
				<td width="15%">施工单位项目考核</td>
				<td width="85%">
					<textarea name="projectConstruct.contractInfo.projectExamine" class="input_text_area" style="width: 500px;height: 50px;">${projectConstruct.contractInfo.projectExamine }</textarea>
				</td>
			</tr>
			<tr>
				<td>参建单位主要相关人员按合同履约到场信息</td>
				<td>
					<textarea name="projectConstruct.contractInfo.contractPresent" class="input_text_area" style="width: 500px;height: 50px;">${projectConstruct.contractInfo.contractPresent }</textarea>
				</td>
			</tr>
			<tr>
			<!-- 
				<td>建设单位按合同支付资金情况</td>
				<td>
					<textarea name="projectConstruct.contractInfo.payment" class="input_text_area" style="width: 500px;height: 50px;">${projectConstruct.contractInfo.payment }</textarea>
				</td>
			</tr> -->
				<td>设备材料采购情况</td>
				<td>
					<textarea name="projectConstruct.contractInfo.moneyUse" class="input_text_area" style="width: 500px;height: 50px;">${projectConstruct.contractInfo.moneyUse }</textarea>
				</td>
			</tr>
		</table>
	</div>
	
	<div id="safeCheckInfoDiv">
	<div class="main_text"><img src="images/left_go.gif"/><label>质量安全检查信息表</label></div>
		<table cellpadding="0" cellspacing="0" class="table_add" style="margin-top: 3px;margin-bottom: 10px;">
			<tr>
				<td width="15%">工程项目质量安全监督机构及质量安全监督负责人</td>
				<td width="85%">
					<textarea name="projectConstruct.safeCheckInfo.chargePerson" class="input_text_area" style="width: 500px;height: 50px;">${projectConstruct.safeCheckInfo.chargePerson }</textarea>
				</td>
			</tr>
			<tr>
				<td>项目质量鉴定、评定结果</td>
				<td>
					<textarea name="projectConstruct.safeCheckInfo.checkContent" class="input_text_area" style="width: 500px;height: 50px;">${projectConstruct.safeCheckInfo.checkContent }</textarea>
				</td>
			</tr>
			<!--
			<tr>
				<td>项目质量鉴定</td>
				<td>
					<textarea name="projectConstruct.safeCheckInfo.identifyResult" class="input_text_area" style="width: 500px;height: 50px;">${projectConstruct.safeCheckInfo.identifyResult }</textarea>
				</td>
			</tr>  -->
		</table>
	</div>
	
	<div id="moneyInfoDiv">
	<div class="main_text"><img src="images/left_go.gif"/><label>资金管理信息表</label></div>
		<table cellpadding="0" cellspacing="0" class="table_add" style="margin-top: 3px;margin-bottom: 10px;">
			<tr>
				<td width="15%">项目资金到位情况</td>
				<td width="85%">
					<textarea name="projectConstruct.moneyInfo.moneyPresent" class="input_text_area" style="width: 500px;height: 50px;">${projectConstruct.moneyInfo.moneyPresent }</textarea>
				</td>
			</tr>
			<tr>
				<td>项目资金使用情况</td>
				<td>
					<textarea name="projectConstruct.moneyInfo.moneyPayment" class="input_text_area" style="width: 500px;height: 50px;">${projectConstruct.moneyInfo.moneyPayment }</textarea>
				</td>
			</tr>
			<!--  
			<tr>
				<td>资金概预算执行情况</td>
				<td>
					<textarea name="projectConstruct.moneyInfo.budgetExecution" class="input_text_area" style="width: 500px;height: 50px;">${projectConstruct.moneyInfo.budgetExecution }</textarea>
				</td>
			</tr>-->
		</table>
	</div>
	<div id="acceptanceInfoDiv">
	<div class="main_text"><img src="images/left_go.gif"/><label>交竣工验收信息表</label></div>
		<table cellpadding="0" cellspacing="0" class="table_add" style="margin-top: 3px;">
			<tr>
				<td width="15%">交竣工验收时间</td>
				<td width="85%">
				<input type="text" name="projectConstruct.acceptanceInfo.acceptanceTime" id="acceptanceTime" value="<s:date name='projectConstruct.acceptanceInfo.acceptanceTime' format='yyyy-MM-dd'/>" class="calendar input_text_large2" readonly="readonly"/>
		
				</td>
			</tr>
			<tr>
				<td>交竣工验收结果</td>
				<td>
					<textarea name="projectConstruct.acceptanceInfo.acceptanceResult" class="input_text_area" style="width: 500px;height: 50px;">${projectConstruct.acceptanceInfo.acceptanceResult }</textarea>
				</td>
			</tr>
			<tr>
				<td>征地补偿和移民安置、水保、环保、档案、消防等专项验收时间信息及结果信息</td>
				<td>
					<textarea name="projectConstruct.acceptanceInfo.reportCheck" class="input_text_area" style="width: 500px;height: 50px;">${projectConstruct.acceptanceInfo.reportCheck }</textarea>
				</td>
			</tr>
			<!-- 
			<tr>
				<td>消防单位项目验收报告</td>
				<td>
					<textarea name="projectConstruct.acceptanceInfo.fireReport" class="input_text_area" style="width: 500px;height: 50px;">${projectConstruct.acceptanceInfo.fireReport }</textarea>
				</td>
			</tr>
			<tr>
				<td>征地补偿和移民安置</td>
				<td>
					<textarea name="projectConstruct.acceptanceInfo.supervisionReport" class="input_text_area" style="width: 500px;height: 50px;">${projectConstruct.acceptanceInfo.supervisionReport }</textarea>
				</td>
			</tr>
			<tr>
				<td>环保单位项目验收报告</td>
				<td>
					<textarea name="projectConstruct.acceptanceInfo.environmentReport" class="input_text_area" style="width: 500px;height: 50px;">${projectConstruct.acceptanceInfo.environmentReport }</textarea>
				</td>
			</tr>
			<tr>
				<td>档案验收</td>
				<td>
					<textarea name="projectConstruct.acceptanceInfo.documentAcceptance" class="input_text_area" style="width: 500px;height: 50px;">${projectConstruct.acceptanceInfo.documentAcceptance }</textarea>
				</td>
			</tr> 
			<tr>
				<td>水保等专项验收时间及结果信息</td>
				<td>
					<textarea name="projectConstruct.acceptanceInfo.acceptanceReport" class="input_text_area" style="width: 500px;height: 50px;">${projectConstruct.acceptanceInfo.acceptanceReport }</textarea>
				</td>
			</tr>
			-->
			<tr>
				<td>交付使用时间</td>
				<td>
				<input type="text" name="projectConstruct.acceptanceInfo.payTime" id="payTime" value="<s:date name='projectConstruct.acceptanceInfo.payTime' format='yyyy-MM-dd'/>" class="calendar input_text_large2" readonly="readonly"/>
				
				</td>
			</tr>
			
		</table>
	</div>
	
	<div id="moneyInfoDiv">
	<div class="main_text"><img src="images/left_go.gif"/><label>从业单位行为信息</label></div>
		<table cellpadding="0" cellspacing="0" class="table_add" style="margin-top: 3px;margin-bottom: 10px;">
			<tr>
				<td width="15%">信用等级信息</td>
				<td width="85%">
					<textarea name="projectConstruct.constructCompanyInfo.companyCredit" class="input_text_area" style="width: 500px;height: 50px;">${projectConstruct.constructCompanyInfo.companyCredit }</textarea>
				</td>
			</tr>
			<tr>
				<td>良好行为信息</td>
				<td>
					<textarea name="projectConstruct.constructCompanyInfo.companyHonor" class="input_text_area" style="width: 500px;height: 50px;">${projectConstruct.constructCompanyInfo.companyHonor }</textarea>
				</td>
			</tr>
			<tr>
				<td>不良行为信息</td>
				<td>
					<textarea name="projectConstruct.constructCompanyInfo.companyBadrecord" class="input_text_area" style="width: 500px;height: 50px;">${projectConstruct.constructCompanyInfo.companyBadrecord }</textarea>
				</td>
			</tr>
		</table>
	</div>
	
	<div id="moneyInfoDiv">
	<div class="main_text"><img src="images/left_go.gif"/><label>从业人员行为信息</label></div>
		<table cellpadding="0" cellspacing="0" class="table_add" style="margin-top: 3px;margin-bottom: 10px;">
			<tr>
				<td width="15%">良好行为信息</td>
				<td width="85%">
					<textarea name="projectConstruct.constructPersonInfo.personHonor" class="input_text_area" style="width: 500px;height: 50px;">${projectConstruct.constructPersonInfo.personHonor }</textarea>
				</td>
			</tr>
			<tr>
				<td>不良行为信息</td>
				<td>
					<textarea name="projectConstruct.constructPersonInfo.personBadrecord" class="input_text_area" style="width: 500px;height: 50px;">${projectConstruct.constructPersonInfo.personBadrecord }</textarea>
				</td>
			</tr>
		</table>
	</div>
	
	<div id="auditStatisticsDiv">
	<div class="main_text"><img src="images/left_go.gif"/><label>审计统计结果信息</label></div>
		<table cellpadding="0" cellspacing="0" class="table_add" style="margin-top: 3px;margin-bottom: 10px;">
			<tr>
				<td width="15%">审计统计结果信息</td>
				<td width="85%">
					<textarea name="projectConstruct.auditStatistics.auditStatistics" class="input_text_area" style="width: 500px;height: 50px;">${projectConstruct.auditStatistics.auditStatistics }</textarea>
				</td>
			</tr>
		</table>
	</div>
	
    <div class="add_savebtn">
    	<s:if test="type==3 || type==6">
    	<s:if test="canAccessURL('project/constructProject_initConstruct.action')">
    	<a href="javascript:doSubmit('1')"><img src="images/verifyPass.gif" border="0"/></a>
    	<a href="javascript:doSubmit('2')"><img src="images/verifyReject.gif" border="0"/></a>
    	</s:if>
    	</s:if>
    	<s:else>
    	<s:if test="type==2 ">
    	<a href="javascript:doSubmit('${state }')"><img src="images/save.gif" border="0"/></a>
    	<s:if test="state==0 || state==2">
    	<a href="javascript:doSubmit('3')"><img src="imgage/ok.jpg" border="0"/></a>
    	</s:if>
    	</s:if>
    	<s:if test="type==1">
    	<a href="javascript:doSubmit('0')"><img src="images/save.gif" border="0"/></a>
    	<a href="javascript:doSubmit('3')"><img src="imgage/ok.jpg" border="0"/></a>
    	</s:if>
    	</s:else>
    	
    	
  
    	
    	<a href="javascript:history.back()"><img src="images/back00.gif" border="0" /></a>
    </div>
    
    </form>
 </div>  <!--right_main-->

 <brady:approveUser title="请选择审核人员" onClickOK="doApprove()" width="350" height="400"/>
<brady:query paramName="queryCode"/>
</body>