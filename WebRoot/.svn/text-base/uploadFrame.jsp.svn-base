<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/include/core.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>通知公告信息</title>
<link href="css/main.css"  rel="stylesheet" style="text/css"/>
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script type="text/javascript">
	function upload(){   
			$("#uploadFile").submit();
		}
</script>
</head>

<body>

	<form id="uploadFile" action="project/projectApprove_upload.action" enctype="multipart/form-data" method="post">
    	<table cellpadding="0" cellspacing="0" class="table_add">
    		<tr>
		      <th width="12%">上传附件</th>
		      <td>
			      <input type="file" class="input_text_large" name="attachFile" id="attachFile" onkeydown="return false"/>
			      <a href="javascript:upload()">上传</a>
			      <s:if test="#error==1"><font color="red">&nbsp;&nbsp;提示：文件过大！</font></s:if>
			      <s:elseif test="#error==2"><font color="red">&nbsp;&nbsp;提示：文件内容！</font></s:elseif>
			      <s:else>&nbsp;&nbsp;&nbsp;&nbsp;提示：文件不能超过8M</s:else>
		      </td>
		     </tr>
    	</table>
    </form>
    <table cellpadding="0" cellspacing="0"  class="table_add2">
    		<tr>
		      <th width="20%" align="center">序号</th>
		      <th width="50%" align="center">文件名</th>
		      <th align="center">操作</th>
		    </tr>
		    <s:iterator value="attachFileList" var="attach" status="statusaf">
		    <tr>
		      <td>${statusaf.index + 1}</td>
		      <td>${attach.realName }</td>
		      <td><a href="project/projectApprove_deleteFile.action?message=${attach.fileName }&id=${id}">删除</a></td>
		    </tr>
		    </s:iterator>
    	</table>
    
</body>
</html>