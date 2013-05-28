package com.kjlink.ahpips.web.action.system;

import java.net.URLEncoder;
import java.util.*;

import net.sf.json.JSONArray;

import com.brady.common.util.StringUtil;
import com.kjlink.ahpips.entity.system.*;
import com.kjlink.ahpips.pojo.ZTree;
import com.kjlink.ahpips.service.system.*;
import com.kjlink.ahpips.web.action.BaseAction;


public class RoleAction extends BaseAction<Role> {
	private Role model = new Role(); //用于保存模型驱动对象
	private RoleService roleService;
	private UserService userService;
	private String userIds; //以逗号分隔的用户ID字符串
	private Integer roleId;
	private Integer userId;
	private String[] permissionIds;
	private String actionType;
	private Permission permission; 
	private Integer permissionId;
	private Integer parentPermissionId;

	/**
	 * 返回模型驱动对象
	 */
	public Role getModel() {
		return model;
	}

	/**
	 * 实现Struts2的preparable接口
	 */
	public void prepare() throws Exception {
		if (id != null && id > 0) {
			model = this.roleService.findById(id);
		}
	}
	
	/**
	 * 查看全部角色
	 * @return
	 * @throws Exception
	 */
	public String list() throws Exception {
		this.getSession().remove("role_queryStr");
		this.pageInfo = this.roleService.findPageAll(getPageNo(), getMaxPageSize());
		this.pageUrl = "system/role_list.action";
		return "roleList";
	}
	
	/**
	 * 添加及修改请求方法
	 * @return
	 * @throws Exception
	 */
	public String addReq() throws Exception {
		return "addRole";
	}
	
	public String editReq() throws Exception {
		return this.addReq();
	}
	
	/**
	 * 通过ajax检查角色名称是否可用
	 */
	public String checkName()  throws Exception {
		Role tmp = this.roleService.findByName(model.getName());
		String msg = "ok";
		if(tmp != null) {
			msg = "err";
		}
		this.writeToResponse(msg);
		return null;
	}
	
	/**
	 * 角色信息保存方法
	 * @return
	 * @throws Exception
	 */
	public String add()  throws Exception {
		Role tmpRole = this.roleService.findByName(model.getName());
		if(tmpRole != null) {
			this.message = this.getText("角色名称[" + model.getName() + "]已经存在！");
			return "message";
		}
		
		this.roleService.save(model);
		return "redirectInit";
	}
	
	public String edit()  throws Exception {
		Role tmpRole = this.roleService.findByName(model.getName());
		if(tmpRole != null && !id.equals(tmpRole.getId())) { 
				this.message = this.getText("role.save.repeat.name", new String[] {model.getName()});
				return "addRole";
		}
		
		this.roleService.update(model);
		return "redirectInit";
	}
	
	/**
	 * 快速查询方法
	 * @return
	 * @throws Exception
	 */
	public String query()  throws Exception {
		if(queryStr != null)
			this.getSession().put("role_queryStr", queryStr);
		else
			queryStr = (String)this.getSession().get("role_queryStr");
		
		this.pageInfo = this.roleService.searchByName(getPageNo(), getMaxPageSize(), queryStr);
		this.pageUrl = "system/role_query.action";
		return "roleList";
	}
	/**
	 * 删除角色信息
	 * @return
	 * @throws Exception
	 */
	public String delete()  throws Exception {
		try {
			this.roleService.delete(model);
		} catch(Exception e) {
			this.message = "对不起，当前记录已经被使用，不能被删除！";
			return "message";
		}
		return "redirectInit";
	}
	
	public String show() throws Exception {
		return "viewRole";
	}
	
	public String listUser() throws Exception {
		this.getSession().remove("user_queryStr");
		this.roleId = id;
		this.pageInfo = this.roleService.findUsersByRoleId(getPageNo(), getMaxPageSize(), id);
		return "roleUserList";
	}
	
	public String queryUser() throws Exception {
		if (queryStr != null)
			this.getSession().put("user_queryStr", queryStr);
		else
			queryStr = (String) this.getSession().get("user_queryStr");
		this.pageInfo = this.roleService.findUsersByRoleId(getPageNo(), getMaxPageSize(), this.roleId,queryStr);
		return "roleUserList";
	}
	/**
	 * 跳转到角色资源配置页面
	 * @return
	 * @throws Exception
	 */
	public String setPowerRequest() throws Exception {
		List firstPermissionList = this.roleService.findFirstLevelPermission();
		Map firstPermissionMap = this.roleService.findFirstPermissionMap();
		Map secondPermissionMap= this.roleService.findSecondPermissionMap();
		Map permissionIdMap  = this.roleService.findPermissionIdMap(model);
		
		this.getContext().put("firstPermissionList", firstPermissionList);
		this.getContext().put("firstPermissionMap", firstPermissionMap);
		this.getContext().put("secondPermissionMap", secondPermissionMap);
		this.getContext().put("permissionIdMap", permissionIdMap);
		this.roleId = id;
		return "setPower";
	}
	
	/**
	 * 保存角色资源配置信息
	 * @return
	 * @throws Exception
	 */
	public String setPower() throws Exception {
		this.roleService.setPermissionPower(model, permissionIds);
		this.actionType = "setPower";
//		return setPowerRequest();
		return "redirectPowerRequest";
	}
	
	/**
	 * 以树形方式加载数据
	 */
	public String buildPermissionTree() throws Exception {
		List<ZTree> ztreeList = this.roleService.buildFullPermissionTree();
		JSONArray jo = JSONArray.fromObject(ztreeList);
		this.message = jo.toString();
		return "permissionTree";
	}
	
	public String addFirstResReq() throws Exception {
		this.actionType = "addFirstRes";
		return "addPermission";
	}
	
	public String addFirstRes() throws Exception {
		this.roleService.savePermission(permission);
		
		return "redirectPermissionTree";
	} 
	
	public String addChildResReq() throws Exception {
		this.actionType = "addChildRes";
		this.getContext().put("parentPermission", this.roleService.findPermissionById(parentPermissionId));
		return "addPermission";
	}
	
	public String addChildRes() throws Exception {
		if(this.parentPermissionId != null && this.parentPermissionId > 0) {
			this.permission.setParent(this.roleService.findPermissionById(parentPermissionId));
		}
		this.roleService.savePermission(permission);
//		return this.buildPermissionTree();
		return "redirectPermissionTree";
	}
	
	public String editResReq() throws Exception {
		this.actionType = "editRes";
		this.permission = this.roleService.findPermissionById(permissionId);
		if(permission.getParent() != null) {
			this.parentPermissionId = permission.getParent().getId();
		}
		return "addPermission";
	}
	
	public String editRes() throws Exception {
		if(this.permissionId != null && this.permissionId > 0) {
			Permission res = this.roleService.findPermissionById(permissionId);
			res.setTitle(this.permission.getTitle());
			res.setUrl(this.permission.getUrl());
			res.setPosition(this.permission.getPosition());
			
			if(this.parentPermissionId != null && this.parentPermissionId > 0) {
				res.setParent(this.roleService.findPermissionById(parentPermissionId));
			}
			this.roleService.updatePermission(res);
		}
		
//		return this.buildPermissionTree();
		return "redirectPermissionTree";
	}
	
	public String deletePermission()  throws Exception {
		try {
			if(this.permissionId != null && this.permissionId > 0) {
				this.roleService.deletePermission(this.roleService.findPermissionById(permissionId));
			}
		} catch(Exception e) {
			this.message = "对不起，当前记录已经被使用，不能被删除！";
			return "message";
		}
//		return this.buildPermissionTree();
		return "redirectPermissionTree";
	}
	
	public String showPermission() throws Exception {
		int childNodesCount = this.roleService.getChildNodesCount(permissionId);
		this.getContext().put("childNodesCount", childNodesCount);
		permission = this.roleService.findPermissionById(permissionId);
		return "viewPermission";
	} 
	
	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getUserIds() {
		return userIds;
	}

	public void setUserIds(String userIds) {
		this.userIds = userIds;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String[] getPermissionIds() {
		return permissionIds;
	}

	public void setPermissionIds(String[] permissionIds) {
		this.permissionIds = permissionIds;
	}

	public String getActionType() {
		return actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	public Permission getPermission() {
		return permission;
	}

	public void setPermission(Permission permission) {
		this.permission = permission;
	}

	public Integer getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(Integer permissionId) {
		this.permissionId = permissionId;
	}

	public Integer getParentPermissionId() {
		return parentPermissionId;
	}

	public void setParentPermissionId(Integer parentPermissionId) {
		this.parentPermissionId = parentPermissionId;
	}


}
