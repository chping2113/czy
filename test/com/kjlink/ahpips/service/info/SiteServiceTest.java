package com.kjlink.ahpips.service.info;

import javax.annotation.Resource;

import org.junit.Test;

import com.kjlink.TestBase;
import com.kjlink.ahpips.entity.info.Site;

public class SiteServiceTest extends TestBase{
	
	private SiteService siteService;
	
	@Test
	public void testSave() {
		Site s = new Site();
		s.setName("安徽省中小企业平台");
		s.setState(1);
		s.setGrade("省");
		siteService.save(s);
		
	}
	public SiteService getSiteService() {
		return siteService;
	}
	
	@Resource(name="siteService")
	public void setSiteService(SiteService siteService) {
		this.siteService = siteService;
	}

}
