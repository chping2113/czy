<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/include/core.jsp"%>
  <div id="tba_project_body" style="display:block;">
  <table cellpadding="0" cellspacing="0" class="table_list">
   <tr>
  <th  width="33%">项目编码</th>
  <th width="33%">项目名称</th>
  <th width="20%">发布单位</th>
  <th width="14%">发布时间</th>
  </tr>
  </table>
 <table cellpadding="0" cellspacing="0" class="table_list">
  <s:iterator value="projectAimList" var="projectAim" status="status1">
  		<s:if test="#status1.last == false">
  <tr>
  <td width="33%"><a href="pub_showProjectAim.action?id=${projectAim.id}" target="_blank">${util:limitText(projectAim.code,28) }</a></td>
  <td width="33%">${util:limitText(projectAim.name,16) }</td>
  <td width="20%">${projectAim.site.name }</td>
  <td width="14%"><s:date name="#projectAim.createTime" format="yyyy-MM-dd" /></td>
  </tr>
  		</s:if>
  		<s:else>
  <tr>
  <td width="33%" style="border-bottom:none;"><a href="pub_showProjectAim.action?id=${projectAim.id}" target="_blank">${util:limitText(projectAim.code,28) }</a></td>
  <td width="33%" style="border-bottom:none;">${util:limitText(projectAim.name,16) }</td>
  <td width="20%" style="border-bottom:none;">${projectAim.site.name }</td>
  <td width="14%" style="border-bottom:none;"><s:date name="#projectAim.createTime" format="yyyy-MM-dd" /></td>
  </tr>
  		</s:else>
  </s:iterator>
  </table>
</div>