package com.kjlink.ahpips.service.project.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.brady.common.page.PageInfo;
import com.kjlink.ahpips.dao.project.ProjectDAO;
import com.kjlink.ahpips.entity.project.Project;
import com.kjlink.ahpips.service.impl.BaseServiceImpl;
import com.kjlink.ahpips.service.project.ProjectService;

@Service("projectService")
public class ProjectServiceImpl extends BaseServiceImpl<Project> implements ProjectService{

	private ProjectDAO projectDAO ;
	
	public PageInfo findPageAll(int pageNo, int pageSize,String queryStr) {
		return this.projectDAO.findPageAll(pageNo, pageSize,queryStr);
	}
	
	public PageInfo findApprovePageAll(int pageNo, int pageSize,String queryStr){
		return this.projectDAO.findApprovePageAll(pageNo, pageSize, queryStr);
	}
	
	public Project findProjectByName(String name){
		return this.projectDAO.findUniqueResultByProperty("name", name);
	}

	public ProjectDAO getProjectDAO() {
		return projectDAO;
	}

	public void setProjectDAO(ProjectDAO projectDAO) {
		this.setCommonDAO(projectDAO);
		this.projectDAO = projectDAO;
	}
	
	public List<Project> findByName(String str){
		return this.projectDAO.findByName(str);
	}
	
	public List<Project> findByCode(String code){
		return this.projectDAO.findByCode(code);
	}
}
