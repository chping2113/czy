<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/include/core.jsp"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>发布项目编码信息</title>
<link href="css/bm_main.css" rel="stylesheet" />
<link href="css/styles.css" rel="stylesheet" />
<link href="css/humanity/jquery-ui.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="css/smallslider.css"/>

<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.6.min.js"></script>
<script type="text/javascript" src="js/jquery.ui.datepicker-zh-CN.js"></script>
<script type="text/javascript" src="js/jquery.brady-min.js"></script>
<script type="text/javascript" src="js/jquery.smallslider.js"></script>
<script type="text/javascript" src="js/index.js"></script>
<style type="text/css">
	.twopage_left_text ul li a {
		display:block;
		line-height: 30px;
		margin: 10px;
	}
</style>
	<script type="text/javascript">

	var validator_projectCoder = {
			siteCode: {
				text: "",
				validators: {
					required: {
						failmsg:"组织机构代码不能为空!"
					},
					maxBytes: {
						max:11,
						failmsg:"信息不能大于11个字节"
					},
					minLength: {
						min:8,
						failmsg:"信息不能小于8个字节"
					}
				}
			},xzqCode: {
				text: "",
				validators: {
					required: {
						failmsg:"行政区划代码不能为空!"
					},range: {
						min:6,
						max:6,
						failmsg:"行政区划代码必须是6位!"
					},digit: {
						failmsg:"行政区划代码为数字!"
					}
				}
			},
			projectName: {
				text: "",
				validators: {
					required: {
						failmsg:"项目名称不能为空!"
					}
				}
			}
		};

	jQuery(function(){
		$("#createTime").datepicker({
			changeYear:true,
			changeMonth: true,
			onSelect: function(dateText, inst) {
				$("#createTime").blur();
			}
		});
		$.brady.validator.validate("projectCoderAddForm", validator_projectCoder);
	});
		function doSubmit(approveState){
			var url = "projectCoder_checkProjectName.action";
			var param = {"projectName":$("#projectName").val(),"editId":$("#id").val()};
			$.post(url, param, function(date) {
				if(date=='err'){
					alert("该名称已经存在，请重新输入!");
					return false ;
				}else{
					$("#projectCoderAddForm").submit();
				}
			});
		}

	</script>
	</head>
	<body>

  
  <div class="content">

<div class="top">
   <div class="logo">
   		<img src="logo_images/340000000.jpg" />

   </div>
 </div>
  <div class="middle">
    
    
   <div class="open_news">
 <div class="open_news_top">
 <s:if test="type==1">
<span class="span_left">项目编码信息 >添加</span>
</s:if>
<s:else>
<span class="span_left">项目编码信息 >修改</span>
</s:else>
 <span class="span_more"></span></div>
 <div class="open_news_text">  
    
    
    
 <form action="projectCoder_add.action" id="projectCoderAddForm" method="post">
    <table cellpadding="0" cellspacing="0" class="tousu_table01">
    
    
     <input type="hidden" name="id" id="id" value="${id }" />
     
     <tr>
      <th width="20%">项目名称</th>
      <td>
      <input type="text" name="projectName" id="projectName" class="input_text" value="${projectName }" maxlength="40"/>
	  </td>
      </tr>
      <tr>
      <th>行政区划代码</th>
      <td>	
      <input type="text" name="xzqCode" id="xzqCode" class="input_text" value="${xzqCode }" maxlength="6"/>
	  	
	  </td>
      </tr>
      <tr>
      <th>组织机构代码</th>
      <td>	
      <input type="text" name="siteCode" id="siteCode" class="input_text" value="${siteCode }" maxlength="11"/>
	  	
	  </td>
      </tr>
    </table>
    </form>
    <div class="add_savebtn" align="center">
    	
    	<a href="javascript:doSubmit('0')"><img src="images/save.gif" border="0"/></a>
    	<a href="projectCoder_init.action?type=1"><img src="images/back00.gif" border="0" /></a>
    </div>
     
      </div>
<div class="open_news_btm"></div>
</div><!--open_text-->
 </div> <!--middle DIV-->

 <div class="bottom">
<p>
承　办：安徽省推进工程建设领域项目信息公开和诚信体系建设专项工作组办公室       技术支持：中国电信安徽分公司       备案号： 皖ICP备09014608号 
<br />
协　办：省经济和信息化委　省委宣传部　省检察院　省发展改革委　省监察厅　省财政厅　省住房城乡建设厅　省交通运输厅  省商务厅　省水利厅　省工商局　
        省法制办
        <br /><span>人民银行合肥中心支行　省招标局　省政务服务中心</span></p>
 


</div> <!--bottom DIV-->
</div><!--content DIV-->
  <brady:dialog title="信用档案查询" onClickOK="doSave()" width="650" height="340"/>
  <brady:confirm />
  
  
  
  
</body>

</html>