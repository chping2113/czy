<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/include/core.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>安徽项目公开网-待办事项管理</title>
	
	<script type="text/javascript" src="js/info/task.js"></script>
	<script type="text/javascript">
		var pageNo = "${pageNo}";
		var catelogId = "${catelogId}";
		function del(id) {
			showConfirm("确定删除该条记录吗？", "doConfirmDelete("+id+")");
		}
		
		function doConfirmDelete(id) {
			location.href = "info/task_delete.action?pageNo=" + pageNo + "&id=" + id ;
		}
		function doCommit(id) {
			showConfirm("确定处理吗？", "doConfirmCommit("+id+")");
		}
		
		function doConfirmCommit(id) {
			location.href = "info/task_edit.action?id="+id+"&type=1&pageNo=" + pageNo;
		}
	</script>
</head>
<body>
   <div class="right_main">
   <form action="info/task_query.action" method="post">
    
    <s:if test="type!=1">
    <div class="add_top">您当前的位置：信息发布 > 待办事项</div>
    </s:if>
    <s:else>
    <div class="add_top">您当前的位置：待办工作> 其他工作事项</div>
    </s:else>
    <div class="listop_search">待办事项
    <s:if test="type!=1">
    <a href="info/task_addRequest.action?pageNo=${pageNo }"><img src="images/fabu.jpg" border="0"/></a>
  </s:if>
    <span class="search">
	    <input type="text" class="search_input" id="title"  name="queryStr" value="${empty sessionScope.task_queryStr ? "请输入查询标题" : sessionScope.task_queryStr }"  onclick="clearDefaultText(this,'')" />
	    <input type="image" src="images/search_btn.gif" class="search_image"  onclick="deleteDefaultText('#title','请输入查询标题')"/> 
	   <input type="hidden" name="type" value="${type}" />  
    </span> 
    </div>
    </form>
    <table cellpadding="0" cellspacing="0" class="table_list">
    <tr>
      <th width="30%">标题</th>
      <th >状态</th>
      <th>操作</th>
     </tr>
     <s:iterator value="pageInfo.pageData" var="task">
     <tr>
       <td title="${task.title }">${util:limitText(task.title,30) }</td>
       <td>
        <s:if test="state==0">未处理</s:if>
       <s:elseif test="state==1">已处理</s:elseif>
       </td>
       <td class="table_list_add">
         <a href="info/task_viewRequest.action?id=${task.id }&pageNo=${pageNo}&type=${type}">查看</a>
         
    <s:if test="type!=1">
    <s:if test="state!=1">
         <a href="info/task_editRequest.action?id=${task.id }&pageNo=${pageNo}">修改</a>
         <a href="javascript:del(${task.id })">删除</a></s:if>
         </s:if>
         <s:else>
         
         <a href="javascript:doCommit(${task.id })">处理</a>
         </s:else>
       </td>
     </tr>
     </s:iterator>
     </table>
     
     <div class="page">
     	<brady:page url="info/task_query.action?type=${type }" pageInfo="${pageInfo }" params="${pageParam }" />
     </div>
    
 </div>  <!--right_main-->
 
 <brady:confirm />
</body>