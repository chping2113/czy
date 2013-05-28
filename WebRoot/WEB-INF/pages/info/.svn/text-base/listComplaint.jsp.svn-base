<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/include/core.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>安徽项目公开网-查看投诉内容</title>
	
	<script type="text/javascript" src="js/info/complaint.js"></script>
		<script type="text/javascript">
		var pageNo = "${pageNo}";
		function doDelete(id) {
			showConfirm("确定删除该条记录吗？", "doConfirmDelete("+id+")");
		}
		
		function doConfirmDelete(id) {
			location.href = "info/complaint_delete.action?pageNo=" + pageNo + "&id=" + id;
		}
	</script>
</head>
<body>
   <div class="right_main">
   <form action="info/complaint_query.action" method="post">
    <div class="add_top">您当前的位置：投诉举报处理 > 查看投诉内容</div>
    <div class="listop_search">投诉信息列表
    <!--a href="info/notice_addRequest.action?pageNo=${pageNo }"><img src="images/add.jpg" border="0"/></a-->
    <span class="search">
	    <input type="text" class="search_input" id="title"  name="queryStr" value="${empty sessionScope.complaint_queryStr ? "请输入举报主题" : sessionScope.complaint_queryStr }"  onclick="clearDefaultText(this,'')" />
	    <input type="image" src="images/search_btn.gif" class="search_image"  onclick="deleteDefaultText('#title','请输入举报主题')"/>    
    </span> 
    </div>
    </form>
    
    <table cellpadding="0" cellspacing="0" class="table_list">
    <tr>
      <div align="center">
      <th >举报主题</th>
      <th >举报人姓名</th>
      <th >举报人单位</th>
      <th >处理状态</th>
      <th >举报时间</th>
      <th>操作</th>
      </div>
     </tr>
     
     <s:iterator value="pageInfo.pageData" var="complaint" >
     <tr >
       <td title="${complaint.title }">${util:limitText(complaint.title,30) }</td>
       <td>${util:limitText(complaint.name,8) }</td>
       <td>${util:limitText(complaint.dept,10) }</td>
       <td>${complaint.dealState==0?"未处理":"已处理" }</td>
       <td><s:date name="#complaint.createTime" format="yyyy-MM-dd" /></td>
       <td class="table_list_add">
         <a href="javascript:show(${complaint.id })">查看</a>
         <s:if test="#complaint.dealState != 1">
         <a href="javascript:edit(${complaint.id })">处理意见</a>
         </s:if>
         
		<s:if test="session.loginUser.role.type==1">
		<a href="javascript:doDelete(${complaint.id })">删除</a>
		</s:if>
       </td>
     </tr>
     </s:iterator>
     </table>
     
     <div class="page">
     	<brady:page url="${pageUrl }" pageInfo="${pageInfo }" />
     </div>
    
 </div>  <!--right_main-->
 
 <brady:dialog title="查看投诉内容 " onClickOK="doSave1()" width="675" height="500"/>
 <brady:confirm />
</body>