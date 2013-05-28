<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/include/core.jsp"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理-添加${newsCatelog.title }信息</title>
<script charset="utf-8" src="editor/kindeditor-min.js"></script>
<script type="text/javascript">
	var pageNo = "${empty pageNo ? 0 : pageNo}";
	function doConfirmCommit(id) {
		location.href = "info/task_edit.action?id="+id+"&type=1&pageNo=" + pageNo;
	}
</script>

</head>

<body>
 
 
    <div class="add_news">
    <div class="add_top">信息发布&nbsp; &gt; 待办事项&nbsp; &gt; 查看待办事项</div>
	<input type="hidden" name="pageNo" value="${empty pageNo ? '1' : pageNo}" />
	<input type="hidden" name="type" value="${type }"/>
    <table cellpadding="0" cellspacing="0" class="table_add">
   
      
     <tr>
      <th width="13%">标题</th>
      <td>${title }</td>
     </tr>

    <tr>
      <th>组织机构</th>
       <td>
     ${site.name }
      	
	  </td>
      </tr>
      
      <tr>
      <th valign="top">内容</th>
      <td>${content }</td>
      </tr>
    </table>
 
    <div class="add_savebtn">
    <s:if test="type==1">
    
    	<a href="javascript:doConfirmCommit(${id })"><img src="images/c1.gif" border="0"/></a>
    </s:if>
    
    	<a href="javascript:history.back()"><img src="images/back00.gif" border="0" /></a></div>
    	
    </div>
    
<brady:query paramName="queryCode"/>
</body>
</html>
