<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/include/core.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>安徽项目公开网-栏目设置</title>
	
	<script type="text/javascript" src="js/info/newsCatelog.js"></script>
	<script type="text/javascript">
		var pageNo = "${pageNo}";
		var parentId = "${empty parentCatelog ? 0 : parentCatelog.id}";
	</script>
</head>
<body>
   <div class="right_main">
    <div class="add_top">您当前的位置：信息发布 > 栏目设置</div>
    <div class="listop_search">一级信息栏目列表
    
    <a href="javascript:add()"><img src="images/add.jpg" border="0"/></a>
    
    </div>
    
    <table cellpadding="0" cellspacing="0" class="table_list">
    <tr>
      <th width="25%">栏目标题</th>
      <th width="30%">描述信息</th>
      <th width="10%">显示顺序</th>
      <th>操作</th>
     </tr>
     <s:iterator value="pageInfo.pageData" var="newsCatelog">
     <tr>
       <td title="${newsCatelog.title }">${util:limitText(newsCatelog.title,13) }</td>
       <td title="${newsCatelog.descrip }">${util:limitText(newsCatelog.descrip,16) }</td>
       <td>${newsCatelog.showOrder }</td>
       <td class="table_list_add">
         <a href="javascript:show(${newsCatelog.id })">详细</a>
         <a href="info/newsCatelog_listSecond.action?parentId=${newsCatelog.id }">下级栏目</a>
         <a href="javascript:edit(${newsCatelog.id })">修改</a>
         <%-- 
         <a href="javascript:del(${newsCatelog.id })">删除</a>
         --%>
       </td>
     </tr>
     </s:iterator>
     </table>
     
     <div class="page">
     	<brady:page url="${pageUrl }" pageInfo="${pageInfo }" />
     </div>
    
 </div>  <!--right_main-->
 
 <brady:dialog title="栏目信息维护" onClickOK="doSave()" width="675" height="230"/>
 <brady:confirm />
</body>