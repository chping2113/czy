<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/include/core.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>安徽项目公开网-公告管理</title>
	
	<script type="text/javascript" src="js/info/notice.js"></script>
	<script type="text/javascript">
		var pageNo = "${pageNo}";
	</script>
</head>
<body>
   <div class="right_main">
   <form action="info/notice_query.action" method="post">
    <div class="add_top">您当前的位置：信息发布 > 通知公告</div>
    <div class="listop_search">信息栏目列表
    <a href="info/notice_addRequest.action?pageNo=${pageNo }"><img src="images/fabu.jpg" border="0"/></a>
    <span class="search">
	    <input type="text" class="search_input" id="title"  name="queryStr" value="${empty sessionScope.notice_queryStr ? "请输入公告标题" : sessionScope.notice_queryStr }"  onclick="clearDefaultText(this,'')" />
	    <input type="image" src="images/search_btn.gif" class="search_image"  onclick="deleteDefaultText('#title','请输入公告标题')"/>    
    </span> 
    </div>
    </form>
    
    <table cellpadding="0" cellspacing="0" class="table_list">
    <tr>
      <th width="30%">公告标题</th>
      <th width="8%">浮动显示</th>
      <th width="8%">浏览次数</th>
      <th width="25%">发布单位</th>
      <th width="10%">发布时间</th>
      <th>操作</th>
     </tr>
     <s:iterator value="pageInfo.pageData" var="notice">
     <tr>
       <td title="${notice.title }">${util:limitText(notice.title,30) }</td>
       <td>${notice.floatShow == "1" ? "浮动" : "不浮动" }</td>
       <td>${notice.hitCount }</td>
       <td>${notice.createUser.site.name }</td>
       <td><s:date name="#notice.createTime" format="yyyy-MM-dd" /></td>
       <td class="table_list_add">
         <a href="pub_previewNotice.action?id=${notice.id }" target="_blank">预览</a>
         <a href="info/notice_editRequest.action?id=${notice.id }&pageNo=${pageNo}">修改</a>
         <a href="javascript:del(${notice.id })">删除</a>
       </td>
     </tr>
     </s:iterator>
     </table>
     
     <div class="page">
     	<brady:page url="${pageUrl }" pageInfo="${pageInfo }" />
     </div>
    
 </div>  <!--right_main-->
 
 <brady:dialog title="公告信息维护" onClickOK="doSave()" width="675" height="500"/>
 <brady:confirm />
</body>