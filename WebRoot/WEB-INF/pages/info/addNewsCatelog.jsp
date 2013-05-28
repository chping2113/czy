<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/include/core.jsp"%>


<script type="text/javascript">

$(function(){
	$.brady.validator.validate("addForm", validator_config); //初始化表单验证构架
});
</script>

<div class="add_text">
	<form id="addForm" action="info/newsCatelog_${id > 0 ? 'edit' : 'add' }.action" method="post">
	<input type="hidden" name="id" value="${empty id ? '0' : id }" />
	<input type="hidden" name="pageNo" value="${empty pageNo ? '1' : pageNo}" />
	
    <table cellpadding="0" cellspacing="0" class="table_add">
    <s:if test="#parentCatelog != null">
     <tr>
      <th width="15%">上级栏目</th>
      <td>
      	${parentCatelog.title }
      	<input type="hidden" name="parentId" value="${parentCatelog.id }" /> 
      </td>
     </tr>
     </s:if>
     <tr>
      <th width="15%">栏目标题</th>
      <td><input type="text" id="newsCatelog_title" name="title" value="${title }" class="input_text_big" maxlength="10"/></td>
     </tr>
     
     <tr>
      <th width="15%">显示顺序</th>
      <td><input type="text" id="showOrder" name="showOrder" value="${showOrder }" class="input_text_small" maxlength="50"/></td>
     </tr>
     
     <tr>
      <th width="15%">描述信息</th>
      <td><input type="text" id="descrip" name="descrip" value="${descrip }" class="input_text_big" maxlength="100"/></td>
     </tr>
    </table>
    </form> 
    
</div>