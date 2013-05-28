package com.kjlink.ahpips.service.info;

import java.util.List;

import com.brady.common.service.CommonService;
import com.kjlink.ahpips.entity.info.ScolumnProperty;

public interface ScolumnPropertyService extends CommonService<ScolumnProperty>{

	public List<ScolumnProperty> findByScolumnId(Integer scolumnId);
	

}
