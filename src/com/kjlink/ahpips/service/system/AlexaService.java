package com.kjlink.ahpips.service.system;

import java.util.List;

import com.brady.common.page.PageInfo;
import com.brady.common.service.CommonService;
import com.kjlink.ahpips.entity.system.Alexa;

public interface AlexaService  extends CommonService<Alexa> {
	public PageInfo getAlexaByTitle(int pageNo, int pageSize,String title);
	public List<Alexa> getAlexaByType(String type);
}
