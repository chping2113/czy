package com.kjlink.ahpips.dao.project.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.brady.common.page.PageInfo;
import com.kjlink.ahpips.dao.impl.BaseDAOImpl;
import com.kjlink.ahpips.dao.project.ProjectCoderDAO;
import com.kjlink.ahpips.entity.project.ProjectCoder;
import com.kjlink.ahpips.entity.system.User;

@Component("projectCoderDAO")
public class ProjectCoderDAOImpl extends BaseDAOImpl<ProjectCoder> implements ProjectCoderDAO{
	public ProjectCoderDAOImpl() {
		super(ProjectCoder.class);
	}
	public PageInfo quickSearch(String str, int pageNo, int pageSize){
		String tmp = str == null ? "" : str;
	
	String hql = "from ProjectCoder pc where pc.projectName like ? order by pc.id desc";
	return this.findPageInfoByHql(pageNo, pageSize, hql, new String[] {"%"+tmp+"%"});
		
	}
	
	

	public boolean checkProjectName(String projectName,int id){
		String hql = "from ProjectCoder pc where pc.projectName='"+projectName+"'";
		if(id>0){
			hql+=" and pc.id!="+id;
		}

		List<ProjectCoder> list=this.findByHql(hql);
		if(list.size()>0){
			return true;
			
		}else{
			return false;
		}
	}
}
