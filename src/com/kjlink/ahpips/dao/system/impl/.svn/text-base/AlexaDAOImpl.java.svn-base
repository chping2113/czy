package com.kjlink.ahpips.dao.system.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.brady.common.page.PageInfo;
import com.kjlink.ahpips.dao.impl.BaseDAOImpl;
import com.kjlink.ahpips.dao.system.AlexaDAO;
import com.kjlink.ahpips.entity.system.Alexa;

@Component("alexaDAO")
public class AlexaDAOImpl extends BaseDAOImpl<Alexa> implements AlexaDAO {
	public AlexaDAOImpl() {
		super(Alexa.class);
	}

	@Override
	public PageInfo getAlexaByTitle(int pageNo, int pageSize,String title) {
		String hql = "from Alexa al where al.title like '%" + title + "%' or al.type like '%" + title + "%'";
		return this.findPageInfoByHql(pageNo, pageSize, hql);
	}
	
	@Override
	public List<Alexa> getAlexaByType(String type) {
		String hql = "from Alexa al where al.type='"+type+"'";
		return this.findByHql(hql);
	}

}
