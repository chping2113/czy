<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/include/core.jsp"%>
<div class="right_middle_div">
	<div class="twopage_top">
		土地权审批出让信息
	</div>
	<div>
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
			<s:iterator value="pageInfo.pageData" var="projectLand">
				<tr>
					<td>
						<a href="pub_showProjectLand.action?id=${projectLand.id}"
							target="_blank">${projectLand.code }</a>
					</td>
					<td>
						${projectLand.name }
					</td>
					<td>
						${projectLand.site.name }
					</td>
					<td>
						<s:date name="#projectLand.createTime"
							format="yyyy-MM-dd" />
					</td>
				</tr>
			</s:iterator>
		</table>
		<div class="page">
			<brady:ajaxPage url="pub_projectPublicLand.action?code=${code }" pageInfo="${pageInfo }" />
		</div>
	</div>
</div>
