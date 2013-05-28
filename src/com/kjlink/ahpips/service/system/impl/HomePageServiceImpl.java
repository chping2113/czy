package com.kjlink.ahpips.service.system.impl;

import org.springframework.stereotype.Service;

import com.kjlink.ahpips.dao.system.HomePageDAO;
import com.kjlink.ahpips.entity.system.HomePage;
import com.kjlink.ahpips.entity.system.Site;
import com.kjlink.ahpips.service.impl.BaseServiceImpl;
import com.kjlink.ahpips.service.system.HomePageService;

@Service("homePageService")
public class HomePageServiceImpl extends BaseServiceImpl<HomePage> implements HomePageService {
	private HomePageDAO homePageDAO ;
	
	@Override
	public HomePage findHomePageBySite(Site site) {
		return homePageDAO.findHomePageBySite(site);
	}

	public HomePageDAO getHomePageDAO() {
		return homePageDAO;
	}

	public void setHomePageDAO(HomePageDAO homePageDAO) {
		super.setCommonDAO(homePageDAO);
		this.homePageDAO = homePageDAO;
	}
}
