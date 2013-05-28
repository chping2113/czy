package com.kjlink.ahpips.service.project.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.brady.common.page.PageInfo;
import com.kjlink.ahpips.dao.project.ProjectLandDAO;
import com.kjlink.ahpips.entity.project.Project;
import com.kjlink.ahpips.entity.project.ProjectLand;
import com.kjlink.ahpips.entity.system.Site;
import com.kjlink.ahpips.entity.system.User;
import com.kjlink.ahpips.service.impl.BaseServiceImpl;
import com.kjlink.ahpips.service.project.ProjectLandService;
import com.opensymphony.xwork2.inject.Scope.Strategy;

@Service("projectLandService")
public class ProjectLandServiceImpl extends BaseServiceImpl<ProjectLand> implements ProjectLandService{

	private ProjectLandDAO projectLandDAO ;
	
	public List<ProjectLand> findProjectLandByProject(Project project){
		return this.projectLandDAO.findProjectLandByProject(project);
	}
	
	public List<ProjectLand> findProjectLandForPulbic(int count,Site site){
		return this.projectLandDAO.findProjectLandForPulbic(count,site);
	}
	
	public PageInfo findPageAll(int pageNo, int pageSize){
		return this.projectLandDAO.findPageAll(pageNo, pageSize);
	}
	public PageInfo findPublicAllByName(int pageNo, int pageSize,Site site,String queryCode){
		return this.projectLandDAO.findPublicAllByName(pageNo, pageSize, site, queryCode);
	}
	public PageInfo findPublicAll(int pageNo, int pageSize,Site site){
		return this.projectLandDAO.findPublicAll(pageNo, pageSize, site);
	}

	public ProjectLandDAO getProjectLandDAO() {
		return projectLandDAO;
	}

	public void setProjectLandDAO(ProjectLandDAO projectLandDAO) {
		super.setCommonDAO(projectLandDAO);
		this.projectLandDAO = projectLandDAO;
	}

	public PageInfo quickSearch(String str, int pageNo, int pageSize) {
		return this.projectLandDAO.quickSearch(str, pageNo, pageSize);
	}

	public PageInfo findProjectLandBySiteId(String str, String sitecode,
			int pageNo, int pageSize) {
		return this.projectLandDAO.findProjectLandBySiteId(str,sitecode, pageNo, pageSize);
	}

	public PageInfo findByToDo(String str,User user, int pageNo, int pageSize){
		return this.projectLandDAO.findByToDo(str,user,pageNo,pageSize);
	}

	public int findCount(User user){
		return this.projectLandDAO.findCount(user);
	}
	public int findDataCount(Site site){
		return this.projectLandDAO.findDataCount(site);
	}
	public int findDataCount(Site site,Date startTime,Date endTime){
		return this.projectLandDAO.findDataCount(site,startTime,endTime);
	}

	public int findByUser(User user){
		return this.projectLandDAO.findByUser(user);
	}

	public int findByUser(User user,Date startTime,Date endTime){
		return this.projectLandDAO.findByUser(user,startTime,endTime);
	}
}
