<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/include/core.jsp"%>
<div id="right_middle_div">
	
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
  				<brady:page url="pub_searchAll.action?id=1&title=${title}" pageInfo="${pageInfo }" />
	       </s:if>
	       <s:else>
        		<brady:page url="pub_listMoreNotice.action?message=3" pageInfo="${pageInfo }" />
	       </s:else>
      </div> 
    </div> 
</div>