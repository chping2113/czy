package com.kjlink.ahpips.dao.info;

import java.util.List;

import com.brady.common.dao.CommonDAO;
import com.brady.common.page.PageInfo;
import com.kjlink.ahpips.entity.info.Scolumn;

public interface ScolumnDAO extends CommonDAO<Scolumn>{

	public List<Scolumn> findbyName(String name);

	public PageInfo findFirstLevelPageAll(int pageNo, int pageSize);
	
	public List<Scolumn> findScolumnByName(String name);
	public PageInfo findFirstLevelByName(String name, int pageNo, int pageSize);
	public PageInfo findSecondLevelByName(String parentId, String name, int pageNo, int pageSize);
	public List<Scolumn> findAllScolumn();

	public PageInfo findFirstLevelPageAll(Integer siteId, int pageNo, int pageSize);

	public PageInfo findSecondLevelPageAll(Integer parentId, int pageNo, int pageSize);


}
