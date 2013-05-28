package com.kjlink.ahpips;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;

import com.kjlink.TestBase;
import com.kjlink.ahpips.entity.system.Permission;
import com.kjlink.ahpips.entity.system.Role;
import com.kjlink.ahpips.entity.system.RolePermission;
import com.kjlink.ahpips.service.system.PermissionService;
import com.kjlink.ahpips.service.system.Role1Service;
import com.kjlink.ahpips.service.system.RolePermissionService;

public class RolePermissionServiceTest extends TestBase{
	
	private static ApplicationContext ctx ;
	
	@Resource 
	RolePermissionService rolePermissionService;
	
	@Resource 
	Role1Service role1Service;
	
	@Resource 
	PermissionService permissionService;
	
	
	

	@Test
	public void testGetRolePermissionDAO() throws Exception {
		//ctx = super.setUpBeforeClass();
		
		rolePermissionService = (RolePermissionService) ctx.getBean("rolePermissionService");
		
		role1Service = (Role1Service) ctx.getBean("role1Service");
		
		permissionService = (PermissionService) ctx.getBean("permissionService");
		
		String rId = "40280c603a07189f013a0718ac170001";
		
		Role role = role1Service.findById(rId);
		
		List<Permission> p = permissionService.findAll();
		
		RolePermission rp = new RolePermission();
		for(int i=0;i<p.size();i++){
			rp.setRoleName(role.getName());
			rp.setRoleId(role);
			
			rp.setPermissionId(p.get(i));
			rp.setPermissionName(p.get(i).getName());
			
			rp.setCreateTime(new Date());
			rp.setUpdateTime(new Date());
			
			rolePermissionService.save(rp);
			
			assertNotNull(rp.getRoleName());
		
		}
		
		
	
	}

}
