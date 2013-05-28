package com.kjlink.ahpips.web.action.system;

import java.util.List;

import com.kjlink.ahpips.entity.system.District;
import com.kjlink.ahpips.service.system.DistrictService;
import com.kjlink.ahpips.web.action.BaseAction;

public class DistrictAction extends BaseAction<District> {
	private District district = new District(); //用于保存模型驱动对象
	private DistrictService districtService;
	private String queryCode ;
	
	public String searchDistrictForQucik(){
		List<District> districtList = this.districtService.searchDistrictForQucik(queryCode);
		this.getContext().put("districtList", districtList);
		return "districtList";
	}

	@Override
	public District getModel() {
		return null;
	}

	@Override
	public void prepare() throws Exception {
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	public DistrictService getDistrictService() {
		return districtService;
	}

	public void setDistrictService(DistrictService districtService) {
		this.districtService = districtService;
	}

	public String getQueryCode() {
		return queryCode;
	}

	public void setQueryCode(String queryCode) {
		this.queryCode = queryCode;
	}

}
