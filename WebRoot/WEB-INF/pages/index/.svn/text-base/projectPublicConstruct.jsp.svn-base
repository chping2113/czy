<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/include/core.jsp"%>
<div class="right_middle_div">
	<div class="twopage_top">
		项目建设管理公开信息
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
			<s:iterator value="pageInfo.pageData" var="projectConstruct">
				<tr>
					<td>
						<a href="pub_showProjectConstruct.action?id=${projectConstruct.id}&title=1"
							target="_blank">${projectConstruct.code }</a>
					</td>
					<td>
						${util:limitText(projectConstruct.name,28) }
					</td>
					<td>
						${projectConstruct.site.name }
					</td>
					<td>
						<s:date name="#projectConstruct.createTime"
							format="yyyy-MM-dd" />
					</td>
				</tr>
			</s:iterator>
		</table>
		<div class="page">
			<brady:ajaxPage url="pub_projectPublicConstruct.action?code=${code }" pageInfo="${pageInfo }" />
		</div>
	</div>
</div>
