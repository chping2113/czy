package com.kjlink.ahpips.dao.info.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.brady.common.page.PageInfo;
import com.kjlink.ahpips.dao.impl.BaseDAOImpl;
import com.kjlink.ahpips.dao.info.ScolumnDAO;
import com.kjlink.ahpips.entity.info.Scolumn;

@SuppressWarnings("unchecked")
@Component("scolumnDAO")
public class ScolumnDAOImpl extends BaseDAOImpl<Scolumn> implements ScolumnDAO  {

	public ScolumnDAOImpl() {
		super(Scolumn.class);
	}

	
	public List<Scolumn> findbyName(String name) {
		String hql = "from Scolumn s where s.name='"+name+"' order by s.id desc";
		return this.findByHql(hql);
	}

	public PageInfo findFirstLevelPageAll(int pageNo, int pageSize) {
		String hql = "from Scolumn s where s.parent is null order by s.state, s.id desc";
		return this.findPageInfoByHql(pageNo, pageSize, hql);
	}

	public List<Scolumn> findScolumnByName(String name) {
		String hql = "from Scolumn s where s.parent is null and s.name='"+name+"' order by s.id desc";
		return this.findByHql(hql);
	}
	
	public PageInfo findFirstLevelByName(String name,int pageNo,int pageSize) {
		String hql = "from Scolumn s where s.parent is null and s.name like ? order by s.id desc";
		return this.findPageInfoByHql(pageNo, pageSize, hql, new String[]{"%" + name + "%"});
	}
	
	public PageInfo findSecondLevelByName(String parentId,String name,int pageNo, int pageSize) {
		String hql = "from Scolumn s where s.parent.id='"+parentId+"' and s.name like ? order by s.id desc";
		return this.findPageInfoByHql(pageNo, pageSize, hql, new String[]{"%" + name + "%"});
	}

	public List<Scolumn> findAllScolumn() {
		String hql = "from Scolumn s where s.state=1 order by s.id desc";
		
		return this.findByHql(hql);
	}

	public PageInfo findFirstLevelPageAll(Integer siteId, int pageNo, int pageSize) {
		String hql = "from Scolumn c where c.site.id="+siteId+" and c.parent is null order by c.id desc"; 
		return this.findPageInfoByHql(pageNo, pageSize, hql);
	}

	public PageInfo findSecondLevelPageAll(Integer parentId, int pageNo, int pageSize) {
		String hql = "from Scolumn s where s.parent.id=? order by s.state, s.id desc";
		return this.findPageInfoByHql(pageNo, pageSize, hql, new Integer[] {parentId});
	}
	
}
