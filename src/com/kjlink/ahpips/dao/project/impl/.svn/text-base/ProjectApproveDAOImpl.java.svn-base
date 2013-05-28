package com.kjlink.ahpips.dao.project.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.brady.common.page.PageInfo;
import com.kjlink.ahpips.Constants;
import com.kjlink.ahpips.dao.impl.BaseDAOImpl;
import com.kjlink.ahpips.dao.project.ProjectApproveDAO;
import com.kjlink.ahpips.entity.project.Project;
import com.kjlink.ahpips.entity.project.ProjectApprove;
import com.kjlink.ahpips.entity.system.Site;
import com.kjlink.ahpips.entity.system.User;

@Component("projectApproveDAO")
public class ProjectApproveDAOImpl extends BaseDAOImpl<ProjectApprove> implements ProjectApproveDAO {

	public ProjectApproveDAOImpl() {
		super(ProjectApprove.class);
	}
	
	public List<ProjectApprove> findProjectApproveByProject(Project project){
		String hql = "from ProjectApprove pa where pa.project.id="+project.getId();
		return this.findByHql(hql);
	}
	
	public List<ProjectApprove> findProjectApproveForPulbic(int count,Site site){
		String hql = "from ProjectApprove pa where 1=1" ;
		if(site.getType() == 0){
			hql += " and pa.site.id="+site.getId();
		}else if(!Constants.ANHUI.equals(site.getCode()) && site.getType() == 1){
			hql += " and pa.site.parent.id in (select o.parent.id from Site o where o.parent.id="+site.getId()+")";
		}
		hql += " and pa.state=1 order by pa.createTime desc";
		return this.findByHql(hql,count);
	}

	public PageInfo findPageAll(int pageNo, int pageSize){
		String hql = "from ProjectApprove pa order by pa.id desc";
		return this.findPageInfoByHql(pageNo, pageSize, hql);
	}
	
	public PageInfo findPublicAll(int pageNo, int pageSize,Site site){
		String hql = "from ProjectApprove pa where 1=1 " ;
		if(site.getType() == 0){
			hql += " and pa.site.id="+site.getId();
		}else if(!Constants.ANHUI.equals(site.getCode()) && site.getType() == 1){
			hql += " and pa.site.parent.id in (select o.parent.id from Site o where o.parent.id="+site.getId()+")";
		}
		hql += " and pa.state=1 order by pa.createTime desc";
		return this.findPageInfoByHql(pageNo, pageSize, hql);
	}
	public PageInfo findPublicAllByName(int pageNo, int pageSize,Site site,String queryCode){
		String hql = "from ProjectApprove pa where 1=1 " ;
		if(site.getType() == 0){
			hql += " and pa.site.id="+site.getId();
		}else if(!Constants.ANHUI.equals(site.getCode()) && site.getType() == 1){
			hql += " and pa.site.parent.id in (select o.parent.id from Site o where o.parent.id="+site.getId()+")";
		}
		hql += " and (pa.name like ? or pa.code like ? ) and pa.state=1 order by pa.createTime desc";
		return this.findPageInfoByHql(pageNo, pageSize, hql, new String[]{"%" + queryCode + "%","%" + queryCode + "%"});
	}
	
	public List<ProjectApprove> findProjectByName(String queryCode){
		queryCode = queryCode == null?"":queryCode;
		String hql = "from ProjectApprove pro where pro.state=1 and (pro.name like ? or pro.code like ?) order by pro.id desc";
		return this.findByHql(hql, new String[]{"%" + queryCode + "%","%" + queryCode + "%"});
	}

	public PageInfo quickSearch(String str, int pageNo, int pageSize) {
		String tmp = str == null ? "" : str;
		
		String hql = "from ProjectApprove pro where pro.name like ? order by pro.id desc";
		return this.findPageInfoByHql(pageNo, pageSize, hql, new String[] {"%"+tmp+"%"});
	}

	public PageInfo findProjectApproveBySiteId(String str, String sitecode,
			int pageNo, int pageSize) {
//		String hql = "from ProjectApprove pa where 1=1 " ;
//		if(site.getType() == 0){
//			hql += " and pa.site.id="+site.getId();
//		}else if(!Constants.ANHUI.equals(site.getCode()) && site.getType() == 1){
//			hql += " and pa.site.parent.id in (select o.parent.id from Site o where o.parent.id="+site.getId()+")";
//		}
//		hql += " and pa.state=1 order by pa.createTime desc";
		String tmp = str == null ? "" : str;
		
		String hql = "from ProjectApprove pro where (pro.enable=0 and  pro.name like ? or pro.code like ?   ";
		if(tmp.equals(Constants.STATE0)){
			hql+=" or pro.state=0 )";
		}else if(tmp.equals(Constants.STATE1)){
			hql+=" or pro.state=1 )";
		}else if(tmp.equals(Constants.STATE2)){
			hql+=" or pro.state=2 )";
		}else if(tmp.equals(Constants.STATE3)){
			hql+=" or pro.state=3 )";
		}else{
			hql+=" ) ";
		}
		
		if(sitecode!=null && !sitecode.equals("")){
			hql+=" and  ( pro.id in (select pd.projectApprove.id from ProjectApproveFlow pd where pd.site.code='"+sitecode+"' and (pd.state=1 or pd.state=2)) or pro.site.code = '"+sitecode+"' )";
		    //System.out.println("µ÷ÓÃ");
		}
		hql+="   order by pro.id desc";
		
		return this.findPageInfoByHql(pageNo, pageSize, hql, new String[] {"%"+tmp+"%","%"+tmp+"%"});
		
	}

	public List<ProjectApprove> findProjectByNameAndSitecode(String queryCode,
			String sitecode) {
		queryCode = queryCode == null?"":queryCode;
		sitecode = sitecode == null?"":sitecode;
		String hql = "from ProjectApprove pro where pro.state=1 and (pro.name like ? or pro.code like ?) and pro.site.code=? order by pro.id desc";
		return this.findByHql(hql, new String[]{"%" + queryCode + "%","%" + queryCode + "%",sitecode});
	}

	public PageInfo findByToDo(String str,User user, int pageNo, int pageSize){
		String tmp = str == null ? "" : str;
		
		String hql = "from ProjectApprove pro where pro.name like ? and ( pro.id in (select pd.projectApprove.id from ProjectApproveFlow pd where pd.site.code=? and pd.state=1) or (pro.site.code = ? and (pro.approveUser.id="+user.getId()+" or pro.approveUser=null) and pro.state=3) )   order by pro.id desc";
		
		return this.findPageInfoByHql(pageNo, pageSize, hql, new String[] {"%"+tmp+"%",user.getSite().getCode(),user.getSite().getCode()});
	}

	public int findCount(User user){
		String hql = "from ProjectApprove pro where  pro.id in (select pd.projectApprove.id from ProjectApproveFlow pd where pd.site.id="+user.getSite().getId()+" and pd.state=1) or (pro.site.id = "+user.getSite().getId()+" and (pro.approveUser.id="+user.getId()+" or pro.approveUser=null) and pro.state=3)    order by pro.id desc";
		
		return this.findByHql(hql).size();
	}

	public PageInfo findInfoGrab(String str, String sitecode, String startTime, String endTime,
			int pageNo, int pageSize, Site site) {
		String tmp = str == null ? "" : str;
		String hql = "from ProjectApprove pro where (pro.name like ? or pro.code like ?   ";
		if(tmp.equals(Constants.STATE0)){
			hql+=" or pro.state=0 )";
		}else if(tmp.equals(Constants.STATE1)){
			hql+=" or pro.state=1 )";
		}else if(tmp.equals(Constants.STATE2)){
			hql+=" or pro.state=2 )";
		}else if(tmp.equals(Constants.STATE3)){
			hql+=" or pro.state=3 )";
		}else{
			hql+=" ) ";
		}
		
		if(sitecode!=null && !sitecode.equals("")){
			hql+=" and  ( pro.id in (select pd.projectApprove.id from ProjectApproveFlow pd where pd.site.code='"+sitecode+"' and (pd.state=1 or pd.state=2)) or pro.site.code = '"+sitecode+"' )";
		}
		hql+=" and to_char(pro.createTime,'yyyy-mm-dd') >='"+startTime+"' and to_char(pro.createTime,'yyyy-mm-dd') <='"+endTime+"' order by pro.id desc";
		//hql+=" order by pro.id desc";
		return this.findPageInfoByHql(pageNo, pageSize, hql, new String[] {"%"+tmp+"%","%"+tmp+"%"});
	}
	
	public PageInfo quickFindInfo(String str, String sitecode, String startTime, String endTime,
			int pageNo, int pageSize, Site site, String scolumnName) {
		String tmp = str == null ? "" : str;
		//System.out.println("$$$$$$$$-----3"+startTime);
		//System.out.println("$$$$$$$------4"+endTime);
		//System.out.println("@@@@@@@@-------1111"+scolumnName);
		
		String hql = "from ProjectApprove pro where (pro.name like ? or pro.code like ?   ";
		if(tmp.equals(Constants.STATE0)){
			hql+=" or pro.state=0 )";
		}else if(tmp.equals(Constants.STATE1)){
			hql+=" or pro.state=1 )";
		}else if(tmp.equals(Constants.STATE2)){
			hql+=" or pro.state=2 )";
		}else if(tmp.equals(Constants.STATE3)){
			hql+=" or pro.state=3 )";
		}else{
			hql+=" ) ";
		}
		
		if(sitecode!=null && !sitecode.equals("")){
			hql+=" and  ( pro.id in (select pd.projectApprove.id from ProjectApproveFlow pd where pd.site.code='"+sitecode+"' and (pd.state=1 or pd.state=2)) or pro.site.code = '"+sitecode+"' )";
		}
		hql+=" and pro.scolumn.id in (select s.id from Scolumn s where s.name='"+scolumnName+"' and s.state=1)";
		hql+=" and to_char(pro.createTime,'yyyy-mm-dd') >='"+startTime+"' and to_char(pro.createTime,'yyyy-mm-dd') <='"+endTime+"' order by pro.id desc";
		//hql+="   order by pro.id desc";
		return this.findPageInfoByHql(pageNo, pageSize, hql, new String[] {"%"+tmp+"%","%"+tmp+"%"});
	}
}