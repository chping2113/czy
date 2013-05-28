package com.kjlink.ahpips.web.action.project;

import java.util.List;

import com.kjlink.ahpips.Constants;
import com.kjlink.ahpips.entity.project.ProjectApprove;
import com.kjlink.ahpips.entity.project.ProjectApproveDetail;
import com.kjlink.ahpips.entity.project.ProjectApproveFlow;
import com.kjlink.ahpips.entity.project.ProjectCoder;
import com.kjlink.ahpips.entity.system.User;
import com.kjlink.ahpips.service.project.ProjectCoderService;
import com.kjlink.ahpips.service.system.CoderService;
import com.kjlink.ahpips.web.action.BaseAction;

public class ProjectCoderAction extends BaseAction<ProjectCoder>{
	private ProjectCoder projectCoder = new ProjectCoder();
	private ProjectCoderService projectCoderService;
	private CoderService coderService;
	private int type;

	
	
	public CoderService getCoderService() {
		return coderService;
	}

	public void setCoderService(CoderService coderService) {
		this.coderService = coderService;
	}


	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public ProjectCoderService getProjectCoderService() {
		return projectCoderService;
	}

	public void setProjectCoderService(ProjectCoderService projectCoderService) {
		this.projectCoderService = projectCoderService;
	}

	public ProjectCoder getModel() {
		return projectCoder;
	}

	public void prepare() throws Exception {
		if(id!=null && id>0){
			this.projectCoder = projectCoderService.findById(id);
		}
	}
	public String init() throws Exception {
		this.getSession().remove("projectCoder_queryStr");
		this.pageInfo=projectCoderService.quickSearch("", getPageNo(), getMaxPageSize());
		return "projectCoderList";
	}
	public String codeList() throws Exception {
		this.getSession().remove("projectCoder_queryStr");
		this.pageInfo=projectCoderService.quickSearch("", getPageNo(), getMaxPageSize());
		return "codeList";
	}
	public String query() throws Exception {
		if(queryStr != null)
			this.getSession().put("projectCoder_queryStr", queryStr);
		else
			queryStr = (String)this.getSession().get("projectCoder_queryStr");


		this.pageInfo=projectCoderService.quickSearch(queryStr, getPageNo(), getMaxPageSize());
		
		return "projectCoderList";
	}

	public String initAdd() throws Exception{
		return "projectCoderAdd";
	}
	public String view() throws Exception{
		return "projectCoderView";
	}

	public String add() throws Exception{
		if(type==3){
			if(projectCoder.getProjectCode()==null || projectCoder.getProjectCode().equals("")){
				String temp=projectCoder.getXzqCode();
				projectCoder.setState(1);
				String projectCode=coderService.generateCoderByPrefix(temp+projectCoder.getSiteCode(), "addCode");
				projectCoder.setProjectCode(projectCode);
			}
			
		}
		
		projectCoderService.merge(projectCoder);
		
		return "redirectInit";
	}
	
	/**
	 * 通过ajax验证项目名称是否已被使用
	 */
	public String checkProjectName()  throws Exception {
		String s=getRequest().getParameter("editId");
		int editId=-1;
		if(s!=null && !s.equals("")){
			editId=Integer.parseInt(getRequest().getParameter("editId"));
		}
		String projectName=getRequest().getParameter("projectName");
		boolean exists = this.projectCoderService.checkProjectName(projectName, editId);
		String msg = "ok";
		if(exists) {
			msg = "err";
		}
		this.writeToResponse(msg);
		return null;
	}
	
	public String delete() throws Exception{
		if(projectCoder != null){
			projectCoderService.delete(projectCoder);
		}
		return "redirectInit";
	}

}
