<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/include/core.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>安徽中小企业信息</title>
	<script charset="utf-8" src="editor/kindeditor-min.js"></script>
	<script type="text/javascript" src="js/project/projectApprove.js"></script>
	<script type="text/javascript">
	
	jQuery(function(){
		$("#createTime").datepicker({
			changeYear:true,
			changeMonth: true,
			onSelect: function(dateText, inst) {
				$("#createTime").blur();
			}
		});
		$.brady.validator.validate("projectApproveAddForm", validator_projectApprove);
	});
		function doSubmit(approveState){	
			$("#approveState").val(approveState);
			var id="${approveUser.id}";
			var type="${type}";
			var state="${state}";
			if(approveState==3 && state!=3){
				if(id=="")
					id=0;
				var loadContentUrl = "project/projectLand_approveUser.action?userId="+id;
				showDialog(loadContentUrl, "btn_ok_close","#projectApproveAddForm","");
			}else{
				$("#projectApproveAddForm").submit();
			}
		}
		var pageNo = "${empty pageNo ? 0 : pageNo}";
	
	$(function(){
		$("#radFloatShow").click(function() {
			$("#floatDaysTR").show();
		});
		
		$("#radNoFloatShow").click(function() {
			$("#floatDaysTR").hide();
		});
		
		KE.show({
                id: "notice_content",
                width: "98%",
                height: "400px",
                allowFileManager:true,
                imageUploadJson : '../../../editor/jsp/upload_json.jsp',
    			fileManagerJson : '../../../editor/jsp/file_manager_json.jsp',
                items: [
						'source',  'fullscreen','|','fontname', 'fontsize', '|', 'textcolor', 'bgcolor', 'bold', 'italic', 'underline','|','removeformat',
						'-',  'justifyleft', 'justifycenter', 'justifyright','|', 'insertorderedlist', 'insertunorderedlist', '|', 'emoticons', 'image', 'link'
					]
        });
		
		$.brady.validator.validate("addForm", validator_config); //初始化表单验证构架
	});
	function upload(){   
			$("#uploadFile").submit();
		}
	</script>
</head>
<body>
   <div class="right_main">
    <div class="add_top">
    
发布审批信息&nbsp;&gt;
    <s:if test="type==1">添加</s:if>
    <s:elseif test="type==2">修改</s:elseif>
    <s:elseif test="type==3">审核</s:elseif>
    <s:elseif test="type==6">审核</s:elseif>
    <s:elseif test="type==7">发布</s:elseif>
    <s:else>
   	 添加
    </s:else>
    </div>
    <form action="project/projectApprove_add.action" id="projectApproveAddForm" method="post">
    <div>
    <div class="main_text"><label>中小企业信息概要</label></div>
    <table cellpadding="0" cellspacing="0" class="table_add" style="margin-top: 3px;margin-bottom: 10px;">
    
   <tr>
      
   
      <input type="hidden" name="userId" id="userId" value="${userId}"/>
      
	  	
	<input type="hidden" name="pageNo" value="${empty pageNo ? '1' : pageNo}" />
	 
      </tr>
     <tr>
      <th>项目名称</th>
      <td>
      <input type="text" name="name" id="name" class="input_text" value="${name}" maxlength="40"/>
	  </td>
      </tr>
      
       
    
    
	  <tr>
     
      	<input type="hidden" name="id" id="id" value="${projectApprove.id}"/>
      	<input type="hidden" name="type" id="type" value="${type}"/>
      	<input type="hidden" name="approveState" id="approveState" value="0"/>
	  	
	  	
    
      </tr> 
     
      

    
   
    
        
	<tr>
      <th>栏目</th>
      <td>
        <div class="search_text">
      <select name="scolumnName" id="selectScolmn">
       <option value="未选择" selected="selected">未选择</option> <!-- 默认选中 -->
      <s:iterator value="scolumnList" var="scolumnList" > 
            
       	    <option value="${scolumnList.name}">${scolumnList.name}</option>
       	    
	   </s:iterator>   
	   
      </select>
      </div> 
      </td>      
      </tr>
      
       <tr>
      <th width="25%">发布平台</th>
      <td>
      <s:if test="type==1">
	  	${session.loginUser.site.name }
	  	</s:if>
	  	<s:else>
	  	${site.name }
	  	
	  	</s:else>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	  
	  </td>
      </tr> 

      
      
      <tr>
      <th>发布时间</th>
      <td>
      <s:if test="state!=1">
      <input type="text" name="createTime" id="createTime" class="calendar input_text" value="<s:date name='createTime' format='yyyy-MM-dd' />" readonly="readonly"/>
     </s:if>
     <s:else>
      <input type="text" class="input_text"  value="<s:date name='createTime' format='yyyy-MM-dd' />" readonly="readonly"/>
     </s:else>
      </td>
      </tr>
    
       <tr>
      <th valign="top" width="12%">内容</th>
      <td><textarea id="notice_content" name="content" class="input_text_area_large" >${content }</textarea></td>
     </tr>
		 
    </table></div>
	<iframe frameborder=0   id=frmAtt2 name=frmAtt2 src="project/projectApprove_initFile.action?id=${id}" style=" VISIBILITY: inherit; HEIGHT:200px;WIDTH:97%; Z-INDEX: 1"> </iframe>
    <div class="add_savebtn">
    	
    	<s:if test="type==3 || type==6">
    	<s:if test="canAccessURL('project/approveProject_initApprove.action')">
    	<a href="javascript:doSubmit('1')"><img src="images/verifyPass.gif" border="0"/></a>
    	<a href="javascript:doSubmit('2')"><img src="images/verifyReject.gif" border="0"/></a>
    	</s:if>
    	</s:if>
    	<s:else>
    	<s:if test="type==2 ">
    	<a href="javascript:doSubmit('${state }')"><img src="images/save.gif" border="0"/></a>
    	<s:if test="state==0 || state==2">
    	<a href="javascript:doSubmit('3')"><img src="imgage/ok.jpg" border="0"/></a>
    	</s:if>
    	</s:if>
    	<s:if test="type==1">
    	<a href="javascript:doSubmit('0')"><img src="images/save.gif" border="0"/></a>
    	<a href="javascript:doSubmit('3')"><img src="imgage/ok.jpg" border="0"/></a>
    	</s:if>
    	</s:else>
    	


    	
    	<a href="javascript:history.back()"><img src="images/back00.gif" border="0" /></a>
    </div>
    
    </form>
 </div>  <!--right_main-->

 <brady:approveUser title="请选择审核人员" onClickOK="doApprove()" width="350" height="400"/>
<brady:ajaxQuery paramName="queryCode"/>
</body>