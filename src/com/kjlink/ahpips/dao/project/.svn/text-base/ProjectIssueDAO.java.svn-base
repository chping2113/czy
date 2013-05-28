package com.kjlink.ahpips.dao.project;

import java.util.List;

import com.brady.common.dao.CommonDAO;
import com.brady.common.page.PageInfo;
import com.kjlink.ahpips.entity.project.KeyProject;
import com.kjlink.ahpips.entity.project.KeyProjectKind;
import com.kjlink.ahpips.entity.project.ProjectConstruct;

public interface ProjectIssueDAO extends CommonDAO<KeyProject> {
	public PageInfo findPageAll(int pageNo, int pageSize);
	
	public PageInfo quickSearch(int keyid, String str, int pageNo, int pageSize);
	
	public List<KeyProject> findProjectIdByKindId(KeyProjectKind keyProjectKind);
	
	public PageInfo findPageAllByKeyId(int pageNo, int pageSize, int keyid);
	
	public List<KeyProject> isValidProjectKeyId(int keyId, String proId);

	public List<KeyProject> findProjectConstruct(ProjectConstruct projectConstruct);
}
