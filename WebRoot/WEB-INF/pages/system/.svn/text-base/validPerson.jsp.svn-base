<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/include/core.jsp"%>

<script type="text/javascript">
$(function() {
	$(":radio").click(function() {
		$("#errmsg").hide();
	});
});
</script>

<div class="view_panel">
<form id="addForm" action="system/person_valid.action" method="post">
	<input type="hidden" name="id" value="${empty id ? 0 : id }" />
	<input type="hidden" name="pageNo" value="${empty pageNo ? 0 : pageNo }" />
	
    <table cellpadding="0" cellspacing="0" class="table_add">
     <tr>
      <th width="20%">帐号</th>
      <td>&nbsp;${code }</td>
     </tr>
     
     <tr>
      <th width="20%">姓名</th>
      <td>&nbsp;${name }</td>
     </tr>
     
     <tr>
      <th width="20%">所属单位</th>
      <td>&nbsp;${dept }</td>
     </tr>
     
     <tr>
      <th width="20%">性别</th>
      <td>&nbsp;${sex == "m" ? "男" : "女" }</td>
     </tr>
     
     <!--tr>
      <th width="20%">证件类型</th>
      <td>&nbsp;${certificateType == "a" ? "身份证" : "其它" }</td>
     </tr-->
	
	 <tr>
      <th width="20%">身份证号码</th>
      <td>&nbsp;${certificateCode }</td>
     </tr>
     
	 <tr>
       <th>注册时间</th>
       <td>&nbsp; <s:date name="registerTime" format="yyyy-MM-dd HH:mm:ss" /> </td>
     </tr>
     
     <tr>
      <th width="20%">联系电话</th>
      <td>&nbsp;${tel }</td>
     </tr>
      
     <tr>
      <th width="20%">电子邮件</th>
      <td>&nbsp;${email }</td>
     </tr>
     
      <tr>
      <th>有效状态</th>
      <td>&nbsp;
      	<input type="radio" name="validState" value="1" ${validState==1 ? "checked" :"" }>有效&nbsp;&nbsp;
      	<input type="radio" name="validState" value="0" ${validState==0 ? "checked" :""} >无效
      	<span id="errmsg" class="validator_fail_tips" style="display:none"></span>
      </td>
      </tr>
     
    </table>
</form>

</div><!--content-->