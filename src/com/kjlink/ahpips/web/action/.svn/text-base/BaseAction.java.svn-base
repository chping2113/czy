package com.kjlink.ahpips.web.action;

import java.io.*;
import java.util.*;

import javax.servlet.http.*;

import org.apache.commons.logging.*;
import org.apache.struts2.ServletActionContext;
import com.brady.common.page.PageInfo;
import com.kjlink.ahpips.entity.system.*;
import com.kjlink.ahpips.Constants;
import com.kjlink.ahpips.web.interceptor.SecurityAuthenticateInterceptor;
import com.opensymphony.xwork2.*;

public abstract class BaseAction<T> extends ActionSupport implements  ModelDriven<T>, Preparable{
	public static final int MAX_PAGE_SIZE = Constants.MAX_PAGE_SIZE; //分页显示的每页最大记录数
	protected Log log = LogFactory.getLog(this.getClass()); //统一的Logger实例
	private Integer pageNo = 1; //指明显示第几页的变量
	protected Integer id = 0;   //统一的ID,供子类方便使用
	protected String message;   //统一的消息输出属性，供子类方便使用
	protected PageInfo pageInfo;//统一的分页控制信息，供子类方便使用
	protected String pageUrl;   //可动态指定分页显示控件中的分页请求action的路径
	protected String pageParam; //用于给分页显示控件传递参数的属性，供子类方便使用
	protected String backURL;	//统一的用于指定页面返回路径，供子类方便使用
	protected String queryStr;
	
	protected String input;//验证信息
	protected String rand;
	
	protected String sId;
	
	public String getSId() {
		return sId;
	}

	public void setSId(String id) {
		sId = id;
	}

	public String getBackURL() {
		return backURL;
	}

	public void setBackURL(String backURL) {
		this.backURL = backURL;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPageUrl() {
		return pageUrl;
	}

	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
	}

	public PageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getPageNo() {
		return pageNo < 1 ? 1 : pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	
	public int getMaxPageSize() {
		return MAX_PAGE_SIZE;
	}
	
	public ActionContext getContext() {
		return ActionContext.getContext();
	}
	
	public HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}
	
	public HttpServletResponse getResponse() {
		return ServletActionContext.getResponse();
	}
	
	public void writeToResponse(String msg) throws Exception {
		HttpServletResponse resp = ServletActionContext.getResponse();
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.print(msg);
		out.flush();
	}
	
	public Map getSession() {
		return this.getContext().getSession();
	}
	
	public void putUserToSession(User user) {
		this.getSession().put("loginUser", user);
	}
	public void putConstructToSession(Construct construct){
		this.getSession().put("loginConstruct", construct);
	}
	/**
	 * 返回sesison中保存的User对象
	 * @return
	 */
	public User getLoginUserFromSession() {
		return (User)this.getSession().get("loginUser");
	}
	
	/**
	 * 返回session中保存的项目建设单位对象
	 * @return
	 */
	public Construct getLoginConstructFromSession(){
		return (Construct) this.getSession().get("loginConstruct");
	}
	
	/**
	 * 返回session中保存的组织机构对象
	 * @return
	 */
	public Site getSiteFromSession() {
		return (Site)this.getSession().get("session_site");
	}
	
	/**
	 * 返回登录的用户类型：-1-未登录，0-政府用户，1-企业用户，2-个人用户, 3-建设单位
	 * @return
	 */
	public int getLoginAccountType() {
		User u = this.getLoginUserFromSession();
		Construct con=this.getLoginConstructFromSession();
		
		if(u == null)
			return -1;
		
		return u != null ? 0 : null;
	}

	public String getPageParam() {
		return pageParam;
	}

	public void setPageParam(String pageParam) {
		this.pageParam = pageParam;
	}

	public Log getLog() {
		return log;
	}
	
	/**
	 * 根据提供的权限ID判断当前登录的用户是否具有可操作的权限
	 * menuIds: 使用逗号分隔的菜单ID
	 */
	public boolean canAccessURL(String url) {
		List<Permission> permissionList = (List<Permission>)this.getSession().get("permissionList");
		return SecurityAuthenticateInterceptor.accessAuthenticate(permissionList,	url);
	}

	public String getQueryStr() {
		return queryStr;
	}

	public void setQueryStr(String queryStr) {
		this.queryStr = queryStr;
	}
	
	/**
	 * 取客户端的IP
	 */
	public String getClientIP() {
		return ServletActionContext.getRequest().getRemoteAddr();
	}
	
	/**
	 * 返回Web应用程序所在web server中的绝对文件路径,以"/"结束
	 * @return
	 */
	public String getApplicationContextRealPath() {
		String path = ServletActionContext.getRequest().getSession().getServletContext().getRealPath("/");
		if(! path.endsWith(java.io.File.separator)) {
			path += java.io.File.separator;
		}
		return path;
	}
}
