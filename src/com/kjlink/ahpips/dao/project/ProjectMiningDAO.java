package com.kjlink.ahpips.dao.project;

import java.util.Date;
import java.util.List;

import com.brady.common.dao.CommonDAO;
import com.brady.common.page.PageInfo;
import com.kjlink.ahpips.entity.project.ProjectMining;
import com.kjlink.ahpips.entity.system.Site;
import com.kjlink.ahpips.entity.system.User;

public interface ProjectMiningDAO extends CommonDAO<ProjectMining> {

	
	public List<ProjectMining> findProjectMiningForPulbic(int count,Site site);
	public PageInfo findPublicAllByName(int pageNo, int pageSize,Site site,String queryCode);
	public PageInfo findPageAll(int pageNo, int pageSize);
	public PageInfo findPublicAll(int pageNo, int pageSize,Site site);
	public PageInfo quickSearch(String str, int pageNo, int pageSize);
	public PageInfo findProjectMiningBySiteId(String str,String sitecode, int pageNo, int pageSize);
	public PageInfo findByToDo(String str,User user, int pageNo, int pageSize);
	public int findCount(User user);
	public int findDataCount(Site site);
	public int findDataCount(Site site,Date startTime,Date endTime);

	public int findByUser(User user);
	public int findByUser(User user,Date startTime,Date endTime);
}

