package com.kjlink.ahpips.web.action.info;

import org.apache.struts2.dispatcher.ServletDispatcherResult;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import com.kjlink.ahpips.entity.info.NewsCatelog;
import com.kjlink.ahpips.service.info.NewsCatelogService;
import com.kjlink.ahpips.web.action.BaseAction;
import com.opensymphony.xwork2.Result;


public class NewsCatelogAction extends BaseAction<NewsCatelog> {
	private NewsCatelog model = new NewsCatelog(); //用于保存模型驱动对象
	private NewsCatelogService newsCatelogService;
	private Integer parentId;
	
	/**
	 * 返回模型驱动对象
	 */
	public NewsCatelog getModel() {
		return model;
	}

	/**
	 * 实现Struts2的preparable接口
	 */
	public void prepare() throws Exception {
		if (id != null && id > 0) {
			model = this.newsCatelogService.findById(id);
		}
	}
	
	/**
	 * 显示一级栏目
	 * @return
	 * @throws Exception
	 */
	public String listFirst() throws Exception {
		this.getSession().remove("newsCatelog_queryStr");
		this.pageInfo = this.newsCatelogService.findFirstLevelPageAll(getPageNo(), getMaxPageSize());
		this.pageUrl = "info/newsCatelog_listFirst.action";
		return "listFirstLevelNewsCatelog";
	}
	
	/**
	 * 显示二级栏目
	 * @return
	 * @throws Exception
	 */
	public String listSecond() throws Exception {
		this.getSession().remove("newsCatelog_queryStr");
		this.pageInfo = this.newsCatelogService.findSecondLevelPageAll(parentId, getPageNo(), getMaxPageSize());
		this.pageUrl = "info/newsCatelog_listSecond.action";
		this.pageParam = "parentId=" + parentId;
		NewsCatelog parentCatelog = this.newsCatelogService.findById(parentId);
		this.getContext().put("parentCatelog", parentCatelog);
		return "listSecondLevelNewsCatelog";
	}

	/**
	 * 快速查询方法
	 * @return
	 * @throws Exception
	 */
	public String query()  throws Exception {
			
		if(queryStr != null)
			this.getSession().put("newsCatelog_queryStr", queryStr);
		else
			queryStr = (String)this.getSession().get("newsCatelog_queryStr");
		
		this.pageInfo = this.newsCatelogService.quickSearch(queryStr, getPageNo(), getMaxPageSize());
		this.pageUrl = "info/newsCatelog_query.action";
		return "listNewsCatelog";
	}
	
	public String show()  throws Exception {
		if(parentId != null && parentId > 0) {
			NewsCatelog parentCatelog = this.newsCatelogService.findById(parentId);
			this.getContext().put("parentCatelog", parentCatelog);
		}
		return "viewNewsCatelog";
	}
	
	public Result delete()  throws Exception {
		String url = "info/newsCatelog_listFirst.action?pageNo=" + this.getPageNo();
		if(parentId != null && parentId > 0) {
			model.setParent(this.newsCatelogService.findById(parentId));
			url = "info/newsCatelog_listSecond.action?parentId=" + parentId + "&pageNo=" + this.getPageNo();
		}
		
		try {
			this.newsCatelogService.delete(model);
		} catch(Exception e) {
			this.message = "对不起，当前记录已经被使用，不能被删除！";
			return new ServletDispatcherResult("/WEB-INF/pages/message.jsp");
		}
		return new ServletRedirectResult(url);
	}
	
	public String addReq()  throws Exception {
		if(parentId != null && parentId > 0) {
			NewsCatelog parentCatelog = this.newsCatelogService.findById(parentId);
			this.getContext().put("parentCatelog", parentCatelog);
		}
		return "addNewsCatelog";
	}
	
	public Result add()  throws Exception {
		String url = "info/newsCatelog_listFirst.action?pageNo=" + this.getPageNo();
		if(parentId != null && parentId > 0) {
			model.setParent(this.newsCatelogService.findById(parentId));
			url = "info/newsCatelog_listSecond.action?parentId=" + parentId + "&pageNo=" + this.getPageNo();
		}
		
		this.newsCatelogService.save(model);
		return new ServletRedirectResult(url);
	}
	
	public String editReq()  throws Exception {
		if(parentId != null && parentId > 0) {
			NewsCatelog parentCatelog = this.newsCatelogService.findById(parentId);
			this.getContext().put("parentCatelog", parentCatelog);
		}
		return "addNewsCatelog";
	}
	
	public Result edit()  throws Exception {
		String url = "info/newsCatelog_listFirst.action?pageNo=" + this.getPageNo();
		if(parentId != null && parentId > 0) {
			model.setParent(this.newsCatelogService.findById(parentId));
			url = "info/newsCatelog_listSecond.action?parentId=" + parentId + "&pageNo=" + this.getPageNo();
		}
		
		this.newsCatelogService.update(model);
		return new ServletRedirectResult(url);
	}
	
	
	public NewsCatelogService getNewsCatelogService() {
		return newsCatelogService;
	}

	public void setNewsCatelogService(NewsCatelogService newsCatelogService) {
		this.newsCatelogService = newsCatelogService;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

}
