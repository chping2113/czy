package com.kjlink.ahpips.service.system.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kjlink.ahpips.dao.system.DistrictDAO;
import com.kjlink.ahpips.entity.system.District;
import com.kjlink.ahpips.service.impl.BaseServiceImpl;
import com.kjlink.ahpips.service.system.DistrictService;

@Service("districtService")
public class DistrictServiceImpl extends BaseServiceImpl<District> implements DistrictService {
	private DistrictDAO districtDAO ;

	public DistrictDAO getDistrictDAO() {
		return districtDAO;
	}

	public void setDistrictDAO(DistrictDAO districtDAO) {
		super.setCommonDAO(districtDAO);
		this.districtDAO = districtDAO;
	}

	@Override
	public List<District> searchDistrictForQucik(String queryCode) {
		return this.districtDAO.searchDistrictForQucik(queryCode);
	}
	
	public District findByCode(String code){
		return this.districtDAO.findUniqueResultByProperty("code", code);
	}
	
	public District findByName(String name){
		return this.districtDAO.findUniqueResultByProperty("name", name);
	}

}
