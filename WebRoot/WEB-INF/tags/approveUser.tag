<%@ tag body-content="empty"  pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ attribute name="title" required="true" rtexprvalue="true"%>
<%@ attribute name="onClickOK" required="false" rtexprvalue="true"%>
<%@ attribute name="width" required="false" rtexprvalue="true"%>
<%@ attribute name="height" required="false" rtexprvalue="true"%>

  <!-- 快速查询对话框 -->
  <div id="dialog-common" title="${title }" style="margin:0px; padding:0px; display:none; font:12px; background:#FFFFFF"> 
	   <div id="dialog-content">
	   </div>
  </div>
  
  <script type="text/javascript">
    
    //封装变量避免命名空间污染
    var __common_dialog_var = {
    	onClickOK: "${onClickOK}",
    	width: ${empty width ? 650 : width},
    	height: ${empty height ? 300 : height}
    };
    
    jQuery(function() {
    	$("#dialog-common").dialog({
    		autoOpen: false,
    		modal: true,
    		resizable: false,
    		height:__common_dialog_var.height,
    		width:__common_dialog_var.width
    		
    	});
    });
    
    function showDialog(loadContentUrl, type,formName,lurl) {
        var url = loadContentUrl;
        if(url != "") {
	        $.post(url, function(ret) {
	            $("#dialog-content").html(ret);
	        });
        }
        
    	if(type == "btn_ok") {
    		$("#dialog-common").dialog("option", "buttons", {
    			"确定":function() {
    				
    				
    				
    	    		if(__common_dialog_var.onClickOK != "") {
    	    			eval(__common_dialog_var.onClickOK);
    	    		}
    				//$(this).dialog("close");
    			}
    		});
    	} else if(type == "btn_close") {
    		$("#dialog-common").dialog("option", "buttons", {
    			"关闭":function() {
    				$(this).dialog("close");
    			}
    		});
    	} else if(type == "btn_ok_close") {
    		$("#dialog-common").dialog("option", "buttons", {
    			"确定":function() {
    				var t=$(":radio[checked]").val();
    				$("#userId").val(t);
    				$(this).dialog("close");
					if(lurl==""){
						$(formName).submit();
					}else{
						//alert(lurl+"&uersId="+t);
						location.href = lurl+"&userId="+t;
					}
    				
    			},
    			"关闭":function() {
    				$(this).dialog("close");
    			}
    		});
    	} else if(type == "btn_ok_next_close") {
    		$("#dialog-common").dialog("option", "buttons", {
    			"确定":function() {
    				var t=$(":radio[checked]").val();
    				$("#userId").val(t);
    				$(this).dialog("close");
					if(lurl==""){
						$(formName).submit();
					}else{
						//alert(lurl+"&uersId="+t);
						location.href = lurl+"&userId="+t;
					}
    				
    			},
    			"确定并新增":function() {
    				var t=$(":radio[checked]").val();
    				$("#userId").val(t);
    				$(this).dialog("close");
    				$("#ctype").val(9);
					if(lurl==""){
						$(formName).submit();
					}else{
						//alert(lurl+"&uersId="+t);
						location.href = lurl+"&userId="+t;
					}
    				
    			},
    			"关闭":function() {
    				$(this).dialog("close");
    			}
    		});
    	}
        
    	$("#dialog-common").dialog("open");
    }
    
    function closeDialog() {
    	$("#dialog-common").dialog("close");
    }
  </script>