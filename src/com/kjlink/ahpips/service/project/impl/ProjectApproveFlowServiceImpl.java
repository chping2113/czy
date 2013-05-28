package com.kjlink.ahpips.service.project.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kjlink.ahpips.dao.project.ProjectApproveFlowDAO;
import com.kjlink.ahpips.entity.project.ProjectApprove;
import com.kjlink.ahpips.entity.project.ProjectApproveFlow;
import com.kjlink.ahpips.entity.system.Site;
import com.kjlink.ahpips.service.impl.BaseServiceImpl;
import com.kjlink.ahpips.service.project.ProjectApproveFlowService;

@Service("projectApproveFlowService")
public class ProjectApproveFlowServiceImpl extends BaseServiceImpl<ProjectApproveFlow> implements ProjectApproveFlowService{
	private ProjectApproveFlowDAO projectApproveFlowDAO ;

	public ProjectApproveFlowDAO getProjectApproveFlowDAO() {
		
		return projectApproveFlowDAO;
	}

	public void setProjectApproveFlowDAO(ProjectApproveFlowDAO projectApproveFlowDAO) {
		super.setCommonDAO(projectApproveFlowDAO);
		this.projectApproveFlowDAO = projectApproveFlowDAO;
	}

	public List<ProjectApproveFlow> findByProjectApprove(ProjectApprove projectApprove){
		return this.projectApproveFlowDAO.findByProjectApprove(projectApprove);
	}

	public List<ProjectApproveFlow> findByProjectApprove(ProjectApprove projectApprove,Site site){
		return this.projectApproveFlowDAO.findByProjectApprove(projectApprove,site);
	}

	public int findDataCount(Site site){
		return this.projectApproveFlowDAO.findDataCount(site);
	}
}
