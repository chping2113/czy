package com.kjlink.ahpips.service.project;

import java.util.List;

import com.brady.common.page.PageInfo;
import com.brady.common.service.CommonService;
import com.kjlink.ahpips.entity.project.KeyProjectKind;
import com.kjlink.ahpips.entity.system.Site;
import com.kjlink.ahpips.entity.system.Site;

public interface ProjectAegisService extends CommonService<KeyProjectKind> {
	public PageInfo findPageAll(int pageNo, int pageSize);
	
	public PageInfo quickSearch(String str, int pageNo, int pageSize,Site site);
	
	public List<KeyProjectKind> findKeyAll(Site site);
	
	public List<KeyProjectKind> findKeyProjectKindForPublic(int count);
}
