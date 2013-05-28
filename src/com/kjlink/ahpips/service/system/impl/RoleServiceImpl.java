/** 
  * @title:  
  * @description:   
  * @copyright: 凯捷技术有限公司 
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
 * 作者：brady.zh
 * 创建：2010-11-4
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
		super.setCommonDAO(roleDAO); //父类的方法一定要被调用,否则会出错
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
	 * 查找系统的全部第一级资源列表
	 * @return
	 */
	public List<Permission> findFirstLevelPermission() {
		return this.permissionDAO.findFirstLevelPermission();
	}

	/**
	 * 返回Key为一级资源ID，Value为其对应的下级资源列表
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
	 * 返回Key为二级资源ID，Value为其对应的下级资源列表
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
	 * 返回一个用户所对应的资源列表
	 */
	public List<Permission> findRolePermissionListByUserId(Integer userId) {
		User user = this.userDAO.findById(userId);
		Set<Permission> resSet = user.getRole().getPermissions();
		List<Permission> resList = new ArrayList<Permission>(resSet.size());
		for(Permission res : resSet) {
			//为避免级联太多无用对象，则重新构造Permission放置在Map中
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
	 * 返回只用来显示菜单的Permission，避免使用级联对象
	 * 菜单对应资源表只有前两级
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
	 * 根据第一级资源菜单返回一个Key为第一级资源ID，Value为其对应的第二级资源列表的Map
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
				//是否有发布十大重点示范项目菜单
				if(childResList.get(i).getId()==15){
					//省平台没有此菜单
					if(!user.getSite().getCode().equals(Constants.ANHUI)){
						//父类不是安徽省的没有此菜单，平台机构没有此菜单
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
	 * 查看系统中不需要进行权限认证的所有的URL
	 * @return
	 */
	public List<String> findIgnoreAuthURLs() {
		return this.permissionDAO.findIgnoreAuthURLs();
	}

	public List<Permission> findAllPermissions() {
		return this.permissionDAO.findAll();
	}

	/**
	 * 构造一棵资源树
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
	 * 构造全部的资源树
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
