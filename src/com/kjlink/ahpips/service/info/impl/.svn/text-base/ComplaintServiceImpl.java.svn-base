package com.kjlink.ahpips.service.info.impl;

import org.springframework.stereotype.Service;

import com.brady.common.page.PageInfo;
import com.kjlink.ahpips.dao.info.ComplaintDAO;
import com.kjlink.ahpips.entity.info.Complaint;
import com.kjlink.ahpips.service.impl.BaseServiceImpl;
import com.kjlink.ahpips.service.info.ComplaintService;

@Service("complaintService")
public class ComplaintServiceImpl extends BaseServiceImpl<Complaint> implements ComplaintService {
	private ComplaintDAO complaintDAO;

	public ComplaintDAO getComplaintDAO() {
		return complaintDAO;
	}

	public void setComplaintDAO(ComplaintDAO complaintDAO) {
		super.setCommonDAO(complaintDAO);  //父类的方法一定要被调用,否则会出错
		this.complaintDAO = complaintDAO;
	}
	
	public PageInfo findPageAllByState(int pageNo, int pageSize) {

		String hql = "from Complaint u where u.dealState = 1 order by u.id desc ";
		return complaintDAO.findPageInfoByHql(pageNo, pageSize, hql);
	}

	public PageInfo findPageAll(int pageNo, int pageSize) {

		return complaintDAO.findPageAll(pageNo, pageSize);
	}
	public PageInfo quickSearch(String str, int pageNo, int pageSize) {
		return this.complaintDAO.quickSearch(str, pageNo, pageSize);
	}
}
