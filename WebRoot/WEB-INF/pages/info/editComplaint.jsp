<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/include/core.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理-添加通知公告信息</title>
<script type="text/javascript" src="js/info/complaint.js"></script>
<script type="text/javascript">
	var pageNo = "${empty pageNo ? 0 : pageNo}";
	
	$(function(){
		$.brady.validator.validate("addForm", validator_config1); //初始化表单验证构架
	});
</script>

</head>

<body>
<div class="add_text">
	<form id="addForm" action="info/complaint_${id > 0 ? 'edit' : 'add' }.action" method="post">
	<input type="hidden" name="id" value="${empty id ? '0' : id }" />
	<input type="hidden" name="pageNo" value="${empty pageNo ? '1' : pageNo}" />
	
    <table cellpadding="0" cellspacing="0" class="table_add" >
    	<tr>
    		<th>举报主题</th>
    		<td>${title }</td>
    	</tr>
    	<tr>
    		<th width="20%">姓名</th>
    		<td>${name }</td>
    	</tr>
    	<tr>
    		<th>单位</th>
    		<td>${dept }</td>
    	</tr>
    	<tr>
    		<th>联系地址</th>
    		<td>${address }</td>
    	</tr>
    	<tr>
   		 	<th>联系电话</th>
    		<td>${tel }</td>
    	</tr>
    	<tr>
    		<th>E-mail</th>
    		<td>${email }</td>
    	</tr>
    	<tr>
    		<th>举报内容</th>
    		<td>${content }</td>
    	</tr>
    	<tr>
    		<th>处理意见</th>
    		<td><textarea name="deal" id="complaint_deal" cols="45" rows="5" style="border:1px solid #cac098;width:310px;height:120px;">${deal }</textarea></td>
    	</tr>
	</table>
    </form> 
    
</div> 
</body>
</html>