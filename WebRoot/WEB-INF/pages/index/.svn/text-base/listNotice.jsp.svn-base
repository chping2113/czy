<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/include/core.jsp"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>项目信息公开</title>
<link href="css/jxw_main.css"  rel="stylesheet" type="text/css"/>

<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
</head>



<body>
<div class="content">

<jsp:include page="${headPath }" />
  <div class="middle">
    <div class="left_middle">
    
     
    
    <div class="twopage_left">
    <div class="news"> <div class="twopage_left_top2"></div>
      <div class="twopage_text">
      <div class="news_text_top"></div>
       <ul class="twopage_text_ul">
       <li id="visited">通知公告信息</li>
       
       </ul>
   
 </div>
 <div class="news_text_btm"></div>
 </div>
 </div>
    </div> <!--left_middle-->
    <div class="right_middle">
    <div class="twopage_top"><span class="span_left">通知公告信息</span>
    
    
    </div>
      <div class="two_rightlist">
      <ul class="two_rightlist_ul">
      <s:iterator value="pageInfo.pageData" var="notice">
      	<li><span>「<s:date name="#notice.createTime" format="yyyy-MM-dd" />」</span><a href="pub_showNotice.action?id=${notice.id }" title="${notice.title }" target="_blank">${util:limitText(notice.title,50) }</a></li>
      </s:iterator>
      </ul>  
    
      <div class="page">
	       <s:if test="prostate==1">
  				<brady:page url="pub_searchAll.action?id=1&searchOrganCode=${searchOrganCode }" pageInfo="${pageInfo }" />
	       </s:if>
	       <s:else>
        		<brady:page url="pub_listMoreNotice.action" pageInfo="${pageInfo }" />
	       </s:else>
      </div> 
    </div> 
  </div><!--right_middle-->
 </div> <!--middle DIV-->

 <div class="bottom">
${session_homePage.footer }

</div> <!--bottom DIV-->
</div><!--content DIV-->
</body>
</html>
