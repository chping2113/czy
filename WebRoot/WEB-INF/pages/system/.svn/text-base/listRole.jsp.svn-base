<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/include/core.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>安徽项目公开网-角色权限管理</title>
	<link rel="stylesheet" href="css/zTreeStyle/zTreeStyle.css" type="text/css">
	
	<script type="text/javascript" src="js/system/role.js"></script>
	<script type="text/javascript" src="js/jquery-ztree-2.4.min.js"></script>
	<script type="text/javascript">
		var pageNo = "${pageNo}";
	</script>
</head>
<body>
   <div class="right_main">
   <form action="system/role_query.action" method="post">
    <div class="add_top">您当前的位置：系统管理 > 角色权限管理</div>
    <div class="listop_search">信息栏目列表
      <a href="javascript:add()"><img src="images/add.jpg" border="0"/></a>
    <span class="search">
	    <input type="text" class="search_input" id="title"  name="queryStr" value="${empty sessionScope.role_queryStr ? "请输入您要搜索的角色名称" : sessionScope.role_queryStr }"  onclick="clearDefaultText(this,'')" />
	    <input type="image" src="images/search_btn.gif" class="search_image"  onclick="deleteDefaultText('#title','请输入您要搜索的角色名称')"/>    
    </span> 
    </div>
    </form>
    
    <table cellpadding="0" cellspacing="0" class="table_list">
    <tr>
      <th >类型</th>
      <th >角色名称</th>
      <th >角色描述</th>
      <th>操作</th>
     </tr>
     <s:iterator value="pageInfo.pageData" var="role">
     <tr>
       <td >
       <s:if test="#role.type==1">管理员</s:if>
       <s:if test="#role.type==2">政府部门用户</s:if>
       <s:if test="#role.type==3">项目建设单位</s:if>
       
       
       </td>
       <td title="${role.name}">${util:limitText(role.name,14) }</td>
       <td title="${role.descrip}">${util:limitText(role.descrip,14) }</td>
       <td class="table_list_add">
       	<a href="javascript:show(${role.id })">详细</a>
       	<a href="javascript:edit(${role.id })">修改</a>
       	<a href="system/role_setPowerRequest.action?id=${role.id }">配置角色权限</a>
       	<a href="system/role_listUser.action?id=${role.id }">查看角色成员</a>
       	<s:if test="#role.id != 10">
       	<a href="javascript:del(${role.id })">删除</a> 
       	</s:if>
       </td>
     </tr>
     </s:iterator>
     </table>
     
     <div class="page">
     	<brady:page url="${pageUrl }" pageInfo="${pageInfo }" />
     </div>
    
 </div>  <!--right_main-->
 
 <brady:dialog title="用户角色信息维护" onClickOK="doSave()" width="650" height="260"/>
 <brady:confirm />
</body>