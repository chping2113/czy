<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/include/core.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>安徽项目公开网-重点项目类型</title>
	
	<script type="text/javascript" src="js/projectFocus.js"></script>
	<script type="text/javascript">
		var pageNo = "${pageNo}";
	</script>
</head>
<body>
   <div class="right_main">
   <form action="project/projectAegis_query.action" method="post">
   <s:if test="type==1">
    <div class="add_top">您当前的位置：系统管理 > 十大重点示范项目配置</div></s:if>
   <s:else>
   
    <div class="add_top">您当前的位置：项目信息公开 > 发布十大重点示范项目</div>
   </s:else>
    <div class="listop_search">十大重点示范项目
    <s:if test="type==1">
    <a href="javascript:add()"><img src="images/add.jpg" border="0"/></a></s:if>
    <span class="search">
	    <input type="text" class="search_input" id="title"  name="queryStr" value="${empty sessionScope.keyProjectKind_queryStr ? "请输入类型名称" : sessionScope.keyProjectKind_queryStr }"  onclick="clearDefaultText(this,'')" />
	    <input type="image" src="images/search_btn.gif" class="search_image" onclick="deleteDefaultText('#title','请输入类型名称')"/>    
    	<input type="hidden" id="type"  name="type" value="${type }"/>
    	
    </span> 
    </div>
    </form>
    
    <table cellpadding="0" cellspacing="0" class="table_list">
    <tr>
      <th width="45%">类型名称</th>
      <th width="15%">显示顺序</th>
      <th>操作</th>
     </tr>
     <s:iterator value="pageInfo.pageData" var="kind">
     <tr>
       <td title="${kind.name }">${util:limitText(kind.name,20) }</td>
       <td>${kind.showOrder }</td>
       <td class="table_list_add">
       <s:if test="type==1">
        <a href="javascript:show(${kind.id })">查看</a>
         <a href="javascript:edit(${kind.id })">修改</a>
         <a href="javascript:dele(${kind.id })">删除</a>
       </s:if>
       <s:else>
        <a href="project/projectIssue_list.action?keyid=${kind.id }&pageNo=${pageNo }">查看项目</a>
         <a href="project/projectIssue_addRequest.action?keyid=${kind.id }">发布项目</a>
       </s:else>
       </td>
     </tr>
     </s:iterator>
     </table>
     
     <div class="page">
     	<brady:page url="project/projectAegis_list.action?type=${type }" pageInfo="${pageInfo }" />
     </div>
    
 </div>  <!--right_main-->
 
 <brady:dialog title="重点项目类型 " onClickOK="doSave()" width="450" height="200"/>
 <brady:confirm />
</body>