package com.kjlink.ahpips;

import java.util.Date;
import java.util.List;

import junit.framework.TestCase;

import org.junit.BeforeClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kjlink.ahpips.entity.system.User;
import com.kjlink.ahpips.entity.system.UserRole;
import com.kjlink.ahpips.service.system.User1Service;
import com.kjlink.ahpips.service.system.UserRoleService;

public class User1Test extends TestCase{

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
		
		User1Service service = (User1Service) ctx.getBean("user1Service");
		UserRoleService service1 = (UserRoleService) ctx.getBean("userRoleService");
		
		User user = new User();
		
		user.setName("小明");
		user.setState(1);
		user.setPassword("xiaoming");
		user.setCreateTime(new Date());
		
		List<UserRole> userRole = service1.findAll();
		//user.setUserRole(userRole);
		user.setUpdateTime(new Date());
		
		System.out.println(user.getName());
		
		service.save(user);
		
		
		
	}
	
	

}


