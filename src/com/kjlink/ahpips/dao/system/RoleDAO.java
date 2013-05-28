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
import com.kjlink.ahpips.entity.system.*;

/**
 * 
 * 作者：brady.zh
 * 创建：2010-11-11
 */
public interface RoleDAO extends CommonDAO<Role> {
	/**
	 * 根据名称查唯一的对象
	 * @param name
	 * @return
	 */
	public Role findByName(String name);
	 
	/**
	 * 根据名称模糊查询
	 * @param pageNo
	 * @param pageSize
	 * @param name
	 * @return
	 */
	public PageInfo searchByName(int pageNo, int pageSize, String name);
	
	/**
	 * 根据角色ID查看其对应的用户信息
	 * @param pageNo
	 * @param pageSize
	 * @param code
	 * @param name
	 * @return
	 */
	public PageInfo findUsersByRoleId(int pageNo, int pageSize, Integer roleId); 

	public PageInfo findUsersByRoleId(int pageNo, int pageSize, int roleId,String str);
	public List<User> findUsersByRoleId(Integer roleId);
}
