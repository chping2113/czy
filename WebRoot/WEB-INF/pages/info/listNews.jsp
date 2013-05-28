<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/include/core.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>安徽项目公开网-新闻管理</title>
	
	<script type="text/javascript" src="js/info/news.js"></script>
	<script type="text/javascript">
		var pageNo = "${pageNo}";
		var catelogId = "${catelogId}";
	</script>
</head>
<body>
   <div class="right_main">
   <form action="info/news_query.action" method="post">
    <input type="hidden" name="catelogId" value="${catelogId }" />
    
    <div class="add_top">您当前的位置：信息发布 > ${newsCatelog.title }</div>
    <s:if test="#secondNewsCatelog!=null">
  <div class="nav">
	<ul>
 <s:iterator value="secondNewsCatelog" var="snc" status="status1">
 <s:if test="catelogId == 21">
  	<s:if test="#status1.count == 1">
	<li><a id="curTab">${snc.title }</a></li>
	</s:if>
	<s:else>
	<li><a href="info/news_list.action?catelogId=22">${snc.title }</a></li>
	</s:else>
	</s:if>
	<s:else>
	<s:if test="#status1.count == 1">
	<li><a href="info/news_list.action?catelogId=21">${snc.title }</a></li>
	</s:if>
	<s:else>
	<li><a id="curTab">${snc.title }</a></li>
	</s:else>
	</s:else>
 </s:iterator>
	</ul>
	</div></s:if>
    <div class="listop_search">${newsCatelog.title }
    <a href="info/news_addRequest.action?catelogId=${catelogId }&pageNo=${pageNo }"><img src="images/fabu.jpg" border="0"/></a>
    <span class="search">
	    <input type="text" class="search_input" id="title"  name="queryStr" value="${empty sessionScope.news_queryStr ? "请输入查询标题" : sessionScope.news_queryStr }"  onclick="clearDefaultText(this,'')" />
	    <input type="image" src="images/search_btn.gif" class="search_image"  onclick="deleteDefaultText('#title','请输入查询标题')"/>    
    </span> 
    </div>
    </form>
    <table cellpadding="0" cellspacing="0" class="table_list">
    <tr>
      <th width="30%">标题</th>
      <th width="20%">所属栏目</th>
      <th width="20%">发布单位</th>
      <th width="10%">发布时间</th>
      <th>操作</th>
     </tr>
     <s:iterator value="pageInfo.pageData" var="news">
     <tr>
       <td title="${news.title }">${util:limitText(news.title,32) }</td>
       <td>${news.catelog.title }</td>
       <td>${news.createUser.site.name }</td>
       <td><s:date name="#news.createTime" format="yyyy-MM-dd" /></td>
       <td class="table_list_add">
         <a href="pub_previewNews.action?id=${news.id }" target="_blank">预览</a>
         <a href="info/news_editRequest.action?id=${news.id }&catelogId=${catelogId}&pageNo=${pageNo}">修改</a>
         <a href="javascript:del(${news.id })">删除</a>
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