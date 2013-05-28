<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/include/core.jsp"%>

<div class="view_panel">

    <table cellpadding="0" cellspacing="0" class="table_add">
     <tr>
      <th width="20%">企业帐号</th>
      <td>&nbsp;${code }</td>
      </tr>
      
     <tr>
      <th width="20%">企业名称</th>
      <td>&nbsp;${name }</td>
      </tr>
      
      <tr>
      <th width="20%">营业执照号</th>
      <td>&nbsp;${licenseCode }</td>
      </tr>

	 <tr>
       <th width="20%">注册时间</th>
       <td>&nbsp; <s:date name="registerTime" format="yyyy-MM-dd HH:mm:ss" /> </td>
     </tr>
     
	 <tr>
      <th width="20%">联系人</th>
      <td>&nbsp;${linkman }</td>
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
      <th width="20%">审核机构</th>
      <td>&nbsp;</td>
      </tr>

     <tr>
      <th width="20%">审核状态</th>
      <td>&nbsp;${state==1? "审核通过" : (state==2 ? "未通过" : "未审核") }</td>
      </tr>
     
    </table>
     
</div><!--content-->