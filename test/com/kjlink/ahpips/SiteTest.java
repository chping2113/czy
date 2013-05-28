package com.kjlink.ahpips;

import junit.framework.TestCase;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kjlink.ahpips.entity.info.Site;
import com.kjlink.ahpips.service.info.SiteService;

public class SiteTest extends TestCase{

	/**
	 * 栏目测试类
	 */
	private static ApplicationContext ctx ;
	
	@BeforeClass
	public static void beforeClass() throws Exception{
		
			ctx = new ClassPathXmlApplicationContext(new String[] {"config/spring/applicationContext.xml", "config/spring/applicationContext-dao.xml"});
		
	}

	@Test
	public void testSave() throws Exception {
		beforeClass();
		
		SiteService siteService = (SiteService) ctx.getBean("siteService");
		
		
		Site s1 = new Site();
		s1.setName("芜湖市中小企业平台");
		s1.setState(1);
		s1.setGrade("市");
		
		Site s2 = new Site();
		s2.setName("肥东县中小企业平台");
		s2.setState(1);
		s2.setGrade("县");
		
		siteService.save(s1);
		siteService.save(s2);
		
	}
	
	

}


