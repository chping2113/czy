package com.kjlink.ahpips.service.system.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.brady.common.page.PageInfo;
import com.kjlink.ahpips.dao.system.AlexaDAO;
import com.kjlink.ahpips.entity.system.Alexa;
import com.kjlink.ahpips.service.impl.BaseServiceImpl;
import com.kjlink.ahpips.service.system.AlexaService;

@Service("alexaService")
public class AlexaServiceImpl extends BaseServiceImpl<Alexa> implements AlexaService {
	private AlexaDAO alexaDAO;

	@Override
	public PageInfo getAlexaByTitle(int pageNo, int pageSize,String title) {
		return alexaDAO.getAlexaByTitle(pageNo,pageSize,title);
	}
	
	@Override
	public List<Alexa> getAlexaByType(String type) {
		return alexaDAO.getAlexaByType(type);
	}
	
	public void setAlexaDAO(AlexaDAO alexaDAO) {
		super.setCommonDAO(alexaDAO);
		this.alexaDAO = alexaDAO;
	}

	public AlexaDAO getAlexaDAO() {
		return alexaDAO;
	}

}
