package com.kjlink.ahpips.service.project;

import java.util.List;

import com.kjlink.ahpips.entity.project.ProjectApproveConfig;
import com.kjlink.ahpips.entity.system.Site;
import com.kjlink.ahpips.service.BaseService;

public interface ProjectApproveConfigService extends BaseService<ProjectApproveConfig>{
	public List<ProjectApproveConfig> findByProjectApproveConfigSite(Site site);

}
