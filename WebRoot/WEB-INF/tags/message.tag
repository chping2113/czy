<%@ tag body-content="empty"  pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<%@ attribute name="title" required="false" rtexprvalue="true"%>
<%@ attribute name="onClickOK" required="false" rtexprvalue="true"%>
<%@ attribute name="width" required="false" rtexprvalue="true"%>
<%@ attribute name="height" required="false" rtexprvalue="true"%>


  <!-- 快速查询对话框 -->
  <div id="__dialog-message-div__" title="${empty title ? '系统信息提示' : title }" style="margin:0px; padding:0px; display:none; font:14px; background:#FFFFFF"> 
	   <div style="margin:20px 10px">
	   		<span class="ui-icon ui-icon-info" style="float:left; margin:0 7px 20px 0;"></span>
	   		<div id="__dialog-message-content__" style="margin:10px; text-aglin:left; font-size:14px;"></div>
	   </div>
  </div>
  
  <script type="text/javascript">
    
    //封装变量避免命名空间污染
    var __message_dialog_var = {
    	width: ${empty width ? 450 : width},
    	height: ${empty height ? 200 : height}
    };

    jQuery(function() {
    	$("#__dialog-message-div__").dialog({
    		autoOpen: false,
    		modal: true,
    		resizable: false,
    		height: __message_dialog_var.height,
    		width: __message_dialog_var.width,
    		buttons: {
    			"确定":function() {
		    		if(__message_dialog_var.onClickOK != "") {
		    			eval(__message_dialog_var.onClickOK);
		    		}
    				$(this).dialog("close");
    			}
    		}
    	});
    });
    
    function showMessage(message, onClickOK) {
    	if(onClickOK) {
    		__confirm_dialog_var.onClickOK = onClickOK;
    	}
    	$("#__dialog-message-content__").html(message);
    	$("#__dialog-message-div__").dialog("open");
    }
    
  </script>