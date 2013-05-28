<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/include/core.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>安徽项目公开网-alexa管理</title>
	<link rel="stylesheet" href="css/zTreeStyle/zTreeStyle.css" type="text/css">
	
	<script type="text/javascript" src="js/system/user.js"></script>
	<script type="text/javascript" src="js/jquery-ztree-2.4.min.js"></script>
	<script type="text/javascript">
		var pageNo = "${pageNo}";
		var alexaId = "";
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
		
		function doDelete(id) {
			alexaId = id;
			showConfirm("确定删除该条记录吗？", "doConfirmDelete()");
		}
		
		function doConfirmDelete(id) {
			location.href = "system/alexa_delete.action?pageNo=" + pageNo + "&id=" + alexaId;
		}
		
	</script>
</head>
<body>
   <div class="right_main">
   <form action="system/alexa_query.action" method="post">
    <div class="add_top">您当前的位置：系统管理 > alexa信息管理 　　　　　　　　　　　　　　　　　　　　　　<a href="system/alexa_getAllData.action">获取所有数据</a></div>
    <div class="listop_search">信息栏目列表
      <a href="system/alexa_initAdd.action"><img src="images/add.jpg" border="0"/></a>
    <span class="search">
	    <input type="text" class="search_input" id="queryCode"  name="queryCode" value="${empty sessionScope.user_queryStr ? "请输入您要搜索的类型或单位名称" : sessionScope.user_queryStr }"  onclick="clearDefaultText(this,'')" />
	    <input type="image" src="images/search_btn.gif" class="search_image"  onclick="deleteDefaultText('#title','请输入您要搜索的用户帐号')"/>    
    </span> 
    </div>
    </form>
    
    <table cellpadding="0" cellspacing="0" class="table_list">
    <tr>
      <th width="15%">类型</th>
      <th width="20%">单位名称</th>
      <th width="25%">连接地址</th>
      <th width="15%">alexa数据</th>
      <th>操作</th>
     </tr>
     <s:iterator value="pageInfo.pageData" var="u">
     <tr>
       
       <td title="${u.type }">${util:limitText(u.type,20) }</td>
       <td title="${u.title }">${util:limitText(u.title,20) }</td>
       <td title="${u.url }">${util:limitText(u.url,20) }</td>
       <s:if test="#u.person != null">
       <td>${u.person}|${u.page}|${u.personPage}</td>
       </s:if>
       <s:else>
       <td></td>
       </s:else>
       <td class="table_list_add">
       	<a href="system/alexa_view.action?id=${u.id }&pageNo=${pageNo}">详细</a>
       	<a href="system/alexa_initAdd.action?id=${u.id }&pageNo=${pageNo}">修改</a>
       	<a href="javascript:doDelete(${u.id })">删除</a> 
       	<a href="system/alexa_getData.action?id=${u.id }&pageNo=${pageNo}">获取数据</a> 
       </td>
     </tr>
     </s:iterator>
     </table>
     
     <div class="page">
     	<brady:page url="${pageUrl }" pageInfo="${pageInfo }" />
     </div>
    
 </div>  <!--right_main-->
 
 <brady:confirm />
</body>