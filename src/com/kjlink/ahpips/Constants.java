package com.kjlink.ahpips;

import java.io.File;


import com.brady.common.util.ResourceLoader;

public class Constants {
	// ���ڼ����ⲿ��Դ�����ļ�system_config.properties
	private static ResourceLoader systemConfig = ResourceLoader
			.getInstance("system_config");

	//ϵͳȱʡ���û���¼����
	public static final String DEFAULT_PASSWORD = systemConfig.getString("default.password", "123456");
	
	// ����ҳ��ʾ����
	public static final int MAX_PAGE_SIZE = Integer.parseInt(systemConfig
			.getString("page.page_size", "10"));
	  
	//�������������ϴ���ͼƬ�ı���Ŀ¼
	public static final String  UPLOAD_IMAGE_FILE_PATH = "upload_images"  + java.io.File.separator;

	//��Ŀ��ŵ���ˮ�ų���
	public static final int PROJECT_SERIAL_LENGTH = 5;	
	
	//�ʼ�֪ͨģ���ļ���
	public static final String EMAIL_TEMPLATE_NAME = "WEB-INF" + File.separator 
		+ "templates" + File.separator + "email" + File.separator + "email_template.html";
	
	//����֪ͨ�ʼ���ģ���ļ��еİ�����Ŀ��������ַ
	public static final String URL_AHXMGK = systemConfig.getString("url.ahxmgk", "");
	
	//�����ҵ��λ���Է��ʵ�URL��Ϣ������Զ��ŷָ�
	public static final String ALLOWED_URL_COMPANY = systemConfig.getString("allowed.url.company");
	
	//�����ҵ���˿��Է��ʵ�URL��Ϣ������Զ��ŷָ�
	public static final String ALLOWED_URL_PERSON = systemConfig.getString("allowed.url.person");
	//������Ŀ���赥λ���Է��ʵ�URL��Ϣ������Զ��ŷָ�
	public static final String ALLOWED_URL_CONSTRUCT = systemConfig.getString("allowed.url.construct");
	
	//ʡƽ̨��֯��������
	public static final String ANHUI = "340000000";
	
	public static final String LOGO_IMAGE = "logo_images";
	
	public static final String UPLOAD_FILE = "upload_files";
	public static final String APPROVE_ROLE = " ( u.role.name = '��Ϣ������Ա' or u.role.name = '���赥λ���Ա' ) ";//��˽�ɫ

	public static final String EDUCATION_CODE = "340000004";//ʡ����������
	public static final String HYGIENE_CODE = "340000023";//ʡ����������
	public static final String NATIONAL_CODE = "340000027";//ʡ����ί����
	
	
	public static final String STATE0 = "δ�ύ";//״̬δ�ύ
	public static final String STATE1 = "���ͨ��";//״̬���ͨ��
	public static final String STATE2 = "���δͨ��";//״̬���δͨ��
	public static final String STATE3 = "�����";//״̬�����

}
