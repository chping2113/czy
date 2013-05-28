<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/include/core.jsp"%>
<script type="text/javascript">
	function upload(){   
			$("#uploadFile").submit();
		}
	function uploadUser(){   
		$("#uploadFileUser").submit();
	}
</script>
    <div class="add_tree_text">
    <div class="add_top">组织机构&nbsp; &gt; 详细信息</div>
    <table cellpadding="0" cellspacing="0" class="table_add">
     <tr height="50">
      <th width="20%">机构代码</th>
      <td>${code }</td>
      </tr>
     <tr>
      <th>机构名称</th>
      <td>${name }</td>
      </tr>
     <tr>
      <th>上级机构</th>
      <td>${parent.name }</td>
      </tr>
     <tr>
      <th>联系人</th>
      <td>${linkman }</td>
      </tr>
     <tr>
       <th>联系电话</th>
       <td>${tel }</td>
     </tr>
     <!--  
     <tr>
       <th>举报电话</th>
       <td>${report }</td>
     </tr>-->
     <tr>
       <th>机构类型</th>
       <td>${type==0?'专栏':'平台'}</td>
     </tr>
     <tr>
       <th>有效状态</th>
       <td>${state==1?'无效':'有效'}</td>
     </tr>
     <s:if test="type == 1 and code != 340000000">
     <tr>
       <th>批量导入下级机构</th>
       <td>
       		<form id="uploadFile" action="system/siteUpload_upload.action" enctype="multipart/form-data" method="post">
       		<input type="file" size="8" name="attachFile" id="attachFile" onkeydown="return false"/>
       		<input type="hidden" name="parentCode" id="parentCode" value="${code }"/>
			<a href="javascript:upload()">导入</a>
			</form>
       </td>
     </tr>
     </s:if>
     <s:if test="code == 340000000">
     <tr>
       <th>批量导入用户账号</th>
       <td>
       		<form id="uploadFileUser" action="system/userUpload_upload.action" enctype="multipart/form-data" method="post">
       		<input type="file" size="8" name="attachFileUser" id="attachFileUser" onkeydown="return false"/>
			<a href="javascript:uploadUser()">导入</a>
			</form>
       </td>
     </tr>
     </s:if>
     <!-- 
     <tr>
       <th>页脚</th>
       <td>${footer }</td>
     </tr> -->
    </table>
     
    <div class="add_savebtn">
    	<s:if test="type == 1">
    	<a href="javascript:mod('add')">添加下级机构</a>
    	</s:if>
    	<a href="javascript:mod('edit')">修改</a>
    	<s:if test="#childNodesCount == 0">
    	<a href="javascript:del()">删除</a>
    	</s:if>
    </div>
    
    </div>