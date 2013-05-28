<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/include/core.jsp"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>查看平台</title>

</head>

<body>
 
 
    <div class="add_news">
    <div class="add_top">首页 &gt; 查看栏目</div>
	<input type="hidden" name="pageNo" value="${empty pageNo ? '1' : pageNo}" />
	<input type="hidden" name="type" value="${type }"/>
	<input type="hidden" name="siteId" value="${site.id }" />
    <table cellpadding="0" cellspacing="0" class="table_add">
   
   
   
     <s:if test="#parentScolumn != null">
     <tr>
      <th width="20%">上级栏目</th>
      <td>
      	${parentScolumn.name }
      </td>
     </tr>
     </s:if>
     
     <tr>
      	<th width="15%">所属平台</th>
      	<td>
      		${site.name }
      	
      	</td>
      </tr>
     
     <tr>
      <th width="20%">栏目标题</th>
      <td>&nbsp;${name }</td>
      </tr>

     <tr>
      <th>有效状态</th>
      <td>&nbsp;${state == 1 ? "有效" : "无效" }</td>
      </tr>
      
      <!-- 
      
       -->
    </table>
 	<table cellpadding="0" cellspacing="0" class="table_add">
 		<s:iterator value="pageInfo.pageData" var="sp">
      <tr>
      <th width="20%">属性名称</th>
      <td>${sp.name }</td>
      <th width="20%">属性内容</th>
      <td>${sp.content }</td>
      </tr>
      </s:iterator>
 	</table>
 	
 
    <div class="add_savebtn">
    
    	<a href="javascript:history.back()"><img src="images/back00.gif" border="0" /></a></div>
    	
    </div>
    
<brady:query paramName="queryCode"/>
</body>
</html>
