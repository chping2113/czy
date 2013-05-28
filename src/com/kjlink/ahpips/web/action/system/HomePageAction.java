package com.kjlink.ahpips.web.action.system;

import java.io.File;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;

import org.apache.struts2.ServletActionContext;

import com.brady.common.dao.CommonDAO;
import com.kjlink.ahpips.Constants;
import com.kjlink.ahpips.dao.system.PermissionDAO;
import com.kjlink.ahpips.dao.system.RoleDAO;
import com.kjlink.ahpips.entity.system.HomePage;
import com.kjlink.ahpips.entity.system.Navigate;
import com.kjlink.ahpips.entity.system.Permission;
import com.kjlink.ahpips.entity.system.Role;
import com.kjlink.ahpips.entity.system.Role;
import com.kjlink.ahpips.entity.system.User;
import com.kjlink.ahpips.service.system.HomePageService;
import com.kjlink.ahpips.service.system.RoleService;
import com.kjlink.ahpips.service.system.UserService;
import com.kjlink.ahpips.web.action.BaseAction;
import com.kjlink.common.util.FileUtil;

public class HomePageAction extends BaseAction<HomePage> {
	
	private HomePage homePage = new HomePage();
	private HomePageService homePageService ;
	
	private File attachFile ;
	private String attachFileContentType ;
	private String attachFileFileName ;
	
	private PermissionDAO permissionDAO;
	private Permission permission=new Permission();
	private RoleDAO roleDAO;

	private String title; 
	private String url;	 
	private Integer position;
	private Set<Role> role = new HashSet<Role>();
	
	public Set<Role> getRole() {
		return role;
	}

	public void setRole(Set<Role> role) {
		this.role = role;
	}

	private int pid;
	private Integer roleId;
	
	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	private List<Permission> list;

	public RoleDAO getRoleDAO() {
		return roleDAO;
	}

	public void setRoleDAO(RoleDAO roleDAO) {
		this.roleDAO = roleDAO;
	}

	public Permission getPermission() {
		return permission;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public String init(){
		User user = this.getLoginUserFromSession();
		if(user!=null){
			this.homePage = this.homePageService.findHomePageBySite(user.getSite());		
		}
		//取出项目信息
		list = this.permissionDAO.findProjectbyParentId(3);
		this.getSession().put("projectManager", list);
		
		//System.out.println(this.getLoginUserFromSession().getId());
			
		List<Permission> list1 =this.permissionDAO.findProjectbyParentId2(3); 
		
		
		  for (int i = 0; i < list1.size(); i++) {  

		       this.getContext().put("list1"+i, list1.get(i));

		   }  

		
		return "homePageList";
	}
	
	public PermissionDAO getPermissionDAO() {
		return permissionDAO;
	}

	public void setPermissionDAO(PermissionDAO permissionDAO) {
		this.permissionDAO = permissionDAO;
	}

	public String add(){
		if(homePage!=null && this.getLoginUserFromSession() != null){
			if(homePage.getId()!=null && homePage.getId()>0)
				homePage.setLogoName(this.homePageService.findById(homePage.getId()).getLogoName());
			if(this.attachFile != null){
				File file = new File(ServletActionContext.getServletContext().getRealPath(Constants.LOGO_IMAGE));
				if (!file.exists()) {
					file.mkdir();
				}
				//之前的"/"被置换成File.separator,以适应不同操作系统下的分隔符不同
				String filePath = ServletActionContext.getServletContext().getRealPath(File.separator+Constants.LOGO_IMAGE+File.separator+this.getLoginUserFromSession().getSite().getCode()+FileUtil.getExtention((this.attachFileFileName)));
				File uploadFile = new File(filePath);
				FileUtil.copyFile(this.attachFile, uploadFile);
				//之前的"/"被置换成File.separator,以适应不同操作系统下的分隔符不同
				homePage.setLogoName(Constants.LOGO_IMAGE + File.separator+this.getLoginUserFromSession().getSite().getCode()+FileUtil.getExtention((this.attachFileFileName)));
			}
			homePage.setSite(this.getLoginUserFromSession().getSite());
			homePageService.merge(homePage);
			//checkbox状态
			list = this.permissionDAO.findProjectbyParentId(3);
			for(int i=0;i<list.size();i++){
				list.get(i).setCheckState(0);
			}
			
			String[] state = this.getRequest().getParameterValues("selectProject");
			if(state != null){
				for(int i = 0;i<state.length;i++){
					
					if(state[i] !=null ){
						permission = this.permissionDAO.findById(Integer.parseInt(state[i]));
						permission.setCheckState(1);
						this.permissionDAO.merge(permission);
					}					
				}
			}			
			log.info("用户："+getLoginUserFromSession().getCode()+"修改了首页管理，IP地址："+getRequest().getRemoteAddr());
		}
		return this.init();
	}
	
	//增加项目信息
	public String addProject(){		
		return "addProject";
	}
	
	public String addInit(){
		this.delete();
		permission.setParent(permissionDAO.findById(3));			
		permission.setTitle(this.getRequest().getParameter("title"));
		permission.setUrl(this.getRequest().getParameter("url"));
		permission.setPosition(Integer.parseInt(this.getRequest().getParameter("position")));
		
		Role roles = this.getLoginUserFromSession().getRole();
		
		role.add(roles);
		permission.setRoles(role);
		
		this.permissionDAO.merge(permission);
		return "redirectInit";
	}
	
	public String view(){
		pid = Integer.parseInt(this.getRequest().getParameter("pid"));
		if( pid >0){
			permission = this.permissionDAO.findById(pid);
		}
		return "homePageView";
	}
	public HomePage getHomePage() {
		return homePage;
	}

	public void setHomePage(HomePage homePage) {
		this.homePage = homePage;
	}

	public void setPermission(Permission permission) {
		this.permission = permission;
	}

	public String initEdit(){
		pid = Integer.parseInt(this.getRequest().getParameter("pid"));
		if( pid > 0){
			permission = this.permissionDAO.findById(pid);
		}
		return "homePageEdit";
	}
	public String delete(){
		try{
			pid = Integer.parseInt(this.getRequest().getParameter("pid"));
			if( pid > 0){
				permission = this.permissionDAO.findById(pid);
			}
			if(permission != null){
				permissionDAO.delete(permission);
			}
		}catch(Exception e){
			e.printStackTrace();
			this.message = "对不起，当前记录已经被使用，不能被删除！";
			return "message";
		}
		return "redirectInit";
	}

	@Override
	public HomePage getModel() {
		return homePage;
	}

	@Override
	public void prepare() throws Exception {
		if (id != null && id > 0) {
			homePage = this.homePageService.findById(id);
		}
	}

	public HomePageService getHomePageService() {
		return homePageService;
	}

	public void setHomePageService(HomePageService homePageService) {
		this.homePageService = homePageService;
	}

	public File getAttachFile() {
		return attachFile;
	}

	public void setAttachFile(File attachFile) {
		this.attachFile = attachFile;
	}

	public String getAttachFileContentType() {
		return attachFileContentType;
	}

	public void setAttachFileContentType(String attachFileContentType) {
		this.attachFileContentType = attachFileContentType;
	}

	public String getAttachFileFileName() {
		return attachFileFileName;
	}

	public void setAttachFileFileName(String attachFileFileName) {
		this.attachFileFileName = attachFileFileName;
	}

}
