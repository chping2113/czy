package com.kjlink.ahpips.service.project.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.brady.common.page.PageInfo;
import com.kjlink.ahpips.dao.project.ProjectAegisDAO;
import com.kjlink.ahpips.dao.project.ProjectApproveDAO;
import com.kjlink.ahpips.dao.project.ProjectConstructDAO;
import com.kjlink.ahpips.dao.project.ProjectDAO;
import com.kjlink.ahpips.dao.project.ProjectIssueDAO;
import com.kjlink.ahpips.entity.project.KeyProject;
import com.kjlink.ahpips.entity.project.KeyProjectKind;
import com.kjlink.ahpips.entity.project.Project;
import com.kjlink.ahpips.entity.project.ProjectApprove;
import com.kjlink.ahpips.entity.project.ProjectConstruct;
import com.kjlink.ahpips.entity.system.Permission;
import com.kjlink.ahpips.entity.system.Role;
import com.kjlink.ahpips.service.impl.BaseServiceImpl;
import com.kjlink.ahpips.service.project.ProjectIssueService;

@Service("projectIssueService")
public class ProjectIssueServiceImpl extends BaseServiceImpl<KeyProject> implements ProjectIssueService {
	private ProjectIssueDAO projectIssueDAO;
	private ProjectAegisDAO projectAegisDAO;
	private ProjectDAO projectDAO;
	private ProjectConstructDAO projectConstructDAO;



	public ProjectConstructDAO getProjectConstructDAO() {
		return projectConstructDAO;
	}

	public void setProjectConstructDAO(ProjectConstructDAO projectConstructDAO) {
		this.projectConstructDAO = projectConstructDAO;
	}

	public ProjectAegisDAO getProjectAegisDAO() {
		return projectAegisDAO;
	}

	public void setProjectAegisDAO(ProjectAegisDAO projectAegisDAO) {
		this.projectAegisDAO = projectAegisDAO;
	}

	public ProjectDAO getProjectDAO() {
		return projectDAO;
	}

	public void setProjectDAO(ProjectDAO projectDAO) {
		this.projectDAO = projectDAO;
	}

	public ProjectIssueDAO getPeojectIssueDAO() {
		return projectIssueDAO;
	}

	public void setProjectIssueDAO(ProjectIssueDAO projectIssueDAO) {
		super.setCommonDAO(projectIssueDAO);  //父类的方法一定要被调用,否则会出错
		this.projectIssueDAO = projectIssueDAO;
	}
	
	public PageInfo findPageAll(int pageNo, int pageSize) {
		return this.projectIssueDAO.findPageAll(pageNo, pageSize);
	}
	
	public PageInfo findPageAllByKeyId(int pageNo, int pageSize, int keyid) {
		return this.projectIssueDAO.findPageAllByKeyId(pageNo, pageSize, keyid);
	}
	
	public PageInfo quickSearch(int keyid, String str, int pageNo, int pageSize) {
		return this.projectIssueDAO.quickSearch(keyid, str, pageNo, pageSize);
	}
	
	public void saveKeyProject(KeyProject keyProject, String[] projectIds) {
		//keyPeoject.getProject().clear();
		KeyProjectKind kind = this.projectAegisDAO.findById(keyProject.getKeyProjectKind().getId());
		
		
		if(projectIds != null) {
			for(String projectId : projectIds) {
				
				if(projectId.trim().length() > 0) {
					ProjectConstruct projectConstruct = this.projectConstructDAO.findById(new Integer(projectId));
					
					KeyProject key = new KeyProject();
					
					key.setUser(keyProject.getUser());
					key.setCreateDate(keyProject.getCreateDate());
					key.setProjectConstruct(projectConstruct);
					key.setKeyProjectKind(kind);
					
					this.saveKeyProject(key);
				}
			}
		}
	}
	
	public void saveKeyProject(KeyProject keyProject) {
		this.projectIssueDAO.save(keyProject);
	}
	
	public void updateKeyProject(KeyProject keyProject) {
		this.projectIssueDAO.update(keyProject);
	}
	
	public void deleteKeyProject(KeyProject keyProject) {
		this.projectIssueDAO.delete(keyProject);
	}
	
	public Map<Integer, String> findProjectIdMap(KeyProjectKind keyProjectKind){
		Map<Integer, String> map = new HashMap<Integer, String>();
		List<KeyProject> list = this.projectIssueDAO.findProjectIdByKindId(keyProjectKind);
		
		if(list != null && list.size() > 0){
			for(KeyProject key : list){
				map.put(key.getProjectConstruct().getId(), "ok");
			}
		}
		//System.out.println(map);
		return map;
	}
	
	public List<KeyProject> findProjectIdByKindId(KeyProjectKind keyProjectKind){
		return this.projectIssueDAO.findProjectIdByKindId(keyProjectKind);
	}
	
	public List<KeyProject> isValidProjectKeyId(int keyId, String proId){
		return this.projectIssueDAO.isValidProjectKeyId(keyId, proId);
	}

	public List<KeyProject> findProjectConstruct(ProjectConstruct projectConstruct){
		return this.projectIssueDAO.findProjectConstruct(projectConstruct);
	}

}
