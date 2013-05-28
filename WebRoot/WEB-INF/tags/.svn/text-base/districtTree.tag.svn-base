<%@ tag body-content="empty"  pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ attribute name="title" required="true" rtexprvalue="true"%>
<%@ attribute name="onClickOK" required="false" rtexprvalue="true"%>
<%@ attribute name="width" required="false" rtexprvalue="true"%>
<%@ attribute name="height" required="false" rtexprvalue="true"%>

  <!-- 快速查询对话框 -->
  <div id="dialog-district" title="${title }" style="margin:0px; padding:0px; display:none; font:12px; background:#FFFFFF"> 
	   <div id="dialog-content">
	   </div>
  </div>
  
  <script type="text/javascript">
    var zTreeDistrct;
    var zTreeDistrctNodes;
    
    //封装变量避免命名空间污染
    var __district_dialog_var = {
    	onClickOK: "${onClickOK}",
    	width: ${empty width ? 650 : width},
    	height: ${empty height ? 300 : height}
    };
    
    var zTreeDistrctSetting = {
    		expandSpeed: "",
    		checkable: false,
    		showLine: true,
    		callback:{
    			click:zTreeDistrictOnClick
    		}
    	};
    
    jQuery(function() {
    	$("#dialog-district").dialog({
    		autoOpen: false,
    		modal: true,
    		resizable: false,
    		height:__district_dialog_var.height,
    		width:__district_dialog_var.width,
    		buttons: {
    			"确定":function() {
       	    		if(__district_dialog_var.onClickOK != "") {
       	    			eval(__district_dialog_var.onClickOK);
       	    		}
       				//$(this).dialog("close");
       			}
    		}
    		
    	});
    });
    
    function showDistrictDialog(loadContentUrl) {
        var url = loadContentUrl;
        if(url != "") {
	        $.post(url, function(ret) {
	        	zTreeDistrctNodes = ret;
	        	zTreeDistrct = $("#dialog-content").zTree(zTreeDistrctSetting, zTreeDistrctNodes);
	        });
        }
        
    	$("#dialog-district").dialog("open");
    }
    
    function closeDistrictDialog() {
    	$("#dialog-district").dialog("close");
    }
    
    function zTreeDistrictOnClick(event, treeId, treeNode) {
		alert( "id=" + treeNode.id + "; name=" + treeNode.name);
		
    }
  </script>