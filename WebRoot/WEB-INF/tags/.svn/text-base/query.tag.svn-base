<%@ tag body-content="empty"  pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<%@ attribute name="paramName" required="true" rtexprvalue="true"%>


  <!-- 快速查询对话框 -->
  <div id="dialog-query" title="搜索窗口" style="margin:0px; padding:0px; display:none; font:12px; "> 
       <div class="open-search">
	         <label id="label22">名称或编号：</label>
             <input class="search-text" id="searchBox" type="text" value=""/>
             <a href="javascript:doFastSearch()"><img src="images/query.png" border="0"/></a>
	   </div>
	   
	   <div class="search-list">
	      <div class="search-list-top">搜索结果:</div>
	      <div id="search-result" style="width:100%">
	      </div>
	   </div>
  </div>
  
  <script type="text/javascript">
    var __commonQuery_paramName = "${paramName}";
    var __commonQuery_query_onClickOK ;
    var __commonQuery_query_url ;

    function initOK(){
    	$("#dialog-query").dialog({
    		autoOpen: false,
    		modal: true,
    		resizable: false,
    		height:380,
    		width:604,
    		buttons: {
    			"确定":function() {
		    		if(__commonQuery_query_onClickOK != "") {
		    			eval(__commonQuery_query_onClickOK);
		    		}
    				$(this).dialog("close");
    			}
    		},
    		close: function(evt, ui) {
    			$("#employeeId").show();
    		}
    	});
    }
    
    function doShowQueryWindow(searchUrl,fun,id,name,labelName) {
    	if(labelName.length>0){
    		$("#label22").html(labelName);
    	}else{
    		$("#label22").html("名称或编号：");
    	}
    	$("#search-result").html("");
    	$("#searchBox").val("");
    	__commonQuery_query_url = searchUrl ;
    	__commonQuery_query_onClickOK = fun+"('"+id+"','"+name+"')";
    	initOK();
    	$("#dialog-query").dialog("open");
    	//$.post(searchUrl, {}, function(ret) {
		//	$("#search-result").html(ret);
		//});
    }
    
  	function doFastSearch() {
  		$("#search-result").html("搜索中...");
		var search = $("#searchBox").val();
		var param = {};
		param[__commonQuery_paramName] = search;
		$.post(__commonQuery_query_url, param, function(ret) {
			$("#search-result").html(ret);
		});
	}
  </script>