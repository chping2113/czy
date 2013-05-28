/** 
  * @title:  
  * @description:   
  * @copyright: 凯捷技术有限公司 
  * @author: 
  * @version: 1.0
  * @created: 2010-09-20
*/

package com.kjlink.ahpips.dao.system;

import java.util.List;

import com.brady.common.dao.CommonDAO;
import com.brady.common.page.PageInfo;
import com.kjlink.ahpips.entity.system.Site;

/**
 * 
 * 作者：brady.zh
 * 创建：2010-11-11
 */
public interface SiteDAO extends CommonDAO<Site> {
	public Site findParentSite(Site site);
	public Site findRootSite();
	
	public List<Site> findSiteAll() ;
	
	public List<Site> findSitesByIds(String[] ids);
	
	/**
	 * 返回子节点的数量
	 */
	
	public int getChildNodesCount(Integer id);
	
	public Site findByCode(String code);
	public Site findByCodeEdit(String code,int id);
	
	/**
	 * 查找全部省直机构
	 */
	
	public List<Site> findAllShengZhiSites();
	
	public List<Site> findAllPingTaiSites(Site site);
	public List<Site> findAllZhuanLanSites(Site site);
	public List<Site> searchSiteForQucik(String queryCode) ;
	public List<Site> searchSiteForQucik(String queryCode,Site site) ;
	public List<Site> findPZ(Site site,String str) ;
	public List<Site> findAllXianSites();
	public List<Site> findDetail(Site site);
	public List<Site> searchSiteForQucikZL(String queryCode) ;
	
	public List<Site> findbyName(String name);
	public PageInfo quickSearch(String str, int pageNo, int pageSize);
	//public int findCount(Organ organ);
}
