package com.kjlink.ahpips.service.project.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.brady.common.page.PageInfo;
import com.kjlink.ahpips.dao.project.ProjectApproveDetailDAO;
import com.kjlink.ahpips.dao.project.ProjectApproveFlowDAO;
import com.kjlink.ahpips.entity.project.ProjectApprove;
import com.kjlink.ahpips.entity.project.ProjectApproveDetail;
import com.kjlink.ahpips.entity.system.Site;
import com.kjlink.ahpips.entity.system.User;
import com.kjlink.ahpips.service.impl.BaseServiceImpl;
import com.kjlink.ahpips.service.project.ProjectApproveDetailService;

@Service("projectApproveDetailService")
public class ProjectApproveDetailServiceImpl extends BaseServiceImpl<ProjectApproveDetail> implements ProjectApproveDetailService{
	private ProjectApproveDetailDAO projectApproveDetailDAO ;

	public ProjectApproveDetailDAO getProjectApproveDetailDAO() {
		return projectApproveDetailDAO;
	}

	public void setProjectApproveDetailDAO(
			ProjectApproveDetailDAO projectApproveDetailDAO) {
		super.setCommonDAO(projectApproveDetailDAO);
		this.projectApproveDetailDAO = projectApproveDetailDAO;
	}
	public List<ProjectApproveDetail> findByProjectApprove(ProjectApprove projectApprove){
		return this.projectApproveDetailDAO.findByProjectApprove(projectApprove);
	}
	public List<ProjectApproveDetail> findByProjectApprove(ProjectApprove projectApprove,Site site){
		return this.projectApproveDetailDAO.findByProjectApprove(projectApprove,site);
	}
	public List<ProjectApproveDetail> findProjectApproveDetailForPulbic(int count,Site site){
		return this.projectApproveDetailDAO.findProjectApproveDetailForPulbic(count,site);
	}
	public PageInfo findPublicAll(int pageNo, int pageSize,Site site){
		return this.projectApproveDetailDAO.findPublicAll(pageNo,pageSize,site);
	}
	public PageInfo findPublicAllByName(int pageNo, int pageSize,Site site,String queryCode){
		return this.projectApproveDetailDAO.findPublicAllByName(pageNo,pageSize,site,queryCode);
	}
	public int findDataCount(Site site){
		return this.projectApproveDetailDAO.findDataCount(site);
	}

	public int findDataCount(Site site,Date startTime,Date endTime){
		return this.projectApproveDetailDAO.findDataCount(site,startTime,endTime);
		
	}
	

	public int findByUser(User user){
		return this.projectApproveDetailDAO.findByUser(user);
	}
	public int findByUser(User user,Date startTime,Date endTime){
		return this.projectApproveDetailDAO.findByUser(user,startTime,endTime);
	}
}
