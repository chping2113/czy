package com.kjlink.ahpips.service.project;

import com.brady.common.page.PageInfo;
import com.kjlink.ahpips.entity.project.ProjectCoder;
import com.kjlink.ahpips.service.BaseService;

public interface ProjectCoderService extends BaseService<ProjectCoder>{
	public PageInfo quickSearch(String str, int pageNo, int pageSize);

	public boolean checkProjectName(String projectName,int id);

}
