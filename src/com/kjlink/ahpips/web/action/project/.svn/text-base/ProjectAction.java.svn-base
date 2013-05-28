package com.kjlink.ahpips.web.action.project;

import java.util.List;

import com.kjlink.ahpips.entity.project.Project;
import com.kjlink.ahpips.service.project.ProjectService;
import com.kjlink.ahpips.service.system.CoderService;
import com.kjlink.ahpips.service.system.DistrictService;
import com.kjlink.ahpips.web.action.BaseAction;

public class ProjectAction extends BaseAction<Project>{
	private Project project = new Project();
	private ProjectService projectService ;
	private CoderService coderService ;
	private DistrictService districtService ;
	private int companyId = 0 ;
	private String districtCode = "" ;
	private String coder ;
	private String prefixCode = "";
	private String type;
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String init() throws Exception {
		this.getSession().remove("project_queryStr");
		this.pageInfo = projectService.findPageAll(getPageNo(), getMaxPageSize(),"");
		return "projectList";
	}
	
	public String initPublic() throws Exception {
		this.getSession().remove("project_queryStr");
		this.pageInfo = projectService.findApprovePageAll(getPageNo(), getMaxPageSize(),"");
		if(type.equals("1")){
			return "projectConstructList";
		}
		return "projectPublicList";
	}
	
	public String query() throws Exception {
		if(queryStr != null)
			this.getSession().put("project_queryStr", queryStr);
		else
			queryStr = (String)this.getSession().get("project_queryStr");
		this.pageInfo = projectService.findPageAll(getPageNo(), getMaxPageSize(),queryStr);
		return "projectList";
	}
	
	public String queryPublic() throws Exception {
		if(queryStr != null)
			this.getSession().put("project_queryStr", queryStr);
		else
			queryStr = (String)this.getSession().get("project_queryStr");
		this.pageInfo = projectService.findApprovePageAll(getPageNo(), getMaxPageSize(),queryStr);
		if(type.equals("1")){
			return "projectConstructList";
		}
		return "projectPublicList";
	}
	
	public String initAdd() throws Exception{
		return "projectAdd";
	}
	
	public String add() throws Exception{
		if(project != null){
			if(!"".equals(districtCode)){
				project.setDistrict(districtService.findByCode(districtCode));
			}
			if(this.getLoginUserFromSession() != null){
				project.setSite(this.getLoginUserFromSession().getSite());
			}
			projectService.merge(project);
		}
		return "redirectInit";
	}
	
	public String view() throws Exception{
		return "projectView";
	}
	
	public String delete() throws Exception{
		if(project != null){
			projectService.delete(project);
		}
		return "redirectInit";
	}
	
	public String initApprove() throws Exception{
		if(project != null){
			this.prefixCode = project.getDistrict().getCode();
			this.coder = coderService.generateCoderByPrefix(this.prefixCode,"code");
			List<Project> list = this.projectService.findByCode(this.coder);
			if(list.size()>0){
				this.coder = coderService.generateCoderByPrefix(this.prefixCode,"addCode");
			}
		}
		return "projectApprove";
	}
	
	public String approve() throws Exception{
		if(project != null){
			project.setState(1);
			projectService.merge(project);
			this.prefixCode = project.getDistrict().getCode();
			this.coder = coderService.generateCoderByPrefix(this.prefixCode,project.getCode());
		}
		return this.init();
	}
	
	public String validateCode() throws Exception{
		List<Project> list = this.projectService.findByCode(coder);
		if(list.size()>0){
			this.writeToResponse("true");
		}else{
			this.writeToResponse("false");
		}
		return null; 
	}

	@Override
	public Project getModel() {
		return project;
	}

	@Override
	public void prepare() throws Exception {
		if(id!=null && id>0){
			this.project = projectService.findById(id);
		}
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

	public CoderService getCoderService() {
		return coderService;
	}

	public void setCoderService(CoderService coderService) {
		this.coderService = coderService;
	}

	public String getCoder() {
		return coder;
	}

	public void setCoder(String coder) {
		this.coder = coder;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public DistrictService getDistrictService() {
		return districtService;
	}

	public void setDistrictService(DistrictService districtService) {
		this.districtService = districtService;
	}

	public String getDistrictCode() {
		return districtCode;
	}

	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}

}
