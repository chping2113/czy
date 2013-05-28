package com.kjlink.ahpips.dao.info.impl;

import org.springframework.stereotype.Component;

import com.kjlink.ahpips.dao.impl.BaseDAOImpl;
import com.kjlink.ahpips.dao.info.ContentDAO;
import com.kjlink.ahpips.entity.info.Content;

@Component("contentDAO")
public class ContentDAOImpl extends BaseDAOImpl<Content> implements ContentDAO  {

	public ContentDAOImpl() {
		super(Content.class);
	}

	
}
