package com.kjlink.ahpips.dao.project;

import java.util.Date;
import java.util.List;

import com.brady.common.dao.CommonDAO;
import com.brady.common.page.PageInfo;
import com.kjlink.ahpips.entity.project.Project;
import com.kjlink.ahpips.entity.project.ProjectApprove;
import com.kjlink.ahpips.entity.system.Site;
import com.kjlink.ahpips.entity.system.User;

public interface ProjectApproveDAO extends CommonDAO<ProjectApprove> {
	
	public List<ProjectApprove> findProjectApproveByProject(Project project);
	public List<ProjectApprove> findProjectApproveForPulbic(int count,Site site);
	public PageInfo findPageAll(int pageNo, int pageSize);
	public PageInfo findPublicAll(int pageNo, int pageSize,Site site);
	public List<ProjectApprove> findProjectByName(String queryCode);
	public PageInfo quickSearch(String str, int pageNo, int pageSize);
	public PageInfo findProjectApproveBySiteId(String str,String sitecode, int pageNo, int pageSize);
	public List<ProjectApprove> findProjectByNameAndSitecode(String queryCode,String sitecode);
	public PageInfo findPublicAllByName(int pageNo, int pageSize,Site site,String queryCode);
	public PageInfo findByToDo(String str,User user, int pageNo, int pageSize);
	public int findCount(User user);
	/*
	 * 抓取页面快速查询
	 */
	public PageInfo findInfoGrab(String str, String sitecode, String startTime, String endTime, int pageNo, int pageSize, Site site);
	/*
	 * 发布页面的快速查询
	 * */
	public PageInfo quickFindInfo(String str, String sitecode, String startTime, String endTime, int pageNo, int pageSize, Site site, String scolumnName);
}
