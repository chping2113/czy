package com.kjlink.ahpips.web.action.info;

import java.util.Date;

import org.apache.struts2.dispatcher.ServletRedirectResult;

import com.brady.common.util.Base64;
import com.kjlink.ahpips.entity.info.Complaint;
import com.kjlink.ahpips.service.info.ComplaintService;
import com.kjlink.ahpips.web.action.BaseAction;
import com.opensymphony.xwork2.Result;

public class ComplaintAction extends BaseAction<Complaint>  {
	private Complaint model = new Complaint(); //用于保存模型驱动对象
	private ComplaintService complaintService;
	
	/**
	 * 返回模型驱动对象
	 */
	public Complaint getModel() {
		return model;
	}

	public ComplaintService getComplaintService() {
		return complaintService;
	}

	public void setComplaintService(ComplaintService complaintService) {
		this.complaintService = complaintService;
	}
	
	/**
	 * 实现Struts2的preparable接口
	 */
	public void prepare() throws Exception {
		if (id != null && id > 0) {
			model = this.complaintService.findById(id);
		}
	}
	
	public String list() throws Exception {
		this.getSession().remove("complaint_queryStr");
		this.pageInfo = this.complaintService.findPageAll(getPageNo(), getMaxPageSize());
		this.pageUrl = "info/complaint_list.action";
		return "listComplaint";
	}

	/**
	 * 快速查询方法
	 * @return
	 * @throws Exception
	 */
	public String query()  throws Exception {
		if(queryStr != null)
			this.getSession().put("complaint_queryStr", queryStr);
		else
			queryStr = (String)this.getSession().get("complaint_queryStr");
		
		this.pageInfo = this.complaintService.quickSearch(queryStr, getPageNo(), getMaxPageSize());
		this.pageUrl = "info/complaint_query.action";
		return "listComplaint";
	}
	public String delete() throws Exception{
		if(model != null){
			try {
				complaintService.delete(model);
			} catch(Exception e) {
				this.message = "对不起，当前记录已经被使用，不能被删除！";
				return "message";
			}

		}
		return "redirectInit";
	}
	
	
//	public Result delete()  throws Exception {
//		try {
//			this.complaintService.delete(model);
//		} catch(Exception e) {
//			this.message = "对不起，当前记录已经被使用，不能被删除！";
//			return new ServletDispatcherResult("/WEB-INF/pages/message.jsp");
//		}
//		return new ServletRedirectResult("info/complaint_list.action?pageNo=" + this.getPageNo());
//	}
	
	public String addReq()  throws Exception {
		if(id != null && id > 0) {
			//使用Base64对内容进行解码
			String content = model.getContent();
			if(content != null)
				model.setContent(new String(Base64.decode(content)));
		}
		return "addComplaint";
	}
	
	public Result add() throws Exception {
		model.setCreateTime(new Date());
		model.setDealState(0);
		//使用Base64对内容进行编码
		if(model.getContent() != null) {
			model.setContent(Base64.encode(model.getContent().getBytes()));
		}
		this.complaintService.save(model);
		return new ServletRedirectResult("info/complaint_list.action?pageNo=" + this.getPageNo());
	}
	
	public String editReq() throws Exception {
		if(id != null && id > 0) {
			//使用Base64对内容进行解码
			String content = model.getContent();
			if(content != null)
				model.setContent(new String(Base64.decode(content)));
		}
		return "editComplaint";
	}
	
	public Result edit() throws Exception {
		model.setDealState(1);
		//使用Base64对内容进行编码
//		if(model.getContent() != null) {
//			model.setContent(Base64.encode(model.getContent().getBytes()));
//		}
		model.setComplaintName(this.getLoginUserFromSession().getCode());
		model.setComplaintDate(new Date());
		this.complaintService.update(model);
		return new ServletRedirectResult("info/complaint_list.action?pageNo=" + this.getPageNo());
	}
	
	public String show() throws Exception {
		if(id != null && id > 0) {
			//使用Base64对内容进行解码
			String content = model.getContent();
			if(content != null)
				model.setContent(new String(Base64.decode(content)));
		}
		return "viewComplaint";
	}
	
}
