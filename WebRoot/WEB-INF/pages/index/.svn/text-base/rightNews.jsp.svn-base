<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/include/core.jsp"%>
<div id="right_middle_div">
	<div class="twopage_top"> 项目公开要闻
    
    
    </div>
      <div class="two_rightlist">
      <ul class="two_rightlist_ul">
      <s:iterator value="pageInfo.pageData" var="news">
      	<li><span>「<s:date name="#news.createTime" format="yyyy-MM-dd" />」</span><a href="pub_showNews.action?id=${news.id }" title="${news.title }" target="_blank">${util:limitText(news.title,50) }</a></li>
      </s:iterator>
      </ul>  
    
      <div class="page">
      
	       <s:if test="prostate==2">
  				<brady:page url="pub_searchAll.action?id=2&title=${title}&catelogId=18&message=${message }" pageInfo="${pageInfo }" />
	       </s:if>
	       <s:else>

        		<brady:page url="pub_listNewsByCatelogId.action?catelogId=18&message=3" pageInfo="${pageInfo }" />
	       </s:else>
      </div> 
    </div> 
</div>