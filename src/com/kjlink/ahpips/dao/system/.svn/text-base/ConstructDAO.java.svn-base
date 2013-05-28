package com.kjlink.ahpips.dao.system;

import java.util.List;

import com.brady.common.dao.CommonDAO;
import com.brady.common.page.PageInfo;
import com.kjlink.ahpips.entity.system.Construct;
import com.kjlink.ahpips.entity.system.Site;
import com.kjlink.ahpips.entity.system.Site;

public interface ConstructDAO extends CommonDAO<Construct> {
	public PageInfo findPageAll(int pageNo, int pageSize,String queryStr);
	
	public PageInfo quickSearch(String str, int pageNo, int pageSize);
	
	public Construct findByCode(String code);
	
	public Construct findByConcode(String concode);
	
	public Construct findByEmail(String email);
	public Construct findByEmail(String email,Construct construct);
	
	public Construct findByCertificateCode(String doc);
	
	public List<Construct> searchConstructForQucik(String queryCode);
	
	public PageInfo findPageAllState(int pageNo, int pageSize,String queryStr);
	
	public PageInfo quickSearchState(String str, int pageNo, int pageSize);
	public int findCount(Site site);
}
