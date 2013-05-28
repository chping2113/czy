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
		$("#bidTime").datepicker({
			changeYear:true,
			changeMonth: true,
			onSelect: function(dateText, inst) {
				$("#bidTime").blur();
			}
		});
		$("#mBidTime").datepicker({
			changeYear:true,
			changeMonth: true,
			onSelect: function(dateText, inst) {
				$("#mBidTime").blur();
			}
		});
		$.brady.validator.validate("projectMiningAddForm", validator_projectMining);
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
				showDialog(loadContentUrl, "btn_ok_close","#projectMiningAddForm","");
			}else{
				$("#projectMiningAddForm").submit();
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
 <form action="project/projectMining_add.action" id="projectMiningAddForm" method="post">
   <div class="right_main">
    <div class="add_top">发布项目公开信息&nbsp;&gt;&nbsp;发布矿业权审批出让信息&nbsp;&gt;<s:if test="type==1">添加</s:if>
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
      		<input type="hidden" name="id" id="id" value="${projectMining.id }"/>
					<input type="hidden" name="type" id="type" value="${type}"/>
					<input type="hidden" name="projectId" id="projectId" value="${projectId }"/>
					<input type="hidden" name="approveState" id="approveState" value="0"/>
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
	<div id="prospectApproveDiv">
    <div class="main_text"><img src="images/left_go.gif"/><label>探矿权审批信息表</label></div>
		<table cellpadding="0" cellspacing="0" class="table_add" style="margin-top: 3px;margin-bottom: 10px;">
			<tr>
				<td width="15%">许可证号</td>
				<td width="35%">
					<input type="text" name="projectMining.prospectApprove.licenseCode" value="${projectMining.prospectApprove.licenseCode}" class="input_text"/>
				</td>
				<td width="15%">项目名称</td>
				<td width="35%">
					<input type="text" name="projectMining.prospectApprove.projectName" value="${projectMining.prospectApprove.projectName}" class="input_text"/>
				</td>
			</tr>
			<tr>
				<td>探矿权人</td>
				<td>
					<input type="text" name="projectMining.prospectApprove.prospectPerson" value="${projectMining.prospectApprove.prospectPerson}" class="input_text"/>
				</td>
				<td>勘察单位</td>
				<td>
					<input type="text" name="projectMining.prospectApprove.reconOrgan" value="${projectMining.prospectApprove.reconOrgan}" class="input_text"/>
				</td>
			</tr>
			<tr>
				<td>勘察矿种</td>
				<td>
					<input type="text" name="projectMining.prospectApprove.reconMine" value="${projectMining.prospectApprove.reconMine}" class="input_text"/>
				</td>
				<td>有效期</td>
				<td>
					<input type="text" name="projectMining.prospectApprove.period" value="${projectMining.prospectApprove.period}" class="input_text"/>
				</td>
			</tr>
			<tr>
				<td>经纬度</td>
				<td>
					<input type="text" name="projectMining.prospectApprove.jingweidu" value="${projectMining.prospectApprove.jingweidu}" class="input_text"/>
				</td>
				<td>勘察面积</td>
				<td>
					<input type="text" name="projectMining.prospectApprove.area" id="prospectApprove_area" value="${projectMining.prospectApprove.area}" class="input_text"  maxlength="200"/>
					<br/><span id="prospectApprove_area_msg_span" ></span>
				</td>
			</tr>
			<tr>
				<td>地理位置</td>
				<td>
					<input type="text" name="projectMining.prospectApprove.location" value="${projectMining.prospectApprove.location}" class="input_text"/>
				</td>
				<td>发证机关</td>
				<td>
					<input type="text" name="projectMining.prospectApprove.certificationOrgan" value="${projectMining.prospectApprove.certificationOrgan}" class="input_text"/>
				</td>
			</tr>
			
		</table>
	</div>
	
	<div id="prospectSellDiv">
    <div class="main_text"><img src="images/left_go.gif"/><label>探矿权出让信息表</label></div>
		<table cellpadding="0" cellspacing="0" class="table_add" style="margin-top: 3px;margin-bottom: 10px;">
			<tr>
				<td width="15%">探矿区名称</td>
				<td width="35%">
					<input type="text" name="projectMining.prospectSell.mineName" value="${projectMining.prospectSell.mineName}" class="input_text"/>
				</td>
				<td width="15%">矿种</td>
				<td width="35%">
					<input type="text" name="projectMining.prospectSell.mineType" value="${projectMining.prospectSell.mineType}" class="input_text"/>
				</td>
			</tr>
			<tr>
				<td>面积</td>
				<td>
					<input type="text" name="projectMining.prospectSell.area" id="prospectSell_area" value="${projectMining.prospectSell.area}" class="input_text"  maxlength="200"/>
					<br/><span id="prospectSell_area_msg_span" ></span>
				</td>
				<td>经纬度拐点坐标</td>
				<td>
					<input type="text" name="projectMining.prospectSell.jinweidu" value="${projectMining.prospectSell.jinweidu}" class="input_text"/>
				</td>
			</tr>
			<tr>
				<td>出让方式</td>
				<td>
					<input type="text" name="projectMining.prospectSell.sellType" value="${projectMining.prospectSell.sellType}" class="input_text"/>
				</td>
				<td>起拍价</td>
				<td>
					<input type="text" name="projectMining.prospectSell.bidBaseMoney" id="prospectSell_bidBaseMoney" value="${util:showAll(projectMining.prospectSell.bidBaseMoney)}" class="input_text"  maxlength="20"/>
					<br/><span id="prospectSell_bidBaseMoney_msg_span" ></span>
				</td>
			</tr>
			<tr>
				<td>竞买保证金</td>
				<td>
					<input type="text" name="projectMining.prospectSell.bidMargin" id="prospectSell_bidMargin" value="${util:showAll(projectMining.prospectSell.bidMargin)}" class="input_text"  maxlength="20"/>
					<br/><span id="prospectSell_bidMargin_msg_span" ></span>
				</td>
				<td>招标拍卖挂牌时间</td>
				<td>
					<input type="text" name="projectMining.prospectSell.bidTime" id="bidTime" value="<s:date name='projectMining.prospectSell.bidTime' format='yyyy-MM-dd'/>" class="calendar input_text" readonly="readonly"/>
				</td>
			</tr>
			
		</table>
	</div>
	
	<div id="mineApproveDiv">
    <div class="main_text"><img src="images/left_go.gif"/><label>采矿权审批信息表</label></div>
		<table cellpadding="0" cellspacing="0" class="table_add" style="margin-top: 3px;margin-bottom: 10px;">
			<tr>
				<td width="15%">许可证号</td>
				<td width="35%">
					<input type="text" name="projectMining.mineApprove.licenseCode" value="${projectMining.mineApprove.licenseCode}" class="input_text"/>
				</td>
				<td width="15%">矿山名称</td>
				<td width="35%">
					<input type="text" name="projectMining.mineApprove.mineName" value="${projectMining.mineApprove.mineName}" class="input_text"/>
				</td>
			</tr>
			<tr>
				<td>采矿权人</td>
				<td>
					<input type="text" name="projectMining.mineApprove.minePerson" value="${projectMining.mineApprove.minePerson}" class="input_text"/>
				</td>
				<td>有效期</td>
				<td>
					<input type="text" name="projectMining.mineApprove.period" value="${projectMining.mineApprove.period}" class="input_text"/>
				</td>
			</tr>
			<tr>
				<td>经纬度</td>
				<td>
					<input type="text" name="projectMining.mineApprove.jingweidu" value="${projectMining.mineApprove.jingweidu}" class="input_text"/>
				</td>
				<td>总面积</td>
				<td>
					<input type="text" name="projectMining.mineApprove.area" id="mineApprove_area" value="${projectMining.mineApprove.area}" class="input_text"  maxlength="200"/>
					<br/><span id="mineApprove_area_msg_span" ></span>
				</td>
			</tr>
			<tr>
				<td>矿种</td>
				<td>
					<input type="text" name="projectMining.mineApprove.mineType" value="${projectMining.mineApprove.mineType}" class="input_text"/>
				</td>
				<td>发证机关</td>
				<td>
					<input type="text" name="projectMining.mineApprove.certificationOrgan" value="${projectMining.mineApprove.certificationOrgan}" class="input_text"/>
				</td>
			</tr>
			
		</table>
	</div>
	
	<div id="mineSellDiv">
    <div class="main_text"><img src="images/left_go.gif"/><label>采矿权出让信息表</label></div>
		<table cellpadding="0" cellspacing="0" class="table_add" style="margin-top: 3px;">
			<tr>
				<td width="15%">采矿权名称</td>
				<td width="35%">
					<input type="text" name="projectMining.mineSell.mineName" value="${projectMining.mineSell.mineName}" class="input_text"/>
				</td>
				<td width="15%">矿种</td>
				<td width="35%">
					<input type="text" name="projectMining.mineSell.mineType" value="${projectMining.mineSell.mineType}" class="input_text"/>
				</td>
			</tr>
			<tr>
				<td>面积</td>
				<td>
					<input type="text" name="projectMining.mineSell.area" id="mineSell_area" value="${projectMining.mineSell.area}" class="input_text"  maxlength="200"/>
					<br/><span id="mineSell_area_msg_span" ></span>
				</td>
				<td>经纬度拐点坐标</td>
				<td>
					<input type="text" name="projectMining.mineSell.jingweidu" value="${projectMining.mineSell.jingweidu}" class="input_text"/>
				</td>
			</tr>
			<tr>
				<td>出让方式</td>
				<td>
					<input type="text" name="projectMining.mineSell.sellType" value="${projectMining.mineSell.sellType}" class="input_text"/>
				</td>
				<td>起拍价</td>
				<td>
					<input type="text" name="projectMining.mineSell.bidBaseMoney" id="mineSell_bidBaseMoney" value="${util:showAll(projectMining.mineSell.bidBaseMoney)}" class="input_text"  maxlength="20"/>
					<br/><span id="mineSell_bidBaseMoney_msg_span" ></span>
				</td>
			</tr>
			<tr>
				<td>竞买保证金</td>
				<td>
					<input type="text" name="projectMining.mineSell.bidMargin" id="mineSell_bidMargin" value="${util:showAll(projectMining.mineSell.bidMargin)}" class="input_text" maxlength="20"/>
					<br/><span id="mineSell_bidMargin_msg_span" ></span>
				</td>
				<td>拍卖时间</td>
				<td>
					<input type="text" name="projectMining.mineSell.bidTime" id="mBidTime" value="<s:date name='projectMining.mineSell.bidTime' format='yyyy-MM-dd'/>" class="calendar input_text"  readonly="readonly"/>
				</td>
			</tr>
			
		</table>
	</div>
	
    <div class="add_savebtn">
    	<s:if test="type==3 || type==6">
    	<s:if test="canAccessURL('project/miningProject_initMining.action')">
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