package com.kjlink.ahpips.dao.project.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.brady.common.page.PageInfo;
import com.kjlink.ahpips.Constants;
import com.kjlink.ahpips.dao.impl.BaseDAOImpl;
import com.kjlink.ahpips.dao.project.ProjectMiningDAO;
import com.kjlink.ahpips.entity.project.Project;
import com.kjlink.ahpips.entity.project.ProjectMining;
import com.kjlink.ahpips.entity.system.Site;
import com.kjlink.ahpips.entity.system.User;

@Component("projectMiningDAO")
public class ProjectMiningDAOImpl extends BaseDAOImpl<ProjectMining> implements ProjectMiningDAO {

	public ProjectMiningDAOImpl() {
		super(ProjectMining.class);
	}
	

	
	public List<ProjectMining> findProjectMiningForPulbic(int count,Site site){
		String hql = "from ProjectMining pl where 1=1   ";
//		if(!Constants.ANHUI.equals(site.getCode()) && site.getType() == 1 || "340000004".equals(site.getCode()) || "340000023".equals(site.getCode()) || "340000027".equals(site.getCode())){
//			hql += " and ( pl.site.parent.id in (select o.parent.id from Site o where o.parent.id="+site.getId()+") or pl.site.id="+site.getId()+" ) ";
//		}else if(site.getType() == 0){
//			hql += " and pl.site.id="+site.getId();
//		}
		if(!Constants.ANHUI.equals(site.getCode())){
			hql+=" and pl.site.id in (select o.id from Site o where o.id="+site.getId()+" or o.parent.id="+site.getId()+" or o.parent.parent.id="+site.getId()+")";
			
		}
		hql += " and pl.state=1 order by pl.createTime desc,pl.id desc";
		return this.findByHql(hql, count);
	}

	public PageInfo findPublicAllByName(int pageNo, int pageSize,Site site,String queryCode){
		String hql = "from ProjectMining pl where 1=1 " ;
//		if(!Constants.ANHUI.equals(site.getCode()) && site.getType() == 1 || "340000004".equals(site.getCode()) || "340000023".equals(site.getCode()) || "340000027".equals(site.getCode())){
//			hql += " and ( pl.site.parent.id in (select o.parent.id from Site o where o.parent.id="+site.getId()+") or pl.site.id="+site.getId()+" ) ";
//		}else if(site.getType() == 0){
//			hql += " and pl.site.id="+site.getId();
//		}
		if(!Constants.ANHUI.equals(site.getCode())){
			hql+=" and pl.site.id in (select o.id from Site o where o.id="+site.getId()+" or o.parent.id="+site.getId()+" or o.parent.parent.id="+site.getId()+")";
			
		}
		hql += " and (pl.name like ? or pl.code like ? ) and pl.state=1  order by pl.createTime desc,pl.id desc";
		return this.findPageInfoByHql(pageNo, pageSize, hql, new String[]{"%" + queryCode + "%","%" + queryCode + "%"});
	}
	public PageInfo findPageAll(int pageNo, int pageSize){
		String hql = "from ProjectMining pl order by pl.id desc";
		return this.findPageInfoByHql(pageNo, pageSize, hql);
	}
	
	public PageInfo findPublicAll(int pageNo, int pageSize,Site site){
		String hql = "from ProjectMining pl where 1=1 " ;
//		if(!Constants.ANHUI.equals(site.getCode()) && site.getType() == 1 || "340000004".equals(site.getCode()) || "340000023".equals(site.getCode()) || "340000027".equals(site.getCode())){
//			hql += " and ( pl.site.parent.id in (select o.parent.id from Site o where o.parent.id="+site.getId()+") or pl.site.id="+site.getId()+" ) ";
//		}else if(site.getType() == 0){
//			hql += " and pl.site.id="+site.getId();
//		}
		if(!Constants.ANHUI.equals(site.getCode())){
			hql+=" and pl.site.id in (select o.id from Site o where o.id="+site.getId()+" or o.parent.id="+site.getId()+" or o.parent.parent.id="+site.getId()+")";
			
		}
		hql += " and pl.state=1 order by pl.createTime desc,pl.id desc";
		return this.findPageInfoByHql(pageNo, pageSize, hql);
	}

	public PageInfo quickSearch(String str, int pageNo, int pageSize) {
		String tmp = str == null ? "" : str;
		
		String hql = "from ProjectMining pl where pl.project.name like ? order by pl.id desc";
		return this.findPageInfoByHql(pageNo, pageSize, hql, new String[] {"%"+tmp+"%"});
	}
	@Override
	public PageInfo findProjectMiningBySiteId(String str, String sitecode,
			int pageNo, int pageSize) {
		String tmp = str == null ? "" : str;
		
		String hql = "from ProjectMining pl where ( pl.name like ? or pl.code like ? ";
		if(tmp.equals(Constants.STATE0)){
			hql+=" or pl.state=0 )";
		}else if(tmp.equals(Constants.STATE1)){
			hql+=" or pl.state=1 )";
		}else if(tmp.equals(Constants.STATE2)){
			hql+=" or pl.state=2 )";
		}else if(tmp.equals(Constants.STATE3)){
			hql+=" or pl.state=3 )";
		}else{
			hql+=" ) ";
		}
		if(sitecode!=null && !sitecode.equals("")){
			if(!Constants.ANHUI.equals(sitecode))
				hql += " and pl.site.code='"+sitecode+"'";
		}
		hql+=" order by pl.id desc";
		return this.findPageInfoByHql(pageNo, pageSize, hql, new String[] {"%"+tmp+"%","%"+tmp+"%"});
	}
	

	public PageInfo findByToDo(String str,User user, int pageNo, int pageSize){
		String tmp = str == null ? "" : str;
		String hql = "from ProjectMining pl where pl.name like ? and pl.site.code=? and (pl.approveUser.id="+user.getId()+" or pl.approveUser=null)  and pl.state=3 order by pl.id desc";
		return this.findPageInfoByHql(pageNo, pageSize, hql, new String[] {"%"+tmp+"%",user.getSite().getCode()});
	}
	public int findCount(User user){
		String hql = "select count(*) from ProjectMining pl where pl.site.id="+user.getSite().getId()+"  and (pl.approveUser.id="+user.getId()+" or pl.approveUser=null) and pl.state=3 ";

		List list = this.findByHql(hql);
		String num = String.valueOf(list.get(0));
		return Integer.parseInt(num);
		
	}
	/**
	 * 查找当前组织机构及其子类发布数量 
	 */
	public int findDataCount(Site site){
		String hql = "select count(*) from ProjectMining pl where ( pl.site.id="+site.getId()+" or (pl.site.parent.id="+site.getId()+" and pl.site.type=0)) and pl.state=1 ";

		List list = this.findByHql(hql);
		String num = String.valueOf(list.get(0));
		return Integer.parseInt(num);
		
	}
	/**
	 * 查找当前组织机构发布数量 
	 */
	public int findDataCount(Site site,Date startTime,Date endTime){
		String hql = "select count(*) from ProjectMining pl where pl.site.id="+site.getId()+" and pl.state=1 ";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
		String time1="";
		String time2="";
		if(startTime!=null){
			time1=sdf.format(startTime);
			hql+=" and pl.createTime >='"+time1+"'";
		}
		if(endTime!=null){
			time2=sdf.format(endTime);
			hql+=" and pl.createTime <='"+time2+"'";
		}
		List list = this.findByHql(hql);
		String num = String.valueOf(list.get(0));
		return Integer.parseInt(num);
	}


	public int findByUser(User user){

		String hql = "select count(*) from ProjectMining pl where  pl.createUser.id="+user.getId()+" and pl.state=1 ";

		List list = this.findByHql(hql);
		String num = String.valueOf(list.get(0));
		return Integer.parseInt(num);
	}

	public int findByUser(User user,Date startTime,Date endTime){

		String hql = "select count(*) from ProjectMining pl where  pl.createUser.id="+user.getId()+" and pl.state=1 ";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
		String time1="";
		String time2="";
		if(startTime!=null){
			time1=sdf.format(startTime);
			hql+=" and pl.createTime >='"+time1+"'";
		}
		if(endTime!=null){
			time2=sdf.format(endTime);
			hql+=" and pl.createTime <='"+time2+"'";
		}
		List list = this.findByHql(hql);
		String num = String.valueOf(list.get(0));
		return Integer.parseInt(num);
	}
}