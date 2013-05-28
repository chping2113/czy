package com.kjlink.ahpips.web.action.project;

import java.util.List;

import com.kjlink.ahpips.Constants;
import com.kjlink.ahpips.entity.project.LandBid;
import com.kjlink.ahpips.entity.project.LandSell;
import com.kjlink.ahpips.entity.project.LandUse;
import com.kjlink.ahpips.entity.project.MineApprove;
import com.kjlink.ahpips.entity.project.MineSell;
import com.kjlink.ahpips.entity.project.Project;
import com.kjlink.ahpips.entity.project.ProjectLand;
import com.kjlink.ahpips.entity.project.ProspectApprove;
import com.kjlink.ahpips.entity.project.ProspectSell;
import com.kjlink.ahpips.entity.system.Construct;
import com.kjlink.ahpips.entity.system.User;
import com.kjlink.ahpips.service.project.ProjectLandService;
import com.kjlink.ahpips.service.project.ProjectService;
import com.kjlink.ahpips.service.system.SiteService;
import com.kjlink.ahpips.service.system.UserService;
import com.kjlink.ahpips.web.action.BaseAction;

public class ProjectLandAction extends BaseAction<ProjectLand>{
	private ProjectLand projectLand = new ProjectLand();
	private Project project ;//所属项目
	private LandBid landBid ;//土地招标拍卖挂牌出让信息
	private LandSell landSell ;//国有土地使用权出让合同信息
	private LandUse landUse ;//建设用地审批信息
	private ProspectApprove prospectApprove ;//探矿权审批信息
	private ProspectSell prospectSell ;//探矿权出让信息
	private MineApprove mineApprove ;//采矿权审批信息
	private MineSell mineSell ;//采矿权出让信息
	
	private ProjectLandService projectLandService ;
	private ProjectService projectService ;
	private int projectId = 0;
	private int approveState = 0 ;
	private int siteId = 0;
	private SiteService siteService;

	private UserService userService;
	private int userId;
	public SiteService getSiteService() {
		return siteService;
	}

	public void setSiteService(SiteService siteService) {
		this.siteService = siteService;
	}

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
		
		this.getSession().remove("projectLand_queryStr");
		User user=(User)this.getSession().get("loginUser");
		if(type==6){
			this.pageInfo=projectLandService.findByToDo("", user, getPageNo(), getMaxPageSize());
			return "projectLandList";
		}
		this.pageInfo = projectLandService.findProjectLandBySiteId("", user.getSite().getCode(), getPageNo(), getMaxPageSize());
		
	
		return "projectLandList";
	}
	
	public String query() throws Exception {
		if(queryStr != null)
			this.getSession().put("projectLand_queryStr", queryStr);
		else
			queryStr = (String)this.getSession().get("projectLand_queryStr");

		User user=(User)this.getSession().get("loginUser");
		if(type==6){
			this.pageInfo=projectLandService.findByToDo(queryStr, user, getPageNo(), getMaxPageSize());
			return "projectLandList";
		}
			if(user.getSite().getCode().equals(Constants.ANHUI)){
				this.pageInfo = projectLandService.findProjectLandBySiteId(queryStr, "", getPageNo(), getMaxPageSize());	
			}else{

				this.pageInfo = projectLandService.findProjectLandBySiteId(queryStr, user.getSite().getCode(), getPageNo(), getMaxPageSize());
			}
		
		return "projectLandList";
	}
	
	public String delete() throws Exception{
		if(projectLand != null){
			projectLandService.delete(projectLand);
			log.info("用户："+getLoginUserFromSession().getCode()+"删除了项目土地权审批信息,项目编码："+projectLand.getCode());

		}
		return "redirectInit";
	}
	
	public String initAdd()throws Exception{
		User user=(User)this.getSession().get("loginUser");

		
		List<User> userList=userService.findApproveUser(user.getSite());
		
		getContext().put("userList", userList);
		return "projectLandAdd";
	}
	/**
	 * 查找当前部门的审核人员
	 * @return
	 */
	public String approveUser(){
		User user=(User)this.getSession().get("loginUser");
		Construct construct=(Construct)this.getSession().get("loginConstruct");
		
		List<User> userList=null;
		if(user!=null){
			userList=userService.findApproveUser(user.getSite());
		}
		if(construct!=null){
			userList=userService.findApproveUser(siteService.findById(siteId));
		}
		getContext().put("userList", userList);
		return "approveUser";
	}
	public String add()throws Exception{
		if(userId>0){
			User user=userService.findById(userId);
			projectLand.setApproveUser(user);
		}else{
			if(type!=3 && type!=6 && type!=2)
			projectLand.setApproveUser(null);
			else if(type==2 && approveState==3 && projectLand.getState()!=3){
				projectLand.setApproveUser(null);
			}
		}

		if(type==1){
			projectLand.setCreateUser(getLoginUserFromSession());
		}
		if(approveState==1 && ( type==3 || type==6 )){
			projectLand.setApproveUser(getLoginUserFromSession());
		}
			projectLand.setState(approveState);
			projectLand.setSite(getLoginUserFromSession().getSite());
			projectLandService.merge(projectLand);
		return "redirectInit";
	}
	
	public String view() throws Exception{
		return "projectLandView";
	}

	@Override
	public ProjectLand getModel() {
		return projectLand;
	}

	@Override
	public void prepare() throws Exception {
		if(id!=null&&id>0){
			this.projectLand = projectLandService.findById(id);
		}
		if(projectId>0){
			this.project = projectService.findById(projectId);
		}
	}

	public ProjectLand getProjectLand() {
		return projectLand;
	}

	public void setProjectLand(ProjectLand projectLand) {
		this.projectLand = projectLand;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public LandBid getLandBid() {
		return landBid;
	}

	public void setLandBid(LandBid landBid) {
		this.landBid = landBid;
	}

	public LandSell getLandSell() {
		return landSell;
	}

	public void setLandSell(LandSell landSell) {
		this.landSell = landSell;
	}

	public LandUse getLandUse() {
		return landUse;
	}

	public void setLandUse(LandUse landUse) {
		this.landUse = landUse;
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

	public ProjectLandService getProjectLandService() {
		return projectLandService;
	}

	public void setProjectLandService(ProjectLandService projectLandService) {
		this.projectLandService = projectLandService;
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
