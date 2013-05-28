<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/include/core.jsp"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>新建平台</title>
<script charset="utf-8" src="editor/kindeditor-min.js"></script>
<script type="text/javascript" src="js/info/site.js"></script>

<script type="text/javascript">
	var pageNo = "${empty pageNo ? 0 : pageNo}";
	$(function(){
		KE.show({
                id: "site_content",
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
    <div class="add_top">当前位置:首页 > 平台管理 >
    <c:if test="${id!=null}">编辑平台</c:if>
    <c:if test="${id == null}">新建平台</c:if> 
    </div>
    <form id="addForm" action="system/site_${id > 0 ? 'edit' : 'add'}.action" method="post">
	<input type="hidden" name="id" value="${empty id ? '0' : id }" />
	<input type="hidden" name="pageNo" value="${empty pageNo ? '1' : pageNo}" />
	
    <table cellpadding="0" cellspacing="0" class="table_add">
    <tr>
      <th width="13%">平台名称</th>
      <td>
      	<c:if test="${id!=null}">${name}</c:if>

       	<c:if test="${id == null}">
      
      	<select name="name" id="name">
      		<option value="">请选择一个平台</option>
      		<s:iterator value="#session.siteList" var="site">
      			<option value="${name}" >${site.name}</option>
      		</s:iterator>
      	</select>
      </c:if>
      </td>
      </tr>
      
      <tr>
      <th width="13%">平台级别</th>
      <td>
      <select name="grade" id="grade" value="${grade}" >
      		<option value="">请选择一个级别</option>
      		<option value="省" ${model.grade == "省" ? "selected" : "" }>省</option>
      		<option value="市" ${model.grade == "市" ? "selected" : "" }>市</option>
      		<option value="县" ${model.grade == "县" ? "selected" : "" }>县</option>
      		<option value="镇" ${model.grade == "镇" ? "selected" : "" }>镇</option>
      	</select>
      
      </td>
     </tr>
     
      <tr>
      <th>有效</th>
      <td>      	
      	 <input type="radio" id="stateT" name="state" value="1" ${state==1 ? "checked" : ""} />有效
      	 <input type="radio" id="stateF" name="state" value="0" ${state!=1 ? "checked" : "" }/>无效
      </td>
     </tr
 
      <tr>
      <th valign="top">详细内容</th>
      <td >
      	<textarea id="site_content" name="content" value="${content }" class="input_text_area_large" >${content }</textarea>
      	
      </td>
      </tr>
      
    </table>
    </form>
   
    <div class="add_savebtn">
    	<a href="javascript:doSave()"><img src="images/save.gif" border="0"/></a>
    	<a href="system/site_list.action?pageNo=${pageNo}"><img src="images/back00.gif" border="0" /></a></div>
    </div>
</body>
</html>
