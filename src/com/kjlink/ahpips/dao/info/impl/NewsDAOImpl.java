/** 
  * @title:  
  * @description:   
  * @copyright: 凯捷技术有限公司 
  * @author: 
  * @version: 1.0
  * @created: 2010-09-20
*/

package com.kjlink.ahpips.dao.info.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.brady.common.page.PageInfo;
import com.kjlink.ahpips.dao.impl.BaseDAOImpl;
import com.kjlink.ahpips.dao.info.*;
import com.kjlink.ahpips.entity.info.*;


/**
 * 
 * 作者：brady.zh
 * 创建：2010-11-4
 */

@Component("newsDAO")
public class NewsDAOImpl extends BaseDAOImpl<News> implements NewsDAO {
	public NewsDAOImpl() {
		super(News.class);
	}

	public PageInfo findPageAll(int pageNo, int pageSize) {
		String hql = "from News u order by u.id desc";
		return this.findPageInfoByHql(pageNo, pageSize, hql);
	}
	
	public PageInfo quickSearch(Integer catelogId, String str, int pageNo, int pageSize) {
		String tmp = str == null ? "" : str;
		
		String hql = "from News u where ( u.catelog.id=? or u.catelog.parent.id=?) and u.title like ? order by u.id desc";
		return this.findPageInfoByHql(pageNo, pageSize, hql, new Object[]{catelogId, catelogId, "%"+tmp+"%"});
	}
	
	/**
	 * 根据栏目ID查找新闻
	 */
	public PageInfo findPageByNewsCatelogId(Integer catelogId, int pageNo, int pageSize) {
		String hql = "from News n where n.catelog.id=? or n.catelog.parent.id=? order by n.createTime desc";
		return this.findPageInfoByHql(pageNo, pageSize, hql, new Integer[]{catelogId, catelogId});
	}
	

	/**
	 * 返回最近发布的取指定数量的非图片新闻
	 */
	public List<News> findNonImageNews(int count) {
		String hql = "from News n where n.imageNews=0 and n.catelog.id=18 order by n.createTime desc";
		return  this.findByHql(hql, count);
	}
	
	/**
	 * 返回最近发布的取指定数量的图片新闻
	 */
	public List<News> findImageNews(int count) {
		String hql = "from News n where n.imageNews=1 order by n.createTime desc";
		return  this.findByHql(hql, count);
	}
}
