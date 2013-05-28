package com.kjlink.ahpips.web.action.project;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.dispatcher.ServletDispatcherResult;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import com.kjlink.ahpips.Constants;
import com.kjlink.ahpips.entity.project.KeyProject;
import com.kjlink.ahpips.entity.project.KeyProjectKind;
import com.kjlink.ahpips.entity.project.Project;
import com.kjlink.ahpips.entity.project.ProjectApprove;
import com.kjlink.ahpips.entity.project.ProjectConstruct;
import com.kjlink.ahpips.entity.system.User;
import com.kjlink.ahpips.service.project.ProjectApproveService;
import com.kjlink.ahpips.service.project.ProjectConstructService;
import com.kjlink.ahpips.service.project.ProjectIssueService;
import com.kjlink.ahpips.service.project.ProjectAegisService;
import com.kjlink.ahpips.service.project.ProjectService;
import com.kjlink.ahpips.web.action.BaseAction;
import com.opensymphony.xwork2.Result;

public class ProjectIssueAction extends BaseAction<KeyProject> {
	private KeyProject model = new KeyProject();
	private KeyProjectKind keyProjectKind = new KeyProjectKind();
	private ProjectConstruct projectConstruct = new ProjectConstruct();
	private String queryCode;
	
	public String getQueryCode() {
		return queryCode;
	}
	public void setQueryCode(String queryCode) {
		this.queryCode = queryCode;
	}

	private String[] projectIds;

	public String[] getProjectIds() {
		return projectIds;
	}
	public void setProjectIds(String[] projectIds) {
		this.projectIds = projectIds;
	}

	private ProjectIssueService projectIssueService;
	private ProjectAegisService ProjectAegisService;
	private ProjectService projectService;
	private ProjectConstructService projectConstructService;
	


	public ProjectConstructService getProjectConstructService() {
		return projectConstructService;
	}
	public void setProjectConstructService(
			ProjectConstructService projectConstructService) {
		this.projectConstructService = projectConstructService;
	}

	private String keyname;
	private int keyid;
	public String getKeyname() {
		return keyname;
	}
	public void setKeyname(String keyname) {
		this.keyname = keyname;
	}
	public int getKeyid() {
		return keyid;
	}
	public void setKeyid(int keyid) {
		this.keyid = keyid;
	}
	
	

	private String actionType;
	
	public String getActionType() {
		return actionType;
	}
	public void setActionType(String actionType) {
		this.actionType = actionType;
	}


	public ProjectService getProjectService() {
		return projectService;
	}
	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}
	public ProjectAegisService getProjectAegisService() {
		return ProjectAegisService;
	}
	public void setProjectAegisService(ProjectAegisService projectAegisService) {
		ProjectAegisService = projectAegisService;
	}
	
	public KeyProjectKind getKeyProjectKind() {
		return keyProjectKind;
	}
	public void setKeyProjectKind(KeyProjectKind keyProjectKind) {
		this.keyProjectKind = keyProjectKind;
	}
	/**
	 * 返回模型驱动对象
	 */
	public KeyProject getModel() {
		return model;
	}
	public ProjectIssueService getProjectIssueService() {
		return projectIssueService;
	}
	public void setProjectIssueService(ProjectIssueService projectIssueService) {
		this.projectIssueService = projectIssueService;
	}
	/**
	 * 实现Struts2的preparable接口
	 */
	public void prepare() throws Exception {
		if (id != null && id > 0) {
			model = this.projectIssueService.findById(id);
		}
	}
	
	public String list() throws Exception {
		this.getSession().remove("keyProject_queryStr");
		this.pageInfo = this.projectIssueService.findPageAllByKeyId(getPageNo(), getMaxPageSize(), keyid);
		//this.pageInfo = this.projectIssueService.findPageAll(getPageNo(), getMaxPageSize());
		this.pageUrl = "project/projectIssue_list.action?keyid="+keyid;
		return "projectIssueList";
	}

	/**
	 * 快速查询方法
	 * @return
	 * @throws Exception
	 */
	public String query()  throws Exception {
		if(queryStr != null)
			this.getSession().put("keyProject_queryStr", queryStr);
		else
			queryStr = (String)this.getSession().get("keyProject_queryStr");
		this.pageInfo = this.projectIssueService.quickSearch(keyid, queryStr, getPageNo(), getMaxPageSize());
		this.pageUrl = "project/projectIssue_query.action";
		return "projectIssueList";
		
	}
	
	public String quickQuery()  throws Exception {
		//List<Project> projectList = this.projectService.findByName(queryCode);
		User user=(User)this.getSession().get("loginUser");
		String sitecode=user.getSite().getCode();
		List<ProjectApprove> projectList=null;
		if(Constants.ANHUI.equals(sitecode)){
			projectList= this.projectConstructService.findProjectByName(queryCode);
		}else{
			projectList= this.projectConstructService.findProjectByNameAndSitecode(queryCode,sitecode);
		}
		
		this.getContext().put("projectList", projectList);
		return "listProjectIssue";
	}
	
	public Result delete()  throws Exception {
		try {
			this.projectIssueService.delete(model);
		} catch(Exception e) {
			this.message = "对不起，当前记录已经被使用，不能被删除！";
			return new ServletDispatcherResult("/WEB-INF/pages/message.jsp");
		}
		return new ServletRedirectResult("project/projectIssue_list.action?keyid="+keyid+"&pageNo=" + this.getPageNo());
	}
	
	public String addRequest()  throws Exception {
		keyProjectKind = this.ProjectAegisService.findById(this.keyid);
		this.getContext().put("keyProjectKind", keyProjectKind);
		return "projectIssueAdd";
	}
	
	public Result add() throws Exception {
		if(this.getKeyProjectKind() != null){
			model.setCreateDate(new Date());
			model.setUser(this.getLoginUserFromSession());
			model.setKeyProjectKind(this.getKeyProjectKind());
			this.projectIssueService.saveKeyProject(model,projectIds);
			this.actionType = "ok";
		}
		this.keyid = this.getKeyProjectKind().getId();
		return new ServletRedirectResult("project/projectIssue_list.action?keyid="+keyid+"&pageNo=" + this.getPageNo());
	}
	
	public String checkMaxRecord() throws Exception {
		String msg = "ok";
		
		keyProjectKind.setId(keyid);
		List<KeyProject> keyList = this.projectIssueService.findProjectIdByKindId(keyProjectKind);
		if(keyList != null && keyList.size()>=10){
			msg="no";
		}
		
		List<KeyProject> keyList1 = this.projectIssueService.isValidProjectKeyId(keyid, projectIds[0]+"");
		if(keyList1 != null && keyList1.size()>0){
			msg="has";
		}
		
		this.writeToResponse(msg);
		return null;
	}
	
	public String editReq() throws Exception {
		return "projectIssueAdd";
	}
	
	public Result edit() throws Exception {
		this.projectIssueService.update(model);
		return new ServletRedirectResult("project/projectIssue_list.action?pageNo=" + this.getPageNo());
	}
	
	public String show() throws Exception {
		return "projectIssueView";
	}
}
