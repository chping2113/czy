package com.kjlink.ahpips.dao.project.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.brady.common.page.PageInfo;
import com.kjlink.ahpips.dao.impl.BaseDAOImpl;
import com.kjlink.ahpips.dao.project.ProjectIssueDAO;
import com.kjlink.ahpips.entity.project.KeyProject;
import com.kjlink.ahpips.entity.project.KeyProjectKind;
import com.kjlink.ahpips.entity.project.ProjectConstruct;

@Component("projectIssueDAO")
public class ProjectIssueDAOImpl extends BaseDAOImpl<KeyProject> implements ProjectIssueDAO {
	public ProjectIssueDAOImpl() {
		super(KeyProject.class);
	}
	
	public PageInfo findPageAll(int pageNo, int pageSize) {
		String hql = "from KeyProject u order by u.id desc";
		return this.findPageInfoByHql(pageNo, pageSize, hql);
	}

	public PageInfo quickSearch(int keyid, String str, int pageNo, int pageSize) {
		String tmp = str == null ? "" : str;
		
		String hql = "from KeyProject u where u.projectConstruct.name like ? and u.keyProjectKind.id= "+keyid+" order by u.id desc";
		return this.findPageInfoByHql(pageNo, pageSize, hql,new String[] { "%"+tmp+"%" });
	}
	
	public List<KeyProject> findProjectIdByKindId(KeyProjectKind keyProjectKind){
		String hql = "from KeyProject u where u.keyProjectKind.id = "+keyProjectKind.getId()+" order by u.createDate desc";
		return this.findByHql(hql);
	}
	public List<KeyProject> findProjectConstruct(ProjectConstruct projectConstruct){
		String hql = "from KeyProject u where u.projectConstruct.id = "+projectConstruct.getId()+" order by u.createDate desc";
		return this.findByHql(hql);
	}
	public PageInfo findPageAllByKeyId(int pageNo, int pageSize, int keyid) {
		String hql = "from KeyProject u where u.keyProjectKind.id = "+keyid+" order by u.id desc";
		return this.findPageInfoByHql(pageNo, pageSize, hql);
	}
	
	public List<KeyProject> isValidProjectKeyId(int keyId, String proId){
		String hql = "from KeyProject u where u.keyProjectKind.id = "+keyId+" and u.projectConstruct.id="+proId;
		return this.findByHql(hql);
	}
}
