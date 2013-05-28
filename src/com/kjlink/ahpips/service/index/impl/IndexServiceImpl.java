package com.kjlink.ahpips.service.index.impl;

import java.util.Date;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.brady.common.util.EmailTemplate;
import com.brady.common.util.MD5Generator;
import com.brady.common.util.MyToolkit;
import com.kjlink.ahpips.Constants;
import com.kjlink.ahpips.entity.system.*;
import com.kjlink.ahpips.service.index.IndexService;
import com.kjlink.ahpips.service.system.*;
import com.kjlink.common.util.StringUtil;

@Component("indexService")
public class IndexServiceImpl implements IndexService {
	private EmailTemplate mailTemplate;
	private UserService userService;

	private ConstructService constructService;

	public EmailTemplate getMailTemplate() {
		return mailTemplate;
	}

	public void setMailTemplate(EmailTemplate mailTemplate) {
		this.mailTemplate = mailTemplate;
	}
	
	/**
	 * 找回密码
	 * type: 密码密码的帐户类型:user,company,person
	 * code: 要找回密码的帐号
	 * emailTemplateName: 邮件模板文件名
	 */
	public void takeBakePassword(String type, String code, String emailTemplateName) throws Exception {
		String name = code;
		String newPassword = StringUtil.getRandomString(6);
		String md5Password = MD5Generator.getMD5Value(newPassword);
		String to = "";
		
		if("user".equals(type)) {
			User user = this.userService.findByCode(code);
			to = user.getEmail();
			user.setPassword(md5Password);
			this.userService.update(user);
		} 
		else {
			Construct construct = this.constructService.findByCode(code);
			to = construct.getEmail();
			construct.setPassword(md5Password);
			this.constructService.update(construct);
		}
		
		this.mailTemplate.loadContent(emailTemplateName);
		this.mailTemplate.replaceVariable("name", "尊敬的安徽项目公开网用户" + name);
		this.mailTemplate.replaceVariable("title", "安徽项目公开网");
		
		String ahxmgkUrl = Constants.URL_AHXMGK;
		String from = "<a href='" + ahxmgkUrl + "' target='_blank'>安徽项目公开网</a>";
		this.mailTemplate.replaceVariable("from", from);
		
		String time = MyToolkit.formatDateTime(new Date(), "yyyy-MM-dd");
		this.mailTemplate.replaceVariable("sendTime", time);
		this.mailTemplate.replaceVariable("content", "您的登录帐号是：" + code 
				+ ",新的登录密码为:" + newPassword
				+ ",为了您的帐户安全，建议您使用此密码登录系统后，重新设定新密码。");
		
		//发送邮件
		this.mailTemplate.setSubject("安徽项目公开网-找回密码");
//		this.mailTemplate.setFrom("master@ahxmgk.org.cn");
		this.mailTemplate.setTo(to);
		this.mailTemplate.send();
	}
	
	public void subApprovalOfInfo(String type, String code, String emailTemplateName)  throws Exception{
		String to = "";
		int state = 0;
		String call = "";
		
		
			Construct construct=this.constructService.findByCode(code);
			to = construct.getEmail();
			state = construct.getState();
			call="建设单位";
		
		
		this.mailTemplate.loadContent(emailTemplateName);
		this.mailTemplate.replaceVariable("name", code );
		this.mailTemplate.replaceVariable("title", "安徽项目公开网");
		
		String ahxmgkUrl = Constants.URL_AHXMGK;
		String from = "<a href='" + ahxmgkUrl + "' target='_blank'>安徽项目公开网</a>";
		this.mailTemplate.replaceVariable("from", from);
		
		String time = MyToolkit.formatDateTime(new Date(), "yyyy-MM-dd");
		this.mailTemplate.replaceVariable("sendTime", time);
		
		if(state == 1){
			this.mailTemplate.replaceVariable("content", call + "申请的帐号：" + code 
					+ ",已经审批通过，欢迎登录安徽项目公开网。");
		}else{
			this.mailTemplate.replaceVariable("content", call + "申请的帐号：" + code 
					+ ",未获得审批通过，请完善您的注册信息或联系安徽项目公开网。");	
		}
		
		//发送邮件
		this.mailTemplate.setSubject("安徽项目公开网-注册信息审批");
//		this.mailTemplate.setFrom("master@ahxmgk.org.cn");
		this.mailTemplate.setTo(to);
		this.mailTemplate.send();
	}
	
	public ConstructService getConstructService() {
		return constructService;
	}

	public void setConstructService(ConstructService constructService) {
		this.constructService = constructService;
	}

	public void takeCreditPassword(String type, String email, String password, String applyer, String emailTemplateName)  throws Exception{
		String call = "";
		
		if("company".equals(type)) {
			call = "企业诚信档案查询";
		} else {
			call = "个人诚信档案查询";
		}
		
		this.mailTemplate.loadContent(emailTemplateName);
		this.mailTemplate.replaceVariable("name", applyer + "您好" );
		this.mailTemplate.replaceVariable("title", "安徽项目公开网");
		
		String ahxmgkUrl = Constants.URL_AHXMGK;
		String from = "<a href='" + ahxmgkUrl + "' target='_blank'>安徽项目公开网</a>";
		this.mailTemplate.replaceVariable("from", from);
		
		String time = MyToolkit.formatDateTime(new Date(), "yyyy-MM-dd");
		this.mailTemplate.replaceVariable("sendTime", time);
		
		this.mailTemplate.replaceVariable("content", "您申请的"+ call +"帐号：" + applyer 
					+ ",已经审批通过，密码为："+password+",欢迎使用此密码登录安徽项目公开网进行查询。");
		
		//发送邮件
		this.mailTemplate.setSubject("安徽项目公开网-注册信息审批");
//		this.mailTemplate.setFrom("ahpips@163.com");
		this.mailTemplate.setTo(email);
		this.mailTemplate.send();
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	
}
