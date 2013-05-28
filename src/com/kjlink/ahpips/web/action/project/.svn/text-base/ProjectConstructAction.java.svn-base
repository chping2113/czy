package com.kjlink.ahpips.web.action.project;

import java.util.List;

import org.apache.struts2.dispatcher.ServletRedirectResult;

import com.kjlink.ahpips.Constants;
import com.kjlink.ahpips.entity.project.AcceptanceInfo;
import com.kjlink.ahpips.entity.project.BaseInfo;
import com.kjlink.ahpips.entity.project.BidInfo;
import com.kjlink.ahpips.entity.project.ChangesInfo;
import com.kjlink.ahpips.entity.project.ConstrutInfo;
import com.kjlink.ahpips.entity.project.ContractInfo;
import com.kjlink.ahpips.entity.project.LandInfo;
import com.kjlink.ahpips.entity.project.MoneyInfo;
import com.kjlink.ahpips.entity.project.Project;
import com.kjlink.ahpips.entity.project.ProjectConstruct;
import com.kjlink.ahpips.entity.project.SafeCheckInfo;
import com.kjlink.ahpips.entity.system.Construct;
import com.kjlink.ahpips.entity.system.User;
import com.kjlink.ahpips.service.project.ProjectConstructService;
import com.kjlink.ahpips.service.project.ProjectIssueService;
import com.kjlink.ahpips.service.project.ProjectService;
import com.kjlink.ahpips.service.system.SiteService;
import com.kjlink.ahpips.service.system.UserService;
import com.kjlink.ahpips.web.action.BaseAction;
import com.kjlink.common.util.DateTypeConvert;
import com.opensymphony.xwork2.Result;

public class ProjectConstructAction extends BaseAction<ProjectConstruct>{
	private ProjectConstruct projectConstruct = new ProjectConstruct();
	private Project project;
	private BaseInfo baseInfo ;
	private BidInfo bidInfo ;
	private LandInfo landInfo ;
	private int siteId;
	private int type;//类型 ：1.新建，2.修改，3.审核，4.在列表目录提交，6.待办工作中审核
	public int getSiteId() {
		return siteId;
	}

	public void setSiteId(int siteId) {
		this.siteId = siteId;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	private Construct construct;

	public Construct getConstruct() {
		return construct;
	}

	public void setConstruct(Construct construct) {
		this.construct = construct;
	}
	private UserService userService;
	private ProjectIssueService projectIssueService;
	private int userId;
	private int subType=0;
	
	public ProjectIssueService getProjectIssueService() {
		return projectIssueService;
	}

	public void setProjectIssueService(ProjectIssueService projectIssueService) {
		this.projectIssueService = projectIssueService;
	}

	public int getSubType() {
		return subType;
	}

	public void setSubType(int subType) {
		this.subType = subType;
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
	private ChangesInfo changesInfo ;
	private ConstrutInfo construtInfo ;
	private ContractInfo contractInfo ;
	private SafeCheckInfo safeCheckInfo ;
	private MoneyInfo moneyInfo ;
	private AcceptanceInfo acceptanceInfo ;
	private ProjectConstructService projectConstructService;
	private ProjectService projectService ;
	private SiteService siteService;
	
	private int projectId = 0;
	private int approveState = 0 ;
	

	public SiteService getSiteService() {
		return siteService;
	}

	public void setSiteService(SiteService siteService) {
		this.siteService = siteService;
	}

	public String init() throws Exception {
		this.getSession().remove("projectConstruct_queryStr");
		User user=(User)this.getSession().get("loginUser");

		if(user==null){
			Construct construct=(Construct)this.getSession().get("loginConstruct");
			
			this.pageInfo = projectConstructService.findProjectConstructByConstruct("", construct, getPageNo(), getMaxPageSize());
			
			
			
		}else{
			if(user.getSite()!=null){	
				if(type==6){
					this.pageInfo=projectConstructService.findByToDo("", user, getPageNo(), getMaxPageSize());
					
					return "projectConstructList";
				}
				if(user.getSite().getCode().equals(Constants.ANHUI)){
					this.pageInfo = projectConstructService.findProjectConstructBySiteId("", "", getPageNo(), getMaxPageSize());
				}else{
					this.pageInfo = projectConstructService.findProjectConstructBySiteId("", user.getSite().getCode(), getPageNo(), getMaxPageSize());
				}
			}else{
				this.pageInfo = projectConstructService.findProjectConstructBySiteId("", "", getPageNo(), getMaxPageSize());
			}
		}
		
		
		return "projectConstructList";
	}
	public String query() throws Exception {
		if(queryStr != null)
			this.getSession().put("projectConstruct_queryStr", queryStr);
		else
			queryStr = (String)this.getSession().get("projectConstruct_queryStr");

		User user=(User)this.getSession().get("loginUser");

		if(user==null){
			Construct construct=(Construct)this.getSession().get("loginConstruct");
			
			this.pageInfo = projectConstructService.findProjectConstructByConstruct(queryStr, construct, getPageNo(), getMaxPageSize());
			
			
			
		}else{
				if(user.getSite()!=null){
					if(type==6){
						this.pageInfo=projectConstructService.findByToDo(queryStr, user, getPageNo(), getMaxPageSize());
						return "projectConstructList";
					}
					if(user.getSite().getCode().equals(Constants.ANHUI)){
						this.pageInfo = projectConstructService.findProjectConstructBySiteId(queryStr, "", getPageNo(), getMaxPageSize());
					}else{
						this.pageInfo = projectConstructService.findProjectConstructBySiteId(queryStr, user.getSite().getCode(), getPageNo(), getMaxPageSize());
					}
				}else{
					this.pageInfo = projectConstructService.findProjectConstructBySiteId(queryStr, "", getPageNo(), getMaxPageSize());
				}
			}
		
		
		return "projectConstructList";
	}
	public String initAdd()throws Exception{
		User user=(User)this.getSession().get("loginUser");
		if(user!=null){
			List<User> userList=userService.findApproveUser(user.getSite());
			getContext().put("userList", userList);
		}
		if(subType==1){
			return "auditStatistics";
		}
		return "projectConstructAdd";
	}
	
	public String add()throws Exception{
		if(projectConstruct!=null){
			if(siteId>0){
				projectConstruct.setSite(siteService.findById(siteId));
			}
			if(userId>0){
				User user=userService.findById(userId);
				projectConstruct.setApproveUser(user);
			}else{
				if(type!=3 && type!=6 && type!=2)
				projectConstruct.setApproveUser(null);
				else if(type==2 && approveState==3 && projectConstruct.getState()!=3){
					projectConstruct.setApproveUser(null);
				}
			}
			projectConstruct.setState(approveState);
			if(getLoginConstructFromSession()!=null){
				projectConstruct.setConstruct(getLoginConstructFromSession());
			}else{
				if(type==1){
					projectConstruct.setCreateUser(getLoginUserFromSession());
				}
				if(approveState==1 && ( type==3 || type==6 )){
					projectConstruct.setApproveUser(getLoginUserFromSession());
				}
			}

			projectConstructService.merge(projectConstruct);
		}
		return "redirectInit";
	}

	public String delete() throws Exception{
		if(projectConstruct != null){
			if(projectIssueService.findProjectConstruct(projectConstruct).size()>0){
				this.message = "对不起，当前记录已经被使用，不能被删除！";
				return "message";
			}else{
				projectConstructService.delete(projectConstruct);

				log.info("用户："+getLoginUserFromSession().getCode()+"删除了项目建设管理信息,项目编码："+projectConstruct.getCode());
			}

		}
		return "redirectInit";
	}
	public String view() throws Exception{
		return "projectConstructView";
	}

	@Override
	public ProjectConstruct getModel() {
		return projectConstruct;
	}

	@Override
	public void prepare() throws Exception {
		if(id!=null&&id>0){
			this.projectConstruct = projectConstructService.findById(id);
		}
		if(projectId>0){
			this.project = projectService.findById(projectId);
		}
	}

	public ProjectConstruct getProjectConstruct() {
		return projectConstruct;
	}

	public void setProjectConstruct(ProjectConstruct projectConstruct) {
		this.projectConstruct = projectConstruct;
	}

	public ProjectConstructService getProjectConstructService() {
		return projectConstructService;
	}

	public void setProjectConstructService(
			ProjectConstructService projectConstructService) {
		this.projectConstructService = projectConstructService;
	}

	public BaseInfo getBaseInfo() {
		return baseInfo;
	}

	public void setBaseInfo(BaseInfo baseInfo) {
		this.baseInfo = baseInfo;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
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

	public BidInfo getBidInfo() {
		return bidInfo;
	}

	public void setBidInfo(BidInfo bidInfo) {
		this.bidInfo = bidInfo;
	}

	public LandInfo getLandInfo() {
		return landInfo;
	}

	public void setLandInfo(LandInfo landInfo) {
		this.landInfo = landInfo;
	}

	public ChangesInfo getChangesInfo() {
		return changesInfo;
	}

	public void setChangesInfo(ChangesInfo changesInfo) {
		this.changesInfo = changesInfo;
	}

	public ConstrutInfo getConstrutInfo() {
		return construtInfo;
	}

	public void setConstrutInfo(ConstrutInfo construtInfo) {
		this.construtInfo = construtInfo;
	}

	public ContractInfo getContractInfo() {
		return contractInfo;
	}

	public void setContractInfo(ContractInfo contractInfo) {
		this.contractInfo = contractInfo;
	}

	public SafeCheckInfo getSafeCheckInfo() {
		return safeCheckInfo;
	}

	public void setSafeCheckInfo(SafeCheckInfo safeCheckInfo) {
		this.safeCheckInfo = safeCheckInfo;
	}

	public MoneyInfo getMoneyInfo() {
		return moneyInfo;
	}

	public void setMoneyInfo(MoneyInfo moneyInfo) {
		this.moneyInfo = moneyInfo;
	}

	public AcceptanceInfo getAcceptanceInfo() {
		return acceptanceInfo;
	}

	public void setAcceptanceInfo(AcceptanceInfo acceptanceInfo) {
		this.acceptanceInfo = acceptanceInfo;
	}
	
	
//	
//	private int siteId;
//	private SiteService siteService;
//	private String createTime1;
//	public int getSiteId() {
//		return siteId;
//	}
//
//	public void setSiteId(int siteId) {
//		this.siteId = siteId;
//	}
//
//	public SiteService getSiteService() {
//		return siteService;
//	}
//
//	public void setSiteService(SiteService siteService) {
//		this.siteService = siteService;
//	}
//
//	public String getCreateTime1() {
//		return createTime1;
//	}
//
//	public void setCreateTime1(String createTime1) {
//		this.createTime1 = createTime1;
//	}
//
//	public Result inputData()throws Exception{
//		
//		if(projectConstruct!= null){
//			if(siteId>0){
//				projectConstruct.setSite(this.siteService.findById(siteId));
//			}
//			projectConstruct.setCreateTime(DateTypeConvert.stringToDate(createTime1));
//		}
//		this.projectConstructService.merge(projectConstruct);
//		return new ServletRedirectResult("/ahpips/pub_showProjectConstruct.action?id="+this.projectConstruct.getId());
//	}

}
