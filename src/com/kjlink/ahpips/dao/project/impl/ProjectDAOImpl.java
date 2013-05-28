package com.kjlink.ahpips.dao.project.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.brady.common.page.PageInfo;
import com.kjlink.ahpips.dao.impl.BaseDAOImpl;
import com.kjlink.ahpips.dao.project.ProjectDAO;
import com.kjlink.ahpips.entity.project.Project;

@Component("projectDAO")
public class ProjectDAOImpl extends BaseDAOImpl<Project> implements ProjectDAO {

	public ProjectDAOImpl() {
		super(Project.class);
	}

	public PageInfo findPageAll(int pageNo, int pageSize,String queryStr){
		String str = queryStr == null ? "" : queryStr;
		String hql = "from Project pro where pro.name like ? order by pro.id desc";
		return this.findPageInfoByHql(pageNo, pageSize, hql,new String[]{"%"+str+"%"});
	}
	
	public PageInfo findApprovePageAll(int pageNo, int pageSize,String queryStr){
		String str = queryStr == null ? "" : queryStr;
		String hql = "from Project pro where pro.state=1 and pro.name like ? order by pro.id desc";
		return this.findPageInfoByHql(pageNo, pageSize, hql,new String[]{"%"+str+"%"});
	}
	
	public List<Project> findByName(String str){
		str = str == null?"":str;
		String hql = "from Project pro where pro.name like ? or pro.code like ? order by pro.id desc";
		return this.findByHql(hql, new String[]{"%" + str + "%","%" + str + "%"});
	}
	
	public List<Project> findByCode(String code){
		String hql = "from Project pro where pro.code='"+code+"'";
		return this.findByHql(hql);
	}
}
