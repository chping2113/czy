package com.kjlink.ahpips.service.info;

import java.util.List;

import com.brady.common.page.PageInfo;
import com.brady.common.service.CommonService;
import com.kjlink.ahpips.entity.info.Scolumn;

public interface ScolumnService extends CommonService<Scolumn>{
	
	public List<Scolumn> findByName(String name);

	public PageInfo findFirstLevelPageAll(int pageNo, int pageSize);
	
	public List<Scolumn> findScolumnByName(String name);
	public PageInfo findFirstLevelByName(String name, int pageNo, int pageSize);
	public PageInfo findSecondLevelByName(String parentId, String name, int pageNo, int pageSize);
	public List<Scolumn> findAllScolumn();
	public PageInfo findFirstLevelPageAll(Integer siteId, int pageNo, int pageSize);

	public PageInfo findSecondLevelPageAll(Integer parentId, int pageNo, int maxPageSize);

}
