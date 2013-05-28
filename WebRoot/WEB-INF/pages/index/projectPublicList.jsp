<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/include/core.jsp"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>项目信息公开</title>
<link href="css/jxw_main.css"  rel="stylesheet" type="text/css"/>

<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<style type="text/css">
	.twopage_left_text ul li a {
		display:block;
		line-height: 30px;
		margin: 10px;
	}
</style>
<script type="text/javascript">
function test(objId){
	return document.getElementById(objId);
}
function changeId(idName,obj,tab){
	test(idName).id="";
	obj.id=idName;
	obj.blur();
}
	function rightMiddle(url){
		var param = {};
		$.post(url, param, function(date) {
			$("#right_middle_div").html(date);
		});
	}
	$(function() {
		
		var style = $(".twopage_left a").first().attr("style");
		
		$(".twopage_left a").bind("click", function() {
			$(this).attr("style",style);
		//	$(this).siblings().attr("style","background-color:#cccccc");
		});
	});
</script>
</head>



<body>
<div class="content">

<%@ include file="templateHead.jsp"%>
  <div class="middle">
    <div class="left_middle">
    
     
    
    <div class="twopage_left">
    <div class="news">
      <div class="twopage_left_top"></div>
      <div class="twopage_text">
      <div class="news_text_top"></div>
      <ul class="twopage_text_ul">
	       <s:if test="prostate==3">
	       		<li id="visited">项目审批信息公开</li>
	       </s:if>
	       <s:elseif test="prostate==4">
	       		<li id="visited">项目建设管理公开信息</li>
	       </s:elseif>
	       <s:elseif test="prostate==5">
	       		<li id="visited">土地权审批出让信息</li>
	       </s:elseif>
	       <s:elseif test="prostate==11">
	       		<li id="visited">招投标信息</li>
	       </s:elseif>
	       <s:elseif test="prostate==12">
	       		<li id="visited">矿业权审批出让信息</li>
	       </s:elseif>
	       <s:else>
		       <li>
		      	 <s:if test="#session.session_homePage.approve!=0">
		       		<a id="visited" href="javascript:rightMiddle('pub_projectPublicApprove.action?code=${code }')" onclick="changeId('visited',this)">项目审批信息公开</a>
					</s:if>
		      	 <s:if test="#session.session_homePage.construct!=0">
					<a href="javascript:rightMiddle('pub_projectPublicConstruct.action?code=${code }')" onclick="changeId('visited',this)">项目建设管理公开信息</a>
					</s:if>
		      	 <s:if test="#session.session_homePage.land!=0">
					<a href="javascript:rightMiddle('pub_projectPublicLand.action?code=${code }')" onclick="changeId('visited',this)">土地权审批出让信息</a>
					
					</s:if>
		      	 <s:if test="#session.session_homePage.mining!=0">
		      	 <a href="javascript:rightMiddle('pub_projectPublicMining.action?code=${code }')" onclick="changeId('visited',this)">矿业权审批出让信息</a>
					</s:if>
		      	 <s:if test="#session.session_homePage.aim!=0">
					<a href="javascript:rightMiddle('pub_projectPublicAim.action?code=${code }')" onclick="changeId('visited',this)">招投标信息</a>
		     	</s:if>
		     	</li>
	       </s:else>
			
		<!-- <li >
			<a href="javascript:rightMiddle('pub_projectPublicConstruct.action')">项目建设管理公开信息</a>
		</li>
		<li >
			<a href="javascript:rightMiddle('pub_projectPublicLand.action')">土地矿业审批出让信息</a>
		</li> -->
       </ul>
   
 </div>
      <div class="news_text_btm"></div>
 </div>
     </div>
    </div> <!--left_middle-->
    <div id="right_middle_div" class="right_middle">
    	<div class="twopage_top">
	       <s:if test="prostate==3">
	       		项目审批信息公开
	       </s:if>
	       <s:elseif test="prostate==4">
	       		项目建设管理公开信息
	       </s:elseif>
	       <s:elseif test="prostate==5">
	       		土地权审批出让信息
	       </s:elseif>
	       <s:elseif test="prostate==12">
	       		矿业权审批出让信息
	       </s:elseif>
	       <s:elseif test="prostate==11">
	       		招投标信息
	       </s:elseif>
	       <s:else>
    			项目审批信息公开
	       </s:else>
    	</div>
      <div >
      
      
 <s:if test="prostate==3 || post==1">
  				 <table cellpadding="0" cellspacing="0" class="table_list">
  <tr>
  <th>项目编码</th>
  <th>项目名称</th>
  <th>发布机关</th>
  <th>发布时间</th>
  </tr>
  <s:iterator value="pageInfo.pageData" var="pa">
  <tr>
  <td><a href="pub_showProjectApprove.action?id=${pa.projectApprove.id}&title=1" target="_blank">${pa.projectApprove.code }</a></td>
  <td>${util:limitText(pa.projectApprove.name,28) }</td>
  <td>${pa.site.name }</td>
  <td><s:date name="#pa.createTime" format="yyyy-MM-dd" /></td>
  </tr>
  </s:iterator>
  </table> </s:if>
	       <s:elseif test="prostate==4 || post==2">
  				<table cellpadding="0" cellspacing="0" class="table_list">
			<tr>
				<th>
					项目编码
				</th>
				<th>
					项目名称
				</th>
				<th>
					发布机关
				</th>
				<th>
					发布时间
				</th>
			</tr>
			<s:iterator value="pageInfo.pageData" var="projectConstruct">
				<tr>
					<td>
						<a href="pub_showProjectConstruct.action?id=${projectConstruct.id}&title=1"
							target="_blank">${projectConstruct.code }</a>
					</td>
					<td>
						${util:limitText(projectConstruct.name,28) }
					</td>
					<td>
						${projectConstruct.site.name }
					</td>
					<td>
						<s:date name="#projectConstruct.createTime"
							format="yyyy-MM-dd" />
					</td>
				</tr>
			</s:iterator>
		</table>
		</s:elseif>
	       <s:elseif test="prostate==5 || post==3">
  				<table cellpadding="0" cellspacing="0" class="table_list">
			<tr>
				<th>
					项目编码
				</th>
				<th>
					项目名称
				</th>
				<th>
					发布机关
				</th>
				<th>
					发布时间
				</th>
			</tr>
			<s:iterator value="pageInfo.pageData" var="ProjectLand">
				<tr>
					<td>
						<a href="pub_showProjectLand.action?id=${ProjectLand.id}"
							target="_blank">${ProjectLand.code }</a>
					</td>
					<td>
						${ProjectLand.name }
					</td>
					<td>
						${ProjectLand.site.name }
					</td>
					<td>
						<s:date name="#ProjectLand.createTime"
							format="yyyy-MM-dd" />
					</td>
				</tr>
			</s:iterator>
		</table>
		  </s:elseif>
		  
		  
		  
	       <s:elseif test="prostate==12 || post==4">
  				<table cellpadding="0" cellspacing="0" class="table_list">
			<tr>
				<th>
					项目编码
				</th>
				<th>
					项目名称
				</th>
				<th>
					发布机关
				</th>
				<th>
					发布时间
				</th>
			</tr>
			<s:iterator value="pageInfo.pageData" var="ProjectMining">
				<tr>
					<td>
						<a href="pub_showProjectMining.action?id=${ProjectMining.id}"
							target="_blank">${ProjectMining.code }</a>
					</td>
					<td>
						${ProjectMining.name }
					</td>
					<td>
						${ProjectMining.site.name }
					</td>
					<td>
						<s:date name="#ProjectMining.createTime"
							format="yyyy-MM-dd" />
					</td>
				</tr>
			</s:iterator>
		</table>
		  </s:elseif>
		  
	       <s:elseif test="prostate==11 || post==5">
	       <table cellpadding="0" cellspacing="0" class="table_list">
			<tr>
				<th>
					项目编码
				</th>
				<th>
					项目名称
				</th>
				<th>
					发布机关
				</th>
				<th>
					发布时间
				</th>
			</tr>
			<s:iterator value="pageInfo.pageData" var="projectAim">
				<tr>
					<td>
						<a href="pub_showProjectAim.action?id=${projectAim.id}&title=1"
							target="_blank">${projectAim.code }</a>
					</td>
					<td>
						${util:limitText(projectAim.name,28) }
					</td>
					<td>
						${projectAim.site.name }
					</td>
					<td>
						<s:date name="#projectAim.createTime"
							format="yyyy-MM-dd" />
					</td>
				</tr>
			</s:iterator>
		</table>
	       </s:elseif>
 <s:else>	 <table cellpadding="0" cellspacing="0" class="table_list">
  <tr>
  <th>项目编码</th>
  <th>项目名称</th>
  <th>发布机关</th>
  <th>发布时间</th>
  </tr>
  <s:iterator value="pageInfo.pageData" var="pa">
  <tr>
  <td><a href="pub_showProjectApprove.action?id=${pa.projectApprove.id}&title=1" target="_blank">${pa.projectApprove.code }</a></td>
  <td>${util:limitText(pa.projectApprove.name,28) }</td>
  <td>${pa.site.name }</td>
  <td><s:date name="#pa.createTime" format="yyyy-MM-dd" /></td>
  </tr>
  </s:iterator>
  </table></s:else>
  <div class="page">
	       <s:if test="prostate==3">
  				<brady:page url="pub_searchAll.action?id=3&message=4&searchOrganCode=${searchOrganCode }" pageInfo="${pageInfo }" />
	       </s:if>
	       <s:elseif test="prostate==4">
  				<brady:page url="pub_searchAll.action?id=4&message=4&searchOrganCode=${searchOrganCode }" pageInfo="${pageInfo }" />
	       </s:elseif>
	       <s:elseif test="prostate==5">
  				<brady:page url="pub_searchAll.action?id=5&message=4&searchOrganCode=${searchOrganCode }" pageInfo="${pageInfo }" />
	       </s:elseif>
	       <s:elseif test="prostate==12">
  				<brady:page url="pub_searchAll.action?id=5&message=4&searchOrganCode=${searchOrganCode }" pageInfo="${pageInfo }" />
	       </s:elseif>
	       <s:elseif test="prostate==11">
  				<brady:page url="pub_searchAll.action?id=11&message=4&searchOrganCode=${searchOrganCode }" pageInfo="${pageInfo }" />
	       </s:elseif>
	       <s:else>
  				<brady:page url="pub_navProjectPublic.action?message=4&searchOrganCode=${searchOrganCode }&code=${code }" pageInfo="${pageInfo }" />
	       </s:else>
  </div>

 
    </div> 
  </div><!--right_middle-->
 </div> <!--middle DIV-->
 <div class="bottom">
${session_homePage.footer }

</div> <!--bottom DIV-->
</div><!--content DIV-->
</body>
</html>
