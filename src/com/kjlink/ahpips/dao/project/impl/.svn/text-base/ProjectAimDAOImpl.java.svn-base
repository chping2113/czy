package com.kjlink.ahpips.dao.project.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.brady.common.page.PageInfo;
import com.kjlink.ahpips.Constants;
import com.kjlink.ahpips.dao.impl.BaseDAOImpl;
import com.kjlink.ahpips.dao.project.ProjectAimDAO;
import com.kjlink.ahpips.entity.project.ProjectAim;
import com.kjlink.ahpips.entity.system.Site;
import com.kjlink.ahpips.entity.system.User;

@Component("projectAimDAO")
public class ProjectAimDAOImpl extends BaseDAOImpl<ProjectAim> implements ProjectAimDAO {
	public ProjectAimDAOImpl() {
		super(ProjectAim.class);
	}

	public PageInfo findProjectAimBySiteId(String str,String sitecode, int pageNo, int pageSize){
		String tmp = str == null ? "" : str;
		
		String hql = "from ProjectAim pro where ( pro.name like ? or pro.code like ?  ";
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
			hql += " and pro.site.code = '"+sitecode+"'";
		}
		hql+=" order by pro.id desc";
		return this.findPageInfoByHql(pageNo, pageSize, hql, new String[] {"%"+tmp+"%","%"+tmp+"%"});
	}

	public List<ProjectAim> findProjectAimForPulbic(int count,Site site){
		String hql = "from ProjectAim pl where 1=1 ";
//		if(!Constants.ANHUI.equals(site.getCode()) && site.getType() == 1 || "340000004".equals(site.getCode()) || "340000023".equals(site.getCode()) || "340000027".equals(site.getCode())){
//			hql += " and ( pl.site.parent.id in (select o.parent.id from Site o where o.parent.id="+site.getId()+")  or pl.site.id="+site.getId()+" ) ";
//		}else if(site.getType() == 0){
//			hql += " and pl.site.id="+site.getId();
//		}
		if(!Constants.ANHUI.equals(site.getCode())){
			hql+=" and pl.site.id in (select o.id from Site o where o.id="+site.getId()+" or o.parent.id="+site.getId()+" or o.parent.parent.id="+site.getId()+")";
			
		}
		hql += "  and pl.state=1  order by pl.createTime desc,pl.id desc";
		return this.findByHql(hql, count);
	}

	public PageInfo findPublicAll(int pageNo, int pageSize,Site site){
		String hql = "from ProjectAim pl where 1=1 " ;
//		if(!Constants.ANHUI.equals(site.getCode()) && site.getType() == 1 || "340000004".equals(site.getCode()) || "340000023".equals(site.getCode()) || "340000027".equals(site.getCode())){
//			hql += " and ( pl.site.parent.id in (select o.parent.id from Site o where o.parent.id="+site.getId()+")  or pl.site.id="+site.getId()+" ) ";
//		}else if(site.getType() == 0){
//			hql += " and pl.site.id="+site.getId();
//		}
		if(!Constants.ANHUI.equals(site.getCode())){
			hql+=" and pl.site.id in (select o.id from Site o where o.id="+site.getId()+" or o.parent.id="+site.getId()+" or o.parent.parent.id="+site.getId()+")";
			
		}
		hql += " and pl.state=1 order by pl.createTime desc,pl.id desc";
		return this.findPageInfoByHql(pageNo, pageSize, hql);
	}

	public PageInfo findPublicAllByName(int pageNo, int pageSize,Site site,String queryCode){
		String hql = "from ProjectAim pa where 1=1  " ;
//		if(!Constants.ANHUI.equals(site.getCode()) && site.getType() == 1 || "340000004".equals(site.getCode()) || "340000023".equals(site.getCode()) || "340000027".equals(site.getCode())){
//			hql += " and ( pa.site.parent.id in (select o.parent.id from Site o where o.parent.id="+site.getId()+")  or pl.site.id="+site.getId()+" ) ";
//		}else if(site.getType() == 0){
//			hql += " and pa.site.id="+site.getId();
//		}
		if(!Constants.ANHUI.equals(site.getCode())){
			hql+=" and pa.site.id in (select o.id from Site o where o.id="+site.getId()+" or o.parent.id="+site.getId()+" or o.parent.parent.id="+site.getId()+")";
			
		}
		hql += " and (pa.name like ? or pa.code like ? ) and pa.state=1 order by pa.createTime desc,pa.id desc";
		return this.findPageInfoByHql(pageNo, pageSize, hql, new String[]{"%" + queryCode + "%","%" + queryCode + "%"});
	}
	/**
	 * 查找当前组织机构及其子类发布数量 
	 */
	public int findDataCount(Site site){

		String hql = "select count(*) from ProjectAim pl where ( pl.site.id="+site.getId()+" or (pl.site.parent.id="+site.getId()+" and pl.site.type=0)) and pl.state=1 ";

		List list = this.findByHql(hql);
		String num = String.valueOf(list.get(0));
		return Integer.parseInt(num);
	}

	/**
	 * 查找当前组织机构发布数量 
	 */
	public int findDataCount(Site site,Date startTime,Date endTime){
		String hql = "select count(*) from ProjectAim pl where pl.site.id="+site.getId()+" and pl.state=1 ";
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
		String hql = "select count(*) from ProjectAim pl where  pl.createUser.id="+user.getId()+"  and pl.state=1 ";

		List list = this.findByHql(hql);
		String num = String.valueOf(list.get(0));
		return Integer.parseInt(num);
		
	}

	public int findByUser(User user,Date startTime,Date endTime){

		String hql = "select count(*) from ProjectAim pl where  pl.createUser.id="+user.getId()+"  and pl.state=1 ";
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
