<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/include/core.jsp"%>

<script type="text/javascript">

$(function(){
	$.brady.validator.validate("addForm", validator_config); //初始化表单验证构架
});
</script>

<div class="add_text">
	<form id="addForm" action="system/role_${actionType}.action" method="post">
	<input type="hidden" name="resourceId" value="${empty resource ? '0' : resource.id }" />
	<input type="hidden" name="roleId" value="${empty roleId ? '0' : roleId }" />
	<input type="hidden" name="parentResourceId" value="${empty parentResourceId ? '0' : parentResourceId }" />
	
    <table cellpadding="0" cellspacing="0" class="table_add">
     <tr >
      <th width="12%">上级资源</th>
      <td>
        <s:if test="actionType == 'addFirstRes'">
      	一级资源
      	</s:if>
      	<s:elseif test="actionType == 'addChildRes'">
      	${parentResource.title }
      	</s:elseif>
      	<s:elseif test="actionType == 'editRes'">
      	${resource.parent == null ? '一级资源' : resource.parent.title }
      	</s:elseif>
      </td>
     </tr>
     
     <tr >
      <th width="12%">资源名称</th>
      <td>
      	<input type="text" id="res_title" name="resource.title" value="${resource.title }" class="input_text_big" maxlength="25"/>
      </td>
     </tr>
      
     <tr >
      <th width="12%">访问URL</th>
      <td>
      	<input type="text" id="url" name="resource.url" value="${resource.url }" class="input_text_big" maxlength="400"/>
      </td>
     </tr>
     
	 <tr >
      <th width="12%">显示顺序</th>
      <td>
      	<input type="text" id="position" name="resource.position" value="${resource.position }" class="input_text_small" maxlength="250"/>
      </td>
     </tr>
     
    </table>
    </form> 
</div>
