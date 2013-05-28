<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/include/core.jsp"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("basePath",basePath);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><decorator:title default="安徽项目公开网-后台管理首页" /></title>
 
<link rel="stylesheet" href="css/humanity/jquery-ui.css" />
<link href="css/main.css"  rel="stylesheet" style="text/css"/>
<link href="css/nav.css"  rel="stylesheet" style="text/css"/>
<link href="css/styles.css"  rel="stylesheet" style="text/css"/>

<link href="css/t.css"  rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.6.min.js"></script>
<script type="text/javascript" src="js/jquery.ui.datepicker-zh-CN.js"></script>
<script type="text/javascript" src="js/jquery.brady-min.js"></script>
<script type="text/javascript" src="js/highLightRow.js"></script>
<script type="text/javascript" src="js/credit.js"></script>
<script type="text/javascript" src="js/project.js"></script>
<script type="text/javascript" src="js/cookie.js"></script>
<script type="text/javascript" src="js/verifyCode.js"></script>

<script>




var menuCount = Cookie("menuCount");
var objthis = Cookie("objthis");
jQuery(function(){
	//取cookie值
	var flag="${flag}";
	if(flag==1){
		menuCount=7;
		objthis="smaill71";
	}else if(flag==2){
		menuCount=1;
		objthis="smaill11";
		
	}else if(flag==3){
		menuCount=1;
		objthis="smaill11";
		
	}else if(flag==4){
		menuCount=1;
		objthis="smaill11";
		
	}
	  if(objthis!=null ){
		  if(objthis=="select_nav"){
			  $(objthis).blur();
		  }else{
			  document.getElementById(objthis).id="select_nav";
			  $(objthis).blur();
		  }
		  
			
		}
	if(menuCount==null){
		menuCount=1;
	}
	var s="ChildMenu"+menuCount;
	document.getElementById(s).className = "collapsed";
	$.post("pub_taskCount.action", "", function(date) {
		
		if(date==""){
			$("#daiban").hide();
		}else{
			$("#daiban").html(date);
		}
		
	});
	  
});
function changeMenu(objthis,c){
	setCookie("menuCount", c, expdate, "/", null, false);
	  if(objthis.id!="select_nav"){
			setCookie("objthis", objthis.id, expdate, "/", null, false);
	  }
}
function clearDefaultText (el,message) {
	var obj = el;
	if(typeof(el) == "string")
		obj = document.getElementById(el);
	
	obj.value = "";
	
}

function deleteDefaultText(id,temp) {
	var title = $(id).val();
	if(title == temp){
		$(id).val("");
	}
}

function logout() {
	if(window.confirm("确定退出后台管理程序吗？")) {
		window.location.href = '${basePath}' + 'pub_logout.action';
	}
}

function bookmark() {
	$.brady.util.addBookmark();
}
var LastLeftID = "ChildMenu1";

function DoMenu(emid)
{
 var obj = document.getElementById(emid); 
 var s="ChildMenu"+menuCount;
 obj.className = (obj.className.toLowerCase() == "expanded"?"collapsed":"expanded");
 if(emid==LastLeftID){
		if(s!=emid){
			 document.getElementById(s).className = "expanded";
		}
 }
 if((LastLeftID!="")&&(emid!=LastLeftID)) //关闭上一个Menu
 {
  document.getElementById(LastLeftID).className = "expanded";

	if(s!=emid){
		 document.getElementById(s).className = "expanded";
	}
	 
 }
 LastLeftID = emid;
}
function show_pop(){//显示窗口 
    document.getElementById("tan").style.display="block"; 

    timer=setInterval("changeH(4)",2);//调用changeH(4),每0.002秒向上移动一次 
} 
function hid_pop(){//隐藏窗口 
    timer=setInterval("changeH(-4)",2);//调用changeH(-4),每0.002秒向下移动一次 
} 
//www.jb51.net 脚本之家测试通过 
function changeH(addH) { 
    var MsgPop=document.getElementById("tan"); 
  

    var popH=$("#tan").height();
    if (popH<=100&&addH>0||popH>=4&&addH<0){//如果高度小于等于100(str>0)或高度大于等于4(str<0) 
        MsgPop.style.height=(popH+addH).toString()+"px";//高度增加或减少4个象素 
    } 
    else{//否则 
        clearInterval(timer);//取消调用,意思就是如果高度超过100象素了,就不再增长了，或高度等于0象素了，就不再减少了 
        MsgPop.style.display=addH>0?"block":"none"//向上移动时窗口显示,向下移动时窗口隐藏（因为窗口有边框,所以还是可以看见1~2象素没缩进去,这时候就把DIV隐藏掉） 
    } 
} 
var count="${allCount}";
if(count>0){
	window.onload=function(){//加载 
		//setTimeout("show_pop()",800);//0.8秒后调用show_pop() 
		} ;
}
	

function todo(count,name){
	setCookie("menuCount",count, expdate, "/", null, false);
	setCookie("objthis", name, expdate, "/", null, false);
}


</script>   
    
    
    
<decorator:head />
</head>

<body onload="javascript:changePassword(' ${session.tPassword}')">
<div class="content">
 <div class="top">
 <span>
 <s:if test="session.loginUser!=null">
  <s:if test="session.loginUser.site.code=='340000099'">
   <a href="pub_index.action" target="_blank">首页</a>
  </s:if>
  <s:else>
  <a href="gk_${session.loginUser.site.code }.action" target="_blank">首页</a>
  </s:else>
 
 </s:if>

 <s:else>
 <a href="pub_index.action" target="_blank">首页</a>
 
 </s:else>
 
 |<a href="javascript:bookmark()">加入收藏</a>|<a href="javascript:logout();">安全退出</a></span> </div>
 <!--top-->
 
 
  <div class="middle">
   <div class="left_nav">
     <img src="images/left-top.gif" />
     <s:if test="#session.loginUser != null">
     <!-- 政府部门用户的菜单是数据库中根据角色动态加载 -->
     <s:iterator value="#session.firstLevelMenuPermissionList" var="firstMenu" status="stat">
     <div class="left_nav_h" onclick="DoMenu('ChildMenu${stat.count }')"  style="cursor:hand" ><img src="images/h_0${stat.count }.gif" />${firstMenu.title }</div>
    
       <div id="ChildMenu${stat.count }" class="expanded">
        <ul class="nav_h_ul">
        <s:iterator value="#session.firstIdSecondPermissionMap[#firstMenu.id]" var="secondMenu" status="stat2">
        	<li><a href="${secondMenu.url }" id="smaill${stat.count }${stat2.count }" onclick="changeMenu(this,${stat.count })" >${secondMenu.title }</a></li>
        <s:if test="#secondMenu.id==71 && session.loginUser.role.id!=8">
        <div class="two_ul">
            <!--    <ul>
               <li><a href="project/projectApprove_initAdd.action?subType=1&type=1" id="smaill${stat.count }${stat2.count }1" onclick="changeMenu(this,${stat.count })" >发布审批备案信息</a></li>
               <li><a href="project/projectApprove_initAdd.action?subType=2&type=1" id="smaill${stat.count }${stat2.count }2" onclick="changeMenu(this,${stat.count })" >发布初步设计批复信息</a></li>
               <li><a href="project/projectApprove_initAdd.action?subType=3&type=1" id="smaill${stat.count }${stat2.count }3" onclick="changeMenu(this,${stat.count })" >发布节能评估批复信息</a></li>
               <li><a href="project/projectApprove_initAdd.action?subType=4&type=1" id="smaill${stat.count }${stat2.count }4" onclick="changeMenu(this,${stat.count })" >发布规划选址批复信息</a></li>
               <li><a href="project/projectApprove_initAdd.action?subType=5&type=1" id="smaill${stat.count }${stat2.count }5" onclick="changeMenu(this,${stat.count })" >发布用地批复文件信息</a></li>
               <li><a href="project/projectApprove_initAdd.action?subType=6&type=1" id="smaill${stat.count }${stat2.count }6" onclick="changeMenu(this,${stat.count })" >发布环境影响评价审批信息</a></li>
               <li><a href="project/projectApprove_initAdd.action?subType=7&type=1" id="smaill${stat.count }${stat2.count }7" onclick="changeMenu(this,${stat.count })" >发布施工许可(开工)审批信息</a></li>
               
              </ul>-->
             </div>
        </s:if>
         <s:if test="#secondMenu.id==75 && session.loginUser.role.id!=8">
        <div class="two_ul">
              <ul>
               <li><a href="project/projectConstruct_initAdd.action?subType=1&type=1" id="smaill${stat.count }${stat2.count }1" onclick="changeMenu(this,${stat.count })" >发布审计统计结果信息</a></li>
         
              </ul>
             </div>
        </s:if>
        </s:iterator>
        </ul>
      </div>
     </s:iterator>
     
     <%--政府帐户操作不需要控制权限 --%>
     <div class="left_nav_h" onclick="DoMenu('ChildMenu7')" style="cursor:hand" ><img src="images/h_05.gif" />帐户信息管理</div>
     <div id="ChildMenu7" class="expanded">
        <ul class="nav_h_ul">
         <li><a href="system/account_showAccount.action" id="smaill71" onclick="changeMenu(this,7)">帐户基本信息</a></li>
         <li><a href="system/account_updateAccount.action" id="smaill72" onclick="changeMenu(this,7)">修改基本信息</a></li>
         <li><a href="system/account_showPassword.action" id="smaill73" onclick="changeMenu(this,7)">修改密码</a></li> 
        </ul>
      </div>
    </s:if>
    
 	<s:if test="#session.loginCompany != null">
 	<div class="left_nav_h" onclick="DoMenu('ChildMenu1')" style="cursor:hand" ><img src="images/h_05.gif" />从业单位信息</div>
     <div id="ChildMenu1" class="collapsed">
        <ul class="nav_h_ul">
         <li><a href="system/account_showAccount.action"  id="smaill11" onclick="changeMenu(this,1)">帐户基本信息</a></li>
         <li><a href="system/account_updateAccount.action" id="smaill12" onclick="changeMenu(this,1)">修改基本信息</a></li>
     
         <li><a href="credit/companyInfo_uploadCreditPage.action" id="smaill13" onclick="changeMenu(this,1)">查看诚信档案</a></li>
       
         <li><a href="system/account_showPassword.action" id="smaill14" onclick="changeMenu(this,1)">修改密码</a></li> 
        </ul>
      </div>
     </s:if>
      
      <s:if test="#session.loginPerson != null">
      <div class="left_nav_h" onclick="DoMenu('ChildMenu1')" style="cursor:hand" ><img src="images/h_05.gif" />从业个人信息</div>
     <div id="ChildMenu1" class="collapsed">
        <ul class="nav_h_ul">
         <li><a href="system/account_showAccount.action" id="smaill11" onclick="changeMenu(this,1)">帐户基本信息</a></li>
          
         <li><a href="system/account_updateAccount.action" id="smaill12" onclick="changeMenu(this,1)">修改基本信息</a></li>
         <li><a href="credit/personInfo_uploadCreditPage.action" id="smaill13" onclick="changeMenu(this,1)">查看诚信档案</a></li>
         <li><a href="system/account_showPassword.action" id="smaill14" onclick="changeMenu(this,1)">修改密码</a></li> 
        </ul>
      </div>
   	</s:if>
   	
   	 <s:if test="#session.loginConstruct != null" >
      <div class="left_nav_h" onclick="DoMenu('ChildMenu1')" style="cursor:hand" ><img src="images/h_05.gif" />项目建设单位</div>
     <div id="ChildMenu1" class="collapsed">
        <ul class="nav_h_ul">
         <li><a href="system/account_showAccount.action" id="smaill11" onclick="changeMenu(this,1)">帐户基本信息</a></li>
         <li><a href="system/account_updateAccount.action" id="smaill12" onclick="changeMenu(this,1)">修改基本信息</a></li>
    	 <li><a href="project/projectConstruct_init.action" id="smaill13" onclick="changeMenu(this,1)">项目建设管理信息录入</a></li>
         <li><a href="system/account_showPassword.action" id="smaill14" onclick="changeMenu(this,1)">修改密码</a></li> 
        </ul>
      </div>
   	</s:if>
   	
   	
   </div><!--left_nav-->
   <div id="right_main" class="right_main">
   <s:if test="session.loginUser!=null">
    <div id="daiban" >
    
</div>
   
   
   
   
   
   
   
   
   
   
   
 </s:if>
   	<%-- 在此插入被加载的内容 --%>
   	<decorator:body />
   </div> <!--right_main-->
 </div><!--middle-->

 <div class="bottom">版权所有 &copy;&nbsp; 安徽中小企业服务中心 </div>
 <!--bottom-->






</div><!--content-->




<div id="tan" class="tan">
  <div class="tan_top">您的待办事项<span><a href="javascript:hid_pop()"><img src="imgage/close2.jpg" /></a></span></div>
  <div class="tan_main">
   <ul>
   
       <s:if test="#session.projectApproveCount!=0">
  <li><a href="project/projectApprove_init.action?type=6"><span><font style="color: red;font-weight: bold;">${projectApproveCount }</font>条</span>项目审批信息发布</a></li>
 </s:if>   
  <s:if test="#session.projectConstructCount!=0">
   <li><a href="project/projectConstruct_init.action?type=6"><span><font style="color: red;font-weight: bold;">${projectConstructCount }</font>条</span>建设管理信息审批</a></li>
 </s:if>  
   <s:if test="#session.projectLandCount!=0">
   <li><a href="project/projectLand_init.action?type=6"><span><font style="color: red;font-weight: bold;">${projectLandCount }</font>条</span>土地权信息审核</a></li>
 </s:if>
   <s:if test="#session.projectMiningCount!=0">
   <li><a href="project/projectMining_init.action?type=6"><span><font style="color: red;font-weight: bold;">${projectMiningCount }条</font></span>矿业权信息审核</a></li>
 </s:if>
   <s:if test="#session.taskCount!=0">
   <li><a href="info/task_todo.action"><span><font style="color: red;font-weight: bold;">${taskCount }</font>条</span>其他工作事项</a></li>
 </s:if>
   
   
   </ul>
  </div>
  <div class="tan_btm"></div>  
  </div>











<input type="hidden" id="returnResult" value="0"/>
</body>
</html>
