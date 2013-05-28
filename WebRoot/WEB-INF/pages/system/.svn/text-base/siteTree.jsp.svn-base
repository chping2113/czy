<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/include/core.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>安徽项目公开网-用户管理</title>
	<link rel="stylesheet" href="css/zTreeStyle/zTreeStyle.css" type="text/css">
	<script type="text/javascript" src="js/jquery-ztree-2.4.min.js"></script>
	<script type="text/javascript" src="js/system/siteTree.js"></script>
	
	<script type="text/javascript">
	var zTree;
	var zNodes = ${message};
	var selectedOrganId = "";
	var actionType = "edit";
	
	
	$(function() {
		buildTree();
	});
	
	</script>
</head>

<body>
      
   <div class="right_main">
    <div class="add_top">您当前的位置：系统管理 > 组织机构管理</div>
    <div class="listop_search">组织机构管理</div>
    <div class="tree_content">
    	<div class="tree_js tree" id="tree_div"></div>
    	
    	<div class="dept_right" id="tree_node"></div>
    </div>
   </div><!--right_main-->

	
	<brady:confirm />
</body>