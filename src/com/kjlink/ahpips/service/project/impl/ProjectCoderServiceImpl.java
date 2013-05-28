package com.kjlink.ahpips.service.project.impl;

import org.springframework.stereotype.Service;

import com.brady.common.page.PageInfo;
import com.kjlink.ahpips.dao.project.ProjectCoderDAO;
import com.kjlink.ahpips.entity.project.ProjectCoder;
import com.kjlink.ahpips.service.impl.BaseServiceImpl;
import com.kjlink.ahpips.service.project.ProjectCoderService;
@Service("projectCoderService")
public class ProjectCoderServiceImpl extends BaseServiceImpl<ProjectCoder> implements ProjectCoderService{

	private ProjectCoderDAO projectCoderDAO ;

	public ProjectCoderDAO getProjectCoderDAO() {
		return projectCoderDAO;
	}

	public void setProjectCoderDAO(ProjectCoderDAO projectCoderDAO) {
		super.setCommonDAO(projectCoderDAO);
		this.projectCoderDAO = projectCoderDAO;
	}
	public PageInfo quickSearch(String str, int pageNo, int pageSize){
		return this.projectCoderDAO.quickSearch(str,pageNo,pageSize);
	}
	public boolean checkProjectName(String projectName,int id){
		return this.projectCoderDAO.checkProjectName(projectName,id);
	}
}
