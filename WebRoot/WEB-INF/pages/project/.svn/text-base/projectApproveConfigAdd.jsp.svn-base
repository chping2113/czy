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
		$.brady.validator.validate("projectApproveAddForm", validator_projectApprove);
	});
		function doSubmit(approveState){
			$("#projectApproveAddForm").submit();
		}
	</script>
</head>
<body>
   <div class="right_main">
    <div class="add_top">
    
    发布项目审批信息&nbsp;&gt;
    <s:if test="type==1">添加</s:if>
    <s:elseif test="type==2">修改</s:elseif>
    <s:elseif test="type==3">审核</s:elseif>
    <s:elseif test="type==6">审核</s:elseif>
    <s:elseif test="type==7">发布</s:elseif>
    <s:else>
   	 添加
    </s:else>
    </div>
    
    <form action="project/projectApproveConfig_add.action" id="projectApproveAddForm" method="post">
    <table cellpadding="0" cellspacing="0" class="table_add">
    
    
    
    
     <tr>
      <th width="25%">项目规划审批结果信息</th>
      
      <td >
  	  
     <input type="hidden" name="planOrganId" id="planOrganId" value="${planOrganId }" />
      <input type="text"  class="input_text" name="planOrganName" id="planOrganName" value="${planOrganName }" readonly="readonly"/>
     <a href="javascript:doShowQueryWindow('system/site_searchOrganForOrgan.action','doQueryOK','planOrganId','planOrganName','名称')">
    		<img src="images/query.png" border="0" />
    	</a>
    	<span id="fail_msg_span"></span>
     
	  </td>
      </tr> 
    
	  <tr>
      <th width="25%">项目建议书批复结果信息</th>
      
      <td >
      	<input type="hidden" name="id" id="id" value="${projectApprove.id }"/>
      	<input type="hidden" name="type" id="type" value="${type }"/>

  	  
     <input type="hidden" name="proposeOrganId" id="proposeOrganId" value="${proposeOrganId }" />
      <input type="text"  class="input_text" name="proposeOrganName" id="proposeOrganName" value="${proposeOrganName }" readonly="readonly"/>
     <a href="javascript:doShowQueryWindow('system/site_searchOrganForOrgan.action','doQueryOK','proposeOrganId','proposeOrganName','名称')">
    		<img src="images/query.png" border="0" />
    	</a>
    	<span id="fail_msg_span"></span>
     
	  </td>
      </tr> 
     
      <tr>
      <th>可行性研究报告批复结果信息</th>
      <td  >
	  	
      
     <input type="hidden" name="feasibilityOrganId" id="feasibilityOrganId" value="${feasibilityOrganId }" />
      <input type="text"  class="input_text" name="feasibilityOrganName" id="feasibilityOrganName" value="${feasibilityOrganName }" readonly="readonly"/>
     <a href="javascript:doShowQueryWindow('system/site_searchOrganForOrgan.action','doQueryOK','feasibilityOrganId','feasibilityOrganName','名称')">
    		<img src="images/query.png" border="0" />
    	</a>
    	<span id="fail_msg_span"></span>
	  
	  </td>
      </tr>
     
      <tr>
      <th>项目核准结果信息</th>
      <td  >

     <input type="hidden" name="approveResultOrganId" id="approveResultOrganId" value="${approveResultOrganId }" />
      <input type="text"  class="input_text" name="approveResultOrganName" id="approveResultOrganName" value="${ approveResultOrganName}" readonly="readonly"/>
     <a href="javascript:doShowQueryWindow('system/site_searchOrganForOrgan.action','doQueryOK','approveResultOrganId','approveResultOrganName','名称')">
    		<img src="images/query.png" border="0" />
    	</a>
    	<span id="fail_msg_span"></span>
	  
	  </td>
      </tr>
      
      <tr>
      <th>初步设计方案批复结果信息</th>
      <td  >
	
     <input type="hidden" name="designOrganId" id="designOrganId" value="${designOrganId }" />
      <input type="text"  class="input_text" name="designOrganName" id="designOrganName" value="${designOrganName }" readonly="readonly"/>
     <a href="javascript:doShowQueryWindow('system/site_searchOrganForOrgan.action','doQueryOK','designOrganId','designOrganName','名称')">
    		<img src="images/query.png" border="0" />
    	</a>
    	<span id="fail_msg_span"></span>
	  	
	  	
	  </td>
      </tr>
      
      <tr>
      <th>节能评估审查批复结果信息</th>
      <td  >

     <input type="hidden" name="energyOrganId" id="energyOrganId" value="${energyOrganId }" />
      <input type="text"  class="input_text" name="energyOrganName" id="energyOrganName" value="${energyOrganName }" readonly="readonly"/>
     <a href="javascript:doShowQueryWindow('system/site_searchOrganForOrgan.action','doQueryOK','energyOrganId','energyOrganName','名称')">
    		<img src="images/query.png" border="0" />
    	</a>
    	<span id="fail_msg_span"></span>
	  	
	  	
	  </td>
      </tr>
      
      <tr>
      <th>规划选址意见批复结果信息</th>
      <td  >
	  
     <input type="hidden" name="addressOrganId" id="addressOrganId" value="${addressOrganId }" />
      <input type="text"  class="input_text" name="addressOrganName" id="addressOrganName" value="${addressOrganName }" readonly="readonly"/>
     <a href="javascript:doShowQueryWindow('system/site_searchOrganForOrgan.action','doQueryOK','addressOrganId','addressOrganName','名称')">
    		<img src="images/query.png" border="0" />
    	</a>
    	<span id="fail_msg_span"></span>
	  	
	  	
	  </td>
      </tr>
      <tr>
      <th>用地批复文件结果信息</th>
      <td  >
	  	
     <input type="hidden" name="landOrganId" id="landOrganId" value="${landOrganId }" />
      <input type="text"  class="input_text" name="landOrganName" id="landOrganName" value="${landOrganName }" readonly="readonly"/>
     <a href="javascript:doShowQueryWindow('system/site_searchOrganForOrgan.action','doQueryOK','landOrganId','landOrganName','名称')">
    		<img src="images/query.png" border="0" />
    	</a>
    	<span id="fail_msg_span"></span>
	  	
	  </td>
      </tr>
      <tr>
      <th>环境影响评价审批结果信息</th>
      <td  >
     <input type="hidden" name="environmentOrganId" id="environmentOrganId" value="${environmentOrganId }" />
      <input type="text"  class="input_text" name="environmentOrganName" id="environmentOrganName" value="${environmentOrganName }" readonly="readonly"/>
     <a href="javascript:doShowQueryWindow('system/site_searchOrganForOrgan.action','doQueryOK','environmentOrganId','environmentOrganName','名称')">
    		<img src="images/query.png" border="0" />
    	</a>
    	<span id="fail_msg_span"></span>
	  	
	  </td>
      </tr>
      <tr>
      <th>施工许可(开工报告)审批信息</th>
      <td  >
	  
     <input type="hidden" name="startReportsOrganId" id="startReportsOrganId" value="${startReportsOrganId }" />
      <input type="text"  class="input_text" name="startReportsOrganName" id="startReportsOrganName" value="${startReportsOrganName }" readonly="readonly"/>
     <a href="javascript:doShowQueryWindow('system/site_searchOrganForOrgan.action','doQueryOK','startReportsOrganId','startReportsOrganName','名称')">
    		<img src="images/query.png" border="0" />
    	</a>
    	<span id="fail_msg_span"></span>
	  	
	  </td>
      </tr>
    </table>
    </form>
    <div class="add_savebtn">
    	
    	<a href="javascript:doSubmit('0')"><img src="images/save.gif" border="0"/></a>
    	<a href="javascript:history.back()"><img src="images/back00.gif" border="0" /></a>
    </div>
    
 </div>  <!--right_main-->

<brady:ajaxQuery paramName="queryCode"/>
</body>