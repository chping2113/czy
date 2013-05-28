package com.kjlink.ahpips.dao.system.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.kjlink.ahpips.dao.impl.BaseDAOImpl;
import com.kjlink.ahpips.dao.system.HomePageDAO;
import com.kjlink.ahpips.entity.system.HomePage;
import com.kjlink.ahpips.entity.system.Site;

@Component("homePageDAO")
public class HomePageDAOImpl extends BaseDAOImpl<HomePage> implements HomePageDAO {
	public HomePageDAOImpl() {
		super(HomePage.class);
	}

	@Override
	public HomePage findHomePageBySite(Site site) {
		String hql = "from HomePage hp where hp.site.id="+site.getId();
		List<HomePage> list = this.findByHql(hql);
		return list.size() > 0 ? list.get(0) : null;
	}

}
