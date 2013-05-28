<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/include/core.jsp"%>

    <div class="add_tree_text">
    <div class="add_top">系统资源&nbsp; &gt; 详细信息</div>
    <table cellpadding="0" cellspacing="0" class="table_add">
     <tr height="50">
      <th width="20%">资源名称</th>
      <td>${resource.title }</td>
      </tr>
     <tr>
      <th>访问URL</th>
      <td>${resource.url }</td>
      </tr>
     <tr>
      <th>显示顺序</th>
      <td>${resource.position }</td>
      </tr>
    </table>
     
    <div class="add_savebtn">
    	<a href="javascript:addChildRes()">添加下级资源</a>
    	<a href="javascript:edit()">修改</a>
    	<s:if test="#childNodesCount == 0">
    	<a href="javascript:del()">删除</a>
    	</s:if>
    </div>
    
    </div>