<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/include/core.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>安徽项目公开网-系统管理</title>
	<script type="text/javascript">
	</script>
</head>
<body>
  <div class="right_main">
    <div class="add_top">政府机关账户&nbsp;&gt;查看</div>
    <table cellpadding="0" cellspacing="0" class="table_add">
     <tr>
      <th width="20%">帐号</th>
      <td>&nbsp;${code }</td>
      </tr>
	<tr>
      <th>姓名</th>
      <td>&nbsp;${name }</td>
      </tr><tr>
      <th>电话</th>
      <td>&nbsp;${tel }</td>
      </tr>
	 <tr>
      <th>所属角色</th>
      <td>&nbsp;${role.name }</td>
     </tr>
     
     <tr>
      <th>组织机构</th>
      <td>&nbsp;${site.name }</td>
      </tr>
      
      <tr>
      <th>邮箱地址</th>
      <td>&nbsp;${email }</td>
      </tr>

     <tr>
      <th>有效状态</th>
      <td>&nbsp;${state == 1 ? "有效" : "无效" }</td>
      </tr>
     <tr>
       <th>创建时间</th>
       <td>&nbsp; <s:date name="createTime" format="yyyy-MM-dd" /> </td>
     </tr>
    </table>
     
    <div class="add_savebtn">
    	<a href="javascript:history.back()"><img src="images/back00.gif" border="0" /></a>
    </div>
</div><!--content-->
</body>