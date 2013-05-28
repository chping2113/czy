package com.kjlink.ahpips.dao.project.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.kjlink.ahpips.dao.impl.BaseDAOImpl;
import com.kjlink.ahpips.dao.project.ProjectApproveConfigDAO;
import com.kjlink.ahpips.dao.project.ProjectLandDAO;
import com.kjlink.ahpips.entity.project.ProjectApproveConfig;
import com.kjlink.ahpips.entity.project.ProjectLand;
import com.kjlink.ahpips.entity.system.Site;

@Component("projectApproveConfigDAO")
public class ProjectApproveConfigDAOImpl  extends BaseDAOImpl<ProjectApproveConfig> implements ProjectApproveConfigDAO {

	public ProjectApproveConfigDAOImpl() {

		super(ProjectApproveConfig.class);
	}

	public List<ProjectApproveConfig> findByProjectApproveConfigSite(Site site){
		String hql = "from ProjectApproveConfig pac where  pac.site.id="+site.getId();
		if(site.getParent()!=null && site.getType()!=1){
			hql+=" or pac.site.id="+site.getParent().getId();
		}
		return this.findByHql(hql);
	}

}
