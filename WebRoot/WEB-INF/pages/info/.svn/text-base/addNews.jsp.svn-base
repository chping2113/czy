<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/include/core.jsp"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理-添加${newsCatelog.title }信息</title>
<script charset="utf-8" src="editor/kindeditor-min.js"></script>
<script type="text/javascript" src="js/info/news.js"></script>
<script type="text/javascript">
	var pageNo = "${empty pageNo ? 0 : pageNo}";
	
	$(function(){
		$("#radShow").click(function() {
			$("#imageFileNameTR").show();
		});
		
		$("#radNoShow").click(function() {
			$("#imageFileNameTR").hide();
		});
		
		$("#imageFileName").blur(function() {
			checkFileName();
		});
		
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
    <div class="add_top">信息发布&nbsp; &gt; ${newsCatelog.title }&nbsp; &gt; 发布修改${newsCatelog.title }信息</div>
    <form id="addForm" action="info/news_${id > 0 ? 'edit' : 'add' }.action" method="post">
	<input type="hidden" name="id" value="${empty id ? '0' : id }" />
	<input type="hidden" name="pageNo" value="${empty pageNo ? '1' : pageNo}" />
	<input type="hidden" name="catelogId" value="${empty catelogId ? '0' : catelogId }" />
	
    <table cellpadding="0" cellspacing="0" class="table_add">
    <tr>
      <th width="13%">所在栏目</th>
      <td>${newsCatelog.title } 
      	<s:if test="#secondCatelogList.size > 0">
      	 &nbsp;-&gt;&nbsp;<select name="secondCatelogId" class="input_text">
      		<s:iterator value="#secondCatelogList" var="sc">
      		<option value="${sc.id }" ${sc.id == catelog.id ? "selected" : "" }>${sc.title }</option>
      		</s:iterator>
        </select>
        </s:if>
        <s:else>
        	<input type="hidden" name="secondCatelogId" value="${newsCatelog.id }" />
        </s:else>
      </td>
      </tr>
      
     <tr>
      <th width="13%">标题</th>
      <td><input type="text" name="title" id="news_title" value="${title }" class="input_text_large" maxlength="50"/></td>
     </tr>

     <tr>
      <th width="13%">来源</th>
      <td><input type="text" name="orgFrom" id="orgFrom" value="${orgFrom }" class="input_text_large" maxlength="50"/></td>
     </tr>
     <s:if test="#newsCatelog.id == 18"> <!-- 只有工作动态才有图标标题新闻 -->
     <tr>
      <th>图片标题</th>
      <td>      	
      	<input type="radio" id="radNoShow" name="imageNews" value="0" ${imageNews != 1 ? "checked" : "" }/>否
      	<input type="radio" id="radShow" name="imageNews" value="1" ${ imageNews == 1 ? "checked" : ""} />是
      </td>
     </tr>
     
     <tr id="imageFileNameTR" style="${imageNews==1 ? '' : 'display:none;'}">
      <th width="15%">标题图片文件名</th>
      <td>
      	 <input type="text" name=imageFileName id="imageFileName" value="${imageFileName }" class="input_text_big" maxlength="25"/>
      	 <span id="msg_filename_panel" class="validator_fail_tips" style="display:none;"></span>
      	 <div style="color:#790000; font-size:12px;">提示：为了保证在首页上显示的新闻标题图片不变形，建议标题图片的分辨率设为:268x197像素。</div>
      </td>
     </tr> 
     </s:if>
      
      <tr>
      <th valign="top">内容</th>
      <td><textarea id="news_content" name="content" class="input_text_area_large" >${content }</textarea></td>
      </tr>
    </table>
    </form>
      <iframe frameborder=0  id=frmAtt2 name=frmAtt2 src='info/news_initFile.action?id=${id }' style=" VISIBILITY: inherit; HEIGHT:200px;WIDTH:97%; Z-INDEX: 1"> </iframe>
   
    <div class="add_savebtn">
    	<a href="javascript:doSave()"><img src="images/save.gif" border="0"/></a>
    	<a href="info/news_list.action?catelogId=${catelogId }&pageNo=${pageNo}"><img src="images/back00.gif" border="0" /></a></div>
    </div>
</body>
</html>
