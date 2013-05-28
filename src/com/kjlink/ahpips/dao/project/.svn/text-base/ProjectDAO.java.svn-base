package com.kjlink.ahpips.dao.project;

import java.util.List;

import com.brady.common.dao.CommonDAO;
import com.brady.common.page.PageInfo;
import com.kjlink.ahpips.entity.project.Project;

public interface ProjectDAO extends CommonDAO<Project> {

	public PageInfo findPageAll(int pageNo, int pageSize,String queryStr);
	
	public PageInfo findApprovePageAll(int pageNo, int pageSize,String queryStr);
	
	public List<Project> findByName(String str);
	
	public List<Project> findByCode(String code) ;
}
