package com.kjlink.ahpips.dao.system;

import java.util.List;

import com.brady.common.dao.CommonDAO;
import com.brady.common.page.PageInfo;
import com.kjlink.ahpips.entity.system.Alexa;

public interface AlexaDAO extends CommonDAO<Alexa> {
	public PageInfo getAlexaByTitle(int pageNo, int pageSize,String title) ;
	public List<Alexa> getAlexaByType(String type) ;
}

