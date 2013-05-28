<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/include/core.jsp"%>

      <div  id="dataCount_body"  >
        <table cellpadding="0" cellspacing="0" class="table_list">
      <tr>
      <th>省直部门</th>
      
		<s:iterator value="#valuesList" var="ptl" status="status">
		<s:if test="#status.count<9">
		<th>${ptl.name }</th>
		</s:if>
		</s:iterator>
		<th><a href="pub_dataCount.action?type=1">更多</a></th>
      </tr>
       <tr>
      <td>合计:${allSum }</td>
      <s:iterator value="#valuesList" var="ptl" status="status">
		<s:if test="#status.count<9">
		<td>${ptl.value }</td>
		</s:if>
		</s:iterator>
		<td></td>
      </tr> 
      <tr>
      <th>省辖市</th>
      <s:iterator value="#valuesList2" var="ptl" status="status">
		<s:if test="#status.count<9">
		<th>${ptl.name }</th>
		</s:if>
		</s:iterator>
		<th colspan="2"><a href="pub_dataCount.action?type=2">更多</a></th>
      </tr>
       <tr>
      <td>合计:${allSum1 }</td>
      <s:iterator value="#valuesList2" var="ptl" status="status">
		<s:if test="#status.count<9">
		<td>${ptl.value }</td>
		</s:if>
		</s:iterator>
      <td></td>
      </tr>
       <tr>
      <th>县(市、区)</th>
      <s:iterator value="#valuesList3" var="ptl" status="status">
		<s:if test="#status.count<9">
		<th>${ptl.name }</th>
		</s:if>
		</s:iterator>
		<th colspan="5" align="right"><a href="pub_dataCount.action?type=3">更多&nbsp;&nbsp;</a></th>
      </tr>
       <tr >
      <td style="border-bottom:none;">合计:${allSum2 }</td>
      <s:iterator value="#valuesList3" var="ptl" status="status">
		<s:if test="#status.count<9">
		<td style="border-bottom:none;">${ptl.value }</td>
		</s:if>
		</s:iterator>
      <td style="border-bottom:none;"></td>
      </tr>
      </table>
      </div>
      

