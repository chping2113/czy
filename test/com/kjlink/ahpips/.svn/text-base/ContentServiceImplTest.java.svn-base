package com.kjlink.ahpips;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kjlink.ahpips.entity.info.Content;
import com.kjlink.ahpips.service.info.ContentService;

public class ContentServiceImplTest{

	
	
private static ApplicationContext ctx ;
	
	@BeforeClass
	public static void beforeClass() throws Exception{
		
			ctx = new ClassPathXmlApplicationContext("applicationContext*.xml");
		
	}
	
	@Test
	public void testSave() {
		ContentService service=(ContentService)ctx.getBean("contentService");
		 Content content=new Content();
		 service.save(content);
		 
		
	}

	
	
	
}
