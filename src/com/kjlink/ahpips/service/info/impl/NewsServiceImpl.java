package com.kjlink.ahpips.service.info.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Service;

import com.brady.common.page.PageInfo;
import com.kjlink.ahpips.dao.info.*;
import com.kjlink.ahpips.dao.system.*;
import com.kjlink.ahpips.entity.info.*;
import com.kjlink.ahpips.entity.system.*;
import com.kjlink.ahpips.service.impl.BaseServiceImpl;
import com.kjlink.ahpips.service.info.*;
import com.kjlink.ahpips.service.system.*;

@Service("newsService")
public class NewsServiceImpl extends BaseServiceImpl<News> implements NewsService {
	private NewsDAO newsDAO;

	public NewsDAO getNewsDAO() {
		return newsDAO;
	}

	public void setNewsDAO(NewsDAO newsDAO) {
		super.setCommonDAO(newsDAO);  //父类的方法一定要被调用,否则会出错
		this.newsDAO = newsDAO;
	}
	
	public PageInfo findPageAll(int pageNo, int pageSize) {
		return this.newsDAO.findPageAll(pageNo, pageSize);
	}
	
	public PageInfo quickSearch(Integer catelogId, String str, int pageNo, int pageSize) {
		return this.newsDAO.quickSearch(catelogId, str, pageNo, pageSize);
	}
	
	/**
	 * 根据栏目ID查找新闻
	 */
	public PageInfo findPageByNewsCatelogId(Integer catelogId, int pageNo, int pageSize) {
		return this.newsDAO.findPageByNewsCatelogId(catelogId, pageNo, pageSize);
	}
	
	/**
	 * 返回最近发布的取指定数量的非图片新闻
	 */
	public List<News> findNonImageNews(int count) {
		return this.newsDAO.findNonImageNews(count);
	}
	
	/**
	 * 返回最近发布的取指定数量的图片新闻
	 */
	public List<News> findImageNews(int count) {
		return this.newsDAO.findImageNews(count);
	}
}
