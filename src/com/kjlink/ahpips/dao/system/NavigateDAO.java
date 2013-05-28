package com.kjlink.ahpips.dao.system;


import java.util.List;

import com.brady.common.dao.CommonDAO;
import com.brady.common.page.PageInfo;
import com.kjlink.ahpips.entity.system.Navigate;

public interface NavigateDAO extends CommonDAO<Navigate> {

	public PageInfo findPageAll(int pageNo, int pageSize,int id,int type);

	public PageInfo findPageAllByParent(int pageNo, int pageSize,int id,int type,int parentId);
	public PageInfo quickSearch(String str, int pageNo, int pageSize,int id);
	public List<Navigate> findByType(int type,int siteId);	
	public PageInfo quickSearchByParent(String str, int pageNo, int pageSize,int id,int parentId);

	public List<Navigate> findByTypeParent(int type,int siteId,int parentId);
	

}
