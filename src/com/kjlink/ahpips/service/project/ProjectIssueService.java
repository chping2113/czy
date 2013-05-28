package com.kjlink.ahpips.service.project;

import java.util.List;
import java.util.Map;

import com.brady.common.page.PageInfo;
import com.brady.common.service.CommonService;
import com.kjlink.ahpips.entity.project.KeyProject;
import com.kjlink.ahpips.entity.project.KeyProjectKind;
import com.kjlink.ahpips.entity.project.ProjectConstruct;
import com.kjlink.ahpips.entity.system.Role;

public interface ProjectIssueService extends CommonService<KeyProject> {
	public PageInfo findPageAll(int pageNo, int pageSize);
	
	public PageInfo quickSearch(int keyid, String str, int pageNo, int pageSize);
	
	public void saveKeyProject(KeyProject keyproject, String[] projectIds);
	
	public Map<Integer, String> findProjectIdMap(KeyProjectKind keyProjectKind);
	
	public PageInfo findPageAllByKeyId(int pageNo, int pageSize, int keyid);
	
	public List<KeyProject> findProjectIdByKindId(KeyProjectKind keyProjectKind);
	
	public List<KeyProject> isValidProjectKeyId(int keyId, String proId);

	public List<KeyProject> findProjectConstruct(ProjectConstruct projectConstruct);
}	
