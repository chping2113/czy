/** 
  * @title:  
  * @description:   
  * @copyright: ���ݼ������޹�˾ 
  * @author: 
  * @version: 1.0
  * @created: 2010-09-20
*/

package com.kjlink.ahpips.service.system.impl;

import java.util.*;

import org.springframework.stereotype.Service;
import com.brady.common.page.PageInfo;
import com.kjlink.ahpips.Constants;
import com.kjlink.ahpips.dao.system.*;
import com.kjlink.ahpips.entity.system.*;
import com.kjlink.ahpips.pojo.ZTree;
import com.kjlink.ahpips.service.impl.BaseServiceImpl;
import com.kjlink.ahpips.service.system.*;


/**
 * 
 * ���ߣ�brady.zh
 * ������2010-11-4
 */

@Service("roleService")
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService {
	private RoleDAO roleDAO;
	private UserDAO userDAO;
	private PermissionDAO permissionDAO;
	
	public RoleDAO getRoleDAO() {
		return roleDAO;
	}

	public void setRoleDAO(RoleDAO roleDAO) {
		super.setCommonDAO(roleDAO); //����ķ���һ��Ҫ������,��������
		this.roleDAO = roleDAO;
	}

	public Role findByName(String name) {
		return this.roleDAO.findByName(name);
	}
	public PageInfo searchByName(int pageNo, int pageSize, String name) {
		return this.roleDAO.searchByName(pageNo, pageSize, name);
	}

	public PageInfo findUsersByRoleId(int pageNo, int pageSize, int roleId) {
		return this.roleDAO.findUsersByRoleId(pageNo, pageSize, roleId);
	}

	public PageInfo findUsersByRoleId(int pageNo, int pageSize, int roleId,String str){
		return this.roleDAO.findUsersByRoleId(pageNo, pageSize, roleId,str);
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}


	public PermissionDAO getPermissionDAO() {
		return permissionDAO;
	}

	public void setPermissionDAO(PermissionDAO permissionDAO) {
		this.permissionDAO = permissionDAO;
	}
	
	/**
	 * ����ϵͳ��ȫ����һ����Դ�б�
	 * @return
	 */
	public List<Permission> findFirstLevelPermission() {
		return this.permissionDAO.findFirstLevelPermission();
	}

	/**
	 * ����KeyΪһ����ԴID��ValueΪ���Ӧ���¼���Դ�б�
	 */
	public Map<Integer, List<Permission>> findFirstPermissionMap() {
		List<Permission> firstResList = this.findFirstLevelPermission();
		Map<Integer, List<Permission>> firstResMap = new HashMap<Integer, List<Permission>>(firstResList.size());
		for(Permission res : firstResList) {
			List<Permission> childResList = this.permissionDAO.findChildPermissions(res.getId());
			firstResMap.put(res.getId(), childResList);
		}
		return firstResMap;
	}

	/**
	 * ����KeyΪ������ԴID��ValueΪ���Ӧ���¼���Դ�б�
	 */
	public Map<Integer, List<Permission>> findSecondPermissionMap() {
		List<Permission> secondResList= this.permissionDAO.findSecondLevelPermission();
		Map<Integer, List<Permission>> secondResMap = new HashMap<Integer, List<Permission>>(secondResList.size());
		for(Permission res : secondResList) {
			List<Permission> childResList = this.permissionDAO.findChildPermissions(res.getId());
			secondResMap.put(res.getId(), childResList);
		}
		return secondResMap;
	}

	public void setPermissionPower(Role role, String[] PermissionIds) {
		role.getPermissions().clear();
		
		if(PermissionIds != null) {
			for(String resId : PermissionIds) {
				if(resId.trim().length() > 0) {
					Permission res = this.permissionDAO.findById(new Integer(resId));
					res.getRoles().add(role);
					role.getPermissions().add(res);
				}
			}
		}
		
		this.update(role);
	}

	
	public Map<Integer, String> findPermissionIdMap(Role role) {
		Set<Permission> resSet = role.getPermissions();
		Map<Integer, String> roleResMap = new HashMap<Integer, String>(resSet.size());
		for(Permission res : resSet) {
			roleResMap.put(res.getId(), "ok");
		}
		return roleResMap;
	}

	/**
	 * ����һ���û�����Ӧ����Դ�б�
	 */
	public List<Permission> findRolePermissionListByUserId(Integer userId) {
		User user = this.userDAO.findById(userId);
		Set<Permission> resSet = user.getRole().getPermissions();
		List<Permission> resList = new ArrayList<Permission>(resSet.size());
		for(Permission res : resSet) {
			//Ϊ���⼶��̫�����ö��������¹���Permission������Map��
			Permission tmp = new Permission();
			tmp.setId(res.getId());
			tmp.setTitle(res.getTitle());
			tmp.setUrl(res.getUrl());
			tmp.setPosition(res.getPosition());
			resList.add(tmp);
		}
		
		return resList;
	}
	
	
//	private Set<Permission> getPermissions(User user) {
//		// TODO Auto-generated method stub
//		Set<Role> roles = user.getRoles();
//		Iterator<Role> it = roles.iterator();
//		while (it.hasNext()){
//			Role role = it.next();
//			user.setRole(role);
//			Integer id = role.getId();
//			return roleDAO.findById(id).getPermissions();
//		}
//		return null;
//	}

	/**
	 * ����ֻ������ʾ�˵���Permission������ʹ�ü�������
	 * �˵���Ӧ��Դ��ֻ��ǰ����
	 * @return
	 */
	public List<Permission> findMenuPermissionByUserId(Integer userId) {
		User u = this.userDAO.findById(userId);
		Integer roleId = u.getRole().getId();
		List<Permission> firstLevelPermissionList = permissionDAO.findFirstLevelPermissionByRoleId(roleId);
		return firstLevelPermissionList;
	}
	
//	private Integer getRoleId(User user) {
//		// TODO Auto-generated method stub
//		Set<Role> roles = user.getRoles();
//		Iterator<Role> it = roles.iterator();
//		while (it.hasNext()){
//			Role role = it.next();
//			return role.getId();
//		}
//		return null;
//	}

	/**
	 * ���ݵ�һ����Դ�˵�����һ��KeyΪ��һ����ԴID��ValueΪ���Ӧ�ĵڶ�����Դ�б��Map
	 * @param firstPermissionList
	 * @return
	 */
	public Map<Integer, List<Permission>> findFirstIdSecondPermissionMap(Integer userId, List<Permission> firstPermissionList) {
		User user = this.userDAO.findById(userId);
		Integer roleId = user.getRole().getId();
		
		Map<Integer, List<Permission>> firstSecondMap = new HashMap<Integer, List<Permission>>(firstPermissionList.size());
		for(Permission res : firstPermissionList) {
			List<Permission> childResList = this.permissionDAO.findSecondLevelPermissionByRoleId(res.getId(), roleId);
			for(int i=0;i<childResList.size();i++){
				//�Ƿ��з���ʮ���ص�ʾ����Ŀ�˵�
				if(childResList.get(i).getId()==15){
					//ʡƽ̨û�д˲˵�
					if(!user.getSite().getCode().equals(Constants.ANHUI)){
						//���಻�ǰ���ʡ��û�д˲˵���ƽ̨����û�д˲˵�
						if(!user.getSite().getParent().getCode().equals(Constants.ANHUI) || user.getSite().getType()!=0){
							childResList.remove(i);
						}
					}else{
						childResList.remove(i);
					}
					
				}
			}
			
			firstSecondMap.put(res.getId(), childResList);
		}
		return firstSecondMap;
	}
	
	/**
	 * �鿴ϵͳ�в���Ҫ����Ȩ����֤�����е�URL
	 * @return
	 */
	public List<String> findIgnoreAuthURLs() {
		return this.permissionDAO.findIgnoreAuthURLs();
	}

	public List<Permission> findAllPermissions() {
		return this.permissionDAO.findAll();
	}

	/**
	 * ����һ����Դ��
	 * @param PermissionList
	 * @param ztree
	 */
	public void buliPermissionTree(List<Permission> PermissionList, ZTree ztree) {
		for (Permission res : PermissionList) {
			if (res.getParent() != null
					&& res.getParent().getId().equals(new Integer(ztree.getId()))) {
				ZTree node = new ZTree(String.valueOf(res.getId()), res.getTitle(), "", true);
				ztree.addChild(node);
				this.buliPermissionTree(PermissionList, node);
			}
		}
	}
	
	/**
	 * ����ȫ������Դ��
	 */
	public List<ZTree> buildFullPermissionTree() {
		List<Permission> PermissionList = this.findAllPermissions();
		List<Permission> firstLevelPermission = this.permissionDAO.findFirstLevelPermission();
		List<ZTree> zTreeList = new ArrayList<ZTree>(firstLevelPermission.size());
		for(Permission res : firstLevelPermission) {
			ZTree ztree = new ZTree(String.valueOf(res.getId()), res.getTitle(), "", true);
			this.buliPermissionTree(PermissionList, ztree);
			
			zTreeList.add(ztree);
		}
		return zTreeList;
	}
	
	public void savePermission(Permission Permission) {
		this.permissionDAO.save(Permission);
	}
	
	public Permission findPermissionById(Integer PermissionId) {
		return this.permissionDAO.findById(PermissionId);
	}
	
	public void updatePermission(Permission Permission) {
		this.permissionDAO.update(Permission);
	}
	
	public void deletePermission(Permission Permission) {
		this.permissionDAO.delete(Permission);
	}
	
	public int getChildNodesCount(Integer id) {
		return this.permissionDAO.getChildNodesCount(id);
	}
}
