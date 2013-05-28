<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/include/core.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>安徽项目公开网-项目公开信息</title>
	<script type="text/javascript">
	</script>
</head>
<body>
   <div class="right_main">
    <div class="add_top">发布审批信息&nbsp;&gt;查看</div>
    <form action="project/projectAim_add.action" id="projectAimAddForm">
    
    <div>
    <div class="main_text"><label>项目信息概要</label></div>
    <table cellpadding="0" cellspacing="0" class="table_add" style="margin-top: 3px;margin-bottom: 10px; TABLE-LAYOUT:   fixed;" >
    
      
    
     <tr>
      <th width="20%">发布机构</th>
      <td>
	  	 	${projectAim.site.name }
	  </td>
      </tr>
      <tr>
      <th>项目编号</th>
      <td>
	  	${code }
	  </td>
      </tr>
     <tr>
      <th>项目名称</th>
      <td>
	  	${name }
	  </td>
      </tr>
      <tr>
      <th>建设单位</th>
      <td>
	  	${constructName }
	  </td>
      </tr>
      <tr>
      <th>发布时间</th>
      <td><s:date name="createTime" format="yyyy-MM-dd"/></td>
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
      <th>审核人员</th>
      <td>
      
      <s:if test="approveUser!=null">
         姓名:${approveUser.name }&nbsp;&nbsp;帐号:${approveUser.code }
      </s:if>
   <s:else>
   所有审核人员
   </s:else>
	  </td>
      </tr>
      <tr>
      <th width="25%">招标事项</th>
      <td>
      <pre>${projectAim.aimItem }</pre>
	  	
	  </td>
      </tr>
      <tr>
      <th>招标公告</th>
      <td > 
      <pre >
       ${projectAim.notice }
	  	</pre>
	  </td>
      </tr>
      <tr>
      <th>投标资格预审公告</th>
      <td>
       <pre>${projectAim.statusNotice }</pre>
	  	
	  </td>
      </tr>
      <tr>
      <th>中标结果</th>
      <td>
       <pre>${projectAim.bidResult }</pre>
	  	
	  	
	  </td>
      </tr>
    </table>
    </div>
    </form>
    <div class="add_savebtn">
    	<a href="javascript:history.back()"><img src="images/back00.gif" border="0" /></a>
    </div>
    
 </div>  <!--right_main-->

</body>