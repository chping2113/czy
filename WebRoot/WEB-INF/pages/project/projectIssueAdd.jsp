<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/include/core.jsp"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理-添加重点项目信息</title>
<script type="text/javascript" src="js/projectFocus.js"></script>

<script type="text/javascript">
	jQuery(function() {

		$.brady.validator.validate("editForm", validator_projectIssue);
		if(actionType == "ok") {
			alert("重点项目表保存成功！");
		}
	});
	function doSubmit1(){
			$("#addForm").submit();
	}

	function doSubmit2(){
		var name=$('#projectName').val();
		if(name==""){
			$("#editForm").submit();
			return ;
		}
			$.post(  
		 		'project/projectIssue_checkMaxRecord.action',  
				{  
		 			keyid:$('#keyProjectKindId').val(),
		 			projectIds:$('#projectId').val()
				},  
			  	function (data) //回传函数  
			  	{  
			        //alert(data);
			        if(data == "ok"){
			        	$("#editForm").submit();
			        }else if(data == "has"){
			        	showMessage("此条项目记录已经发布!");
			        }else{
			        	showMessage("此重点项目类型已关联十条项目记录!");
			        }
				}  
			); 
	}
	
	
	
</script>
<script type="text/javascript">
	var actionType = "${actionType}";
</script>
</head>

<body>
<div class="add_news">
    <div class="add_top">发布重点项目&nbsp; &gt; 添加</div>
	
	<form id="editForm" action="project/projectIssue_add.action" method="post">
    <table cellpadding="0" cellspacing="0" class="table_add">
     <tr>
      <th width="40%">重点项目类型</th>
      <td>
      	<input type="hidden" id="keyProjectKindId" name="keyProjectKind.id" value="${keyProjectKind.id }"/>
      	${keyProjectKind.name }
	  </td>
     </tr>
     
     <tr>
      <th width="40%">项目名称</th>
      <td>
        <!--input type="text" id="projectName" name="project.name" value="${keyname }" class="zhuce_list_input"/>
        <a href="javascript:doSubmit1()" title="查询"><img src="images/search.png" style="vertical-align:bottom;"></a-->
        
        <input type="text" id="projectName" name="projectApprove.name" value="" class="input_text" readonly="readonly"/>
    	<a href="javascript:doShowQueryWindow('project/projectIssue_quickQuery.action','doQueryOK','projectId','projectName','项目编号或名称')" title="查询">
    		<img src="images/query.png" border="0" />
    	</a>
    	<input type="hidden" id="projectId" name="projectIds" value=""/>
    	<span id="fail_msg_span" />
      </td>
     </tr>
    </table>
    
    <div class="add_savebtn">
    	<a href="javascript:doSubmit2()"><img src="images/save.gif" border="0"/></a>
    	<a href="javascript:history.back()"><img src="images/back00.gif" border="0" /></a>
    </div>
    </form>
   
</div>
<brady:query paramName="queryCode"/>
<brady:message />  
</body>
</html>
