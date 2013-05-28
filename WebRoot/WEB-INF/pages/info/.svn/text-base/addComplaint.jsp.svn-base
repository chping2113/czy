<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/include/core.jsp"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>投诉举报-投诉举报填写</title>
<link href="css/ah_main.css"  rel="stylesheet" type="text/css"/>
<script charset="utf-8" src="editor/kindeditor-min.js"></script>
<script type="text/javascript" src="js/info/complaint.js"></script>
<script type="text/javascript">
	var pageNo = "${empty pageNo ? 0 : pageNo}";
	
	$(function(){
		$.brady.validator.validate("addForm", validator_config); //初始化表单验证构架
	});
</script>

</head>

<body>
<div class="middle">
<div class="left_middle">
   	<div class="twopage_left">
      	<div class="twopage_left_top">★ 举报信箱使用需知 ★</div>
      	<div class="twopage_left_P">
      	<p>
       <span>一、受理举报范围</span><br />
全省工程建设领域项目信息和信用信息公开共享工作中， 在项目建设决策、招标投资、项目实施和工程质量、物资采购和资金使用等方面存在的违反相关法律法规的行为。<br /> 
<span>二、注意事项</span><br />
1、举报人应据实举报，不得捏造事实，制造假证，诬告陷害他人。对举报陷害他人的依有关规定严肃处理；构成犯罪的移送司法机关依法办理。<br />
2、提倡实名举报，属实名举报的请填写详细联系方式。<br />
3、请如实填写举报表单中的各栏目。填写“举报内容”一栏时，力求详尽，对违反法律法规行为发生的时间、地点、主要证据和涉及人员等要交待明确。<br />
4、本举报信箱将严明工作纪律，以防止举报信息和举报人真实身份泄露。
 </p>
		</div>
 	</div>
</div>
<div class="right_middle">
	<div class="twopage_top">
	<div class="add_news">
	<div class="title">※ 我要投诉举报</div>
	<form id="addForm" action="info/complaint_${id > 0 ? 'edit' : 'add' }.action" method="post">
	<input type="hidden" name="id" value="${empty id ? '0' : id }" />
	<input type="hidden" name="pageNo" value="${empty pageNo ? '1' : pageNo}" />
	
    <table cellpadding="0" cellspacing="0" class="zhuce_list" >
    	<tr>
    		<th width="33%">姓名</th>
    		<td><input type="text" name="name" id="complaint_name" class="zhuce_list_input" value="${name }"/><span>*</span> [填写注意事项：带“*”为必添项] </td>
    	</tr>
    	<tr>
    		<th>单位</th>
    		<td><input type="text" name="dept" id="complaint_dept" class="zhuce_list_input" value="${dept }"/><span>*</span></td>
    	</tr>
    	<tr>
    		<th>联系地址</th>
    		<td><input type="text" name="address" id="complaint_address" class="zhuce_list_input" value="${address }"/></td>
    	</tr>
    	<tr>
   		 	<th>联系电话</th>
    		<td><input type="text" name="tel" id="complaint_tel"  class="zhuce_list_input" value="${tel }"/><span>*</span></td>
    	</tr>
    	<tr>
    		<th>E-mail</th>
    		<td><input type="text" name="email" id="complaint_email"  class="zhuce_list_input" value="${email }"/><span>*</span></td>
    	</tr>
    	<tr>
    		<th>举报主题</th>
    		<td><input type="text" name="title" id="complaint_title"  class="zhuce_list_input" value="${title }"/><span>*</span></td>
    	</tr>
    	<tr>
    		<th>举报内容</th>
    		<td><textarea name="content" id="complaint_content" cols="45" rows="5" class="zhuce_list_textarea">${content }</textarea><span>*</span></td>
    	</tr>
	</table>
    </form> 
    
    <div class="add_savebtn">
    	<a href="javascript:doSave()"><img src="images/save.gif" border="0"/></a>
    	<a href="info/complaint_addRequest"><img src="images/back00.gif" border="0" /></a></div>
    </div>
	</div> 
</div>
</div>
 
   
</body>
</html>
