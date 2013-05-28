<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/include/core.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>安徽项目公开网-发布土地权信息</title>
	<script type="text/javascript">
		var pageNo = "${pageNo}";
		function doDelete(id) {
			showConfirm("确定删除该条记录吗？", "doConfirmDelete("+id+")");
		}
		
		function doConfirmDelete(id) {
			location.href = "project/projectLand_delete.action?pageNo=" + pageNo + "&id=" + id;
		}
		function doCommit(id,userId) {
			var loadContentUrl = "project/projectLand_approveUser.action?userId="+userId;
			showDialog(loadContentUrl, "btn_ok_close","#projectAimAddForm","project/projectLand_add.action?id="+id+"&approveState=3&pageNo=" + pageNo);
		
		}
		
		
	</script>
</head>
<body>
   <div class="right_main">
    <div class="add_top">
  <s:if test="type==6">  您当前的位置：待办工作 > 土地权审批出让信息审核</s:if>  
  <s:else>   您当前的位置：项目信息公开 > 发布土地权审批出让信息</s:else>
 </div>
    <form action="project/projectLand_query.action" method="post">
    <div class="listop_search">土地权审批出让信息
    <s:if test="type!=6">
		<s:if test="!canAccessURL('project/landProject_initLand.action')">
	<a href="project/projectLand_initAdd.action?type=1"><img 
		src="images/add.jpg" border="0"/></a>
		</s:if>
		<s:else>
		<s:if test="canAccessURL('project/landProject_initLand.action') && canAccessURL('pub_init.action')">
		<a href="project/projectLand_initAdd.action?type=1"><img 
		src="images/add.jpg" border="0"/></a>
		</s:if>
	</s:else></s:if>
		<span class="search">
		<input type="hidden" name="type" id="type" value="${type }"/>
		
		<s:if test="type==6">
		   <input type="text" class="search_input" id="title"  name="queryStr" value="${empty sessionScope.projectLand_queryStr ? "请输入项目名称" : sessionScope.projectLand_queryStr }"  onclick="clearDefaultText(this,'')" />
       <input type="image" src="images/search_btn.gif" class="search_image" onclick="deleteDefaultText('#title','请输入项目名称')" /></span>    </div>
    
		</s:if>
		<s:else>
		   <input type="text" class="search_input" id="title"  name="queryStr" value="${empty sessionScope.projectLand_queryStr ? "请输入项目编码或项目名称或状态" : sessionScope.projectLand_queryStr }"  onclick="clearDefaultText(this,'')" />
       <input type="image" src="images/search_btn.gif" class="search_image" onclick="deleteDefaultText('#title','请输入项目编码或项目名称或状态')" /></span>    </div>
    
		</s:else>
    </form>
    <table cellpadding="0" cellspacing="0" class="table_list">
    <tr>
      <th>项目编号</th>
      <th>项目名称</th>
      <th>状态</th>
      <th>操作</th>
     </tr>
     <s:iterator value="pageInfo.pageData" var="pro">
     <tr>
       <td>${util:limitText(pro.code,30) }</td>
       <td>${util:limitText(pro.name,40) }</td>
       <td>
       <s:if test="state==0">未提交</s:if>
       <s:elseif test="state==1">审核通过</s:elseif>
       <s:elseif test="state==2">审核未通过</s:elseif>
       <s:elseif test="state==3">待审核</s:elseif>
		</td>
       <td class="table_list_add">
       <s:if test="type!=6">
      	<a href="project/projectLand_view.action?id=${pro.id }&pageNo=${pageNo}">查看</a>
      	
      	<s:if test="session.loginUser.site.code==site.code">
      	
		<s:if test="!canAccessURL('project/landProject_initLand.action')">
		<a href="project/projectLand_initAdd.action?id=${pro.id }&type=2&pageNo=${pageNo}">修改</a>
		<s:if test="state==0">
		<a href="javascript:doDelete(${pro.id })">删除</a>
		
		<s:if test="#pro.approveUser==null">
		<a href="javascript:doCommit(${pro.id },0)">提交</a>
		</s:if>
		<s:else>
		<a href="javascript:doCommit(${pro.id },${pro.approveUser.id })">提交</a>
		</s:else>
		
		</s:if >
		<s:else>
		<s:if test="session.loginUser.role.type==1">
		<a href="javascript:doDelete(${pro.id })">删除</a>
		</s:if>
		</s:else>
		
		
		
		<s:if test="state==2">
		
		<s:if test="#pro.approveUser==null">
		<a href="javascript:doCommit(${pro.id },0)">提交</a>
		</s:if>
		<s:else>
		<a href="javascript:doCommit(${pro.id },${pro.approveUser.id })">提交</a>
		</s:else>
      	</s:if>
      	</s:if>
      	<s:else>
		<s:if test="canAccessURL('project/landProject_initLand.action') && canAccessURL('pub_init.action')">
			<a href="project/projectLand_initAdd.action?id=${pro.id }&type=2&pageNo=${pageNo}">修改</a>
		<s:if test="state==0">
		<a href="javascript:doDelete(${pro.id })">删除</a>
		
		<s:if test="#pro.approveUser==null">
		<a href="javascript:doCommit(${pro.id },0)">提交</a>
		</s:if>
		<s:else>
		<a href="javascript:doCommit(${pro.id },${pro.approveUser.id })">提交</a>
		</s:else>
		
		</s:if >
		<s:else>
		<s:if test="session.loginUser.role.type==1">
		<a href="javascript:doDelete(${pro.id })">删除</a>
		</s:if>
		</s:else>
		
		<s:if test="state==2">
		<s:if test="#pro.approveUser==null">
		<a href="javascript:doCommit(${pro.id },0)">提交</a>
		</s:if>
		<s:else>
		<a href="javascript:doCommit(${pro.id },${pro.approveUser.id })">提交</a>
		</s:else>
      	
      	</s:if>
		</s:if>
	</s:else>
		<s:if test="state==3">
		<s:if test="canAccessURL('project/landProject_initLand.action')">
		<s:if test="#pro.approveUser.id==#session.loginUser.id">
		<a href="project/projectLand_initAdd.action?id=${pro.id }&type=3&pageNo=${pageNo}">审核</a>
		</s:if>
			<s:if test="#pro.approveUser==null">
		<a href="project/projectLand_initAdd.action?id=${pro.id }&type=3&pageNo=${pageNo}">审核</a>
		</s:if>
		</s:if> 
		</s:if>
		</s:if>
		<s:else>
		<s:if test="session.loginUser.role.type==1">
		<a href="javascript:doDelete(${pro.id })">删除</a>
		</s:if>
		</s:else>
		</s:if>
		<s:else>
		<s:if test="#pro.approveUser.id==#session.loginUser.id">
		<a href="project/projectLand_initAdd.action?id=${pro.id }&type=6&pageNo=${pageNo}">审核</a>
		</s:if>
			<s:if test="#pro.approveUser==null">
		<a href="project/projectLand_initAdd.action?id=${pro.id }&type=6&pageNo=${pageNo}">审核</a>
		</s:if>
		</s:else>
      </td>
     </tr>
     </s:iterator>
     </table>
     
     <div class="page">
     	<brady:page url="project/projectLand_query.action?type=${type }" pageInfo="${pageInfo }" />
     </div>
    
 </div>  <!--right_main-->
 
 <brady:approveUser title="请选择审核人员" onClickOK="doApprove()" width="350" height="400"/>
<brady:confirm />
</body>