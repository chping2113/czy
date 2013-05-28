<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/include/core.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>安徽项目公开网-项目建设单位管理</title>
	
	<script type="text/javascript" src="js/system/construct.js"></script>
	<script type="text/javascript">
	var pageNo = "${pageNo}";
	function doDelete(id) {
		showConfirm("确定删除该条记录吗？", "doConfirmDelete("+id+")");
	}
	
	function doConfirmDelete(id) {
		location.href = "system/construct_delete.action?pageNo=" + pageNo + "&id=" + id;
	}
	</script>
</head>
<body>
   <div class="right_main">
   <form action="system/construct_query.action" method="post">
    <div class="add_top">您当前的位置：系统管理 > 项目建设单位管理</div>
    <div class="listop_search">信息栏目列表
    <span class="search">
	    <input type="text" class="search_input" id="title"  name="queryStr" value="${empty sessionScope.construct_queryStr ? "请输入帐号或建设单位名称" : sessionScope.construct_queryStr }"  onclick="clearDefaultText(this,'')" />
	    <input type="image" src="images/search_btn.gif" class="search_image" />    
    </span> 
    </div>
    </form>
    
    <table cellpadding="0" cellspacing="0" class="table_list">
    <tr>
      <th >帐号</th>
      <th >建设单位名称</th>
      <th >审核机构</th>
      <th >审核状态</th>
      <th >有效状态</th>
      <th width="25%">操作</th>
     </tr>
     <s:iterator value="pageInfo.pageData" var="con">
     <tr>
       <td>${con.code }</td>
       <td>${util:limitText(con.name,20) }</td>
       <td title="${con.approveOrgan.name }">${util:limitText(con.approveOrgan.name,20) }</td>
       <td>${con.state==1? "审核通过" : (con.state==2 ? "未通过" : "未审核") }</td>
       <td>${con.validState==1? "有效" : (con.validState==0 ? "无效" : "") }</td>
       <td class="table_list_add">
  
         <a href="javascript:show(${con.id })">详细</a>
         <a href="javascript:valid(${con.id })">有效设置</a>
         <s:if test="#con.state != 1">
         <a href="javascript:approve(${con.id })">审核</a>
         </s:if>
         <!--a href="javascript:doDelete(${con.id })">删除</a-->
  
		<s:if test="session.loginUser.role.type==1">
		<a href="javascript:doDelete(${con.id })">删除</a>
		</s:if>
       </td>
     </tr>
     </s:iterator>
     </table>
     
     <div class="page">
     
       
       		<brady:page url="${pageUrl }" pageInfo="${pageInfo }" />
     	
     </div>
    
 </div>  <!--right_main-->
 
 <brady:dialog title="建设单位信息维护" onClickOK="doApprove()" width="475" height="460"/>
 <brady:confirm />
</body>