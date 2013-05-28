package com.kjlink.ahpips.dao.system.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.brady.common.page.PageInfo;
import com.kjlink.ahpips.dao.impl.BaseDAOImpl;
import com.kjlink.ahpips.dao.system.NavigateDAO;
import com.kjlink.ahpips.entity.system.Navigate;

@Component("navigateDAO")
public class NavigateDAOImpl  extends BaseDAOImpl<Navigate> implements NavigateDAO{

	
	public NavigateDAOImpl() {
		super(Navigate.class);
	}


	public PageInfo findPageAll(int pageNo, int pageSize,int id,int type) {
		String hql = "from Navigate n where n.type="+type+" and n.site.id="+id+" order by n.showOrder ";
		return this.findPageInfoByHql(pageNo, pageSize, hql);
	}

	public PageInfo findPageAllByParent(int pageNo, int pageSize,int siteId,int type,int parentId){

		String hql = "from Navigate n where n.type="+type+" and n.parent.id="+parentId+" and  n.site.id="+siteId+" order by n.showOrder ";
		return this.findPageInfoByHql(pageNo, pageSize, hql);
	}
	
	public PageInfo quickSearch(String queryStr, int pageNo, int pageSize,int id) {
		String str = queryStr == null ? "" : queryStr;
		String hql = "from Navigate n where n.type=0 and n.site.id="+id+" and n.name like ? order by n.showOrder";
		return this.findPageInfoByHql(pageNo, pageSize, hql,new String[]{"%"+str+"%"});
	}
	public PageInfo quickSearchByParent(String queryStr, int pageNo, int pageSize,int id,int parentId){
		String str = queryStr == null ? "" : queryStr;
		String hql = "from Navigate n where n.type=1 and n.parent.id="+parentId+" and n.site.id="+id+" and n.name like ? order by n.showOrder ";
		return this.findPageInfoByHql(pageNo, pageSize, hql,new String[]{"%"+str+"%"});
	}

	public List<Navigate> findByType(int type,int siteId) {
		String hql = "from Navigate n where n.type = "+type+" and n.site.id = "+siteId+" order by n.showOrder";
		return this.findByHql(hql);
	}

	public List<Navigate> findByTypeParent(int type,int siteId,int parentId){
		String hql = "from Navigate n where n.type = "+type+" and n.site.id = "+siteId+" and n.parent.id="+parentId+" order by n.showOrder";
		return this.findByHql(hql);
	}

}
