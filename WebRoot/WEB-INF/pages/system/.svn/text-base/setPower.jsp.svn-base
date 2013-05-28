<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/include/core.jsp"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理->权限管理->设置权限</title>
<script type="text/javascript" src="js/system/setPower.js"></script>
<script type="text/javascript">
	var actionType = "${actionType}";
</script>
</head>
<body>

<div class="add_news">
<a href="system/role_buildPermissionTree.action?roleId=${roleId }">配置访问资源</a>


<div class="add_top">系统管理&nbsp; &gt; 角色权限管理 &nbsp; &gt; 当前角色：${name }</div>

<form action="system/role_setPower.action" method="post" id="addForm"> 
	<input type="hidden" name="id" value="${id }" />

<s:iterator value="#firstPermissionList" var="firstPermission">
<br/>
<fieldset class="fieldset"> 
<legend class="legend">
<!-- 对应一级资源的ID，因此一旦它的任一子资源被选中，则它也是被选中的 -->
<s:if test="#permissionIdMap[#firstPermission.id] == 'ok'">
	<input type="checkbox" class="checkbox2 firstLevel" id="first_${firstPermission.id}" checked value="${firstPermission.id }" name="permissionIds" />
</s:if>
<s:else>
	<input type="checkbox" class="checkbox2 firstLevel" id="first_${firstPermission.id}" value="${firstPermission.id }" name="permissionIds" />
</s:else>
	${firstPermission.title }
</legend> 

<s:iterator value="#firstPermissionMap[#firstPermission.id]" var="secondPermission">
<label class="lab" for="username"><div class="titile2text">
<!-- 二级资源 -->
	<s:if test="#permissionIdMap[#secondPermission.id] == 'ok'">
		<input firstLevelId="${firstPermission.id }"  class="checkbox fl_${firstPermission.id } secondLevel" name="permissionIds" type="checkbox" checked value="${secondPermission.id }" />
	</s:if>
	<s:else>
		<input firstLevelId="${firstPermission.id }"  class="checkbox fl_${firstPermission.id } secondLevel" name="permissionIds" type="checkbox" value="${secondPermission.id }" />
	</s:else>
	${secondPermission.title }:</div> 

<s:iterator value="#secondPermissionMap[#secondPermission.id]" var="thirdPermission">
	<s:if test="#permissionIdMap[#thirdPermission.id] == 'ok'">
		<input firstLevelId="${firstPermission.id }" class="checkbox firstLevel_${firstPermission.id} secondLevel_${secondPermission.id }" name="permissionIds" type="checkbox" value="${thirdPermission.id }" checked />${thirdPermission.title }
	</s:if>
	<s:else>
		<input firstLevelId="${firstPermission.id }" class="checkbox firstLevel_${firstPermission.id} secondLevel_${secondPermission.id }" name="permissionIds" type="checkbox" value="${thirdPermission.id }" />${thirdPermission.title }
	</s:else>
</s:iterator>

</label>
<br />
</s:iterator>

</fieldset> 
</s:iterator>

	<div class="add_savebtn">
    	<a href="javascript:doSave()"><img src="images/save.gif" border="0"/></a>
    	<a href="system/role_list.action?pageNo=${pageNo }"><img src="images/back00.gif" border="0" /></a></div>
    </div>
</form> 
</div>

</body>
</html>
