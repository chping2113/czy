package com.kjlink.ahpips.dao.info.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.kjlink.ahpips.dao.impl.BaseDAOImpl;
import com.kjlink.ahpips.dao.info.AttachFileDAO;
import com.kjlink.ahpips.entity.info.AttachFile;
import com.kjlink.ahpips.entity.info.News;
import com.kjlink.ahpips.entity.info.Notice;
import com.kjlink.ahpips.entity.project.ProjectApprove;

@Component("attachFileDAO")
public class AttachFileDAOImpl extends BaseDAOImpl<AttachFile> implements AttachFileDAO {
	
	public List<AttachFile> findAttachFileByProjectApprove(ProjectApprove projectApprove){
		String hql = "from AttachFile af where af.projectApprove.id="+projectApprove.getId();
		return this.findByHql(hql);
	}

	public List<AttachFile> findAttachFileByNews(News news){
		String hql = "from AttachFile af where af.news.id="+news.getId();
		return this.findByHql(hql);
	}
	public AttachFileDAOImpl() {
		super(AttachFile.class);
	}

}
