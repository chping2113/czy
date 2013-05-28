package com.kjlink.ahpips.dao.system.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Component;

import com.brady.common.page.PageInfo;
import com.kjlink.ahpips.dao.impl.BaseDAOImpl;
import com.kjlink.ahpips.dao.system.ConstructDAO;
import com.kjlink.ahpips.entity.system.Construct;
import com.kjlink.ahpips.entity.system.Site;
import com.kjlink.ahpips.entity.system.Site;


@Component("constructDAO")
public class ConstructDAOImpl extends BaseDAOImpl<Construct> implements ConstructDAO {

	public ConstructDAOImpl() {
		super(Construct.class);
	}
	
	public PageInfo findPageAll(int pageNo, int pageSize, String queryStr) {
		String str = queryStr == null ? "" : queryStr;
		String hql = "from Construct p where p.name like ? order by p.state,p.registerTime desc";
		return this.findPageInfoByHql(pageNo, pageSize, hql,new String[]{"%"+str+"%"});
	}


	public PageInfo quickSearch(String str, int pageNo, int pageSize) {
		String tmp = str == null ? "" : str;
		
		String hql = "from Construct u where u.code like ? or u.name like ? order by u.id desc";
		return this.findPageInfoByHql(pageNo, pageSize, hql, new String[]{"%"+tmp+"%", "%"+tmp+"%"});
	}

	public Construct findByCode(String code) {
		return this.findUniqueResultByProperty("code", code);
	}


	public Construct findByEmail(String email) {
		return this.findUniqueResultByProperty("email", email);
	}

	public Construct findByEmail(String email,Construct construct){
		String hql = "from Construct p where p.email = ?  and p.id != "+construct.getId()+" order by p.id desc";
		List<Construct> list=this.findByHql(hql, new String[]{ email});
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}

	public Construct findByCertificateCode(String doc) {
		
		return this.findUniqueResultByProperty("code", doc);
	}


	public List<Construct> searchConstructForQucik(String queryCode) {
		queryCode = queryCode == null ? "" : queryCode;
		String hql = "from Construct com where 1=1 " +
				"and (com.name like ? or com.linkman like ?) order by com.id desc ";
		return this.findByHql(hql, new String[]{"%" + queryCode + "%", "%" + queryCode + "%"});
	}

	
	public PageInfo findPageAllState(int pageNo, int pageSize, String queryStr) {
		String str = queryStr == null ? "" : queryStr;
		String hql = "from Construct con where con.state=1 and con.name like ? order by con.id desc";
		return this.findPageInfoByHql(pageNo, pageSize, hql,new String[]{"%"+str+"%"});
	}

	
	public PageInfo quickSearchState(String str, int pageNo, int pageSize) {
		String tmp = str == null ? "" : str;
		
		String hql = "from Construct con where con.state=1 and con.code like ? or con.name like ? order by con.id desc";
		return this.findPageInfoByHql(pageNo, pageSize, hql, new String[]{"%"+tmp+"%", "%"+tmp+"%"});
	}

	public Construct findByConcode(String concode) {
		
		return this.findUniqueResultByProperty("concode", concode);
	}
	public int findCount(Site site){

		String hql = "from Construct con where con.state=0 order by con.id desc";
		return this.findByHql(hql).size();
	}


}
