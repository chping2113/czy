package com.kjlink.ahpips.web.action.info;

import org.apache.struts2.dispatcher.ServletDispatcherResult;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import com.brady.common.util.Base64;
import com.kjlink.ahpips.entity.info.Task;
import com.kjlink.ahpips.service.info.TaskService;
import com.kjlink.ahpips.service.system.SiteService;
import com.kjlink.ahpips.web.action.BaseAction;
import com.opensymphony.xwork2.Result;


public class TaskAction extends BaseAction<Task> {
	private Task model = new Task(); //用于保存模型驱动对象
	private TaskService taskService;
	
	private int  siteId;
	private int type;
	private SiteService siteService;
	
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
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

	/**
	 * 返回模型驱动对象
	 */
	public Task getModel() {
		return model;
	}

	/**
	 * 实现Struts2的preparable接口
	 */
	public void prepare() throws Exception {
		if (id != null && id > 0) {
			model = this.taskService.findById(id);
		}
		String stid=this.getRequest().getParameter("id");
		if(stid!=null && !stid.equals("")){
			int tid=Integer.parseInt(stid);
			if( tid > 0) {
				//使用Base64对内容进行解码
				model = this.taskService.findById(tid);
			}
		}
		
	}
	
	public String list() throws Exception {
		this.getSession().remove("task_queryStr");
		this.pageInfo = this.taskService.findPageAll(getPageNo(), getMaxPageSize());
		this.pageUrl = "info/task_list.action?type="+type;
		return "listTask";
	}
	public String todo() throws Exception {
		type=1;
		this.getSession().remove("task_queryStr");
		this.pageInfo = this.taskService.todoList("",getPageNo(), getMaxPageSize(),getLoginUserFromSession().getSite());
		this.pageUrl = "info/task_query.action?type="+type;
		return "listTask";
	}

	/**
	 * 快速查询方法
	 * @return
	 * @throws Exception
	 */
	public String query()  throws Exception {
			
		if(queryStr != null)
			this.getSession().put("task_queryStr", queryStr);
		else
			queryStr = (String)this.getSession().get("task_queryStr");
		if(type==1){
			this.pageInfo = this.taskService.todoList(queryStr,getPageNo(), getMaxPageSize(),getLoginUserFromSession().getSite());
		}else{
			this.pageInfo = this.taskService.quickSearch(queryStr, getPageNo(), getMaxPageSize());
		}
		
		this.pageUrl = "info/task_query.action?type="+type;
		return "listTask";
	}
	
	public Result delete()  throws Exception {
		try {	
		
			this.taskService.delete(model);
		} catch(Exception e) {
			this.message = "对不起，当前记录已经被使用，不能被删除！";
			return new ServletDispatcherResult("/WEB-INF/pages/message.jsp");
		}
		return new ServletRedirectResult("info/task_query.action?pageNo=" + this.getPageNo());
	}
	
	public String addRequest()  throws Exception {

		if(id != null && id > 0) {
			//使用Base64对内容进行解码
			String content = model.getContent();
			if(content != null)
				model.setContent(new String(Base64.decode(content)));
		}
		return "addTask";
	}
	
	public Result add()  throws Exception {
		
		//使用Base64对内容进行编码
		if(model.getContent() != null) {
			model.setContent(Base64.encode(model.getContent().getBytes()));
		}
		//处理浮动显示时间
		model.setSite(this.siteService.findById(siteId));
		this.taskService.save(model);
		
		return new ServletRedirectResult("info/task_query.action?pageNo=" + this.getPageNo());
	}
	

	
	public String editRequest()  throws Exception {
		int tid=Integer.parseInt(this.getRequest().getParameter("id"));
		if( tid > 0) {
			//使用Base64对内容进行解码
			String content = model.getContent();
			if(content != null)
				model.setContent(new String(Base64.decode(content)));
		}
//		this.attachFileList=attachFileService.findAttachFileByTask(model);
//		this.getSession().put("attachFileList", attachFileList);
		return "addTask";
	}
	public String viewRequest()  throws Exception {
		int tid=Integer.parseInt(this.getRequest().getParameter("id"));
		if( tid > 0) {
			//使用Base64对内容进行解码
			String content = model.getContent();
			if(content != null)
				model.setContent(new String(Base64.decode(content)));
		}
//		this.attachFileList=attachFileService.findAttachFileByTask(model);
//		this.getSession().put("attachFileList", attachFileList);
		return "viewTask";
	}
	
	public Result edit()  throws Exception {
		//使用Base64对内容进行编码
		
		if(type==1){
			model.setState(1);
			
			this.taskService.update(model);
			return new ServletRedirectResult("info/task_todo.action?pageNo=" + this.getPageNo()+"&type="+type);
		}else{
			if(model.getContent() != null) {
				model.setContent(Base64.encode(model.getContent().getBytes()));
			}
			
			model.setSite(this.siteService.findById(siteId));
		}
		
		this.taskService.update(model);
	
		return new ServletRedirectResult("info/task_query.action?pageNo=" + this.getPageNo()+"&type="+type);
	}
	
	public TaskService getTaskService() {
		return taskService;
	}

	public void setTaskService(TaskService taskService) {
		this.taskService = taskService;
	}

	
}
