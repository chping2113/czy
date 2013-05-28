<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/include/core.jsp"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>" />
<title>安徽项目公开网</title>

<link href="css/jxw_main.css" rel="stylesheet" />
<link href="css/styles.css" rel="stylesheet" />
<link href="css/humanity/jquery-ui.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="css/smallslider.css"/>

<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.6.min.js"></script>
<script type="text/javascript" src="js/jquery.ui.datepicker-zh-CN.js"></script>
<script type="text/javascript" src="js/jquery.brady-min.js"></script>
<script type="text/javascript" src="js/jquery.smallslider.js"></script>
<script type="text/javascript" src="js/index.js"></script>
<script type="text/javascript"> 
var flag=0 ;
function SelectTab(keyword, count, index){
	var i=1;
	for(i=1; i<=count; i++){
		if(i == index){
			document.getElementById(keyword + "_" + i +"_hander").className="Tab_Blue_focus";
			document.getElementById(keyword + "_" + i +"_body").style.display="block";
		}else{
			if(document.getElementById(keyword + "_" + i +"_hander")!=null){
				document.getElementById(keyword + "_" + i +"_hander").className="Tab_Blue_blur";
				document.getElementById(keyword + "_" + i +"_body").style.display="none";
			}
		}
	}
}
function SelectTab2(keyword, index){
	document.getElementById(keyword + "_" + index +"_hander").className="Tab_Blue_focus";
	document.getElementById(keyword + "_" + index +"_body").style.display="block";
}
	function changeKey(count){
		  if (event.keyCode==13) { 
			  doSubmit(count);
		  } 
	}
	

	//<!-- 
		function clearText(title){
			$('#'+title).attr("value","");
		}
		//-->
</script>
</head>

<body>

<div class="content">
  <%session.setAttribute( "headPath", request.getServletPath().substring(0,request.getServletPath().lastIndexOf('/')+1)+"templateHead.jsp");%>
  <%@ include file="templateHead.jsp"%>
  <div class="middle">
  
    <div class="left_middle">

<s:if test="session.session_site.code=='340000000'">
    <div class="news">
      <div class="news_top"><span class="span_more"><a href="pub_listNewsByCatelogId.action?catelogId=18&message=3"> > 更多</a></span></div>
      <div class="news_text">
      <div class="news_text_top"></div>
      <div class="news_photo">
		
    <div id="imageSliderBox" class="photo_slider smallslider">
   		<ul >
   		<s:iterator value="#imageNewsList" var="news">
   			<li><a href="pub_showNews.action?id=${news.id}" target="_blank" ><img src="upload_images/${news.imageFileName}" width="268" height="197" border="0" title="" alt=""/></a></li>
   		</s:iterator>
   		</ul>
    </div>
	  </div>
      <ul class="news_text_ul">
      <s:iterator value="#nonImageNewsList" var="nonImageNews" >
    	<li><span><s:date name="#nonImageNews.createTime" format="yyyy-MM-dd" /></span><a href="pub_showNews.action?id=${nonImageNews.id}" title="${nonImageNews.title }" target="_blank">${util:limitText(nonImageNews.title, 10) }</a></li>
      </s:iterator>
      </ul>
      </div>
      <div class="news_text_btm"></div>
 </div> 
 </s:if>
    
        <div class="news">
      <div class="message_top"><span class="span_more"><a href="pub_listMoreNotice.action?message=3"> > 更多</a></span></div>
      <div class="news_text">
      <div class="news_text_top"></div>
      <ul class="message_text_ul">
      <s:iterator value="#noticeList" var="notice">
      	<li><span><s:date name="#notice.createTime" format="yyyy-MM-dd" /></span><a href="pub_showNotice.action?id=${notice.id }" title="${notice.title }" target="_blank">${util:limitText(notice.title, 10) }</a></li>
      </s:iterator>
      </ul>
      </div>
      <div class="news_text_btm"></div>
 </div>
    

 <div class="sheng">
  <div class="sheng_top"></div>
  <div class="sheng_text">
  <s:if test="session.session_site.type==0">
  <div class="sheng_title"><img src="imgage/top.jpg" /></div>
  </s:if>
  <s:else>
  <div class="sheng_title"><img src="imgage/shen.jpg" /></div>
  
  </s:else>
  <table border="0" cellpadding="0" cellspacing="0" class="sheng_table">
 
  <s:if test="session.session_site.type==0">
  <c:forEach items="${topNavigateList}" step="3" varStatus="status">
  <tr>
  <td>
  		<a href="${topNavigateList[status.index].url}" title="${topNavigateList[status.index].name}" target="_blank">${util:limitText(topNavigateList[status.index].name, 4) }</a>
  	
  </td>
  <td>
  		<a href="${topNavigateList[status.index+1].url }" title="${topNavigateList[status.index+1].name}" target="_blank">${util:limitText(topNavigateList[status.index+1].name, 4) }</a>
  	
  </td>
  <td>
  		<a href="${topNavigateList[status.index+2].url }" title="${topNavigateList[status.index+2].name }" target="_blank">${util:limitText(topNavigateList[status.index+2].name, 4) }</a>
  	
  </td>
  </tr>
  </c:forEach>
  </s:if>
  <s:else> 
  <c:forEach items="${zhuanLanOrganList}" step="3" varStatus="status">
  <tr>
  <td>
  	<c:if test="${empty zhuanLanOrganList[status.index].footer }">
  		<a href="#" onclick="return false;" title="${zhuanLanOrganList[status.index].name}"  target="_blank">${util:limitText(zhuanLanOrganList[status.index].name, 4) }</a>
  	</c:if>
  	<c:if test="${not empty zhuanLanOrganList[status.index].footer }">
  		<a href="zl_${zhuanLanOrganList[status.index].code }.action" title="${zhuanLanOrganList[status.index].name }"  target="_blank">${util:limitText(zhuanLanOrganList[status.index].name, 4) }</a>
  	</c:if>
  </td>
  <td>
  	<c:if test="${empty zhuanLanOrganList[status.index+1].footer }">
  		<a href="#" onclick="return false;" title="${zhuanLanOrganList[status.index+1].name }"  target="_blank">${util:limitText(zhuanLanOrganList[status.index+1].name, 4) }</a>
  	</c:if>
  	<c:if test="${not empty zhuanLanOrganList[status.index+1].footer }">
  		<a href="zl_${zhuanLanOrganList[status.index+1].code }.action" title="${zhuanLanOrganList[status.index+1].name}" target="_blank">${util:limitText(zhuanLanOrganList[status.index+1].name, 4) }</a>
  	</c:if>
  </td>
  <td>
  	<c:if test="${empty zhuanLanOrganList[status.index+2].footer }">
  		<a href="#" onclick="return false;" title="${zhuanLanOrganList[status.index+2].name }"  target="_blank">${util:limitText(zhuanLanOrganList[status.index+2].name, 4) }</a>
  	</c:if>
  	<c:if test="${not empty zhuanLanOrganList[status.index+2].footer }">
  		<a href="zl_${zhuanLanOrganList[status.index+2].code }.action" title="${zhuanLanOrganList[status.index+2].name }"  target="_blank">${util:limitText(zhuanLanOrganList[status.index+2].name, 4) }</a>
  	</c:if>
  </td>
  </tr>
  </c:forEach>
  </s:else>
</table>
</div>
  <div class="sheng_btm"></div>
 </div><!--sheng-->

 <div class="sheng">
 <div class="sheng_top"></div>
  <div class="sheng_text">
  <s:if test="session.session_site.type==0">
  <div class="sheng_title"><img src="imgage/bottom.jpg" /></div>
  </s:if>
  <s:else>
  <div class="sheng_title"><img src="imgage/shi.jpg" /></div>
  
  </s:else>
  <table border="0" cellpadding="0" cellspacing="0" class="sheng_table">
  
  <s:if test="session.session_site.type==0">
  <c:forEach items="${bottomNavigateList}" step="3" varStatus="status">
  <tr>
  <td>
  		<a href="${bottomNavigateList[status.index].url}" title="${bottomNavigateList[status.index].name}" target="_blank">${util:limitText(bottomNavigateList[status.index].name, 4) }</a>
  	
  </td>
  <td>
  		<a href="${bottomNavigateList[status.index+1].url }" title="${bottomNavigateList[status.index+1].name}" target="_blank">${util:limitText(bottomNavigateList[status.index+1].name, 4) }</a>
  	
  </td>
  <td>
  		<a href="${bottomNavigateList[status.index+2].url }" title="${bottomNavigateList[status.index+2].name }" target="_blank">${util:limitText(bottomNavigateList[status.index+2].name, 4) }</a>
  	
  </td>
  </tr>
  </c:forEach>
  </s:if>
  <s:else>
  <c:forEach items="${pingTaiOrganList}" step="3" varStatus="status">
  <tr>
  <td>
  	<c:if test="${empty pingTaiOrganList[status.index].footer }">
  		<a href="#" onclick="return false;" target="_blank">${pingTaiOrganList[status.index].name }</a>
  	</c:if>
  	<c:if test="${not empty pingTaiOrganList[status.index].footer }">
  		<a href="pt_${pingTaiOrganList[status.index].code }.action" target="_blank">${pingTaiOrganList[status.index].name }</a>
  	</c:if>
  </td>
  <td>
  	<c:if test="${empty pingTaiOrganList[status.index+1].footer }">
  		<a href="#" onclick="return false;" target="_blank">${pingTaiOrganList[status.index+1].name }</a>
  	</c:if>
  	<c:if test="${not empty pingTaiOrganList[status.index+1].footer }">
  		<a href="pt_${pingTaiOrganList[status.index+1].code }.action" target="_blank">${pingTaiOrganList[status.index+1].name }</a>
  	</c:if>
  </td>
  <td>
  	<c:if test="${empty pingTaiOrganList[status.index+2].footer }">
  		<a href="#" onclick="return false;" target="_blank">${pingTaiOrganList[status.index+2].name }</a>
  	</c:if>
  	<c:if test="${not empty pingTaiOrganList[status.index+2].footer }">
  		<a href="pt_${pingTaiOrganList[status.index+2].code }.action" target="_blank">${pingTaiOrganList[status.index+2].name }</a>
  	</c:if>
  </td>
  </tr>
  </c:forEach>
  </s:else>
</table>
 </div>
 <div class="sheng_btm"></div>
</div><!--sheng-->
 
 
  <div class="sheng">
 <div class="sheng_top"></div>
  <div class="sheng_text">
  <div class="sheng_title"><img src="imgage/xian.jpg" /></div>
  <table border="0" cellpadding="0" cellspacing="0" class="sheng_table">
  
  
  <tr>
  <td><a href="http://220.178.124.24/gcjsxxgk/public/department_xmgk.xp?treeid=000400010010&strUnitId=12738297634864" target="_blank">肥西县人民政府</a></td>
  <td><a href="http://www.ahxmgk.gov.cn/web/index.jsp#" target="_blank">肥西县住建委</a></td>
  </tr>
   <tr>
  <td><a href="http://220.178.124.24/gcjsxxgk/public/department_xmgk.xp?treeid=0004000100100015&strUnitId=128399651385522" target="_blank">肥西县交通局</a></td>
  <td><a href="http://220.178.124.24/gcjsxxgk/public/department_xmgk.xp?treeid=0004000100100029&strUnitId=128399645280916" target="_blank">肥西县水务局</a></td>
  </tr>  
   <tr>
  <td><a href="http://220.178.201.103/ftfgw/" target="_blank">凤台县发改委</a></td>
  <td><a href="http://220.178.201.103/ftcxjs/" target="_blank">凤台县城建委</a></td>
  </tr> 
   <tr>
  <td><a href="http://220.178.201.103/ftjtys/" target="_blank">凤台县交通局</a></td>
  <td><a href="http://220.178.201.103/ftslj/" target="_blank">凤台县水利局</a></td>
  </tr> 
   <tr>
  <td><a href="http://www.ahxmgk.net/fcfgw/" target="_blank">繁昌县发改委</a></td>
  <td><a href="http://www.ahxmgk.net/fccxjs/" target="_blank">繁昌县城建委</a></td>
  </tr> 
   <tr>
  <td><a href="http://www.ahxmgk.net/fcjtys/" target="_blank">繁昌县交通局</a></td>
  <td><a href="http://www.ahxmgk.net/fcswj/" target="_blank">繁昌县水务局</a></td>
  </tr> 
   <tr>
  <td><a href="http://220.178.124.24/gcjsxxgk/public/department_xmgk.xp?treeid=0004000100100092&strUnitId=128399649884020" target="_blank">肥西县房产局</a></td>
  <td><a href="http://220.178.124.24/gcjsxxgk/public/department_xmgk.xp?treeid=0004000100100093&strUnitId=128399648066818" target="_blank">肥西县发改委</a></td>
  </tr> 
  
</table>
 </div>
 <div class="sheng_btm"></div>
</div><!--sheng-->



 <div class="left_images"><a href="http://www.zzg.gov.cn/xmxx/xgyw/" target="_blank"><img src="imgage/gongchen.jpg" /></a>
 <a href="#"><img src="imgage/zaixian.jpg" /></a>
 <a href="help/web/index-help.html" target="_blank"> <img src="imgage/zinan.jpg" /></a>
 </div>  
<div class="tell">
      <div class="tell_top"></div>
      <div class="tell_text">
      <div class="tell_bg">
      <div class="tell_nuber">${homePage.report }</div>
        <div class="tell_btn"><a href="pub_showComplaint.action?message=7" id="${message=='7'?'curTab':'' }"><img src="imgage/tell_btn1.jpg" /></a> </div>
      </div>
      </div>
     <div class="news_text_btm"></div>
 </div> <!--div tell-->
    
    
     <!-- 快速登录 start -->
     <div class="user">
     <form id="loginForm" action="pub_indexLogin.action" method="post">
      <div class="user_top">
      <ul>
      <li><a href="#" id="curTab_select5" onClick="changeId5('curTab_select5',this,'#tab223'); return false;">项目建设单位</a></li>
      <li><a href="#" onClick="changeId5('curTab_select5',this,'#tab224'); return false;">从业单位/个人</a></li></ul></div>
      <div id="tab223" style="display:block;" >
      <div class="user_text">
      <p>用户名
             <input name="code" id="code" type="text" class="user_text_input" />
      </p>
    <p>密<span>码</span>
             <input name="password" id="password" type="password" class="user_text_input"  onkeypress="changeKey(1)"/>
    </p>
          
       <p class="ahahubtn"><a href="#">项目建设单位注册</a></p>
      <p class="text_center"><a href="javascript:doSubmit(1)"><img src="imgage/login.gif" /></a><span class="password"><a href="pub_showPassword.action">忘记密码？</a></span>  </p>
      </div>
     </div>
      <div id="tab224" style="display:none;" >
      <div class="user_text">
      <p>用户名
             <input name="code" id="code2" type="text" class="user_text_input" tabIndex=5/>
             <a href="pub_companyRegister.action" target="_blank"><img src="images/index/work.jpg"  class="work_valing" border="0"/></a></p>
    <p>密<span>码</span>
             <input name="password" id="password2" type="password" class="user_text_input" tabIndex=6 onkeypress="changeKey(2)"/>
             <a href="pub_personRegister.action" target="_blank"><img src="images/index/people.jpg"  class="work_valing" border="0"/></a>          </p>
          <p class="radio_p">类<span>型</span>
            <label><input type="radio" name="state2" value="1" id="RadioGroup_2" class="user_text_radio" checked="checked" onkeypress="changeKey(2)"/>从业单位</label>
            <label><input type="radio" name="state2" value="2" id="RadioGroup_3" class="user_text_radio" onkeypress="changeKey(2)"/>从业个人</label>
          </p>
      <p class="text_center"><a href="javascript:doSubmit(2)"><img src="imgage/login.gif" tabIndex=7/></a><span class="password"><a href="pub_showPassword.action">忘记密码？</a></span>  </p>
      </div>
     </div>
     </form>
     </div>
     <div class="user_btm"></div>
     <!-- 快速登录 end -->
    
 	
 	<!-- 通知公告的浮动显示div -->
 	<input type="hidden" id="floatNoticeListSize" value="<s:property value='#floatNoticeList.size' />" />
 	<s:if test="#floatNoticeList.size > 0">
 	<p class="clear"></p><!-- 修改IE6下绝对定位不显示的bug -->
   	
   	<div id="floatNoticePane" class="open_window">
    <div class="open01"><a href="javascript:closeFloatNoticePane()"><img src="images/index/closebtn.gif" /></a></div>
    <div class="open02">
    <ul>
    <s:iterator value="#floatNoticeList" var="notice">
	     <li><a href="pub_showNotice.action?id=${notice.id }" title="${notice.title }" target="_blank">${util:limitText(notice.title, 30) }</a></li>
	    </s:iterator>
    </ul>
    </div>
    <div class="open03"></div>
    </div>
    
   	<p class="clear"></p><!-- 修改IE6下绝对定位不显示的bug -->
   	</s:if>
 

 
      
 </div><!--left_middle--> 
 
 <div class="right_middle">
 <div class="search">
 <div class="search_bg">
  <div class="search_title">快速搜索</div>
    <form action="pub_searchAll.action" method="post" id="searchForm">
  <div class="search_text">
	   <select class="select_txt" id="id" name="id">
	    <option value="1">通知公告</option>
		<option value="2">项目公开要闻</option>
		<option value="3" selected="selected">项目审批信息</option>
		<option value="4">项目建设管理信息</option>
		<option value="5">土地矿业权审批信息</option>
		<option value="6">从业单位信用等级公告</option>
		<option value="7">从业单位诚信档案</option>
		<option value="8">从业个人诚信档案</option>
		<option value="9">良好行为信息</option>
		<option value="10">不良行为信息</option>
	   </select>
	   <input  type="text" class="search_input" id="title"  name="title"  value="请输入您要搜索的关键字......" onclick="clearText('title')"/>
	   
   		<a href="javascript:searchForm.submit()"><img src="imgage/search2.gif" /></a> 
	    </div>
	    </form>
 </div>
 </div>

 <div class="open_news">
 <div class="open_news_top"><span class="span_more"><a href="pub_navProjectPublic.action?message=4"> > 更多</a></span></div>
 <div class="open_news_text">
   <div class="Tab_Blue">
   <s:if test="#homePage.approve==1 || #homePage.construct==1 || #homePage.land==1">
      <div class="Tab_Blue_focus" id="tba_1_hander" onclick="javascript:SelectTab('tba', 4, 1);">
    	<div class="L"></div>
        <div class="C">
        	<s:if test="#homePage.approve==1">项目审批信息</s:if>
        	<s:elseif test="#homePage.construct==1">项目建设管理信息</s:elseif>
        	<s:elseif test=" #homePage.land==1">土地矿业权审批信息</s:elseif>
        </div>
        <div class="R"></div>  
      </div>
      <script type="text/javascript">flag = 1;</script>
   </s:if>
   <s:if test="#homePage.approve==2 || #homePage.construct==2 || #homePage.land==2">
      <div class="Tab_Blue_blur" id="tba_2_hander" onclick="javascript:SelectTab('tba', 4, 2);">
    	<div class="L"></div>
        <div class="C">
        	<s:if test="#homePage.approve==2">项目审批信息</s:if>
        	<s:elseif test="#homePage.construct==2">项目建设管理信息</s:elseif>
        	<s:elseif test=" #homePage.land==2">土地矿业权审批信息</s:elseif>
        </div>
        <div class="R"></div>  
      </div>
      <script type="text/javascript">if(flag==0)flag=2;</script>
   </s:if>
   <s:if test="#homePage.approve==3 || #homePage.construct==3 || #homePage.land==3">
      <div class="Tab_Blue_blur" id="tba_3_hander" onclick="javascript:SelectTab('tba', 4, 3);">
    	<div class="L"></div>
        <div class="C">
        	<s:if test="#homePage.approve==3">项目审批信息</s:if>
        	<s:elseif test="#homePage.construct==3">项目建设管理信息</s:elseif>
        	<s:elseif test=" #homePage.land==3">土地矿业权审批信息</s:elseif>
        </div>
        <div class="R"></div>  
      </div>
      <script type="text/javascript">if(flag==0)flag=3;</script>
   </s:if>
      <div class="Tab_Blue_blur" id="tba_4_hander" >
    	<div class="L"></div>
        <div class="C">&nbsp;&nbsp;&nbsp;招投标信息</div>
        <div class="R"></div>  
      </div>
   </div>
   <div>
  <div id="tba_${homePage.approve }_body" style="display:none;" >
  <table cellpadding="0" cellspacing="0" class="table_list">
  <tr>
  <th>项目编码</th>
  <th>项目名称</th>
  <th>发布单位</th>
  <th>发布时间</th>
  </tr>
  <s:iterator value="projectApproveList" var="projectApprove" status="status1">
  
  		<s:if test="#status1.last == false">
  <tr>
  <td><a href="pub_showProjectApprove.action?id=${projectApprove.id}&title=1" target="_blank">${projectApprove.project.code }</a></td>
  <td>${util:limitText(projectApprove.project.name,16) }</td>
  <td>${projectApprove.site.name }</td>
  <td><s:date name="#projectApprove.createTime" format="yyyy-MM-dd" /></td>
  </tr>
  		</s:if>
  		<s:else>
  <tr>
  <td  style="border-bottom:none;" ><a href="pub_showProjectApprove.action?id=${projectApprove.id}" target="_blank">${projectApprove.project.code }</a></td>
  <td  style="border-bottom:none;" >${util:limitText(projectApprove.project.name,16) }</td>
  <td style="border-bottom:none;" >${projectApprove.site.name }</td>
  <td style="border-bottom:none;" ><s:date name="#projectApprove.createTime" format="yyyy-MM-dd" /></td>
  </tr>
  		</s:else>
  </s:iterator>
  </table>
  </div>
  <div id="tba_${homePage.construct }_body" style="display:none;">
  <table cellpadding="0" cellspacing="0" class="table_list">
   <tr>
  <th>项目编码</th>
  <th>项目名称</th>
  <th>发布单位</th>
  <th>发布时间</th>
  </tr>
  <s:iterator value="projectConstructList" var="projectConstruct" status="status1">
  		<s:if test="#status1.last == false">
  <tr>
  <td><a href="pub_showProjectConstruct.action?id=${projectConstruct.id}" target="_blank">${projectConstruct.project.code }</a></td>
  <td>${util:limitText(projectConstruct.project.name,16) }</td>
  <td>${projectConstruct.site.name }</td>
  <td><s:date name="#projectConstruct.createTime" format="yyyy-MM-dd" /></td>
  </tr>
  		</s:if>
  		<s:else>
  <tr>
  <td style="border-bottom:none;"><a href="pub_showProjectConstruct.action?id=${projectConstruct.id}" target="_blank">${projectConstruct.project.code }</a></td>
  <td style="border-bottom:none;">${util:limitText(projectConstruct.project.name,16) }</td>
  <td style="border-bottom:none;">${projectConstruct.site.name }</td>
  <td style="border-bottom:none;"><s:date name="#projectConstruct.createTime" format="yyyy-MM-dd" /></td>
  </tr>
  		</s:else>
  </s:iterator>
  </table>
</div>
<div id="tba_${homePage.land }_body" style="display:none;">
  <table cellpadding="0" cellspacing="0" class="table_list">
   <tr>
  <th>项目编码</th>
  <th>项目名称</th>
  <th>发布单位</th>
  <th>发布时间</th>
  </tr>
  <s:iterator value="projectLandList" var="projectLand" status="status1">
  <s:if test="#status1.last == false">
  <tr>
  <td><a href="pub_showProjectLand.action?id=${projectLand.id}" target="_blank">${projectLand.project.code }</a></td>
  <td>${util:limitText(projectLand.project.name,16) }</td>
  <td>${projectLand.site.name }</td>
  <td><s:date name="#projectLand.createTime" format="yyyy-MM-dd" /></td>
  </tr>
  </s:if>
  <s:else>
  <tr>
  <td style="border-bottom:none;"><a href="pub_showProjectLand.action?id=${projectLand.id}" target="_blank">${projectLand.project.code }</a></td>
  <td style="border-bottom:none;">${util:limitText(projectLand.project.name,16) }</td>
  <td style="border-bottom:none;">${projectLand.site.name }</td>
  <td style="border-bottom:none;"><s:date name="#projectLand.createTime" format="yyyy-MM-dd" /></td>
  </tr>
  </s:else>
  </s:iterator>
          <tr>
          <td><a href="#">3416001111111111120102A0</a></td>
          <td><a href="#">凤台县2010年小型农田水利重点县建设项目</a></td>
          <td>淮南市水利局</td>
          <td>2010-12-24</td>
          </tr>
          <tr>
          <td><a href="#">3416001111111111120102A0</a></td>
          <td><a href="#">凤台县2010年小型农田水利重点县建设项目</a></td>
          <td>淮南市水利局</td>
          <td>2010-12-24</td>
          </tr>
            <tr>
          <td><a href="#">3416001111111111120102A0</a></td>
          <td><a href="#">凤台县2010年小型农田水利重点县建设项目</a></td>
          <td>淮南市水利局</td>
          <td>2010-12-24</td>
          </tr>
          <tr>
          <td><a href="#">3416001111111111120102A0</a></td>
          <td><a href="#">凤台县2010年小型农田水利重点县建设项目</a></td>
          <td>淮南市水利局</td>
          <td>2010-12-24</td>
          </tr>
          <tr>
          <td><a href="#">3416001111111111120102A0</a></td>
          <td><a href="#">凤台县2010年小型农田水利重点县建设项目</a></td>
          <td>淮南市水利局</td>
          <td>2010-12-24</td>
          </tr>
          <tr>
          <td><a href="#">3416001111111111120102A0</a></td>
          <td><a href="#">凤台县2010年小型农田水利重点县建设项目</a></td>
          <td>淮南市水利局</td>
          <td>2010-12-24</td>
          </tr>
          <tr>
          <td><a href="#">3416001111111111120102A0</a></td>
          <td><a href="#">凤台县2010年小型农田水利重点县建设项目</a></td>
          <td>淮南市水利局</td>
          <td>2010-12-24</td>
          </tr>
          <tr>
          <td><a href="#">3416001111111111120102A0</a></td>
          <td><a href="#">凤台县2010年小型农田水利重点县建设项目</a></td>
          <td>淮南市水利局</td>
          <td>2010-12-24</td>
          </tr>
          <tr>
          <td><a href="#">3416001111111111120102A0</a></td>
          <td><a href="#">凤台县2010年小型农田水利重点县建设项目</a></td>
          <td>淮南市水利局</td>
          <td>2010-12-24</td>
          </tr>
          <tr>
          <td style="border-bottom:none;"><a href="#">3416001111111111120102A0</a></td>
          <td style="border-bottom:none;"><a href="#">凤台县2010年小型农田水利重点县建设项目</a></td>
          <td style="border-bottom:none;">淮南市水利局</td>
          <td style="border-bottom:none;">2010-12-24</td>
          </tr>
  </table>
</div>
<div id="tba_4_body" style="display:none;">
</div>
</div>
</div>
<div class="open_news_btm"></div>
</div>

<script type="text/javascript">if(flag!=0)SelectTab2('tba', flag);</script>

<s:if test="#keyProjectKindList.size > 0">
<div class="open_news">
 <div class="ten_top"></div>
 <div class="open_news_text">
	<div class="Tab_Blue1">
	
  <s:iterator value="keyProjectKindList" var="keyProjectKind" status="status">
  <s:if test="#status.count == 1">
      <div class="Tab_Blue_focus" id='tentext_${status.count }_hander' onclick="SelectTab('tentext', <s:property value='#keyProjectKindList.size'/>,${status.count});">
    	<div class="L"></div>
        <div class="C">${keyProjectKind.name}</div>
        <div class="R"></div>  
      </div>
      </s:if>
      <s:else>
	      <div class="Tab_Blue_blur" id='tentext_${status.count }_hander' onclick="SelectTab('tentext', <s:property value='#keyProjectKindList.size'/>,${status.count});">
	    	<div class="L"></div>
	        <div class="C">${keyProjectKind.name}</div>
	        <div class="R"></div>  
	      </div>
      </s:else>
  </s:iterator>
   </div>
   <div>
      
    <s:iterator value="keyProjectKindList" var="keyProjectKind" status="status">
	<s:if test="#status.first == true">
	<div id="tentext_${status.count }_body" tab="tab" style="display:block;"  >
    </s:if>
    <s:else>
	<div id="tentext_${status.count }_body" tab="tab" style="display:none;">
    </s:else>
  	<table cellpadding="0" cellspacing="0" class="table_list">
  		
  		<tr>
  			<th>项目编码</th>
 	 		<th>项目名称</th>
  			<th>发布单位</th>
  			<th>发布时间</th>
  		</tr>
  		
  		<s:iterator value="#keyProjectMap[#keyProjectKind.id]" var="keyProject" status="status1">
  		<s:if test="#status1.last == false">
  		<tr>
  			<td><a href="pub_showPorjectAegis.action?id=${keyProject.project.id }" target="_blank">${keyProject.project.code }</a></td>
  			<td>${util:limitText(keyProject.project.name,16) }</td>
  			<td>${keyProject.project.district.name }</td>
  			<td><s:date name="#keyProject.project.createTime" format="yyyy-MM-dd" /></td>
  		</tr>
  		</s:if>
    	<s:else>
  		<tr>
  			<td style="border-bottom:none;" ><a href="pub_showPorjectAegis.action?id=${keyProject.project.id }" target="_blank">${keyProject.project.code }</a></td>
  			<td style="border-bottom:none;" >${util:limitText(keyProject.project.name,16) }</td>
  			<td style="border-bottom:none;" >${keyProject.project.district.name }</td>
  			<td style="border-bottom:none;" ><s:date name="#keyProject.project.createTime" format="yyyy-MM-dd" /></td>
  		</tr>
  		</s:else>
  		</s:iterator>
  		
  	</table>
  	</div>
  	</s:iterator>
   </div>

</div>
<div class="open_news_btm"></div>
</div><!--ten_text div-->

</s:if>

<div class="open_news">
 <div class="gongx_top"><span class="span_more"><a href="pub_navCreditPublic.action?message=5"> > 更多</a></span></div>
 
 <div class="open_news_text">
    <div class="Tab_Blue">
      <div class="Tab_Blue_focus" id="gongx_1_hander" onclick="javascript:SelectTab('gongx', 5, 1);">
    	<div class="L"></div>
        <div class="C">从业单位信用等级公告</div>
        <div class="R"></div>  
      </div>
      <div class="Tab_Blue_blur" id="gongx_2_hander" onclick="javascript:SelectTab('gongx', 5, 2);">
    	<div class="L"></div>
        <div class="C">单位基本信息</div>
        <div class="R"></div>  
      </div>
      <div class="Tab_Blue_blur" id="gongx_3_hander" onclick="javascript:SelectTab('gongx', 5, 3);">
    	<div class="L"></div>
        <div class="C">个人基本信息</div>
        <div class="R"></div>  
      </div>
      <div class="Tab_Blue_blur" id="gongx_4_hander" onclick="javascript:SelectTab('gongx', 5, 4);">
    	<div class="L"></div>
        <div class="C">单位资质信息</div>
        <div class="R"></div>  
      </div>
      <div class="Tab_Blue_blur" id="gongx_5_hander" onclick="javascript:SelectTab('gongx', 5, 5);">
    	<div class="L"></div>
        <div class="C">个人资质信息</div>
        <div class="R"></div>  
      </div>
   </div>
   <div>
      <div id="gongx_1_body" style="display:block;" >
  <table cellpadding="0" cellspacing="0" class="table_list">
  <tr>
  <th colspan="2">单位名称</th>
  <th>信用评价结果</th>
  <!-- 
  <th>评价机构</th> -->
  <th>发布单位</th>
  <th>发布时间</th>
  </tr>
  <s:iterator value="companyCreditList" var="companyCredit">
  <tr>
  <td width="2"><img src="images/index/point.gif" /></td>
  <td><a href="pub_showCompanyCredit.action?id=${companyCredit.id}" target="_blank">${companyCredit.company.name }</a></td>
  
  <td>
  	<s:if test="#companyCredit.unifyCredit != null && #companyCredit.unifyCredit != ''">${companyCredit.unifyCredit }(${companyCredit.industryCredit })</s:if>
  	<s:else>${companyCredit.industryCredit }</s:else>
  </td>
  <!--  <td>${companyCredit.evaluateOrgan }</td>-->
  <td>${companyCredit.site.name }</td>
  <td><s:date name="#companyCredit.evaluateDate" format="yyyy-MM-dd" /></td>
  </tr>
  </s:iterator>
  </table>
</div>

   <div id="gongx_2_body" style="display:none;" >
    <table cellpadding="0" cellspacing="0" class="table_list">
  <tr>
  <th>单位名称</th>
  <th>发布单位</th>
  <th>发布时间</th>
  </tr>
  <s:iterator value="companyBaseList" var="companyBase">
  <tr>
    <td><a href="pub_showCompanyBaseinfo.action?id=${companyBase.id}" target="_blank">${companyBase.name}</a></td>
  <td></td>
  <td><s:date name="#companyBase.registerTime" format="yyyy-MM-dd" /></td>
  </tr>
  </s:iterator>
  </table> 
   </div>

      <div id="gongx_3_body" style="display:none;">
       <table cellpadding="0" cellspacing="0" class="table_list">
		  <tr>
		  <th>姓名</th>
		  <th>发布单位</th>
		  <th>发布时间</th>
		  </tr>
		  <s:iterator value="personBaseList" var="personBase">
		  <tr>
		    <td><a href="pub_showPersonBaseinfo.action?title=${personBase.code}" target="_blank">${personBase.name}</a></td>
		  <td></td>
		  <td><s:date name="#personBase.registerTime" format="yyyy-MM-dd" /></td>
		  </tr>
		  </s:iterator>
		  </table> 
      </div>
      <div id="gongx_4_body" style="display:none;">
        <table cellpadding="0" cellspacing="0" class="table_list">
  <tr>
    <th>资质证书号</th>
  <th>资质等级名称</th>
  <th>发布单位</th>
  <th>发布时间</th>
  </tr>
  <s:iterator value="companyQualificationList" var="companyQ">
  <tr>
  <td>${companyQ.code}</td>
    <td><a href="pub_showCompanyQualificationList.action?id=${companyQ.id}" target="_blank">${companyQ.name}</a></td>
  <td>${companyQ.site.name}</td>
  <td><s:date name="#companyQ.auditDate" format="yyyy-MM-dd" /></td>
  </tr>
  </s:iterator>
  </table>  
      </div>
      <div id="gongx_5_body" style="display:none;">
        <table cellpadding="0" cellspacing="0" class="table_list">
  <tr>
    <th>资质证书号</th>
  <th>资质等级名称</th>
  <th>发布单位</th>
  <th>发布时间</th>
  </tr>
  <s:iterator value="personQualificationList" var="personQ">
  <tr>
  <td>${personQ.code}</td>
    <td><a href="pub_showPersonQualificationList.action?id=${personQ.id}" target="_blank">${personQ.name}</a></td>
  <td>${personQ.site.name}</td>
  <td><s:date name="#personQ.auditDate" format="yyyy-MM-dd" /></td>
  </tr>
  </s:iterator>
  </table>  
      </div>
   </div>
   
   <div class="Tab_Blue">
   <span class="span_more"><a href="pub_navCreditPublic.action?message=5&title=5"> > 更多</a></span>
 
      <div class="Tab_Blue_focus" id="xyong_1_hander" onclick="javascript:SelectTab('xyong', 2, 1);">
    	<div class="L"></div>
        <div class="C">单位不良行为信息</div>
        <div class="R"></div>  
      </div>
      <div class="Tab_Blue_blur" id="xyong_2_hander" onclick="javascript:SelectTab('xyong', 2, 2);">
    	<div class="L"></div>
        <div class="C">单位良好行为信息</div>
        <div class="R"></div>  
      </div>
   </div>
   <div>
<div id="xyong_1_body" style="display:block; " >
 <table cellpadding="0" cellspacing="0" class="table_list">
  <tr>
  <th colspan="2" width="30%">单位名称</th>
  <th>不良行为类型</th>
  <th>发布单位</th>
  <th>发布时间</th>
  </tr>
  <s:iterator value="companyBadrecordList" var="companyBadrecord">
  <tr>
  <td width="2"><img src="images/index/point.gif" /></td>
  <td><a href="pub_showCompanyBadrecord.action?id=${companyBadrecord.id}" target="_blank">${companyBadrecord.company.name }</a></td>
  <td>
	<s:if test="#companyBadrecord.type == 1">单位违法信息</s:if>
	<s:elseif test="#companyBadrecord.type == 2">单位行政处罚信息</s:elseif>
	<s:elseif test="#companyBadrecord.type == 3">单位行政强制信息</s:elseif>
	<s:elseif test="#companyBadrecord.type == 4">单位行政裁决信息</s:elseif>
	<s:elseif test="#companyBadrecord.type == 5">单位欠薪及欠缴社保金信息</s:elseif>
	<s:else>test</s:else>
  </td>
  <td>${companyBadrecord.site.name}</td>
  <td>
  	<s:date name="#companyBadrecord.recordTime" format="yyyy-MM-dd" />
  </td>
  </tr>
  </s:iterator>
 </table>
</div><!--tab66 DIV-->

<div id="xyong_2_body" style="display: none; " >
 <table cellpadding="0" cellspacing="0" class="table_list">
  <tr>
     <th colspan="2">单位名称</th>
  <th>荣誉内容</th>
     <th width="182">发布单位</th>
  	 <th width="115">发布时间</th>
  </tr>
 <s:iterator value="companyHonorList" var="companyHonor">
  <tr>
      <td width="11"><img src="images/index/point.gif" /></td>
	  <td ><a href="pub_showCompanyHonor.action?id=${companyHonor.id}" target="_blank">${companyHonor.company.name }</a></td>
	  <td>${companyHonor.honorContent }</td>
	  <td>${companyHonor.site.name }</td>
	  <td><s:date name="#companyHonor.honorDate" format="yyyy-MM-dd" /></td>
  </tr>
 </s:iterator>
 </table>
  </div><!--tab77 DIV-->
    </div>
      
 <div class="Tab_Blue">
      <div class="Tab_Blue_focus" id="dangan_1_hander" onclick="javascript:SelectTab('dangan', 2, 1);">
    	<div class="L"></div>
        <div class="C">从业单位诚信档案</div>
        <div class="R"></div>  
      </div>
      <div class="Tab_Blue_blur" id="dangan_2_hander" onclick="javascript:SelectTab('dangan', 2, 2);">
    	<div class="L"></div>
        <div class="C">从业个人诚信档案</div>
        <div class="R"></div>  
      </div>
      <div class="right_link">
      <div class="search2">
  <div class="search_bg2">
  <div class="search_title2">快速搜索</div>
    <form action="pub_searchAll.action" method="post" id="searchForm2">
  <div class="search_text2">
   <select class="select_txt2" name="id" id="id2">
		<option value="7" selected="selected">从业单位诚信档案</option>
		<option value="8">从业个人诚信档案</option>
   </select>
   <input  type="text" class="search_input2" id="title2"  name="title"  value="" onclick="clearText('title2')"/>
   
		<a href="javascript:searchForm2.submit()"><img src="imgage/search2_1.gif" /></a> 
   </div>
   </form>
 </div>
 </div>
      
      
      </div>
      </div>
   <div>
<div id="dangan_1_body" style="display:block;" >
  <table cellpadding="0" cellspacing="0" class="table_list">
  <tr>
  <th >单位名称</th>
  <th>发布单位</th>
  <th>发布时间</th>
  </tr>
  <s:iterator value="companyList" var="com">
  <tr>
  <!--<li><a href="credit/companyInfo_uploadCreditPage.action">上传诚信档案</a></li> td><a href="pub_showCompanyApprove.action?id=${com.id}" target="_blank">${com.name }</a></td>-->
  <td><a href="javascript:add('1','${com.id}')">${com.name }</a></td> 
  <td></td>
  <td><s:date name="#com.registerTime" format="yyyy-MM-dd" /></td>
  </tr>
  </s:iterator>
  </table>
</div>
<div id="dangan_2_body" style="display:none;" >
  <table cellpadding="0" cellspacing="0" class="table_list">
  <tr>
    <th colspan="2">姓名</th>
  <th>所属单位</th>
  <th>发布单位</th>
  <th>发布时间</th>
  </tr>
  <s:iterator value="personList" var="per">
  <tr>
    <td width="2"><img src="images/index/point.gif" /></td>
  <!--td><a href="pub_showPersonApprove.action?id=${per.id}" target="_blank">${per.name }</a></td-->
  <td><a href="javascript:add('2','${per.id}')">${per.name }</a></td>
  <td>${per.dept }</td>
  <td></td>
  <td><s:date name="#per.registerTime" format="yyyy-MM-dd" /></td>
  </tr>
  </s:iterator>
  </table>
</div>
   </div>
 <div class="Tab_Blue">
   <span class="span_more"><a href="pub_navCreditPublic.action?message=5&title=6"> > 更多</a></span>
      <div class="Tab_Blue_focus" id="dianxing_1_hander" >
    	<div class="L"></div>
        <div class="C">${title }</div>
        <div class="R"></div>  
      </div>
      </div>
   <div>
      <div id="dianxing_1_body" style="display:block;" >
        <table border="0" cellpadding="0" cellspacing="0"  class="tabletwo">
         <tr>

		<s:iterator value="typicalList" var="typeList" status="status">
			<td width="50%" valign="top">
			<table cellpadding="0" cellspacing="0" class="table_list" >
				<tr>
					<th>${typeList.title }</th>
				</tr>
				<s:if test="#status.count == 1">
					<s:iterator value="typicalList0" var="typeList0" status="statust">
					
						<s:if test="#statust.count == 10">
						<tr>
							<td style="border-bottom:none;" ><a href="pub_showNews.action?id=${typeList0.id }"
								target="_blank">${util:limitText(typeList0.title, 20) }</a></td>
						</tr>
						</s:if>
						<s:else>
						<tr>
							<td><a href="pub_showNews.action?id=${typeList0.id }"
								target="_blank">${util:limitText(typeList0.title, 20) }</a></td>
						</tr>
						</s:else>
					</s:iterator>
					
				</s:if>
				<s:else>
					<s:iterator value="typicalList1" var="typeList1" status="statust2">
						<s:if test="#statust2.count == 10">
						<tr>
							<td style="border-bottom:none;"><a href="pub_showNews.action?id=${typeList1.id }"
								target="_blank">${util:limitText(typeList1.title, 20) }</a></td>
						</tr>
						</s:if>
						<s:else>
						<tr>
							<td><a href="pub_showNews.action?id=${typeList1.id }"
								target="_blank">${util:limitText(typeList1.title, 20) }</a></td>
						</tr>
						</s:else>
					</s:iterator>
				</s:else>
			</table>
			</td>
				<s:if test="#status.count == 1"><td class="td_border"></td></s:if>
		
		</s:iterator>

	</tr>
        </table>
        
      </div>
   </div>
</div><!--open_text-->

<div class="open_news_btm"></div>

</div><!--open news-->
 </div> <!--right_middle-->       
</div><!--middle DIV-->
 
 <div class="bottom">
${session.homePage.footer }
</div> <!--bottom DIV-->
   </div><!--content DIV-->
  <brady:message />  
  <brady:dialog title="信用档案查询" onClickOK="doSave()" width="650" height="340"/>
  <brady:confirm />
</body>
</html>
