package com.kjlink.ahpips.service.info.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kjlink.ahpips.dao.info.AttachFileDAO;
import com.kjlink.ahpips.entity.info.AttachFile;
import com.kjlink.ahpips.entity.info.News;
import com.kjlink.ahpips.entity.info.Notice;
import com.kjlink.ahpips.entity.project.ProjectApprove;
import com.kjlink.ahpips.service.impl.BaseServiceImpl;
import com.kjlink.ahpips.service.info.AttachFileService;

@Service("attachFileService")
public class AttachFileServiceImpl extends BaseServiceImpl<AttachFile> implements AttachFileService {
	private AttachFileDAO attachFileDAO;
	
	public List<AttachFile> findAttachFileByProjectApprove(ProjectApprove projectApprove){
		return this.attachFileDAO.findAttachFileByProjectApprove(projectApprove);
	}

	public List<AttachFile> findAttachFileByNews(News news){
		return  this.attachFileDAO.findAttachFileByNews(news);
	}
	public AttachFileDAO getAttachFileDAO() {
		return attachFileDAO;
	}

	public void setAttachFileDAO(AttachFileDAO attachFileDAO) {
		super.setCommonDAO(attachFileDAO);
		this.attachFileDAO = attachFileDAO;
	}

}
