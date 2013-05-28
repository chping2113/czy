<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/include/core.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>安徽项目公开网-项目公开信息</title>
	<script type="text/javascript">
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
    <div class="add_top">发布项目公开信息&nbsp;&gt;&nbsp;发布土地权审批出让信息&nbsp;&gt;查看</div>
    <div id="landbaseDiv">
    <div class="main_text"><img src="images/left_go.gif"/><label>项目信息概要</label></div>
		<table cellpadding="0" cellspacing="0" class="table_add" style="margin-top: 3px;margin-bottom: 10px;">
	<tr>
      <th width="20%">发布机构</th>
      <td>
	  	${site.name }
	  </td>
      </tr>
      <!-- 
      <tr>
      <th>建设单位</th>
      <td>
	  	${constructName }
	  </td>
      </tr> -->
      <tr>
      <th>项目编号</th>
      <td>
	  ${code }
	  </td>
      </tr>
     <tr>
      <th>项目名称</th>
      <td>
	  	${name }
	  </td>
      </tr>
      <tr>
      <th>发布时间</th>
      <td><s:date name="createTime" format="yyyy-MM-dd"/></td>
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
      <th>审核人员</th>
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
    <form action="project/projectLand_add.action" id="projectLandAddForm" method="post">
    <div id="landBidDiv">
    <img src="images/left_go.gif"/><label>土地招标拍卖挂牌出让信息表</label>
		<table cellpadding="0" cellspacing="0" class="table_add" style="margin-top: 3px;margin-bottom: 10px; TABLE-LAYOUT:   fixed;">
			<tr>
				<td width="15%">土地面积</td>
				<td width="35%">
					${projectLand.landBid.area }
				</td>
				<td width="15%">建筑密度</td>
				<td width="35%">
					${projectLand.landBid.density }
				</td>
			</tr>
			<tr>
				<td>容积率</td>
				<td>
					${projectLand.landBid.capacityRate }
				</td>
				<td>出让年限</td>
				<td>
					${projectLand.landBid.sellRears}
				</td>
			</tr>
			<tr>
				<td>竞价起始时间</td>
				<td>
					<s:date name='projectLand.landBid.bidBeginTime' format='yyyy-MM-dd'/>
				</td>
				<td>竞价截止时间</td>
				<td>
					<s:date name='projectLand.landBid.bidEndTime' format='yyyy-MM-dd'/>
				</td>
			</tr>
			<tr>
				<td>拍卖起叫价</td>
				<td>
					${projectLand.landBid.bidBaseMoney}
				</td>
				<td>竞买保证金</td>
				<td>
					${projectLand.landBid.bidMargin }
				</td>
			</tr>
			<tr>
				<td>位置</td>
				<td colspan="3">
					${projectLand.landBid.location}
				</td>
			</tr>
			<tr>
				<td>规划用途</td>
				<td colspan="3">
				<pre>${projectLand.landBid.planApplication }</pre>
	  	
					
				</td>
			</tr>
		</table>
	</div>
	
	<div id="landSellDiv">
    <img src="images/left_go.gif"/>
    <label>国有土地使用权出让合同信息表</label>
		<table cellpadding="0" cellspacing="0" class="table_add" style="margin-top: 3px;margin-bottom: 10px;">
			<tr>
				<td width="15%">土地面积</td>
				<td width="35%">
					${projectLand.landSell.area }
				</td>
				<td width="15%">容积率</td>
				<td width="35%">
					${projectLand.landBid.capacityRate }
				</td>
			</tr>
			<tr>
				<td>土地成交价格</td>
				<td>
					${projectLand.landSell.transactionPrice}
				</td>
				<td>受让方名称</td>
				<td>
					${projectLand.landSell.transfereeName}
				</td>
			</tr>
			<tr>
				<td>土地位置</td>
				<td>
					${projectLand.landSell.location}
				</td>
				<td>签约时间</td>
				<td>
					<s:date name='projectLand.landSell.signTime' format='yyyy-MM-dd'/>
				</td>
			</tr>
			<tr>
				<td>规划用途</td>
				<td colspan="3">
				<pre>${projectLand.landSell.planApplication }</pre>
	  	
					
				</td>
			</tr>
		</table>
	</div>
	
	<div id="landUseDiv">
    <img src="images/left_go.gif"/><label>建设用地审批信息表</label>
		<table cellpadding="0" cellspacing="0" class="table_add" style="margin-top: 3px;margin-bottom: 10px;">
			<tr>
				<td width="15%">项目名称</td>
				<td width="35%">
					${projectLand.landUse.projectName}
				</td>
				<td width="15%">申请单位</td>
				<td width="35%">
					${projectLand.landUse.applyOrgan}
				</td>
			</tr>
			<tr>
				<td>申请用地面积</td>
				<td>
					${projectLand.landUse.applyUseUrea}
				</td>
				<td>批准时间</td>
				<td>
					<s:date name='projectLand.landUse.approvalTime' format='yyyy-MM-dd'/>
				</td>
			</tr>
			<tr>
				<td>用地位置</td>
				<td colspan="3">
					${projectLand.landUse.location}
				</td>
			</tr>
			<tr>
				<td>用地用途</td>
				<td colspan="3">
				<pre>${projectLand.landUse.landUse }</pre>
	  	
					
				</td>
			</tr>
		</table>
	</div>
	
	
    </form>
    <div class="add_savebtn">
    	<a href="javascript:history.back()"><img src="images/back00.gif" border="0" /></a>
    </div>
    
 </div>  <!--right_main-->

</body>