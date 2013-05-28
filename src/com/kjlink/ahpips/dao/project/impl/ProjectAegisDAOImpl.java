package com.kjlink.ahpips.dao.project.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.brady.common.page.PageInfo;
import com.kjlink.ahpips.dao.impl.BaseDAOImpl;
import com.kjlink.ahpips.dao.project.ProjectAegisDAO;
import com.kjlink.ahpips.entity.project.KeyProjectKind;
import com.kjlink.ahpips.entity.system.Site;

@Component("projectAegisDAO")
public class ProjectAegisDAOImpl extends BaseDAOImpl<KeyProjectKind> implements ProjectAegisDAO {
	public ProjectAegisDAOImpl() {
		super(KeyProjectKind.class);
	}
	
	public PageInfo findPageAll(int pageNo, int pageSize) {
		String hql = "from KeyProjectKind u order by u.id desc";
		return this.findPageInfoByHql(pageNo, pageSize, hql);
	}

	public PageInfo quickSearch(String str, int pageNo, int pageSize,Site site) {
		String tmp = str == null ? "" : str;
		
		String hql = "from KeyProjectKind u where  u.name like ? order by u.showOrder";
		return this.findPageInfoByHql(pageNo, pageSize, hql, new String[] {"%"+tmp+"%"});
	}
	
	public List<KeyProjectKind> findKeyAll(Site site) {
		String hql = "from KeyProjectKind u  order by u.showOrder";
		return this.findByHql(hql);
	}
	
	public List<KeyProjectKind> findKeyProjectKindForPublic(int count){
		String hql = "from KeyProjectKind u order by u.id desc";
		return this.findByHql(hql, count);
	}
}
