<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/include/core.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>安徽中小企业服务平台-项目基本信息</title>
	<script type="text/javascript">
		jQuery(function(){
			//$.brady.validator.validate("projectApproveForm", validator_projectApprove);
		});
		function doSubmit(){
			var url = "project/project_validateCode.action";
			var param = {"coder":$("#code").val()};
			$.post(url, param, function(date) {
				if(date=='true'){
					alert("项目编号已经存在，请刷新或输入其它编号！");
					return false ;
				}else{
					$("#projectApproveForm").submit();
				}
			});
		}
		$(function() {
			$('#code').bind('keyup mouseout', function() {
			  var prefix = $("#prefix").val().substring(0,21);
				var iVal = $(this).val();
				if(iVal.length < 21 || iVal.substring(0,21) != prefix) {
					$(this).val($("#prefix").val());
				}
			});
			
		});
	</script>
</head>
<body>
   <div class="right_main">
    <div class="add_top">发布项目基本信息&nbsp; &gt; 审批</div>
    <form action="project/project_approve.action" id="projectApproveForm" method="post">
    <table cellpadding="0" cellspacing="0" class="table_add">
      <tr>
      <th>发布标题</th>
      <td>
      	<input type="text" name="code" id="code"/></td>
      </tr>
      <tr>
      <th>栏目</th>
      <td>
	  	<select>
								<option value="langmu" selected="selected"> 
									 请选择栏目
								</option>
								<option value="volvo">
									政策法规
								</option>
								<option value="saab">
									融资担保
								</option>
								<option value="opel">
									通知公告
								</option>
								<option value="audi">
									技术支持
								</option>
							</select>
	  </td>
      </tr>
     <tr>
      <th>平台</th>
      <td>
							<select>
							<option value="pingtai" selected="selected">
									 请选择平台
								</option>
								<option value="volvo">
									安徽省中小企业服务平台
								</option>
								<option value="saab">
									合肥市中小企业服务平台
								</option>
								<option value="opel">
									长丰县中小企业服务平台
								</option>
								<option value="audi">
									肥西县桃花镇
								</option>
							</select>

						</td>
      </tr>
      <tr rowspan="2">
       <th>发布内容</th>
       <td>
	  	<textarea name="content" id="address" class="input_text_area" style="width: 500px">${projectApprove.address }</textarea>
	  </td>
      </tr>
      <tr>
		      <th width="12%">上传附件</th>
		      <td>
			      <input type="file" class="input_text_large" name="attachFile" id="attachFile" onkeydown="return false"/>
			      <a href="javascript:upload()">上传</a>
			      <s:if test="#error==1"><font color="red">&nbsp;&nbsp;提示：文件过大！</font></s:if>
			      <s:elseif test="#error==2"><font color="red">&nbsp;&nbsp;提示：文件内容为空！</font></s:elseif>
			      <s:else>&nbsp;&nbsp;&nbsp;&nbsp;提示：文件不能超过8M</s:else>
		      </td>
		     </tr>
    </table>
    </form>
    <div class="add_savebtn">
    	<a href="javascript:doSubmit()"><img src="images/save.gif" border="0"/></a>
    	<a href="javascript:history.back()"><img src="images/back00.gif" border="0" /></a>
    </div>
    
 </div>  <!--right_main-->
<brady:query paramName="queryCode"/>
</body>