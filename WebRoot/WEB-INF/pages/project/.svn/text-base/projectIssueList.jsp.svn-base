<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/include/core.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>安徽项目公开网-发布重点项目</title>
	
	<script type="text/javascript" src="js/projectFocus.js"></script>
	<script type="text/javascript">
		var pageNo = "${pageNo}";
	</script>
</head>
<body>
   <div class="right_main">
   <form action="project/projectIssue_query.action?keyid=${keyid}" method="post">
    <div class="add_top">您当前的位置：项目信息公开 > 发布重点项目</div>
    <div class="listop_search">
    <a href="project/projectIssue_addRequest.action?keyid=${keyid}&pageNo=${pageNo }"><img src="images/fabu.jpg" border="0"/></a>
    <a href="project/projectAegis_list.action?pageNo=${pageNo }"><img src="images/back012.jpg" border="0" /></a>
    <span class="search">
	    <input type="text" class="search_input" id="title"  name="queryStr" value="${empty sessionScope.keyProject_queryStr ? "请输入项目名称" : sessionScope.keyProject_queryStr }"  onclick="clearDefaultText(this,'')" />
	    <input type="image" src="images/search_btn.gif" class="search_image" onclick="deleteDefaultText('#title','请输入项目名称')"/>    
    </span> 
    </div>
    </form>
    
    <table cellpadding="0" cellspacing="0" class="table_list">
    <tr>
      <th width="40%">项目名称</th>
      <th width="20%">项目类型</th>
      <th width="15%">发布人</th>
      <th width="12%">发布日期</th>
      <th>操作</th>
     </tr>
     <s:iterator value="pageInfo.pageData" var="issue">
     <tr>
       <td title="${issue.projectConstruct.name }">${util:limitText(issue.projectConstruct.name,21) }</td>
       <td>${issue.keyProjectKind.name }</td>
       <td>${issue.user.code }     </td>
       <td><s:date name="#issue.createDate" format="yyyy-MM-dd" /></td>
       <td class="table_list_add">
       
      	<s:if test="session.loginUser.site.code==projectConstruct.site.code">
         <a href="javascript:deleIssue(${issue.id },${issue.keyProjectKind.id })">删除</a>
         </s:if>
         <a href="project/projectConstruct_view.action?id=${issue.projectConstruct.id }&type=8">查看</a>
       </td>
     </tr>
     </s:iterator>
     </table>
     
     <div class="page">
     	<brady:page url="${pageUrl }" pageInfo="${pageInfo }" />
     </div>
    
 </div>  <!--right_main-->
 
 <brady:dialog title="发布重点项目 " onClickOK="doSave()" width="675" height="500"/>
 <brady:confirm />
</body>