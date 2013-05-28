package com.kjlink.ahpips.web.interceptor;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.kjlink.ahpips.Constants;
import com.kjlink.ahpips.entity.system.*;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class SecurityAuthenticateInterceptor extends MethodFilterInterceptor {

	protected String doIntercept(ActionInvocation actionInv) throws Exception {
		Map session = ActionContext.getContext().getSession();
		User user = (User)session.get("loginUser");
		Construct construct=(Construct) session.get("loginConstruct");
		
		String requestURI = ""; //当前action所对应的URL
		HttpServletRequest request = ServletActionContext.getRequest();
		requestURI = request.getRequestURI();
		
		//检查政府用户权限,先判断是否登录
		if(user == null) {
			//在转向login页面之前先把用户的请求url保存起来
			String fullURL = requestURI;
			String queryString = request.getQueryString();
			queryString = queryString == null ? "" : "?" + queryString;
			
			fullURL += fullURL;
			//之前的"/"被置换成File.separator,以适应不同操作系统下的分隔符不同
			String contextPath = request.getContextPath() + File.separator;
			int pos = fullURL.indexOf(contextPath);
			if(pos >= 0) {
				fullURL = fullURL.substring(contextPath.length());
			}
			session.put("prevRequestURI", fullURL);
			actionInv.getInvocationContext().put("failType", "no_login");
			return "no_login";
		}
		
		
		//判断是否有访问权限
		List<Permission> permissionList = (List<Permission>)session.get("permissionList");
		if(! this.accessAuthenticate(permissionList, requestURI)) {
			session.put("prevrequestURI", requestURI);
			actionInv.getInvocationContext().put("failType", "no_access");
			return "no_login";
		}
		return actionInv.invoke();
	}

	/**
	 * 根据角色与资源映射来对要访问的URL进行权限认证
	 * @param permissionList 角色资源列表
	 * @param url 需要访问的URL
	 * @return 返回true表示有权限访问指定的url
	 */
	public static boolean accessAuthenticate(List<Permission> permissionList, String url) {
			for(Permission res : permissionList) {
				String tmpUrl = res.getUrl();
				if(tmpUrl != null && tmpUrl.trim().length() > 0) {
					String[] aryUrl = tmpUrl.split(",");
					for(String tmp : aryUrl) {
						if(url.contains(tmp)) {
							return true;
						}
					}
				}
			}
		return false;
	}
	
}
