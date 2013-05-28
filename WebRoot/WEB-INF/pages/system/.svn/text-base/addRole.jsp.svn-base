<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/include/core.jsp"%>

<script type="text/javascript">

$(function(){
	$.brady.validator.validate("addForm", validator_config); //初始化表单验证构架
});
</script>

<div class="add_text">
	<form id="addForm" action="system/role_${id > 0 ? 'edit' : 'add' }.action" method="post">
	<input type="hidden" name="id" value="${empty id ? '0' : id }" />
	<input type="hidden" name="pageNo" value="${empty pageNo ? '1' : pageNo}" />
	
    <table cellpadding="0" cellspacing="0" class="table_add">
     <tr>
      <th width="12%">角色名称</th>
      <td>
      	<s:if test="id > 0">
      		${name }
      	</s:if>
      	<s:else>
      		<input type="text" id="name" name="name" value="${name }" class="input_text_big" maxlength="20"/>
      	</s:else>
      	</td>
     </tr>
     
     <tr>
      <th width="12%">角色描述</th>
      <td><input type="text" id="descrip" name="descrip" value="${descrip }" class="input_text_big" maxlength="50"/></td>
     </tr>
       <tr>
      <th>类型</th>
      <td>
      	<select id="type" name="type" class="input_text">
      		<option value="1"  ${type==1?'selected="selected"':''}>管理员</option>
      		<option value="2"  ${type==2?'selected="selected"':''}>政府部门用户</option>
      		<option value="3"  ${type==3?'selected="selected"':''}>项目建设单位</option>
      	</select>
      </td>
      </tr>
    </table>
    </form> 
    
</div>