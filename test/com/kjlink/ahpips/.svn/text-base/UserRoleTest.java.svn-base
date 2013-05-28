package com.kjlink.ahpips;

import java.util.Date;

import junit.framework.TestCase;

import org.junit.BeforeClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kjlink.ahpips.entity.system.Role;
import com.kjlink.ahpips.entity.system.User;
import com.kjlink.ahpips.entity.system.UserRole;
import com.kjlink.ahpips.service.system.Role1Service;
import com.kjlink.ahpips.service.system.User1Service;
import com.kjlink.ahpips.service.system.UserRoleService;

public class UserRoleTest extends TestCase{

	/**
	 * 栏目测试类
	 */
	private static ApplicationContext ctx ;
	
	@BeforeClass
	public static void beforeClass() throws Exception{
		
			ctx = new ClassPathXmlApplicationContext(new String[] {"config/spring/applicationContext.xml", "config/spring/applicationContext-dao.xml"});
		
	}
	
	
	
	/*public static void main(String args[]) throws Exception {
		beforeClass();
		
		UserRoleService service = (UserRoleService) ctx.getBean("userRoleService");
		User1Service service2 = (User1Service) ctx.getBean("user1Service");
		Role1Service service3 = (Role1Service) ctx.getBean("role1Service");
		
		User1 user1 = new User1();
		
		user1.setName("小红");
		user1.setState(1);
		user1.setPassword("xiaohong");
		user1.setCreateTime(new Date());
		user1.setUpdateTime(new Date());
		
		service2.save(user1);
		
		Role1 role1 = new Role1();
		role1.setName("发布人员");
		role1.setState(1);
		role1.setCreateTime(new Date());
		role1.setUpdateTime(new Date());
		service3.save(role1);
		
		UserRole ur = new UserRole();
		ur.setUserId(user1);
		ur.setRoleId(role1);
		ur.setUserName(user1.getName());
		ur.setRoleName(role1.getName());
		
		ur.setCreateTime(new Date());
		ur.setUpdateTime(new Date());
		service.save(ur);		
	}*/
	
	public static void main(String args[]) throws Exception {
		beforeClass();
		
		UserRoleService service = (UserRoleService) ctx.getBean("userRoleService");
		User1Service service2 = (User1Service) ctx.getBean("user1Service");
		Role1Service service3 = (Role1Service) ctx.getBean("role1Service");
		
		String uId = "40280c603a0726fd013a072713c50001";
		
		User user1 = service2.findById(uId);
		
		System.out.println(user1.getName());
		
		String rId = "40280c603a07189f013a0718ac170001";
		
		Role role1 = service3.findById(rId);
		
		System.out.println(role1.getName());
		
		UserRole ur = new UserRole();
		ur.setUserId(user1);
		ur.setRoleId(role1);
		ur.setUserName(user1.getName());
		ur.setRoleName(role1.getName());
		
		ur.setCreateTime(new Date());
		ur.setUpdateTime(new Date());
		service.save(ur);		
	}
	
	

}


