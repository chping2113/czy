<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/include/core.jsp"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>发布项目编码信息</title>
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
		
		var style = $(".twopage_left_text a").first().attr("style");
		
		$(".twopage_left_text a").bind("click", function() {
			$(this).attr("style",style);
		//	$(this).siblings().attr("style","background-color:#cccccc");
		});
	});
	var pageNo = "${pageNo}";
	function doDelete(id) {
		showConfirm("确定删除该条记录吗？", "doConfirmDelete("+id+")");
	}
	
	function doConfirmDelete(id) {
		location.href = "projectCoder_delete.action?pageNo=" + pageNo + "&id=" + id;
	}
	function clearText(title){
		$('#'+title).attr("value","");
	}

	function doCommit(id) {
		showConfirm("您确定要生成项目编码吗？", "doConfirmCommit("+id+")");
	}
	
	function doConfirmCommit(id) {
		location.href = "projectCoder_add.action?id="+id+"&type=3&pageNo=" + pageNo;
	}
</script>
</head>



<body>
<div class="content">

<div class="top">
   <div class="logo">
   		<img src="logo_images/340000000.jpg" />

   </div>
 </div>
  <div class="middle">
    
    
    <div class="search">
  <div class="search_bg">
  <div class="search_title">快速搜索</div>
  <div class="search_text">
    <form action="projectCoder_query.action" method="post">
    <input type="text" class="search_input" id="title"  name="queryStr" value="${empty sessionScope.projectCoder_queryStr ? "请输入项目名称" : sessionScope.projectCoder_queryStr }" onclick="clearText('title')"/>
       <input type="image" src="imgage/search2.gif" class="search_img" onclick="deleteDefaultText('#title','请输入项目名称')"/>
   	</form>
   </div>
 </div>
 </div>
   <div class="open_news">
 <div class="open_news_top">
<span class="span_left">项目编码信息</span>

<span class="span_more"><a href="projectCoder_initAdd.action?type=1"> > 新建<</a></span></div>
 <div class="open_news_text">  
    
    
    

    <table cellpadding="0" cellspacing="0" class="table_list">
    <tr>
      <th>项目名称</th>
      <th>项目编码</th>
      <th>操作</th>
     </tr>
     <s:iterator value="pageInfo.pageData" var="pro">
     <tr>
       <td>${pro.projectName }</td>
       <td>${util:limitText(pro.projectCode,60) }</td>
       
       <td  align="center" class="abtn">
       
      	<a href="projectCoder_view.action?id=${pro.id }">查看</a>
      	<s:if test="state!=1">
		<a href="projectCoder_initAdd.action?id=${pro.id }&type=2">修改</a>
		<a href="javascript:doCommit(${pro.id })">生成项目编码</a>
		<a href="javascript:doDelete(${pro.id })">删除</a>
		</s:if>
      </td>
     </tr>
     </s:iterator>
     </table>
     
      </div>
<div class="open_news_btm"></div>
</div><!--open_text-->
     <div class="page">
     	<brady:page url="projectCoder_query.action" pageInfo="${pageInfo }" />
     </div>
 </div> <!--middle DIV-->

 <div class="bottom">
<p>
承　办：安徽省推进工程建设领域项目信息公开和诚信体系建设专项工作组办公室       技术支持：中国电信安徽分公司       备案号： 皖ICP备09014608号 
<br />
协　办：省经济和信息化委　省委宣传部　省检察院　省发展改革委　省监察厅　省财政厅　省住房城乡建设厅　省交通运输厅  省商务厅　省水利厅　省工商局　
        省法制办
        <br /><span>人民银行合肥中心支行　省招标局　省政务服务中心</span></p>
 


</div> <!--bottom DIV-->
</div><!--content DIV-->
  <brady:dialog title="信用档案查询" onClickOK="doSave()" width="650" height="340"/>
  <brady:confirm />
</body>