package com.kjlink.ahpips;

import java.util.Date;

import junit.framework.TestCase;

import org.junit.BeforeClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kjlink.ahpips.entity.system.Permission;
import com.kjlink.ahpips.service.system.PermissionService;

public class PermissionTest extends TestCase{

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
		PermissionService service = (PermissionService) ctx.getBean("permissionService");
		
		
		Permission p = new Permission();
		
		p.setName("上报4");
		//p.setRolePermission(rolePermission)
		p.setState(1);
		p.setCreateTime(new Date());
		p.setUpdateTime(new Date());
		
		service.save(p);
		
		
		
	}
	
	

}


