package com.kjlink.ahpips.service.info.impl;

import org.springframework.stereotype.Service;

import com.kjlink.ahpips.dao.info.ContentDAO;
import com.kjlink.ahpips.entity.info.Content;
import com.kjlink.ahpips.service.impl.BaseServiceImpl;
import com.kjlink.ahpips.service.info.ContentService;

@Service("contentService")
public class ContentServiceImpl extends BaseServiceImpl<Content> implements ContentService {

	private ContentDAO contentDAO;

	public ContentDAO getContentDAO() {
		return contentDAO;
	}

	public void setContentDAO(ContentDAO contentDAO) {
		super.setCommonDAO(contentDAO);
		this.contentDAO = contentDAO;
	}
	

}
