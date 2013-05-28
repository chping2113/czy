<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/include/core.jsp"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理-添加${newsCatelog.title }信息</title>
<script charset="utf-8" src="editor/kindeditor-min.js"></script>
<script type="text/javascript">
	var pageNo = "${empty pageNo ? 0 : pageNo}";
	var validator_config = {
			task_title: {
				text: "在此输入标题",
				validators: {
					required: {
						failmsg:"标题不能为空!"
					}
				}
			},siteName: {
				text: "请选择组织机构",
				validators: {
					required: {
						failmsg:"组织机构不能为空!"
					}
				}
			}
	};
	function doSave() {
		if($.brady.validator.validateForm("addForm", validator_config)) {
			$("#addForm").submit();
		}
	}
	$(function(){
		
		KE.show({
                id: "news_content",
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
</script>

</head>

<body>
 
 
    <div class="add_news">
    <div class="add_top">信息发布&nbsp; &gt; 待办事项&nbsp; &gt; 发布修改待办事项信息</div>
    <form id="addForm" action="info/task_${id > 0 ? 'edit' : 'add' }.action" method="post">
	<input type="hidden" name="id" value="${empty id ? '0' : id }" />
	<input type="hidden" name="pageNo" value="${empty pageNo ? '1' : pageNo}" />
	
    <table cellpadding="0" cellspacing="0" class="table_add">
   
      
     <tr>
      <th width="13%">标题</th>
      <td><input type="text" name="title" id="task_title" value="${title }" class="input_text_large" maxlength="50"/></td>
     </tr>

    <tr>
      <th>组织机构</th>
       <td>
     
      	<input type="hidden" name="siteId" id="siteId" value="${site.id }"/>
      	<input type="text"  class="input_text" name="siteName" id="siteName" value="${site.name }" readonly="readonly"/>
      	<a href="javascript:doShowQueryWindow('system/site_searchOrganForQucik.action','doQueryOK','siteId','siteName','名称')">
    		<img src="images/query.png" border="0" />
    	</a>
    	<span id="fail_msg_span"></span>
	  </td>
      </tr>
      
      <tr>
      <th valign="top">内容</th>
      <td><textarea id="news_content" name="content" class="input_text_area_large">${content }</textarea></td>
      </tr>
    </table>
    </form>
 
    <div class="add_savebtn">
    	<a href="javascript:doSave()"><img src="images/save.gif" border="0"/></a>
    	<a href="info/task_query.action?pageNo=${pageNo}"><img src="images/back00.gif" border="0" /></a></div>
    </div>
    
<brady:query paramName="queryCode"/>
</body>
</html>
