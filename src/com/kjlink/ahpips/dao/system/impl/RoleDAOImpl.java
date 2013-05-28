/** 
  * @title:  
  * @description:   
  * @copyright: 凯捷技术有限公司 
  * @author: 
  * @version: 1.0
  * @created: 2010-09-20
*/

package com.kjlink.ahpips.dao.system.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.brady.common.page.PageInfo;
import com.kjlink.ahpips.dao.impl.BaseDAOImpl;
import com.kjlink.ahpips.dao.system.*;
import com.kjlink.ahpips.entity.system.*;


/**
 * 
 * 作者：brady.zh
 * 创建：2010-11-4
 */

@Component("roleDAO")
public class RoleDAOImpl extends BaseDAOImpl<Role> implements RoleDAO {
	public RoleDAOImpl() {
		super(Role.class);
	}
	public Role findByName(String name) {
		return this.findUniqueResultByProperty("name", name);
	}
	
	public PageInfo searchByName(int pageNo, int pageSize, String name) {
		name = name == null ? "" : name;
		String hql = "from Role r where r.name like ? order by r.name";
		return this.findPageInfoByHql(pageNo, pageSize, hql, new String[] {"%" + name + "%"});
	}
	
	public PageInfo findUsersByRoleId(int pageNo, int pageSize, Integer roleId) {
		String hql = "from User u where u.role.id=? order by u.id desc";
		return this.findPageInfoByHql(pageNo, pageSize, hql, new Integer[] {roleId});
	}


	public PageInfo findUsersByRoleId(int pageNo, int pageSize, int roleId,String str){
		str = str == null ? "" : str;
		String hql = "from User u where u.role.id="+roleId+" and (u.code like ? or u.site.name like ?) order by u.id desc";
		return this.findPageInfoByHql(pageNo, pageSize, hql,  new String[] {"%" + str + "%","%" + str + "%"});
	}
	public List<User> findUsersByRoleId(Integer roleId) {
		String hql = "from User u where u.role.id=? order by u.id desc";
		return this.findByHql(hql, new Integer[] {roleId});
	}

}
