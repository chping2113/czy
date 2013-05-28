<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="brady" %>
<script type="text/javascript">
	function douClick(){
		if(__commonQuery_query_onClickOK != "") {
   			eval(__commonQuery_query_onClickOK);
   		}
		$("#dialog-query").dialog("close");
	}
	
	function oneClick(str) {
		var cls = "." + str;
		$(cls).attr("checked", "true");
	}
</script>
	   <table cellpadding="0" cellspacing="0" class="search-list-content">
         <tr>
			  <th width="8%">选择</th>
	          <th width="40%">区划名称</th>
	          <th>区划代码</th>
         </tr>
         
         <s:iterator value="#districtList" var="per" status="stat">
         	<tr class="search-list-content-tr${stat.index % 2 == 0 ? '1' : '2' }" ondblclick="douClick();" onclick="oneClick('radioEmp${stat.count}');")>
	           <td><input name="radioEmp" class="radioEmp${stat.count}" type="radio" value="${per.code }" /></td>
	           <td id="name_${per.code }">${per.name }</td>
	           <td id="code_${per.code }">${per.code }</td>
         	</tr>
         </s:iterator>
        </table>
