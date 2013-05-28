<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/include/core.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>安徽项目公开网-项目基本信息</title>
	<script type="text/javascript">
		jQuery(function(){
			$("#createTime").datepicker({
				changeYear:true,
				changeMonth: true,
				onSelect: function(dateText, inst) {
					$("#createTime").blur();
				}
			});
			$.brady.validator.validate("projectAddForm", validator_project);
		});
		function doSubmit(){
			$("#projectAddForm").submit();
		}
	</script>
</head>
<body>
   <div class="right_main">
    <div class="add_top">发布项目基本信息&nbsp; &gt; <s:if test="id > 0">修改</s:if><s:else>添加</s:else></div>
    <form action="project/project_add.action" id="projectAddForm" method="post">
    <table cellpadding="0" cellspacing="0" class="table_add">
	  <tr>
      <th>发布机构</th>
      <td>
	  	${loginUser.site.name }
	  </td>
      </tr>
     <tr>
      <th>项目编码</th>
      <td>
	  	<input type="text" name="code" id="code" class="input_text" value="${code }" maxlength="40"/>
	  </td>
      </tr>
     <tr>
      <th>项目名称</th>
      <td>
      	<input type="hidden" name="id" id="id" value="${id }"/>
	  	<input type="text" name="name" id="name" class="input_text" value="${name }" maxlength="50"/>
	  </td>
      </tr>
     <tr>
      <th>建设单位</th>
      <td>
	  	<input type="text" name="constructName" id="constructName" class="input_text" value="${constructName }" maxlength="50"/>
	  </td>
      </tr>
      <!--  
      <tr>
      <th>建设单位</th>
      <td>
	  	<input type="text" id="companyName" name="companyName" value="${company.name }" class="input_text" readonly="readonly"/>
    	<a href="javascript:doShowQueryWindow('system/company_searchCompanyForQucik.action','doQueryOK','companyId','companyName','名称或联系人')">
    		<img src="images/query.png" border="0" />
    	</a>
    	<span id="fail_msg_span"></span>
    	<input type="hidden" id="companyId" name="companyId" value="${company.id }"/>
	  </td>
      </tr>
     <tr>
      <th>项目名称</th>
      <td>
      	<input type="hidden" name="id" id="id" value="${id }"/>
	  	<input type="text" name="name" id="name" class="input_text" value="${name }" maxlength="30"/>
	  </td>
      </tr>
     <tr>
      <th>项目金额</th>
      <td><input type="text" name="money" id="money" class="input_text" value="${money }"/></td>
      </tr>
     <tr>
      <th>项目归属地</th>
      <td>
      	<input type="text" id="districtName" name="districtName" value="${district.name }" class="input_text" readonly="readonly"/>
    	<a href="javascript:doShowQueryWindow('system/district_searchDistrictForQucik.action','doQueryOK','districtCode','districtName','代码或名称')">
    		<img src="images/query.png" border="0" />
    	</a>
    	<span id="fail_msg_span2"></span>
    	<input type="hidden" id="districtCode" name="districtCode" value="${district.code }"/>
      <!-- input type="text" name="districtCode" id="districtCode" class="input_text" value="${districtCode }" maxlength="30"/ -->
      <!--  </td>
      </tr>
	  <tr>
      <th>项目业主</th>
      <td><input type="text" name="owner" id="owner" class="input_text" value="${owner }" maxlength="30"/></td>
      </tr>
      -->
      <tr>
      <th>发布时间</th>
      <td><input type="text" name="createTime" id="createTime" class="calendar input_text" value="<s:date name='createTime' format='yyyy-MM-dd' />" readonly="readonly"/></td>
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