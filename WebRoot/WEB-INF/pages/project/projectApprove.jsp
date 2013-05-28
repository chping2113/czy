<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/include/core.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>安徽项目公开网-项目基本信息</title>
	<script type="text/javascript">
		jQuery(function(){
			//$.brady.validator.validate("projectApproveForm", validator_projectApprove);
		});
		function doSubmit(){
			var url = "project/project_validateCode.action";
			var param = {"coder":$("#code").val()};
			$.post(url, param, function(date) {
				if(date=='true'){
					alert("项目编号已经存在，请刷新或输入其它编号！");
					return false ;
				}else{
					$("#projectApproveForm").submit();
				}
			});
		}
		$(function() {
			$('#code').bind('keyup mouseout', function() {
			  var prefix = $("#prefix").val().substring(0,21);
				var iVal = $(this).val();
				if(iVal.length < 21 || iVal.substring(0,21) != prefix) {
					$(this).val($("#prefix").val());
				}
			});
			
		});
	</script>
</head>
<body>
   <div class="right_main">
    <div class="add_top">发布项目基本信息&nbsp; &gt; 审批</div>
    <form action="project/project_approve.action" id="projectApproveForm" method="post">
    <table cellpadding="0" cellspacing="0" class="table_add">
      <tr>
      <th>项目编号</th>
      <td>
      	<input id="prefix" type="hidden" value="${coder }">
      	<input type="text" name="code" id="code" class="input_text validator_focus_border" value="${coder }" maxlength="30"/></td>
      </tr>
	  <tr>
      <th>发布机构</th>
      <td>
	  	${loginUser.site.name }
	  </td>
      </tr>
      <tr>
      <th>建设单位</th>
      <td>
	  	${company.name }
	  </td>
      </tr>
     <tr>
      <th>项目名称</th>
      <td>
      	<input type="hidden" name="id" id="id" value="${id }"/>
	  	${name }
	  </td>
      </tr>
     <tr>
      <th>项目金额</th>
      <td>${money }</td>
      </tr>
     <tr>
      <th>项目归属地</th>
      <td>${district.name }</td>
      </tr>
	  <tr>
      <th>项目业主</th>
      <td>${owner }</td>
      </tr>
      <tr>
      <th>发布时间</th>
      <td><s:date name='createTime' format='yyyy-MM-dd' /></td>
      </tr>
    </table>
    </form>
    <div class="add_savebtn">
    	<a href="javascript:doSubmit()"><img src="images/save.gif" border="0"/></a>
    	<a href="javascript:history.back()"><img src="images/back00.gif" border="0" /></a>
    </div>
    
 </div>  <!--right_main-->
<brady:query paramName="queryCode"/>
</body>