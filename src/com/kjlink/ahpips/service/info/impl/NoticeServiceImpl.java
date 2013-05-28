package com.kjlink.ahpips.service.info.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Service;

import com.brady.common.page.PageInfo;
import com.kjlink.ahpips.dao.info.*;
import com.kjlink.ahpips.dao.system.*;
import com.kjlink.ahpips.entity.info.*;
import com.kjlink.ahpips.entity.system.*;
import com.kjlink.ahpips.service.impl.BaseServiceImpl;
import com.kjlink.ahpips.service.info.*;
import com.kjlink.ahpips.service.system.*;

@Service("noticeService")
public class NoticeServiceImpl extends BaseServiceImpl<Notice> implements NoticeService {
	private NoticeDAO noticeDAO;

	public NoticeDAO getNoticeDAO() {
		return noticeDAO;
	}

	public void setNoticeDAO(NoticeDAO noticeDAO) {
		super.setCommonDAO(noticeDAO);  //父类的方法一定要被调用,否则会出错
		this.noticeDAO = noticeDAO;
	}
	
	public PageInfo findPageAll(int pageNo, int pageSize) {
		return this.noticeDAO.findPageAll(pageNo, pageSize);
	}

	public PageInfo findPageAllSite(int pageNo, int pageSize,Site site) {
		return this.noticeDAO.findPageAllSite(pageNo, pageSize, site);
	}
	public PageInfo quickSearch(String str, int pageNo, int pageSize,Site site) {
		return this.noticeDAO.quickSearch(str, pageNo, pageSize,site);
	}

	public PageInfo findParentNotice(String str, int pageNo, int pageSize,Site site){
		return this.noticeDAO.findParentNotice(str,pageNo,pageSize,site);
	}
	/**
	 * 返回最近发布的取指定数量的公告
	 */
	public List<Notice> findNotice(int count) {
		return this.noticeDAO.findNotice(count);
	}
	
	/**
	 * 返回最近发布的指定的浮动公告
	 * @param count
	 * @return
	 */
	public List<Notice> findFloatNotice(Site site,int count) {
		return this.noticeDAO.findFloatNotice(site,count);
	}

	public List<Notice> findBySite(Site site,int count){
		return this.noticeDAO.findBySite(site,count);
	}
}
