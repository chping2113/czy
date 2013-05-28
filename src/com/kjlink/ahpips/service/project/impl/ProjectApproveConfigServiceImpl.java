package com.kjlink.ahpips.service.project.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kjlink.ahpips.dao.project.ProjectApproveConfigDAO;
import com.kjlink.ahpips.entity.project.ProjectApproveConfig;
import com.kjlink.ahpips.entity.system.Site;
import com.kjlink.ahpips.service.impl.BaseServiceImpl;
import com.kjlink.ahpips.service.project.ProjectApproveConfigService;
@Service("projectApproveConfigService")
public class ProjectApproveConfigServiceImpl  extends BaseServiceImpl<ProjectApproveConfig> implements ProjectApproveConfigService{
	private ProjectApproveConfigDAO projectApproveConfigDAO ;

	public ProjectApproveConfigDAO getProjectApproveConfigDAO() {
		return projectApproveConfigDAO;
	}

	public void setProjectApproveConfigDAO(
			ProjectApproveConfigDAO projectApproveConfigDAO) {
		super.setCommonDAO(projectApproveConfigDAO);
		this.projectApproveConfigDAO = projectApproveConfigDAO;
	}
	public List<ProjectApproveConfig> findByProjectApproveConfigSite(Site site){
		return  this.projectApproveConfigDAO.findByProjectApproveConfigSite(site);
	}
}
