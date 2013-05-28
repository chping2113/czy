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
<script type="text/javascript" src="js/info/scolumnProperty.js"></script>
<script type="text/javascript">
	function upload(){
			$("#uploadFile").submit();
		}
</script>
</head>

<body>

					<c:if test="${id!=null}">
					<table cellpadding="0" cellspacing="0" class="table_add" id="table2">
						<s:iterator value="properties" var="sp">
					      <tr>
					      <th width="20%">属性名称</th>${sp.scolumnId.id }
					      <td><input type="text" value="${sp.name }" id="${sp.id }" name="properties" />${sp.id }</td>
					      <th width="20%">属性内容</th>
					      <td><input type="text" value="${sp.content }" id="${sp.id }" name="contents" /></td>
					      <td> <a href="info/scolumn_deleteProperty.action?spid=${sp.id }&id=${sp.scolumnId.id }">删除</a></td>
					     
					      </tr>
					     </s:iterator>
					
			 	</table>
				</c:if>
</body>
</html>