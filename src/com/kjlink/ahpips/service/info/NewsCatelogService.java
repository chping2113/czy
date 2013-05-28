package com.kjlink.ahpips.service.info;

import java.util.List;

import com.brady.common.page.PageInfo;
import com.brady.common.service.CommonService;
import com.kjlink.ahpips.entity.info.*;

public interface NewsCatelogService extends CommonService<NewsCatelog> {
	/**
	 * ��ʾȫ����Ŀ
	 */
	public PageInfo findPageAll(int pageNo, int pageSize) ;
	
	/**
	 * ��ʾȫ��һ����Ŀ
	 */
	public PageInfo findFirstLevelPageAll(int pageNo, int pageSize) ;
	
	/**
	 * ��ʾȫ��������Ŀ
	 */
	public PageInfo findSecondLevelPageAll(Integer parentId, int pageNo, int pageSize) ;
	
	public PageInfo quickSearch(String str, int pageNo, int pageSize);
	
	public List<NewsCatelog> findSecondCatelogsByParentId(Integer parentId);
}
