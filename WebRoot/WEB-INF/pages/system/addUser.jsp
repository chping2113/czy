<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/include/core.jsp"%>
	<script type="text/javascript" src="js/system/user.js"></script>
<script type="text/javascript">

$(function(){
	$.brady.validator.validate("addForm", validator_config); //初始化表单验证构架
});

</script>

 <div class="right_main">
    <div class="add_top">
    
    政府机关账户&nbsp;&gt;
    <s:if test="id>0">修改</s:if>
    <s:else>
   	 添加
    </s:else>
    </div>
	<form id="addForm" action="system/user_${id > 0 ? 'edit' : 'add' }.action" method="post">
	<input type="hidden" id="id" name="id" value="${empty id ? '0' : id }" />
	
    <table cellpadding="0" cellspacing="0" class="table_add">
     <tr>
      <th width="12%">帐号</th>
      <td>
      
      	<s:if test="id > 0">&nbsp;${code }</s:if>
      	<s:else>
      		<input type="text" id="code" name="code" class="input_text" maxlength="20"/>
      	</s:else>
      </td>
      </tr>
      
     <s:if test="id <= 0">
     <tr>
      <th>密码</th>
      <td><input type="password" id="password" name="password" class="input_text" maxlength="20" /></td>
      </tr>
     <tr>
      <th>确认密码</th>
      <td><input type="password" id="password2" class="input_text" maxlength="20" /></td>
      </tr>
     </s:if>
       
    <tr>
      <th>姓名</th>
      <td>
		<input type="hidden" name="pageNo" value="${empty pageNo ? '1' : pageNo}" />	
      <input type="text" id="name" name="name" value="${name }"  class="input_text"  maxlength="50"/>
      </td>
      </tr>  
    <tr>
      <th>电话</th>
      <td><input type="text" id="tel" name="tel" value="${tel }"  class="input_text"  />
      </td>
      </tr>
     <tr>
      <th>所属角色</th>
      <td>
      	<select id="roleId" name="roleId" class="input_text">
      		<option value="">请选择一个角色</option>
      		<s:iterator value="#roleList" var="r">
      		<option value="${r.id }" ${r.id == role.id ? "selected" : ""}>${r.name }</option>
      		</s:iterator>
      	</select>
      </td>
      </tr>
      <s:if test="session.loginUser.site.code=='340000000' || session.loginUser.site.code=='340000099'">
     <tr>
      <th>组织机构</th>
       <td>
     
      	<input type="hidden" name="siteId" id="siteId" value="${site.id }"/>
      	<input type="text"  class="input_text" name="siteName" id="siteName" value="${site.name }" readonly="readonly"/>
      	<a href="javascript:doShowQueryWindow('system/site_searchOrganForQucik.action','doQueryOK','siteId','siteName','名称')">
    		<img src="images/query.png" border="0" />
    	</a>
    	<span id="fail_msg_span"></span>
	  </td>
      </tr>
      </s:if>
      <s:else>
     <tr>
      <th>组织机构</th>
       <td>
      <input type="hidden" name="siteId" id="siteId" value="${session.loginUser.site.id }"/>
      <input type="text"  class="input_text" name="siteName" id="siteName" value="${session.loginUser.site.name }" readonly="readonly"/>
      
	  </td>
      </tr>
      </s:else>
      
      
    <tr>
      <th>邮箱地址</th>
      <td><input type="text" id="email" name="email" value="${email }"  class="input_text"  />
      </td>
      </tr>

	<s:if test="id > 0">
     <tr>
      <th>有效状态</th>
      <td>
          <input type="radio" name="state" value="1" ${state == 1 ? "checked" : "" } />有效
          <input type="radio" name="state" value="0" ${state == 0 ? "checked" : ""}/>无效
      </td>
      </tr>
      </s:if>
    </table>
    
    </form> 
    <div class="add_savebtn">
    	
    	<a href="javascript:doSave()"><img src="images/save.gif" border="0"/></a>
    	<a href="javascript:history.back()"><img src="images/back00.gif" border="0" /></a>
    </div>
    
<brady:query paramName="queryCode"/>
 </div>  <!--right_main-->