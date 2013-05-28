package com.kjlink.ahpips.web.action.system;

import java.io.File;
import java.util.*;

import net.sf.json.JSONArray;

import com.brady.common.util.MD5Generator;
import com.kjlink.ahpips.entity.system.*;
import com.kjlink.ahpips.pojo.ZTree;
import com.kjlink.ahpips.service.system.*;
import com.kjlink.ahpips.Constants;
import com.kjlink.ahpips.web.action.BaseAction;
import com.kjlink.common.util.ExcelImport;

public class UserAction extends BaseAction<User> {
	private User model = new User(); //用于保存模型驱动对象
	private UserService userService;
	private RoleService roleService;
	private SiteService siteService;
	String oldPwd; //原始密码
	String newPwd; //新密码
	Integer userId;//用于接收重置密码的用户ID
	Integer roleId;
	Integer siteId;
	
	private File attachFileUser ;
	
	/**
	 * 返回模型驱动对象
	 */
	public User getModel() {
		return model;
	}

	/**
	 * 实现Struts2的preparable接口
	 */
	public void prepare() throws Exception {
		if (id != null && id > 0) {
			model = this.userService.findById(id);
		}
	}
	
	/**
	 * 查看全部用户
	 * @return
	 * @throws Exception
	 */
	public String list() throws Exception {
		this.getSession().remove("user_queryStr");
		User user=(User)this.getSession().get("loginUser");
		this.pageInfo = this.userService.findPageAllBySite(getPageNo(), getMaxPageSize(),user,"");
		this.pageUrl = "system/user_list.action";
		return "listUser";
	}
	
	/**
	 * 添加及修改请求方法
	 * @return
	 * @throws Exception
	 */
	public String addReq() throws Exception {
		List<Site> allSites = this.siteService.findAll();
		Site siteRoot = this.siteService.findRootSite();
		ZTree ztree = new ZTree(String.valueOf(siteRoot.getId()), siteRoot.getName(), "", true);
		this.siteService.bulidSiteTree(allSites, ztree);
		
		ArrayList<ZTree> ztreeList = new ArrayList<ZTree>();
		ztreeList.add(ztree);
		JSONArray jo = JSONArray.fromObject(ztreeList);
		this.getContext().put("siteTreeData", jo.toString());
		
		this.getContext().put("roleList", this.roleService.findAll());
		return "addUser";
	}
	public String initAdd() throws Exception{

		User user=(User)this.getSession().get("loginUser");
		List<Role> list=this.roleService.findAll();
		if(user.getRole().getType()==1){
			this.getContext().put("roleList", list);
		}else if(user.getRole().getType()==2){
			for(int i=0;i<list.size();i++){
				Role role=list.get(i);
				if(role.getType()!=2){
					list.remove(i);
					i--;
				}
			}
			this.getContext().put("roleList", list);
		}else if(user.getRole().getType()==3){
			for(int i=0;i<list.size();i++){
				Role role=list.get(i);
				if(role.getType()!=3){
					list.remove(i);
					i--;
				}
			}
			this.getContext().put("roleList", list);
		}
		
		return "addUser";
	}
	/**
	 * 通过ajax验证帐号是否可用
	 */
	public String checkCode()  throws Exception {
		User tmp = this.userService.findByCode(model.getCode());
		String msg = "ok";
		if(tmp != null) {
			msg = "err";
		}
		this.writeToResponse(msg);
		return null;
	}
	
	/**
	 * 通过ajax验证邮箱是否已被使用
	 */
	public String checkEmail()  throws Exception {
		int editId=Integer.parseInt(getRequest().getParameter("editId"));
		String email=getRequest().getParameter("email");
		boolean exists =true;
		if(editId>0){
			exists= this.userService.checkEmailExistsEdit(email, editId);
		}else{
			exists= this.userService.checkEmailExists(email);
		}
		String msg = "ok";
		if(exists) {
			msg = "err";
		}
		this.writeToResponse(msg);
		return null;
	}
	
	/**
	 * 用户信息保存方法
	 * @return
	 * @throws Exception
	 */
	public String add()  throws Exception {
		model.setPassword(MD5Generator.getMD5Value(model.getPassword())); //保存时对密码加密
		model.setSite(this.siteService.findById(siteId));
		model.setRole(this.roleService.findById(roleId));
		model.setState(1);
		this.userService.merge(model);
//		return this.list();
		return "redirectInit";
	}
	
	public String edit() throws Exception {
		model.setSite(this.siteService.findById(siteId));
		model.setRole(this.roleService.findById(roleId));
		this.userService.update(model);
//		return this.list();
		return "redirectInit";
	}
	
	/**
	 * 修改登录密码
	 */
	public String changePwdReq() throws Exception {
		return "changePwd";
	}
	
	/**
	 * 修改登录密码
	 */
	public String changePwd() throws Exception {
		User me = this.getLoginUserFromSession();
		if(me == null) {
			return "login";
		}
		
		String md5OldPwd = MD5Generator.getMD5Value(oldPwd);
		String md5NewPwd = MD5Generator.getMD5Value(newPwd);
		if(! me.getPassword().equals(md5OldPwd)) {
			this.message = this.getText("user.changepwd.oldpassword.invalid");
			return "changePwd";
		}
		
		User u = this.userService.findById(me.getId());
		u.setPassword(md5NewPwd);
		this.userService.update(u);
		me.setPassword(md5NewPwd);
		this.message = this.getText("user.changepwd.success");
		log.info("用户："+getLoginUserFromSession().getCode()+"修改了密码，IP地址:"+getRequest().getRemoteAddr());
		return "changePwd";
	}
	
	
	/**
	 * 快速查询方法
	 * @return
	 * @throws Exception
	 */
	public String query()  throws Exception {
			
		if(queryStr != null)
			this.getSession().put("user_queryStr", queryStr);
		else
			queryStr = (String)this.getSession().get("user_queryStr");

		User user=(User)this.getSession().get("loginUser");
		this.pageInfo = this.userService.findPageAllBySite(getPageNo(), getMaxPageSize(),user,queryStr);
		this.pageUrl = "system/user_query.action";
		return "listUser";
	}
	
	/**
	 * 查看用户详细信息
	 * @return
	 * @throws Exception
	 */
	public String show()  throws Exception {
		return "roleViewUser";
	}
	/**
	 * 查看用户详细信息
	 * @return
	 * @throws Exception
	 */
	public String view()  throws Exception {
		return "viewUser";
	}
	/**
	 * 删除用户信息
	 * @return
	 * @throws Exception
	 */
	public String delete()  throws Exception {
		try {
			this.userService.delete(model);
			log.info("用户："+getLoginUserFromSession().getCode()+"删除了用户："+model.getCode()+"IP地址:"+getRequest().getRemoteAddr());
		} catch(Exception e) {
			this.message = "对不起，当前记录已经被使用，不能被删除！";
			return "message";
		}
		
//		return this.list();
		return "redirectInit";
	}
	
	public String upload() throws Exception{
		message = "";
		message += "=====================================================</br>";
		int suCount=0;
		int failCount=0;
		if(this.attachFileUser != null && this.attachFileUser.exists()){
			List<List<String>> list = ExcelImport.excelToList(this.attachFileUser);
			for(List<String> row : list) {
				if(		"类型".equals(row.get(0).trim()) 			&& "部门名称".equals(row.get(1).trim()) && "部门编码".equals(row.get(2).trim()) 
						&& "部门联系人".equals(row.get(3).trim()) 	&& "部门联系电话".equals(row.get(4).trim())
						&& "用户姓名".equals(row.get(5).trim()) 	&& "用户类型".equals(row.get(6).trim())
						&& "职务".equals(row.get(7).trim()) 		&& "电话".equals(row.get(8).trim())
						&& "Email".equals(row.get(9).trim()) 		&& "用户名".equals(row.get(10).trim())
						&& "密码".equals(row.get(11).trim()) 		&& "状态".equals(row.get(12).trim()) ){
					list.remove(row);
					break;
				}else{
					message += "<font color='red'>导入文件格式错误</font></br>";
					return "uploadSucc";
				}
			}
			for(List<String> row : list) {
				User user = new User();
				user.setState(1);
				User u = this.userService.findByCode(row.get(10).trim());
				if(u!=null){
					message += "<font color='red'>用户名:"+row.get(10)+"已经存在，不能导入</font></br>";
					failCount++;
					continue;
				}
				user.setCode(row.get(10).trim());
				user.setPassword(MD5Generator.getMD5Value(row.get(11).trim()));
				user.setName(row.get(5).trim());
				user.setTel(row.get(8).trim());
				user.setEmail(row.get(9).trim());
				Site site = this.siteService.findByCode(row.get(2).trim());
				if(site == null){
					message += "<font color='red'>部门:"+row.get(1)+"不存在，用户不能导入</font></br>";
					failCount++;
					continue;
				}
				user.setSite(site);
				Role role = this.roleService.findByName(row.get(6).trim());
				if(role == null){
					message += "<font color='red'>部门:"+row.get(1)+"的用户类型"+row.get(6)+"不存在，用户不能导入</font></br>";
					failCount++;
					continue;
				}
				user.setRole(role);
				this.userService.save(user);
				message += "<font color='green'>部门:"+row.get(1)+" ,用户名："+row.get(10)+" ,密码："+row.get(11)+"成功导入，恭喜恭喜！！！</font></br>";
				suCount++;
			}
			message += "导入成功:<font color='red'>"+suCount+"</font>条,导入失败:<font color='red'>"+failCount+"</font>条</br>";
		}
		return "uploadSucc";
	}
	
	
	
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public String getOldPwd() {
		return oldPwd;
	}

	public void setOldPwd(String oldPwd) {
		this.oldPwd = oldPwd;
	}

	public String getNewPwd() {
		return newPwd;
	}

	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public SiteService getSiteService() {
		return siteService;
	}

	public void setSiteService(SiteService siteService) {
		this.siteService = siteService;
	}

	public Integer getSiteId() {
		return siteId;
	}

	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
	}

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public File getAttachFileUser() {
		return attachFileUser;
	}

	public void setAttachFileUser(File attachFileUser) {
		this.attachFileUser = attachFileUser;
	}


}
