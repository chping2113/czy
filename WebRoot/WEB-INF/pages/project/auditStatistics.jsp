<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/include/core.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>安徽项目公开网-项目公开信息</title>
	<script type="text/javascript">
		jQuery(function() {
			$("#createTime").datepicker({
				changeYear:true,
				changeMonth: true,
				onSelect: function(dateText, inst) {
					$("#createTime").blur();
				}
			});$("#constructBeginDate").datepicker({
				changeYear:true,
				changeMonth: true,
				onSelect: function(dateText, inst) {
					$("#constructBeginDate").blur();
				}
			});
			$("#constructEndDate").datepicker({
				changeYear:true,
				changeMonth: true,
				onSelect: function(dateText, inst) {
					$("#constructEndDate").blur();
				}
			});
			$("#changesInfo_changeDate").datepicker({
				changeYear:true,
				changeMonth: true,
				onSelect: function(dateText, inst) {
					$("#changesInfo_changeDate").blur();
				}
			});
			$("#acceptanceTime").datepicker({
				changeYear:true,
				changeMonth: true,
				onSelect: function(dateText, inst) {
					$("#acceptanceTime").blur();
				}
			});
			$("#payTime").datepicker({
				changeYear:true,
				changeMonth: true,
				onSelect: function(dateText, inst) {
					$("#payTime").blur();
				}
			});
			var type="${type}";
			if(type==3 || type==6){
				$.brady.validator.validate("projectConstructAddForm", validator_projectConstruct2);
			}else{
				$.brady.validator.validate("projectConstructAddForm", validator_projectConstruct);
			}
			
		});
		function doSubmit(approveState){	
			$("#approveState").val(approveState);
			var id="${approveUser.id}";
			var type="${type}";
			var state="${state}";
			var siteId=$("#siteId").val();
			
			if(siteId==""){
				alert("审核机构不能为空!");
				return;
			}
			if(approveState==3 && state!=3){
				if(id=="")
					id=0;
				var loadContentUrl = "project/projectLand_approveUser.action?userId="+id+"&siteId="+siteId;
				showDialog(loadContentUrl, "btn_ok_close","#projectConstructAddForm","");
			}else{
				$("#projectConstructAddForm").submit();
			}
		}
	</script>
	<style type="text/css">
		label {
			padding:8px 0px 8px 3px;
			/*font-weight:bolder;*/
		}
		.input_text_large2 { border:1px solid #cac098;
             width:500px;
			 padding:0px 5px;
			 height:22px;		 
}
	</style>
</head>
<body>
   <div class="right_main">
    <div class="add_top">
    <s:if test="type==3">项目信息公开&nbsp;&gt;&nbsp;发布审计统计结果信息&nbsp;&gt;审核</s:if>
    <s:elseif test="type==6">待办工作&nbsp;&gt;&nbsp;审计统计结果信息审批&nbsp;&gt;审核</s:elseif>
    <s:elseif test="type==2">审计统计结果信息录入&nbsp;&gt;修改</s:elseif>
    <s:else>审计统计结果信息录入&nbsp;&gt;添加</s:else>
   </div>
    <form action="project/projectConstruct_add.action" id="projectConstructAddForm" method="post">
         <div id="projectBaseDiv">
    <div class="main_text"><img src="images/left_go.gif"/><label>项目信息概要</label></div>
		<table cellpadding="0" cellspacing="0" class="table_add" style="margin-top: 3px;margin-bottom: 10px;">
				<input type="hidden" name="pageNo" value="${empty pageNo ? '1' : pageNo}" />		
   
      <s:if test="state==1 ">
       <tr>
      <td>项目编号</td>
      <td>	
      <input type="hidden" name="userId" id="userId" value="${userId}"/>
      <input type="text" name="code2" id="code2" class="input_text" value="${code }" maxlength="40" readonly="readonly"/>
	  	
	  </td>
      </tr>
     <tr>
      <td>项目名称</td>
      <td>
      <input type="text" name="name" id="name" class="input_text" value="${name }" maxlength="40"  readonly="readonly"/>
	  </td>
      </tr>
     <s:if test="session.loginUser==null">
     <tr>
      <td width="15%" align="left">建设单位</td>
      <td>${session.loginConstruct.name }
   
     
	  </td>
      </tr>  
   </s:if>
   <s:else>
    <tr>
      <td width="15%" align="left">建设单位</td>
      <td>
     
      <s:if test="construct.name != ''">
      
    <input type="text" name="constructName" id="constructName" class="input_text" value="${construct.name }" maxlength="100" />	
      </s:if>
      <s:else>
      
    <input type="text" name="constructName" id="constructName" class="input_text" value="${constructName }" maxlength="100" />
      </s:else>
	  </td>
      </tr>  
   
   </s:else> 
     <tr>
      <td width="15%">
      <s:if test="session.loginUser==null">审核机构
   
   </s:if>
   <s:else>
    发布机构
   
   </s:else></td>
      <td>
      	<input type="hidden" name="siteId" id="siteId" value="${site.id }"  />
      	<input type="text"  class="input_text" name="siteName" id="siteName" value="${site.name }" readonly="readonly"/>
      
    	<span id="fail_msg_span"></span>
	  </td>
      </tr>
      
      
     <s:if test="session.loginUser!=null"> 
       <tr>
      <td >发布人员</td>
      <td>
      <s:if test="type==1">
	  	
            姓名:${session.loginUser.name }&nbsp;&nbsp;帐号:${session.loginUser.code }
	  	</s:if>
	  	<s:else>
            姓名:${createUser.name }&nbsp;&nbsp;帐号:${createUser.code }
	  	
	  	
	  	</s:else>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	  
	  </td>
      </tr> 
      </s:if>
      
      <tr>
      <td>发布时间</td>
      <td>
      <input type="text"  class="input_text" value="<s:date name='createTime' format='yyyy-MM-dd' />" readonly="readonly"/>
      </td>
      </tr>
      </s:if>
      <s:else>
      <tr>
      <td>项目编号</td>
      <td>	
      <input type="text" name="code" id="code" class="input_text" value="${code }" maxlength="40"/>
	  	
	  </td>
      </tr>
     <tr>
      <td align="left">项目名称</td>
      <td>
      <input type="text" name="name" id="name" class="input_text" value="${name }" maxlength="40"/>
	  </td>
      </tr>
      <s:if test="session.loginUser==null">
     <tr>
      <td width="15%" align="left">建设单位</td>
      <td>${session.loginConstruct.name }
   
     
	  </td>
      </tr>  
   </s:if>
   <s:else>
    <tr>
      <td width="15%" align="left">建设单位</td>
      <td>
    
      <s:if test="construct.name != ''">
      
    <input type="text" name="constructName" id="constructName" class="input_text" value="${construct.name }" maxlength="100" />	
      </s:if>
      <s:else>
      
    <input type="text" name="constructName" id="constructName" class="input_text" value="${constructName }" maxlength="100" />
      </s:else>
	  </td>
      </tr>  
   
   </s:else>
     <tr>
      <td width="15%">
      <s:if test="session.loginUser==null">审核机构
   
   </s:if>
   <s:else>
    发布机构
   
   </s:else></td>
      <td>
     
   <s:if test="session.loginUser==null">
      	<input type="hidden" name="siteId" id="siteId" value="${site.id }"/>
      	<input type="text"  class="input_text" name="siteName" id="siteName" value="${site.name }" readonly="readonly"/>
      	<a href="javascript:doShowQueryWindow('system/site_searchOrganForQucik.action','doQueryOK','siteId','siteName','名称')">
    		<img src="images/query.png" border="0" />
    	</a>
    	<span id="fail_msg_span"></span>
    	</s:if>
    	<s:else>
    	
      	<input type="hidden" name="siteId" id="siteId" value="${session.loginUser.site.id}"/>
      	<input type="text"  class="input_text"  value="${session.loginUser.site.name }" readonly="readonly"/>
    	</s:else>
	  </td>
      </tr>
      
      
     <s:if test="session.loginUser!=null"> 
       <tr>
      <td >发布人员</td>
      <td>
      <s:if test="type==1">
	  	
            姓名:${session.loginUser.name }&nbsp;&nbsp;帐号:${session.loginUser.code }
	  	</s:if>
	  	<s:else>
            姓名:${createUser.name }&nbsp;&nbsp;帐号:${createUser.code }
	  	
	  	
	  	</s:else>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	  
	  </td>
      </tr> 
      </s:if>
      
      <tr>
      <td>发布时间</td>
      <td>
      <input type="text" name="createTime" id="createTime" class="calendar input_text" value="<s:date name='createTime' format='yyyy-MM-dd' />" readonly="readonly"/>
      </td>
      </tr>
      </s:else>
    
		</table>
	</div>

	<div id="auditStatisticsDiv">
	<div class="main_text"><img src="images/left_go.gif"/><label>审计统计结果信息</label></div>
		<table cellpadding="0" cellspacing="0" class="table_add" style="margin-top: 3px;margin-bottom: 10px;">
			<tr>
				<td width="15%">审计统计结果信息</td>
				<td width="85%">
					<textarea name="projectConstruct.auditStatistics.auditStatistics" class="input_text_area" style="width: 500px;height: 50px;">${projectConstruct.auditStatistics.auditStatistics }</textarea>
				
      	<input type="hidden" name="approveType" id="approveType" value="${subType}"/>
      		<input type="hidden" name="id" id="id" value="${projectConstruct.id }"/>
					<input type="hidden" name="projectId" id="projectId" value="${projectId }"/>
					<input type="hidden" name="approveState" id="approveState" value="0"/>
					<input type="hidden" name="type" id="type" value="${type }"/>
				</td>
			</tr>
		</table>
	</div>
	
    <div class="add_savebtn">
    	<s:if test="type==3 || type==6">
    	<s:if test="canAccessURL('project/constructProject_initConstruct.action')">
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
<brady:query paramName="queryCode"/>
</body>