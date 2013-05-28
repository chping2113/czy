<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/include/core.jsp"%>

<div class="add_text">

    <table cellpadding="0" cellspacing="0" class="table_add" >
    	<tr>
    		<th>举报主题</th>
    		<td>${title }</td>
    	</tr>
    	<tr>
    		<th width="20%">姓名</th>
    		<td>${name } </td>
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
    		<td>${deal }</td>
    	</tr>
	</table>
     
</div><!--content-->