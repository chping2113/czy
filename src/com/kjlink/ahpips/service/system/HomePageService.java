package com.kjlink.ahpips.service.system;

import com.kjlink.ahpips.entity.system.HomePage;
import com.kjlink.ahpips.entity.system.Site;
import com.kjlink.ahpips.service.BaseService;

public interface HomePageService extends BaseService<HomePage> {

	public HomePage findHomePageBySite(Site site);
}
