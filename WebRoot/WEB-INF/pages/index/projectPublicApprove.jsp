<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/include/core.jsp"%>
<div class="right_middle_div">
	<div class="twopage_top">
		项目审批信息公开
	</div>
	<div >
		<table cellpadding="0" cellspacing="0" class="table_list">
			<tr>
				<th>
					项目编码
				</th>
				<th>
					项目名称
				</th>
				<th>
					发布机关
				</th>
				<th>
					发布时间
				</th>
			</tr>
			 <s:iterator value="pageInfo.pageData" var="pa">
  <tr>
  <td><a href="pub_showProjectApprove.action?id=${pa.projectApprove.id}&title=1" target="_blank">${pa.projectApprove.code }</a></td>
  <td>${util:limitText(pa.projectApprove.name,28) }</td>
  <td>${pa.site.name }</td>
  <td><s:date name="#pa.createTime" format="yyyy-MM-dd" /></td>
  </tr>
  </s:iterator>
		</table>
		<div class="page">
			<brady:ajaxPage url="pub_projectPublicApprove.action?code=${code }" pageInfo="${pageInfo }" />
		</div>
	</div>
</div>
