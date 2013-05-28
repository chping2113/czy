package com.kjlink.ahpips.service.project.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.brady.common.page.PageInfo;
import com.kjlink.ahpips.dao.project.ProjectAimDAO;
import com.kjlink.ahpips.dao.project.ProjectApproveDAO;
import com.kjlink.ahpips.entity.project.ProjectAim;
import com.kjlink.ahpips.entity.system.Site;
import com.kjlink.ahpips.entity.system.User;
import com.kjlink.ahpips.service.impl.BaseServiceImpl;
import com.kjlink.ahpips.service.project.ProjectAimService;

@Service("projectAimService")
public class ProjectAimServiceImpl  extends BaseServiceImpl<ProjectAim> implements ProjectAimService{

	private ProjectAimDAO projectAimDAO ;

	public PageInfo findProjectAimBySiteId(String str,String sitecode, int pageNo, int pageSize){
		return this.projectAimDAO.findProjectAimBySiteId(str,sitecode,pageNo,pageSize);
	}

	public List<ProjectAim> findProjectAimForPulbic(int count,Site site){
		return this.projectAimDAO.findProjectAimForPulbic(count,site);
	}

	public ProjectAimDAO getProjectAimDAO() {
		return projectAimDAO;
	}

	public void setProjectAimDAO(ProjectAimDAO projectAimDAO) {
		super.setCommonDAO(projectAimDAO);
		this.projectAimDAO = projectAimDAO;
	}

	public PageInfo findPublicAll(int pageNo, int pageSize,Site site){
		return this.projectAimDAO.findPublicAll(pageNo,pageSize,site);
	}

	public PageInfo findPublicAllByName(int pageNo, int pageSize,Site site,String queryCode){
		return this.projectAimDAO.findPublicAllByName(pageNo,pageSize,site,queryCode);
	}

	public int findDataCount(Site site){
		return this.projectAimDAO.findDataCount(site);
	}

	public int findDataCount(Site site,Date startTime,Date endTime){
		return this.projectAimDAO.findDataCount(site,startTime,endTime);
	}

	public int findByUser(User user){
		return this.projectAimDAO.findByUser(user);
	}

	public int findByUser(User user,Date startTime,Date endTime){
		return this.projectAimDAO.findByUser(user,startTime,endTime);
	}
}
