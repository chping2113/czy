<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/include/core.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>安徽项目公开网-项目公开信息</title>
	<script type="text/javascript">
	jQuery(function(){
		$("#releaseDate").datepicker({
			changeYear:true,
			changeMonth: true,
			onSelect: function(dateText, inst) {
				$("#releaseDate").blur();
			}
		});
		$.brady.validator.validate("projectApproveAddForm", validator_projectApprove);
	});
		function doSubmit(approveState){
			$("#approveState").val(approveState);
			$("#projectApproveAddForm").submit();
		}
	</script>
</head>
<body>
   <div class="right_main">
    <div class="add_top">
    
    项目审批信息&nbsp;&gt;发布
    </div>
    
    <form action="project/projectApprove_releaseSave.action" id="projectApproveAddForm" method="post">
    
    <div>
    <div class="main_text"><label>项目信息概要</label></div>
    <table cellpadding="0" cellspacing="0" class="table_add" style="margin-top: 3px;margin-bottom: 10px;">
    
    
     
      <tr>
      <th>项目编号</th>
      <td>	
      	<input type="hidden" name="id" id="id" value="${projectApprove.id }"/>
      	<input type="hidden" name="type" id="type" value="${type }"/>
      <input type="text" name="code" id="code" class="input_text" value="${code }" maxlength="40" readonly="readonly"/>
	  
	<input type="hidden" name="pageNo" value="${empty pageNo ? '1' : pageNo}" />	
	  </td>
      </tr>
     <tr>
      <th>项目名称</th>
      <td>
      <input type="text" name="name" id="name" class="input_text" value="${name }" maxlength="40" readonly="readonly"/>
	  </td>
      </tr>
      <tr>
      <th>建设单位</th>
      <td>
      <input type="text" name=constructName id="constructName" class="input_text" value="${constructName }" maxlength="40" readonly="readonly"/>
	  	
	  </td>
      </tr>
      
      <tr>
      <th width="20%">发布机构</th>
      <td>
	  	${session.loginUser.site.name }
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
      <input type="text" name="releaseDate" id="releaseDate" class="calendar input_text" value="<s:date name='releaseDate' format='yyyy-MM-dd' />" readonly="readonly"/>
      </td>
      </tr>
 
     <s:iterator value="projectApproveFlowList" var="pf">
     <s:if test='#pf.type.equals("plan")'>
      <tr>
      <th width="25%">项目规划审批结果信息</th>
      
      <td rowspan="2">
	  	<textarea name="plan" id="plan" class="input_text_area" style="width: 500px">${projectApprove.plan }</textarea>
	  </td>
      </tr>   
      <tr>
      </tr>
     </s:if> 
     <s:elseif test='#pf.type.equals("propose")'>
      <tr>
      <th width="25%">项目建议书批复结果信息</th>
      
      <td rowspan="2">
	  	<textarea name="propose" id="propose" class="input_text_area" style="width: 500px">${projectApprove.propose }</textarea>
	  </td>
      </tr>   
      <tr>
      </tr>
     </s:elseif>
     <s:elseif test='#pf.type.equals("feasibility")'> 
   
     <tr>
      <th>可行性研究报告批复结果信息</th>
      <td  rowspan="2">
	  	<textarea name="feasibility" id="feasibility" class="input_text_area" style="width: 500px">${projectApprove.feasibility }</textarea>
	  </td>
      </tr>
      <tr>
      </tr>
     </s:elseif>
     <s:elseif test='#pf.type.equals("design")'>
      <tr>
      <th>初步设计方案批复结果信息</th>
      <td  rowspan="2">
	  	<textarea name="design" id="design" class="input_text_area" style="width: 500px">${projectApprove.design }</textarea>
	  </td>
      </tr>
      <tr>
      </tr>
     </s:elseif>
     <s:elseif test='#pf.type.equals("energy")'>
      <tr>
      <th>节能评估审查批复结果信息</th>
      <td  rowspan="2">
	  	<textarea name="energy" id="energy" class="input_text_area" style="width: 500px">${projectApprove.energy }</textarea>
	  </td>
      </tr>
      <tr>
      </tr>
     </s:elseif>
     <s:elseif test='#pf.type.equals("address")'>
     <tr>
      <th>规划选址意见批复结果信息</th>
      <td  rowspan="2">
	  	<textarea name="address" id="address" class="input_text_area" style="width: 500px">${projectApprove.address }</textarea>
	  </td>
      </tr>
      <tr>
      </tr>
     </s:elseif>
     <s:elseif test='#pf.type.equals("land")'>
     <tr>
      <th>用地批复文件结果信息</th>
      <td  rowspan="2">
	  	<textarea name="land" id="land" class="input_text_area" style="width: 500px">${projectApprove.land }</textarea>
	  </td>
      </tr>
      <tr>
      </tr>
     </s:elseif>
     <s:elseif test='#pf.type.equals("environment")'>
      <tr>
      <th>环境影响评价审批结果信息</th>
      <td  rowspan="2">
	  	<textarea name="environment" id="environment" class="input_text_area" style="width: 500px">${projectApprove.environment }</textarea>
	  </td>
      </tr>
      <tr>
      </tr>
     </s:elseif>
     <s:elseif test='#pf.type.equals("approveResult")'>
      <tr>
      <th>项目核准结果信息</th>
      <td  rowspan="2">
	  	<textarea name="approveResult" id="approveResult" class="input_text_area" style="width: 500px">${projectApprove.approveResult }</textarea>
	  </td>
      </tr>
      <tr>
      </tr>
     </s:elseif>
     <s:elseif test='#pf.type.equals("startReports")'>
     <tr>
      <th>施工许可(开工报告)审批信息</th>
      <td  rowspan="2">
	  	<textarea name="startReports" id="startReports" class="input_text_area" style="width: 500px">${projectApprove.startReports }</textarea>
	  </td>
      </tr>
      <tr>
      </tr>
     </s:elseif>
     </s:iterator>
	 
    
    </table>
    </div>
    </form>
    <div class="add_savebtn">
    	
    	<a href="javascript:doSubmit('0')"><img src="images/fa.gif" border="0"/></a>
    	<a href="javascript:history.back()"><img src="images/back00.gif" border="0" /></a>
    </div>
    
 </div>  <!--right_main-->

<brady:query paramName="queryCode"/>
</body>