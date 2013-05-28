<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/include/core.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>安徽项目公开网-角色管理</title>
	<link rel="stylesheet" href="css/zTreeStyle/zTreeStyle.css" type="text/css">
	
	<script type="text/javascript" src="js/system/user.js"></script>
	<script type="text/javascript" src="js/jquery-ztree-2.4.min.js"></script>
	<script type="text/javascript">
		var pageNo = "${pageNo}";
	</script>
</head>
<body>
   <div class="right_main">
   <form action="system/role_queryUser.action" method="post">
    <div class="add_top">您当前的位置：系统管理 > 角色权限管理 > 角色成员列表</div>
    <div class="listop_search">角色：${model.name }
    	<a href="system/role_list.action"><img src="images/back012.jpg" border="0" /></a>
    <span class="search">
    	
      	<input type="hidden" name="name" id="name" value="${name }"/>
      	<input type="hidden" name="roleId" id="roleId" value="${roleId }"/>
	    <input type="text" class="search_input" id="title"  name="queryStr" value="${empty sessionScope.user_queryStr ? "请输入帐号或者组织机构" : sessionScope.user_queryStr }"  onclick="clearDefaultText(this,'')" />
	    <input type="image" src="images/search_btn.gif" class="search_image"  onclick="deleteDefaultText('#title','请输入帐号或者组织机构')"/>    
    </span> 
    </div>
    </form>
    
    <table cellpadding="0" cellspacing="0" class="table_list">
    <tr>
      <th width="20%">帐号</th>
      <th width="15%">角色</th>
      <th width="12%">创建时间</th>
      <th width="8%">状态</th>
      <th width="25%">组织机构</th>
      <th>操作</th>
     </tr>
     <s:iterator value="pageInfo.pageData" var="u">
     <tr>
       <td title="${u.code }">${util:limitText(u.code,14) }</td>
       <td title="${u.role.name }">${util:limitText(u.role.name,10) }</td>
       <td><s:date name="#u.createTime" format="yyyy-MM-dd" /></td>
       <td>${u.state==1? "有效" : "无效" }</td>
       <td title="${u.site.name }">${util:limitText(u.site.name,15) }</td>
       <td class="table_list_add">
       	<a href="javascript:doExecute('view', ${u.id })">详细</a>
       	</td>
     </tr>
     </s:iterator>
     </table>
       
     <div class="page">
     	<brady:page url="system/system/role_queryUser.action?roleId=${roleId }&id=${roleId }" pageInfo="${pageInfo }" />
     </div>
  
 </div>  <!--right_main-->
 
  <brady:dialog title="政府用户信息查看" onClickOK="doSave()" width="650" height="450"/>
</body>