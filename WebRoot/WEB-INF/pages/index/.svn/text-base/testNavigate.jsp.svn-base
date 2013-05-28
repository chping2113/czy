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
    

  <s:if test="session.session_site.type==0" >
  <s:iterator value="#allNavigateList" var="allNavigate" status="statusb" >
  <div class="sheng">
  <div class="sheng_top"></div>
  <div class="sheng_text">
   <div class="sheng_title">${allNavigate.name }</div>
  <table border="0" cellpadding="0" cellspacing="0" class="sheng_table">
 
  <c:forEach items="${smailList[statusb.count-1]}" step="3" varStatus="status">
  <tr>
  <td>
  		<a href="${smailList[statusb.count-1][status.index].url}" title="${smailList[statusb.count-1][status.index].name}" target="_blank">${util:limitText(smailList[statusb.count-1][status.index].name, 4) }</a>
  	
  </td>
  <td>
  		<a href="${smailList[statusb.count-1][status.index+1].url }" title="${smailList[statusb.count-1][status.index+1].name}" target="_blank">${util:limitText(smailList[statusb.count-1][status.index+1].name, 4) }</a>
  	
  </td>
  <td>
  		<a href="${smailList[statusb.count-1][status.index+2].url }" title="${smailList[statusb.count-1][status.index+2].name }" target="_blank">${util:limitText(smailList[statusb.count-1][status.index+2].name, 4) }</a>
  	
  </td>
  </tr>
  </c:forEach>
</table>
</div>
  <div class="sheng_btm"></div>
 </div><!--sheng-->
  
  </s:iterator>
  </s:if>
  <s:else>
  
  
 <div class="sheng">
  <div class="sheng_top"></div>
  <div class="sheng_text">
  <div class="sheng_title"><img src="imgage/shen.jpg" /></div>
  <table border="0" cellpadding="0" cellspacing="0" class="sheng_table">

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
</table>
</div>
  <div class="sheng_btm"></div>
 </div><!--sheng-->
  
  
  <div class="sheng">
 <div class="sheng_top"></div>
  <div class="sheng_text">
  <div class="sheng_title"><img src="imgage/shi.jpg" /></div>
  <table border="0" cellpadding="0" cellspacing="0" class="sheng_table">
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
 
  
  
  
  </s:else>
  

 


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
