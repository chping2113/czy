package com.kjlink.ahpips.service.index;

import java.util.*;

import com.brady.common.page.PageInfo;
import com.brady.common.service.CommonService;
import com.kjlink.ahpips.entity.info.*;

public interface IndexService {
	
	/**
	 * �һ�����
	 * code: Ҫ�һ�������ʺ�
	 * type: ����������ʻ�����:user,company,person
	 * emailTemplateName: �ʼ�ģ���ļ���
	 */
	public void takeBakePassword(String type, String code, String emailTemplateName)  throws Exception;
	
	/**
	 * �û��ʺ�����
	 * @param type�������������ͣ�company,person
	 * @param code���û��ʺ�
	 * @param emailTemplateName���ʼ�ģ���ļ���
	 * @throws Exception
	 */
	public void subApprovalOfInfo(String type, String code, String emailTemplateName)  throws Exception;
	
	/**
	 * ���Ų�ѯ�������ز�ѯ����
	 * @param type
	 * @param email
	 * @param password
	 * @param emailTemplateName
	 * @throws Exception
	 */
	public void takeCreditPassword(String type, String email, String password, String applyer, String emailTemplateName)  throws Exception;
}
