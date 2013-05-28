<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/include/core.jsp"%>
<div class="right_middle_div">
	<div class="twopage_top">
		 招投标信息
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
			<s:iterator value="pageInfo.pageData" var="projectAim">
				<tr>
					<td>
						<a href="pub_showProjectAim.action?id=${projectAim.id}&title=1"
							target="_blank">${projectAim.code }</a>
					</td>
					<td>
						${util:limitText(projectAim.name,28) }
					</td>
					<td>
						${projectAim.site.name }
					</td>
					<td>
						<s:date name="#projectAim.createTime"
							format="yyyy-MM-dd" />
					</td>
				</tr>
			</s:iterator>
		</table>
		<div class="page">
			<brady:ajaxPage url="pub_projectPublicAim.action?code=${code }" pageInfo="${pageInfo }" />
		</div>
	</div>
</div>
