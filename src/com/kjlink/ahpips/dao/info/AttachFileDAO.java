package com.kjlink.ahpips.dao.info;

import java.util.List;

import com.brady.common.dao.CommonDAO;
import com.kjlink.ahpips.entity.info.AttachFile;
import com.kjlink.ahpips.entity.info.News;
import com.kjlink.ahpips.entity.info.Notice;
import com.kjlink.ahpips.entity.project.ProjectApprove;

public interface AttachFileDAO extends CommonDAO<AttachFile> {
	
	public List<AttachFile> findAttachFileByProjectApprove(ProjectApprove projectApprove);

	public List<AttachFile> findAttachFileByNews(News news);

}
