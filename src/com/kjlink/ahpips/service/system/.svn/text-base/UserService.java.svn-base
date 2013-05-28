/** 
  * @title:  
  * @description:   
  * @copyright: 凯捷技术有限公司 
  * @author: 
  * @version: 1.0
  * @created: 2010-09-20
*/

package com.kjlink.ahpips.service.system;

import java.util.*;
import com.brady.common.page.PageInfo;
import com.kjlink.ahpips.entity.system.*;
import com.kjlink.ahpips.service.BaseService;

/**
 * 
 * 作者：brady.zh
 * 创建：2010-11-11
 */
public interface UserService extends BaseService<User> {
	public PageInfo findPageAll(int pageNo, int pageSize);
	public PageInfo findPageAllBySite(int pageNo, int pageSize,User user ,String queryCode );
	
	public PageInfo searchUsersByCode(String code, int pageNo, int pageSize);
	
	public User findByCode(String code); //根据用户帐号返回唯一的用户对象
	
	public boolean isValidUser(String code, String password); //根据用户帐号和密码检查该帐号是不是有效的帐号
	
	public List<User> findUsersByRoleName(String roleName); //根据角色名称查找该角色下面的用户
	
	public boolean checkUserInRole(User user, String roleName); //判断用户是不是在指定的角色中
	
	
	/**
	 * 根据角色ID返回该角色下的用户ID与用户对象的映射
	 * @param roleId
	 * @return
	 */
	public Map<Integer, User> findUserIdNameMapByRoleId(Integer roleId);
	
	/**
	 * 检查邮箱是否已经使用
	 * @param email
	 * @return
	 */
	public boolean checkEmailExists(String email);

	public boolean checkEmailExistsEdit(String email,int id);
	public List<User> findApproveUser(Site site);
	public List<User> findBySite(Site site);
	
}
