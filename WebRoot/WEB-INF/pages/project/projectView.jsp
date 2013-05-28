<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/include/core.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>安徽项目公开网-项目基本信息</title>
	<script type="text/javascript">
	</script>
</head>
<body>
   <div class="right_main">
    <div class="add_top">发布项目基本信息&nbsp; &gt; 查看</div>
    <table cellpadding="0" cellspacing="0" class="table_add">
	  <tr>
      <th width="20%">发布机构</th>
      <td>
	  	${site.name }
	  </td>
      </tr>
      <tr>
      <th>建设单位</th>
      <td>
	  	${company.name }
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
      <th>项目金额</th>
      <td>${money }</td>
      </tr>
     <tr>
      <th>项目归属地</th>
      <td>${district.name }</td>
      </tr>
	  <tr>
      <th>项目业主</th>
      <td>${owner }</td>
      </tr>
      <tr>
      <th>发布时间</th>
      <td><s:date name="createTime" format="yyyy-MM-dd"/></td>
      </tr>
    </table>
    </form>
    <div class="add_savebtn">
    	<a href="javascript:history.back()"><img src="images/back00.gif" border="0" /></a>
    </div>
    
 </div>  <!--right_main-->

</body>