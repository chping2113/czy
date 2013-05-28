<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/include/core.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>安徽项目公开网-发布审批信息</title>
	<script type="text/javascript">
	</script>
</head>
<body>
   <div class="right_main">
    <div class="add_top">您当前的位置：待办工作 > 审批信息发布</div>
    <form action="project/projectApprove_query.action" method="post">
    <div class="listop_search">发布审批信息
    
		
		<span class="search">
		<input type="hidden" name="type" id="type" value="${type }"/>
       <input type="text" class="search_input" id="title"  name="queryStr" value="${empty sessionScope.project_queryStr ? "请输入项目名称" : sessionScope.project_queryStr }"  onclick="clearDefaultText(this,'')" />
       <input type="image" src="images/search_btn.gif" class="search_image" onclick="deleteDefaultText('#title','请输入项目名称')"/></span>    </div>
    </form>
    <table cellpadding="0" cellspacing="0" class="table_list">
    <tr>
      <th>编号</th>
      <th>名称</th>
      <th>状态</th>
      <th>操作</th>
     </tr>
     <s:iterator value="pageInfo.pageData" var="pro" status="status">
     <tr>
       <td>${util:limitText(pro.code,30) } </td>
       <td>${util:limitText(pro.name,50) }</td>
       <td>
       <s:if test="state==0">未提交</s:if>
       <s:elseif test="state==1">审核通过</s:elseif>
       <s:elseif test="state==2">审核未通过</s:elseif>
       <s:elseif test="state==3">待审核</s:elseif>
		</td>
       <td class="table_list_add">
      	<s:if test="session.loginUser.site.code==site.code">
      	
		<s:if test="state==3">
		<s:if test="canAccessURL('project/approveProject_initApprove.action')">
		
		<a href="project/projectApprove_initAdd.action?id=${pro.id }&type=6&pageNo=${pageNo}">审核</a>
		</s:if>
		</s:if>
		<s:else>
		
		<a href="project/projectApprove_release.action?id=${pro.id }&type=6&pageNo=${pageNo}">发布</a>
		</s:else>
		</s:if> 
		<s:else>
		
		
		<a href="project/projectApprove_release.action?id=${pro.id }&type=6&pageNo=${pageNo}">发布</a>
		
		
		
		</s:else>
      </td>
     </tr>
     </s:iterator>
     </table>
     
     <div class="page">
     	<brady:page url="project/projectApprove_query.action?type=6" pageInfo="${pageInfo }" />
     </div>
    
 </div>  <!--right_main-->
<brady:confirm />
</body>