package com.kjlink.ahpips.service.system;

import com.brady.common.service.CommonService;
import com.kjlink.ahpips.entity.system.Coder;

public interface CoderService extends CommonService<Coder> {
	public String generateCoderByPrefix(String prefix,String code);
}
