package com.kjlink.ahpips.dao.project;

import java.util.Date;
import java.util.List;

import com.brady.common.dao.CommonDAO;
import com.brady.common.page.PageInfo;
import com.kjlink.ahpips.entity.project.ProjectAim;
import com.kjlink.ahpips.entity.system.Site;
import com.kjlink.ahpips.entity.system.User;

public interface ProjectAimDAO extends CommonDAO<ProjectAim> {

	public PageInfo findProjectAimBySiteId(String str,String sitecode, int pageNo, int pageSize);

	public List<ProjectAim> findProjectAimForPulbic(int count,Site site);

	public PageInfo findPublicAll(int pageNo, int pageSize,Site site);

	public PageInfo findPublicAllByName(int pageNo, int pageSize,Site site,String queryCode);
	public int findDataCount(Site site);
	public int findDataCount(Site site,Date startTime,Date endTime);
	public int findByUser(User user);
	public int findByUser(User user,Date startTime,Date endTime);

}
