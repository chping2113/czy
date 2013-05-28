package com.kjlink.ahpips.service.info.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kjlink.ahpips.dao.info.ScolumnPropertyDAO;
import com.kjlink.ahpips.entity.info.ScolumnProperty;
import com.kjlink.ahpips.service.impl.BaseServiceImpl;
import com.kjlink.ahpips.service.info.ScolumnPropertyService;

@Service("scolumnPropertyService")
public class ScolumnPropertyServiceImpl extends BaseServiceImpl<ScolumnProperty> implements ScolumnPropertyService {

	private ScolumnPropertyDAO scolumnPropertyDAO;

	public ScolumnPropertyDAO getScolumnPropertyDAO() {
		return scolumnPropertyDAO;
	}

	public void setScolumnPropertyDAO(ScolumnPropertyDAO scolumnPropertyDAO) {
		super.setCommonDAO(scolumnPropertyDAO);
		this.scolumnPropertyDAO = scolumnPropertyDAO;
	}

	public List<ScolumnProperty> findByScolumnId(Integer scolumnId) {
		return this.scolumnPropertyDAO.findByScolumnId(scolumnId);
	}

	

}
