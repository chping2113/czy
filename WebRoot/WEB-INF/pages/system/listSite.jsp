<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/include/core.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>平台管理</title>
	<script type="text/javascript" src="js/info/site.js"></script>
	<script type="text/javascript">
		var pageNo = "${pageNo}";
		var siteId = "${siteId}";
	</script>
</head>
<body>
  
   <div class="right_main">
   <form action="system/site_query.action" method="post">
   
    <div class="add_top">首页 > 平台管理 </div>
    <div class="listop_search">平台列表
      <a href="javascript:add()"><img src="images/add.jpg" border="0"/></a>
    <span class="search">
	    <input type="text" class="search_input" id="title"  name="queryStr" value="${empty sessionScope.site_queryStr ? "请输入平台标题" : sessionScope.site_queryStr }"  onclick="clearDefaultText(this,'')" />
	    <input type="image" src="images/search_btn.gif" class="search_image"  onclick="deleteDefaultText('#title','请输入平台标题')"/>    
    </span> 
    </div>
    </form>
    <table cellpadding="0" cellspacing="0" class="table_list">
    <tr>
      <th width="30%">平台名称</th>
      <th width="20%">状态</th>
      <th>操作</th>
     </tr>
     
     <s:iterator value="pageInfo.pageData" var="site">
     <input type="hidden" name="siteId" value="${site.id }" /> 
     <tr>
       <td name="${site.name }"><a href="javascript:view(${site.id })">${util:limitText(site.name,30) }</a></td>
       
       <td name="${site.state }">
       	<s:if test="state==1">有效</s:if>
       	<s:elseif test="state==0">无效</s:elseif>
       </td>
       
       <td class="table_list_add">
         <a href="javascript:edit(${site.id })">编辑</a>
         <a href="info/scolumn_listFirst.action?siteId=${site.id }&pageNo=${pageNo}">栏目管理</a>
        
   		 <c:if test="${site.grade!='省'}">
         <a href="javascript:del(${site.id })">删除</a>
         </c:if>
         
       </td>
     </tr>
     </s:iterator>
     
    
     </table>
     
     <div class="page">
     	<brady:page url="${pageUrl }" pageInfo="${pageInfo }" params="${pageParam }" />
     </div>
    
 </div>  <!--right_main-->
 
 <brady:confirm />
</body>