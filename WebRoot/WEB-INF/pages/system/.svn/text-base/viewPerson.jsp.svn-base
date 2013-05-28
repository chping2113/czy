<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/include/core.jsp"%>

<div class="view_panel">

    <table cellpadding="0" cellspacing="0" class="table_add">
     <tr>
      <th width="20%">帐号</th>
      <td>&nbsp;${code }</td>
     </tr>
     
     <tr>
      <th width="20%">姓名</th>
      <td>&nbsp;${name }</td>
     </tr>
     
     <tr>
      <th width="20%">所属单位</th>
      <td>&nbsp;${dept }</td>
     </tr>
     
     <tr>
      <th width="20%">性别</th>
      <td>&nbsp;${sex == "m" ? "男" : "女" }</td>
     </tr>
     
     <tr>
      <th width="20%">证件类型</th>
      <td>&nbsp;${certificateType == "a" ? "身份证" : "其它" }</td>
     </tr>
	
	 <tr>
      <th width="20%">证件号码</th>
      <td>&nbsp;${certificateCode }</td>
     </tr>
     
	 <tr>
       <th>注册时间</th>
       <td>&nbsp; <s:date name="registerTime" format="yyyy-MM-dd HH:mm:ss" /> </td>
     </tr>
     
     <tr>
      <th width="20%">联系电话</th>
      <td>&nbsp;${tel }</td>
     </tr>
      
     <tr>
      <th width="20%">电子邮件</th>
      <td>&nbsp;${email }</td>
     </tr>
     
     <tr>
      <th>审核机构</th>
      <td>&nbsp;</td>
      </tr>

     <tr>
      <th>审核状态</th>
      <td>&nbsp;${state==1? "审核通过" : (state==2 ? "未通过" : "未审核") }</td>
      </tr>
     
    </table>
     
</div><!--content-->