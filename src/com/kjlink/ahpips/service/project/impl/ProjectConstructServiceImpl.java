package com.kjlink.ahpips.service.project.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.brady.common.page.PageInfo;
import com.kjlink.ahpips.dao.project.ProjectConstructDAO;
import com.kjlink.ahpips.entity.project.Project;
import com.kjlink.ahpips.entity.project.ProjectApprove;
import com.kjlink.ahpips.entity.project.ProjectConstruct;
import com.kjlink.ahpips.entity.system.Construct;
import com.kjlink.ahpips.entity.system.Site;
import com.kjlink.ahpips.entity.system.User;
import com.kjlink.ahpips.service.impl.BaseServiceImpl;
import com.kjlink.ahpips.service.project.ProjectConstructService;

@Service("projectConstructService")
public class ProjectConstructServiceImpl extends BaseServiceImpl<ProjectConstruct> implements ProjectConstructService{

	private ProjectConstructDAO projectConstructDAO ;
	
	public List<ProjectConstruct> findProjectConstructByProject(Project project){
		return this.projectConstructDAO.findProjectConstructByProject(project);
	}
	
	public List<ProjectConstruct> findProjectConstructForPulbic(int count,Site site){
		return this.projectConstructDAO.findProjectConstructForPulbic(count,site);
	}

	public ProjectConstructDAO getProjectConstructDAO() {
		return projectConstructDAO;
	}

	public PageInfo findPublicAllByName(int pageNo, int pageSize,Site site,String queryCode){
		return this.projectConstructDAO.findPublicAllByName(pageNo,pageSize,site,queryCode);
	}
	public PageInfo findPageAll(int pageNo, int pageSize) {
		return this.projectConstructDAO.findPageAll(pageNo, pageSize);
	}
	
	public PageInfo findPublicAll(int pageNo, int pageSize,Site site){
		return this.projectConstructDAO.findPublicAll(pageNo, pageSize, site);
	}

	public void setProjectConstructDAO(ProjectConstructDAO projectConstructDAO) {
		super.setCommonDAO(projectConstructDAO);
		this.projectConstructDAO = projectConstructDAO;
	}

	public PageInfo quickSearch(String str, int pageNo, int pageSize) {
		return this.projectConstructDAO.quickSearch(str, pageNo, pageSize);
	}

	public PageInfo findProjectConstructBySiteId(String str, String sitecode,
			int pageNo, int pageSize) {
		return this.projectConstructDAO.findProjectConstructBySiteId(str,sitecode, pageNo, pageSize);
	}

	public List<ProjectApprove> findProjectByName(String queryCode){
		return this.projectConstructDAO.findProjectByName(queryCode);
	}
	public List<ProjectApprove> findProjectByNameAndSitecode(String queryCode,String sitecode){
		return this.projectConstructDAO.findProjectByNameAndSitecode(queryCode,sitecode);
	}

	public PageInfo findProjectConstructByConstruct(String str,Construct construct, int pageNo, int pageSize){
		return this.projectConstructDAO.findProjectConstructByConstruct(str,construct,pageNo,pageSize);
	}
	public PageInfo findByToDo(String str,User user, int pageNo, int pageSize){
		return this.projectConstructDAO.findByToDo(str,user,pageNo,pageSize);
	}
	public int findCount(User user){
		return this.projectConstructDAO.findCount(user);
	}
	public int findDataCount(Site site){
		return this.projectConstructDAO.findDataCount(site);
	}

	public int findDataCount(Site site,Date startTime,Date endTime){
		return this.projectConstructDAO.findDataCount(site,startTime,endTime);
	}

	public int findByUser(User user){
		return this.projectConstructDAO.findByUser(user);
	}
	public int findByUser(User user,Date startTime,Date endTime){
		return this.projectConstructDAO.findByUser(user,startTime,endTime);
	}
	
	
}
