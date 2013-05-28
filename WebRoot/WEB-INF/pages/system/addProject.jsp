<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/include/core.jsp"%>

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
		$.brady.validator.validate("addForm", validator_navigate);
	});
		function doSubmit(){
			$("#addForm").submit();
		}

</script>

<div class="add_text">
	<form id="addForm" action="system/homePage_addInit.action" method="post">
	<input type="hidden" name="resourceId" value="${empty resource ? '0' : resource.id }" />
	<input type="hidden" name="roleId" value="${empty roleId ? '0' : roleId }" />
	<input type="hidden" name="parentResourceId" value="${empty parentResourceId ? '0' : parentResourceId }" />
	
	<input type="hidden" name="pid" value="${resource.id}"/>
	
    <table cellpadding="0" cellspacing="0" class="table_add">
     <tr >
      <th width="12%">上级资源</th>
      <td>
        <s:if test="actionType == 'addFirstRes'">
      	一级资源
      	</s:if>
      	<s:elseif test="actionType == 'addChildRes'">
      	${parentResource.title }
      	</s:elseif>
      	<s:elseif test="actionType == 'editRes'">
      	${resource.parent == null ? '一级资源' : resource.parent.title }
      	</s:elseif>
      </td>
     </tr>
     
     <tr >
      <th width="12%">资源名称</th>
      <td>
      	<input type="text" id="title" name="title" value="${resource.title }" class="input_text_big" maxlength="25"/>
      </td>
     </tr>
      
     <tr >
      <th width="12%">访问URL</th>
      <td>
      	<input type="text" id="url" name="url" value="${resource.url }" class="input_text_big" maxlength="400"/>
      </td>
     </tr>
     
	 <tr >
      <th width="12%">显示顺序</th>
      <td>
      	<input type="text" id="position" name="position" value="${resource.position }" class="input_text_small" maxlength="250"/>
      </td>
     </tr>
     
    </table>
    </form> 
    
      <div class="add_savebtn">
    	<a href="javascript:doSubmit()"><img src="images/save.gif" border="0"/></a>
    	<a href="javascript:history.back()"><img src="images/back00.gif" border="0" /></a>
    </div>
</div>
