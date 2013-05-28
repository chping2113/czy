<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/include/core.jsp"%>
<script type="text/javascript">

var validator_config = {
		title: {
			text: "请输入单位名称！",
			msg_panel_id: "fail_msg_span",
			validators: {
				required: {
					failmsg:"单位名称不能为空!"
				}
			}
		},
		url: {
			text: "请输入连接地址！",
			msg_panel_id: "fail_msg_span",
			validators: {
				required: {
					failmsg:"连接地址不能为空!"
				}
			}
		}
};

$(function(){
	$.brady.validator.validate("addForm", validator_config); //初始化表单验证构架
});

function doSave() {
	if($.brady.validator.validateForm("addForm", validator_config)) {
		$("#addForm").get(0).submit();
	}
}
</script>

 <div class="right_main">
    <div class="add_top">
    
    政府机关账户&nbsp;&gt;
    <s:if test="id>0">修改</s:if>
    <s:else>
   	 添加
    </s:else>
    </div>
	<form id="addForm" action="system/alexa_add.action" method="post">
	<input type="hidden" id="id" name="id" value="${empty id ? '0' : id }" />
	
    <table cellpadding="0" cellspacing="0" class="table_add">
     <tr>
      <th width="40%">类型</th>
      <td>
	      <select id="type" name="type" style="width: 210px;" class="input_text_small">
      		<option value="省直单位" ${type=='省直单位'?'selected="selected"':'' }>省直单位</option>
      		<option value="市县政府" ${type=='市县政府'?'selected="selected"':'' }>市县政府</option>
      		<option value="高等院校" ${type=='高等院校'?'selected="selected"':'' }>高等院校</option>
      		<option value="各省(市、区)" ${type=='各省(市、区)'?'selected="selected"':'' }>各省(市、区)</option>
      		<option value="中央部委" ${type=='中央部委'?'selected="selected"':'' }>中央部委</option>
      		<option value="其他网站" ${type=='其他网站'?'selected="selected"':'' }>其他网站</option>
      	  </select>
      </td>
     </tr>
     <tr>
      <th>单位名称</th>
      <td>
	      <input type="text" id="title" name="title" class="input_text" value="${title }" maxlength="100"/>
      </td>
     </tr>
     <tr>
      <th>链接地址</th>
      <td>
	      <input type="text" id="url" name="url" class="input_text" value="${url }" maxlength="100"/>
      </td>
     </tr>
    </table>
    
    </form> 
    <div class="add_savebtn">
    	
    	<a href="javascript:doSave()"><img src="images/save.gif" border="0"/></a>
    	<a href="javascript:history.back()"><img src="images/back00.gif" border="0" /></a>
    </div>
    
<brady:query paramName="queryCode"/>
 </div>  <!--right_main-->