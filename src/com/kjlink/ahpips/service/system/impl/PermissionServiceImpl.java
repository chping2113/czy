/** 
  * @title:  
  * @description:   
  * @copyright: 凯捷技术有限公司 
  * @author: 
  * @version: 1.0
  * @created: 2010-09-20
*/

package com.kjlink.ahpips.service.system.impl;

import org.springframework.stereotype.Service;

import com.kjlink.ahpips.dao.system.*;
import com.kjlink.ahpips.entity.system.*;
import com.kjlink.ahpips.service.impl.BaseServiceImpl;
import com.kjlink.ahpips.service.system.*;


/**
 * 
 * 作者：brady.zh
 * 创建：2010-11-4
 */

@Service("permissionService")
public class PermissionServiceImpl extends BaseServiceImpl<Permission> implements PermissionService{
	private PermissionDAO permissionDAO;

	public PermissionDAO getPermissionDAO() {
		return permissionDAO;
	}

	public void setPermissionDAO(PermissionDAO permissionDAO) {
		super.setCommonDAO(permissionDAO); 
		this.permissionDAO = permissionDAO;
	}



	
}
