package com.kjlink.ahpips.service.project.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.brady.common.page.PageInfo;
import com.kjlink.ahpips.dao.project.ProjectAegisDAO;
import com.kjlink.ahpips.entity.project.KeyProjectKind;
import com.kjlink.ahpips.entity.system.Site;
import com.kjlink.ahpips.service.impl.BaseServiceImpl;
import com.kjlink.ahpips.service.project.ProjectAegisService;

@Service("projectAegisService")
public class ProjectAegisServiceImpl extends BaseServiceImpl<KeyProjectKind> implements ProjectAegisService {
	private ProjectAegisDAO projectAegisDAO;

	public ProjectAegisDAO getPeojectAegisDAO() {
		return projectAegisDAO;
	}

	public void setProjectAegisDAO(ProjectAegisDAO projectAegisDAO) {
		super.setCommonDAO(projectAegisDAO);  //父类的方法一定要被调用,否则会出错
		this.projectAegisDAO = projectAegisDAO;
	}
	
	public PageInfo findPageAll(int pageNo, int pageSize) {
		return this.projectAegisDAO.findPageAll(pageNo, pageSize);
	}
	
	public PageInfo quickSearch(String str, int pageNo, int pageSize,Site site) {
		return this.projectAegisDAO.quickSearch(str, pageNo, pageSize,site);
	}
	
	public List<KeyProjectKind> findKeyAll(Site site) {
		return this.projectAegisDAO.findKeyAll(site);
	}
	
	public List<KeyProjectKind> findKeyProjectKindForPublic(int count){
		return this.projectAegisDAO.findKeyProjectKindForPublic(count);
	}
}
