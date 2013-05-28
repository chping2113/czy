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
    <s:if test="message != null">
    <span style="font-size:20px;color: red; ">　　　　　　　　　　　　　　　　${message }</span>
    </s:if>
    <table cellpadding="0" cellspacing="0" class="table_add">
     <tr>
      <th width="30%">类型</th>
      <td>&nbsp;${type }</td>
      </tr>
	<tr>
      <th>单位名称</th>
      <td>&nbsp;${title }</td>
      </tr><tr>
      <th>链接地址</th>
      <td>&nbsp;${url }</td>
      </tr>
	 <tr>
      <th>每百万人中访问人数</th>
      <td>&nbsp;${person }</td>
     </tr>
     
     <tr>
      <th>每百万人访问页面中访问本站的页面数</th>
      <td>&nbsp;${page }</td>
      </tr>
      
      <tr>
      <th>平均每个访问者浏览的页面数</th>
      <td>&nbsp;${personPage }</td>
      </tr>
    </table>
     
    <div class="add_savebtn">
    	<a href="javascript:history.back()"><img src="images/back00.gif" border="0" /></a>
    </div>
</div><!--content-->
</body>