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
<title>矿业权审批出让信息</title>

</head>

<body>
  <div class="content">
   
  <img src="logo_images/${projectMining.site.code }.jpg"  style="width: 960px;margin-top: 20px;" />
  <div class="main_text">
    <div class="title">※ 矿业权审批出让信息</div>
    <div class="title_sp">
    <h4>项目信息概要</h4>
    <p>
    <table cellpadding="0" cellspacing="0" class="shengpi_list" >
    <tr>
    <th width="15%">项目编码</th>
    <td>${projectMining.code }</td>
    </tr>
    <tr>
    <th>项目名称</th>
    <td>${projectMining.name }</td>
    </tr>
    <!-- 
    <tr>
    <th>建设单位</th>
    <td>${projectMining.constructName }</td>
    </tr> -->
    <tr>
    <th>发布机构</th>
    <td width="35%">${projectMining.site.name }</td>
    </tr>
    <tr>
    <th>发布时间</th>
    <td><s:date name='#projectMining.createTime' format='yyyy-MM-dd'/></td>
    </tr>
    </table>
    </p>
    </div>
    <s:if test="#projectMining.prospectApprove.licenseCode != ''
    	|| #projectMining.prospectApprove.projectName != '' 
    	|| #projectMining.prospectApprove.prospectPerson != '' 
    	|| #projectMining.prospectApprove.reconOrgan != '' 
    	|| #projectMining.prospectApprove.reconMine != '' 
    ">
        <div class="title_sp">
    <h4>探矿权审批信息表</h4>
    <p>
    	<table cellpadding="0" cellspacing="0" class="shengpi_list" >
			<tr>
				<td width="15%">许可证号</td>
				<td width="35%">
					${projectMining.prospectApprove.licenseCode}
				</td>
				<td width="15%">项目名称</td>
				<td width="35%">
					${projectMining.prospectApprove.projectName}
				</td>
			</tr>
			<tr>
				<td>探矿权人</td>
				<td>
					${projectMining.prospectApprove.prospectPerson}
				</td>
				<td>勘察单位</td>
				<td>
					${projectMining.prospectApprove.reconOrgan}
				</td>
			</tr>
			<tr>
				<td>勘察矿种</td>
				<td>
					${projectMining.prospectApprove.reconMine}
				</td>
				<td>有效期</td>
				<td>
					${projectMining.prospectApprove.period}
				</td>
			</tr>
			<tr>
				<td>经纬度</td>
				<td>
					${projectMining.prospectApprove.jingweidu}
				</td>
				<td>勘察面积</td>
				<td>
					${projectMining.prospectApprove.area}
				</td>
			</tr>
			<tr>
				<td>地理位置</td>
				<td>
					${projectMining.prospectApprove.location}
				</td>
				<td>发证机关</td>
				<td>
					${projectMining.prospectApprove.certificationOrgan}
				</td>
			</tr>
		</table>
    </p>
    </div>
    </s:if>
    
    <s:if test="#projectMining.prospectSell.mineName != ''
    	|| #projectMining.prospectSell.mineType != '' 
    	|| #projectMining.prospectSell.area != '' 
    	|| #projectMining.prospectSell.sellType != '' 
    ">
        <div class="title_sp">
    <h4>探矿权出让信息表</h4>
    <p>
    	<table cellpadding="0" cellspacing="0" class="shengpi_list" >
			<tr>
				<td width="15%">探矿区名称</td>
				<td width="35%">
					${projectMining.prospectSell.mineName}
				</td>
				<td width="15%">矿种</td>
				<td width="35%">
					${projectMining.prospectSell.mineType}
				</td>
			</tr>
			<tr>
				<td>面积</td>
				<td>
					${projectMining.prospectSell.area}
				</td>
				<td>经纬度拐点坐标</td>
				<td>
					${projectMining.prospectSell.jinweidu}
				</td>
			</tr>
			<tr>
				<td>出让方式</td>
				<td>
					${projectMining.prospectSell.sellType}
				</td>
				<td>起拍价</td>
				<td>
					${util:showAll(projectMining.prospectSell.bidBaseMoney)}
				</td>
			</tr>
			<tr>
				<td>竞买保证金</td>
				<td>
					${util:showAll(projectMining.prospectSell.bidMargin)}
				</td>
				<td>招标拍卖挂牌时间</td>
				<td>
					<s:date name='#projectMining.prospectSell.bidTime' format='yyyy-MM-dd'/>
				</td>
			</tr>
		</table>
    </p>
    </div>
    </s:if>
    
    <s:if test="#projectMining.mineApprove.licenseCode != '' 
    	|| #projectMining.mineApprove.mineName != '' 
    	|| #projectMining.mineApprove.minePerson != '' 
    	|| #projectMining.mineApprove.area != '' 
    ">
            <div class="title_sp">
    <h4>采矿权审批信息表</h4>
    <p>
    	<table cellpadding="0" cellspacing="0" class="shengpi_list" >
			<tr>
				<td width="15%">许可证号</td>
				<td width="35%">
					${projectMining.mineApprove.licenseCode}
				</td>
				<td width="15%">矿山名称</td>
				<td width="35%">
					${projectMining.mineApprove.mineName}
				</td>
			</tr>
			<tr>
				<td>采矿权人</td>
				<td>
					${projectMining.mineApprove.minePerson}
				</td>
				<td>有效期</td>
				<td>
					${projectMining.mineApprove.period}
				</td>
			</tr>
			<tr>
				<td>经纬度</td>
				<td>
					${projectMining.mineApprove.jingweidu}
				</td>
				<td>总面积</td>
				<td>
					${projectMining.mineApprove.area}
				</td>
			</tr>
			<tr>
				<td>矿种</td>
				<td>
					${projectMining.mineApprove.mineType}
				</td>
				<td>发证机关</td>
				<td>
					${projectMining.mineApprove.certificationOrgan}
				</td>
			</tr>
			
		</table>
    </p>
    </div>
    </s:if>
    
    <s:if test="#projectMining.mineSell.mineName != ''
    	|| #projectMining.mineSell.mineType != '' 
    	|| #projectMining.mineSell.area != '' 
    	|| #projectMining.mineSell.sellType != '' 
    ">
     <div class="title_sp">
    <h4>采矿权出让信息表</h4>
    <p>
    	<table cellpadding="0" cellspacing="0" class="shengpi_list" >
			<tr>
				<td width="15%">采矿权名称</td>
				<td width="35%">
					${projectMining.mineSell.mineName}
				</td>
				<td width="15%">矿种</td>
				<td width="35%">
					${projectMining.mineSell.mineType}
				</td>
			</tr>
			<tr>
				<td>面积</td>
				<td>
					${projectMining.mineSell.area}
				</td>
				<td>经纬度拐点坐标</td>
				<td>
					${projectMining.mineSell.jingweidu}
				</td>
			</tr>
			<tr>
				<td>出让方式</td>
				<td>
					${projectMining.mineSell.sellType}
				</td>
				<td>起拍价</td>
				<td>
					${util:showAll(projectMining.mineSell.bidBaseMoney)}
				</td>
			</tr>
			<tr>
				<td>竞买保证金</td>
				<td>
					${util:showAll(projectMining.mineSell.bidMargin)}
				</td>
				<td>拍卖时间</td>
				<td>
					<s:date name='#projectMining.mineSell.bidTime' format='yyyy-MM-dd'/>
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
