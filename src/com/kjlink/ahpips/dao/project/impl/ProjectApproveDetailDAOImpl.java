package com.kjlink.ahpips.dao.project.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.brady.common.page.PageInfo;
import com.kjlink.ahpips.Constants;
import com.kjlink.ahpips.dao.impl.BaseDAOImpl;
import com.kjlink.ahpips.dao.project.ProjectApproveDetailDAO;
import com.kjlink.ahpips.entity.project.ProjectApprove;
import com.kjlink.ahpips.entity.project.ProjectApproveDetail;
import com.kjlink.ahpips.entity.system.Site;
import com.kjlink.ahpips.entity.system.User;

@Component("projectApproveDetailDAO")
public class ProjectApproveDetailDAOImpl extends BaseDAOImpl<ProjectApproveDetail> implements ProjectApproveDetailDAO{

	public ProjectApproveDetailDAOImpl() {
		super(ProjectApproveDetail.class);
	}
	public List<ProjectApproveDetail> findByProjectApprove(ProjectApprove projectApprove){
		String hql = "from ProjectApproveDetail pad where pad.projectApprove.id="+projectApprove.getId();
		return this.findByHql(hql);
		
	}
	public List<ProjectApproveDetail> findByProjectApprove(ProjectApprove projectApprove,Site site){
		String hql = "from ProjectApproveDetail pad where pad.projectApprove.id="+projectApprove.getId()+" and pad.site.id="+site.getId();
		return this.findByHql(hql);
		
	}
	public List<ProjectApproveDetail> findProjectApproveDetailForPulbic(int count,Site site){
		//String hql = "from ProjectApprove pa where pa.id="+site.getId()+" and pa.state=1 order by pa.createTime desc,pa.id desc";
		//try{
		// return this.findByHql(hql,count);
		//}catch(Exception e){
		 // e.printStackTrace();
		//}
		//return null;
/*		String hql = null;
		long flag_p = 0;
		long flag_c = 0;
		
		String hql_p ="from Site o where o.parent.parent.parent.id="+site.getId()+"";
		String hql_c ="from Site o where o.parent.parent.id="+site.getId()+"";
		
		flag_p = this.getCountByHql(hql_p);
		flag_c = this.getCountByHql(hql_c);
		
		if(flag_p>0){
			hql = "from ProjectApproveDetail pa where 1=1 and pa.site.id in (select o.id from Site o where o.id="+site.getId()+" or o.parent.id="+site.getId()+" or o.parent.parent.id="+site.getId()+")" +
					" and pa.projectApprove.state_p=1 order by pa.createTime desc,pa.id desc";
			return this.findByHql(hql,count);
		}
		else if((flag_c>0) && (flag_p<=0)){
			hql = "from ProjectApproveDetail pa where 1=1 and pa.site.id in (select o.id from Site o where o.id="+site.getId()+" or o.parent.id="+site.getId()+")" +
					" and pa.projectApprove.state_c=1 order by pa.createTime desc,pa.id desc";
			return this.findByHql(hql,count);
		}
		
		hql = "from ProjectApproveDetail pa where 1=1 and pa.site.id in (select o.id from Site o where o.id="+site.getId()+") and pa.projectApprove.state=1 order by pa.createTime desc,pa.id desc";
		return this.findByHql(hql,count);*/
		
		String hql = "from ProjectApproveDetail pa where 1=1 ";
//		 if(!Constants.ANHUI.equals(site.getCode()) && site.getType() == 1 || "340000004".equals(site.getCode()) || "340000023".equals(site.getCode()) || "340000027".equals(site.getCode())){
//			//hql += " and ( pa.site.parent.id in (select o.parent.id from Site o where o.parent.id="+site.getId()+") or pa.site.id="+site.getId()+" ) ";
//			hql+=" and pa.site.id in (select o.id from Site o where o.id="+site.getId()+" or o.parent.id="+site.getId()+" or o.parent.parent.id="+site.getId()+")";
//		}else if(site.getType() == 0){
//			hql += " and pa.site.id="+site.getId();
//		}
		//if(!Constants.ANHUI.equals(site.getCode())){
			//hql+=" and pa.site.id in (select o.id from Site o where o.id="+site.getId()+" or o.parent.id="+site.getId()+" or o.parent.parent.id="+site.getId()+")";
			hql+=" and pa.site.id ="+site.getId();
		//}
		hql += " and pa.projectApprove.state=1 order by pa.createTime desc,pa.id desc";
		return this.findByHql(hql,count);
	}
	public PageInfo findPublicAll(int pageNo, int pageSize,Site site){
		String hql = "from ProjectApproveDetail pa where 1=1 " ;
		if(!Constants.ANHUI.equals(site.getCode())){
			hql+=" and pa.site.id in (select o.id from Site o where o.id="+site.getId()+" or o.parent.id="+site.getId()+" or o.parent.parent.id="+site.getId()+")";
			
		}
//		 if((!Constants.ANHUI.equals(site.getCode()) && site.getType() == 1)  || "340000004".equals(site.getCode()) || "340000023".equals(site.getCode()) || "340000027".equals(site.getCode())){
//			//hql += " and ( pa.site.parent.id in (select o.parent.id from Site o where o.parent.id="+site.getId()+") or pa.site.id="+site.getId()+" ) ";
//			hql+=" and pa.site.id in (select o.id from Site o where o.id="+site.getId()+" or o.parent.id="+site.getId()+" or o.parent.parent.id="+site.getId()+")";
//		}else if(site.getType() == 0){
//			hql += " and pa.site.id="+site.getId();
//		}
		hql += " and pa.projectApprove.state=1 order by pa.createTime desc,pa.id desc";
		return this.findPageInfoByHql(pageNo, pageSize, hql);
	}
	public PageInfo findPublicAllByName(int pageNo, int pageSize,Site site,String queryCode){
		String hql = "from ProjectApproveDetail pa where 1=1 " ;
//		 if(!Constants.ANHUI.equals(site.getCode()) && site.getType() == 1  || "340000004".equals(site.getCode()) || "340000023".equals(site.getCode()) || "340000027".equals(site.getCode())){
//			//hql += " and ( pa.site.parent.id in (select o.parent.id from Site o where o.parent.id="+site.getId()+") or pa.site.id="+site.getId()+" ) ";
//			hql+=" and pa.site.id in (select o.id from Site o where o.id="+site.getId()+" or o.parent.id="+site.getId()+" or o.parent.parent.id="+site.getId()+")";
//		}else if(site.getType() == 0){
//			hql += " and pa.site.id="+site.getId();
//		}	
		if(!Constants.ANHUI.equals(site.getCode())){
			hql+=" and pa.site.id in (select o.id from Site o where o.id="+site.getId()+" or o.parent.id="+site.getId()+" or o.parent.parent.id="+site.getId()+")";
			
		}
		hql += " and (pa.projectApprove.name like ? or pa.projectApprove.code like ? ) and pa.projectApprove.state=1 order by pa.createTime desc,pa.id desc";
		return this.findPageInfoByHql(pageNo, pageSize, hql, new String[]{"%" + queryCode + "%","%" + queryCode + "%"});
	
	}

	public int findDataCount(Site site){

		String hql = "select count(*) from ProjectApproveDetail pad where  ( pad.site.id="+site.getId()+" or (pad.site.parent.id="+site.getId()+" and pad.site.type=0))";

		List list = this.findByHql(hql);
		String num = String.valueOf(list.get(0));
		return Integer.parseInt(num);
	}
	public int findDataCount(Site site,Date startTime,Date endTime){
		String hql = "select count(*) from ProjectApproveDetail pad where pad.site.id="+site.getId();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
		String time1="";
		String time2="";
		if(startTime!=null){
			time1=sdf.format(startTime);
			hql+=" and pad.createTime >='"+time1+"'";
		}
		if(endTime!=null){
			time2=sdf.format(endTime);
			hql+=" and pad.createTime <='"+time2+"'";
		}
		List list = this.findByHql(hql);
		String num = String.valueOf(list.get(0));
		return Integer.parseInt(num);
		
	}

	public int findByUser(User user){
		String hql = "select count(*) from ProjectApproveDetail pad where   pad.projectApprove.createUser.id="+user.getId();

		List list = this.findByHql(hql);
		String num = String.valueOf(list.get(0));
		return Integer.parseInt(num);
	}

	public int findByUser(User user,Date startTime,Date endTime){
		String hql = "select count(*) from ProjectApproveDetail pad where   pad.projectApprove.createUser.id="+user.getId();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
		String time1="";
		String time2="";
		if(startTime!=null){
			time1=sdf.format(startTime);
			hql+=" and pad.createTime >='"+time1+"'";
		}
		if(endTime!=null){
			time2=sdf.format(endTime);
			hql+=" and pad.createTime <='"+time2+"'";
		}
		List list = this.findByHql(hql);
		String num = String.valueOf(list.get(0));
		return Integer.parseInt(num);
	}

	
}
