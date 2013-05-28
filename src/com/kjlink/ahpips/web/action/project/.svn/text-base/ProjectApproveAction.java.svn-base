package com.kjlink.ahpips.web.action.project;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.brady.common.util.Base64;
import com.kjlink.ahpips.Constants;
import com.kjlink.ahpips.entity.info.AttachFile;
import com.kjlink.ahpips.entity.info.Scolumn;
import com.kjlink.ahpips.entity.project.Project;
import com.kjlink.ahpips.entity.project.ProjectApprove;
import com.kjlink.ahpips.entity.project.ProjectApproveConfig;
import com.kjlink.ahpips.entity.project.ProjectApproveDetail;
import com.kjlink.ahpips.entity.project.ProjectApproveFlow;
import com.kjlink.ahpips.entity.system.Permission;
import com.kjlink.ahpips.entity.system.Site;
import com.kjlink.ahpips.entity.system.User;
import com.kjlink.ahpips.service.info.AttachFileService;
import com.kjlink.ahpips.service.info.ScolumnService;
import com.kjlink.ahpips.service.project.ProjectApproveConfigService;
import com.kjlink.ahpips.service.project.ProjectApproveDetailService;
import com.kjlink.ahpips.service.project.ProjectApproveFlowService;
import com.kjlink.ahpips.service.project.ProjectApproveService;
import com.kjlink.ahpips.service.project.ProjectService;
import com.kjlink.ahpips.service.system.RoleService;
import com.kjlink.ahpips.service.system.SiteService;
import com.kjlink.ahpips.service.system.UserService;
import com.kjlink.ahpips.web.action.BaseAction;
import com.kjlink.common.util.FileUtil;

public class ProjectApproveAction extends BaseAction<ProjectApprove>{
	private ProjectApprove projectApprove = new ProjectApprove();
	private Project project = new Project();
	private ProjectApproveService projectApproveService ;
	private ProjectService projectService ;
	private ProjectApproveConfigService projectApproveConfigService;
	private SiteService siteService ;
	private ProjectApproveFlow projectApproveFlow;
	private ProjectApproveDetail projectApproveDetail;
	private ProjectApproveFlowService projectApproveFlowService;
	private ProjectApproveDetailService projectApproveDetailService;
	private RoleService roleService;
	private ScolumnService scolumnService;
	private int projectId = 0;
	private int approveState = 0 ;
	private int siteId = 0;
	private String createTime1 ;
	private int type;//类型 ：1.新建，2.修改，3.审核，4.在列表目录提交，6.待办工作中审核
	//发布机构的id和名称
	private String proposeSiteId;
	private String feasibilitySiteId;
	private String designSiteId;
	private String energySiteId;
	private String addressSiteId;
	private String landSiteId;
	private String environmentSiteId;
	private String approveResultSiteId;
	private String startReportsSiteId;
	private String planSiteId;
	private String planSiteName;
	private String proposeSiteName;
	private String feasibilitySiteName;
	private String designSiteName;
	private String energySiteName;
	private String addressSiteName;
	private String landSiteName;
	private String environmentSiteName;
	private String approveResultSiteName;
	private String startReportsSiteName;
	private Date releaseDate;
	private int subType=0;//子菜单类型 ：1. 发布项目审批备案信息， 2. 发布初步设计批复信息，  3.发布节能评估批复信息，4.发布规划选址批复信息，5.发布用地批复文件信息，5.发布环境影响评价审批信息，7.发布施工许可(开工)审批信息

 
	
	private UserService userService;
	private int userId;
	
	
	private String instr;
	private String check;
	private boolean chk;
	
	private String startTime;
	private String endTime;
	private String scolumnName;
	//文件处理
	
	private AttachFileService attachFileService;
	
	private File attachFile ;
	private String attachFileContentType ;
	private String attachFileFileName ;
	
	private List<AttachFile> attachFileList ;
	
	private Integer[] verProIds;  //审核信息id集合
	
	private  Integer[] reProIds;//推荐信息id集合
	
	private Integer[] proIds;  //删除信息id集合
	
	

	public void setProIds(Integer[] proIds) {
			this.proIds = proIds;
		}

		public Integer[] getProIds()
		{
			return proIds;
		}
	
	public boolean getIsChk() {  
		    return chk;  
		}  
		public void setIsChk(boolean chk) {  
		    this.chk= chk;  
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

	public String getPlanSiteId() {
		return planSiteId;
	}

	public void setPlanSiteId(String planSiteId) {
		this.planSiteId = planSiteId;
	}

	public String getPlanSiteName() {
		return planSiteName;
	}

	public void setPlanSiteName(String planSiteName) {
		this.planSiteName = planSiteName;
	}

	public String getProposeSiteName() {
		return proposeSiteName;
	}

	public void setProposeSiteName(String proposeSiteName) {
		this.proposeSiteName = proposeSiteName;
	}

	public String getFeasibilitySiteName() {
		return feasibilitySiteName;
	}

	public void setFeasibilitySiteName(String feasibilitySiteName) {
		this.feasibilitySiteName = feasibilitySiteName;
	}

	public String getDesignSiteName() {
		return designSiteName;
	}

	public void setDesignSiteName(String designSiteName) {
		this.designSiteName = designSiteName;
	}

	public String getEnergySiteName() {
		return energySiteName;
	}

	public void setEnergySiteName(String energySiteName) {
		this.energySiteName = energySiteName;
	}

	public String getAddressSiteName() {
		return addressSiteName;
	}

	public void setAddressSiteName(String addressSiteName) {
		this.addressSiteName = addressSiteName;
	}

	public String getLandSiteName() {
		return landSiteName;
	}

	public void setLandSiteName(String landSiteName) {
		this.landSiteName = landSiteName;
	}

	public String getEnvironmentSiteName() {
		return environmentSiteName;
	}

	public void setEnvironmentSiteName(String environmentSiteName) {
		this.environmentSiteName = environmentSiteName;
	}

	public String getApproveResultSiteName() {
		return approveResultSiteName;
	}

	public void setApproveResultSiteName(String approveResultSiteName) {
		this.approveResultSiteName = approveResultSiteName;
	}

	public String getStartReportsSiteName() {
		return startReportsSiteName;
	}

	public void setStartReportsSiteName(String startReportsSiteName) {
		this.startReportsSiteName = startReportsSiteName;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getProposeSiteId() {
		return proposeSiteId;
	}

	public void setProposeSiteId(String proposeSiteId) {
		this.proposeSiteId = proposeSiteId;
	}

	public String getFeasibilitySiteId() {
		return feasibilitySiteId;
	}

	public void setFeasibilitySiteId(String feasibilitySiteId) {
		this.feasibilitySiteId = feasibilitySiteId;
	}

	public String getDesignSiteId() {
		return designSiteId;
	}

	public void setDesignSiteId(String designSiteId) {
		this.designSiteId = designSiteId;
	}

	public String getEnergySiteId() {
		return energySiteId;
	}

	public void setEnergySiteId(String energySiteId) {
		this.energySiteId = energySiteId;
	}

	public String getAddressSiteId() {
		return addressSiteId;
	}

	public void setAddressSiteId(String addressSiteId) {
		this.addressSiteId = addressSiteId;
	}

	public String getLandSiteId() {
		return landSiteId;
	}

	public void setLandSiteId(String landSiteId) {
		this.landSiteId = landSiteId;
	}

	public String getEnvironmentSiteId() {
		return environmentSiteId;
	}

	public void setEnvironmentSiteId(String environmentSiteId) {
		this.environmentSiteId = environmentSiteId;
	}

	public String getApproveResultSiteId() {
		return approveResultSiteId;
	}

	public void setApproveResultSiteId(String approveResultSiteId) {
		this.approveResultSiteId = approveResultSiteId;
	}

	public String getStartReportsSiteId() {
		return startReportsSiteId;
	}

	public void setStartReportsSiteId(String startReportsSiteId) {
		this.startReportsSiteId = startReportsSiteId;
	}

	public ProjectApproveFlowService getProjectApproveFlowService() {
		return projectApproveFlowService;
	}

	public void setProjectApproveFlowService(
			ProjectApproveFlowService projectApproveFlowService) {
		this.projectApproveFlowService = projectApproveFlowService;
	}

	public ProjectApproveDetailService getProjectApproveDetailService() {
		return projectApproveDetailService;
	}

	public void setProjectApproveDetailService(
			ProjectApproveDetailService projectApproveDetailService) {
		this.projectApproveDetailService = projectApproveDetailService;
	}

	public ProjectApproveFlow getProjectApproveFlow() {
		return projectApproveFlow;
	}

	public void setProjectApproveFlow(ProjectApproveFlow projectApproveFlow) {
		this.projectApproveFlow = projectApproveFlow;
	}

	public ProjectApproveDetail getProjectApproveDetail() {
		return projectApproveDetail;
	}

	public void setProjectApproveDetail(ProjectApproveDetail projectApproveDetail) {
		this.projectApproveDetail = projectApproveDetail;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
	//取得所有配置的栏目的名字
	public void findScolumnName() {
		List<Scolumn> scolumnList = scolumnService.findAllScolumn();
		this.getContext().put("scolumnList", scolumnList);
	}

	public String init() throws Exception {
		findScolumnName();   //取得所有的栏目名称 gaoyang
		
		this.getSession().remove("projectApprove_queryStr");
		User user=(User)this.getSession().get("loginUser");
		
		//查找待办工作列表
		if(type==6){
			this.pageInfo=projectApproveService.findByToDo("", user, getPageNo(), getMaxPageSize());
			return "projectApproveToDoList";
		}
		if(user.getSite().getCode().equals(Constants.ANHUI)){
			this.pageInfo = projectApproveService.findProjectApproveBySiteId("", "", getPageNo(), getMaxPageSize());
		
		}else{
			this.pageInfo = projectApproveService.findProjectApproveBySiteId("", user.getSite().getCode(), getPageNo(), getMaxPageSize());
		}
		List<ProjectApprove> projectApproveList=this.pageInfo.getPageData();
		for(int i=0;i<projectApproveList.size();i++){
			List<ProjectApproveFlow> projectApproveFlowList=projectApproveFlowService.findByProjectApprove(projectApproveList.get(i), user.getSite());
			if(projectApproveFlowList.size()>0){
				
				if(projectApproveFlowList.get(0).getState()==2){
					this.getContext().put("flag"+(i+1), "2");
				}else{
					this.getContext().put("flag"+(i+1), "1");
				}
			}else{
				this.getContext().put("flag"+(i+1), "0");
			}
		}
		
		return "projectApproveList";
	}
	public String initAdd() throws Exception{
		findScolumnName();  //取得所有的栏目名称 gaoyang
		
		User user=(User)this.getSession().get("loginUser");
		List permissionList = this.roleService.findRolePermissionListByUserId(user.getId()); //当前用户所对应的资源
//		if(Integer.valueOf(user.getSite().getId())!=1)
//		{	
//		for(Object object:permissionList)
//		{
//			Permission permission=(Permission)object;
//			if(permission.getTitle().equals("信息上报"))
//			{
//				instr="1";
//				//System.out.println("initAdd中的"+instr);
//			}
//			
//		}
//		}
//		if(instr!="1")
//			instr="0";
		//System.out.println(id);
		List<User> userList=userService.findApproveUser(user.getSite());
		getContext().put("userList", userList);
		
		if(id>0){
			List<ProjectApproveFlow> projectApproveFlowList=projectApproveFlowService.findByProjectApprove(projectApprove);
			for(int i=0;i<projectApproveFlowList.size();i++){
				projectApproveFlow=projectApproveFlowList.get(i);
				Site fsite=projectApproveFlow.getSite();
				this.getContext().put(projectApproveFlow.getType()+"SiteId", fsite.getId().toString());
				this.getContext().put(projectApproveFlow.getType()+"SiteName", fsite.getName());
				
			}
		}else{
			List<ProjectApproveConfig> list=projectApproveConfigService.findByProjectApproveConfigSite(getLoginUserFromSession().getSite());
			for(int i=0;i<list.size();i++){
				ProjectApproveConfig projectApproveConfig=list.get(i);
				Site site=projectApproveConfig.getApproveSite();
				Site lsite=getLoginUserFromSession().getSite();
				int old=Integer.valueOf(site.getId());
				int newId=Integer.valueOf(lsite.getId());
				if(old!=newId){
					this.getContext().put(projectApproveConfig.getApproveName()+"SiteId", site.getId());
					this.getContext().put(projectApproveConfig.getApproveName()+"SiteName", site.getName());
				}
				
			}
		}
		if(subType==1){
			return "projectApprovesAdd";
		}else if(subType==2){
			return "projectApproveDesignAdd";
		}else if(subType==3){
			return "projectApproveEnergyAdd";
		}else if(subType==4){
			return "projectApproveAddressAdd";
		}else if(subType==5){
			return "projectApproveLandAdd";
		}else if(subType==6){
			return "projectApproveEnvironmentAdd";
		}else if(subType==7){
			return "projectApproveStartReportsAdd";
		}
		
		return "projectApproveAdd";
	}
	public ProjectApproveConfigService getProjectApproveConfigService() {
		return projectApproveConfigService;
	}

	public void setProjectApproveConfigService(
			ProjectApproveConfigService projectApproveConfigService) {
		this.projectApproveConfigService = projectApproveConfigService;
	}

	/**
	 * 发布信息初始化
	 * @return
	 * @throws Exception
	 */
	public String release() throws Exception{
		if(id>0){
			Site site=getLoginUserFromSession().getSite();
			List<ProjectApproveFlow> projectApproveFlowList=projectApproveFlowService.findByProjectApprove(projectApprove,site);
			List<ProjectApproveDetail> projectApproveDetailList=projectApproveDetailService.findByProjectApprove(projectApprove,site);
			if(projectApproveDetailList.size()>0){
				releaseDate=projectApproveDetailList.get(0).getCreateTime();
			}else{
				releaseDate=new Date();
			}
			
			this.getContext().put("projectApproveFlowList", projectApproveFlowList);
		}
		return "projectApproveRelease";
	}
	/**
	 * 发布信息保存
	 * @return
	 * @throws Exception
	 */
	public String releaseSave() throws Exception{
		projectApproveService.merge(projectApprove);

		Site site=getLoginUserFromSession().getSite();

		List<ProjectApproveDetail> projectApproveDetailList=projectApproveDetailService.findByProjectApprove(projectApprove,site);

		List<ProjectApproveFlow> projectApproveFlowList=projectApproveFlowService.findByProjectApprove(projectApprove,site);
		for(int i=0;i<projectApproveFlowList.size();i++){
			projectApproveFlow=projectApproveFlowList.get(i);
			projectApproveFlow.setState(2);
			projectApproveFlowService.merge(projectApproveFlow);
		}
		if(projectApproveDetailList.size()<=0){
			
			projectApproveDetail=new ProjectApproveDetail();
			projectApproveDetail.setCreateTime(new Date());
			projectApproveDetail.setSite(site);
			projectApproveDetail.setProjectApprove(projectApprove);
			projectApproveDetailService.save(projectApproveDetail);
		}else{
			for(int i=0;i<projectApproveDetailList.size();i++){
				projectApproveDetail=projectApproveDetailList.get(i);
				//projectApproveDetail.setCreateTime(releaseDate);
				projectApproveDetailService.merge(projectApproveDetail);
				
			}
		}
		
		return "redirectInit";
	}
	public String delete() throws Exception{
		if(projectApprove != null){
			projectApproveService.deleteAll(projectApprove);

			log.info("用户："+getLoginUserFromSession().getCode()+"删除了项目审批信息,项目编码："+projectApprove.getCode());
		}
		return "redirectInit";
	}
	/*
	 * 发布和审核页面的快速查找
	 * */
	public String query() throws Exception {
		if(queryStr != null)
			this.getSession().put("projectApprove_queryStr", queryStr);
		else
			queryStr = (String)this.getSession().get("projectApprove_queryStr");

		User user=(User)this.getSession().get("loginUser");
		
		//String str=this.getRequest().getParameter("name");
		//String str=this.getRequest()

	    
		//String str=
		
		//System.out.println(str);
		//System.out.println("get方法+"+projectApprove.getName());
		this.getSession().put("scolumnName", scolumnName);
		scolumnName = (String)this.getSession().get("scolumnName");
		if(type==6){

			this.pageInfo=projectApproveService.findByToDo(queryStr, user, getPageNo(), getMaxPageSize());
			return "projectApproveToDoList";
		}
			if(user.getSite().getCode().equals(Constants.ANHUI)){
				this.pageInfo = projectApproveService.findProjectApproveBySiteId(queryStr, "", getPageNo(), getMaxPageSize());
				//this.pageInfo = projectApproveService.quickFindInfo(queryStr, "", startTime, endTime, getPageNo(), getMaxPageSize(), user.getSite(), scolumnName);
				List<ProjectApprove> projectApproveList=this.pageInfo.getPageData();
				for(int i=0;i<projectApproveList.size();i++){
					List<ProjectApproveFlow> projectApproveFlowList=projectApproveFlowService.findByProjectApprove(projectApproveList.get(i), user.getSite());
					if(projectApproveFlowList.size()>0){
						
						if(projectApproveFlowList.get(0).getState()==2){
							this.getContext().put("flag"+(i+1), "2");
						}else{
							this.getContext().put("flag"+(i+1), "1");
						}
					}else{
						this.getContext().put("flag"+(i+1), "0");
					}
				}	
			}else{
				//this.pageInfo = projectApproveService.quickFindInfo(queryStr, user.getSite().getCode(), startTime, endTime, getPageNo(), getMaxPageSize(), user.getSite(), scolumnName);
				this.pageInfo = projectApproveService.findProjectApproveBySiteId(queryStr, user.getSite().getCode(), getPageNo(), getMaxPageSize());
				List<ProjectApprove> projectApproveList=this.pageInfo.getPageData();
				for(int i=0;i<projectApproveList.size();i++){
					List<ProjectApproveFlow> projectApproveFlowList=projectApproveFlowService.findByProjectApprove(projectApproveList.get(i), user.getSite());
					if(projectApproveFlowList.size()>0){
						
						if(projectApproveFlowList.get(0).getState()==2){
							this.getContext().put("flag"+(i+1), "2");
						}else{
							this.getContext().put("flag"+(i+1), "1");
						}
					}else{
						this.getContext().put("flag"+(i+1), "0");
					}
				}
			}
			
		startTime = "";
		endTime = "";
		scolumnName = "";
		return "projectApproveList";
	}
	public String add() throws Exception{
		if(projectApprove != null ){
			if(userId>0){
				User user=userService.findById(userId);
				//System.out.println(user.getCode());
				projectApprove.setApproveUser(user);
			}else{
				//新建保存时，审核人员为空
				if(type!=3 && type!=6 && type!=2){
					projectApprove.setApproveUser(null);
				}else if(type==2 && approveState==3 && projectApprove.getState()!=3){
					projectApprove.setApproveUser(null);
				}
			}
			projectApprove.setState(approveState);

			//审核时，把当前用户赋值给审核人员
			if(approveState==1 && ( type==3 || type==6 )){
				projectApprove.setApproveUser(getLoginUserFromSession());
				
				
				//System.out.println(this.getCheck());
				//System.out.println(getLoginUserFromSession().getSite().getId());
				
			
				//projectApproveService.save(projectApprove2);
				//System.out.println("信息id="+projectApprove.getId());
			}
			if(type==1){
				//取得栏目名称,并取得栏目id
				this.getSession().put("scolumnName", scolumnName);
				scolumnName = (String)this.getSession().get("scolumnName");
				//System.out.println("@@@@@@@@@@--------4"+scolumnName);
				List <Scolumn> list = scolumnService.findByName(scolumnName);
				//System.out.println("@@@@@@@@@@--------5"+list.get(0));
				projectApprove.setScolumn(list.get(0));
				//Site site_c=siteService.findParentSite(getLoginUserFromSession().getSite());
				//System.out.println(site.getId());
				projectApprove.setCreateUser(getLoginUserFromSession());
				projectApprove.setSite(getLoginUserFromSession().getSite());
				//添加
				//projectApprove.setSite_c(site_c);
				//System.out.println(projectApprove.getId());
				
				projectApproveService.save(projectApprove);
				attachFileList = (List<AttachFile>) this.getSession().get("attachFileList");
				if(attachFileList!=null){
					for(AttachFile attachFile : attachFileList){
						attachFile.setProjectApprove(projectApprove);
						attachFileService.merge(attachFile);
					}
				}
				this.getSession().remove("attachFileList");
				
			}else{
				projectApproveService.merge(projectApprove);
			}
			
		}
		if(type!=4){
			if(type==2 && approveState==1){
				List<ProjectApproveFlow> projectApproveFlowList = projectApproveFlowService.findByProjectApprove(projectApprove,getLoginUserFromSession().getSite());
				for(int i=0;i<projectApproveFlowList.size();i++){
					projectApproveFlow=projectApproveFlowList.get(i);
					projectApproveFlow.setState(2);
					projectApproveFlowService.merge(projectApproveFlow);
				}
			}else{
				List<ProjectApproveFlow> projectApproveFlowList = projectApproveFlowService.findByProjectApprove(projectApprove);
				for(int i=0;i<projectApproveFlowList.size();i++){
					projectApproveFlow=projectApproveFlowList.get(i);
					projectApproveFlowService.delete(projectApproveFlow);
				}
				if(planSiteId!=null && !planSiteId.equals("") ){
					projectApproveFlow = new ProjectApproveFlow();
					projectApproveFlow.setProjectApprove(projectApprove);
					projectApproveFlow.setSite(siteService.findById(Integer.parseInt(planSiteId)));
					projectApproveFlow.setType("plan");
					projectApproveFlow.setState(approveState);
					projectApproveFlowService.merge(projectApproveFlow);
				}
				if(proposeSiteId!=null && !proposeSiteId.equals("") ){
					projectApproveFlow = new ProjectApproveFlow();
					projectApproveFlow.setProjectApprove(projectApprove);
					projectApproveFlow.setSite(siteService.findById(Integer.parseInt(proposeSiteId)));
					projectApproveFlow.setType("propose");
					projectApproveFlow.setState(approveState);
					projectApproveFlowService.merge(projectApproveFlow);
				}
			
	
				if(feasibilitySiteId!=null && !feasibilitySiteId.equals("") ){
					projectApproveFlow = new ProjectApproveFlow();
					projectApproveFlow.setProjectApprove(projectApprove);
					projectApproveFlow.setSite(siteService.findById(Integer.parseInt(feasibilitySiteId)));
					projectApproveFlow.setType("feasibility");
					projectApproveFlow.setState(approveState);
					projectApproveFlowService.merge(projectApproveFlow);
				}
	
				if(designSiteId!=null && !designSiteId.equals("") ){
					projectApproveFlow = new ProjectApproveFlow();
					projectApproveFlow.setProjectApprove(projectApprove);
					projectApproveFlow.setSite(siteService.findById(Integer.parseInt(designSiteId)));
					projectApproveFlow.setType("design");
					projectApproveFlow.setState(approveState);
					projectApproveFlowService.merge(projectApproveFlow);
				}
	
				if(energySiteId!=null && !energySiteId.equals("") ){
					projectApproveFlow = new ProjectApproveFlow();
					projectApproveFlow.setProjectApprove(projectApprove);
					projectApproveFlow.setSite(siteService.findById(Integer.parseInt(energySiteId)));
					projectApproveFlow.setType("energy");
					projectApproveFlow.setState(approveState);
					projectApproveFlowService.merge(projectApproveFlow);
				}
	
				if(addressSiteId!=null && !addressSiteId.equals("") ){
					projectApproveFlow = new ProjectApproveFlow();
					projectApproveFlow.setProjectApprove(projectApprove);
					projectApproveFlow.setSite(siteService.findById(Integer.parseInt(addressSiteId)));
					projectApproveFlow.setType("address");
					projectApproveFlow.setState(approveState);
					projectApproveFlowService.merge(projectApproveFlow);
				}
	
				if(landSiteId!=null && !landSiteId.equals("") ){
					projectApproveFlow = new ProjectApproveFlow();
					projectApproveFlow.setProjectApprove(projectApprove);
					projectApproveFlow.setSite(siteService.findById(Integer.parseInt(landSiteId)));
					projectApproveFlow.setType("land");
					projectApproveFlow.setState(approveState);
					projectApproveFlowService.merge(projectApproveFlow);
				}
	
				if(environmentSiteId!=null && !environmentSiteId.equals("") ){
					projectApproveFlow = new ProjectApproveFlow();
					projectApproveFlow.setProjectApprove(projectApprove);
					projectApproveFlow.setSite(siteService.findById(Integer.parseInt(environmentSiteId)));
					projectApproveFlow.setType("environment");
					projectApproveFlow.setState(approveState);
					projectApproveFlowService.merge(projectApproveFlow);
				}
	
				if(approveResultSiteId!=null && !approveResultSiteId.equals("") ){
					projectApproveFlow = new ProjectApproveFlow();
					projectApproveFlow.setProjectApprove(projectApprove);
					projectApproveFlow.setSite(siteService.findById(Integer.parseInt(approveResultSiteId)));
					projectApproveFlow.setType("approveResult");
					projectApproveFlow.setState(approveState);
					projectApproveFlowService.merge(projectApproveFlow);
				}
	
				if(startReportsSiteId!=null && !startReportsSiteId.equals("") ){
					projectApproveFlow = new ProjectApproveFlow();
					projectApproveFlow.setProjectApprove(projectApprove);
					projectApproveFlow.setSite(siteService.findById(Integer.parseInt(startReportsSiteId)));
					projectApproveFlow.setType("startReports");
					projectApproveFlow.setState(approveState);
					projectApproveFlowService.merge(projectApproveFlow);
				}
			}
		}
		if(approveState!=2 && (type==3 || type==6)){
			projectApproveDetail=new ProjectApproveDetail();
			projectApproveDetail.setCreateTime(new Date());
			projectApproveDetail.setSite(getLoginUserFromSession().getSite());
			projectApproveDetail.setProjectApprove(projectApprove);
			projectApproveDetailService.merge(projectApproveDetail);
			
			if(this.getCheck()!=null)
			{
			Site site=siteService.findParentSite(getLoginUserFromSession().getSite());
			
			String code=projectApprove.getCode();
		    String name=projectApprove.getName();
			//String title=projectApprove.getTitle();
			
		    ProjectApprove projectApprove2=new ProjectApprove();
		    projectApprove2.setCode(code);
		    projectApprove2.setName(name);
		    //projectApprove2.setTitle(title);
		    //projectApprove2.setConstructName(projectApprove.getConstructName());
		    projectApprove2.setSite(site);
		    projectApprove2.setState(3);
		    projectApprove2.setApproveType(projectApprove.getApproveType());
		    projectApprove=projectApprove2;
			projectApproveService.save(projectApprove);
			}
			
		}
		//System.out.println("check="+this.getIsChk());
		//System.out.println("check="+this.getCheck());
		return "redirectInit";
		
	}
	
	public String view() throws Exception{
		if(id>0){
			List<ProjectApproveFlow> projectApproveFlowList=projectApproveFlowService.findByProjectApprove(projectApprove);
		
			this.getContext().put("projectApproveFlowList", projectApproveFlowList);
		}
		
		return "projectApproveView";
	}
	
//	public Result inputData()throws Exception{
//		
//		if(projectApprove != null){
//			if(siteId>0){
//				projectApprove.setSite(this.siteService.findById(siteId));
//			}
//			projectApprove.setCreateTime(DateTypeConvert.stringToDate(createTime1));
//		}
//		this.projectApproveService.merge(projectApprove);
//		return new ServletRedirectResult("/ahpips/pub_showProjectApprove.action?id="+this.projectApprove.getId());
//	}
	/*
	 *抓取页面的初始化显示 
	 * */
	public String initGrab() throws Exception {
		this.getSession().remove("projectApprove_queryStr");
		User user=(User)this.getSession().get("loginUser");
		//查找待办工作列表
		if(type==6){
			this.pageInfo=projectApproveService.findByToDo("", user, getPageNo(), getMaxPageSize());
			return "projectApproveToDoList";
		}
		if(user.getSite().getCode().equals(Constants.ANHUI)){
			this.pageInfo = projectApproveService.findProjectApproveBySiteId("", "", getPageNo(), getMaxPageSize());
		
		}else{
			this.pageInfo = projectApproveService.findProjectApproveBySiteId("", user.getSite().getCode(), getPageNo(), getMaxPageSize());
		}
		List<ProjectApprove> projectApproveList=this.pageInfo.getPageData();
		for(int i=0;i<projectApproveList.size();i++){
			List<ProjectApproveFlow> projectApproveFlowList=projectApproveFlowService.findByProjectApprove(projectApproveList.get(i), user.getSite());
			if(projectApproveFlowList.size()>0){
				
				if(projectApproveFlowList.get(0).getState()==2){
					this.getContext().put("flag"+(i+1), "2");
				}else{
					this.getContext().put("flag"+(i+1), "1");
				}
			}else{
				this.getContext().put("flag"+(i+1), "0");
			}
		}
		
		return "grabList";
	}
	/*
	 * 抓取页面快速查询
	 * */	
	public String queryGrab() throws Exception {
		if(queryStr != null)
			this.getSession().put("projectApprove_queryStr", queryStr);
		else
			queryStr = (String)this.getSession().get("projectApprove_queryStr");
		
		//String startTime = (String)this.getSession().get("startTime");
		//String endTime = (String)this.getSession().get("endTime");

		User user=(User)this.getSession().get("loginUser");
	    //System.out.println("########--------1111111111"+queryStr);
		if(type==6){

			this.pageInfo=projectApproveService.findByToDo(queryStr, user, getPageNo(), getMaxPageSize());
			return "projectApproveToDoList";
		}
			if(user.getSite().getCode().equals(Constants.ANHUI)){
				//this.pageInfo = projectApproveService.findProjectApproveBySiteId(queryStr, "", getPageNo(), getMaxPageSize());
				this.pageInfo = projectApproveService.findInfoGrab(queryStr, "", startTime, endTime, getPageNo(), getMaxPageSize(), user.getSite());
				List<ProjectApprove> projectApproveList=this.pageInfo.getPageData();
				for(int i=0;i<projectApproveList.size();i++){
					List<ProjectApproveFlow> projectApproveFlowList=projectApproveFlowService.findByProjectApprove(projectApproveList.get(i), user.getSite());
					if(projectApproveFlowList.size()>0){
						
						if(projectApproveFlowList.get(0).getState()==2){
							this.getContext().put("flag"+(i+1), "2");
						}else{
							this.getContext().put("flag"+(i+1), "1");
						}
					}else{
						this.getContext().put("flag"+(i+1), "0");
					}
				}	
			}else{
				//this.pageInfo = projectApproveService.findProjectApproveBySiteId(queryStr, user.getSite().getCode(), getPageNo(), getMaxPageSize());
				this.pageInfo = projectApproveService.findInfoGrab(queryStr, user.getSite().getCode(), startTime, endTime, getPageNo(), getMaxPageSize(), user.getSite());
				List<ProjectApprove> projectApproveList=this.pageInfo.getPageData();
				for(int i=0;i<projectApproveList.size();i++){
					List<ProjectApproveFlow> projectApproveFlowList=projectApproveFlowService.findByProjectApprove(projectApproveList.get(i), user.getSite());
					if(projectApproveFlowList.size()>0){
						
						if(projectApproveFlowList.get(0).getState()==2){
							this.getContext().put("flag"+(i+1), "2");
						}else{
							this.getContext().put("flag"+(i+1), "1");
						}
					}else{
						this.getContext().put("flag"+(i+1), "0");
					}
				}
			}
			
		
		return "grabList";
	}
	/*
	 * 抓取页面的删除功能
	 * */
	public String deleteGrab()
	{
		//批量删除,删除信息前先删除对应的文件
              for(Integer proId:proIds)
		   {
            	  projectApprove=projectApproveService.findById(proId);
            	  List<AttachFile> afList=attachFileService.findAttachFileByProjectApprove(projectApprove);
      			for(AttachFile af : afList){
      				//之前的"/"被置换成File.separator,以适应不同操作系统下的分隔符不同
      				File file = new File(ServletActionContext.getServletContext().getRealPath(File.separator+Constants.UPLOAD_FILE+File.separator+af.getFileName()));
      				if(file.exists()){
      					file.delete();
      				}
      				attachFileService.delete(af);
      			}
      			projectApproveService.deleteAll(projectApprove);
   			}
              
		this.getSession().remove("projectApprove_queryStr");
		User user=(User)this.getSession().get("loginUser");
	
		if(type==6){
			this.pageInfo=projectApproveService.findByToDo("", user, getPageNo(), getMaxPageSize());
			return "projectApproveToDoList";
		}
		if(user.getSite().getCode().equals(Constants.ANHUI)){
			this.pageInfo = projectApproveService.findProjectApproveBySiteId("", "", getPageNo(), getMaxPageSize());
		
		}else{
			this.pageInfo = projectApproveService.findProjectApproveBySiteId("", user.getSite().getCode(), getPageNo(), getMaxPageSize());
		}
		List<ProjectApprove> projectApproveList=this.pageInfo.getPageData();
		for(int i=0;i<projectApproveList.size();i++){
			List<ProjectApproveFlow> projectApproveFlowList=projectApproveFlowService.findByProjectApprove(projectApproveList.get(i), user.getSite());
			if(projectApproveFlowList.size()>0){
				
				if(projectApproveFlowList.get(0).getState()==2){
					this.getContext().put("flag"+(i+1), "2");
				}else{
					this.getContext().put("flag"+(i+1), "1");
				}
			}else{
				this.getContext().put("flag"+(i+1), "0");
			}
		}
		
		return "grabList";

		
	}
	//提交和删除后的跳转查询
	public String queryBack() throws Exception {
		if(queryStr != null)
			this.getSession().put("projectApprove_queryStr", queryStr);
		else
			queryStr = (String)this.getSession().get("projectApprove_queryStr");

		User user=(User)this.getSession().get("loginUser");
		
		//String str=this.getRequest().getParameter("name");
		//String str=this.getRequest()

	    
		//String str=
		
		//System.out.println(str);
		//System.out.println("get方法+"+projectApprove.getName());
		this.getSession().put("scolumnName", scolumnName);
		scolumnName = (String)this.getSession().get("scolumnName");
		if(type==6){

			this.pageInfo=projectApproveService.findByToDo(queryStr, user, getPageNo(), getMaxPageSize());
			return "projectApproveToDoList";
		}
			if(user.getSite().getCode().equals(Constants.ANHUI)){
				this.pageInfo = projectApproveService.findProjectApproveBySiteId(queryStr, "", getPageNo(), getMaxPageSize());
				//this.pageInfo = projectApproveService.quickFindInfo(queryStr, "", startTime, endTime, getPageNo(), getMaxPageSize(), user.getSite(), scolumnName);
				List<ProjectApprove> projectApproveList=this.pageInfo.getPageData();
				for(int i=0;i<projectApproveList.size();i++){
					List<ProjectApproveFlow> projectApproveFlowList=projectApproveFlowService.findByProjectApprove(projectApproveList.get(i), user.getSite());
					if(projectApproveFlowList.size()>0){
						
						if(projectApproveFlowList.get(0).getState()==2){
							this.getContext().put("flag"+(i+1), "2");
						}else{
							this.getContext().put("flag"+(i+1), "1");
						}
					}else{
						this.getContext().put("flag"+(i+1), "0");
					}
				}	
			}else{
				//this.pageInfo = projectApproveService.quickFindInfo(queryStr, user.getSite().getCode(), startTime, endTime, getPageNo(), getMaxPageSize(), user.getSite(), scolumnName);
				this.pageInfo = projectApproveService.findProjectApproveBySiteId(queryStr, user.getSite().getCode(), getPageNo(), getMaxPageSize());
				List<ProjectApprove> projectApproveList=this.pageInfo.getPageData();
				for(int i=0;i<projectApproveList.size();i++){
					List<ProjectApproveFlow> projectApproveFlowList=projectApproveFlowService.findByProjectApprove(projectApproveList.get(i), user.getSite());
					if(projectApproveFlowList.size()>0){
						
						if(projectApproveFlowList.get(0).getState()==2){
							this.getContext().put("flag"+(i+1), "2");
						}else{
							this.getContext().put("flag"+(i+1), "1");
						}
					}else{
						this.getContext().put("flag"+(i+1), "0");
					}
				}
			}
			
		return "projectApproveList";
	}
	
	@Override
	public ProjectApprove getModel() {
		return projectApprove;
	}

	@Override
	public void prepare() throws Exception {
		
		if(id!=null && id>0){
			System.out.println("dshihsi = "+id);
			this.projectApprove = projectApproveService.findById(id);
			System.out.println(projectApprove.getName());
		}
		if(projectId>0){
			this.project = projectService.findById(projectId);
		}
	}

	public ProjectApproveService getProjectApproveService() {
		return projectApproveService;
	}

	public void setProjectApproveService(ProjectApproveService projectApproveService) {
		this.projectApproveService = projectApproveService;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
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

	public ProjectApprove getProjectApprove() {
		return projectApprove;
	}

	public void setProjectApprove(ProjectApprove projectApprove) {
		this.projectApprove = projectApprove;
	}

	public int getApproveState() {
		return approveState;
	}

	public void setApproveState(int approveState) {
		this.approveState = approveState;
	}

	public SiteService getSiteService() {
		return siteService;
	}

	public void setSiteService(SiteService siteService) {
		this.siteService = siteService;
	}

	public int getSiteId() {
		return siteId;
	}

	public void setSiteId(int siteId) {
		this.siteId = siteId;
	}

	public String getCreateTime1() {
		return createTime1;
	}

	public void setCreateTime1(String createTime1) {
		this.createTime1 = createTime1;
	}

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public String getInstr() {
		return instr;
	}

	public void setInstr(String instr) {
		this.instr = instr;
	}

	public String getCheck() {
		return check;
	}

	public void setCheck(String check) {
		this.check = check;
	}
	public AttachFileService getAttachFileService() {
		return attachFileService;
	}
	public void setAttachFileService(AttachFileService attachFileService) {
		this.attachFileService = attachFileService;
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
	public List<AttachFile> getAttachFileList() {
		return attachFileList;
	}
	public void setAttachFileList(List<AttachFile> attachFileList) {
		this.attachFileList = attachFileList;
	}
	
	public String initFile() throws Exception{
		String stid=this.getRequest().getParameter("id");

		if(stid!=null && !stid.equals("")){
			int tid=Integer.parseInt(stid);
			//System.out.println(tid);
			if( tid > 0) {
				
		id=tid;
				this.attachFileList=attachFileService.findAttachFileByProjectApprove(projectApprove);
				this.getSession().put("attachFileList", attachFileList);
			}
		}
			return "uploadSucc";
	}
	
	public String upload() throws Exception{
		if(this.attachFile != null && this.attachFile.exists()){
			File file = new File(ServletActionContext.getServletContext().getRealPath(Constants.UPLOAD_FILE));
			if (!file.exists()) {
				file.mkdir();
			}
			String fileName = this.getLoginUserFromSession().getCode()+"_"+System.currentTimeMillis()+FileUtil.getExtention((this.attachFileFileName));
			log.info("JIJIJIJI"+fileName);
			//之前的"/"被置换成File.separator,以适应不同操作系统下的分隔符不同
			String filePath = ServletActionContext.getServletContext().getRealPath(File.separator+Constants.UPLOAD_FILE+File.separator+fileName);
			log.info("JIJIJIJI"+filePath);
			File uploadFile = new File(filePath);
			FileUtil.copyFile(this.attachFile, uploadFile);
			//uploadFile
			AttachFile attach = new AttachFile();
			attach.setFileName(fileName);
			//log.info("添加对象");
			attach.setRealName(attachFileFileName);
			attachFileList = (List<AttachFile>) this.getSession().get("attachFileList");
			if(attachFileList!=null && attachFileList.size()>0){
				attachFileList.add(attach);
			}else{
				attachFileList = new ArrayList<AttachFile>();
				attachFileList.add(attach);
			}
			this.getSession().put("attachFileList", attachFileList);
		}
		else{
			if(attachFile!=null && !attachFile.exists()){
				this.getContext().put("error", "2");
			}
			attachFileList = (List<AttachFile>) this.getSession().get("attachFileList");
//			System.out.println(model.getId());
//			if(model.getId()!=null){
//				this.attachFileList=attachFileService.findAttachFileByNotice(model);
//				this.getSession().put("attachFileList", attachFileList);
//			}
		}
		return "uploadSucc";
	}
	public String largeFile(){
		this.getContext().put("error", "1");
		this.attachFileList = (List<AttachFile>) this.getSession().get("attachFileList");
		return "uploadSucc";
	}
	
	public String deleteFile()throws Exception{
		String stid=this.getRequest().getParameter("id");
		String fileName = this.message;
		attachFileList = (List<AttachFile>) this.getSession().get("attachFileList");
		for(AttachFile attachFile : attachFileList){
			if(attachFile.getFileName().equals(fileName)){
				attachFileList.remove(attachFile);

				if(stid!=null && !stid.equals("")){
				
				}else{
					//之前的"/"被置换成File.separator,以适应不同操作系统下的分隔符不同
					File file = new File(ServletActionContext.getServletContext().getRealPath(File.separator+Constants.UPLOAD_FILE+File.separator+fileName));
					if(file.exists()){
						file.delete();
					}
				}
				
				break;
			}
		}
		this.getSession().put("attachFileList", attachFileList);
		return "uploadSucc";
	}

	//批量删除(软删除)
	public String batchDelete()
	{
 		
		
		
		//批量删除,删除信息前先删除对应的文件
              for(Integer proId:proIds)
		   {
            	  projectApprove=projectApproveService.findById(proId);
            	  projectApprove.setEnable(1);
            	  projectApproveService.update(projectApprove);
//            	  List<AttachFile> afList=attachFileService.findAttachFileByProjectApprove(projectApprove);
//      			for(AttachFile af : afList){
//      				//之前的"/"被置换成File.separator,以适应不同操作系统下的分隔符不同
//      				File file = new File(ServletActionContext.getServletContext().getRealPath(File.separator+Constants.UPLOAD_FILE+File.separator+af.getFileName()));
//      				if(file.exists()){
//      					file.delete();
//      				}
//      				attachFileService.delete(af);
//      			}
      			//projectApproveService.deleteAll(projectApprove);
      			
   			}
           
              return "redirectInit";
	}
	
	//批量硬删除
	public String batchDelete0()
	{
		//批量删除,删除信息前先删除对应的文件
              for(Integer proId:proIds)
		   {
            	  projectApprove=projectApproveService.findById(proId);
            	 
            	  List<AttachFile> afList=attachFileService.findAttachFileByProjectApprove(projectApprove);
      			for(AttachFile af : afList){
      				//之前的"/"被置换成File.separator,以适应不同操作系统下的分隔符不同
      				File file = new File(ServletActionContext.getServletContext().getRealPath(File.separator+Constants.UPLOAD_FILE+File.separator+af.getFileName()));
      				if(file.exists()){
      					file.delete();
      				}
      				attachFileService.delete(af);
      			}
      			projectApproveService.deleteAll(projectApprove);
      			
   			}
              
              return "redirectInit";
	}
	
	//批量审核
	public String verifyAll() throws Exception{
		
		for(Integer temp:proIds)
		{
		projectApprove=projectApproveService.findById(temp);
		if(projectApprove != null ){
			if(userId>0){
				User user=userService.findById(userId);
				//System.out.println(user.getCode());
				projectApprove.setApproveUser(user);
			}else{
				//新建保存时，审核人员为空
				if(type!=3 && type!=6 && type!=2){
					projectApprove.setApproveUser(null);
				}else if(type==2 && approveState==3 && projectApprove.getState()!=3){
					projectApprove.setApproveUser(null);
				}
			}
			projectApprove.setState(approveState);

			//审核时，把当前用户赋值给审核人员
			if(approveState==1 && ( type==3 || type==6 )){
				projectApprove.setApproveUser(getLoginUserFromSession());
				
				
				//System.out.println(this.getCheck());
				//System.out.println(getLoginUserFromSession().getSite().getId());
				
			
				//projectApproveService.save(projectApprove2);
				//System.out.println("信息id="+projectApprove.getId());
			}
			if(type==1){
				//Site site_c=siteService.findParentSite(getLoginUserFromSession().getSite());
				//System.out.println(site.getId());
				projectApprove.setCreateUser(getLoginUserFromSession());
				projectApprove.setSite(getLoginUserFromSession().getSite());
				//添加
				//projectApprove.setSite_c(site_c);
				//System.out.println(projectApprove.getId());
				projectApproveService.save(projectApprove);
				attachFileList = (List<AttachFile>) this.getSession().get("attachFileList");
				if(attachFileList!=null){
					for(AttachFile attachFile : attachFileList){
						attachFile.setProjectApprove(projectApprove);
						attachFileService.merge(attachFile);
					}
				}
				this.getSession().remove("attachFileList");
				
			}else{
				projectApproveService.merge(projectApprove);
			}
			
		}
		if(type!=4){
			if(type==2 && approveState==1){
				List<ProjectApproveFlow> projectApproveFlowList = projectApproveFlowService.findByProjectApprove(projectApprove,getLoginUserFromSession().getSite());
				for(int i=0;i<projectApproveFlowList.size();i++){
					projectApproveFlow=projectApproveFlowList.get(i);
					projectApproveFlow.setState(2);
					projectApproveFlowService.merge(projectApproveFlow);
				}
			}else{
				List<ProjectApproveFlow> projectApproveFlowList = projectApproveFlowService.findByProjectApprove(projectApprove);
				for(int i=0;i<projectApproveFlowList.size();i++){
					projectApproveFlow=projectApproveFlowList.get(i);
					projectApproveFlowService.delete(projectApproveFlow);
				}
				if(planSiteId!=null && !planSiteId.equals("") ){
					projectApproveFlow = new ProjectApproveFlow();
					projectApproveFlow.setProjectApprove(projectApprove);
					projectApproveFlow.setSite(siteService.findById(Integer.parseInt(planSiteId)));
					projectApproveFlow.setType("plan");
					projectApproveFlow.setState(approveState);
					projectApproveFlowService.merge(projectApproveFlow);
				}
				if(proposeSiteId!=null && !proposeSiteId.equals("") ){
					projectApproveFlow = new ProjectApproveFlow();
					projectApproveFlow.setProjectApprove(projectApprove);
					projectApproveFlow.setSite(siteService.findById(Integer.parseInt(proposeSiteId)));
					projectApproveFlow.setType("propose");
					projectApproveFlow.setState(approveState);
					projectApproveFlowService.merge(projectApproveFlow);
				}
			
	
				if(feasibilitySiteId!=null && !feasibilitySiteId.equals("") ){
					projectApproveFlow = new ProjectApproveFlow();
					projectApproveFlow.setProjectApprove(projectApprove);
					projectApproveFlow.setSite(siteService.findById(Integer.parseInt(feasibilitySiteId)));
					projectApproveFlow.setType("feasibility");
					projectApproveFlow.setState(approveState);
					projectApproveFlowService.merge(projectApproveFlow);
				}
	
				if(designSiteId!=null && !designSiteId.equals("") ){
					projectApproveFlow = new ProjectApproveFlow();
					projectApproveFlow.setProjectApprove(projectApprove);
					projectApproveFlow.setSite(siteService.findById(Integer.parseInt(designSiteId)));
					projectApproveFlow.setType("design");
					projectApproveFlow.setState(approveState);
					projectApproveFlowService.merge(projectApproveFlow);
				}
	
				if(energySiteId!=null && !energySiteId.equals("") ){
					projectApproveFlow = new ProjectApproveFlow();
					projectApproveFlow.setProjectApprove(projectApprove);
					projectApproveFlow.setSite(siteService.findById(Integer.parseInt(energySiteId)));
					projectApproveFlow.setType("energy");
					projectApproveFlow.setState(approveState);
					projectApproveFlowService.merge(projectApproveFlow);
				}
	
				if(addressSiteId!=null && !addressSiteId.equals("") ){
					projectApproveFlow = new ProjectApproveFlow();
					projectApproveFlow.setProjectApprove(projectApprove);
					projectApproveFlow.setSite(siteService.findById(Integer.parseInt(addressSiteId)));
					projectApproveFlow.setType("address");
					projectApproveFlow.setState(approveState);
					projectApproveFlowService.merge(projectApproveFlow);
				}
	
				if(landSiteId!=null && !landSiteId.equals("") ){
					projectApproveFlow = new ProjectApproveFlow();
					projectApproveFlow.setProjectApprove(projectApprove);
					projectApproveFlow.setSite(siteService.findById(Integer.parseInt(landSiteId)));
					projectApproveFlow.setType("land");
					projectApproveFlow.setState(approveState);
					projectApproveFlowService.merge(projectApproveFlow);
				}
	
				if(environmentSiteId!=null && !environmentSiteId.equals("") ){
					projectApproveFlow = new ProjectApproveFlow();
					projectApproveFlow.setProjectApprove(projectApprove);
					projectApproveFlow.setSite(siteService.findById(Integer.parseInt(environmentSiteId)));
					projectApproveFlow.setType("environment");
					projectApproveFlow.setState(approveState);
					projectApproveFlowService.merge(projectApproveFlow);
				}
	
				if(approveResultSiteId!=null && !approveResultSiteId.equals("") ){
					projectApproveFlow = new ProjectApproveFlow();
					projectApproveFlow.setProjectApprove(projectApprove);
					projectApproveFlow.setSite(siteService.findById(Integer.parseInt(approveResultSiteId)));
					projectApproveFlow.setType("approveResult");
					projectApproveFlow.setState(approveState);
					projectApproveFlowService.merge(projectApproveFlow);
				}
	
				if(startReportsSiteId!=null && !startReportsSiteId.equals("") ){
					projectApproveFlow = new ProjectApproveFlow();
					projectApproveFlow.setProjectApprove(projectApprove);
					projectApproveFlow.setSite(siteService.findById(Integer.parseInt(startReportsSiteId)));
					projectApproveFlow.setType("startReports");
					projectApproveFlow.setState(approveState);
					projectApproveFlowService.merge(projectApproveFlow);
				}
			}
		}
		if(approveState!=2 && (type==3 || type==6)){
			projectApproveDetail=new ProjectApproveDetail();
			projectApproveDetail.setCreateTime(new Date());
			projectApproveDetail.setSite(getLoginUserFromSession().getSite());
			projectApproveDetail.setProjectApprove(projectApprove);
			projectApproveDetailService.merge(projectApproveDetail);
			
			//上报
			
//			if(this.getCheck()==null)
//			{
//			Site site=siteService.findParentSite(getLoginUserFromSession().getSite());
//			
//			String code=projectApprove.getCode();
//		    String name=projectApprove.getName();
//			//String title=projectApprove.getTitle();
//			
//		    ProjectApprove projectApprove2=new ProjectApprove();
//		   // projectApprove2.setCode(code);
//		    projectApprove2.setName(name);
//		    //projectApprove2.setTitle(title);
//		    //projectApprove2.setConstructName(projectApprove.getConstructName());
//		    projectApprove2.setSite(site);
//		    projectApprove2.setState(3);
//		    projectApprove2.setApproveType(projectApprove.getApproveType());
//		    projectApprove=projectApprove2;
//			projectApproveService.save(projectApprove);
//			}
			
		}
		}
		//System.out.println("check="+this.getIsChk());
		//System.out.println("check="+this.getCheck());
		return "redirectInit";
		
	}
	
	//批量推荐
	public String recommendAll() throws Exception{
		
		for(Integer temp:proIds)
		{
			projectApprove=projectApproveService.findById(temp);
			Integer retemp=projectApprove.getRenable();
			if(retemp==0)
			{
			Site site=siteService.findParentSite(getLoginUserFromSession().getSite());
			//User user=(User) userService.findApproveUser(site);
			projectApprove.setRenable(1);
			projectApproveService.update(projectApprove);
			String code=projectApprove.getCode();
		    String name=projectApprove.getName();
		    String scloumnName=projectApprove.getScolumnName();
		    
		    Date createTime=projectApprove.getCreateTime();
			//String title=projectApprove.getTitle();
			
		    ProjectApprove projectApprove2=new ProjectApprove();
		   // projectApprove2.setCode(code);
		    projectApprove2.setName(name);
		    projectApprove2.setScolumnName(scolumnName);
		    //projectApprove2.setTitle(title);
		    //projectApprove2.setConstructName(projectApprove.getConstructName());
		   // projectApprove2.setApproveUser(projectApprove.getApproveUser());
		    projectApprove2.setSite(site);
		    projectApprove2.setState(3);
		   // projectApprove2.setApproveUser(user);
		    projectApprove2.setCreateTime(createTime);
		    projectApprove2.setRenable(0);
		    
		    
		    
		    projectApprove=projectApprove2;
			projectApproveService.save(projectApprove);
			}
		}
		
		
		//System.out.println("check="+this.getIsChk());
		//System.out.println("check="+this.getCheck());
		return "redirectInit";
		
	}
	public ScolumnService getScolumnService() {
		return scolumnService;
	}

	public void setScolumnService(ScolumnService scolumnService) {
		this.scolumnService = scolumnService;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getScolumnName() {
		return scolumnName;
	}

	public void setScolumnName(String scolumnName) {
		this.scolumnName = scolumnName;
	}

	public Integer[] getVerProIds() {
		return verProIds;
	}

	public void setVerProIds(Integer[] verProIds) {
		this.verProIds = verProIds;
	}

	public Integer[] getReProIds() {
		return reProIds;
	}

	public void setReProIds(Integer[] reProIds) {
		this.reProIds = reProIds;
	}
}
