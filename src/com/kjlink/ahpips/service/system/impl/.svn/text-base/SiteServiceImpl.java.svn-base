/** 
  * @title:  
  * @description:   
  * @copyright: 凯捷技术有限公司 
  * @author: 
  * @version: 1.0
  * @created: 2010-09-20
*/

package com.kjlink.ahpips.service.system.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.brady.common.page.PageInfo;
import com.kjlink.ahpips.dao.system.DistrictDAO;
import com.kjlink.ahpips.dao.system.SiteDAO;
import com.kjlink.ahpips.entity.system.District;
import com.kjlink.ahpips.entity.system.Site;
import com.kjlink.ahpips.pojo.ZTree;
import com.kjlink.ahpips.service.impl.BaseServiceImpl;
import com.kjlink.ahpips.service.system.SiteService;


/**
 * 
 * 作者：brady.zh
 * 创建：2010-11-4
 */

@Service("siteService")
public class SiteServiceImpl extends BaseServiceImpl<Site> implements SiteService {
	private SiteDAO siteDAO;
	private DistrictDAO districtDAO;
	
	public List<Site> findSiteAll(){
		return this.siteDAO.findSiteAll();
	}
	
	public Site findParentSite(Site site){
		return this.siteDAO.findParentSite(site);
	}
	
	public Site findRootSite() {
		return this.siteDAO.findRootSite();
	}
	
	public void bulidSiteTree(List<Site> siteList, ZTree ztree) {
		for (Site site : siteList) {
			if (site.getParent() != null
					&& site.getParent().getId().equals(new Integer(ztree.getId()))) {
				ZTree node = new ZTree(String.valueOf(site.getId()), site.getName(), "", false);
				ztree.addChild(node);
				this.bulidSiteTree(siteList, node);
			}else{
				
			}
		}
	}
	
	public SiteDAO getSiteDAO() {
		return siteDAO;
	}

	public void setSiteDAO(SiteDAO siteDAO) {
		super.setCommonDAO(siteDAO); //父类的方法一定要被调用,否则会出错
		this.siteDAO = siteDAO;
	}

	public List<Site> findSitesByIds(String[] ids) {
		return this.siteDAO.findSitesByIds(ids);
	}

	public District findRootDistrict() {
		return this.districtDAO.findRootDistrict();
	}

	public List<District> findAllDistricts() {
		return this.districtDAO.findAll();
	}

	public void bulidDistrictTree(List<District> districtList, ZTree ztree) {
		for (District dist : districtList) {
			if (dist.getParent() != null
					&& dist.getParent().getCode().equals(ztree.getId())) {
				ZTree node = new ZTree(dist.getCode(), dist.getName(), "", true);
				ztree.addChild(node);
				this.bulidDistrictTree(districtList, node);
			}
		}
		
	}

	public DistrictDAO getDistrictDAO() {
		return districtDAO;
	}

	public void setDistrictDAO(DistrictDAO districtDAO) {
		this.districtDAO = districtDAO;
	}

	public int getChildNodesCount(Integer id) {
		return this.siteDAO.getChildNodesCount(id);
	}

	public Site findByCode(String code) {
		return this.siteDAO.findByCode(code);
	}

	public Site findByCodeEdit(String code,int id){
		return this.siteDAO.findByCodeEdit(code,id);
	}
	/**
	 * 查找全部省直机构
	 */
	
	public List<Site> findAllShengZhiSites() {
		return this.siteDAO.findAllShengZhiSites();
	}

	@Override
	public List<Site> findAllPingTaiSites(Site site) {
		return this.siteDAO.findAllPingTaiSites(site);
	}

	public List<Site> findAllXianSites(){
		return this.siteDAO.findAllXianSites();
	}
	@Override
	public List<Site> findAllZhuanLanSites(Site site) {
		return this.siteDAO.findAllZhuanLanSites(site);
	}

	@Override
	public List<Site> searchSiteForQucik(String queryCode) {
		
		return this.siteDAO.searchSiteForQucik(queryCode);
	}

	public List<Site> searchSiteForQucik(String queryCode,Site site) {
		return  this.siteDAO.searchSiteForQucik(queryCode,site);
	}
	public List<Site> findPZ(Site site,String str) {
		return this.siteDAO.findPZ(site, str);
	}

	public List<Site> findDetail(Site site){
		return this.siteDAO.findDetail(site);
	}
	public List<Site> searchSiteForQucikZL(String queryCode) {
		return this.siteDAO.searchSiteForQucikZL(queryCode);
	}
	
	public PageInfo findPageAll(int pageNo, int pageSize) {
		return this.siteDAO.findPageAll(pageNo, pageSize);
	}
/*
	public PageInfo todoList(String str,int pageNo, int pageSize,Organ organ){
		return this.siteDAO.todoList(str,pageNo, pageSize,organ);
		
	}*/
	public PageInfo quickSearch( String str, int pageNo, int pageSize) {
		return this.siteDAO.quickSearch(str, pageNo, pageSize);
	}
	/*public int findCount(Organ organ){
		return this.siteDAO.findCount(organ);
	}
*/
	public List<Site> findByName(String name) {
		return this.siteDAO.findbyName(name);
	}


	
}
