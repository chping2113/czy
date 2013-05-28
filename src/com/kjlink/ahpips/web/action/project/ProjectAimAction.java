package com.kjlink.ahpips.web.action.project;

import java.util.List;

import com.kjlink.ahpips.Constants;
import com.kjlink.ahpips.entity.project.ProjectAim;
import com.kjlink.ahpips.entity.system.User;
import com.kjlink.ahpips.service.project.ProjectAimService;
import com.kjlink.ahpips.service.system.UserService;
import com.kjlink.ahpips.web.action.BaseAction;

public class ProjectAimAction extends BaseAction<ProjectAim>{

	private ProjectAim projectAim =new ProjectAim();
	private ProjectAimService projectAimService;

	private int approveState = 0 ;	
	private int type;//类型 ：1.新建，2.修改，3.审核，4.在列表目录提交，6.待办工作中审核

	private UserService userService;
	private int userId;
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public int getApproveState() {
		return approveState;
	}

	public void setApproveState(int approveState) {
		this.approveState = approveState;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	public ProjectAim getProjectAim() {
		return projectAim;
	}


	public void setProjectAim(ProjectAim projectAim) {
		this.projectAim = projectAim;
	}


	public ProjectAimService getProjectAimService() {
		return projectAimService;
	}


	public void setProjectAimService(ProjectAimService projectAimService) {
		this.projectAimService = projectAimService;
	}


	public ProjectAim getModel() {
		
		return projectAim;
	}

	
	public void prepare() throws Exception {
		if(id!=null && id>0){
			this.projectAim = projectAimService.findById(id);
		}
		
	}
	
	public String init() throws Exception {
		this.getSession().remove("projectAim_queryStr");
		User user=(User)this.getSession().get("loginUser");
		if(user.getSite().getCode().equals(Constants.ANHUI)){
			this.pageInfo = projectAimService.findProjectAimBySiteId("", "", getPageNo(), getMaxPageSize());
				
		}else{
			this.pageInfo = projectAimService.findProjectAimBySiteId("", user.getSite().getCode(), getPageNo(), getMaxPageSize());
		}
		return "projectAimList";
	}
	public String initAdd() throws Exception{

		User user=(User)this.getSession().get("loginUser");
		List<User> userList=userService.findApproveUser(user.getSite());
		getContext().put("userList", userList);
		return "projectAimAdd";
	}
	public String delete() throws Exception{
		if(projectAim != null){
			projectAimService.delete(projectAim);

			log.info("用户："+getLoginUserFromSession().getCode()+"删除了项目招投标信息,项目编码："+projectAim.getCode());
		}
		return "redirectInit";
	}
	public String query() throws Exception {
		if(queryStr != null)
			this.getSession().put("projectAim_queryStr", queryStr);
		else
			queryStr = (String)this.getSession().get("projectAim_queryStr");

		User user=(User)this.getSession().get("loginUser");
			if(user.getSite().getCode().equals(Constants.ANHUI)){
				this.pageInfo = projectAimService.findProjectAimBySiteId(queryStr, "", getPageNo(), getMaxPageSize());
					
			}else{
				this.pageInfo = projectAimService.findProjectAimBySiteId(queryStr, user.getSite().getCode(), getPageNo(), getMaxPageSize());
			}
		
		return "projectAimList";
	}
	public String add() throws Exception{
		
		if(projectAim != null ){
			if(userId>0){
				User user=userService.findById(userId);
				projectAim.setApproveUser(user);
			}else{
				if(type!=3 && type!=6 && type!=2)
				projectAim.setApproveUser(null);
				else if(type==2 && approveState==3 && projectAim.getState()!=3){
					projectAim.setApproveUser(null);
				}
			}

			if(type==1){
				projectAim.setCreateUser(getLoginUserFromSession());
			}
			if(approveState==1 && ( type==3 || type==6 )){
				projectAim.setApproveUser(getLoginUserFromSession());
			}
			projectAim.setState(approveState);
			projectAim.setSite(getLoginUserFromSession().getSite());
			projectAimService.merge(projectAim);
		}
		
		return "redirectInit";
	}
	
	public String view() throws Exception{
		return "projectAimView";
	}

}
