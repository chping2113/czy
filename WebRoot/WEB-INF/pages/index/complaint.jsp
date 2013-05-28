<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/include/core.jsp"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>投诉举报</title>
<link href="css/jxw_main.css"  rel="stylesheet" type="text/css"/>


</head>

<body>
<div class="content">
<jsp:include page="${headPath }" />
  <div class="middle">
    <div class="left_middle">
    
    <div class="news">
      <div class="tousu_text_top"></div>
      <div class="news_text">
      <div class="news_text_top"></div>
      <div class="message_text_ul">
      <div class="twopage_left_P">
      <p>
       <span>一、受理举报范围</span><br />
全省工程建设领域项目信息和信用信息公开共享工作中， 在项目建设决策、招标投资、项目实施和工程质量、物资采购和资金使用等方面存在的违反相关法律法规的行为。<br /> 
<span>二、注意事项</span><br />
1、举报人应据实举报，不得捏造事实，制造假证，诬告陷害他人。对举报陷害他人的依有关规定严肃处理；构成犯罪的移送司法机关依法办理。<br />
2、提倡实名举报，属实名举报的请填写详细联系方式。<br />
3、请如实填写举报表单中的各栏目。填写“举报内容”一栏时，力求详尽，对违反法律法规行为发生的时间、地点、主要证据和涉及人员等要交待明确。<br />
4、本举报信箱将严明工作纪律，以防止举报信息和举报人真实身份泄露。
 </p>

 </div>
       
      </div>
      </div>
      <div class="news_text_btm"></div>
 </div> <!--div news-->
    
     
  
    </div> <!--left_middle-->
    <div class="right_middle">

    <div class="twopage_top"><span class="tousu_btn_left">投诉举报</span><span class="tousu_btn"><a href="pub_showComplaintAdd.action?message=7"><img src="imgage/ts_btn.jpg" /></a></span></div>
      <div class="tousu_text">
     <div class=two_rightlist>
  <s:iterator value="pageInfo.pageData" var="cc">
      <table cellpadding="0" cellspacing="0" class="tousu_table">
        <tr >
          <th colspan="2"><span>主题:</span>${cc.title }</th>
        </tr>
        <tr>
          <td width="35%">
            举报用户：${cc.name }<br />
          &nbsp;&nbsp;  举报时间：<s:date name="#cc.createTime" format="yyyy-MM-dd" /></td>
          <td>内容：${cc.content}
            <div class="reply"><span>回复：</span>${cc.deal}<br />
              「回复人员：${cc.complaintName}」「回复时间：<s:date name="#cc.complaintDate" format="yyyy-MM-dd" />」 </div></td>
        </tr>
      </table>
</s:iterator>
    
    <div class="page">
      
  				<brady:page url="pub_showComplaint.action?message=7" pageInfo="${pageInfo }" />
	       
      </div> 
      </div> 
      </div>
  </div><!--right_middle-->
 </div> <!--middle DIV-->
 <div class="bottom">
${session_homePage.footer }

</div> <!--bottom DIV-->
 </div>
   
</body>
</html>
