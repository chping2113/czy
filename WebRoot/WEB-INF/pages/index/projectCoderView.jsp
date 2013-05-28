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
</style></head>
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
 
<span class="span_left">项目编码信息>查看</span>
 <span class="span_more"></span></div>
 <div class="open_news_text">  
    
    
    

    <table cellpadding="0" cellspacing="0" class="tousu_table01">
    
    
     
     <tr>
      <th  width="20%">项目名称</th>
      <td>
     ${projectName }
	  </td>
      </tr>
      <tr>
      <th>行政区划代码</th>
      <td>	
      ${xzqCode }
	  	
	  </td>
      </tr><tr>
      <th>组织机构代码</th>
      <td>	
      ${siteCode }
	  	
	  </td>
      </tr>
      <tr>
      <th>项目编码</th>
      <td>	
      ${projectCode }
	  	
	  </td>
      </tr>
    </table>
    
    <div class="add_savebtn" align="center">
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