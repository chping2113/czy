/** 
  * @title:  
  * @description:   
  * @copyright: 凯捷技术有限公司 
  * @author: 
  * @version: 1.0
  * @created: 2010-09-20
*/

package com.kjlink.ahpips.dao.system;

import java.util.*;

import com.brady.common.dao.CommonDAO;
import com.kjlink.ahpips.entity.system.*;

/**
 * 
 * 作者：brady.zh
 * 创建：2010-11-11
 */
public interface ResourceDAO extends CommonDAO<Permission> {
	/**
	 * 查找系统的全部第一级资源列表
	 * @return
	 */
	public List<Permission> findFirstLevelPermission();
	
	public List<Permission> findSecondLevelPermission();
	
	public List<Permission> findChildPermissions(Integer parentId);
	
	/**
	 * 根据roleId数组查询其所对应的一级资源列表
	 * @param roleIds
	 * @return
	 */
	public List<Permission> findFirstLevelPermissionByRoleId(Integer roleId);
	
	/**
	 * 根据上一级资源ID及对应的Role ID返回第二级资源列表
	 * @param firstLevelPermissionId
	 * @param roleIds
	 * @return
	 */
	public List<Permission> findSecondLevelPermissionByRoleId(Integer firstLevelPermissionId, Integer roleId);
	
	/**
	 * 查看系统中不需要进行权限认证的所有的URL
	 * @return
	 */
	public List<String> findIgnoreAuthURLs() ;
	
	public int getChildNodesCount(Integer id);
	
	public List<Permission> findProjectbyParentId(Integer id);

	public List<Permission> findProjectbyParentId2(Integer id);

}
