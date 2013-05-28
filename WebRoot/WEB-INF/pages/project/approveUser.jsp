<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/include/core.jsp"%>

<script type="text/javascript">
$(function() {
	$(":radio").click(function() {
		$("#errmsg").hide();
	});
});
</script>

<div style="margin:5px 10px;width:320px;">
	<input type="hidden" name="id" value="${empty id ? 0 : id }" />
	<input type="hidden" name="pageNo" value="${empty pageNo ? 0 : pageNo }" />

    <table cellpadding="0" cellspacing="0" class="table_add">
     	 <tr>
      <td>
      		<input type="radio" name="userId" value="0" checked="checked">所有审核人员
      		
      		
      </td>
      </tr>
    
      		<s:iterator value="#userList" var="r">
      		 <tr>
      <td>
      		<input type="radio" name="userId" value="${r.id }" ${r.id == userId  ? "checked" :"" }>${r.name }&nbsp;(${r.code })
      		
      		  
      </td>
      </tr>
      		
      		</s:iterator>
    
     
    </table>
</div><!--content-->