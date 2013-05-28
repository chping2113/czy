<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/include/core.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>安徽项目公开网-系统管理</title>
	<script type="text/javascript">
		var pageNo = "${pageNo}";
		function doDelete(id) {
			showConfirm("确定删除该条记录吗？", "doConfirmDelete("+id+")");
		}
		
		function doConfirmDelete(id) {
			location.href = "system/navigate_delete.action?pageNo=" + pageNo + "&id=" + id+"&ptype=${ptype}&parentId=${parentId}";
		}
	</script>
</head>
<body>
   <div class="right_main">
    <div class="add_top">您当前的位置：系统管理 > 专栏快速导航</div>
    <div class="nav">
	<ul>
	<li><a href="system/homePage_init.action">首页管理</a></li>
	<li><a id="curTab">专栏快速导航</a></li>
	</ul>
	</div>
    <form action="system/navigate_query.action" method="post">
      	<input type="hidden" name="parentId" id="parentId" value="${parentId }"/>
      	<input type="hidden" name="ptype" id="ptype" value="${ptype }"/>
    <div class="listop_search">
	<a href="system/navigate_initAdd.action?ptype=${ptype }&parentId=${parentId }"><img 
		src="images/add.jpg" border="0"/></a>
		<s:if test="ptype==1">
		 <a href="system/navigate_init.action?ptype=0&pageNo=${pageNo }"><img src="images/back012.jpg" border="0" /></a>
		</s:if><span class="search">
       <input type="text" class="search_input" id="title"  name="queryStr" value="${empty sessionScope.navigate_queryStr ? "请输入专栏名称" : sessionScope.navigate_queryStr }"  onclick="clearDefaultText(this,'')" />
       <input type="image" src="images/search_btn.gif" class="search_image" /></span>    </div>
    </form>
    <table cellpadding="0" cellspacing="0" class="table_list">
    <tr>
      <th>专栏名称 </th>
      
		<s:if test="ptype==1">
	  <th>链接URL</th>
	  </s:if>
	  
	  <th>顺序</th>
	  <th>操作</th>
     </tr>
     <s:iterator value="pageInfo.pageData" var="ni">
     <tr>
       <td>${ni.name }</td>
		<s:if test="ptype==1">
       <td>
       ${ni.url } 
	   </td></s:if>
	   
	   <td>
	  ${ni.showOrder }
	   </td>
       <td class="table_list_add">
      	<a href="system/navigate_view.action?id=${ni.id }&ptype=${ptype}">查看</a>
		<a href="system/navigate_initEdit.action?id=${ni.id }&ptype=${ptype}&parentId=${parentId}">修改</a>
		<a href="javascript:doDelete(${ni.id })">删除</a>
		<s:if test="ptype==0">
		<a href="system/navigate_init.action?parentId=${ni.id }&ptype=1">查看下级</a>
      	
      	</s:if>
      	
		
      </td>
     </tr>
     </s:iterator>
     </table>
     
     <div class="page">
     	<brady:page url="system/navigate_query.action?ptype=${ptype }&parentId=${parentId }" pageInfo="${pageInfo }" />
     </div>
    
 </div>  <!--right_main-->
<brady:confirm />
</body>