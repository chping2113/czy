<%@ tag body-content="empty"  pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<%@ attribute name="title" required="false" rtexprvalue="true"%>
<%@ attribute name="width" required="false" rtexprvalue="true"%>
<%@ attribute name="height" required="false" rtexprvalue="true"%>

  <!-- 快速查询对话框 -->
  <div id="__dialog-confirm-div__" title="${empty title ? '系统信息确认' : title }" style="margin:0px; padding:0px; display:none; font:14px; background:#FFFFFF"> 
	   <div style="margin:20px 10px">
	   		<span class="ui-icon ui-icon-alert" style="float:left; margin:0 7px 20px 0;"></span>
	   		<div id="__dialog-confirm-content__" style="margin:10px; text-aglin:left; font-size:14px;"></div>
	   </div>
  </div>
  
  <script type="text/javascript">
	//封装变量避免命名空间污染
	var __confirm_dialog_var = {
		width: ${empty width ? 450 : width},
		height: ${empty height ? 200 : height}
	};

    jQuery(function() {
    	$("#__dialog-confirm-div__").dialog({
    		autoOpen: false,
    		modal: true,
    		resizable: false,
    		height:__confirm_dialog_var.height,
    		width:__confirm_dialog_var.width,
    		buttons: {
    			"确定":function() {
    				$(this).dialog("close");
    				if(__confirm_dialog_var.onClickOK != "") {
		    			eval(__confirm_dialog_var.onClickOK);
		    		}
    			},
    			"取消":function() {
    				$(this).dialog("close");
    			}
    		}
    	});
    });
    
    function showConfirm(message, onClickOK) {
    	if(onClickOK) {
    		__confirm_dialog_var.onClickOK = onClickOK;
    	}
    	$("#__dialog-confirm-content__").html(message);
    	$("#__dialog-confirm-div__").dialog("open");
    }
    
  </script>