<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/include/core.jsp"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>项目信息和信用信息公开进度合计</title>
<link href="css/bm_main.css" rel="stylesheet" />
<link href="css/styles.css" rel="stylesheet" />
<link href="css/humanity/jquery-ui.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="css/smallslider.css"/>

<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.6.min.js"></script>
<script type="text/javascript" src="js/jquery.ui.datepicker-zh-CN.js"></script>
<script type="text/javascript" src="js/jquery.brady-min.js"></script>
<script type="text/javascript" src="js/jquery.smallslider.js"></script>
<script type="text/javascript" src="js/index.js"></script>
<style type="text/css">
	.twopage_left_text ul li a {
		display:block;
		line-height: 30px;
		margin: 10px;
	}
</style>
<script type="text/javascript">
function deleteDefaultText(id,temp) {
	var title = $(id).val();
	if(title == temp){
		$(id).val("");
	}
}
function clearText(title){
	$('#'+title).attr("value","");
}
	
	$(function() {
		
		$("#startTime").datepicker({
			changeYear:true,
			changeMonth: true,
			onSelect: function(dateText, inst) {
				$("#createTime").blur();
			}
		});

		$("#endTime").datepicker({
			changeYear:true,
			changeMonth: true,
			onSelect: function(dateText, inst) {
				$("#endTime").blur();
			}
		});
	});
</script>
</head>



<body>
<div class="content">

<jsp:include page="${headPath }" />
  <div class="middle">
    
    <!--  
    
    <div class="search">
  <div class="search_bg">
  <div class="search_title">快速搜索</div>
  <div class="search_text">
    <form action="pub_dataQuery.action" method="post">
    <input size="10" type="text" class="search_input2" id="title"  name="queryStr" value="${empty queryStr ? "请输入发布单位" : queryStr }" onclick="clearText('title')"/>
       时间：<input type="text" name="startTime" id="startTime" class="calendar input_text" value="<s:date name='startTime' format='yyyy-MM-dd'/>"  readonly="readonly"/>
     
       <input type="text" name="endTime" id="endTime" class="calendar input_text" value="<s:date name='endTime' format='yyyy-MM-dd'/>"   readonly="readonly"/>
       &nbsp;&nbsp;&nbsp;&nbsp;
       <input type="image" src="imgage/search2.gif" class="search_img" onclick="deleteDefaultText('#title','请输入发布单位')"/>
   	</form>
   </div>
 </div>
 </div>
 -->
   <div class="open_news">
 <div class="open_news_top">
<span class="span_left">项目信息和信用信息公开进度合计　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　<a href="pub_excelExport.action?type=${type }&code=${o_code }">导出Excel</a></span>

</div>
 <div class="open_news_text">  
    
    
    

  	<table cellpadding="0" cellspacing="0" class="table_list2">
  		
  		<tr>
  			<th>发布单位</th>
 	 		<th>项目审批信息</th>
  			<th>建设管理信息</th>
  			<th>土地权信息</th>
  			<th>矿业权信息</th>
  			<th>招投标信息</th>
  			<th>单位信用等级公告</th>
  			<th>单位基本信息</th>
  			<th>单位资质信息</th>
  			<th>个人资质信息</th>
  			<th>单位良好信息</th>
  			<th>单位不良信息</th>
  			<th>总数</th>
  		</tr>
  		
  		<s:iterator value="#dataCountList" var="dc" status="status1">
  		<s:if test="#status1.last == false">
  		<tr>
  		<s:if test="#dc.site==null"><td style="border-bottom:none;">合计</td></s:if>
  		<s:else>
  		<s:if test="#type==2 || #type==3">
  		<td><a href="pub_showDetail.action?code=${dc.site.code }">${dc.site.name }</a></td>
  		</s:if>
  		<s:else>
  		<s:if test="#dc.site.code=='340000004' || #dc.site.code=='340000023' || #dc.site.code=='340000027'"><td><a href="pub_showDetail.action?code=${dc.site.code }">${dc.site.name }</a></td></s:if>
  		<s:else>
  		<td>${dc.site.name }</td>
  		</s:else>
  		</s:else>
  		</s:else>
  			
  			<td>${dc.projectApproveCount }</td>
  			<td>${dc.projectConstructCount }</td>
  			<td>${dc.projectLandCount }</td>
  			<td>${dc.projectMiningCount }</td>
  			<td>${dc.projectAimCount }</td>
  			<td>${dc.companyCreditCount }</td>
  			<td>${dc.companyInfoCount }</td>
  			<td>${dc.companyQualificationCount }</td>
  			<td>${dc.personQualificationCount }</td>
  			<td>${dc.companyHonorCount }</td>
  			<td>${dc.companyBadrecordCount }</td>
  			<td>${dc.allCount }</td>
  		</tr>
  		</s:if>
    	<s:else>
  		<tr>
  		
  		<s:if test="#dc.site==null"><td style="border-bottom:none;color:red">合计</td></s:if>
  		<s:else>
  		<s:if test="#type==2 || #type==3">
  		<td style="border-bottom:none;"><a href="pub_showDetail.action?code=${dc.site.code }">${dc.site.name }</a></td>
  		</s:if>
  		<s:else>
  		<s:if test="#dc.site.code=='340000004' || #dc.site.code=='340000023' || #dc.site.code=='340000027'"><td style="border-bottom:none;"><a href="pub_showDetail.action?code=${dc.site.code }">${dc.site.name }</a></td></s:if>
  		<s:else>
  		<td style="border-bottom:none;">${dc.site.name }</td>
  		</s:else>
  		
  		</s:else>
  		</s:else>
  			<td style="border-bottom:none;color:red" >${dc.projectApproveCount }</td>
  			<td style="border-bottom:none;color:red" >${dc.projectConstructCount }</td>
  			<td style="border-bottom:none;color:red" >${dc.projectLandCount }</td>
  			<td style="border-bottom:none;color:red" >${dc.projectMiningCount }</td>
  			<td style="border-bottom:none;color:red" >${dc.projectAimCount }</td>
  			<td style="border-bottom:none;color:red" >${dc.companyCreditCount }</td>
  			<td style="border-bottom:none;color:red" >${dc.companyInfoCount }</td>
  			<td style="border-bottom:none;color:red" >${dc.companyQualificationCount }</td>
  			<td style="border-bottom:none;color:red" >${dc.personQualificationCount }</td>
  			<td style="border-bottom:none;color:red" >${dc.companyHonorCount }</td>
  			<td style="border-bottom:none;color:red" >${dc.companyBadrecordCount }</td>
  			<td style="border-bottom:none;color:red" >${dc.allCount }</td>
  		</tr>
  		</s:else>
  		</s:iterator>
  		
  	</table>
     
      </div>
<div class="open_news_btm"></div>
</div><!--open_text-->
     
 </div> <!--middle DIV-->


 <div class="bottom">
${session_homePage.footer }

</div> <!--bottom DIV-->
</div><!--content DIV-->
  <brady:dialog title="信用档案查询" onClickOK="doSave()" width="650" height="340"/>
  <brady:confirm />
</body>