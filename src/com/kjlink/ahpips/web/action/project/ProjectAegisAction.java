package com.kjlink.ahpips.web.action.project;

import org.apache.struts2.dispatcher.ServletDispatcherResult;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import com.kjlink.ahpips.entity.project.KeyProjectKind;
import com.kjlink.ahpips.entity.system.Site;
import com.kjlink.ahpips.service.project.ProjectAegisService;
import com.kjlink.ahpips.web.action.BaseAction;
import com.opensymphony.xwork2.Result;

public class ProjectAegisAction extends BaseAction<KeyProjectKind> {
	private KeyProjectKind model = new KeyProjectKind();
	private ProjectAegisService projectAegisService;
	private int type;
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	/**
	 * 返回模型驱动对象
	 */
	public KeyProjectKind getModel() {
		return model;
	}
	public ProjectAegisService getProjectAegisService() {
		return projectAegisService;
	}
	public void setProjectAegisService(ProjectAegisService projectAegisService) {
		this.projectAegisService = projectAegisService;
	}
	/**
	 * 实现Struts2的preparable接口
	 */
	public void prepare() throws Exception {
		if (id != null && id > 0) {
			model = this.projectAegisService.findById(id);
		}
	}
	
	public String list() throws Exception {
		Site site = new Site();
		if(this.getLoginUserFromSession() != null){
			site = this.getLoginUserFromSession().getSite();
		}
		this.getSession().remove("keyProjectKind_queryStr");
		this.pageInfo = this.projectAegisService.quickSearch(queryStr, getPageNo(), getMaxPageSize(),site);
		this.pageUrl = "project/projectAegis_list.action";
		return "projectAegisList";
	}

	/**
	 * 快速查询方法
	 * @return
	 * @throws Exception
	 */
	public String query()  throws Exception {
		Site site = new Site();
		if(this.getLoginUserFromSession() != null){
			site = this.getLoginUserFromSession().getSite();
		}
		if(queryStr != null)
			this.getSession().put("keyProjectKind_queryStr", queryStr);
		else
			queryStr = (String)this.getSession().get("keyProjectKind_queryStr");
		
		this.pageInfo = this.projectAegisService.quickSearch(queryStr, getPageNo(), getMaxPageSize(),site);
		this.pageUrl = "project/projectAegis_query.action";
		return "projectAegisList";
	}
	
	public Result delete()  throws Exception {
		try {
			this.projectAegisService.delete(model);
		} catch(Exception e) {
			this.message = "对不起，当前记录已经被使用，不能被删除！";
			return new ServletDispatcherResult("/WEB-INF/pages/message.jsp");
		}
		return new ServletRedirectResult("project/projectAegis_list.action?pageNo=" + this.getPageNo()+"&type=1");
	}
	
	public String addReq()  throws Exception {
		return "projectAegisAdd";
	}
	
	public Result add() throws Exception {
		
		if(this.getLoginUserFromSession() != null){
			model.setSite(this.getLoginUserFromSession().getSite());
		}
		this.projectAegisService.save(model);
		return new ServletRedirectResult("project/projectAegis_list.action?pageNo=" + this.getPageNo()+"&type=1");
	}
	
	public String editReq() throws Exception {
		return "projectAegisAdd";
	}
	
	public Result edit() throws Exception {
		type=1;
		if(this.getLoginUserFromSession() != null){
			model.setSite(this.getLoginUserFromSession().getSite());
		}
		this.projectAegisService.update(model);
		return new ServletRedirectResult("project/projectAegis_list.action?pageNo=" + this.getPageNo()+"&type=1");
	}
	
	public String show() throws Exception {
		return "projectAegisView";
	}
}
