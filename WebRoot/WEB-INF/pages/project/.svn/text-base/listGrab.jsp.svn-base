<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/include/core.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<script type="text/javascript" src="<%=request.getContextPath()%>/date/WdatePicker.js"></script>
	<title>安徽项目公开网-发布审批信息</title>
	<script type="text/javascript">
		var pageNo = "${pageNo}";
		function doDelete(id) {
			showConfirm("确定删除该条记录吗？", "doConfirmDelete("+id+")");
		}
		
		function doConfirmDelete(id) {
			location.href = "project/projectApprove_delete.action?pageNo=" + pageNo + "&id=" + id;
		}
		function doCommit(id,userId) {
			
			var loadContentUrl = "project/projectLand_approveUser.action?userId="+userId;
			showDialog(loadContentUrl, "btn_ok_close","","project/projectApprove_add.action?id="+id+"&approveState=3&type=4&pageNo=" + pageNo);
		
		}
		function   batchDeteleAll()
       {
	      fom.action="project/projectApprove_batchDelete.action";
	      fom.submit();
      
      }
      function   verifyAll()
       {
	      fom.action="project/projectApprove_verifyAll.action?approveState=1&type=3";
	      fom.submit();
      
      }
      function   recommendAll()
       {
	      fom.action="project/projectApprove_recommendAll.action";
	      fom.submit();
      
      }
      
		function checkAll() {
  for (var i = 0; i < document.getElementsByName("proIds").length; i++) {
   document.getElementsByName("proIds")[i].checked = document.getElementById("selectAll").checked;
  }
  }
    
		
		
		
	</script>
</head>
<body>
   <div class="right_main">
    <div class="add_top"><span style="float: left;">您当前的位置：中小企业服务信息公开 > 抓取信息</span>
   </div>
    <form action="project/projectApprove_queryGrab.action" method="post">
    <div class="listop_search">抓取信息
     开始时间:<input type="text" id="startTime" name="startTime"  onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd '})" class=" Wdate " style="width: 100px" readonly="readonly"/>
	结束时间:<input type="text" id="endTime" name="endTime"  onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd '})" class=" Wdate " style="width: 100px" readonly="readonly"/>	
       <input type="text" class="search_input" id="title"  name="queryStr" value="${empty sessionScope.projectApprove_queryStr ? "请输入项目编码或项目名称或状态" : sessionScope.projectApprove_queryStr }"  onclick="clearDefaultText(this,'')" />
       <input type="image" src="images/search_btn.gif" class="search_image" onclick="deleteDefaultText('#title','请输入项目编码或项目名称或状态')"/></span>    </div>
    </form>
  <!--   <form id="fom" method="post" action="project/projectApprove_batchDelete.action"> -->
        <form id="fom" method="post" action="project/projectApprove_verifyAll.action?approveState=1&type=3">
        <!-- <form id="fom" method="post" action="project/projectApprove_recommendAll.action">-->
         <form name="fom" method="post">
    <table cellpadding="0" cellspacing="0" class="table_list">
    <tr>
    
      <th><input id="selectAll" type="checkbox"  onclick="checkAll()">全选</th>  
      <th>标题</th>
      <th>所属栏目</th>
      <th>发布平台</th>
      <th>发布时间</th>
      <th>状态</th>
      <th>操作</th>
   

      </th>
     </tr>
     <s:iterator value="pageInfo.pageData" var="pro" status="status">
     <tr>
        <td><input type="checkbox" name="proIds"  value="${pro.id}"/></td>
       <td><a href="project/projectApprove_view.action?id=${pro.id }&pageNo=${pageNo}">${util:limitText(pro.name,60) }</a></td>
        <td>${util:limitText(pro.scolumnName,60) }</td>
        <td>${util:limitText(pro.site.name,60) }</td>
        <td>${util:limitText(pro.createTime,60) }</td>
       
       <td>
       <s:if test="state==0">未提交</s:if>
       <s:elseif test="state==1">审核通过</s:elseif>
       <s:elseif test="state==2">审核未通过</s:elseif>
       <s:elseif test="state==3">待审核</s:elseif>
		</td>
       <td class="table_list_add">
      	<!--  <a href="project/projectApprove_view.action?id=${pro.id }&pageNo=${pageNo}">查看</a>-->
      	
      	<s:if test="session.loginUser.site.code==site.code">
      	
		<s:if test="!canAccessURL('project/approveProject_initApprove.action')">
		<a href="project/projectApprove_initAdd.action?id=${pro.id}&type=2&subType=${pro.approveType}&pageNo=${pageNo}">修改</a>
		
		<s:if test="state==0">
		
		<a href="javascript:doDelete(${pro.id })">删除</a>
		
		<s:if test="#pro.approveUser==null">
		<a href="javascript:doCommit(${pro.id },0)">提交</a>
		</s:if>
		<s:else>
		<a href="javascript:doCommit(${pro.id },${pro.approveUser.id })">提交</a>
		</s:else>
		</s:if>
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
		</s:else></s:if>
      	</s:if>
      	<s:else>
		<s:if test="canAccessURL('project/approveProject_initApprove.action') && canAccessURL('pub_init.action')">
			<a href="project/projectApprove_initAdd.action?id=${pro.id }&type=2&subType=${pro.approveType}&pageNo=${pageNo}">修改</a>
		
		<s:if test="state==0">
		
		<a href="javascript:doDelete(${pro.id })">删除</a>
		
		<s:if test="#pro.approveUser==null">
		<a href="javascript:doCommit(${pro.id },0)">提交</a>
		</s:if>
		<s:else>
		<a href="javascript:doCommit(${pro.id },${pro.approveUser.id })">提交</a>
		</s:else>
		</s:if>
		
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
		</s:else></s:if>
		</s:if>
	</s:else>
		<s:if test="state==3">
		<s:if test="canAccessURL('project/approveProject_initApprove.action')">
		
		
		<s:if test="#pro.approveUser.id==#session.loginUser.id">
	<!--  	<a href="project/projectApprove_initAdd.action?id=${pro.id}&type=3&subType=${pro.approveType}&pageNo=${pageNo}">审核</a> -->
	<!-- 	
		<input type="checkbox" name="verProIds"  value="${pro.id}"/>审核
		<input type="checkbox" name="reProIds"  value="${pro.id}"/>推荐 -->
		</s:if>
	 
		
			<s:if test="#pro.approveUser==null">  
		<a href="project/projectApprove_initAdd.action?id=${pro.id }&type=3&subType=${pro.approveType}&pageNo=${pageNo}">审核</a>
		</s:if>
		
		</s:if>
		</s:if>
		</s:if> 
		<s:else>
		
		<s:if test="session.loginUser.role.type==1">
		<a href="javascript:doDelete(${pro.id })">删除</a>
		</s:if>
		<s:if test="canAccessURL('pub_init.action')">
		
		
		<s:if test="#status.count==1">
		<s:if test="#flag1==1"><a href="project/projectApprove_release.action?id=${pro.id }&pageNo=${pageNo}">发布</a></s:if>
		<s:elseif test="#flag1==2">
		<a href="project/projectApprove_release.action?id=${pro.id }&pageNo=${pageNo}">修改</a>
		</s:elseif>
		</s:if>
		<s:elseif test="#status.count==2">
		<s:if test="#flag2==1"><a href="project/projectApprove_release.action?id=${pro.id }&pageNo=${pageNo}">发布</a></s:if>
		<s:elseif test="#flag2==2">
		<a href="project/projectApprove_release.action?id=${pro.id }&pageNo=${pageNo}">修改</a>
		</s:elseif>
		</s:elseif>
		<s:elseif test="#status.count==3">
		<s:if test="#flag3==1"><a href="project/projectApprove_release.action?id=${pro.id }&pageNo=${pageNo}">发布</a></s:if>
		<s:elseif test="#flag3==2">
		<a href="project/projectApprove_release.action?id=${pro.id }&pageNo=${pageNo}">修改</a>
		</s:elseif>
		</s:elseif>
		<s:elseif test="#status.count==4">
		<s:if test="#flag4==1"><a href="project/projectApprove_release.action?id=${pro.id }&pageNo=${pageNo}">发布</a></s:if>
		<s:elseif test="#flag4==2">
		<a href="project/projectApprove_release.action?id=${pro.id }&pageNo=${pageNo}">修改</a>
		</s:elseif>
		</s:elseif>
		<s:elseif test="#status.count==5">
		<s:if test="#flag5==1"><a href="project/projectApprove_release.action?id=${pro.id }&pageNo=${pageNo}">发布</a></s:if>
		<s:elseif test="#flag5==2">
		<a href="project/projectApprove_release.action?id=${pro.id }&pageNo=${pageNo}">修改</a>
		</s:elseif>
		</s:elseif>
		<s:elseif test="#status.count==6">
		<s:if test="#flag6==1"><a href="project/projectApprove_release.action?id=${pro.id }&pageNo=${pageNo}">发布</a></s:if>
		<s:elseif test="#flag6==2">
		<a href="project/projectApprove_release.action?id=${pro.id }&pageNo=${pageNo}">修改</a>
		</s:elseif>
		</s:elseif>
		<s:elseif test="#status.count==7">
		<s:if test="#flag7==1"><a href="project/projectApprove_release.action?id=${pro.id }&pageNo=${pageNo}">发布</a></s:if>
		<s:elseif test="#flag7==2">
		<a href="project/projectApprove_release.action?id=${pro.id }&pageNo=${pageNo}">修改</a>
		</s:elseif>
		</s:elseif>
		<s:elseif test="#status.count==8">
		<s:if test="#flag8==1"><a href="project/projectApprove_release.action?id=${pro.id }&pageNo=${pageNo}">发布</a></s:if>
		<s:elseif test="#flag8==2">
		<a href="project/projectApprove_release.action?id=${pro.id }&pageNo=${pageNo}">修改</a>
		</s:elseif>
		</s:elseif>
		<s:elseif test="#status.count==9">
		<s:if test="#flag9==1"><a href="project/projectApprove_release.action?id=${pro.id }&pageNo=${pageNo}">发布</a></s:if>
		<s:elseif test="#flag9==2">
		<a href="project/projectApprove_release.action?id=${pro.id }&pageNo=${pageNo}">修改</a>
		</s:elseif>
		</s:elseif>
		<s:elseif test="#status.count==10">
		<s:if test="#flag10==1"><a href="project/projectApprove_release.action?id=${pro.id }&pageNo=${pageNo}">发布</a></s:if>
		<s:elseif test="#flag10==2">
		<a href="project/projectApprove_release.action?id=${pro.id }&pageNo=${pageNo}">修改</a>
		</s:elseif>
		</s:elseif>
		</s:if>
		
		
		
		</s:else>
		
	 	<!--  <input type="checkbox" name="proIds"  value="${pro.id}"/>删除-->
      </td>
     </tr>
     </s:iterator>
     <s:if test="session.loginUser.role.id==7">
		
		 <tr> 
      <td align="center" colspan=7>
     <!--  <input type="submit"  value="删除" onclick="batchDeteleAll()">-->
     <input type="submit" value="置顶" onclick="singleUp()">
     </td>
     </tr>
	
	</s:if>	
	<s:else>
     
      <tr> 
      <td align="center" colspan=7>
      <input type="submit" value="置顶" onclick="singleUp()">
     <input type="submit" value="审核" onclick="verifyAll">
     <!--  <input type="submit" value="推荐" onclick="recommendAll()">
     <input type="submit"  value="删除" onclick="batchDeteleAll()">-->
     </td>
     </tr>
     </s:else>
      
     </table>
     </form>
     <div class="page">
     	<brady:page url="project/projectApprove_query.action" pageInfo="${pageInfo }" />
     </div>
    
 </div>  <!--right_main-->
<brady:confirm />
 <brady:approveUser title="请选择审核人员" onClickOK="doApprove()" width="350" height="400"/>
</body>