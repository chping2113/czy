package com.kjlink.ahpips.dao.project.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.kjlink.ahpips.dao.impl.BaseDAOImpl;
import com.kjlink.ahpips.dao.project.ProjectApproveFlowDAO;
import com.kjlink.ahpips.entity.project.ProjectApprove;
import com.kjlink.ahpips.entity.project.ProjectApproveFlow;
import com.kjlink.ahpips.entity.system.Site;
@Component("projectApproveFlowDAO")
public class ProjectApproveFlowDAOImpl extends BaseDAOImpl<ProjectApproveFlow> implements ProjectApproveFlowDAO {

	public ProjectApproveFlowDAOImpl() {
		super(ProjectApproveFlow.class);
	}

	public List<ProjectApproveFlow> findByProjectApprove(ProjectApprove projectApprove){
		String hql = "from ProjectApproveFlow paf where paf.projectApprove.id="+projectApprove.getId();
		return this.findByHql(hql);
	}

	public List<ProjectApproveFlow> findByProjectApprove(ProjectApprove projectApprove,Site site){
		String hql = "from ProjectApproveFlow paf where (paf.state=1 or paf.state=2) and paf.projectApprove.id="+projectApprove.getId()+" and paf.site.id="+site.getId();
		return this.findByHql(hql);
	}
	public int findDataCount(Site site){
		String hql = "from ProjectApproveFlow paf where (paf.state=1 or paf.state=2)  and paf.site.id="+site.getId();
		return this.findByHql(hql).size();
	}

}
