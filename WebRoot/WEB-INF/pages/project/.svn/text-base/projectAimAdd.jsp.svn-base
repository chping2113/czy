<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/include/core.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>安徽项目公开网-项目公开信息</title>
	<script type="text/javascript">
	jQuery(function(){
		$("#createTime").datepicker({
			changeYear:true,
			changeMonth: true,
			onSelect: function(dateText, inst) {
				$("#createTime").blur();
			}
		});
		$.brady.validator.validate("projectAimAddForm", validator_projectApprove);
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
				showDialog(loadContentUrl, "btn_ok_close","#projectAimAddForm","");
			}else{
				$("#projectAimAddForm").submit();
			}
		}
	</script>
</head>
<body>
   <div class="right_main">
    <div class="add_top">
    
    发布招标投标信息&nbsp;&gt;
    <s:if test="type==1">添加</s:if>
    <s:elseif test="type==2">修改</s:elseif>
    <s:elseif test="type==3">审核</s:elseif>
    <s:else>
   	 添加
    </s:else>
    </div>
    
    <form action="project/projectAim_add.action" id="projectAimAddForm" method="post">
    
    <div>
    <div class="main_text"><label>项目信息概要</label></div>
    <table cellpadding="0" cellspacing="0" class="table_add" style="margin-top: 3px;margin-bottom: 10px;">
    
    
     
      <tr>
      <th>项目编号</th>
      <td>	
      <input type="hidden" name="userId" id="userId" value="${userId}"/>
      <input type="text" name="code" id="code" class="input_text" value="${code }" maxlength="40"/>
	  	
	<input type="hidden" name="pageNo" value="${empty pageNo ? '1' : pageNo}" />
	  </td>
      </tr>
     <tr>
      <th>项目名称</th>
      <td>
      <input type="text" name="name" id="name" class="input_text" value="${name }" maxlength="40"/>
	  </td>
      </tr>
      <tr>
      <th>建设单位</th>
      <td>
      <input type="text" name=constructName id="constructName" class="input_text" value="${constructName }" maxlength="40"/>
	  	
	  </td>
      </tr>
      <tr>
      <th width="20%">发布机构</th>
      <td>
      <s:if test="type==1">
	  	${session.loginUser.site.name }
	  	</s:if>
	  	<s:else>
	  	${site.name }
	  	
	  	</s:else>
	  </td>
      </tr>
      
       <tr>
      <th width="25%">发布人员</th>
      <td>
      <s:if test="type==1">
	  	
            姓名:${session.loginUser.name }&nbsp;&nbsp;帐号:${session.loginUser.code }
	  	</s:if>
	  	<s:else>
            姓名:${createUser.name }&nbsp;&nbsp;帐号:${createUser.code }
	  	
	  	
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
      <th width="25%">招标事项</th>
      <td>
      	<input type="hidden" name="id" id="id" value="${projectAim.id }"/>
      	<input type="hidden" name="type" id="type" value="${type }"/>
      	<input type="hidden" name="approveState" id="approveState" value="0"/>
	  	<textarea name="aimItem" id="aimItem" class="input_text_area" style="width: 500px">${projectAim.aimItem }</textarea>
	  </td>
      </tr>
      <tr>
      <th>招标公告</th>
      <td>
	  	<textarea name="notice" id="notice" class="input_text_area" style="width: 500px">${projectAim.notice }</textarea>
	  </td>
      </tr>
      <tr>
      <th>投标资格预审公告</th>
      <td>
	  	<textarea name="statusNotice" id="statusNotice" class="input_text_area" style="width: 500px">${projectAim.statusNotice }</textarea>
	  </td>
      </tr>
      <tr>
      <th>中标结果</th>
      <td>
	  	<textarea name="bidResult" id="bidResult" class="input_text_area" style="width: 500px">${projectAim.bidResult }</textarea>
	  </td>
      </tr>
    </table>
    </div>
    <div class="add_savebtn">
    	
    	<s:if test="type==3">
    	<s:if test="canAccessURL('project/aimProject_initAim.action')">
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
</body>