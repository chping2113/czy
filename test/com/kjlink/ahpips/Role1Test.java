package com.kjlink.ahpips;

import java.util.Date;

import junit.framework.TestCase;

import org.junit.BeforeClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kjlink.ahpips.entity.system.Role;
import com.kjlink.ahpips.service.system.Role1Service;

public class Role1Test extends TestCase{

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
		
		Role1Service service = (Role1Service) ctx.getBean("role1Service");
		
		Role role = new Role();
		
		role.setName("管理员2");
		role.setState(1);
		role.setCreateTime(new Date());
		role.setUpdateTime(new Date());
		
		service.save(role);
		
		
		
	}
	
	

}


