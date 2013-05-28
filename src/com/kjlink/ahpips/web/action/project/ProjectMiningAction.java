package com.kjlink.ahpips.web.action.project;

import java.util.List;

import com.kjlink.ahpips.Constants;
import com.kjlink.ahpips.entity.project.LandBid;
import com.kjlink.ahpips.entity.project.LandSell;
import com.kjlink.ahpips.entity.project.LandUse;
import com.kjlink.ahpips.entity.project.MineApprove;
import com.kjlink.ahpips.entity.project.MineSell;
import com.kjlink.ahpips.entity.project.Project;
import com.kjlink.ahpips.entity.project.ProjectMining;
import com.kjlink.ahpips.entity.project.ProspectApprove;
import com.kjlink.ahpips.entity.project.ProspectSell;
import com.kjlink.ahpips.entity.system.User;
import com.kjlink.ahpips.service.project.ProjectMiningService;
import com.kjlink.ahpips.service.project.ProjectService;
import com.kjlink.ahpips.service.system.UserService;
import com.kjlink.ahpips.web.action.BaseAction;

public class ProjectMiningAction  extends BaseAction<ProjectMining>{
	private ProjectMining projectMining = new ProjectMining();
	private Project project ;//所属项目
	private ProspectApprove prospectApprove ;//探矿权审批信息
	private ProspectSell prospectSell ;//探矿权出让信息
	private MineApprove mineApprove ;//采矿权审批信息
	private MineSell mineSell ;//采矿权出让信息
	
	private ProjectMiningService projectMiningService ;
	private ProjectService projectService ;
	
	private int projectId = 0;
	private int approveState = 0 ;
	private int siteId = 0;


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

	public int getSiteId() {
		return siteId;
	}

	public void setSiteId(int siteId) {
		this.siteId = siteId;
	}

	private int type;//类型 ：1.新建，2.修改，3.审核，4.在列表目录提交，6.待办工作中审核
	
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String init() throws Exception{
		
		this.getSession().remove("projectMining_queryStr");
		User user=(User)this.getSession().get("loginUser");
		if(type==6){
			this.pageInfo=projectMiningService.findByToDo("", user, getPageNo(), getMaxPageSize());
			return "projectMiningList";
		}
		this.pageInfo = projectMiningService.findProjectMiningBySiteId("", user.getSite().getCode(), getPageNo(), getMaxPageSize());
		
	
		return "projectMiningList";
	}
	
	public String query() throws Exception {
		if(queryStr != null)
			this.getSession().put("projectMining_queryStr", queryStr);
		else
			queryStr = (String)this.getSession().get("projectMining_queryStr");

		User user=(User)this.getSession().get("loginUser");
		if(type==6){
			this.pageInfo=projectMiningService.findByToDo(queryStr, user, getPageNo(), getMaxPageSize());
			return "projectMiningList";
		}
			if(user.getSite().getCode().equals(Constants.ANHUI)){
				this.pageInfo = projectMiningService.findProjectMiningBySiteId(queryStr, "", getPageNo(), getMaxPageSize());	
			}else{

				this.pageInfo = projectMiningService.findProjectMiningBySiteId(queryStr, user.getSite().getCode(), getPageNo(), getMaxPageSize());
			}
		
		return "projectMiningList";
	}
	
	public String delete() throws Exception{
		if(projectMining != null){
			projectMiningService.delete(projectMining);
			log.info("用户："+getLoginUserFromSession().getCode()+"删除了项目矿业权审批信息,项目编码："+projectMining.getCode());

		}
		return "redirectInit";
	}
	
	public String initAdd()throws Exception{

		User user=(User)this.getSession().get("loginUser");
		List<User> userList=userService.findApproveUser(user.getSite());
		getContext().put("userList", userList);
		return "projectMiningAdd";
	}
	
	public String add()throws Exception{
		if(userId>0){
			User user=userService.findById(userId);
			projectMining.setApproveUser(user);
		}else{
			if(type!=3 && type!=6 && type!=2)
			projectMining.setApproveUser(null);
			else if(type==2 && approveState==3 && projectMining.getState()!=3){
				projectMining.setApproveUser(null);
			}
		}

		if(type==1){
			projectMining.setCreateUser(getLoginUserFromSession());
		}
		if(approveState==1 && ( type==3 || type==6 )){
			projectMining.setApproveUser(getLoginUserFromSession());
		}
			projectMining.setState(approveState);
			projectMining.setSite(getLoginUserFromSession().getSite());
			projectMiningService.merge(projectMining);
		return "redirectInit";
	}
	
	public String view() throws Exception{
		return "projectMiningView";
	}

	@Override
	public ProjectMining getModel() {
		return projectMining;
	}

	@Override
	public void prepare() throws Exception {
		if(id!=null&&id>0){
			this.projectMining = projectMiningService.findById(id);
		}
		if(projectId>0){
			this.project = projectService.findById(projectId);
		}
	}

	public ProjectMining getProjectMining() {
		return projectMining;
	}

	public void setProjectMining(ProjectMining projectMining) {
		this.projectMining = projectMining;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public ProspectApprove getProspectApprove() {
		return prospectApprove;
	}

	public void setProspectApprove(ProspectApprove prospectApprove) {
		this.prospectApprove = prospectApprove;
	}

	public ProspectSell getProspectSell() {
		return prospectSell;
	}

	public void setProspectSell(ProspectSell prospectSell) {
		this.prospectSell = prospectSell;
	}

	public MineApprove getMineApprove() {
		return mineApprove;
	}

	public void setMineApprove(MineApprove mineApprove) {
		this.mineApprove = mineApprove;
	}

	public MineSell getMineSell() {
		return mineSell;
	}

	public void setMineSell(MineSell mineSell) {
		this.mineSell = mineSell;
	}

	public ProjectMiningService getProjectMiningService() {
		return projectMiningService;
	}

	public void setProjectMiningService(ProjectMiningService projectMiningService) {
		this.projectMiningService = projectMiningService;
	}

	public ProjectService getProjectService() {
		return projectService;
	}

	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public int getApproveState() {
		return approveState;
	}

	public void setApproveState(int approveState) {
		this.approveState = approveState;
	}
}
