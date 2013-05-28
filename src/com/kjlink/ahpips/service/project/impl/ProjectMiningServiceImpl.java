package com.kjlink.ahpips.service.project.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.brady.common.page.PageInfo;
import com.kjlink.ahpips.dao.project.ProjectMiningDAO;
import com.kjlink.ahpips.entity.project.ProjectMining;
import com.kjlink.ahpips.entity.system.Site;
import com.kjlink.ahpips.entity.system.User;
import com.kjlink.ahpips.service.impl.BaseServiceImpl;
import com.kjlink.ahpips.service.project.ProjectMiningService;

@Service("projectMiningService")
public class ProjectMiningServiceImpl extends BaseServiceImpl<ProjectMining> implements ProjectMiningService{

	private ProjectMiningDAO projectMiningDAO ;
	

	public List<ProjectMining> findProjectMiningForPulbic(int count,Site site){
		return this.projectMiningDAO.findProjectMiningForPulbic(count,site);
	}
	
	public PageInfo findPageAll(int pageNo, int pageSize){
		return this.projectMiningDAO.findPageAll(pageNo, pageSize);
	}
	public PageInfo findPublicAllByName(int pageNo, int pageSize,Site site,String queryCode){
		return this.projectMiningDAO.findPublicAllByName(pageNo, pageSize, site, queryCode);
	}
	public PageInfo findPublicAll(int pageNo, int pageSize,Site site){
		return this.projectMiningDAO.findPublicAll(pageNo, pageSize, site);
	}

	public ProjectMiningDAO getProjectMiningDAO() {
		return projectMiningDAO;
	}

	public void setProjectMiningDAO(ProjectMiningDAO projectMiningDAO) {
		super.setCommonDAO(projectMiningDAO);
		this.projectMiningDAO = projectMiningDAO;
	}

	public PageInfo quickSearch(String str, int pageNo, int pageSize) {
		return this.projectMiningDAO.quickSearch(str, pageNo, pageSize);
	}

	public PageInfo findProjectMiningBySiteId(String str, String sitecode,
			int pageNo, int pageSize) {
		return this.projectMiningDAO.findProjectMiningBySiteId(str,sitecode, pageNo, pageSize);
	}

	public PageInfo findByToDo(String str,User user, int pageNo, int pageSize){
		return this.projectMiningDAO.findByToDo(str,user,pageNo,pageSize);
	}

	public int findCount(User user){
		return this.projectMiningDAO.findCount(user);
	}

	public int findDataCount(Site site){
		return this.projectMiningDAO.findDataCount(site);
	}

	public int findDataCount(Site site,Date startTime,Date endTime){
		return this.projectMiningDAO.findDataCount(site,startTime,endTime);
	}


	public int findByUser(User user){
		return this.projectMiningDAO.findByUser(user);
	}

	public int findByUser(User user,Date startTime,Date endTime){
		return this.projectMiningDAO.findByUser(user,startTime,endTime);
	}
}
