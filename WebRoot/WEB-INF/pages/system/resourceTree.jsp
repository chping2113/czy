<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/include/core.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>安徽项目公开网-系统资源管理</title>
	<link rel="stylesheet" href="css/zTreeStyle/zTreeStyle.css" type="text/css">
	<script type="text/javascript" src="js/jquery-ztree-2.4.min.js"></script>
	<script type="text/javascript" src="js/system/resource.js"></script>
	
	<script type="text/javascript">
	var zTree;
	var zNodes = ${message};
	var selectedResId = "";
	var actionType = "edit";
	var roleId = "${roleId}";
	
	$(function() {
		buildTree();
	});
	
	</script>
</head>

<body>
      
   <div class="right_main">
    <div class="main_text">您当前的位置：系统管理 &gt; <a href="system/role_list.action">角色权限管理 </a> &gt;<a href="system/role_setPowerRequest.action?id=${roleId }">配置角色权限 </a> &gt; <a href="system/role_buildResourceTree.action?roleId=${roleId }">配置访问资源</a></div>
    <div class="listop_search">系统资源配置 <a href="javascript:addFirstRes()">添加一级资源</a></div>
    <div class="tree_content">
    	<div class="tree_js tree" id="tree_div"></div>
    	
    	<div class="dept_right" id="tree_node"></div>
    </div>
   </div><!--right_main-->

	
	<brady:confirm />
	<brady:dialog title="系统资源信息维护" onClickOK="doSave()" width="660" height="320"/>
</body>