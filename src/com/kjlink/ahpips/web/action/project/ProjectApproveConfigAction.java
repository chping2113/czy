package com.kjlink.ahpips.web.action.project;

import java.util.List;

import com.kjlink.ahpips.entity.project.ProjectApproveConfig;
import com.kjlink.ahpips.entity.project.ProjectApproveFlow;
import com.kjlink.ahpips.service.project.ProjectApproveConfigService;
import com.kjlink.ahpips.service.system.SiteService;
import com.kjlink.ahpips.web.action.BaseAction;

public class ProjectApproveConfigAction  extends BaseAction<ProjectApproveConfig>{

	private ProjectApproveConfig projectApproveConfig=new ProjectApproveConfig();
	private ProjectApproveConfigService projectApproveConfigService;
	

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
	public ProjectApproveConfig getProjectApproveConfig() {
		return projectApproveConfig;
	}


	public void setProjectApproveConfig(ProjectApproveConfig projectApproveConfig) {
		this.projectApproveConfig = projectApproveConfig;
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


	public ProjectApproveConfigService getProjectApproveConfigService() {
		return projectApproveConfigService;
	}


	public void setProjectApproveConfigService(
			ProjectApproveConfigService projectApproveConfigService) {
		this.projectApproveConfigService = projectApproveConfigService;
	}


	private SiteService siteService ;
	public SiteService getSiteService() {
		return siteService;
	}


	public void setSiteService(SiteService siteService) {
		this.siteService = siteService;
	}


	public ProjectApproveConfig getModel() {
		
		return projectApproveConfig;
	}
	public String initAdd(){
		List<ProjectApproveConfig> projectApproveConfigList = projectApproveConfigService.findByProjectApproveConfigSite(getLoginUserFromSession().getSite());
		for(int i=0;i<projectApproveConfigList.size();i++){
			projectApproveConfig=projectApproveConfigList.get(i);
			this.getContext().put(projectApproveConfig.getApproveName()+"SiteId", projectApproveConfig.getApproveSite().getId());
			this.getContext().put(projectApproveConfig.getApproveName()+"SiteName", projectApproveConfig.getApproveSite().getName());
		}
		return "projectApproveConfigAdd";
	}
	public String add(){
		List<ProjectApproveConfig> projectApproveConfigList = projectApproveConfigService.findByProjectApproveConfigSite(getLoginUserFromSession().getSite());
		for(int i=0;i<projectApproveConfigList.size();i++){
			projectApproveConfig=projectApproveConfigList.get(i);
			projectApproveConfigService.delete(projectApproveConfig);
		}
		if(planSiteId!=null && !planSiteId.equals("") ){
			projectApproveConfig = new  ProjectApproveConfig();
			projectApproveConfig.setSite(getLoginUserFromSession().getSite());
			projectApproveConfig.setApproveSite(siteService.findById(Integer.parseInt(planSiteId)));
			projectApproveConfig.setApproveName("plan");
			projectApproveConfigService.merge(projectApproveConfig);
		}
		if(proposeSiteId!=null && !proposeSiteId.equals("") ){
			projectApproveConfig = new  ProjectApproveConfig();
			projectApproveConfig.setSite(getLoginUserFromSession().getSite());
			projectApproveConfig.setApproveSite(siteService.findById(Integer.parseInt(proposeSiteId)));
			projectApproveConfig.setApproveName("propose");
			projectApproveConfigService.merge(projectApproveConfig);
		}
	

		if(feasibilitySiteId!=null && !feasibilitySiteId.equals("") ){
			projectApproveConfig = new  ProjectApproveConfig();
			projectApproveConfig.setSite(getLoginUserFromSession().getSite());
			projectApproveConfig.setApproveSite(siteService.findById(Integer.parseInt(feasibilitySiteId)));
			projectApproveConfig.setApproveName("feasibility");
			projectApproveConfigService.merge(projectApproveConfig);
		}

		if(designSiteId!=null && !designSiteId.equals("") ){
			projectApproveConfig = new  ProjectApproveConfig();
			projectApproveConfig.setSite(getLoginUserFromSession().getSite());
			projectApproveConfig.setApproveSite(siteService.findById(Integer.parseInt(designSiteId)));
			projectApproveConfig.setApproveName("design");
			projectApproveConfigService.merge(projectApproveConfig);
		}

		if(energySiteId!=null && !energySiteId.equals("") ){
			projectApproveConfig = new  ProjectApproveConfig();
			projectApproveConfig.setSite(getLoginUserFromSession().getSite());
			projectApproveConfig.setApproveSite(siteService.findById(Integer.parseInt(energySiteId)));
			projectApproveConfig.setApproveName("energy");
			projectApproveConfigService.merge(projectApproveConfig);
		}

		if(addressSiteId!=null && !addressSiteId.equals("") ){
			projectApproveConfig = new  ProjectApproveConfig();
			projectApproveConfig.setSite(getLoginUserFromSession().getSite());
			projectApproveConfig.setApproveSite(siteService.findById(Integer.parseInt(addressSiteId)));
			projectApproveConfig.setApproveName("address");
			projectApproveConfigService.merge(projectApproveConfig);
		}

		if(landSiteId!=null && !landSiteId.equals("") ){
			projectApproveConfig = new  ProjectApproveConfig();
			projectApproveConfig.setSite(getLoginUserFromSession().getSite());
			projectApproveConfig.setApproveSite(siteService.findById(Integer.parseInt(landSiteId)));
			projectApproveConfig.setApproveName("land");
			projectApproveConfigService.merge(projectApproveConfig);
		}

		if(environmentSiteId!=null && !environmentSiteId.equals("") ){
			projectApproveConfig = new  ProjectApproveConfig();
			projectApproveConfig.setSite(getLoginUserFromSession().getSite());
			projectApproveConfig.setApproveSite(siteService.findById(Integer.parseInt(environmentSiteId)));
			projectApproveConfig.setApproveName("environment");
			projectApproveConfigService.merge(projectApproveConfig);
		}

		if(approveResultSiteId!=null && !approveResultSiteId.equals("") ){
			projectApproveConfig = new  ProjectApproveConfig();
			projectApproveConfig.setSite(getLoginUserFromSession().getSite());
			projectApproveConfig.setApproveSite(siteService.findById(Integer.parseInt(approveResultSiteId)));
			projectApproveConfig.setApproveName("approveResult");
			projectApproveConfigService.merge(projectApproveConfig);
		}

		if(startReportsSiteId!=null && !startReportsSiteId.equals("") ){
			projectApproveConfig = new  ProjectApproveConfig();
			projectApproveConfig.setSite(getLoginUserFromSession().getSite());
			projectApproveConfig.setApproveSite(siteService.findById(Integer.parseInt(startReportsSiteId)));
			projectApproveConfig.setApproveName("startReports");
			projectApproveConfigService.merge(projectApproveConfig);
		}
		
		
		
		
		return "redirectInit";
	}
	public void prepare() throws Exception {
		if(id!=null&&id>0){
			this.projectApproveConfig = projectApproveConfigService.findById(id);
		}
		
	}

}
