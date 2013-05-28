<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/include/core.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>安徽项目公开网-系统管理</title>
	<script type="text/javascript">
	var validator_navigate = {
			name: {
				text: "",
				msg_panel_id: "fail_msg_span",
				validators: {
					required: {
						failmsg:"专栏名称不能为空!"
					}
				}
			},
			url: {
				text: "",
				validators: {
					required: {
						failmsg:"链接URL不能为空!"
					}
				}
			},
			showOrder:{
				text: "",
				validators: {
					number: {
						failmsg:"顺序必须为数字!"
					}
				}
			}
		};

	jQuery(function(){
		$.brady.validator.validate("navigateAddForm", validator_navigate);
	});
		function doSubmit(){
			$("#navigateAddForm").submit();
		}
	</script>
</head>
<body>
   <div class="right_main">
    <div class="add_top">专栏快速导航&nbsp;&gt;<s:if test="id > 0">修改</s:if><s:else>添加</s:else></div>
    <form action="system/navigate_add.action" id="navigateAddForm" method="post">
    <table cellpadding="0" cellspacing="0" class="table_add">
	  <tr>
      <th width="25%">专栏名称</th>
      <td>
      	<input type="hidden" name="id" id="id" value="${id }"/>
      	<input type="hidden" name="parentId" id="parentId" value="${parentId }"/>
      	<input type="hidden" name="ptype" id="ptype" value="${ptype }"/>
      	<input type="hidden" name="siteId" id="siteId" value="${id }"/>
      	<input type="text"  class="input_text" name="name" id="name" value="${name }"  maxlength="200"/>
      	<s:if test="ptype==1">
      	<a href="javascript:doShowQueryWindow('system/site_searchOrganForQucik.action','doQueryOK','siteId','name','名称')">
    		<img src="images/query.png" border="0" />
    	</a></s:if>
    	<span id="fail_msg_span"></span>
	  </td>
      </tr>   
     <s:if test="ptype==1">
      <tr>
      <th>链接URL</th>
      <td>
	  	<input type="text" class="input_text" name="url" id="url" value="${url }"/>
	  </td>
      </tr></s:if>
      <tr>
      <th>顺序</th>
      <td>
	  <input type="text" class="input_text" name="showOrder" id="showOrder" value="${showOrder }"/>
	  </td>
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