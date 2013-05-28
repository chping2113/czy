/** 
  * @title:  
  * @description:   
  * @copyright: 凯捷技术有限公司 
  * @author: 
  * @version: 1.0
  * @created: 2010-09-20
*/

package com.kjlink.ahpips.dao.system.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.brady.common.page.PageInfo;
import com.kjlink.ahpips.dao.impl.BaseDAOImpl;
import com.kjlink.ahpips.dao.system.*;
import com.kjlink.ahpips.entity.system.*;
import com.kjlink.common.util.ArrayUtil;


/**
 * 
 * 作者：brady.zh
 * 创建：2010-11-4
 */

@Component("siteDAO")
@SuppressWarnings("unchecked")
public class SiteDAOImpl extends BaseDAOImpl<Site> implements SiteDAO {
	public SiteDAOImpl() {
		super(Site.class);
	}
	
	
	public List<Site> findSiteAll(){
		String hql = "from Site s order by s.code";
		return this.findByHql(hql);
	}
	
	public Site findParentSite(Site site) {
		String hql = "from Site d where d.id="+site.getParent().getId();
		List<Site> list = this.findByHql(hql);
		return list.size() > 0 ? list.get(0) : null;
	}

	public Site findRootSite() {
		String hql = "from Site s where s.parent is null";
		List<Site> list = this.findByHql(hql);
		return list.size() > 0 ? list.get(0) : null;
	}
	
	public List<Site> findSitesByIds(String[] ids) {
		if(ids == null || ids.length == 0)
			return new ArrayList<Site>();
		
		String str = ArrayUtil.join(ids, ",");
		if(str.trim().length() == 0) {
			return new ArrayList<Site>();
		}
		
		String hql = "from Site d where d.id in (" + str + ")";
		return this.findByHql(hql);
	}

	public int getChildNodesCount(Integer id) {
		String hql = "select count(*) from Site s where s.parent.id =" + id;
		List list = this.findByHql(hql);
		String num = String.valueOf(list.get(0));
		return Integer.parseInt(num);
	}

	public Site findByCode(String code) {
		return this.findUniqueResultByProperty("code", code);
	}

	public Site findByCodeEdit(String code,int id){
		String hql = "from Site o where o.code='"+code+"' and o.id!="+id;

		List<Site> list=this.findByHql(hql);
		if(list.size()>0){

			return list.get(0);
		}else{
			return null;
		}
	}
	/**
	 * 查找全部省直机构
	 */
	public List<Site> findAllShengZhiSites() {
		String hql = "from Site d where d.parent.parent is null and d.id not in " +
				"(select o.parent.id from Site o where o.parent.parent.parent is null) " +
				"order by d.code";
		return this.findByHql(hql);
	}
	
	/**
	 * 查找全部直属平台	
	 */
	public List<Site> findAllPingTaiSites(Site Site) {
		String hql = "from Site d where d.parent.id in " +
			" (select o.parent.id from Site o where o.parent.id="+Site.getId()+") " +
			" and d.type=1" +
			" order by d.code";
		return this.findByHql(hql);
	}
	
	/**
	 * 查找全部直属专栏
	 */
	public List<Site> findAllZhuanLanSites(Site site) {
		String hql = "from Site d where d.parent.id in " +
			" (select o.parent.id from Site o where o.parent.id="+site.getId()+") " +
			" and d.type=0 and d.code != '340000099' " +
			" order by d.code";
		return this.findByHql(hql);
	}

	@Override
	public List<Site> searchSiteForQucikZL(String queryCode) {


		queryCode = queryCode == null ? "" : queryCode;
		String hql = "from Site o where 1=1 " +
				"and (o.name like ? or o.code like ?) and o.type=0 order by o.code  ";
		return this.findByHql(hql, new String[]{"%" + queryCode + "%", "%" + queryCode + "%"});
	}
	@Override
	public List<Site> searchSiteForQucik(String queryCode) {


		queryCode = queryCode == null ? "" : queryCode;
		String hql = "from Site o where 1=1 " +
				"and (o.name like ? or o.code like ?) order by o.code  ";
		return this.findByHql(hql, new String[]{"%" + queryCode + "%", "%" + queryCode + "%"});
	}

	public List<Site> searchSiteForQucik(String queryCode,Site site) {
		String hql = "";
		if(site.getType()==0){
			hql = "from Site d where ((d.parent.id in " +
			"   (select o.parent.id from Site o where o.id="+site.getId()
			+") and d.type=0) or d.id="+site.getParent().getId()+" )" +
			
			
			" and (d.name like ? or d.code like ?) and d.id!="+site.getId()+" order by d.code";
		}else{
			hql = "from Site d where ((d.parent.id in " +
			"   (select o.parent.id from Site o where o.parent.id="+site.getId()
			+")  and d.type=0) or d.id="+site.getId()+")" +
			
			
			" and (d.name like ? or d.code like ?) and d.id!="+site.getId()+" order by d.code";
		}
		
		return this.findByHql(hql, new String[]{"%" + queryCode + "%", "%" + queryCode + "%"});
	}

	public List<Site> findPZ(Site Site,String str) {
		String queryStr = str == null ? "" : str;
		String hql = "from Site d where d.name like ?  order by d.code";
		return this.findByHql(hql,new String[]{ "%" + queryStr + "%"});
	}

	public List<Site> findAllXianSites(){

		String hql = "from Site d where d.parent.parent.id in " +
		" (select o.parent.parent.id from Site o where o.parent.parent.parent is null) " +
		" and d.type=1" +
		" order by d.code";
	return this.findByHql(hql);
	}
	

	public List<Site> findDetail(Site Site){
		String hql = "from Site d where (d.parent.id = " +Site.getId()+" and d.type=0 "+
		") or d.id = "+Site.getId() +
		" order by d.code";
		return this.findByHql(hql);
	}
	
	public List<Site> findbyName(String name) {
		String hql = "from Site s where s.name='"+name+"' ";
		List<Site> site = (List<Site>) this.findByHql(hql);
		return site;
	}

	public PageInfo findPageAll(int pageNo, int pageSize) {
		String hql = "from Site u where u.enable=0 or u.enable is null order by u.id desc";
		return this.findPageInfoByHql(pageNo, pageSize, hql);
	}

	
	public PageInfo quickSearch( String str, int pageNo, int pageSize) {
		String tmp = str == null ? "" : str;
		
		String hql = "from Site u where  u.name like ? order by u.id desc";
		return this.findPageInfoByHql(pageNo, pageSize, hql, new Object[]{ "%"+tmp+"%"});
	}
	/*public int findCount(Organ organ){
		String hql = "from Site u where u.state!=1 and u.organ.id="+organ.getId()+" order by u.id desc";
		return this.findByHql(hql).size();
	}*/

	
}
