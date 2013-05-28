<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/include/core.jsp"%>
<%
	
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理-添加通知公告信息</title>
<script charset="utf-8" src="editor/kindeditor-min.js"></script>
<script type="text/javascript" src="js/info/notice.js"></script>
<script type="text/javascript">
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
</script>

</head>

<body>
<div class="add_news">
<div class="add_top">信息发布&nbsp; &gt; 通知公告 &nbsp; &gt; 发布修改公告信息</div>

	<form id="addForm" action="info/notice_${id > 0 ? 'edit' : 'add' }.action" method="post">
	<input type="hidden" name="id" value="${empty id ? '0' : id }" />
	<input type="hidden" name="pageNo" value="${empty pageNo ? '1' : pageNo}" />
	
    <table cellpadding="0" cellspacing="0" class="table_add">
     <tr>
      <th width="12%">公告标题</th>
      <td><input type="text" id="notice_title" name="title" value="${title }" class="input_text_large" maxlength="100"/></td>
     </tr>
      
     <tr>
      <th width="12%">浮动显示</th>
      <td>
      	<input type="radio" id="radNoFloatShow" name="floatShow" value="0" ${floatShow != 1 ? "checked" : "" }/>不浮动显示
      	<input type="radio" id="radFloatShow" name="floatShow" value="1" ${ floatShow == 1 ? "checked" : ""} />在首页上浮动显示
      </td>
     </tr>
     
     <tr id="floatDaysTR" style="${floatShow !=1 ? 'display:none;' : ''}">
      <th width="12%">浮动时间</th>
      <td>
      	<select id="floatDays" name="floatDays" class="input_text_small">
      		<c:forEach begin="1" end="30" var="day">
      		<option value="${day }" ${day == floatDays ? "selected" : "" }>${day } 天</option>
      		</c:forEach>
      	</select> 
      </td>
     </tr>
	 
	 <tr>
      <th valign="top" width="12%">公告内容</th>
      <td><textarea id="notice_content" name="content" class="input_text_area_large" >${content }</textarea></td>
     </tr>
    </table>
    </form> 
    
    <iframe frameborder=0   id=frmAtt2 name=frmAtt2 src="info/notice_initFile.action?id=${id }" style=" VISIBILITY: inherit; HEIGHT:200px;WIDTH:97%; Z-INDEX: 1"> </iframe>
    
    <div class="add_savebtn">
    	<a href="javascript:doSave()"><img src="images/save.gif" border="0"/></a>
    	<a href="info/notice_list.action?pageNo=${pageNo }"><img src="images/back00.gif" border="0" /></a></div>
    </div>
 
   
</body>
</html>
