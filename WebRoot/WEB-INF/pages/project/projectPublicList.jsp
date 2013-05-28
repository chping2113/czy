<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/include/core.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>安徽项目公开网-项目公开信息</title>
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
       <s:if test="type==4">
    <div class="add_top">您当前的位置：项目信息公开 > 项目建设管理信息审核</div>
    <form action="project/project_queryPublic.action?type=4" method="post">
    <div class="listop_search">项目建设管理信息
       </s:if>
       <s:elseif test="type==2">
    <div class="add_top">您当前的位置：项目信息公开 > 发布项目审批信息</div>
    <form action="project/project_queryPublic.action?type=2" method="post">
    <div class="listop_search">项目审批信息
       </s:elseif>
       <s:elseif test="type==3">
    <div class="add_top">您当前的位置：项目信息公开 > 发布土地矿业信息</div>
    <form action="project/project_queryPublic.action?type=3" method="post">
    <div class="listop_search">土地矿业信息
       </s:elseif>
       <s:else>
    <form action="project/project_queryPublic.action" method="post">
    <div class="listop_search">项目公开信息 
       
       </s:else>
	<span class="search">
       <input type="text" class="search_input" id="title"  name="queryStr" value="${empty sessionScope.project_queryStr ? "请输入项目名称" : sessionScope.project_queryStr }"  onclick="clearDefaultText(this,'')" />
       <input type="image" src="images/search_btn.gif" class="search_image" /></span>    </div>
    </form>
    <table cellpadding="0" cellspacing="0" class="table_list">
    <tr>
      <th>项目编号</th>
      <th>项目名称</th>
      <th width="25%">操作</th>
     </tr>
     <s:iterator value="pageInfo.pageData" var="pro">
     <tr>
       <td>${pro.code }</td>
       <td>${pro.name }</td>
       <td class="table_list_add">
       <s:if test="type==4">  
       	<a href="project/projectConstruct_initAdd.action?projectId=${pro.id }&type=4">项目建设管理信息审核</a>
		
       </s:if>
       <s:elseif test="type==2">
       
        <a href="project/projectApprove_initAdd.action?projectId=${pro.id }&type=2">发布审批信息</a>
       </s:elseif>
       <s:elseif test="type==3">
		<a href="project/projectLand_initAdd.action?projectId=${pro.id }&type=3">发布土地矿业信息</a>
       
       </s:elseif>
        <s:else> 
        <a href="project/projectApprove_initAdd.action?projectId=${pro.id }">发布审批信息</a>
	   	<a href="project/projectConstruct_initAdd.action?projectId=${pro.id }">发布建设管理信息</a>
		<a href="project/projectLand_initAdd.action?projectId=${pro.id }">发布土地矿业信息</a>
     
       </s:else>
      </td>
     </tr>
     </s:iterator>
     </table>
     
     <div class="page">
       <s:if test="type==4">
     	<brady:page url="project/project_queryPublic.action?type=4" pageInfo="${pageInfo }" />
       </s:if>
       <s:elseif test="type==2">
     	<brady:page url="project/project_queryPublic.action?type=2" pageInfo="${pageInfo }" />
       </s:elseif>
       <s:elseif test="type==3">
     	<brady:page url="project/project_queryPublic.action?type=3" pageInfo="${pageInfo }" />
       </s:elseif>
       <s:else>
     	<brady:page url="project/project_queryPublic.action" pageInfo="${pageInfo }" />
       
       </s:else>
     </div>
    
 </div>  <!--right_main-->
<brady:confirm />
</body>