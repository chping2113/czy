<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/include/core.jsp"%>

<script type="text/javascript">
$(function() {
	$(":radio").click(function() {
		$("#errmsg").hide();
	});
});
</script>

<div>
<form id="addForm" action="system/company_approve.action" method="post">
	<input type="hidden" name="id" value="${empty id ? 0 : id }" />
	<input type="hidden" name="pageNo" value="${empty pageNo ? 0 : pageNo }" />

    <table cellpadding="0" cellspacing="0" class="table_add">
     <tr>
      <th width="30%">企业帐号</th>
      <td>&nbsp;${code }</td>
      </tr>
      
     <tr>
      <th>企业名称</th>
      <td>&nbsp;${name }</td>
      </tr>
      
      <tr>
      <th>营业执照号</th>
      <td>&nbsp;${licenseCode }</td>
      </tr>

	 <tr>
       <th>注册时间</th>
       <td>&nbsp; <s:date name="registerTime" format="yyyy-MM-dd HH:mm:ss" /> </td>
     </tr>
     
	 <tr>
      <th>联系人</th>
      <td>&nbsp;${linkman }</td>
     </tr>
     
     <tr>
      <th>联系电话</th>
      <td>&nbsp;${tel }</td>
     </tr>
      
     <tr>
      <th>电子邮件</th>
      <td>&nbsp;${email }</td>
     </tr>
     
     <tr>
      <th>审核机构</th>
      <td>&nbsp;</td>
      </tr>

     <tr>
      <th>审核状态</th>
      <td>&nbsp;
      	<input type="radio" name="state" value="1" ${state==1 ? "checked" :"" }>通过&nbsp;&nbsp;
      	<input type="radio" name="state" value="2" ${state==2 ? "checked" :""} >不通过
      	<span id="errmsg" class="validator_fail_tips" style="display:none"></span>
      </td>
      </tr>
     
    </table>
</form>    
</div><!--content-->