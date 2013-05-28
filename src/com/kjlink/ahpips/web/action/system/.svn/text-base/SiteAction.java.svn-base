package com.kjlink.ahpips.web.action.system;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;

import org.apache.struts2.dispatcher.ServletDispatcherResult;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import com.brady.common.util.Base64;
import com.kjlink.ahpips.entity.system.District;
import com.kjlink.ahpips.entity.system.Site;
import com.kjlink.ahpips.pojo.ZTree;
import com.kjlink.ahpips.service.system.SiteService;
import com.kjlink.ahpips.web.action.BaseAction;
import com.kjlink.common.util.ExcelImport;
import com.opensymphony.xwork2.Result;

@SuppressWarnings("serial")
public class SiteAction extends BaseAction<Site> {
	private Site model = new Site(); //用于保存模型驱动对象
	private SiteService siteService;
	private Integer parentId; //上级节点ID
	private String actionType = "edit";
	private String queryCode ;
	private List<Site> list;
	
	private File attachFile ;
	
	/**
	 * 返回模型驱动对象
	 */
	public Site getModel() {
		return model;
	}

	/**
	 * 实现Struts2的preparable接口
	 */
	public void prepare() throws Exception {
		if (id != null && id > 0) {
			model = this.siteService.findById(id);
		}
	}
	
	/**
	 * 快速查询方法
	 * @return
	 * @throws Exception
	 */
	
	public String query()  throws Exception {
			
		if(queryStr != null) {
			this.getSession().put("site_queryStr", queryStr);
		}
		else 
			queryStr = (String)this.getSession().get("site_queryStr");
		this.pageInfo = this.siteService.quickSearch(queryStr, getPageNo(), getMaxPageSize());
		this.pageUrl = "system/site_query.action";

		return "listSite";
	}
	
	public String show()  throws Exception {
		int childNodesCount = this.siteService.getChildNodesCount(id);
		this.getContext().put("childNodesCount", childNodesCount);
		return "viewStickSet";
	}
	
	public String list() throws Exception {
		this.getSession().remove("site_queryStr");
		this.pageInfo = this.siteService.findPageAll(getPageNo(), getMaxPageSize());
		this.pageUrl = "system/site_list.action";
		return "listSite";
	}
	
	
	public String addRequest()  throws Exception {
		if(id != null && id > 0) {
			String content = model.getContent();
			if(content != null)
				model.setContent(new String(Base64.decode(content)));
		}
		list = this.siteService.findAll();
		this.getSession().put("siteList",list);
		
		/*
		List<Template> templateList = this.templateService.findAll();
		this.getSession().put("templateList", templateList);*/
		
		return "addSite";
	}
	
	public Result add()  throws Exception {
		if(model.getContent() != null) {
			model.setContent(Base64.encode(model.getContent().getBytes()));
		}
		List<Site> site = this.siteService.findByName(model.getName());
		for(int i=0;i<site.size();i++){
			site.get(i).setContent(model.getContent());
			site.get(i).setName(model.getName());
			site.get(i).setState(model.getState());
			log.info("grade" + model.getGrade());
			site.get(i).setGrade(model.getGrade());
			//site.get(i).setTemplate(this.templateService.findById(templateId));
			
			this.siteService.update(site.get(i));
		}
		
		return new ServletRedirectResult("system/site_list.action?pageNo=" + this.getPageNo());
	}

	public String viewRequest()  throws Exception {
		System.out.println("MMMM1"+model.getName());
		String tid=this.getRequest().getParameter("id");
		System.out.println("MMMM2"+model.getName());
		if( tid != null) {
			//使用Base64对内容进行解码
			String content = model.getContent();
			if(content != null)
				model.setContent(new String(Base64.decode(content)));
			System.out.println("MMMM3"+model.getName());
			
		}
		System.out.println("MMMM4"+model.getName());
		return "viewSite";
	}
	
	public String editRequest()  throws Exception {
		String tid = this.getRequest().getParameter("id");
		if( tid !=null) {
			//使用Base64对内容进行解码
			String content = model.getContent();
			if(content != null)
				model.setContent(new String(Base64.decode(content)));
		}
		return "addSite";
	}
	
	public Result edit()  throws Exception {
		if(model.getContent() != null) {
			model.setContent(Base64.encode(model.getContent().getBytes()));
		}
		this.siteService.update(model);
		
		return new ServletRedirectResult("system/site_list.action?pageNo=" + this.getPageNo());
	}
	
	public Result delete() {
		try {	
			model.setEnable(1);
			this.siteService.update(model);
		} catch(Exception e) {
			this.message = "对不起，当前记录已经被使用，不能被删除！";
			return new ServletDispatcherResult("/WEB-INF/pages/message.jsp");
		}
		return new ServletRedirectResult("system/site_list.action?pageNo=" + this.getPageNo());
	}
	
	public SiteService getSiteService() {
		return siteService;
	}

	public void setSiteService(SiteService siteService) {
		this.siteService = siteService;
	}

	
	
	
	/**
	 * 以树形方式加载数据
	 */
	public String buildSiteTree() throws Exception {
		List<Site> allSites = this.siteService.findSiteAll();
		Site siteRoot = this.siteService.findRootSite();
		ZTree ztree = new ZTree(String.valueOf(siteRoot.getId()), siteRoot.getName(), "", false);
		this.siteService.bulidSiteTree(allSites, ztree);
		
		ArrayList<ZTree> ztreeList = new ArrayList<ZTree>();
		ztreeList.add(ztree);
		JSONArray jo = JSONArray.fromObject(ztreeList);
		this.message = jo.toString();
		return "siteTree";
	}
	
	/**
	 * 获得JSON形式的部门树信息
	 * @return
	 * @throws Exception
	 */
	public String loadSiteTreeData() throws Exception {
		List<Site> allSites = this.siteService.findAll();
		Site siteRoot = this.siteService.findRootSite();
		ZTree ztree = new ZTree(String.valueOf(siteRoot.getId()), siteRoot.getName(), "", true);
		this.siteService.bulidSiteTree(allSites, ztree);
		ArrayList<ZTree> ztreeList = new ArrayList<ZTree>();
		ztreeList.add(ztree);
		JSONArray jo = JSONArray.fromObject(ztreeList);
		this.writeToResponse(jo.toString());
		return null;
	}
	
	/**
	 * 加载行政区划的树形结构数据
	 * @return 返回JSON结构的数据
	 * @throws Exception
	 */
	public String loadDistrictTreeData() throws Exception {
		List<District> allDistricts = this.siteService.findAllDistricts();
		District root = this.siteService.findRootDistrict();
		ZTree ztree = new ZTree(root.getCode(), root.getName(), "", true);
		this.siteService.bulidDistrictTree(allDistricts, ztree);
		ArrayList<ZTree> ztreeList = new ArrayList<ZTree>();
		ztreeList.add(ztree);
		JSONArray jo = JSONArray.fromObject(ztreeList);
		this.writeToResponse(jo.toString());
		return "siteTree";
	}
	
	/**
	 * 通过ajax验证帐号是否可用
	 */
	public String checkCode()  throws Exception {
		int editId=Integer.parseInt(getRequest().getParameter("editId"));
		String code=getRequest().getParameter("code");

		Site tmp = this.siteService.findByCode(code);
		if(editId>0){
			tmp = this.siteService.findByCodeEdit(code,editId);
		}
		String msg = "ok";
		if(tmp != null) {
			msg = "err";
		}
		this.writeToResponse(msg);
		return null;
	}
	public String searchSiteForQucik(){
		List<Site> siteList = this.siteService.searchSiteForQucik(queryCode);
		this.getContext().put("siteList", siteList);
		return "siteList";
	}

	public String searchSiteForQucikZL(){
		List<Site> siteList = this.siteService.searchSiteForQucikZL(queryCode);
		this.getContext().put("siteList", siteList);
		return "siteList";
	}
	public String searchSiteForSite(){
		Site site=getLoginUserFromSession().getSite();
		List<Site> siteList = this.siteService.searchSiteForQucik(queryCode,site);
		this.getContext().put("siteList", siteList);
		return "siteList";
	}
	/**
	 * 添加及修改请求方法
	 * @return
	 * @throws Exception
	 */
	public String addChildReq() throws Exception {
		this.actionType = "addChild";
		return "addSite";
	}
	
	public String editReq() throws Exception {
		this.actionType = "edit";
		return "addSite";
	}
	
	/**
	 * 用户信息保存方法
	 * @return
	 * @throws Exception
	 */
	/*public String edit()  throws Exception {
		this.siteService.update(model);
		return this.buildSiteTree();
	}
	*/
	/**
	 * 添加下级部门
	 * @return
	 * @throws Exception
	 */
	public Result addChild()  throws Exception {
		Site parent = this.siteService.findById(parentId);
		if(parent != null) {
			model.setParent(parent);
			this.siteService.save(model);
		}
		return new ServletRedirectResult("system/site_buildsiteTree.action");
	}
	
	/**
	 * 查看用户详细信息
	 * @return
	 * @throws Exception
	 */
	/*public String show()  throws Exception {
		int childNodesCount = this.siteService.getChildNodesCount(id);
		this.getContext().put("childNodesCount", childNodesCount);
		return "viewSite";
	}
	
	*//**
	 * 删除用户信息
	 * @return
	 * @throws Exception
	 *//*
	public Result delete()  throws Exception {
		try {
			this.siteService.delete(model);
		} catch(Exception e) {
			this.message = "对不起，当前记录已经被使用，不能被删除！";
			return new ServletDispatcherResult("/WEB-INF/pages/message.jsp");
		}
		return new ServletRedirectResult("system/site_buildSiteTree.action");
	}*/
	
	public String upload() throws Exception{
		message = "";
		message += "=====================================================</br>";
		int suCount=0;
		int failCount=0;
		if(this.attachFile != null && this.attachFile.exists()){
			List<List<String>> list = ExcelImport.excelToList(this.attachFile);
			for(List<String> row : list) {
				if(		"类型".equals(row.get(0).trim()) 			&& "部门名称".equals(row.get(1).trim()) && "部门编码".equals(row.get(2).trim()) 
						&& "部门联系人".equals(row.get(3).trim()) 	&& "部门联系电话".equals(row.get(4).trim())
						&& "用户姓名".equals(row.get(5).trim()) 	&& "用户类型".equals(row.get(6).trim())
						&& "职务".equals(row.get(7).trim()) 		&& "电话".equals(row.get(8).trim())
						&& "Email".equals(row.get(9).trim()) 		&& "用户名".equals(row.get(10).trim())
						&& "密码".equals(row.get(11).trim()) 		&& "状态".equals(row.get(12).trim()) ){
					list.remove(row);
					break;
				}else{
					message += "<font color='red'>导入文件格式错误<font></br>";
					return "uploadSucc";
				}
			}
			Site parentSite = null ;
			String parentCode = this.getRequest().getParameter("parentCode");
			if(parentCode != null && !"".equals(parentCode)){
				parentSite = this.siteService.findByCode(parentCode);
			}else{
				message += "<font color='red'>系统错误</font></br>";
				return "uploadSucc";
			}
			for(List<String> row : list) {
				Site site = new Site();
				site.setName(row.get(1).trim());
				site.setCode(row.get(2).trim());
				site.setType(0);
				site.setLinkman(row.get(3).trim());
				site.setTel(row.get(4).trim());
				site.setParent(parentSite);
				if(parentSite==null){
					failCount++;
					message += "<font color='red'>系统错误!  部门:"+row.get(1)+",编码:"+row.get(2)+"导入失败</font></br>";;
					continue;
				}
				Site o = this.siteService.findByCode(row.get(2).trim());
				if(o!=null){
					message += "<font color='red'>部门:"+row.get(1)+",编码:"+row.get(2)+"已经存在，不能导入</font></br>";
					failCount++;
					continue;
				}
				this.siteService.save(site);
				suCount++;
				message += "<font color='green'>部门:"+row.get(1)+",编码:"+row.get(2)+"成功导入，恭喜恭喜！！！</font></br>";
			}
			message += "导入成功:<font color='red'>"+suCount+"</font>条,导入失败:<font color='red'>"+failCount+"</font>条</br>";
		}
		return "uploadSucc";
	}
	
	

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getActionType() {
		return actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	public File getAttachFile() {
		return attachFile;
	}

	public void setAttachFile(File attachFile) {
		this.attachFile = attachFile;
	}
	

	public String getQueryCode() {
		return queryCode;
	}

	public void setQueryCode(String queryCode) {
		this.queryCode = queryCode;
	}


}
