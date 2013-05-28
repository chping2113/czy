package com.kjlink.ahpips.service.info;

import com.brady.common.page.PageInfo;
import com.brady.common.service.CommonService;
import com.kjlink.ahpips.entity.info.*;

public interface ComplaintService extends CommonService<Complaint> {
	
	public PageInfo findPageAll(int pageNo, int pageSize);
	public PageInfo findPageAllByState(int pageNo, int pageSize);
	
	public PageInfo quickSearch(String str, int pageNo, int pageSize);
}
