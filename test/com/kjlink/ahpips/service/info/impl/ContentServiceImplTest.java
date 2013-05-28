package com.kjlink.ahpips.service.info.impl;

import javax.annotation.Resource;

import org.junit.Test;

import com.kjlink.TestBase;
import com.kjlink.ahpips.entity.info.Content;
import com.kjlink.ahpips.service.info.ContentService;

public class ContentServiceImplTest extends TestBase{

	
	
	private ContentService contentService;
	
	@Test
	public void testSave() {
		 Content content=new Content();
		 
		 
		// ScolumnContent scolumnContent=new ScolumnContent();
		 contentService.save(content);
		 
		
	}

	public ContentService getContentService() {
		return contentService;
	}
     
	@Resource(name="contentService")
	public void setContentService(ContentService contentService) {
		this.contentService = contentService;
	}

	
	
	
}
