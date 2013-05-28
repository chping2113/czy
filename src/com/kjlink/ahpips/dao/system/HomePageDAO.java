package com.kjlink.ahpips.dao.system;

import com.brady.common.dao.CommonDAO;
import com.kjlink.ahpips.entity.system.HomePage;
import com.kjlink.ahpips.entity.system.Site;

public interface HomePageDAO extends CommonDAO<HomePage> {
	public HomePage findHomePageBySite(Site site);
}
