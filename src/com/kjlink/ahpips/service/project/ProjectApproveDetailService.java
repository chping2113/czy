package com.kjlink.ahpips.service.project;

import java.util.Date;
import java.util.List;

import com.brady.common.page.PageInfo;
import com.kjlink.ahpips.entity.project.ProjectApprove;
import com.kjlink.ahpips.entity.project.ProjectApproveDetail;
import com.kjlink.ahpips.entity.project.ProjectApproveFlow;
import com.kjlink.ahpips.entity.system.Site;
import com.kjlink.ahpips.entity.system.Site;
import com.kjlink.ahpips.entity.system.User;
import com.kjlink.ahpips.service.BaseService;

public interface ProjectApproveDetailService extends BaseService<ProjectApproveDetail>{
	public List<ProjectApproveDetail> findByProjectApprove(ProjectApprove projectApprove);
	public List<ProjectApproveDetail> findByProjectApprove(ProjectApprove projectApprove,Site site);
	public List<ProjectApproveDetail> findProjectApproveDetailForPulbic(int count,Site site);
	public PageInfo findPublicAll(int pageNo, int pageSize,Site site);
	public PageInfo findPublicAllByName(int pageNo, int pageSize,Site site,String queryCode);
	public int findDataCount(Site site);
	public int findDataCount(Site tempSite,Date startTime,Date endTime);

	public int findByUser(User user);
	public int findByUser(User user,Date startTime,Date endTime);

}
