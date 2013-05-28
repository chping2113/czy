package com.kjlink.ahpips;

import java.util.Date;
import java.util.List;

import junit.framework.TestCase;

import org.junit.BeforeClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kjlink.ahpips.entity.system.Permission;
import com.kjlink.ahpips.entity.system.Role;
import com.kjlink.ahpips.entity.system.RolePermission;
import com.kjlink.ahpips.service.system.PermissionService;
import com.kjlink.ahpips.service.system.Role1Service;
import com.kjlink.ahpips.service.system.RolePermissionService;

public class RolePermissionTest extends TestCase{

	/**
	 * ¿∏ƒø≤‚ ‘¿‡
	 */
	private static ApplicationContext ctx ;
	
	@BeforeClass
	public static void beforeClass() throws Exception{
		
			ctx = new ClassPathXmlApplicationContext(new String[] {"config/spring/applicationContext.xml", "config/spring/applicationContext-dao.xml"});
		
	}
	
	
	
	public static void main(String args[]) throws Exception {
		beforeClass();
		RolePermissionService service = (RolePermissionService) ctx.getBean("rolePermissionService");
		Role1Service service1 = (Role1Service) ctx.getBean("role1Service");
		PermissionService service2 = (PermissionService) ctx.getBean("permissionService");
		
		String rId = "40280c603a0726fd013a072714230002";
		
		Role role = service1.findById(rId);
		
		List<Permission> p = service2.findAll();
		
		RolePermission rp = new RolePermission();
		for(int i=0;i<p.size();i++){
		rp.setRoleName(role.getName());
		rp.setRoleId(role);
		
		rp.setPermissionId(p.get(i));
		rp.setPermissionName(p.get(i).getName());
		
		rp.setCreateTime(new Date());
		rp.setUpdateTime(new Date());
		
		service.save(rp);
		}
		
		
	}
	
	

}


