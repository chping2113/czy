/** 
  * @title:  
  * @description:   
  * @copyright: 凯捷技术有限公司 
  * @author: 
  * @version: 1.0
  * @created: 2010-09-20
*/

package com.kjlink.ahpips.service.system.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.brady.common.page.PageInfo;
import com.kjlink.ahpips.dao.system.*;
import com.kjlink.ahpips.entity.system.*;
import com.kjlink.ahpips.service.impl.BaseServiceImpl;
import com.kjlink.ahpips.service.system.*;


/**
 * 
 * 作者：brady.zh
 * 创建：2010-11-4
 */

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {
	private UserDAO userDAO;
	private RoleDAO roleDAO;
	
	public PageInfo findPageAll(int pageNo, int pageSize) {
		return this.userDAO.findPageAll(pageNo, pageSize);
	}
	public PageInfo findPageAllBySite(int pageNo, int pageSize,User user,String queryCode){
		return this.userDAO.findPageAllBySite(pageNo,pageSize,user,queryCode);
	}
	
	public User findByCode(String code) {
		return this.userDAO.findUniqueResultByProperty("code", code);
	}
	
	public boolean isValidUser(String code, String password) {
		User u = this.findByCode(code);
		return u != null && u.getPassword().equals(password) && new Integer(1).equals(u.getState());
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		super.setCommonDAO(userDAO); //父类的方法一定要被调用,否则会出错
		this.userDAO = userDAO;
	}

	public List<User> findUsersByRoleName(String roleName) {
		return this.userDAO.findUsersByRoleName(roleName);
	}

	public boolean checkUserInRole(User user, String roleName) {
		List<User> users = this.findUsersByRoleName(roleName);
		for(User u : users) {
			if(u.getId().equals(user.getId())) {
				return true;
			}
		}
		return false;
	}
	
	
	/**
	 * 根据角色ID返回该角色下的用户ID与用户对象的映射
	 * @param roleId
	 * @return
	 */
	public Map<Integer, User> findUserIdNameMapByRoleId(Integer roleId) {
		Role role = this.roleDAO.findById(roleId);
		List<User> users = roleDAO.findUsersByRoleId(role.getId());
		Map<Integer, User> userMap = new HashMap<Integer, User>(users.size());
		for(User u : users) {
			userMap.put(u.getId(), u);
		}
		return userMap;
	}

	public RoleDAO getRoleDAO() {
		return roleDAO;
	}

	public void setRoleDAO(RoleDAO roleDAO) {
		this.roleDAO = roleDAO;
	}
	
	public PageInfo searchUsersByCode(String code, int pageNo, int pageSize) {
		return this.userDAO.searchUsersByCode(code, pageNo, pageSize);
	}
	
	/**
	 * 检查邮箱是否已经使用
	 * @param email
	 * @return
	 */
	public boolean checkEmailExists(String email) {
		return this.userDAO.checkEmailExists(email);
	}

	public boolean checkEmailExistsEdit(String email,int id){
		return this.userDAO.checkEmailExistsEdit(email,id);
	}

	public List<User> findApproveUser(Site site){
		return this.userDAO.findApproveUser(site);
	}

	public List<User> findBySite(Site site){
		return this.userDAO.findBySite(site);
	}
}
