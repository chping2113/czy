package com.kjlink.ahpips;

import java.io.File;


import com.brady.common.util.ResourceLoader;

public class Constants {
	// 用于加载外部资源配置文件system_config.properties
	private static ResourceLoader systemConfig = ResourceLoader
			.getInstance("system_config");

	//系统缺省的用户登录密码
	public static final String DEFAULT_PASSWORD = systemConfig.getString("default.password", "123456");
	
	// 最大分页显示条数
	public static final int MAX_PAGE_SIZE = Integer.parseInt(systemConfig
			.getString("page.page_size", "10"));
	  
	//发布新闻中所上传的图片的保存目录
	public static final String  UPLOAD_IMAGE_FILE_PATH = "upload_images"  + java.io.File.separator;

	//项目编号的流水号长度
	public static final int PROJECT_SERIAL_LENGTH = 5;	
	
	//邮件通知模板文件名
	public static final String EMAIL_TEMPLATE_NAME = "WEB-INF" + File.separator 
		+ "templates" + File.separator + "email" + File.separator + "email_template.html";
	
	//用在通知邮件的模板文件中的安徽项目公开网网址
	public static final String URL_AHXMGK = systemConfig.getString("url.ahxmgk", "");
	
	//定义从业单位可以访问的URL信息，多个以逗号分隔
	public static final String ALLOWED_URL_COMPANY = systemConfig.getString("allowed.url.company");
	
	//定义从业个人可以访问的URL信息，多个以逗号分隔
	public static final String ALLOWED_URL_PERSON = systemConfig.getString("allowed.url.person");
	//定义项目建设单位可以访问的URL信息，多个以逗号分隔
	public static final String ALLOWED_URL_CONSTRUCT = systemConfig.getString("allowed.url.construct");
	
	//省平台组织机构代码
	public static final String ANHUI = "340000000";
	
	public static final String LOGO_IMAGE = "logo_images";
	
	public static final String UPLOAD_FILE = "upload_files";
	public static final String APPROVE_ROLE = " ( u.role.name = '信息审批人员' or u.role.name = '建设单位审核员' ) ";//审核角色

	public static final String EDUCATION_CODE = "340000004";//省教育厅代码
	public static final String HYGIENE_CODE = "340000023";//省卫生厅代码
	public static final String NATIONAL_CODE = "340000027";//省国资委代码
	
	
	public static final String STATE0 = "未提交";//状态未提交
	public static final String STATE1 = "审核通过";//状态审核通过
	public static final String STATE2 = "审核未通过";//状态审核未通过
	public static final String STATE3 = "待审核";//状态待审核

}
