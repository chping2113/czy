/** 
  * @title:  
  * @description:   
  * @copyright: 凯捷技术有限公司 
  * @author: 
  * @version: 1.0
  * @created: 2010-09-20
*/

package com.kjlink.ahpips.dao.system;

import java.util.List;

import com.brady.common.dao.CommonDAO;
import com.brady.common.page.PageInfo;
import com.kjlink.ahpips.entity.system.Site;
import com.kjlink.ahpips.entity.system.Site;
import com.kjlink.ahpips.entity.system.User;

/**
 * 
 * 作者：brady.zh
 * 创建：2010-11-11
 */
public interface UserDAO extends CommonDAO<User> {
	public PageInfo findPageAll(int pageNo, int pageSize);

	public PageInfo findPageAllBySite(int pageNo, int pageSize,User user,String queryCode);
	
	List<User> findUsersByRoleName(String roleName); //根据角色名称查找该角色下面的用户
	
	public PageInfo searchUsersByCode(String code, int pageNo, int pageSize);
	
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
