<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/include/core.jsp"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/jxw_main.css"  rel="stylesheet" type="text/css"/>

<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<style type="text/css">
	.twopage_left_text ul li a {
		display:block;
		line-height: 30px;
		margin: 10px;
	}
</style>
<script type="text/javascript">function test(objId){
	return document.getElementById(objId);
}
function changeId(idName,obj,tab){
	test(idName).id="";
	obj.id=idName;
	obj.blur();
}
	function rightMiddle(url){
		var param = {};
		$.post(url, param, function(date) {
			$("#right_middle_div").html(date);
		});
	}
	
	$(function() {
		
		var style = $(".twopage_left a").first().attr("style");
		
		$(".twopage_left a").bind("click", function() {
			$(this).attr("style",style);
		//	$(this).siblings().attr("style","background-color:#cccccc");
		});
	});
</script>

<title>

    <s:if test="message==2">
    组织机构</s:if>
    <s:elseif test="message==3">
        工作动态</s:elseif>
    <s:elseif test="message==6">
      法律法规</s:elseif>
</title>
</head>



<body>
<div class="content">
<jsp:include page="${headPath }" />
  <div class="middle">
    <div class="left_middle">
    
    <div class="twopage_left">
    <div class="news">
    <s:if test="message==2">
      <div class="twopage_left_top1"></div></s:if>
    <s:elseif test="message==3">
      <div class="twopage_left_top2"></div></s:elseif>
    <s:elseif test="message==6">
      <div class="twopage_left_top4"></div></s:elseif>
      <div class="twopage_text">
      <div class="news_text_top"></div>
       <ul class="twopage_text_ul">
       <s:if test="message==3">
        <li >
        <s:if test="temp==2">
       		<a href="javascript:rightMiddle('pub_rightNews.action')" onclick="changeId('visited',this)">项目公开要闻</a>
			
			<a id="visited"  href="javascript:rightMiddle('pub_rightNotice.action')" onclick="changeId('visited',this)">通知公告信息</a>
		</s:if>
		<s:else>
        <s:if test="prostate==2">
        <a  id="visited" href="javascript:rightMiddle('pub_rightNews.action')" onclick="changeId('visited',this)">项目公开要闻</a>
		
        </s:if>
        <s:else>
        <a  id="visited" href="javascript:rightMiddle('pub_rightNews.action')" onclick="changeId('visited',this)">项目公开要闻</a>
			
			<a href="javascript:rightMiddle('pub_rightNotice.action')" onclick="changeId('visited',this)">通知公告信息</a>
		
        </s:else>
		
		</s:else>		
		</li>
       </s:if>
      
		<s:else>
		
       <li id="visited">${newsCatelog.title}</li>
		</s:else>
			</ul>
   
 </div> 
 <div class="news_text_btm"></div>
 </div>
 </div>
    </div> <!--left_middle-->
    <div id="right_middle_div" class="right_middle">
        <s:if test="temp==2">
          
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
        		<brady:page url="pub_listMoreNotice.action?message=${message }" pageInfo="${pageInfo }" />
	       </s:else>
      </div> 
    </div> 
        </s:if>
      
        <s:else>
        <s:if test="message==3">
         <div class="twopage_top">  项目公开要闻
    </div>
    </s:if>
        <s:else>
         <div class="twopage_top"> ${newsCatelog.title}
    </div>
        </s:else>
       
      <div class="two_rightlist">
      <ul class="two_rightlist_ul">
      <s:iterator value="pageInfo.pageData" var="news">
      	<li><span>「<s:date name="#news.createTime" format="yyyy-MM-dd" />」</span><a href="pub_showNews.action?id=${news.id }" title="${news.title }" target="_blank">${util:limitText(news.title,50) }</a></li>
      </s:iterator>
      </ul>  
    
      <div class="page">
      
	       <s:if test="prostate==2">
  				<brady:page url="pub_searchAll.action?id=2&catelogId=18&message=${message }" pageInfo="${pageInfo }" />
	       </s:if>
	       <s:else>

        		<brady:page url="pub_listNewsByCatelogId.action?catelogId=${catelogId }&message=${message }" pageInfo="${pageInfo }" />
	       </s:else>
      </div> 
    </div> 
        </s:else>
    
  </div><!--right_middle-->
 </div> <!--middle DIV-->
 <div class="bottom">
${session_homePage.footer }

</div> <!--bottom DIV-->
</div><!--content DIV-->
</body>
</html>
