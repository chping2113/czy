/** 
  * @title:  
  * @description:   
  * @copyright: ���ݼ������޹�˾ 
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
 * ���ߣ�brady.zh
 * ������2010-11-11
 */
public interface RoleService extends BaseService<Role> {
	public Role findByName(String name);
	
	public PageInfo searchByName(int pageNo, int pageSize, String name);
	
	/**
	 * ���ݽ�ɫID�鿴���Ӧ���û���Ϣ
	 * @param pageNo
	 * @param pageSize
	 * @param code
	 * @param name
	 * @return
	 */
	public PageInfo findUsersByRoleId(int pageNo, int pageSize, int roleId); 
	public PageInfo findUsersByRoleId(int pageNo, int pageSize, int roleId,String str); 
	
	/**
	 * ����ϵͳ��ȫ����һ����Դ�б�
	 * @return
	 */
	public List<Permission> findFirstLevelPermission();
	
	/**
	 * ���ص�һ����ԴID�����Ӧ����������Դ�б��ӳ��
	 * @return
	 */
	public Map<Integer, List<Permission>> findFirstPermissionMap();
	
	/**
	 * ���صڶ�����ԴID�����Ӧ����������Դ�б��ӳ��
	 * @return
	 */
	public Map<Integer, List<Permission>> findSecondPermissionMap();
	
	/**
	 * ���ؽ�ɫID�����Ӧ��������Դ�б��ӳ��
	 * Key: ��Ӧ����ԴID,
	 * Value: ����ж�Ӧ�����Ǽ򵥵�"ok"ֵ
	 * @param roleId
	 * @return
	 */
	public Map<Integer, String> findPermissionIdMap(Role role);
	
	/**
	 * Ϊָ���Ľ�ɫ����PermissionIds����������Դ
	 * @param role
	 * @param PermissionIds
	 */
	public void setPermissionPower(Role role, String[] PermissionIds);
	
	/**
	 * ����һ���û�����Ӧ�Ľ�ɫ�б�
	 */
	public List<Permission> findRolePermissionListByUserId(Integer userId);
	
	
	public List<Permission> findMenuPermissionByUserId(Integer userId);
	
	/**
	 * ���ݵ�һ����Դ�˵�����һ��KeyΪ��һ����ԴID��ValueΪ���Ӧ�ĵڶ�����Դ�б��Map
	 * @param firstPermissionList
	 * @return
	 */
	public Map<Integer, List<Permission>> findFirstIdSecondPermissionMap(Integer userId, List<Permission> firstPermissionList);
	
	/**
	 * �鿴ϵͳ�в���Ҫ����Ȩ����֤�����е�URL
	 * @return
	 */
	public List<String> findIgnoreAuthURLs();
	
	/**
	 * ����ȫ����Դ��
	 */
	public List<ZTree> buildFullPermissionTree() ;
	
	public void savePermission(Permission Permission);
	
	public Permission findPermissionById(Integer PermissionId);
	
	public void updatePermission(Permission Permission);
	
	public void deletePermission(Permission Permission);
	
	public int getChildNodesCount(Integer id);
}
