<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/include/core.jsp"%>


    
<s:if test="#taskCountList.size!=0">
<fieldset class="fieldset2"> 
<legend class="legend2"> <!-- 对应一级资源的ID，因此一旦它的任一子资源被选中，则它也是被选中的 -->
待办事项 </legend> 
<label class="label2" for="username">

 <table width="93%" border="0" cellpadding="0" cellspacing="0"  style="margin-left: 45px;margin-top: 0px;">
  <c:forEach items="${taskCountList}" step="3" varStatus="status" >
  <tr ><td width="33%" >
  		<a href="${taskCountList[status.index].url}" onclick='javascript:todo("${taskCountList[status.index].fristMenu}","${taskCountList[status.index].id}")'>${ taskCountList[status.index].name}</a>
  </td>
  <td  width="33%">
  		<a href="${taskCountList[status.index+1].url }"  onclick='javascript:todo("${taskCountList[status.index+1].fristMenu}","${taskCountList[status.index+1].id}")'>${taskCountList[status.index+1].name}</a>
  </td>
  <td>
  		<a href="${taskCountList[status.index+2].url }"  onclick='javascript:todo("${taskCountList[status.index+2].fristMenu}","${taskCountList[status.index+2].id}")'>${taskCountList[status.index+2].name}</a>
  </td>
  </tr>
  </c:forEach>
  
</table>


</label>
</fieldset>
</s:if>