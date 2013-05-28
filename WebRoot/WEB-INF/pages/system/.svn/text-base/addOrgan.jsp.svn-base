<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/include/core.jsp"%>

<script type="text/javascript">

$(function(){
	$.brady.validator.validate("addForm", validator_config); //初始化表单验证构架
});
</script>

<div class="add_text">
	<form id="addForm" action="system/site_${actionType}.action" method="post">
	<input type="hidden" id="id" name="id" value="${empty id ? '0' : id }" />
	<input type="hidden" name="parentId" value="${empty parentId ? '0' : parentId }" />
	
    <table cellpadding="0" cellspacing="0" class="table_add">
     <tr >
      <th width="15%">机构代码</th>
      <td>
      <input type="text" id="code" name="code" class="input_text" maxlength="20" value="${code }"/>
      </td>
      </tr>
      
     
     <tr >
      <th>机构名称</th>
      <td>
      	<input type="text" id="name" name="name" value="${name }" maxlength="25" class="input_text" />
      </td>
      </tr>
     
      <tr >
      <th>联系人</th>
      <td>
      	<input type="text" id="linkman" name="linkman" value="${linkman }" maxlength="20" class="input_text" />
      </td>
      </tr>
      
      <tr>
      <th>联系电话</th>
      <td>
      	<input type="text" id="tel" name="tel" value="${tel }" maxlength="20" class="input_text" />
      </td>
      </tr>
      <!--  
      <tr>
      <th>举报电话</th>
      <td>
      	<input type="text" id="report" name="report" value="${report }" maxlength="20" class="input_text" />
      </td>
      </tr>
      -->
      <tr>
      <th>机构类型</th>
      <td>
      	<select id="type" name="type">
			<option value="0" ${type==0?"selected='true'":""}>专栏</option>
			<option value="1" ${type==1?"selected='true'":""}>平台</option>
		</select>
      </td>
      </tr>
      <tr>
      <th>有效状态</th>
      <td>
      	<select id="state" name="state">
			<option value="0" ${state==0?"selected='true'":""}>有效</option>
			<option value="1" ${state==1?"selected='true'":""}>无效</option>
		</select>
      </td>
      </tr>
      <!-- 
      <tr>
      <th>页脚</th>
      <td>
      	<textarea name="footer" id="footer" class="input_text_area">${footer }</textarea>
      </td>
      </tr>
 -->
    </table>
    </form> 
</div>
