package com.kjlink.ahpips.web.action.info;

import java.util.List;

import org.apache.struts2.dispatcher.ServletDispatcherResult;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import com.kjlink.ahpips.entity.info.Scolumn;
import com.kjlink.ahpips.entity.info.ScolumnProperty;
import com.kjlink.ahpips.entity.system.Site;
import com.kjlink.ahpips.service.info.ScolumnPropertyService;
import com.kjlink.ahpips.service.info.ScolumnService;
import com.kjlink.ahpips.service.system.SiteService;
import com.kjlink.ahpips.web.action.BaseAction;
import com.opensymphony.xwork2.Result;

@SuppressWarnings("unchecked")
public class ScolumnAction extends BaseAction<Scolumn> {

	
	private static final long serialVersionUID = 1L;
	private Scolumn model = new Scolumn();
	private ScolumnService scolumnService;
	private List<Scolumn> list;
	private Integer parentId;
	private Integer siteId;
	private SiteService siteService;
	
	private ScolumnPropertyService scolumnPropertyService;
	
	private List<ScolumnProperty> properties;
	
	/**
	 * 返回模型驱动对象
	 */
	public Scolumn getModel() {
		return model;
	}

	public void prepare() throws Exception {
		if (id != null && id > 0) {
			model = this.scolumnService.findById(id);
		}
		
		if(siteId != null && siteId > 0){
			Site site = this.siteService.findById(siteId);
			this.getContext().put("site", site);
		}
		
		System.out.println("LLLLLL"+id);
		
	}


	/**
	 * 显示一级栏目
	 * @return
	 * @throws Exception
	 */
	public String listFirst() throws Exception {
		this.getSession().remove("scolumn_queryStr");
		this.pageInfo = this.scolumnService.findFirstLevelPageAll(siteId, getPageNo(), getMaxPageSize());
		this.pageUrl = "info/scolumn_listFirst.action";
		
		return "listFirstLevelScolumn";
	}
	
	/**
	 * 显示二级栏目
	 * @return
	 * @throws Exception
	 */
	public String listSecond() throws Exception {
		this.getSession().remove("scolumn_queryStr");
		this.pageInfo = this.scolumnService.findSecondLevelPageAll(parentId, getPageNo(), getMaxPageSize());
		this.pageUrl = "info/scolumn_listSecond.action";
		this.pageParam = "parentId=" + parentId;
		Scolumn parentScolumn = this.scolumnService.findById(parentId);
		this.getContext().put("parentScolumn", parentScolumn);
		return "listSecondLevelScolumn";
	}
	
	public String addRequest()  throws Exception {
		if(parentId != null && parentId > 0) {
			Scolumn parentScolumn = this.scolumnService.findById(parentId);
			this.getContext().put("parentScolumn", parentScolumn);
		}
		
		/*List<Template> templateList = this.templateService.findAll();
		this.getSession().put("templateList", templateList);
		*/
		return "addScolumn";
	}
	
	/**
	 * 新增方法
	 * @return
	 * @throws Exception
	 */
	public Result add()  throws Exception {
		String url = "info/scolumn_listFirst.action?siteId=" + siteId+ "&pageNo=" + this.getPageNo();
		if(parentId != null && parentId > 0) {
			model.setParent(this.scolumnService.findById(parentId));
			url = "info/scolumn_listSecond.action?parentId=" + parentId + "&siteId=" + siteId+ "&pageNo=" + this.getPageNo();
		}
		if(siteId != null && siteId > 0) {
			model.setSite(this.siteService.findById(siteId));
		}
		this.scolumnService.merge(model);
		return new ServletRedirectResult(url);
	}
	
	/**
	 * 查看方法
	 * @return
	 * @throws Exception
	 */
	public String view() throws Exception {
		if(parentId != null && parentId > 0) {
			Scolumn parentScolumn = this.scolumnService.findById(parentId);
			this.getContext().put("parentScolumn", parentScolumn);
		}
		
		//this.pageInfo = this.scolumnPropertyService.findByScolumnId(id, getPageNo(), getMaxPageSize());
		
		return "viewScolumn";
	}
	
	/**
	 * 编辑方法
	 * @return
	 * @throws Exception
	 */
	public Result edit() throws Exception {
		String url = "info/scolumn_listFirst.action?siteId=" + siteId +"&pageNo=" + this.getPageNo();
		/*if(parentId != null && parentId > 0) {
			model.setParent(this.scolumnService.findById(parentId));
			url = "info/scolumn_listSecond.action?parentId=" + parentId + "&siteId=" + siteId+ "&pageNo=" + this.getPageNo();
		}
		this.scolumnService.update(model);
		
		System.out.println("name1 = ");*/
		/*
		String[] properties = this.getRequest().getParameterValues("properties");
		String[] contents = this.getRequest().getParameterValues("contents");
		
		if(properties!=null){
			for(int i=0;i<properties.length;i++){
				ScolumnProperty scolumnProperty = new ScolumnProperty();
				System.out.println("name = ");
				System.out.println("name = " + properties[i]);
				scolumnProperty.setName(properties[i]);
				scolumnProperty.setScolumnId(this.scolumnService.findById(id));
				scolumnProperty.setState(1);
				scolumnProperty.setCreateTime(new Date());
				scolumnProperty.setContent(contents[i]);
				this.scolumnPropertyService.saveOrUpdate(scolumnProperty);
			}
		}*/
		return new ServletRedirectResult(url);
	}
	
	public String editRequest()  throws Exception {
		if(parentId != null && parentId > 0) {
			Scolumn parentScolumn = this.scolumnService.findById(parentId);
			this.getContext().put("parentScolumn", parentScolumn);
		}
		
		return "addScolumn";
	}
	/**
	 * 删除方法
	 * @return
	 * @throws Exception
	 */
	public Result delete()  throws Exception {
		String url = "info/scolumn_listFirst.action?siteId=" + siteId +"&pageNo=" + this.getPageNo();
		if(parentId != null && parentId > 0) {
			model.setParent(this.scolumnService.findById(parentId));
			url = "info/scolumn_listSecond.action?parentId=" + parentId + "&siteId=" + siteId +"&pageNo=" + this.getPageNo();
		}
		try {
			model.setEnable(1);
			this.scolumnService.update(model);
		} catch(Exception e) {
			this.message = "对不起，当前记录已经被使用，不能被删除！";
			return new ServletDispatcherResult("/WEB-INF/pages/message.jsp");
		}
		return new ServletRedirectResult(url);
	}
	
	/**
	 * 快速查询方法
	 * @return
	 * @throws Exception
	 */
	public String query()  throws Exception {
		
		if(queryStr != null)
			this.getSession().put("scolumn_queryStr", queryStr);
		else
			queryStr = (String)this.getSession().get("scolumn_queryStr");
		
		this.pageInfo = this.scolumnService.findFirstLevelByName(queryStr, getPageNo(), getMaxPageSize());
		this.pageUrl = "info/scolumn_query.action";
		return "listFirstLevelScolumn";
	}
	
	public String initProperty() throws Exception {
		
		String stid=this.getRequest().getParameter("id");
		
		if(stid!=null && !stid.equals("")){
			int tid=Integer.parseInt(stid);
			if( tid > 0) {
				id=tid;
				this.properties=scolumnPropertyService.findByScolumnId(id);
				this.getSession().put("properties", properties);
			}
		}
		return "listScolumnProperty";
	}
	
	public String deleteProperty() throws Exception {
		System.out.println("HUHUH");
		String stid=this.getRequest().getParameter("spid");
		String scolId=this.getRequest().getParameter("id");
		id = Integer.parseInt(scolId);
		System.out.println("HUHUH"+ Integer.parseInt(stid));
		if(stid!=null && !stid.equals("")){
			int tid=Integer.parseInt(stid);
			System.out.println("HUHUH"+ tid);
			if( tid > 0) {
				//id=tid;
				this.scolumnPropertyService.delete(this.scolumnPropertyService.findById(tid));
			}
		}
		this.properties=scolumnPropertyService.findByScolumnId(id);
		this.getSession().put("properties", properties);
		
		System.out.println("HUHUH"+ id);
		
		return "listScolumnProperty";
		
	}
		
	public ScolumnService getScolumnService() {
		return scolumnService;
	}

	public void setScolumnService(ScolumnService scolumnService) {
		this.scolumnService = scolumnService;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Integer getSiteId() {
		return siteId;
	}

	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
	}

	public SiteService getSiteService() {
		return siteService;
	}

	public void setSiteService(SiteService siteService) {
		this.siteService = siteService;
	}

	public ScolumnPropertyService getScolumnPropertyService() {
		return scolumnPropertyService;
	}

	public void setScolumnPropertyService(
			ScolumnPropertyService scolumnPropertyService) {
		this.scolumnPropertyService = scolumnPropertyService;
	}

	public List<ScolumnProperty> getProperties() {
		return properties;
	}

	public void setProperties(List<ScolumnProperty> properties) {
		this.properties = properties;
	}
	
}
