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
    <div class="add_top">发布项目公开信息&nbsp;&gt;&nbsp;发布矿业权审批出让信息&nbsp;&gt;查看</div>
    <div id="landbaseDiv">
    <div class="main_text"><img src="images/left_go.gif"/><label>项目基本信息表</label></div>
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
	<div id="prospectApproveDiv">
    <img src="images/left_go.gif"/><label>探矿权审批信息表</label>
		<table cellpadding="0" cellspacing="0" class="table_add" style="margin-top: 3px;margin-bottom: 10px;">
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
	</div>
	
	<div id="prospectSellDiv">
    <img src="images/left_go.gif"/><label>探矿权出让信息表</label>
		<table cellpadding="0" cellspacing="0" class="table_add" style="margin-top: 3px;margin-bottom: 10px;">
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
					<s:date name='projectMining.prospectSell.bidTime' format='yyyy-MM-dd'/>
				</td>
			</tr>
			
		</table>
	</div>
	
	<div id="mineApproveDiv">
    <img src="images/left_go.gif"/><label>采矿权审批信息表</label>
		<table cellpadding="0" cellspacing="0" class="table_add" style="margin-top: 3px;margin-bottom: 10px;">
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
	</div>
	
	<div id="mineSellDiv">
    <img src="images/left_go.gif"/><label>采矿权出让信息表</label>
		<table cellpadding="0" cellspacing="0" class="table_add" style="margin-top: 3px;">
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
					<s:date name='projectMining.mineSell.bidTime' format='yyyy-MM-dd'/>
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