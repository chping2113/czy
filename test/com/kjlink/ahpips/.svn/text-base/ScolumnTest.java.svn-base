package com.kjlink.ahpips;

import java.util.Date;

import junit.framework.TestCase;

import org.junit.BeforeClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kjlink.ahpips.entity.info.Scolumn;
import com.kjlink.ahpips.service.info.ScolumnService;

public class ScolumnTest extends TestCase{

	/**
	 * 栏目测试类
	 */
	private static ApplicationContext ctx ;
	
	@BeforeClass
	public static void beforeClass() throws Exception{
		
			ctx = new ClassPathXmlApplicationContext(new String[] {"config/spring/applicationContext.xml", "config/spring/applicationContext-dao.xml"});
		
	}
	
	
	
	public static void main(String args[]) throws Exception {
		beforeClass();
		
		ScolumnService service = (ScolumnService) ctx.getBean("scolumnService");
		
		Scolumn scolumn = new Scolumn();
		
		scolumn.setName("新闻2");
		scolumn.setState(1);
		scolumn.setCreateTime(new Date());
		scolumn.setUpdateTime(new Date());
		
		service.save(scolumn);
		
		
		
	}
	
	

}


