package com.kjlink.ahpips.service.info.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.brady.common.page.PageInfo;
import com.kjlink.ahpips.dao.info.ScolumnDAO;
import com.kjlink.ahpips.entity.info.Scolumn;
import com.kjlink.ahpips.service.impl.BaseServiceImpl;
import com.kjlink.ahpips.service.info.ScolumnService;

@Service("scolumnService")
public class ScolumnServiceImpl extends BaseServiceImpl<Scolumn> implements ScolumnService {

	private ScolumnDAO scolumnDAO;

	public ScolumnDAO getScolumnDAO() {
		return scolumnDAO;
	}

	public void setScolumnDAO(ScolumnDAO scolumnDAO) {
		super.setCommonDAO(scolumnDAO);
		this.scolumnDAO = scolumnDAO;
	}

	public List<Scolumn> findByName(String name) {
		return this.scolumnDAO.findbyName(name);
	}

	public PageInfo findFirstLevelPageAll(int pageNo, int pageSize) {
		return this.scolumnDAO.findFirstLevelPageAll(pageNo, pageSize);
	}
	
	public List<Scolumn> findScolumnByName(String name) {
		return this.scolumnDAO.findScolumnByName(name);
	}

	public List<Scolumn> findAllScolumn() {
		return this.scolumnDAO.findAllScolumn();
	}
	
	public PageInfo findFirstLevelPageAll(Integer siteId, int pageNo, int pageSize) {
		return this.scolumnDAO.findFirstLevelPageAll(siteId, pageNo, pageSize);
	}
	
	public PageInfo findSecondLevelPageAll(Integer parentId, int pageNo, int pageSize) {
		return this.scolumnDAO.findSecondLevelPageAll(parentId, pageNo, pageSize);
	}
	
	public PageInfo findFirstLevelByName(String name,int pageNo,int pageSize) {
		return this.scolumnDAO.findFirstLevelByName(name, pageNo, pageSize);
	}

	public PageInfo findSecondLevelByName(String parentId,String name,int pageNo, int pageSize) {
		return this.scolumnDAO.findSecondLevelByName(parentId,name,pageNo, pageSize);
	}

}
