<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/include/core.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>安徽项目公开网-项目公开信息</title>
	<script type="text/javascript" src="js/project.js"></script>
	<script type="text/javascript">
	jQuery(function(){
		$("#createTime").datepicker({
			changeYear:true,
			changeMonth: true,
			onSelect: function(dateText, inst) {
				$("#createTime").blur();
			}
		});
		$("#bidBeginTime").datepicker({
			changeYear:true,
			changeMonth: true,
			onSelect: function(dateText, inst) {
				$("#projectLand.landBid.bidBeginTime").blur();
			}
		});
		$("#endTime").datepicker({
			changeYear:true,
			changeMonth: true,
			onSelect: function(dateText, inst) {
				$("#endTime").blur();
			}
		});
		$("#signTime").datepicker({
			changeYear:true,
			changeMonth: true,
			onSelect: function(dateText, inst) {
				$("#signTime").blur();
			}
		});
		$("#approvalTime").datepicker({
			changeYear:true,
			changeMonth: true,
			onSelect: function(dateText, inst) {
				$("#approvalTime").blur();
			}
		});
		$.brady.validator.validate("projectLandAddForm", validator_projectLand);
	});
		function doSubmit(approveState){

			$("#approveState").val(approveState);
			var id="${approveUser.id}";
			var type="${type}";
			var state="${state}";
			if(approveState==3 && state!=3){
				if(id=="")
					id=0;
				var loadContentUrl = "project/projectLand_approveUser.action?userId="+id;
				showDialog(loadContentUrl, "btn_ok_close","#projectLandAddForm","");
			}else{
				$("#projectLandAddForm").submit();
			}
			
			
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
 <form action="project/projectLand_add.action" id="projectLandAddForm" method="post">
   <div class="right_main">
    <div class="add_top">发布项目公开信息&nbsp;&gt;&nbsp;发布土地权审批出让信息&nbsp;&gt;<s:if test="type==1">添加</s:if>
    <s:elseif test="type==2">修改</s:elseif>
    <s:elseif test="type==3">审核</s:elseif>
    <s:else>
   	 添加
    </s:else></div>
    <div id="landbaseDiv">
    <div class="main_text"><img src="images/left_go.gif"/><label>项目信息概要</label></div>
		<table cellpadding="0" cellspacing="0" class="table_add" style="margin-top: 3px;margin-bottom: 10px;">
	
      <!-- 
      <tr>
      <th>建设单位</th>
      <td>
	  	<input type="text" name=constructName id="constructName" class="input_text" value="${constructName }" maxlength="40"/>
	  </td>
      </tr> -->
      <tr>
      <th>项目编号</th>
      <td>
      <input type="hidden" name="userId" id="userId" value="${userId}"/>
	  	<input type="text" name="code" id="code" class="input_text" value="${code }" maxlength="40"/>
	  	
	<input type="hidden" name="pageNo" value="${empty pageNo ? '1' : pageNo}" />	
	  </td>
      </tr>
     <tr>
      <th>项目名称</th>
      <td>
	  	<input type="text" name="name" id="name" class="input_text" value="${name }" maxlength="40"/>
	  </td>
      </tr>
      
    <tr>
      <th width="20%">发布机构</th>
      <td>
	  	   <s:if test="type==1">
	  	${session.loginUser.site.name }
	  	</s:if>
	  	<s:else>
	  	${site.name }
	  	
	  	</s:else>
	  </td>
      </tr>  
      
       <tr>
      <th width="25%">发布人员</th>
      <td>
      <s:if test="type==1">
	  	
            姓名:${session.loginUser.name }&nbsp;&nbsp;帐号:${session.loginUser.code }
	  	</s:if>
	  	<s:else>
            姓名:${createUser.name }&nbsp;&nbsp;帐号:${createUser.code }
	  	
	  	
	  	</s:else>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	  
	  </td>
      </tr> 
      
      <tr>
      <th>发布时间</th>
      <td>
      <s:if test="state!=1">
      <input type="text" name="createTime" id="createTime" class="calendar input_text" value="<s:date name='createTime' format='yyyy-MM-dd' />" readonly="readonly"/>
     </s:if>
     <s:else>
      <input type="text" class="input_text"  value="<s:date name='createTime' format='yyyy-MM-dd' />" readonly="readonly"/>
     </s:else>
      </td>
      </tr>
		</table>
	</div>
    <div id="landBidDiv">
    <div class="main_text"><img src="images/left_go.gif"/><label>土地招标拍卖挂牌出让信息表</label></div>
		<table cellpadding="0" cellspacing="0" class="table_add" style="margin-top: 3px;margin-bottom: 10px;">
			<tr>
				<td width="15%">土地面积</td>
				<td width="35%">
					<input type="text" name="projectLand.landBid.area" id="landBid_area" value="${projectLand.landBid.area }" class="input_text" maxlength="200"/>
					<input type="hidden" name="id" id="id" value="${projectLand.id }"/>
					<input type="hidden" name="type" id="type" value="${type}"/>
					<input type="hidden" name="projectId" id="projectId" value="${projectId }"/>
					<input type="hidden" name="approveState" id="approveState" value="0"/>
					<br/><span id="fail_msg_span" ></span>
				</td>
				<td width="15%">建筑密度</td>
				<td width="35%">
					<input type="text" name="projectLand.landBid.density" id="landBid_density" value="${projectLand.landBid.density }" class="input_text"   maxlength="200"/>
					<br/><span id="density_msg_span" ></span>
				</td>
			</tr>
			<tr>
				<td>容积率</td>
				<td>
					<input type="text" name="projectLand.landBid.capacityRate" id="landBid_capacityRate" value="${projectLand.landBid.capacityRate }" class="input_text"   maxlength="200"/>
					<br/><span id="capacityRate_msg_span" ></span>
				</td>
				<td>出让年限</td>
				<td>
					<input type="text" name="projectLand.landBid.sellRears" id="landBid_sellRears" value="${projectLand.landBid.sellRears}" class="input_text" maxlength="100"/>
					<br/><span id="sellRears_msg_span" ></span>
				</td>
			</tr>
			<tr>
				<td>竞价起始时间</td>
				<td>
					<input type="text" name="projectLand.landBid.bidBeginTime" id="bidBeginTime" class="calendar input_text" value="<s:date name='projectLand.landBid.bidBeginTime' format='yyyy-MM-dd' />" readonly="readonly"/>
				</td>
				<td>竞价截止时间</td>
				<td>
					<input type="text" name="projectLand.landBid.bidEndTime" id="endTime" class="calendar input_text" value="<s:date name='projectLand.landBid.bidEndTime' format='yyyy-MM-dd'/>" readonly="readonly"/>
				</td>
			</tr>
			<tr>
				<td>拍卖起叫价</td>
				<td>
					<input type="text" name="projectLand.landBid.bidBaseMoney" id="landBid_bidBaseMoney" value="${projectLand.landBid.bidBaseMoney}" class="input_text"   maxlength="200"/>
					<br/><span id="bidBaseMoney_msg_span" ></span>
				</td>
				<td>竞买保证金</td>
				<td>
					<input type="text" name="projectLand.landBid.bidMargin" id="landBid_bidMargin" value="${projectLand.landBid.bidMargin }" class="input_text"   maxlength="200"/>
					<br/><span id="bidMargin_msg_span" ></span>
				</td>
			</tr>
			<tr>
				<td>位置</td>
				<td colspan="3">
					<input type="text" name="projectLand.landBid.location" value="${projectLand.landBid.location}" class="input_text"/>
				</td>
			</tr>
			<tr>
				<td>规划用途</td>
				<td colspan="3">
					<textarea name="projectLand.landBid.planApplication" class="input_text_area" style="width: 500px;height: 50px;">${projectLand.landBid.planApplication }</textarea>
				</td>
			</tr>
		</table>
	</div>
	
	<div id="landSellDiv">
    <div class="main_text"><img src="images/left_go.gif"/><label>国有土地使用权出让合同信息表</label></div>
		<table cellpadding="0" cellspacing="0" class="table_add" style="margin-top: 3px;margin-bottom: 10px;">
			<tr>
				<td width="15%">土地面积</td>
				<td width="35%">
					<input type="text" name="projectLand.landSell.area" id="landSell_area" value="${projectLand.landSell.area }" class="input_text"  maxlength="200"/>
					<br/><span id="sarea_msg_span" ></span>
				</td>
				<td width="15%">容积率</td>
				<td width="35%">
					<input type="text" name="projectLand.landSell.capacityRate" id="landSell_capacityRate" value="${projectLand.landSell.capacityRate}" class="input_text"   maxlength="200"/>
					<br/><span id="scapacityRate_msg_span" ></span>
				</td>
			</tr>
			<tr>
				<td>土地成交价格</td>
				<td>
					<input type="text" name="projectLand.landSell.transactionPrice" id="landSell_transactionPrice" value="${projectLand.landSell.transactionPrice}" class="input_text"   maxlength="200"/>
					<br/><span id="transactionPrice_msg_span" ></span>
				</td>
				<td>受让方名称</td>
				<td>
					<input type="text" name="projectLand.landSell.transfereeName" value="${projectLand.landSell.transfereeName}" class="input_text"/>
				</td>
			</tr>
			<tr>
				<td>土地位置</td>
				<td>
					<input type="text" name="projectLand.landSell.location" value="${projectLand.landSell.location}" class="input_text"/>
				</td>
				<td>签约时间</td>
				<td>
					<input type="text" name="projectLand.landSell.signTime" id="signTime" value="<s:date name='projectLand.landSell.signTime' format='yyyy-MM-dd'/>" class="calendar input_text""/>
				</td>
			</tr>
			<tr>
				<td>规划用途</td>
				<td colspan="3">
					<textarea name="projectLand.landSell.planApplication" class="input_text_area" style="width: 500px;height: 50px;">${projectLand.landSell.planApplication }</textarea>
				</td>
			</tr>
		</table>
	</div>
	
	<div id="landUseDiv">
    <div class="main_text"><img src="images/left_go.gif"/><label>建设用地审批信息表</label></div>
		<table cellpadding="0" cellspacing="0" class="table_add" style="margin-top: 3px;margin-bottom: 10px;">
			<tr>
				<td width="15%">项目名称</td>
				<td width="35%">
					<input type="text" name="projectLand.landUse.projectName" value="${projectLand.landUse.projectName}" class="input_text"/>
				</td>
				<td width="15%">申请单位</td>
				<td width="35%">
					<input type="text" name="projectLand.landUse.applyOrgan" value="${projectLand.landUse.applyOrgan}" class="input_text"/>
				</td>
			</tr>
			<tr>
				<td>申请用地面积</td>
				<td>
					<input type="text" name="projectLand.landUse.applyUseUrea" id="landUse_applyUseUrea" value="${projectLand.landUse.applyUseUrea}" class="input_text"  maxlength="200"/>
					<br/><span id="applyUseUrea_msg_span" ></span>
				</td>
				<td>批准时间</td>
				<td>
					<input type="text" name="projectLand.landUse.approvalTime" id="approvalTime" value="<s:date name='projectLand.landUse.approvalTime' format='yyyy-MM-dd'/>" class="calendar input_text" />
				</td>
			</tr>
			<tr>
				<td>用地位置</td>
				<td colspan="3">
					<input type="text" name="projectLand.landUse.location" value="${projectLand.landUse.location}" class="input_text"/>
				</td>
			</tr>
			<tr>
				<td>用地用途</td>
				<td colspan="3">
					<textarea name="projectLand.landUse.landUse" class="input_text_area" style="width: 500px;height: 50px;">${projectLand.landUse.landUse }</textarea>
				</td>
			</tr>
		</table>
	</div>
	
	
	
    
    <div class="add_savebtn">
    	<s:if test="type==3 || type==6">
    	<s:if test="canAccessURL('project/landProject_initLand.action')">
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
</body>