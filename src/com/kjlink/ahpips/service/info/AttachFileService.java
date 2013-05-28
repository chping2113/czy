package com.kjlink.ahpips.service.info;

import java.util.List;

import com.brady.common.service.CommonService;
import com.kjlink.ahpips.entity.info.AttachFile;
import com.kjlink.ahpips.entity.info.News;
import com.kjlink.ahpips.entity.info.Notice;
import com.kjlink.ahpips.entity.project.ProjectApprove;

public interface AttachFileService extends CommonService<AttachFile> {
	
	public List<AttachFile> findAttachFileByProjectApprove(ProjectApprove projectApprove);
	
	public List<AttachFile> findAttachFileByNews(News news);

}
