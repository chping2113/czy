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
<title>安徽省中小企业公共信息服务平台</title>

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
<script type="text/javascript" src="js/verifyCode.js"></script>
<script type="text/javascript"> 


var flag=0 ;
var param = {"searchOrganCode":"${searchOrganCode}"};
var c=0; //第i+1个tab开始
var offset = 3000; //轮换时间
var timer = null;	
function SelectTab(keyword, count, index){
	var i=1;
	for(i=1; i<=count; i++){
		if(i == index){
			c=i;
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
function SelectTabProject(keyword, count, index){
	$("#tba_project_body").html("<div style='height:295px;height:300px\9;'> <table cellpadding='0' cellspacing='0' class='table_list' height='100%' width='100%'><tr rowspan='10'><td colspan='4' align='center'><img src='images/initload.gif'/></td></tr></table></div>");
	var approve="${homePage.approve}";
	var coustruct="${homePage.construct}";
	var land="${homePage.land}";
	var aim="${homePage.aim}";
	var url="pub_ajaxProjectApprove.action";
	if(index==approve){
		url="pub_ajaxProjectApprove.action";
	}else if(index==coustruct){
		url="pub_ajaxProjectConstruct.action";
	}else if(index==land){
		url="pub_ajaxProjectLand.action";
	}else if(index==aim){
		url="pub_ajaxProjectAim.action";
	}
	$.post(url, param, function(date) {
		$("#tba_project_body").html(date);
	});
	var i=1;
	for(i=1; i<=count; i++){
		if(i == index){
				document.getElementById(keyword + "_" + i +"_hander").className="Tab_Blue_focus";
		}else{
			if(document.getElementById(keyword + "_" + i +"_hander")!=null){
				document.getElementById(keyword + "_" + i +"_hander").className="Tab_Blue_blur";
			}
		}
	}
}
function SelectTabCredit1(url,count,index){
	$("#gongx_credit_body").html("<div style='height:295px;height:300px\9;'> <table cellpadding='0' cellspacing='0' class='table_list' height='100%' width='100%'><tr rowspan='10'><td colspan='4' align='center'><img src='images/initload.gif'/></td></tr></table></div>");
	$.post(url, param, function(date) {
		$("#gongx_credit_body").html(date);
	});
	var i=1;
	for(i=1; i<=count; i++){
		if(i == index){
			document.getElementById( "gongx_" + i +"_hander").className="Tab_Blue_focus";
		}else{
			if(document.getElementById( "gongx_" + i +"_hander")!=null){
				document.getElementById( "gongx_" + i +"_hander").className="Tab_Blue_blur";
			}
		}
	}
}
function SelectTabCredit2(url,count,index){
	$("#xyong_credit_body").html("<div style='height:295px;height:300px\9;'> <table cellpadding='0' cellspacing='0' class='table_list' height='100%' width='100%'><tr rowspan='10'><td colspan='4' align='center'><img src='images/initload.gif'/></td></tr></table></div>");
	$.post(url, param, function(date) {
		$("#xyong_credit_body").html(date);
	});
	var i=1;
	for(i=1; i<=count; i++){
		if(i == index){
			document.getElementById( "xyong_" + i +"_hander").className="Tab_Blue_focus";
		}else{
			if(document.getElementById( "xyong_" + i +"_hander")!=null){
				document.getElementById( "xyong_" + i +"_hander").className="Tab_Blue_blur";
			}
		}
	}
}

function SelectTabCredit3(url,count,index){
	$("#dangan_credit_body").html("<div style='height:295px;height:300px\9;'> <table cellpadding='0' cellspacing='0' class='table_list' height='100%' width='100%'><tr rowspan='10'><td colspan='4' align='center'><img src='images/initload.gif'/></td></tr></table></div>");
	$.post(url, param, function(date) {
		$("#dangan_credit_body").html(date);
	});
	var i=1;
	for(i=1; i<=count; i++){
		if(i == index){
			document.getElementById( "dangan_" + i +"_hander").className="Tab_Blue_focus";
		}else{
			if(document.getElementById( "dangan_" + i +"_hander")!=null){
				document.getElementById( "dangan_" + i +"_hander").className="Tab_Blue_blur";
			}
		}
	}
}
function SelectTab2(keyword, index){
	document.getElementById(keyword + "_" + index +"_hander").className="Tab_Blue_focus";
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
		
		var count=${count};
		var n=5;//共有n个tab
		var approve="${homePage.approve}";
		var coustruct="${homePage.construct}";
		var land="${homePage.land}";
		var mining="${homePage.mining}";
		var aim="${homePage.aim}";	
		$(document).ready(function(){
			var sitecode="${session.session_site.code}";
			if(sitecode=="340000000"){
				
				ajaxDataCount();
			}
			if(count>1){
				autoroll();
				hookThumb();
			}
			
		});
		function ajaxDataCount(){
			$("#dataCount_body").html("<div style='height:225px;height:300px\9;'> <table cellpadding='0' cellspacing='0' class='table_list' height='100%' width='100%'><tr rowspan='10'><td colspan='4' align='center'><img src='images/initload.gif'/></td></tr></table></div>");
			$.post("pub_ajaxDataCount.action", "", function(date) {

				
				$("#dataCount_body").html(date);
			});
		}
		function autoroll(){
			c++;
			if(approve!=c && coustruct!=c && land!=c && aim!=c && mining!=c){
				c++;
				if(approve!=c && coustruct!=c && land!=c && aim!=c && mining!=c){
					c++;

					if(approve!=c && coustruct!=c && land!=c && aim!=c && mining!=c){
						c++;
					}
				}
			}
			if(c > n){
				c = 1;
			}
			SelectTab('tba', 5, c);
			timer = window.setTimeout(autoroll, offset);
		}
		function hookThumb(){
			$("#tba_1_body").hover(
			  function () {
			    if (timer) {
			    	clearTimeout(timer);
			    }
			  },
			  function () {
			     timer = window.setTimeout(autoroll, offset);  
			     this.blur();            
			     return false;
			  }
			); 
			$("#tba_2_body").hover(
					  function () {
						    if (timer) {
						    	clearTimeout(timer);
						    }
						  },
						  function () {
						     timer = window.setTimeout(autoroll, offset);  
						     this.blur();            
						     return false;
						  }
						); 
			$("#tba_3_body").hover(
					  function () {
					    if (timer) {
					    	clearTimeout(timer);
					    }
					  },
					  function () {
					     timer = window.setTimeout(autoroll, offset);  
					     this.blur();            
					     return false;
					  }
					); 
			$("#tba_4_body").hover(
					  function () {
					    if (timer) {
					    	clearTimeout(timer);
					    }
					  },
					  function () {
					     timer = window.setTimeout(autoroll, offset);  
					     this.blur();            
					     return false;
					  }
					); 
			$("#tba_5_body").hover(
					  function () {
					    if (timer) {
					    	clearTimeout(timer);
					    }
					  },
					  function () {
					     timer = window.setTimeout(autoroll, offset);  
					     this.blur();            
					     return false;
					  }
					); 
}
</script>
</head>

<body>

<div class="content">
  <%session.setAttribute( "headPath", request.getServletPath().substring(0,request.getServletPath().lastIndexOf('/')+1)+"templateHead.jsp");%>
  <%@ include file="templateHead.jsp"%>
  <div class="middle">
  
    <div class="left_middle">

    <div class="news">
      <div class="news_top"><span class="span_more"><a href="pub_listNewsByCatelogId.action?catelogId=18&message=3"> 更多</a></span></div>
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
    	<li><span><s:date name="#nonImageNews.createTime" format="MM-dd" /></span><a href="pub_showNews.action?id=${nonImageNews.id}" title="${nonImageNews.title }" target="_blank">${util:limitText(nonImageNews.title, 26) }</a></li>
      </s:iterator>
      </ul>
      </div>
      <div class="news_text_btm"></div>
 </div> 
    
        <div class="news">
      <div class="message_top"><span class="span_more"><a href="pub_listMoreNotice.action?message=3">  更多</a></span></div>
      <div class="news_text">
      <div class="news_text_top"></div>
      <ul class="message_text_ul">
      <s:iterator value="#noticeList" var="notice">
      	<li><span><s:date name="#notice.createTime" format="MM-dd" /></span><a href="pub_showNotice.action?id=${notice.id }" title="${notice.title }" target="_blank">${util:limitText(notice.title, 26) }</a></li>
      </s:iterator>
      </ul>
      </div>
      <div class="news_text_btm"></div>
 </div>
    

<s:if test="session.session_site.code=='340000000'">
<s:iterator value="#allNavigateList" var="allNavigate" status="statusb" >
 <c:if test="${allNavigate.name!='<span>省直部门项目信息和信用</span><br />信息公开共享专栏'}">
  <div class="sheng">
  <div class="sheng_top"></div>
  <div class="sheng_text">
   <div class="sheng_title">${allNavigate.name }</div>
  <table border="0" cellpadding="0" cellspacing="0" class="sheng_table">
  <c:forEach items="${smailList[statusb.count-1]}" step="3" varStatus="status">
  <tr>
  <td>
  		<a href="${smailList[statusb.count-1][status.index].url}" title="${smailList[statusb.count-1][status.index].name}">${util:limitText(smailList[statusb.count-1][status.index].name, 8) }</a>
  </td>
  <td>
  		<a href="${smailList[statusb.count-1][status.index+1].url }" title="${smailList[statusb.count-1][status.index+1].name}">${util:limitText(smailList[statusb.count-1][status.index+1].name, 8) }</a>
  </td>
  <td>
  		<a href="${smailList[statusb.count-1][status.index+2].url }" title="${smailList[statusb.count-1][status.index+2].name }">${util:limitText(smailList[statusb.count-1][status.index+2].name, 8) }</a>
  </td>
  </tr>
  </c:forEach>
</table>
</div>
  <div class="sheng_btm"></div>
 </div><!--sheng-->
 </c:if>
</s:iterator>
</s:if>
<s:if test="session.session_site.code!='340000000'">
<s:iterator value="#allNavigateList" var="allNavigate" status="statusb" >
 <c:if test="${allNavigate.name!='<span>市属企事业单位项目信息和</span><br />信用信息公开共享专栏'}">
  <div class="sheng">
  <div class="sheng_top"></div>
  <div class="sheng_text">
   <div class="sheng_title">${allNavigate.name }</div>
  <table border="0" cellpadding="0" cellspacing="0" class="sheng_table">
  <c:forEach items="${smailList[statusb.count-1]}" step="3" varStatus="status">
  <tr>
  <td>
  		<a href="${smailList[statusb.count-1][status.index].url}" title="${smailList[statusb.count-1][status.index].name}">${util:limitText(smailList[statusb.count-1][status.index].name, 8) }</a>
  </td>
  <td>
  		<a href="${smailList[statusb.count-1][status.index+1].url }" title="${smailList[statusb.count-1][status.index+1].name}">${util:limitText(smailList[statusb.count-1][status.index+1].name, 8) }</a>
  </td>
  <td>
  		<a href="${smailList[statusb.count-1][status.index+2].url }" title="${smailList[statusb.count-1][status.index+2].name }">${util:limitText(smailList[statusb.count-1][status.index+2].name, 8) }</a>
  </td>
  </tr>
  </c:forEach>
</table>
</div>
  <div class="sheng_btm"></div>
 </div><!--sheng-->
 </c:if>
</s:iterator>
</s:if>
<!--  
<s:if test="session.session_site.code=='340000000'">
<div class="sheng">
  <div class="sheng_top"></div>
  <div class="sheng_text">
   <div class="sheng_title"><span>省属企事业单位项目信息和</span><br />信用信息公开共享专栏</div>
  <table border="0" cellpadding="0" cellspacing="0" class="sheng_table">
  <tr>
  <td colspan="3" height="30">
  		<a href="gk_340000027.action " ><b>省属企业专栏 </b></a>
  </td>
  </tr>
  <tr>
  <td>
  		<a href="gk_340000054.action " title="马钢集团 ">马钢集团 </a>
  </td>
  <td>
  		<a href="gk_340000059.action" title="淮南矿业集团 ">淮南矿业...</a>
  </td>
  <td>
  		<a href="gk_340000060.action " title="国元集团">国元集团</a>
  </td>
  </tr><tr>
  <td>
  		<a href="gk_340000065.action " title="华安证券公司">华安证券...</a>
  </td>
  <td>
  		<a href="gk_340000067.action " title="省交通集团">省交通集...</a>
  </td>
  <td>
  		<a href="gk_340000080.action " title="国贸集团">国贸集团</a>
  </td>
  </tr><tr >
  <td  colspan="3"  height="30">
  		<a href="gk_340000004.action" title="省属大学专栏 "><b>省属大学专栏</b> </a>
  </td>
  </tr><tr>
  <td>
  		<a href="gk_3400000100.action " title="安徽大学 ">安徽大学 </a>
  </td>
  <td>
  		<a href="gk_3400000101.action " title="安徽工业大学">安徽工业...</a>
  </td>
  <td>
  		<a href="gk_3400000102.action " title="安徽理工大学">安徽理工..</a>
  </td>
  </tr><tr>
  <td >
  		<a href="gk_3400000103.action " title="安徽农业大学 ">安徽农业... </a>
  </td>
  <td>
  		<a href="gk_3400000104.action " title="安徽医科大学">安徽医科...</a>
  </td>
  <td>
  		<a href="gk_3400000105.action " title="安徽师范大学 ">安徽师范...</a>
  </td>
  </tr><tr>
  <td  colspan="3"  height="30">
  		<a href="gk_340000023.action " title="省属医疗卫生单位专栏"><b>省属医疗卫生单位专栏 </b></a>
  </td>
  </tr><tr>
  <td>
  		<a href="gk_3400000201.action " title="安徽省立医院 ">安徽省立...</a>
  </td>
  <td>
  		<a href="gk_3400000207.action  " title="安徽省立友谊医院 ">安徽省立...</a>
  </td>
  <td>
  		<a href="gk_3400000204.action  " title="安徽省立儿童医院 ">安徽省立... </a>
  </td>
  </tr><tr>
  <td>
  		<a href="gk_3400000208.action  " title="安徽省肺科医院">安徽省肺...</a>
  </td>
  <td>
  		<a href="gk_3400000209.action " title="安徽中医学院第一附属 ">安徽中医...</a>
  </td>
  <td>
  		<a href="gk_3400000211.action  " title="蚌埠医学院一附院">蚌埠医学...</a>
  </td>
  </tr>
</table>
</div>
  <div class="sheng_btm"></div>
 </div>
 </s:if>-->



 <div class="left_images">
 <!--<s:if test="session.session_site.parent!=null">
 	<a href="gk_${session.session_site.parent.code}.action" style="text-decoration:none;cursor:hand" >
 	<s:if test="session.session_site.parent.code=='340000000'">
 	<div class="left_images_old">${session.session_site.parent.name}项目公开网</div>
 	</s:if>
 	<s:else>
 	<div class="left_images_other">${session.session_site.parent.name}工程建设领域项目信息和信用信息公开共享专栏平台</div>
 	</s:else>
 	</a>
 	<s:if test="session.session_site.parent.parent!=null">
 		<a href="gk_${session.session_site.parent.parent.code}.action"  style="text-decoration:none;cursor:hand" >
	 	<s:if test="session.session_site.parent.parent.code=='340000000'">
	 	<div class="left_images_old">${session.session_site.parent.parent.name}项目公开网</div>
	 	</s:if>
	 	<s:else>
	 	<div class="left_images_other">${session.session_site.parent.parent.name}工程建设领域项目信息和信用信息公开共享专栏平台</div>
	 	</s:else>
	 	</a>
	 	<s:if test="session.session_site.parent.parent.parent!=null">
	 		<a href="gk_${session.session_site.parent.parent.parent.code}.action"  style="text-decoration:none;cursor:hand" >
		 	<s:if test="session.session_site.parent.parent.parent.code=='340000000'">
		 	<div class="left_images_old">${session.session_site.parent.parent.parent.name}项目公开网</div>
		 	</s:if>
		 	<s:else>
		 	<div class="left_images_other">${session.session_site.parent.parent.parent.name}工程建设领域项目信息和信用信息公开共享专栏平台</div>
		 	</s:else>
		 	</a>
	 	</s:if>
 	</s:if>
 </s:if>-->
 <s:if test="session.session_site.parent!=null">
 	<a href="gk_${session.session_site.parent.code}.action" style="text-decoration:none;cursor:hand" >
 		<div class="left_images_other">${session.session_site.parent.name}工程建设领域项目信息和信用信息公开共享专栏</div>
 	</a>
 	<s:if test="session.session_site.parent.parent!=null">
 		<a href="gk_${session.session_site.parent.parent.code}.action"  style="text-decoration:none;cursor:hand" >
 			<div class="left_images_other">${session.session_site.parent.parent.name}工程建设领域项目信息和信用信息公开共享专栏</div>
 		</a>
 		<s:if test="session.session_site.parent.parent.parent!=null">
 			<a href="gk_${session.session_site.parent.parent.parent.code}.action"  style="text-decoration:none;cursor:hand" >
 				<div class="left_images_other">${session.session_site.parent.parent.parent.name}工程建设领域项目信息和信用信息公开共享专栏</div>
 			</a>
 		</s:if>
 	</s:if>
 </s:if>
 <a href="http://www.zzg.gov.cn/xmxx/xgyw/" target="_blank"><img src="imgage/gongchen.jpg" /></a>
 <a href="http://gc.cio360.org/index.html" target="_blank"><img src="imgage/search_all.jpg" /></a>
 <!-- <a href="#"><img src="imgage/zaixian.jpg" /></a> -->
 <a href="help/web/index-help.html" target="_blank"><img src="imgage/zinan.jpg" /></a>
 </div>  
<div class="tell">
      <div class="tell_bg">
      <div class="tell_nuber">${homePage.report }</div>
        <div class="tell_btn"><a href="pub_showComplaint.action?message=7" id="${message=='7'?'curTab':'' }"><img src="imgage/tell_btn1.jpg" /></a> </div>
      </div>
 </div> <!--div tell-->
    
    
     <!-- 快速登录 start      ------------屏蔽     系统后台管理---------------  快速登录 end -->  
     <div class="user">
     <form id="loginForm" action="pub_indexLogin.action" method="post">
     <!--
      <div class="user_top">
      <ul>
      <li><a href="#" id="curTab_select5" onClick="changeId5('curTab_select5',this,'#tab223'); return false;">项目建设单位</a></li>
      <li><a href="#" onClick="changeId5('curTab_select5',this,'#tab224'); return false;">从业单位/个人</a></li>
      <li><a href="#" onClick="changeId5('curTab_select5',this,'#tab225'); return false;">政府机关单位</a></li>
      </ul></div>
      
      <div id="tab223" style="display:block;" >
      <div class="user_text">
      <p>用户名
             <input name="code" id="code" type="text" class="user_text_input" />
      </p>
    <p>密<span>码</span>
             <input name="password" id="password" type="password" class="user_text_input"  onkeypress="changeKey(1)"/>
    </p>
     
    <p>验证码       
          <input type="text" height="20" name="rand"  id="input1" size="6" >  
          <img alt="code..." name="input" id="randImage1"  src="image.jsp" width="70" height="20" border="1" align="absmiddle">
          <a href="javascript:loadimage(1);" style="text-decoration:none"><font color="#30a4e7" >&nbsp;换一张</font></a>      
         </p>
       
       <p class="ahahubtn"><a href="pub_constructRegister.action" target="_blank"">项目建设单位注册</a></p>
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

	<p>验证码       
          <input type="text" height="20" name="rand"  id="input2" size="6" >  
          <img alt="code..." name="input" id="randImage2"  src="image.jsp" width="70" height="20" border="1" align="absmiddle">
          <a href="javascript:loadimage(2);" style="text-decoration:none"><font color="#30a4e7" >&nbsp;换一张</font></a>      
         </p>
         
          <p class="radio_p">类<span>型</span>
            <label><input type="radio" name="state2" value="1" id="RadioGroup_2" class="user_text_radio" checked="checked" onkeypress="changeKey(2)"/>从业单位</label>
            <label><input type="radio" name="state2" value="2" id="RadioGroup_3" class="user_text_radio" onkeypress="changeKey(2)"/>从业个人</label>
          </p>
      <p class="text_center"><a href="javascript:doSubmit(2)"><img src="imgage/login.gif" tabIndex=7/></a><span class="password"><a href="pub_showPassword.action">忘记密码？</a></span>  </p>
      </div>
     </div>
       -->
      
     <div id="tab225" style="display:block;" >
       <div class="user_text">
       <p >用户名
             <input name="code" id="code3" type="text" class="user_text_input" tabIndex=5/>
       </p>
     <p >密<span>码</span>
            <input name="password" id="password3" type="password" class="user_text_input" tabIndex=6 onkeypress="changeKey(2)"/>
     </p>
	<!--   <p>验证码       
          <input type="text" height="20" name="rand"  id="input3" size="6" >  
          <img alt="code..." name="input" id="randImage"  src="image.jsp" width="70" height="20" border="1" align="absmiddle">
          <a href="javascript:loadimage(0);" style="text-decoration:none"><font color="#30a4e7" >&nbsp;换一张</font></a>      
         </p>-->
      <p class="text_center"><a href="javascript:doSubmit(0)"><img src="imgage/login.gif" tabIndex=7/></a><span class="password"><a href="pub_showPassword.action">忘记密码？</a></span>  </p>
      </div>
     </div>
     </form>
     </div>
     <div class="user_btm"></div>
	     
    
 	
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
    <form action="pub_searchAll.action" method="post" id="searchForm" name="searchForm">
  <div class="search_text">
	   <select class="select_txt" id="id" name="id">
	    <s:iterator value="scolumnList" var="scolumnList" >
	    <option value="${scolumnList.name}">${scolumnList.name}</option>
	   </s:iterator>
	   <!-- 
	    <option value="1">通知公告</option>
		<option value="2">项目公开要闻</option>
		<option value="3" selected="selected">项目审批信息</option>
		<option value="4">项目建设管理信息</option>
		<option value="5">土地权审批出让信息</option>
		
		<option value="12">矿业权审批出让信息</option>
		<option value="11">招投标信息</option>
		<option value="6">从业单位信用评价信息</option>
		<option value="7">从业单位信用档案</option>
		<option value="8">从业个人信用档案</option>
		<option value="9">从业单位良好行为信息</option>
		<option value="10">从业单位不良行为信息</option>
		 -->
	   </select>
	   <input  type="text" class="search_input" id="title"  name="title"  value="请输入您要搜索的关键字......" onclick="clearText('title')"/>
	 <input  type="hidden" id="searchOrganCode" name="searchOrganCode" value="${searchOrganCode }"/>
	   
   		<a href="javascript:document.searchForm.submit()"><img src="imgage/search2.gif" /></a> 
	    </div>
	    </form>
 </div>
 </div>
<s:if test="#count!=0">
 <div class="open_news">
 <div class="open_news_top"><span class="span_more"><a href="pub_navProjectPublic.action?message=4&code=${session.session_site.code }">  更多</a></span></div>
 <div class="open_news_text">
   <div class="Tab_Blue">
  
 <s:if test="#homePage.approve==1 || #homePage.construct==1 || #homePage.land==1  || #homePage.aim==1 || #homePage.mining==1">
      <div class="Tab_Blue_focus" id="tba_1_hander" onclick="javascript:SelectTab('tba', 5, 1);">
    	<div class="L"></div>
        <div class="C">
        
        	<s:iterator value="list10" var="list10" >
        	<s:if test="#homePage.approve==1">${list10.title}</s:if>
			</s:iterator>
			<s:iterator value="list11" var="list11" >
        	<s:elseif test="#homePage.construct==1">${list11.title}</s:elseif>
			</s:iterator>
			<s:iterator value="list12" var="list12" >
        	<s:elseif test=" #homePage.land==1">${list12.title}</s:elseif>
			</s:iterator>
			<s:iterator value="list13" var="list13" >
        	<s:elseif test=" #homePage.mining==1">${list13.title}</s:elseif>
			</s:iterator>
			<s:iterator value="list14" var="list14" >
        	<s:elseif test=" #homePage.aim==1">${list14.title}</s:elseif>
			</s:iterator> 
        </div>
        <div class="R"></div>  
      </div>
      <script type="text/javascript">flag = 1;</script>
   </s:if>
  
   <s:if test="#homePage.approve==2 || #homePage.construct==2 || #homePage.land==2  || #homePage.aim==2 || #homePage.mining==2">
      <div class="Tab_Blue_blur" id="tba_2_hander" onclick="javascript:SelectTab('tba', 5, 2);">
    	<div class="L"></div>
        <div class="C">
        	<s:iterator value="list10" var="list10" >
        	<s:if test="#homePage.approve==2">${list10.title}</s:if>
			</s:iterator>
			<s:iterator value="list11" var="list11" >
        	<s:elseif test="#homePage.construct==2">${list11.title}</s:elseif>
			</s:iterator>
			<s:iterator value="list12" var="list12" >
        	<s:elseif test=" #homePage.land==2">${list12.title}</s:elseif>
			</s:iterator>
			<s:iterator value="list13" var="list13" >
        	<s:elseif test=" #homePage.mining==2">${list13.title}</s:elseif>
			</s:iterator>
			<s:iterator value="list14" var="list14" >
        	<s:elseif test=" #homePage.aim==2">${list14.title}</s:elseif>
			</s:iterator> 
        </div>
        <div class="R"></div>  
      </div>
      <script type="text/javascript">if(flag==0)flag=2;</script>
   </s:if>
   <s:if test="#homePage.approve==3 || #homePage.construct==3 || #homePage.land==3 || #homePage.aim==3 || #homePage.mining==3">
      <div class="Tab_Blue_blur" id="tba_3_hander" onclick="javascript:SelectTab('tba', 5, 3);">
    	<div class="L"></div>
        <div class="C">
        	<s:iterator value="list10" var="list10" >
        	<s:if test="#homePage.approve==3">${list10.title}</s:if>
			</s:iterator>
			<s:iterator value="list11" var="list11" >
        	<s:elseif test="#homePage.construct==3">${list11.title}</s:elseif>
			</s:iterator>
			<s:iterator value="list12" var="list12" >
        	<s:elseif test=" #homePage.land==3">${list12.title}</s:elseif>
			</s:iterator>
			<s:iterator value="list13" var="list13" >
        	<s:elseif test=" #homePage.mining==3">${list13.title}</s:elseif>
			</s:iterator>
			<s:iterator value="list14" var="list14" >
        	<s:elseif test=" #homePage.aim==3">${list14.title}</s:elseif>
			</s:iterator> 
        </div>
        <div class="R"></div>  
      </div>
      <script type="text/javascript">if(flag==0)flag=3;</script>
   </s:if>
   <s:if test="#homePage.approve==4 || #homePage.construct==4 || #homePage.land==4 || #homePage.aim==4 || #homePage.mining==4">
      <div class="Tab_Blue_blur" id="tba_4_hander" onclick="javascript:SelectTab('tba', 5, 4);">
    	<div class="L"></div>
        <div class="C">
        	<s:iterator value="list10" var="list10" >
        	<s:if test="#homePage.approve==4">${list10.title}</s:if>
			</s:iterator>
			<s:iterator value="list11" var="list11" >
        	<s:elseif test="#homePage.construct==4">${list11.title}</s:elseif>
			</s:iterator>
			<s:iterator value="list12" var="list12" >
        	<s:elseif test=" #homePage.land==4">${list12.title}</s:elseif>
			</s:iterator>
			<s:iterator value="list13" var="list13" >
        	<s:elseif test=" #homePage.mining==4">${list13.title}</s:elseif>
			</s:iterator>
			<s:iterator value="list14" var="list14" >
        	<s:elseif test=" #homePage.aim==4">${list14.title}</s:elseif>
			</s:iterator> 
        </div>
        <div class="R"></div>  
      </div>
      <script type="text/javascript">if(flag==0)flag=4;</script>
   </s:if>
   <s:if test="#homePage.approve==5 || #homePage.construct==5 || #homePage.land==5 || #homePage.aim==5 || #homePage.mining==5">
      <div class="Tab_Blue_blur" id="tba_5_hander" onclick="javascript:SelectTab('tba', 5, 5);">
    	<div class="L"></div>
        <div class="C">
        	<s:iterator value="list10" var="list10" >
        	<s:if test="#homePage.approve==5">${list10.title}</s:if>
			</s:iterator>
			<s:iterator value="list11" var="list11" >
        	<s:elseif test="#homePage.construct==5">${list11.title}</s:elseif>
			</s:iterator>
			<s:iterator value="list12" var="list12" >
        	<s:elseif test=" #homePage.land==5">${list12.title}</s:elseif>
			</s:iterator>
			<s:iterator value="list13" var="list13" >
        	<s:elseif test=" #homePage.mining==5">${list13.title}</s:elseif>
			</s:iterator>
			<s:iterator value="list14" var="list14" >
        	<s:elseif test=" #homePage.aim==5">${list14.title}</s:elseif>
			</s:iterator> 
        </div>
        <div class="R"></div>  
      </div>
      <script type="text/javascript">if(flag==0)flag=5;</script>
   </s:if> 
   </div>
   <div>
   
  <div id="tba_1_body" style="display:block;" >
  <table cellpadding="0" cellspacing="0" class="table_list">
  <tr>
  <th width="33%">项目编码</th>
  <th  width="33%">项目名称</th>
  <th  width="20%">发布单位</th>
  <th  width="14%">发布时间</th>
  </tr>
  </table>
  <table cellpadding="0" cellspacing="0" class="table_list">
  <s:if test="#homePage.approve==1">
  <s:iterator value="projectApproveDetailList" var="pd" status="status1">
  
  		<s:if test="#status1.last == false">
  <tr>
  <td  width="33%"><a href="pub_showProjectApprove.action?id=${pd.projectApprove.id}&title=1" target="_blank">${util:limitText(pd.projectApprove.code,30) }</a></td>
  <td width="33%">${util:limitText(pd.projectApprove.name,30) }</td>
  <td width="20%">${util:limitText(pd.site.name,20) }</td>
  <td width="14%"><s:date name="#pd.createTime" format="yyyy-MM-dd" /></td>
  </tr>
  		</s:if>
  		<s:else>
  <tr>
  <td width="33%"  style="border-bottom:none;" ><a href="pub_showProjectApprove.action?id=${pd.projectApprove.id}&title=1" target="_blank">${util:limitText(pd.projectApprove.code,30) }</a></td>
  <td width="33%"  style="border-bottom:none;" >${util:limitText(pd.projectApprove.name,30) }</td>
  <td width="20%" style="border-bottom:none;" >${util:limitText(pd.site.name,20) }</td>
  <td width="14%" style="border-bottom:none;" ><s:date name="#pd.createTime" format="yyyy-MM-dd" /></td>
  </tr>
  		</s:else>
  </s:iterator>
  </s:if>
  
  <s:if test="#homePage.construct==1">
  <s:iterator value="projectConstructList" var="projectConstruct" status="status1">
  		<s:if test="#status1.last == false">
  <tr>
  <td width="33%"><a href="pub_showProjectConstruct.action?id=${projectConstruct.id}&title=1" target="_blank">${util:limitText(projectConstruct.code,30) }</a></td>
  <td width="33%">${util:limitText(projectConstruct.name,30) }</td>
  <td width="20%">${util:limitText(projectConstruct.site.name,20) }</td>
  <td width="14%"><s:date name="#projectConstruct.createTime" format="yyyy-MM-dd" /></td>
  </tr>
  		</s:if>
  		<s:else>
  <tr>
  <td width="33%" style="border-bottom:none;"><a href="pub_showProjectConstruct.action?id=${projectConstruct.id}&title=1" target="_blank">${util:limitText(projectConstruct.code,30) }</a></td>
  <td width="33%" style="border-bottom:none;">${util:limitText(projectConstruct.name,30) }</td>
  <td width="20%" style="border-bottom:none;">${util:limitText(projectConstruct.site.name,20) }</td>
  <td width="14%" style="border-bottom:none;"><s:date name="#projectConstruct.createTime" format="yyyy-MM-dd" /></td>
  </tr>
  		</s:else>
  </s:iterator>
  </s:if>
  
  <s:if test="#homePage.land==1">
   <s:iterator value="projectLandList" var="projectLand" status="status1">
  <s:if test="#status1.last == false">
  <tr>
  <td width="33%"><a href="pub_showProjectLand.action?id=${projectLand.id}" target="_blank">${util:limitText(projectLand.code,30) }</a></td>
  <td width="33%">${util:limitText(projectLand.name,30) }</td>
  <td width="20%">${util:limitText(projectLand.site.name,20) }</td>
  <td width="14%"><s:date name="#projectLand.createTime" format="yyyy-MM-dd" /></td>
  </tr>
  </s:if>
  <s:else>
  <tr>
  <td width="33%" style="border-bottom:none;"><a href="pub_showProjectLand.action?id=${projectLand.id}" target="_blank">${util:limitText(projectLand.code,30) }</a></td>
  <td width="33%" style="border-bottom:none;">${util:limitText(projectLand.name,30) }</td>
  <td width="20%" style="border-bottom:none;">${util:limitText(projectLand.site.name,20) }</td>
  <td width="14%" style="border-bottom:none;"><s:date name="#projectLand.createTime" format="yyyy-MM-dd" /></td>
  </tr>
  </s:else>
  
  </s:iterator>
  </s:if>
  
   
  <s:if test="#homePage.mining==1">
   <s:iterator value="projectMiningList" var="projectMining" status="status1">
  <s:if test="#status1.last == false">
  <tr>
  <td width="33%"><a href="pub_showProjectMining.action?id=${projectMining.id}" target="_blank">${util:limitText(projectMining.code,30) }</a></td>
  <td width="33%">${util:limitText(projectMining.name,30) }</td>
  <td width="20%">${util:limitText(projectMining.site.name,20) }</td>
  <td width="14%"><s:date name="#projectMining.createTime" format="yyyy-MM-dd" /></td>
  </tr>
  </s:if>
  <s:else>
  <tr>
  <td width="33%" style="border-bottom:none;"><a href="pub_showProjectMining.action?id=${projectMining.id}" target="_blank">${util:limitText(projectMining.code,30) }</a></td>
  <td width="33%" style="border-bottom:none;">${util:limitText(projectMining.name,30) }</td>
  <td width="20%" style="border-bottom:none;">${util:limitText(projectMining.site.name,20) }</td>
  <td width="14%" style="border-bottom:none;"><s:date name="#projectMining.createTime" format="yyyy-MM-dd" /></td>
  </tr>
  </s:else>
  
  </s:iterator>
  </s:if>
  
    <s:if test="#homePage.aim==1">
<s:iterator value="projectAimList" var="projectAim" status="status1">
  		<s:if test="#status1.last == false">
  <tr>
  <td width="33%"><a href="pub_showProjectAim.action?id=${projectAim.id}" target="_blank">${util:limitText(projectAim.code,30) }</a></td>
  <td width="33%">${util:limitText(projectAim.name,30) }</td>
  <td width="20%">${util:limitText(projectAim.site.name,20) }</td>
  <td width="14%"><s:date name="#projectAim.createTime" format="yyyy-MM-dd" /></td>
  </tr>
  		</s:if>
  		<s:else>
  <tr>
  <td width="33%" style="border-bottom:none;"><a href="pub_showProjectAim.action?id=${projectAim.id}" target="_blank">${util:limitText(projectAim.code,30) }</a></td>
  <td width="33%" style="border-bottom:none;">${util:limitText(projectAim.name,30) }</td>
  <td width="20%" style="border-bottom:none;">${util:limitText(projectAim.site.name,20) }</td>
  <td width="14%" style="border-bottom:none;"><s:date name="#projectAim.createTime" format="yyyy-MM-dd" /></td>
  </tr>
  		</s:else>
  </s:iterator>
  </s:if>
  
  </table>
</div>



  <div id="tba_2_body" style="display:none;" >
  <table cellpadding="0" cellspacing="0" class="table_list">
  <tr>
  <th width="33%">项目编码</th>
  <th  width="33%">项目名称</th>
  <th  width="20%">发布单位</th>
  <th  width="14%">发布时间</th>
  </tr>
  </table>
  <table cellpadding="0" cellspacing="0" class="table_list">
  <s:if test="#homePage.approve==2">
  <s:iterator value="projectApproveDetailList" var="pd" status="status1">
  
  		<s:if test="#status1.last == false">
  <tr>
  <td  width="33%"><a href="pub_showProjectApprove.action?id=${pd.projectApprove.id}&title=1" target="_blank">${util:limitText(pd.projectApprove.code,30) }</a></td>
  <td width="33%">${util:limitText(pd.projectApprove.name,30) }</td>
  <td width="20%">${util:limitText(pd.site.name,20) }</td>
  <td width="14%"><s:date name="#pd.createTime" format="yyyy-MM-dd" /></td>
  </tr>
  		</s:if>
  		<s:else>
  <tr>
  <td width="33%"  style="border-bottom:none;" ><a href="pub_showProjectApprove.action?id=${pd.projectApprove.id}&title=1" target="_blank">${util:limitText(pd.projectApprove.code,30) }</a></td>
  <td width="33%"  style="border-bottom:none;" >${util:limitText(pd.projectApprove.name,30) }</td>
  <td width="20%" style="border-bottom:none;" >${util:limitText(pd.site.name,20) }</td>
  <td width="14%" style="border-bottom:none;" ><s:date name="#pd.createTime" format="yyyy-MM-dd" /></td>
  </tr>
  		</s:else>
  </s:iterator>
  </s:if>
  
  <s:if test="#homePage.construct==2">
  <s:iterator value="projectConstructList" var="projectConstruct" status="status1">
  		<s:if test="#status1.last == false">
  <tr>
  <td width="33%"><a href="pub_showProjectConstruct.action?id=${projectConstruct.id}&title=1" target="_blank">${util:limitText(projectConstruct.code,30) }</a></td>
  <td width="33%">${util:limitText(projectConstruct.name,30) }</td>
  <td width="20%">${util:limitText(projectConstruct.site.name,20) }</td>
  <td width="14%"><s:date name="#projectConstruct.createTime" format="yyyy-MM-dd" /></td>
  </tr>
  		</s:if>
  		<s:else>
  <tr>
  <td width="33%" style="border-bottom:none;"><a href="pub_showProjectConstruct.action?id=${projectConstruct.id}&title=1" target="_blank">${util:limitText(projectConstruct.code,30) }</a></td>
  <td width="33%" style="border-bottom:none;">${util:limitText(projectConstruct.name,30) }</td>
  <td width="20%" style="border-bottom:none;">${util:limitText(projectConstruct.site.name,20) }</td>
  <td width="14%" style="border-bottom:none;"><s:date name="#projectConstruct.createTime" format="yyyy-MM-dd" /></td>
  </tr>
  		</s:else>
  </s:iterator>
  </s:if>
  
  <s:if test="#homePage.land==2">
   <s:iterator value="projectLandList" var="projectLand" status="status1">
  <s:if test="#status1.last == false">
  <tr>
  <td width="33%"><a href="pub_showProjectLand.action?id=${projectLand.id}" target="_blank">${util:limitText(projectLand.code,30) }</a></td>
  <td width="33%">${util:limitText(projectLand.name,30) }</td>
  <td width="20%">${util:limitText(projectLand.site.name,20) }</td>
  <td width="14%"><s:date name="#projectLand.createTime" format="yyyy-MM-dd" /></td>
  </tr>
  </s:if>
  <s:else>
  <tr>
  <td width="33%" style="border-bottom:none;"><a href="pub_showProjectLand.action?id=${projectLand.id}" target="_blank">${util:limitText(projectLand.code,30) }</a></td>
  <td width="33%" style="border-bottom:none;">${util:limitText(projectLand.name,30) }</td>
  <td width="20%" style="border-bottom:none;">${util:limitText(projectLand.site.name,20) }</td>
  <td width="14%" style="border-bottom:none;"><s:date name="#projectLand.createTime" format="yyyy-MM-dd" /></td>
  </tr>
  </s:else>
  
  </s:iterator>
  </s:if>
    <s:if test="#homePage.mining==2">
   <s:iterator value="projectMiningList" var="projectMining" status="status1">
  <s:if test="#status1.last == false">
  <tr>
  <td width="33%"><a href="pub_showProjectMining.action?id=${projectMining.id}" target="_blank">${util:limitText(projectMining.code,30) }</a></td>
  <td width="33%">${util:limitText(projectMining.name,30) }</td>
  <td width="20%">${util:limitText(projectMining.site.name,20) }</td>
  <td width="14%"><s:date name="#projectMining.createTime" format="yyyy-MM-dd" /></td>
  </tr>
  </s:if>
  <s:else>
  <tr>
  <td width="33%" style="border-bottom:none;"><a href="pub_showProjectMining.action?id=${projectMining.id}" target="_blank">${util:limitText(projectMining.code,30) }</a></td>
  <td width="33%" style="border-bottom:none;">${util:limitText(projectMining.name,30) }</td>
  <td width="20%" style="border-bottom:none;">${util:limitText(projectMining.site.name,20) }</td>
  <td width="14%" style="border-bottom:none;"><s:date name="#projectMining.createTime" format="yyyy-MM-dd" /></td>
  </tr>
  </s:else>
  
  </s:iterator>
  </s:if>
    <s:if test="#homePage.aim==2">
<s:iterator value="projectAimList" var="projectAim" status="status1">
  		<s:if test="#status1.last == false">
  <tr>
  <td width="33%"><a href="pub_showProjectAim.action?id=${projectAim.id}" target="_blank">${util:limitText(projectAim.code,30) }</a></td>
  <td width="33%">${util:limitText(projectAim.name,30) }</td>
  <td width="20%">${util:limitText(projectAim.site.name,20) }</td>
  <td width="14%"><s:date name="#projectAim.createTime" format="yyyy-MM-dd" /></td>
  </tr>
  		</s:if>
  		<s:else>
  <tr>
  <td width="33%" style="border-bottom:none;"><a href="pub_showProjectAim.action?id=${projectAim.id}" target="_blank">${util:limitText(projectAim.code,30) }</a></td>
  <td width="33%" style="border-bottom:none;">${util:limitText(projectAim.name,30) }</td>
  <td width="20%" style="border-bottom:none;">${util:limitText(projectAim.site.name,20) }</td>
  <td width="14%" style="border-bottom:none;"><s:date name="#projectAim.createTime" format="yyyy-MM-dd" /></td>
  </tr>
  		</s:else>
  </s:iterator>
  </s:if>
  
  </table>
</div>


  <div id="tba_3_body" style="display:none;" >
  <table cellpadding="0" cellspacing="0" class="table_list">
  <tr>
  <th width="33%">项目编码</th>
  <th  width="33%">项目名称</th>
  <th  width="20%">发布单位</th>
  <th  width="14%">发布时间</th>
  </tr>
  </table>
  <table cellpadding="0" cellspacing="0" class="table_list">
  <s:if test="#homePage.approve==3">
  <s:iterator value="projectApproveDetailList" var="pd" status="status1">
  
  		<s:if test="#status1.last == false">
  <tr>
  <td  width="33%"><a href="pub_showProjectApprove.action?id=${pd.projectApprove.id}&title=1" target="_blank">${util:limitText(pd.projectApprove.code,30) }</a></td>
  <td width="33%">${util:limitText(pd.projectApprove.name,30) }</td>
  <td width="20%">${util:limitText(pd.site.name,20) }</td>
  <td width="14%"><s:date name="#pd.createTime" format="yyyy-MM-dd" /></td>
  </tr>
  		</s:if>
  		<s:else>
  <tr>
  <td width="33%"  style="border-bottom:none;" ><a href="pub_showProjectApprove.action?id=${pd.projectApprove.id}&title=1" target="_blank">${util:limitText(pd.projectApprove.code,30) }</a></td>
  <td width="33%"  style="border-bottom:none;" >${util:limitText(pd.projectApprove.name,30) }</td>
  <td width="20%" style="border-bottom:none;" >${util:limitText(pd.site.name,20) }</td>
  <td width="14%" style="border-bottom:none;" ><s:date name="#pd.createTime" format="yyyy-MM-dd" /></td>
  </tr>
  		</s:else>
  </s:iterator>
  </s:if>
  
  <s:if test="#homePage.construct==3">
  <s:iterator value="projectConstructList" var="projectConstruct" status="status1">
  		<s:if test="#status1.last == false">
  <tr>
  <td width="33%"><a href="pub_showProjectConstruct.action?id=${projectConstruct.id}&title=1" target="_blank">${util:limitText(projectConstruct.code,30) }</a></td>
  <td width="33%">${util:limitText(projectConstruct.name,30) }</td>
  <td width="20%">${util:limitText(projectConstruct.site.name,20) }</td>
  <td width="14%"><s:date name="#projectConstruct.createTime" format="yyyy-MM-dd" /></td>
  </tr>
  		</s:if>
  		<s:else>
  <tr>
  <td width="33%" style="border-bottom:none;"><a href="pub_showProjectConstruct.action?id=${projectConstruct.id}&title=1" target="_blank">${util:limitText(projectConstruct.code,30) }</a></td>
  <td width="33%" style="border-bottom:none;">${util:limitText(projectConstruct.name,30) }</td>
  <td width="20%" style="border-bottom:none;">${util:limitText(projectConstruct.site.name,20) }</td>
  <td width="14%" style="border-bottom:none;"><s:date name="#projectConstruct.createTime" format="yyyy-MM-dd" /></td>
  </tr>
  		</s:else>
  </s:iterator>
  </s:if>
  
  <s:if test="#homePage.land==3">
   <s:iterator value="projectLandList" var="projectLand" status="status1">
  <s:if test="#status1.last == false">
  <tr>
  <td width="33%"><a href="pub_showProjectLand.action?id=${projectLand.id}" target="_blank">${util:limitText(projectLand.code,30) }</a></td>
  <td width="33%">${util:limitText(projectLand.name,30) }</td>
  <td width="20%">${util:limitText(projectLand.site.name,20) }</td>
  <td width="14%"><s:date name="#projectLand.createTime" format="yyyy-MM-dd" /></td>
  </tr>
  </s:if>
  <s:else>
  <tr>
  <td width="33%" style="border-bottom:none;"><a href="pub_showProjectLand.action?id=${projectLand.id}" target="_blank">${util:limitText(projectLand.code,30) }</a></td>
  <td width="33%" style="border-bottom:none;">${util:limitText(projectLand.name,30) }</td>
  <td width="20%" style="border-bottom:none;">${util:limitText(projectLand.site.name,20) }</td>
  <td width="14%" style="border-bottom:none;"><s:date name="#projectLand.createTime" format="yyyy-MM-dd" /></td>
  </tr>
  </s:else>
  
  </s:iterator>
  </s:if>
  
  
    <s:if test="#homePage.mining==3">
   <s:iterator value="projectMiningList" var="projectMining" status="status1">
  <s:if test="#status1.last == false">
  <tr>
  <td width="33%"><a href="pub_showProjectMining.action?id=${projectMining.id}" target="_blank">${util:limitText(projectMining.code,30) }</a></td>
  <td width="33%">${util:limitText(projectMining.name,30) }</td>
  <td width="20%">${util:limitText(projectMining.site.name,20) }</td>
  <td width="14%"><s:date name="#projectMining.createTime" format="yyyy-MM-dd" /></td>
  </tr>
  </s:if>
  <s:else>
  <tr>
  <td width="33%" style="border-bottom:none;"><a href="pub_showProjectMining.action?id=${projectMining.id}" target="_blank">${util:limitText(projectMining.code,30) }</a></td>
  <td width="33%" style="border-bottom:none;">${util:limitText(projectMining.name,30) }</td>
  <td width="20%" style="border-bottom:none;">${util:limitText(projectMining.site.name,20) }</td>
  <td width="14%" style="border-bottom:none;"><s:date name="#projectMining.createTime" format="yyyy-MM-dd" /></td>
  </tr>
  </s:else>
  
  </s:iterator>
  </s:if>
    <s:if test="#homePage.aim==3">
<s:iterator value="projectAimList" var="projectAim" status="status1">
  		<s:if test="#status1.last == false">
  <tr>
  <td width="33%"><a href="pub_showProjectAim.action?id=${projectAim.id}" target="_blank">${util:limitText(projectAim.code,30) }</a></td>
  <td width="33%">${util:limitText(projectAim.name,30) }</td>
  <td width="20%">${util:limitText(projectAim.site.name,20) }</td>
  <td width="14%"><s:date name="#projectAim.createTime" format="yyyy-MM-dd" /></td>
  </tr>
  		</s:if>
  		<s:else>
  <tr>
  <td width="33%" style="border-bottom:none;"><a href="pub_showProjectAim.action?id=${projectAim.id}" target="_blank">${util:limitText(projectAim.code,30) }</a></td>
  <td width="33%" style="border-bottom:none;">${util:limitText(projectAim.name,30) }</td>
  <td width="20%" style="border-bottom:none;">${util:limitText(projectAim.site.name,20) }</td>
  <td width="14%" style="border-bottom:none;"><s:date name="#projectAim.createTime" format="yyyy-MM-dd" /></td>
  </tr>
  		</s:else>
  </s:iterator>
  </s:if>
  
  </table>
</div>




  <div id="tba_4_body" style="display:none;" >
  <table cellpadding="0" cellspacing="0" class="table_list">
  <tr>
  <th width="33%">项目编码</th>
  <th  width="33%">项目名称</th>
  <th  width="20%">发布单位</th>
  <th  width="14%">发布时间</th>
  </tr>
  </table>
  <table cellpadding="0" cellspacing="0" class="table_list">
  <s:if test="#homePage.approve==4">
  <s:iterator value="projectApproveDetailList" var="pd" status="status1">
  
  		<s:if test="#status1.last == false">
  <tr>
  <td  width="33%"><a href="pub_showProjectApprove.action?id=${pd.projectApprove.id}&title=1" target="_blank">${util:limitText(pd.projectApprove.code,30) }</a></td>
  <td width="33%">${util:limitText(pd.projectApprove.name,30) }</td>
  <td width="20%">${util:limitText(pd.site.name,20) }</td>
  <td width="14%"><s:date name="#pd.createTime" format="yyyy-MM-dd" /></td>
  </tr>
  		</s:if>
  		<s:else>
  <tr>
  <td width="33%"  style="border-bottom:none;" ><a href="pub_showProjectApprove.action?id=${pd.projectApprove.id}&title=1" target="_blank">${util:limitText(pd.projectApprove.code,30) }</a></td>
  <td width="33%"  style="border-bottom:none;" >${util:limitText(pd.projectApprove.name,30) }</td>
  <td width="20%" style="border-bottom:none;" >${util:limitText(pd.site.name,20) }</td>
  <td width="14%" style="border-bottom:none;" ><s:date name="#pd.createTime" format="yyyy-MM-dd" /></td>
  </tr>
  		</s:else>
  </s:iterator>
  </s:if>
  
  <s:if test="#homePage.construct==4">
  <s:iterator value="projectConstructList" var="projectConstruct" status="status1">
  		<s:if test="#status1.last == false">
  <tr>
  <td width="33%"><a href="pub_showProjectConstruct.action?id=${projectConstruct.id}&title=1" target="_blank">${util:limitText(projectConstruct.code,30) }</a></td>
  <td width="33%">${util:limitText(projectConstruct.name,30) }</td>
  <td width="20%">${util:limitText(projectConstruct.site.name,20) }</td>
  <td width="14%"><s:date name="#projectConstruct.createTime" format="yyyy-MM-dd" /></td>
  </tr>
  		</s:if>
  		<s:else>
  <tr>
  <td width="33%" style="border-bottom:none;"><a href="pub_showProjectConstruct.action?id=${projectConstruct.id}&title=1" target="_blank">${util:limitText(projectConstruct.code,30) }</a></td>
  <td width="33%" style="border-bottom:none;">${util:limitText(projectConstruct.name,30) }</td>
  <td width="20%" style="border-bottom:none;">${util:limitText(projectConstruct.site.name,20) }</td>
  <td width="14%" style="border-bottom:none;"><s:date name="#projectConstruct.createTime" format="yyyy-MM-dd" /></td>
  </tr>
  		</s:else>
  </s:iterator>
  </s:if>
  
  <s:if test="#homePage.land==4">
   <s:iterator value="projectLandList" var="projectLand" status="status1">
  <s:if test="#status1.last == false">
  <tr>
  <td width="33%"><a href="pub_showProjectLand.action?id=${projectLand.id}" target="_blank">${util:limitText(projectLand.code,30) }</a></td>
  <td width="33%">${util:limitText(projectLand.name,30) }</td>
  <td width="20%">${util:limitText(projectLand.site.name,20) }</td>
  <td width="14%"><s:date name="#projectLand.createTime" format="yyyy-MM-dd" /></td>
  </tr>
  </s:if>
  <s:else>
  <tr>
  <td width="33%" style="border-bottom:none;"><a href="pub_showProjectLand.action?id=${projectLand.id}" target="_blank">${util:limitText(projectLand.code,30) }</a></td>
  <td width="33%" style="border-bottom:none;">${util:limitText(projectLand.name,30) }</td>
  <td width="20%" style="border-bottom:none;">${util:limitText(projectLand.site.name,20) }</td>
  <td width="14%" style="border-bottom:none;"><s:date name="#projectLand.createTime" format="yyyy-MM-dd" /></td>
  </tr>
  </s:else>
  
  </s:iterator>
  </s:if>
  
    <s:if test="#homePage.mining==4">
   <s:iterator value="projectMiningList" var="projectMining" status="status1">
  <s:if test="#status1.last == false">
  <tr>
  <td width="33%"><a href="pub_showProjectMining.action?id=${projectMining.id}" target="_blank">${util:limitText(projectMining.code,30) }</a></td>
  <td width="33%">${util:limitText(projectMining.name,30) }</td>
  <td width="20%">${util:limitText(projectMining.site.name,20) }</td>
  <td width="14%"><s:date name="#projectMining.createTime" format="yyyy-MM-dd" /></td>
  </tr>
  </s:if>
  <s:else>
  <tr>
  <td width="33%" style="border-bottom:none;"><a href="pub_showProjectMining.action?id=${projectMining.id}" target="_blank">${util:limitText(projectMining.code,30) }</a></td>
  <td width="33%" style="border-bottom:none;">${util:limitText(projectMining.name,30) }</td>
  <td width="20%" style="border-bottom:none;">${util:limitText(projectMining.site.name,20) }</td>
  <td width="14%" style="border-bottom:none;"><s:date name="#projectMining.createTime" format="yyyy-MM-dd" /></td>
  </tr>
  </s:else>
  
  </s:iterator>
  </s:if>
  
    <s:if test="#homePage.aim==4">
<s:iterator value="projectAimList" var="projectAim" status="status1">
  		<s:if test="#status1.last == false">
  <tr>
  <td width="33%"><a href="pub_showProjectAim.action?id=${projectAim.id}" target="_blank">${util:limitText(projectAim.code,30 )}</a></td>
  <td width="33%">${util:limitText(projectAim.name,30) }</td>
  <td width="20%">${util:limitText(projectAim.site.name,20) }</td>
  <td width="14%"><s:date name="#projectAim.createTime" format="yyyy-MM-dd" /></td>
  </tr>
  		</s:if>
  		<s:else>
  <tr>
  <td width="33%" style="border-bottom:none;"><a href="pub_showProjectAim.action?id=${projectAim.id}" target="_blank">${util:limitText(projectAim.code,30) }</a></td>
  <td width="33%" style="border-bottom:none;">${util:limitText(projectAim.name,30) }</td>
  <td width="20%" style="border-bottom:none;">${util:limitText(projectAim.site.name,20) }</td>
  <td width="14%" style="border-bottom:none;"><s:date name="#projectAim.createTime" format="yyyy-MM-dd" /></td>
  </tr>
  		</s:else>
  </s:iterator>
  </s:if>
  
  </table>
</div>



  <div id="tba_5_body" style="display:none;" >
  <table cellpadding="0" cellspacing="0" class="table_list">
  <tr>
  <th width="33%">项目编码</th>
  <th  width="33%">项目名称</th>
  <th  width="20%">发布单位</th>
  <th  width="14%">发布时间</th>
  </tr>
  </table>
  <table cellpadding="0" cellspacing="0" class="table_list">
  <s:if test="#homePage.approve==5">
  <s:iterator value="projectApproveDetailList" var="pd" status="status1">
  
  		<s:if test="#status1.last == false">
  <tr>
  <td  width="33%"><a href="pub_showProjectApprove.action?id=${pd.projectApprove.id}&title=1" target="_blank">${util:limitText(pd.projectApprove.code,30) }</a></td>
  <td width="33%">${util:limitText(pd.projectApprove.name,30) }</td>
  <td width="20%">${util:limitText(pd.site.name,20) }</td>
  <td width="14%"><s:date name="#pd.createTime" format="yyyy-MM-dd" /></td>
  </tr>
  		</s:if>
  		<s:else>
  <tr>
  <td width="33%"  style="border-bottom:none;" ><a href="pub_showProjectApprove.action?id=${pd.projectApprove.id}&title=1" target="_blank">${util:limitText(pd.projectApprove.code,30) }</a></td>
  <td width="33%"  style="border-bottom:none;" >${util:limitText(pd.projectApprove.name,30) }</td>
  <td width="20%" style="border-bottom:none;" >${util:limitText(pd.site.name,20) }</td>
  <td width="14%" style="border-bottom:none;" ><s:date name="#pd.createTime" format="yyyy-MM-dd" /></td>
  </tr>
  		</s:else>
  </s:iterator>
  </s:if>
  
  <s:if test="#homePage.construct==5">
  <s:iterator value="projectConstructList" var="projectConstruct" status="status1">
  		<s:if test="#status1.last == false">
  <tr>
  <td width="33%"><a href="pub_showProjectConstruct.action?id=${projectConstruct.id}&title=1" target="_blank">${util:limitText(projectConstruct.code,30) }</a></td>
  <td width="33%">${util:limitText(projectConstruct.name,30) }</td>
  <td width="20%">${util:limitText(projectConstruct.site.name,20) }</td>
  <td width="14%"><s:date name="#projectConstruct.createTime" format="yyyy-MM-dd" /></td>
  </tr>
  		</s:if>
  		<s:else>
  <tr>
  <td width="33%" style="border-bottom:none;"><a href="pub_showProjectConstruct.action?id=${projectConstruct.id}&title=1" target="_blank">${util:limitText(projectConstruct.code,30) }</a></td>
  <td width="33%" style="border-bottom:none;">${util:limitText(projectConstruct.name,30) }</td>
  <td width="20%" style="border-bottom:none;">${util:limitText(projectConstruct.site.name,20) }</td>
  <td width="14%" style="border-bottom:none;"><s:date name="#projectConstruct.createTime" format="yyyy-MM-dd" /></td>
  </tr>
  		</s:else>
  </s:iterator>
  </s:if>
  
  <s:if test="#homePage.land==5">
   <s:iterator value="projectLandList" var="projectLand" status="status1">
  <s:if test="#status1.last == false">
  <tr>
  <td width="33%"><a href="pub_showProjectLand.action?id=${projectLand.id}" target="_blank">${util:limitText(projectLand.code,30) }</a></td>
  <td width="33%">${util:limitText(projectLand.name,30) }</td>
  <td width="20%">${util:limitText(projectLand.site.name,20) }</td>
  <td width="14%"><s:date name="#projectLand.createTime" format="yyyy-MM-dd" /></td>
  </tr>
  </s:if>
  <s:else>
  <tr>
  <td width="33%" style="border-bottom:none;"><a href="pub_showProjectLand.action?id=${projectLand.id}" target="_blank">${util:limitText(projectLand.code,30) }</a></td>
  <td width="33%" style="border-bottom:none;">${util:limitText(projectLand.name,30) }</td>
  <td width="20%" style="border-bottom:none;">${util:limitText(projectLand.site.name,20) }</td>
  <td width="14%" style="border-bottom:none;"><s:date name="#projectLand.createTime" format="yyyy-MM-dd" /></td>
  </tr>
  </s:else>
  
  </s:iterator>
  </s:if>
  
    <s:if test="#homePage.mining==5">
   <s:iterator value="projectMiningList" var="projectMining" status="status1">
  <s:if test="#status1.last == false">
  <tr>
  <td width="33%"><a href="pub_showProjectMining.action?id=${projectMining.id}" target="_blank">${util:limitText(projectMining.code,30) }</a></td>
  <td width="33%">${util:limitText(projectMining.name,30) }</td>
  <td width="20%">${util:limitText(projectMining.site.name,20) }</td>
  <td width="14%"><s:date name="#projectMining.createTime" format="yyyy-MM-dd" /></td>
  </tr>
  </s:if>
  <s:else>
  <tr>
  <td width="33%" style="border-bottom:none;"><a href="pub_showProjectMining.action?id=${projectMining.id}" target="_blank">${util:limitText(projectMining.code,30) }</a></td>
  <td width="33%" style="border-bottom:none;">${util:limitText(projectMining.name,30) }</td>
  <td width="20%" style="border-bottom:none;">${util:limitText(projectMining.site.name,20) }</td>
  <td width="14%" style="border-bottom:none;"><s:date name="#projectMining.createTime" format="yyyy-MM-dd" /></td>
  </tr>
  </s:else>
  
  </s:iterator>
  </s:if>
  
    <s:if test="#homePage.aim==5">
<s:iterator value="projectAimList" var="projectAim" status="status1">
  		<s:if test="#status1.last == false">
  <tr>
  <td width="33%"><a href="pub_showProjectAim.action?id=${projectAim.id}" target="_blank">${util:limitText(projectAim.code,30 )}</a></td>
  <td width="33%">${util:limitText(projectAim.name,30) }</td>
  <td width="20%">${util:limitText(projectAim.site.name,20) }</td>
  <td width="14%"><s:date name="#projectAim.createTime" format="yyyy-MM-dd" /></td>
  </tr>
  		</s:if>
  		<s:else>
  <tr>
  <td width="33%" style="border-bottom:none;"><a href="pub_showProjectAim.action?id=${projectAim.id}" target="_blank">${util:limitText(projectAim.code,30) }</a></td>
  <td width="33%" style="border-bottom:none;">${util:limitText(projectAim.name,30) }</td>
  <td width="20%" style="border-bottom:none;">${util:limitText(projectAim.site.name,20) }</td>
  <td width="14%" style="border-bottom:none;"><s:date name="#projectAim.createTime" format="yyyy-MM-dd" /></td>
  </tr>
  		</s:else>
  </s:iterator>
  </s:if>
  
  </table>
</div>

</div>
</div>
<div class="open_news_btm"></div>
</div>
</s:if>
<script type="text/javascript">if(flag!=0)SelectTab2('tba', flag);</script>

<s:if test="session.session_site.code=='340000000'">
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
  		<th>序号</th>
  			<th>项目编码</th>
 	 		<th>项目名称</th>
  			<th>发布单位</th>
  			<th>发布时间</th>
  		</tr>
  		
  		<s:iterator value="#keyProjectMap[#keyProjectKind.id]" var="keyProject" status="status1">
  		<s:if test="#status1.last == false">
  		<tr>
  			<td>${status1.count }</td>
  			<td><a href="pub_showPorjectAegis.action?id=${keyProject.projectConstruct.id }" target="_blank">${keyProject.projectConstruct.code }</a></td>
  			<td>${util:limitText(keyProject.projectConstruct.name,30) }</td>
  			<td>${util:limitText(keyProject.projectConstruct.site.name,20) }</td>
  			<td><s:date name="#keyProject.createDate" format="yyyy-MM-dd" /></td>
  		</tr>
  		</s:if>
    	<s:else>
  		<tr>
  			<td>${status1.count }</td>
  			<td style="border-bottom:none;" ><a href="pub_showPorjectAegis.action?id=${keyProject.projectConstruct.id }" target="_blank">${keyProject.projectConstruct.code }</a></td>
  			<td style="border-bottom:none;" >${util:limitText(keyProject.projectConstruct.name,30) }</td>
  			<td style="border-bottom:none;" >${keyProject.projectConstruct.site.name }</td>
  			<td style="border-bottom:none;" ><s:date name="#keyProject.projectConstruct.createTime" format="yyyy-MM-dd" /></td>
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
	</s:if>

<div class="open_news">
 <div class="gongx_top"><span class="span_more"><a href="pub_navCreditPublic.action?message=5&code=${session.session_site.code }">  更多</a></span></div>
 
 <div class="open_news_text">
    <div class="Tab_Blue">
      <div class="Tab_Blue_focus" id="gongx_1_hander" onclick="javascript:SelectTabCredit1('pub_ajaxCompanyCredit.action', 5, 1);">
    	<div class="L"></div>
        <div class="C">从业单位信用评价信息</div>
        <div class="R"></div>  
      </div>
      <div class="Tab_Blue_blur" id="gongx_2_hander" onclick="javascript:SelectTabCredit1('pub_ajaxCompanyInfo.action', 5, 2);">
    	<div class="L"></div>
        <div class="C">从业单位基本信息</div>
        <div class="R"></div>  
      </div>
      <!--  
      <div class="Tab_Blue_blur" id="gongx_3_hander" onclick="javascript:SelectTab('gongx', 5, 3);">
    	<div class="L"></div>
        <div class="C">个人基本信息</div>
        <div class="R"></div>  
      </div>-->
      <div class="Tab_Blue_blur" id="gongx_4_hander" onclick="javascript:SelectTabCredit1('pub_ajaxCompanyQualification.action', 5, 4);">
    	<div class="L"></div>
        <div class="C">从业单位资质信息</div>
        <div class="R"></div>  
      </div>
      <div class="Tab_Blue_blur" id="gongx_5_hander" onclick="javascript:SelectTabCredit1('pub_ajaxPersonQualification.action', 5, 5);">
    	<div class="L"></div>
        <div class="C">从业个人资质信息</div>
        <div class="R"></div>  
      </div>
      <div class="Tab_Blue_blur" id="gongx_3_hander" onclick="javascript:SelectTabCredit1('pub_ajaxCompanyCreditContract.action', 5, 3);">
    	<div class="L"></div>
        <div class="C">重合同守信用信息</div>
        <div class="R"></div>  
      </div>
   </div>
   <div>
      <div id="gongx_credit_body" style="display:block;" >
  <table cellpadding="0" cellspacing="0" class="table_list">
  <tr>
  <th colspan="2">单位名称</th>
  <th>行业信用等级(中央共享等级)</th>
  <!-- 
  <th>评价机构</th> -->
  <th>发布单位</th>
  <th>发布时间</th>
  </tr>
  <s:iterator value="companyCreditList" var="companyCredit">
  <tr>
  <td width="2"><img src="images/index/point.gif" /></td>
  <td><a href="pub_showCompanyCredit.action?id=${companyCredit.id}" target="_blank">${util:limitText(companyCredit.companyName,30) }</a></td>
  
  <td align="center">
  	${util:limitText(companyCredit.industryCredit,20) }&nbsp;&nbsp;(${util:limitText(companyCredit.unifyCredit,20) })
  </td>
  <!--  <td>${companyCredit.evaluateOrgan }</td>-->
  <td>${companyCredit.site.name }</td>
  <td><s:date name="#companyCredit.evaluateDate" format="yyyy-MM-dd" /></td>
  </tr>
  </s:iterator>
  </table>
</div>

  

     
   </div>
   
   <div class="Tab_Blue">
   <span class="span_more"><a href="pub_navCreditPublic.action?message=5&title=5&code=${session.session_site.code }">  更多</a></span>
 
      <div class="Tab_Blue_focus" id="xyong_1_hander" onclick="javascript:SelectTabCredit2('pub_ajaxCompanyBadrecord.action', 2, 1);">
    	<div class="L"></div>
        <div class="C">从业单位不良行为信息</div>
        <div class="R"></div>  
      </div>
      <div class="Tab_Blue_blur" id="xyong_2_hander" onclick="javascript:SelectTabCredit2('pub_ajaxCompanyHonor.action', 2, 2);">
    	<div class="L"></div>
        <div class="C">从业单位良好行为信息</div>
        <div class="R"></div>  
      </div>
   </div>
   <div>
<div id="xyong_credit_body" style="display:block; " >
 <table cellpadding="0" cellspacing="0" class="table_list">
  <tr>
  <th colspan="2" width="35%">单位名称</th>
  <th>不良行为类型</th>
  <th>发布单位</th>
  <th>发布时间</th>
  </tr>
  <s:iterator value="companyBadrecordList" var="companyBadrecord">
  <tr>
  <td width="2"><img src="images/index/point.gif" /></td>
  <td><a href="pub_showCompanyBadrecord.action?id=${companyBadrecord.id}" target="_blank">${util:limitText(companyBadrecord.companyName,30) }</a></td>
  <td>
	<s:if test="#companyBadrecord.type == 1">违法信息</s:if>
	<s:elseif test="#companyBadrecord.type == 2">行政处罚信息</s:elseif>
	<s:elseif test="#companyBadrecord.type == 3">行政强制信息</s:elseif>
	<s:elseif test="#companyBadrecord.type == 4">行政裁决信息</s:elseif>
	<s:elseif test="#companyBadrecord.type == 5">欠薪及欠缴社保金信息</s:elseif>
	<s:elseif test="#companyBadrecord.type == 6">质量安全信息</s:elseif>
    <s:elseif test="#companyBadrecord.type == 7">恶意欠付货款信息</s:elseif>
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
    </div>
      
 <div class="Tab_Blue">
      <div class="Tab_Blue_focus" id="dangan_1_hander" onclick="javascript:SelectTabCredit3('pub_ajaxCompany.action', 2, 1);">
    	<div class="L"></div>
        <div class="C">从业单位信用档案</div>
        <div class="R"></div>  
      </div>
      <div class="Tab_Blue_blur" id="dangan_2_hander" onclick="javascript:SelectTabCredit3('pub_ajaxPerson.action', 2, 2);">
    	<div class="L"></div>
        <div class="C">从业个人信用档案</div>
        <div class="R"></div>  
      </div>
      <div class="right_link">
      <div class="search2">
  <div class="search_bg2">
  <div class="search_title2">快速搜索</div>
    <form action="pub_searchAll.action" method="post" id="searchForm2" name="searchForm2">
  <div class="search_text2">
   <select class="select_txt2" name="id" id="id2">
		<option value="7" selected="selected">从业单位信用档案</option>
		<option value="8">从业个人信用档案</option>
   </select>
   <input  type="text" class="search_input2" id="title2"  name="title"  value="" onclick="clearText('title2')" />
   
		<a href="javascript:document.searchForm2.submit()"><img src="imgage/search2_1.gif" /></a> 
   </div>
   </form>
 </div>
 </div>
      
      
      </div>
      </div>
   <div>
<div id="dangan_credit_body" style="display:block;" >
  <table cellpadding="0" cellspacing="0" class="table_list">
  <tr>
  <th >单位名称</th>
  <th>发布单位</th>
  <th>发布时间</th>
  </tr>
  <s:iterator value="companyBaseList" var="com">
  <tr>
  <!--<li><a href="credit/companyInfo_uploadCreditPage.action">上传诚信档案</a></li> -->
   <!-- <td><a href="pub_showCompanyApprove.action?id=${com.id}" target="_blank">${com.companyName }</a></td>-->
  <td><a href="javascript:add('1','${com.id}')" >${util:limitText(com.companyName,30) }</a></td> 
  <td>${com.site.name }</td>
  <td><s:date name="#com.recordTime" format="yyyy-MM-dd" /></td>
  </tr>
  </s:iterator>
  </table>
</div>

   </div>
 <div class="Tab_Blue">
   <span class="span_more"><a href="pub_navCreditPublic.action?message=5&title=6&code=${session.session_site.code }">  更多</a></span>
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
								target="_blank" title="${typeList0.title }">${util:limitText(typeList0.title, 50) }</a></td>
						</tr>
						</s:if>
						<s:else>
						<tr>
							<td><a href="pub_showNews.action?id=${typeList0.id }"
								target="_blank" title="${typeList0.title }">${util:limitText(typeList0.title, 50) }</a></td>
						</tr>
						</s:else>
					</s:iterator>
					
				</s:if>
				<s:else>
					<s:iterator value="typicalList1" var="typeList1" status="statust2">
						<s:if test="#statust2.count == 10">
						<tr>
							<td style="border-bottom:none;"><a href="pub_showNews.action?id=${typeList1.id }"
								target="_blank"  title="${typeList1.title }">${util:limitText(typeList1.title, 50) }</a></td>
						</tr>
						</s:if>
						<s:else>
						<tr>
							<td><a href="pub_showNews.action?id=${typeList1.id }"
								target="_blank"  title="${typeList1.title }">${util:limitText(typeList1.title, 50) }</a></td>
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



<s:if test="session.session_site.code=='340000000'">
 <div class="open_news">
 <div class="dc_top"></div>
 <div class="open_news_text">
   <div>
      <div  id="dataCount_body">
        
      </div>
      
   </div>

</div>

<div class="open_news_btm"></div>
</div>


</s:if>









</div><!--open news-->



 </div> <!--right_middle-->       
</div><!--middle DIV-->

 
 <div class="bottom">
${homePage.footer }

</div> <!--bottom DIV-->
  
  
  
 
  <brady:message title="系统信息提示"/>  
  <brady:dialog title="信用档案查询" onClickOK="doSave()" width="650" height="340"/>
  <brady:confirm />
</body>
</html>
