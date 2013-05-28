package com.kjlink.ahpips.service.project;

import java.util.Date;
import java.util.List;

import com.brady.common.page.PageInfo;
import com.kjlink.ahpips.entity.project.Project;
import com.kjlink.ahpips.entity.project.ProjectApprove;
import com.kjlink.ahpips.entity.project.ProjectConstruct;
import com.kjlink.ahpips.entity.system.Construct;
import com.kjlink.ahpips.entity.system.Site;
import com.kjlink.ahpips.entity.system.Site;
import com.kjlink.ahpips.entity.system.User;
import com.kjlink.ahpips.service.BaseService;

public interface ProjectConstructService  extends BaseService<ProjectConstruct>{
	public List<ProjectConstruct> findProjectConstructByProject(Project project);
	public List<ProjectConstruct> findProjectConstructForPulbic(int count,Site site);
	public PageInfo findPageAll(int pageNo, int pageSize);
	public PageInfo findPublicAll(int pageNo, int pageSize,Site site);
	public PageInfo findPublicAllByName(int pageNo, int pageSize,Site site,String queryCode);
	public PageInfo quickSearch(String str, int pageNo, int pageSize);
	public PageInfo findProjectConstructBySiteId(String str,String sitecode, int pageNo, int pageSize);

	public PageInfo findProjectConstructByConstruct(String str,Construct construct, int pageNo, int pageSize);

	public List<ProjectApprove> findProjectByName(String queryCode);
	public List<ProjectApprove> findProjectByNameAndSitecode(String queryCode,String sitecode);
	public PageInfo findByToDo(String str,User user, int pageNo, int pageSize);
	public int findCount(User user);
	public int findDataCount(Site site);
	public int findDataCount(Site tempSite,Date startTime,Date endTime);
	public int findByUser(User user);
	public int findByUser(User user,Date startTime,Date endTime);
}
