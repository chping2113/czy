package com.kjlink.ahpips.service.project.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.brady.common.page.PageInfo;
import com.kjlink.ahpips.dao.project.ProjectApproveDAO;
import com.kjlink.ahpips.entity.project.Project;
import com.kjlink.ahpips.entity.project.ProjectApprove;
import com.kjlink.ahpips.entity.project.ProjectApproveDetail;
import com.kjlink.ahpips.entity.project.ProjectApproveFlow;
import com.kjlink.ahpips.entity.system.Site;
import com.kjlink.ahpips.entity.system.User;
import com.kjlink.ahpips.service.impl.BaseServiceImpl;
import com.kjlink.ahpips.service.project.ProjectApproveDetailService;
import com.kjlink.ahpips.service.project.ProjectApproveFlowService;
import com.kjlink.ahpips.service.project.ProjectApproveService;

@Service("projectApproveService")
public class ProjectApproveServiceImpl extends BaseServiceImpl<ProjectApprove> implements ProjectApproveService{

	private ProjectApproveDAO projectApproveDAO ;

	private ProjectApproveFlow projectApproveFlow;
	private ProjectApproveDetail projectApproveDetail;
	private ProjectApproveFlowService projectApproveFlowService;
	private ProjectApproveDetailService projectApproveDetailService;
	public ProjectApproveFlow getProjectApproveFlow() {
		return projectApproveFlow;
	}

	public void setProjectApproveFlow(ProjectApproveFlow projectApproveFlow) {
		this.projectApproveFlow = projectApproveFlow;
	}

	public ProjectApproveDetail getProjectApproveDetail() {
		return projectApproveDetail;
	}

	public void setProjectApproveDetail(ProjectApproveDetail projectApproveDetail) {
		this.projectApproveDetail = projectApproveDetail;
	}

	public ProjectApproveFlowService getProjectApproveFlowService() {
		return projectApproveFlowService;
	}

	public void setProjectApproveFlowService(
			ProjectApproveFlowService projectApproveFlowService) {
		this.projectApproveFlowService = projectApproveFlowService;
	}

	public ProjectApproveDetailService getProjectApproveDetailService() {
		return projectApproveDetailService;
	}

	public void setProjectApproveDetailService(
			ProjectApproveDetailService projectApproveDetailService) {
		this.projectApproveDetailService = projectApproveDetailService;
	}

	public List<ProjectApprove> findProjectApproveByProject(Project project){
		return this.projectApproveDAO.findProjectApproveByProject(project);
	}
	
	public List<ProjectApprove> findProjectApproveForPulbic(int count,Site site){
		return this.projectApproveDAO.findProjectApproveForPulbic(count,site);
	}
	
	public PageInfo findPublicAll(int pageNo, int pageSize,Site site){
		return this.projectApproveDAO.findPublicAll(pageNo, pageSize, site);
	}
	public PageInfo findPublicAllByName(int pageNo, int pageSize,Site site,String queryCode){
		return this.projectApproveDAO.findPublicAllByName(pageNo, pageSize, site, queryCode);
	}
	public PageInfo findPageAll(int pageNo, int pageSize) {
		return this.projectApproveDAO.findPageAll(pageNo, pageSize);
	}

	public ProjectApproveDAO getProjectApproveDAO() {
		return projectApproveDAO;
	}

	public void setProjectApproveDAO(ProjectApproveDAO projectApproveDAO) {
		super.setCommonDAO(projectApproveDAO);
		this.projectApproveDAO = projectApproveDAO;
	}
	 
	public List<ProjectApprove> findProjectByName(String queryCode){
		return this.projectApproveDAO.findProjectByName(queryCode);
	}

	public PageInfo quickSearch(String str, int pageNo, int pageSize) {
		return this.projectApproveDAO.quickSearch(str, pageNo, pageSize);
	}

	public PageInfo findProjectApproveBySiteId(String str, String sitecode,
			int pageNo, int pageSize) {
		return this.projectApproveDAO.findProjectApproveBySiteId(str,sitecode, pageNo, pageSize);
	}

	public List<ProjectApprove> findProjectByNameAndSitecode(String queryCode,
			String sitecode) {
		return this.projectApproveDAO.findProjectByNameAndSitecode(queryCode,sitecode);
	}
	public PageInfo findByToDo(String str,User user, int pageNo, int pageSize){
		return this.projectApproveDAO.findByToDo(str,user,pageNo,pageSize);
	}
	public int findCount(User user){
		return this.projectApproveDAO.findCount(user);
	}

	public void deleteAll(ProjectApprove projectApprove){
		List<ProjectApproveFlow> projectApproveFlowList=projectApproveFlowService.findByProjectApprove(projectApprove);
		for(int i=0;i<projectApproveFlowList.size();i++){
			projectApproveFlow=projectApproveFlowList.get(i);
			projectApproveFlowService.delete(projectApproveFlow);
		}
		List<ProjectApproveDetail> projectApproveDetailList=projectApproveDetailService.findByProjectApprove(projectApprove);
		for(int i=0;i<projectApproveDetailList.size();i++){
			projectApproveDetail=projectApproveDetailList.get(i);
			projectApproveDetailService.delete(projectApproveDetail);
		}
		this.delete(projectApprove);
	}
	
	public PageInfo findInfoGrab(String str, String sitecode, String startTime,
			String endTime, int pageNo, int pageSize, Site site) {
		return this.projectApproveDAO.findInfoGrab(str, sitecode, startTime, endTime, pageNo, pageSize, site);
	}

	public PageInfo quickFindInfo(String str, String sitecode,
			String startTime, String endTime, int pageNo, int pageSize,
			Site site, String scolumnName) {
		return this.projectApproveDAO.quickFindInfo(str, sitecode, startTime, endTime, pageNo, pageSize, site, scolumnName);
	}
}
