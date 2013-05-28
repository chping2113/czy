package com.kjlink.ahpips.dao.project;

import java.util.List;

import com.brady.common.dao.CommonDAO;
import com.brady.common.page.PageInfo;
import com.kjlink.ahpips.entity.project.KeyProjectKind;
import com.kjlink.ahpips.entity.system.Site;

public interface ProjectAegisDAO extends CommonDAO<KeyProjectKind> {
	public PageInfo quickSearch(String str, int pageNo, int pageSize,Site site);
	
	public List<KeyProjectKind> findKeyAll(Site site);
	
	public List<KeyProjectKind> findKeyProjectKindForPublic(int count);
}
