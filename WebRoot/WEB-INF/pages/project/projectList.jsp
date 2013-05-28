<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/include/core.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>安徽项目公开网-项目基本信息</title>
	<script type="text/javascript">
		var pageNo = "${pageNo}";
		function doDelete(id) {
			showConfirm("确定删除该条记录吗？", "doConfirmDelete("+id+")");
		}
		
		function doConfirmDelete(id) {
			location.href = "project/project_delete.action?pageNo=" + pageNo + "&id=" + id;
		}
	</script>
</head>
<body>
   <div class="right_main">
    <div class="add_top">您当前的位置：项目信息公开 > 发布项目基本信息</div>
    <form action="project/project_query.action" method="post">
    <div class="listop_search">发布项目基本信息 
	<a href="project/project_initAdd.action"><img 
		src="images/add.jpg" border="0"/></a><span class="search">
       <input type="text" class="search_input" id="title"  name="queryStr" value="${empty sessionScope.project_queryStr ? "请输入项目名称" : sessionScope.project_queryStr }"  onclick="clearDefaultText(this,'')" />
       <input type="image" src="images/search_btn.gif" class="search_image" /></span>    </div>
    </form>
    <table cellpadding="0" cellspacing="0" class="table_list">
    <tr>
      <th>项目编号</th>
      <th>项目名称</th>
      <th>建设单位</th>
      <th>操作</th>
     </tr>
     <s:iterator value="pageInfo.pageData" var="pro">
     <tr>
       <td>${pro.code }</td>
       <td>${util:limitText(pro.name,15) }</td>
       <td>${util:limitText(pro.company.name,15) }</td>
       <td class="table_list_add">
      	<a href="project/project_view.action?id=${pro.id }">查看</a>
      	<s:if test="#pro.state==1">
		<!-- <span style="color:#999999;">修改</span>
		<span style="color:#999999;">删除</span>
		<span style="color:#999999;">审批</span> -->
		</s:if>
		<s:else>
		<a href="project/project_initAdd.action?id=${pro.id }">修改</a>
		<a href="javascript:doDelete(${pro.id })">删除</a><!-- 
		<s:if test="canAccessURL('project/approveProject_initApprove.action')">
		
		<a href="project/approveProject_initApprove.action?id=${pro.id }">审批</a>
		</s:if> -->
		</s:else>
      </td>
     </tr>
     </s:iterator>
     </table>
     
     <div class="page">
     	<brady:page url="project/project_query.action" pageInfo="${pageInfo }" />
     </div>
    
 </div>  <!--right_main-->
<brady:confirm />
</body>