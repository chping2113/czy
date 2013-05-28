package com.kjlink.ahpips.service.project;

import java.util.List;

import com.brady.common.page.PageInfo;
import com.kjlink.ahpips.entity.project.Project;
import com.kjlink.ahpips.service.BaseService;

public interface ProjectService extends BaseService<Project>{
	public PageInfo findPageAll(int pageNo, int pageSize,String queryStr);
	
	public PageInfo findApprovePageAll(int pageNo, int pageSize,String queryStr);
	
	public List<Project> findByName(String str);
	
	public List<Project> findByCode(String code);
	
	public Project findProjectByName(String name);
}
