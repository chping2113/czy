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
<style type=""></style>
<title>土地权审批出让信息</title>

</head>

<body>
  <div class="content">
    
  <img src="logo_images/${projectLand.site.code }.jpg"  style="width: 960px;margin-top: 20px;" />
  <div class="main_text">
    <div class="title">※ 土地权审批出让信息</div>
    <div class="title_sp">
    <h4>项目信息概要</h4>
    <p>
    <table cellpadding="0" cellspacing="0" class="shengpi_list" >
    <tr>
    <th width="15%">项目编码</th>
    <td>${projectLand.code }</td>
    </tr>
    <tr>
    <th>项目名称</th>
    <td>${projectLand.name }</td>
    </tr>
    <!-- 
    <tr>
    <th>建设单位</th>
    <td>${projectLand.constructName }</td>
    </tr> -->
    <tr>
    <th>发布机构</th>
    <td width="35%">${projectLand.site.name }</td>
    </tr>
    <tr>
    <th>发布时间</th>
    <td><s:date name='#projectLand.createTime' format='yyyy-MM-dd'/></td>
    </tr>
    </table>
    </p>
    </div>
    
    <s:if test="#projectLand.landBid.area != ''
    	|| #projectLand.landBid.location != ''
    	|| #projectLand.landBid.planApplication != ''
    ">
    <div class="title_sp">
    <h4>土地招标拍卖挂牌出让信息表</h4>
    <p>
    	<table cellpadding="0" cellspacing="0" class="shengpi_list" >
			<tr>
				<td width="15%">土地面积</td>
				<td width="35%">
					${projectLand.landBid.area}
				</td>
				<td width="15%">建筑密度</td>
				<td width="35%">
					${projectLand.landBid.density}
				</td>
			</tr>
			<tr>
				<td>容积率</td>
				<td>
					${projectLand.landBid.capacityRate}
				</td>
				<td>出让年限</td>
				<td>
					${projectLand.landBid.sellRears} 
				</td>
			</tr>
			<tr>
				<td>竞价起始时间</td>
				<td>
					<s:date name='#projectLand.landBid.bidBeginTime' format='yyyy-MM-dd' />
				</td>
				<td>竞价截止时间</td>
				<td>
					<s:date name='#projectLand.landBid.bidEndTime' format='yyyy-MM-dd'/>
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
					${projectLand.landBid.planApplication }
				</td>
			</tr>
		</table>
    </p>
    </div>
    </s:if>
    
    <s:if test="#projectLand.landSell.area != ''
    			|| #projectLand.landSell.transfereeName != ''
    			|| #projectLand.landSell.location != ''
    			|| #projectLand.landSell.planApplication != ''
    ">
    <div class="title_sp">
    <h4>国有土地使用权出让合同信息表</h4>
    <p>
    	<table cellpadding="0" cellspacing="0" class="shengpi_list" >
			<tr>
				<td width="15%">土地面积</td>
				<td width="35%">
					${projectLand.landSell.area}
				</td>
				<td width="15%">容积率</td>
				<td width="35%">
					${projectLand.landSell.capacityRate}
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
					<s:date name='#projectLand.landSell.signTime' format='yyyy-MM-dd'/>
				</td>
			</tr>
			<tr>
				<td>规划用途</td>
				<td colspan="3">
					${projectLand.landSell.planApplication }
				</td>
			</tr>
		</table>
    </p>
    </div>
    </s:if>
    <s:if test="#projectLand.landUse.projectName != '' 
    	|| #projectLand.landUse.applyOrgan != ''
    	|| #projectLand.landUse.applyUseUrea != ''
    	|| #projectLand.landUse.location != ''
    	|| #projectLand.landUse.landUse != ''
    	">
        <div class="title_sp">
    <h4>建设用地审批信息表</h4>
    <p>
    	<table cellpadding="0" cellspacing="0" class="shengpi_list" >
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
					<s:date name='#projectLand.landUse.approvalTime' format='yyyy-MM-dd'/>
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
					${projectLand.landUse.landUse }
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
