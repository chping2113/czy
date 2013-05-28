package com.kjlink.ahpips.web.action.system;

import java.util.Date;
import java.util.List;

import org.apache.struts2.dispatcher.ServletDispatcherResult;

import com.kjlink.ahpips.entity.system.Navigate;
import com.kjlink.ahpips.service.system.NavigateService;
import com.kjlink.ahpips.web.action.BaseAction;

public class NavigateAction extends BaseAction<Navigate> {
	
	private static final long serialVersionUID = 1L;
	private Navigate model=new Navigate();
	private NavigateService navigateService;
	private String queryCode ;
	private int ptype;
	private int parentId;
	private List<Navigate> navigateList;
	
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public int getPtype() {
		return ptype;
	}
	public void setPtype(int ptype) {
		this.ptype = ptype;
	}
	public void setPtype(String ptype) {
		this.ptype = Integer.parseInt(ptype);
	}
	public NavigateService getNavigateService() {
		return navigateService;
	}
	public void setNavigateService(NavigateService navigateService) {
		this.navigateService = navigateService;
	}
	public String getQueryCode() {
		return queryCode;
	}
	public void setQueryCode(String queryCode) {
		this.queryCode = queryCode;
	}

	public Navigate getModel() {
		return model;
	}
	public void prepare() throws Exception {
		if (id != null && id > 0) {
			model = this.navigateService.findById(id);
		}
		
	}
	public String init(){
		this.getSession().remove("navigate_queryStr");
		if(ptype==1){
			this.pageInfo=this.navigateService.findPageAllByParent(getPageNo(), getMaxPageSize(),Integer.valueOf(this.getLoginUserFromSession().getSite().getId()),ptype,parentId);
		}else{
			this.pageInfo=this.navigateService.findPageAll(getPageNo(), getMaxPageSize(),Integer.valueOf(this.getLoginUserFromSession().getSite().getId()),ptype);
		}
		
		
		return "navigateList";
	}

	public String query(){
		if(queryStr != null)
			this.getSession().put("navigate_queryStr", queryStr);
		else
			queryStr = (String)this.getSession().get("navigate_queryStr");
		if(ptype==1){
			//parentId=id;
			this.pageInfo=this.navigateService.quickSearchByParent(queryStr,getPageNo(), getMaxPageSize(),Integer.valueOf(this.getLoginUserFromSession().getSite().getId()),parentId);
		}else{
			this.pageInfo=this.navigateService.quickSearch(queryStr,getPageNo(), getMaxPageSize(),Integer.valueOf(this.getLoginUserFromSession().getSite().getId()));
		}
		return "navigateList";
	}
	
	public String initAdd(){
		this.navigateList = this.navigateService.findAll();
		return "navigateAdd";
	}
	public String add(){
		if(this.getLoginUserFromSession() != null){
			model.setSite(this.getLoginUserFromSession().getSite());
			model.setType(ptype);
			if(ptype==1){
				model.setParent(navigateService.findById(parentId));
			}
		}
		this.navigateService.merge(model);
		return "redirectInit";
	}
	public String view() throws Exception{
		return "navigateView";
	}
	public String initEdit(){
		return "navigateEdit";
	}
	public String delete() throws Exception{
		try{
			if(model != null){
				navigateService.delete(model);
			}
		}catch(Exception e){
			e.printStackTrace();
			this.message = "对不起，当前记录已经被使用，不能被删除！";
			return "message";
		}
		return "redirectInit";
	}

}
