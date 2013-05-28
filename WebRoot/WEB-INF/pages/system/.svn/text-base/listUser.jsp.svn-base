<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/include/core.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>安徽项目公开网-用户管理</title>
	<link rel="stylesheet" href="css/zTreeStyle/zTreeStyle.css" type="text/css">
	
	<script type="text/javascript" src="js/system/user.js"></script>
	<script type="text/javascript" src="js/jquery-ztree-2.4.min.js"></script>
	<script type="text/javascript">
		var pageNo = "${pageNo}";
		function doSubmit(){
			var url = "system/user_checkEmail.action";
			var param = {"email":$("#email").val(),"editId":$("#id").val()};
			$.post(url, param, function(date) {
				if(date=='err'){
					alert("该邮箱已经被使用，请重新输入!");
					return false ;
				}else{
					$("#addForm").submit();
				}
			});
		}
	</script>
</head>
<body>
   <div class="right_main">
   <form action="system/user_query.action" method="post">
    <div class="add_top">您当前的位置：系统管理 > 政府机关帐户管理</div>
    <div class="listop_search">信息栏目列表
      <a href="system/user_initAdd.action"><img src="images/add.jpg" border="0"/></a>
    <span class="search">
	    <input type="text" class="search_input" id="title"  name="queryStr" value="${empty sessionScope.user_queryStr ? "请输入您要搜索的用户帐号或组织机构" : sessionScope.user_queryStr }"  onclick="clearDefaultText(this,'')" />
	    <input type="image" src="images/search_btn.gif" class="search_image"  onclick="deleteDefaultText('#title','请输入您要搜索的用户帐号')"/>    
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
       <td title="${u.code }">${util:limitText(u.code,20) }</td>
       <td title="${u.role.name }">${util:limitText(u.role.name,20) }</td>
       <td><s:date name="#u.createTime" format="yyyy-MM-dd" /></td>
       <td>${u.state==1? "有效" : "无效" }</td>
       <td title="${u.site.name }">${util:limitText(u.site.name,20) }</td>
       <td class="table_list_add">
       	<a href="system/user_view.action?id=${u.id }&pageNo=${pageNo}">详细</a>
       	<a href="system/user_initAdd.action?id=${u.id }&pageNo=${pageNo}">修改</a>
       	<s:if test="session.loginUser.id != id">
       	<s:if test="#u.code != 'admin'">
       	<a href="javascript:doDelete(${u.id })">删除</a> 
       	</s:if>
       	</s:if>
       </td>
     </tr>
     </s:iterator>
     </table>
     
     <div class="page">
     	<brady:page url="${pageUrl }" pageInfo="${pageInfo }" />
     </div>
    
 </div>  <!--right_main-->
 
 <brady:dialog title="政府部门帐户信息维护" onClickOK="doSubmit()" width="650" height="360"/>
 <brady:confirm />
</body>