<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/include/core.jsp"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理-帐号基本信息</title>
<script type="text/javascript">
$(function(){
	if("${loginType}"==0){
		$("#tab0").show();
	}else if("${loginType}"==1){
		$("#tab1").show();
	}else if("${loginType}"==2){
		$("#tab2").show();
	}else if("${loginType}"==3){
		$("#tab3").show();
	}else{
		$("#tab4").show();
	}

	$.brady.validator.validate("addForm", validator_config); //初始化表单验证构架
});
var validator_config = {
		email: {
			text: "请输入邮箱地址！",
			validators: {
				required: {
					failmsg:"邮箱地址不能为空!"
				},
				email: {
					failmsg:"邮箱地址的格式不正确!"
				},
				ajax: {
					url:'system/account_checkCompanyEmail.action',
					param:"company.email",
					returnText:'ok',
					failmsg:"该邮箱已被使用，请重新输入!"
				}
			}
		},
		tel: {
			text: "请输入电话,如13911110000或0551-1234567",
			validators: {
				required: {
					failmsg:"联系电话不能为空"
				},
				phone: {
					failmsg:"您输入的不是一个有效的电话号码!"
				}
			}
		}
};
function doSave() {
		$("#addForm").submit();
}
</script>

</head>

<body>
<div class="add_news">
	<div class="add_top">帐户基本信息</div>
	<form id="addForm" method="post" action="system/account_addAccount.action">
	
    
    <table id="tab1" style="display:block" cellpadding="0" cellspacing="0" class="table_add">
     <tr>
      <th width="28%">帐号</th>
      <td>${company.code }</td>
     </tr>
      
     <tr>
      <th width="28%">企业名称</th>
      <td>${company.name }</td>
     </tr>
     
     <tr>
      <th width="28%">营业执照注册号</th>
      <td>${company.licenseCode }</td>
     </tr>
     
     <tr>
      <th width="28%">联系人</th>
      <td>
       <input type="hidden" name="company.id" value="${company.id }" />
      <input type="text" id="name" name="company.linkman" value="${company.linkman }"  class="input_text"  maxlength="50"/>
      </td>
     </tr>
     
     <tr>
      <th width="28%">联系电话</th>
      <td><input type="text" id="tel" name="company.tel" value="${company.tel}"  class="input_text"  /></td>
     </tr>
     
     <tr>
      <th width="28%">邮件</th>
      <td><input type="text" id="email" name="company.email" value="${company.email }"  class="input_text"  /></td>
     </tr>
     
     <tr>
      <th width="28%">注册时间</th>
      <td><s:date name="company.registerTime" format="yyyy-MM-dd" /></td>
     </tr>
     
     <tr>
      <th width="28%">审核机构</th>
      <td></td>
     </tr>
     
     <tr>
      <th width="28%">有效状态</th>
      <td>${company.validState == 1 ? "正常" : "禁用" }</td>
     </tr>
    </table>
   
    
    </form>
    <div class="add_savebtn">
    	
    	<a href="javascript:doSave()"><img src="images/save.gif" border="0"/></a>
    	<a href="javascript:history.back()"><img src="images/back00.gif" border="0" /></a>
    </div>
</div> 
 
   
</body>
</html>
