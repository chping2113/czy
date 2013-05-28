<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/include/core.jsp"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="css/smallslider.css"/>

<script type="text/javascript" src="js/jquery.smallslider.js"></script>
<script type="text/javascript" src="js/index.js"></script>
  
	<script type="text/javascript"> 
	
	function changeKey(count){
		  if (event.keyCode==13) { 
			  doSubmit(count);
		  } 
	}
	

	//<!-- 
		function doSearchSubmit(){
			var id=$('#id').val(); 
			var title=$('#title').val(); 
			if(title=="请输入您要搜索的关键字......"){
				title="";
			}
			var message=0;
			if(id==2){
				message=3;
			}
			if(id==3 || id== 4 || id ==5){
				message=4;
			}
			if(id==6 || id==7 || id== 8 || id==9 || id == 10){
				message=5;
			}
			//window.location.href = "pub_searchAll.action?catelogId=18&id="+id+"&title=" + title;
			window.open("pub_searchAll.action?catelogId=18&id="+id+"&title=" + title+"&message="+message);
		}
		function clearText(){
			$('#title').attr("value","");
		}
		//-->
	</script>
</head>

<body>

     
  <div class="middle">
  
    <div class="left_middle">
     <!-- 快速登录 start -->
     <div class="user">
     <form id="loginForm" action="pub_indexLogin.action" method="post">
      <div class="user_top">
      <ul>
      <li><a href="#" id="curTab_select5" onClick="changeId5('curTab_select5',this,'#tab223'); return false;">政府/建设单位</a></li>
      <li><a href="#" onClick="changeId5('curTab_select5',this,'#tab224'); return false;">从业单位/个人</a></li></ul></div>
      <div id="tab223" style="display:block;" >
      <div class="user_text">
      <p>用户名
             <input name="code" id="code" type="text" class="user_text_input" />
      </p>
    <p>密<span>码</span>
             <input name="password" id="password" type="password" class="user_text_input"  onkeypress="changeKey(1)"/>
    </p>
          <p class="radio_p">类<span>型</span>
            <label><input type="radio" name="state" value="0" id="RadioGroup_0" class="user_text_radio" checked="checked" onkeypress="changeKey(1)"/>政府审批部门</label>
            <label><input type="radio" name="state" value="3" id="RadioGroup_1" class="user_text_radio" onkeypress="changeKey(1)"/>项目建设单位</label>
           
          </p>
      <p class="text_center"><a href="javascript:doSubmit(1)"><img src="images/index/login.gif" /></a><span class="password"><a href="pub_showPassword.action">忘记密码？</a></span>  </p>
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
      <p class="text_center"><a href="javascript:doSubmit(2)"><img src="images/index/login.gif" tabIndex=7/></a><span class="password"><a href="pub_showPassword.action">忘记密码？</a></span>  </p>
      </div>
     </div>
     </form>
     </div>
     <!-- 快速登录 end -->
    
    <div class="message">
      <div class="message_top"><span class="span_left">通知公告</span><span class="span_more"><a href="pub_listMoreNotice.action" target="_blank">>>更多</a></span></div>
      <ul class="message_text">
      <s:iterator value="#noticeList" var="notice">
      	<li><span><s:date name="#notice.createTime" format="yyyy-MM-dd" /></span><a href="pub_showNotice.action?id=${notice.id }" title="${notice.title }" target="_blank">${util:limitText(notice.title, 12) }</a></li>
      </s:iterator>
      </ul>
 	</div>
 	
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
 
 <div class="sheng">
  <div class="sheng_top">部门项目信息和诚信信息公开专栏</div>
  <div class="sheng_text">
  <table border="0" cellpadding="0" cellspacing="0" class="sheng_table">
  <c:forEach items="${shengzhiOrganList}" step="3" varStatus="status">
  <tr>
  <td>
  	<c:if test="${empty shengzhiOrganList[status.index].footer }">
  		<a href="#" onclick="return false;">${shengzhiOrganList[status.index].name }</a>
  	</c:if>
  	<c:if test="${not empty shengzhiOrganList[status.index].footer }">
  		<a href="sitePub_${shengzhiOrganList[status.index].code }.action">${shengzhiOrganList[status.index].name }</a>
  	</c:if>
  </td>
  <td>
  	<c:if test="${empty shengzhiOrganList[status.index+1].footer }">
  		<a href="#" onclick="return false;">${shengzhiOrganList[status.index+1].name }</a>
  	</c:if>
  	<c:if test="${not empty shengzhiOrganList[status.index+1].footer }">
  		<a href="sitePub_${shengzhiOrganList[status.index+1].code }.action">${shengzhiOrganList[status.index+1].name }</a>
  	</c:if>
  </td>
  <td>
  	<c:if test="${empty shengzhiOrganList[status.index+2].footer }">
  		<a href="#" onclick="return false;">${shengzhiOrganList[status.index+2].name }</a>
  	</c:if>
  	<c:if test="${not empty shengzhiOrganList[status.index+2].footer }">
  		<a href="sitePub_${shengzhiOrganList[status.index+2].code }.action">${shengzhiOrganList[status.index+2].name }</a>
  	</c:if>
  </td>
  </tr>
  </c:forEach>
</table>
  </div>
 </div>
 
 <div class="shi">
 <div class="shi_top">部门项目信息和诚信信息公开专栏</div>
 <div class="sheng_text">
  <a href="#">合肥市</a>  <a href="#">亳州市</a>  <a href="#">淮北市</a>  <a href="#">宿州市</a> <a href="#">阜阳市</a> 
  <a href="#">淮南市</a>  <a href="#">蚌埠市</a>  <a href="#">滁州市</a>  <a href="#">六安市</a> <a href="#">巢湖市</a>
  <a href="#">芜湖市</a>  <a href="#">黄山市</a>  <a href="#">安庆市</a>  <a href="#">池州市</a> <a href="#">铜陵市</a>
  <a href="#">宣城市</a>  <a href="#">马鞍山市</a> </div>
 </div>

 
  <div class="other">
 <div class="other_top">省市项目信息和诚信信息公开专栏</div>
 <div class="sheng_text">
  <a href="http://gcjs.beijing.gov.cn/" target="_blank">北京市</a>  <a href="http://www.tjjw.gov.cn/article/2010/0610/article_532.html" target="_blank">天津市</a>  <a href="http://www.hebei.gov.cn/gcjs/index.jsp" target="_blank">河北省</a>  <a href="#">上海市</a><a href="http://www.js.gov.cn/shouye/gsgg/gcjs/index.html" target="_blank">江苏省</a> 
  <a href="http://www.zjcredit.gov.cn/gcxy/" target="_blank">浙江省</a>  <a href="#">重庆市</a>  <a href="http://www.fujian.gov.cn/ztzl/gcjs/" target="_blank">福建省</a>  <a href="http://www.hnsjct.gov.cn/ztzl/zxzl/gzdt/" target="_blank">河南省</a></div>         
</div>
         
 <div class="left_images">
 	<s:if test="session.session_site.code!='anhui'">
 	<a href="pub_index.action"><img src="images/index/x_photo03.jpg" border="0" /></a>
 	</s:if>
 	<a href="http://www.zzg.gov.cn/xmxx/xgyw/" target="_blank"><img src="images/index/gongchen.jpg" border="0" /></a>
 	<a href="#"><img src="images/index/zaixian.jpg" border="0"  /></a><br />
 </div>

 <div class="tel">
  <div class="tel_top">投诉举报</div>
  <div class="tel_text"><span>${session_site.report }</span>
  <br />
  <a href="pub_showComplaint.action"><img src="images/index/jubao.gif" border="0"/></a></div>
 </div><!--tel--> 
 </div><!--left_middle--> 
<div class="right_middle">
 <div class="search">
 	<div class="search_div">
	   <select class="select_txt" id="id" name="id">
	    <option value="1">通知公告</option>
		<option value="2">工作动态</option>
		<option value="3" selected="selected">项目审批信息</option>
		<option value="4">项目建设管理信息</option>
		<option value="5">土地矿业权审批信息</option>
		<option value="6">从业单位信用等级公告</option>
		<option value="7">从业单位诚信档案</option>
		<option value="8">从业个人诚信档案</option>
		<option value="9">良好行为信息</option>
		<option value="10">不良行为信息</option>
	   </select>
	   <input  type="text" class="search_input" id="title"  name="title"  value="请输入您要搜索的关键字......" onclick="clearText()"/>
	   <a href="javascript:doSearchSubmit()"><img src="images/index/searh_btn.jpg" /></a> 
   </div>
 </div>
 
<s:if test="session.session_site.code=='anhui'">
<div class="news">
  <div class="news_top"><span class="span_left">项目公开新闻</span><span class="span_more"><a href="pub_listNewsByCatelogId.action?catelogId=18&message=3" target="_blank">&gt;&gt;更多</a></span></div>
  <div class="news_text">
  	<!-- 标题图片轮播区 -->
  	<div class="news_photo">
    <div id="imageSliderBox" class="photo_slider smallslider">
   		<ul>
   		<s:iterator value="#imageNewsList" var="news">
   			<li><a href="pub_showNews.action?id=${news.id}" target="_blank" ><img src="upload_images/${news.imageFileName}" width="268" height="197" border="0" title="" alt=""/></a></li>
   		</s:iterator>
   		</ul>
    </div>
    </div>
    
    <div class="new_ul01">
    <ul>
      <s:iterator value="#nonImageNewsList" var="nonImageNews" >
    	<li><span><s:date name="#nonImageNews.createTime" format="yyyy-MM-dd" /></span><a href="pub_showNews.action?id=${nonImageNews.id}" title="${nonImageNews.title }" target="_blank">${util:limitText(nonImageNews.title, 23) }</a></li>
      </s:iterator>
      </ul>
  </div>
   
  </div>
  </div>
  </s:if>
  
<div class="open_news">
 <div class="open_news_top"><span class="span_left">项目信息公开</span><span class="span_more"><a href="pub_navProjectPublic.action?message=4" target="_blank">>>更多</a></span></div>
 <div class="open_news_text">
  <div class="open_ul">
  <ul class="content-ul-select" id="ul1">
              <li>
                <div class="ul-span1"></div>
              </li>
              <li>
                <div><a href="#" id="curTab_select" onClick="changeId('curTab_select',this,'#tab11'); return false;">项目审批信息</a></div>
              </li>
              <li>
                <div class="ul-span2"></div>
              </li>
            </ul>
            <ul class="content-ul" id="ul2">
              <li>
                <div class="ul-span1"></div>
              </li>
              <li>
                <div><a href="#" onClick="changeId('curTab_select',this,'#tab22'); return false;">项目建设管理信息</a></div>
              </li>
              <li>
                <div class="ul-span2"></div>
              </li>
            </ul>
            <ul class="content-ul" id="ul2">
              <li>
                <div class="ul-span1"></div>
              </li>
              <li>
                <div><a href="#" onClick="changeId('curTab_select',this,'#tab33'); return false;">土地矿业权审批信息</a></div>
              </li>
              <li>
                <div class="ul-span2"></div>
              </li>
            </ul>
            <ul class="content-ul" id="ul2">
              <li>
                <div class="ul-span1"></div>
              </li>
              <li>
                <div><a href="#" onClick="return false;">从业资质信息</a></div>
              </li>
              <li>
                <div class="ul-span2"></div>
              </li>
            </ul>
            <ul class="content-ul" id="ul2">
              <li>
                <div class="ul-span1"></div>
              </li>
              <li>
                <div><a href="#" onClick="return false;">招投标信息</a></div>
              </li>
              <li>
                <div class="ul-span2"></div>
              </li>
            </ul>

    </div>
  <div id="tab11" style="display:block;" >
  <table cellpadding="0" cellspacing="0" class="table_list">
  <tr>
  <th>项目编码</th>
  <th>项目名称</th>
  <th>发布机关</th>
  <th>发布时间</th>
  </tr>
  <s:iterator value="projectApproveList" var="projectApprove">
  <tr>
  <td><a href="pub_showProjectApprove.action?id=${projectApprove.id}" target="_blank">${projectApprove.project.code }</a></td>
  <td>${util:limitText(projectApprove.project.name,16) }</td>
  <td>${projectApprove.site.name }</td>
  <td><s:date name="#projectApprove.createTime" format="yyyy-MM-dd" /></td>
  </tr>
  </s:iterator>
  </table>
  </div>
  <div id="tab22" style="display:none;float:left;">
  <table cellpadding="0" cellspacing="0" class="table_list">
   <tr>
  <th>项目编码</th>
  <th>项目名称</th>
  <th>发布机关</th>
  <th>发布时间</th>
  </tr>
  <s:iterator value="projectConstructList" var="projectConstruct">
  <tr>
  <td><a href="pub_showProjectConstruct.action?id=${projectConstruct.id}" target="_blank">${projectConstruct.project.code }</a></td>
  <td>${util:limitText(projectConstruct.project.name,16) }</td>
  <td>${projectConstruct.site.name }</td>
  <td><s:date name="#projectConstruct.createTime" format="yyyy-MM-dd" /></td>
  </tr>
  </s:iterator>
  </table>
</div>
<div id="tab33" style="display:none;float:left">
  <table cellpadding="0" cellspacing="0" class="table_list">
   <tr>
  <th>项目编码</th>
  <th>项目名称</th>
  <th>发布机关</th>
  <th>发布时间</th>
  </tr>
  <s:iterator value="projectLandList" var="projectLand">
  <tr>
  <td><a href="pub_showProjectLand.action?id=${projectLand.id}" target="_blank">${projectLand.project.code }</a></td>
  <td>${util:limitText(projectLand.project.name,16) }</td>
  <td>${projectLand.site.name }</td>
  <td><s:date name="#projectLand.createTime" format="yyyy-MM-dd" /></td>
  </tr>
  </s:iterator>
  </table>
</div>
</div>
</div>

<s:if test="#keyProjectKindList.size > 0">
<div class="ten_text">
 <div class="ten_text_top"><span class="span_left">十大重点示范项目</span></div>
 <div class="open_news_text">
 
	<div class="open_ul<s:property value='#keyProjectKindList.size > 5 ? 2 : 1' />">
  	<ul class="content-ul-select" id="ul1">
  <s:iterator value="keyProjectKindList" var="keyProjectKind" status="status">
              <li>
                <div class="ul-span<s:property value='#keyProjectKindList.size > 5 ? 3 : 1' />"></div>
              </li>
              <li>
                <div>
                	<s:if test="#status.count == 1">
                	<a id='curTab_select<s:property value="#keyProjectKindList.size > 5 ? 8 : 4" />' href="#" tab="tab2" onClick="changeId4('curTab_select<s:property value="#keyProjectKindList.size > 5 ? 8 : 4" />', this,'#tab_${keyProjectKind.id}'); return false;">${keyProjectKind.name}</a> 
                	</s:if>
                	<s:else>
                	<a href="#" tab="tab2" onClick="changeId4('curTab_select<s:property value="#keyProjectKindList.size > 5 ? 8 : 4" />', this,'#tab_${keyProjectKind.id}'); return false;">${keyProjectKind.name}</a>
                	</s:else>
                </div>
              </li>
              <li>
                <div class="ul-span<s:property value='#keyProjectKindList.size > 5 ? 4 : 2' />"></div>
              </li>
  </s:iterator>
   </ul>
   </div>
   
    <s:iterator value="keyProjectKindList" var="keyProjectKind" status="status">
	<s:if test="#status.first == true">
	<div id="tab_${keyProjectKind.id}" tab="tab" style="display:block;float:left;width:693px;height:295px;"  >
    </s:if>
    <s:else>
	<div id="tab_${keyProjectKind.id}" tab="tab" style="display:none;float:left;width:672px;">
    </s:else>
  	<table cellpadding="0" cellspacing="0" class="table_list">
  		
  		<tr>
  			<th>项目编码</th>
 	 		<th>项目名称</th>
  			<th>发布地点</th>
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
</div><!--ten_text div-->
</s:if>

<div class="open_news">
 <div class="open_news_top"><span class="span_left">信用信息共享</span><span class="span_more"><a href="pub_navCreditPublic.action?message=5" target="_blank">>>更多</a></span></div>
 <div class="open_news_text">
  <div class="open_ul">
  <ul class="content-ul-select" id="ul1">
              <li>
                <div class="ul-span1"></div>
              </li>
              <li>
                <div><a href="#" id="curTab_select2" onClick="changeId2('curTab_select2',this,'#tab44'); return false;">从业单位信用等级公告</a></div>
              </li>
              <li>
                <div class="ul-span2"></div>
              </li>
            </ul>
            <ul class="content-ul" id="ul2">
              <li>
                <div class="ul-span1"></div>
              </li>
              <li>
                <div><a href="#" onClick="changeId2('curTab_select2',this,'#tab55'); return false;">从业单位诚信档案</a></div>
              </li>
              <li>
                <div class="ul-span2"></div>
              </li>
            </ul>
            <ul class="content-ul" id="ul2">
              <li>
                <div class="ul-span1"></div>
              </li>
              <li>
            <div><a href="#" onClick="changeId2('curTab_select2',this,'#tabcc'); return false;">从业个人诚信档案</a></div>
              </li>
              <li>
                <div class="ul-span2"></div>
              </li>
            </ul>
 
  </div>
  
   <div id="tab44" style="display:block;" >
  <table cellpadding="0" cellspacing="0" class="table_list_two">
  <tr>
  <th colspan="2">单位名称</th>
  <th>信用评价结果</th>
  <th>评价机构</th>
  <th>发布机关</th>
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
  <td>${companyCredit.evaluateOrgan }</td>
  <td>${companyCredit.site.name }</td>
  <td><s:date name="#companyCredit.evaluateDate" format="yyyy-MM-dd" /></td>
  </tr>
  </s:iterator>
  </table>
</div>

<div id="tab55" style="display:none;" >
  <table cellpadding="0" cellspacing="0" class="table_list_two">
  <tr>
  <th colspan="2">单位名称</th>
  <th>发布机关</th>
  <th>发布时间</th>
  </tr>
  <s:iterator value="companyList" var="com">
  <tr>
  <td width="2px"><img src="images/index/point.gif" /></td>
  <!-- td><a href="pub_showCompanyApprove.action?id=${com.id}" target="_blank">${com.name }</a></td>-->
  <td><a href="javascript:add('1','${com.id}')">${com.name }</a></td> 
  <td></td>
  <td><s:date name="#com.registerTime" format="yyyy-MM-dd" /></td>
  </tr>
  </s:iterator>
  </table>
</div>
<div id="tabcc" style="display:none;" >
  <table cellpadding="0" cellspacing="0" class="table_list_two">
  <tr>
    <th colspan="2">姓名</th>
  <th>所属单位</th>
  <th>发布机关</th>
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

  <div class="linetwo">&nbsp;</div>
  <div class="open_ul">
  <ul class="content-ul-select" id="ul1">
              <li>
                <div class="ul-span1"></div>
              </li>
              <li>
                <div><a href="#" id="curTab_select3" onClick="changeId3('curTab_select3',this,'#tab66'); return false;">不良行为信息</a> </div>
              </li>
              <li>
                <div class="ul-span2"></div>
              </li>
            </ul>
            <ul class="content-ul" id="ul2">
              <li>
                <div class="ul-span1"></div>
              </li>
              <li>
                <div><a href="#" onClick="changeId3('curTab_select3',this,'#tab77'); return false;">良好行为信息</a></div>
              </li>
              <li>
                <div class="ul-span2"></div>
              </li>
            </ul>
  </div>
  
  
<div id="tab66" style="display:block; " >
 <table cellpadding="0" cellspacing="0" class="table_list_two">
  <tr>
  <th colspan="2" width="30%">单位名称</th>
  <th>不良行为类型</th>
  <th>发布机关</th>
  <th style="border:none">发布时间</th>
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

<div id="tab77" style="display: none; " >
 <table cellpadding="0" cellspacing="0" class="table_list_two">
  <tr>
     <th colspan="2">单位名称</th>
     <th width="182">发布机关</th>
  	 <th width="115" style="border:none">发布时间</th>
  </tr>
 <s:iterator value="companyHonorList" var="companyHonor">
  <tr>
      <td width="11"><img src="images/index/point.gif" /></td>
	  <td width="85"><a href="pub_showCompanyHonor.action?id=${companyHonor.id}" target="_blank">${companyHonor.company.name }</a></td>
	  <td>${companyHonor.site.name }</td>
	  <td><s:date name="#companyHonor.honorDate" format="yyyy-MM-dd" /></td>
  </tr>
 </s:iterator>
 </table>
  </div><!--tab77 DIV-->
  </div><!--open_news_text Div-->
</div><!--open_news Div-->


 </div> <!--right_middle-->       
</div><!--middle DIV-->
  <brady:message />  
  <brady:dialog title="信用档案查询" onClickOK="doSave()" width="650" height="340"/>
  <brady:confirm />
</body>
</html>
