package com.kjlink.ahpips.service.info;

import java.util.List;

import com.brady.common.page.PageInfo;
import com.brady.common.service.CommonService;
import com.kjlink.ahpips.entity.info.*;

public interface NewsService extends CommonService<News> {
	public PageInfo findPageAll(int pageNo, int pageSize);
	
	/**
	 * 根据栏目ID查找新闻
	 */
	public PageInfo findPageByNewsCatelogId(Integer catelogId, int pageNo, int pageSize);
	
	public PageInfo quickSearch(Integer catelogId, String str, int pageNo, int pageSize);
	
	/**
	 * 根据新闻栏目显示新闻列表
	 */
	
	/**
	 * 返回最近发布的取指定数量的非图片新闻
	 */
	public List<News> findNonImageNews(int count);
	
	/**
	 * 返回最近发布的取指定数量的图片新闻
	 */
	public List<News> findImageNews(int count);
}
