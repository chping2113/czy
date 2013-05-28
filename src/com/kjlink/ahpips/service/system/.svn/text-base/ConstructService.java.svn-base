package com.kjlink.ahpips.service.system;

import java.util.List;

import com.brady.common.page.PageInfo;
import com.brady.common.service.CommonService;
import com.kjlink.ahpips.entity.system.Construct;
import com.kjlink.ahpips.entity.system.Site;
import com.kjlink.ahpips.entity.system.Site;


public interface ConstructService extends CommonService<Construct>{
	public PageInfo findPageAll(int pageNo, int pageSize,String queryStr);
	
	public PageInfo quickSearch(String str, int pageNo, int pageSize);
	
	public boolean isValidCompany(String code, String password); //根据用户帐号和密码检查该帐号是不是有效的帐号
	
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
