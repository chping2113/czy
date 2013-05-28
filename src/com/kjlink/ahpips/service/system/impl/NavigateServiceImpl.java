package com.kjlink.ahpips.service.system.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.brady.common.page.PageInfo;
import com.kjlink.ahpips.dao.system.NavigateDAO;
import com.kjlink.ahpips.entity.system.Navigate;
import com.kjlink.ahpips.service.impl.BaseServiceImpl;
import com.kjlink.ahpips.service.system.NavigateService;
@Service("navigateService")
public class NavigateServiceImpl extends BaseServiceImpl<Navigate> implements NavigateService {
	private NavigateDAO navigateDAO;
	
	public NavigateDAO getNavigateDAO() {
		return navigateDAO;
	}


	public void setNavigateDAO(NavigateDAO navigateDAO) {
		super.setCommonDAO(navigateDAO);
		this.navigateDAO = navigateDAO;
	}

	public PageInfo findPageAllByParent(int pageNo, int pageSize,int id,int type,int parentId){
		return this.navigateDAO.findPageAllByParent(pageNo, pageSize, id, type,parentId);
	}

	public PageInfo findPageAll(int pageNo, int pageSize,int id,int type) {
		return this.navigateDAO.findPageAll(pageNo, pageSize,id, type);
	}

	public PageInfo quickSearchByParent(String str, int pageNo, int pageSize,int id,int parentId){
		return this.navigateDAO.quickSearchByParent(str, pageNo, pageSize, id,parentId);
	}
	
	public PageInfo quickSearch(String str, int pageNo, int pageSize,int id) {
		return this.navigateDAO.quickSearch(str, pageNo, pageSize,id);
	}


	public List<Navigate> findByType(int type,int siteId) {
		
		return this.navigateDAO.findByType(type,siteId);
	}
	public List<Navigate> findByTypeParent(int type,int siteId,int parentId){
		return this.navigateDAO.findByTypeParent(type,siteId,parentId);
	}

}
