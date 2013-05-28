package com.kjlink.ahpips.service.info;

import java.util.List;

import com.brady.common.page.PageInfo;
import com.brady.common.service.CommonService;
import com.kjlink.ahpips.entity.info.*;
import com.kjlink.ahpips.entity.system.Site;
import com.kjlink.ahpips.entity.system.Site;

public interface NoticeService extends CommonService<Notice> {
	public PageInfo findPageAll(int pageNo, int pageSize);

	public PageInfo findPageAllSite(int pageNo, int pageSize,Site site);
	public PageInfo quickSearch(String str, int pageNo, int pageSize,Site site);

	public PageInfo findParentNotice(String str, int pageNo, int pageSize,Site site);
	/**
	 * �������������ȡָ�������Ĺ���
	 */
	public List<Notice> findNotice(int count);

	public List<Notice> findBySite(Site site,int count);
	
	/**
	 * �������������ָ���ĸ�������
	 * @param count
	 * @return
	 */
	public List<Notice> findFloatNotice(Site site,int count);
}
