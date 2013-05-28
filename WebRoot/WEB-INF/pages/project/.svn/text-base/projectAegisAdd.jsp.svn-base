<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/include/core.jsp"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理-添加重点项目</title>
<script charset="utf-8" src="editor/kindeditor-min.js"></script>
<script type="text/javascript" src="js/projectFocus.js"></script>
<script type="text/javascript">
	var pageNo = "${empty pageNo ? 0 : pageNo}";
	
	$(function(){
		$.brady.validator.validate("addForm", validator_config); //初始化表单验证构架
	});
</script>

</head>

<body>
<div class="">
	<form id="addForm" action="project/projectAegis_${id > 0 ? 'edit' : 'add' }.action" method="post">
	<input type="hidden" name="id" value="${empty id ? '0' : id }" />
	<input type="hidden" name="pageNo" value="${empty pageNo ? '1' : pageNo}" />
	
    <table cellpadding="0" cellspacing="0" class="table_add">
     <tr>
      <th width="20%">类型名称</th>
      <td><input type="text" id="name" name="name" value="${name }" class="zhuce_list_input" maxlength="30"/></td>
     </tr>
     
     <tr>
      <th width="20%">显示顺序</th>
      <td><input type="text" id="showOrder" name="showOrder" value="${showOrder }" class="zhuce_list_input" maxlength="11"/></td>
     </tr>
    </table>
    </form>
    
    <!--div class="add_savebtn">
    	<a href="javascript:doSave()"><img src="images/save.gif" border="0"/></a>
    	<a href="project/projectAegis_list.action"><img src="images/back00.gif" border="0" /></a>
    </div-->
</div>
 
</body>
</html>
