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

@Component("newsCatelogDAO")
public class NewsCatelogDAOImpl extends BaseDAOImpl<NewsCatelog> implements NewsCatelogDAO {
	public NewsCatelogDAOImpl() {
		super(NewsCatelog.class);
	}
	
	public PageInfo findPageAll(int pageNo, int pageSize) {
		String hql = "from NewsCatelog u order by id desc";
		return this.findPageInfoByHql(pageNo, pageSize, hql);
	}
	
	public PageInfo findFirstLevelPageAll(int pageNo, int pageSize) {
		String hql = "from NewsCatelog u where u.parent is null order by u.showOrder, u.id desc";
		return this.findPageInfoByHql(pageNo, pageSize, hql);
	}
	
	public PageInfo findSecondLevelPageAll(Integer parentId, int pageNo, int pageSize) {
		String hql = "from NewsCatelog u where u.parent.id=? order by u.showOrder, u.id desc";
		return this.findPageInfoByHql(pageNo, pageSize, hql, new Integer[] {parentId});
	}

	public PageInfo quickSearch(String str, int pageNo, int pageSize) {
		String tmp = str == null ? "" : str;
		
		String hql = "from NewsCatelog u where u.title like ? order by u.id desc";
		return this.findPageInfoByHql(pageNo, pageSize, hql, new String[] {"%"+tmp+"%"});
	}
	
	public List<NewsCatelog> findSecondCatelogsByParentId(Integer parentId) {
		String hql = "from NewsCatelog nc where nc.parent.id=? order by nc.showOrder, nc.id desc";
		return this.findByHql(hql, new Integer[] {parentId});
	}
}
