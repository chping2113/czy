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
import com.kjlink.ahpips.pojo.ZTree;
import com.kjlink.ahpips.service.BaseService;

/**
 * 
 * 作者：brady.zh
 * 创建：2010-11-11
 */
public interface RoleService extends BaseService<Role> {
	public Role findByName(String name);
	
	public PageInfo searchByName(int pageNo, int pageSize, String name);
	
	/**
	 * 根据角色ID查看其对应的用户信息
	 * @param pageNo
	 * @param pageSize
	 * @param code
	 * @param name
	 * @return
	 */
	public PageInfo findUsersByRoleId(int pageNo, int pageSize, int roleId); 
	public PageInfo findUsersByRoleId(int pageNo, int pageSize, int roleId,String str); 
	
	/**
	 * 查找系统的全部第一级资源列表
	 * @return
	 */
	public List<Permission> findFirstLevelPermission();
	
	/**
	 * 返回第一级资源ID及其对应的所有子资源列表的映射
	 * @return
	 */
	public Map<Integer, List<Permission>> findFirstPermissionMap();
	
	/**
	 * 返回第二级资源ID及其对应的所有子资源列表的映射
	 * @return
	 */
	public Map<Integer, List<Permission>> findSecondPermissionMap();
	
	/**
	 * 返回角色ID及其对应的所有资源列表的映射
	 * Key: 对应的资源ID,
	 * Value: 如果有对应，就是简单的"ok"值
	 * @param roleId
	 * @return
	 */
	public Map<Integer, String> findPermissionIdMap(Role role);
	
	/**
	 * 为指定的角色关联PermissionIds所包含的资源
	 * @param role
	 * @param PermissionIds
	 */
	public void setPermissionPower(Role role, String[] PermissionIds);
	
	/**
	 * 返回一个用户所对应的角色列表
	 */
	public List<Permission> findRolePermissionListByUserId(Integer userId);
	
	
	public List<Permission> findMenuPermissionByUserId(Integer userId);
	
	/**
	 * 根据第一级资源菜单返回一个Key为第一级资源ID，Value为其对应的第二级资源列表的Map
	 * @param firstPermissionList
	 * @return
	 */
	public Map<Integer, List<Permission>> findFirstIdSecondPermissionMap(Integer userId, List<Permission> firstPermissionList);
	
	/**
	 * 查看系统中不需要进行权限认证的所有的URL
	 * @return
	 */
	public List<String> findIgnoreAuthURLs();
	
	/**
	 * 构造全部资源树
	 */
	public List<ZTree> buildFullPermissionTree() ;
	
	public void savePermission(Permission Permission);
	
	public Permission findPermissionById(Integer PermissionId);
	
	public void updatePermission(Permission Permission);
	
	public void deletePermission(Permission Permission);
	
	public int getChildNodesCount(Integer id);
}
