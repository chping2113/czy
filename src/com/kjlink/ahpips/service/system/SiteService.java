/** 
  * @title:  
  * @description:   
  * @copyright: 凯捷技术有限公司 
  * @author: 
  * @version: 1.0
  * @created: 2010-09-20
*/

package com.kjlink.ahpips.service.system;

import java.util.List;

import com.brady.common.page.PageInfo;
import com.brady.common.service.CommonService;
import com.kjlink.ahpips.entity.system.District;
import com.kjlink.ahpips.entity.system.Site;
import com.kjlink.ahpips.pojo.ZTree;

/**
 * 
 * 作者：brady.zh
 * 创建：2010-11-11
 */
public interface SiteService extends CommonService<Site> {
	/**
	 * 查找父部门，不存在则返回null
	 * @return
	 */
	public List<Site> findSiteAll();
	
	/**
	 * 查找父部门，不存在则返回null
	 * @return
	 */
	public Site findParentSite(Site Site);
	
	/**
	 * 查找根部门，不存在则返回null
	 * @return
	 */
	public Site findRootSite();
	
	/**
	 * 从列表SiteList中的对象构造一个Tree
	 * @param SiteList
	 * @param treeRoot
	 */
	public void bulidSiteTree(List<Site> SiteList, ZTree treeRoot) ;
	
	/**
	 * 根据部门ID数组查找部门ID
	 * @param ids
	 * @return
	 */
	public List<Site> findSitesByIds(String[] ids);
	
	/**
	 * 返回行政区划的根节点
	 * @return
	 */
	public District findRootDistrict(); 
	
	/**
	 * 返回全部的District数据
	 * @return
	 */
	public List<District> findAllDistricts();
	
	/**
	 * 从列表districtList中的对象构造一个Tree
	 * @param districtList
	 * @param treeRoot
	 */
	public void bulidDistrictTree(List<District> districtList, ZTree treeRoot) ;
	
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
	
	public List<Site> findAllPingTaiSites(Site Site);
	public List<Site> findAllZhuanLanSites(Site Site);
	public List<Site> searchSiteForQucik(String queryCode) ;
	public List<Site> searchSiteForQucik(String queryCode,Site Site) ;
	public List<Site> findPZ(Site Site,String str) ;
	public List<Site> findAllXianSites();
	public List<Site> findDetail(Site Site);
	public List<Site> searchSiteForQucikZL(String queryCode) ;
	
	public List<Site> findByName(String name);
	public PageInfo findPageAll(int pageNo, int pageSize);
	//public PageInfo todoList(String str,int pageNo, int pageSize,Organ organ);
	public PageInfo quickSearch( String str, int pageNo, int pageSize);
	//public int findCount(Organ organ);
	
}
