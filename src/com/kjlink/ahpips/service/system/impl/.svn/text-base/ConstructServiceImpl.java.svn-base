package com.kjlink.ahpips.service.system.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Service;

import com.brady.common.page.PageInfo;
import com.kjlink.ahpips.dao.impl.BaseDAOImpl;
import com.kjlink.ahpips.dao.system.ConstructDAO;

import com.kjlink.ahpips.entity.system.Construct;
import com.kjlink.ahpips.entity.system.Site;
import com.kjlink.ahpips.entity.system.Site;
import com.kjlink.ahpips.service.impl.BaseServiceImpl;
import com.kjlink.ahpips.service.system.ConstructService;

@Service("constructService")
public class ConstructServiceImpl extends BaseServiceImpl<Construct> implements ConstructService {
	private ConstructDAO constructDAO;
	
	public ConstructDAO getConstructDAO() {
		return constructDAO;
	}


	public void setConstructDAO(ConstructDAO constructDAO) {
		super.setCommonDAO(constructDAO);  //父类的方法一定要被调用,否则会出错
		this.constructDAO = constructDAO;
	}


	public PageInfo findPageAll(int pageNo, int pageSize, String queryStr) {
		
		return this.constructDAO.findPageAll(pageNo, pageSize, queryStr);
	}


	public PageInfo quickSearch(String str, int pageNo, int pageSize) {
		
		return this.constructDAO.quickSearch(str, pageNo, pageSize);
	}

	public Construct findByCode(String code) {
		return this.constructDAO.findByCode(code);
	}


	public Construct findByEmail(String email) {
		return this.constructDAO.findByEmail(email);
	}

	public Construct findByEmail(String email,Construct construct){
		return this.constructDAO.findByEmail(email,construct);
	}

	public Construct findByCertificateCode(String doc) {
		
		return this.constructDAO.findByCertificateCode(doc);
	}


	public List<Construct> searchConstructForQucik(String queryCode) {
		return this.constructDAO.searchConstructForQucik(queryCode);
	}

	
	public PageInfo findPageAllState(int pageNo, int pageSize, String queryStr) {
		return this.constructDAO.findPageAllState(pageNo, pageSize, queryStr);
	}

	
	public PageInfo quickSearchState(String str, int pageNo, int pageSize) {
		return this.constructDAO.quickSearchState(str, pageNo, pageSize);
	}


	public boolean isValidCompany(String code, String password) {
		Construct construct= this.findByCode(code);
		return construct != null && construct.getPassword().equals(password) && new Integer(1).equals(construct.getState());
	}

	public Construct findByConcode(String concode) {
		return this.constructDAO.findByConcode(concode);
	}
	public int findCount(Site site){
		return this.constructDAO.findCount(site);
	}

}
