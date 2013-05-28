package com.kjlink.ahpips.service.index;

import java.util.*;

import com.brady.common.page.PageInfo;
import com.brady.common.service.CommonService;
import com.kjlink.ahpips.entity.info.*;

public interface IndexService {
	
	/**
	 * 找回密码
	 * code: 要找回密码的帐号
	 * type: 密码密码的帐户类型:user,company,person
	 * emailTemplateName: 邮件模板文件名
	 */
	public void takeBakePassword(String type, String code, String emailTemplateName)  throws Exception;
	
	/**
	 * 用户帐号审批
	 * @param type：找审批的类型：company,person
	 * @param code：用户帐号
	 * @param emailTemplateName：邮件模板文件名
	 * @throws Exception
	 */
	public void subApprovalOfInfo(String type, String code, String emailTemplateName)  throws Exception;
	
	/**
	 * 诚信查询审批返回查询密码
	 * @param type
	 * @param email
	 * @param password
	 * @param emailTemplateName
	 * @throws Exception
	 */
	public void takeCreditPassword(String type, String email, String password, String applyer, String emailTemplateName)  throws Exception;
}
