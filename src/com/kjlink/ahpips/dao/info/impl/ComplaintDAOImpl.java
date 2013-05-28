package com.kjlink.ahpips.dao.info.impl;

import org.springframework.stereotype.Service;

import com.brady.common.page.PageInfo;
import com.kjlink.ahpips.dao.impl.BaseDAOImpl;
import com.kjlink.ahpips.dao.info.ComplaintDAO;
import com.kjlink.ahpips.entity.info.Complaint;

@Service("complaintDAO")
public class ComplaintDAOImpl extends BaseDAOImpl<Complaint> implements ComplaintDAO {
	public ComplaintDAOImpl() {
		super(Complaint.class);
	}
	
	public PageInfo findPageAll(int pageNo, int pageSize) {
		String hql = "from Complaint u order by u.id desc";
		return this.findPageInfoByHql(pageNo, pageSize, hql);
	}

	public PageInfo quickSearch(String str, int pageNo, int pageSize) {
		String tmp = str == null ? "" : str;
		
		String hql = "from Complaint u where u.title like ? order by u.id desc";
		return this.findPageInfoByHql(pageNo, pageSize, hql, new String[] {"%"+tmp+"%"});
	}
}
