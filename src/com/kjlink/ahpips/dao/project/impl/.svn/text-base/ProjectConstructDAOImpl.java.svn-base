package com.kjlink.ahpips.dao.project.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.brady.common.page.PageInfo;
import com.kjlink.ahpips.Constants;
import com.kjlink.ahpips.dao.impl.BaseDAOImpl;
import com.kjlink.ahpips.dao.project.ProjectConstructDAO;
import com.kjlink.ahpips.entity.project.Project;
import com.kjlink.ahpips.entity.project.ProjectApprove;
import com.kjlink.ahpips.entity.project.ProjectConstruct;
import com.kjlink.ahpips.entity.system.Construct;
import com.kjlink.ahpips.entity.system.Site;
import com.kjlink.ahpips.entity.system.User;

@Component("projectConstructDAO")
public class ProjectConstructDAOImpl extends BaseDAOImpl<ProjectConstruct> implements ProjectConstructDAO {

	public ProjectConstructDAOImpl() {
		super(ProjectConstruct.class);
	}
	
	public List<ProjectConstruct> findProjectConstructByProject(Project project){
		String hql = "from ProjectConstruct pc where pc.project.id="+project.getId();
		return this.findByHql(hql);
	}
	
	public List<ProjectConstruct> findProjectConstructForPulbic(int count,Site site){
		String hql = "from ProjectConstruct pc where 1=1 ";
//		if(!Constants.ANHUI.equals(site.getCode()) && site.getType() == 1   || "340000004".equals(site.getCode()) || "340000023".equals(site.getCode()) || "340000027".equals(site.getCode())){
//			hql += " and ( pc.site.parent.id in ( select o.parent.id from Site o where o.parent.id="+site.getId()+") or pc.site.id="+site.getId()+" )";
//		}else if(site.getType() == 0){
//			hql += " and pc.site.id="+site.getId();
//		}
		if(!Constants.ANHUI.equals(site.getCode())){
			hql+=" and pc.site.id in (select o.id from Site o where o.id="+site.getId()+" or o.parent.id="+site.getId()+" or o.parent.parent.id="+site.getId()+")";
			
		}
		hql += "  and pc.state=1 order by pc.createTime desc,pc.id desc";
		return this.findByHql(hql,count);
	}
	
	public PageInfo findPageAll(int pageNo, int pageSize){
		String hql = "from ProjectConstruct pc order by pc.id desc";
		return this.findPageInfoByHql(pageNo, pageSize, hql);
	}
	
	public PageInfo findPublicAll(int pageNo, int pageSize,Site site){
		String hql = "from ProjectConstruct pc where 1=1 ";
//		if(!Constants.ANHUI.equals(site.getCode()) && site.getType() == 1  || "340000004".equals(site.getCode()) || "340000023".equals(site.getCode()) || "340000027".equals(site.getCode())){
//			hql += " and ( pc.site.parent.id in ( select o.parent.id from Site o where o.parent.id="+site.getId()+") or pc.site.id="+site.getId()+" )";
//		}else if(site.getType() == 0){
//			hql += " and pc.site.id="+site.getId();
//		}
		if(!Constants.ANHUI.equals(site.getCode())){
			hql+=" and pc.site.id in (select o.id from Site o where o.id="+site.getId()+" or o.parent.id="+site.getId()+" or o.parent.parent.id="+site.getId()+")";
			
		}
		hql += "  and pc.state=1  order by pc.createTime desc,pc.id desc";
		return this.findPageInfoByHql(pageNo, pageSize, hql);
	}
	public PageInfo findPublicAllByName(int pageNo, int pageSize,Site site,String queryCode){
		String hql = "from ProjectConstruct pc where 1=1 ";
//		if(!Constants.ANHUI.equals(site.getCode()) && site.getType() == 1  || "340000004".equals(site.getCode()) || "340000023".equals(site.getCode()) || "340000027".equals(site.getCode())){
//			hql += " and ( pc.site.parent.id in ( select o.parent.id from Site o where o.parent.id="+site.getId()+") or pc.site.id="+site.getId()+" )";;
//		}else if(site.getType() == 0){
//			hql += " and pc.site.id="+site.getId();
//		}
		if(!Constants.ANHUI.equals(site.getCode())){
			hql+=" and pc.site.id in (select o.id from Site o where o.id="+site.getId()+" or o.parent.id="+site.getId()+" or o.parent.parent.id="+site.getId()+")";
			
		}
		hql += " and (pc.name like ? or pc.code like ? ) and pc.state=1  order by pc.createTime desc,pc.id desc";
		return this.findPageInfoByHql(pageNo, pageSize, hql, new String[]{"%" + queryCode + "%","%" + queryCode + "%"});
	}

	public PageInfo quickSearch(String str, int pageNo, int pageSize) {
		String tmp = str == null ? "" : str;
		
		String hql = "from ProjectConstruct pc where pc.name like ? order by pc.id desc";
		return this.findPageInfoByHql(pageNo, pageSize, hql, new String[] {"%"+tmp+"%"});
	}

	public PageInfo findProjectConstructBySiteId(String str, String sitecode,
			int pageNo, int pageSize) {
		String tmp = str == null ? "" : str;
		String hql = "from ProjectConstruct pc where ( pc.name like ? or pc.code like ? ";
		if(tmp.equals(Constants.STATE0)){
			hql+=" or pc.state=0 )";
		}else if(tmp.equals(Constants.STATE1)){
			hql+=" or pc.state=1 )";
		}else if(tmp.equals(Constants.STATE2)){
			hql+=" or pc.state=2 )";
		}else if(tmp.equals(Constants.STATE3)){
			hql+=" or pc.state=3 )";
		}else{
			hql+=" ) ";
		}
		if(sitecode!=null && !sitecode.equals("")){
			hql += " and pc.site.code= '"+sitecode+"'";
		}

		hql+=" order by pc.id desc";
		return this.findPageInfoByHql(pageNo, pageSize, hql, new String[] {"%"+tmp+"%","%"+tmp+"%"});
	}

	public List<ProjectApprove> findProjectByName(String queryCode){
		queryCode = queryCode == null?"":queryCode;
		String hql = "from ProjectConstruct pro where pro.state=1 and (pro.name like ? or pro.code like ?) order by pro.id desc";
		return this.findByHql(hql, new String[]{"%" + queryCode + "%","%" + queryCode + "%"});
	}
	public List<ProjectApprove> findProjectByNameAndSitecode(String queryCode,String sitecode){
		queryCode = queryCode == null?"":queryCode;
		sitecode = sitecode == null?"":sitecode;
		String hql = "from ProjectConstruct pro where pro.state=1 and (pro.name like ? or pro.code like ?) and pro.site.code=? order by pro.id desc";
		if(sitecode.equals(Constants.EDUCATION_CODE) || sitecode.equals(Constants.HYGIENE_CODE) || sitecode.equals(Constants.NATIONAL_CODE)){
			hql = "from ProjectConstruct pro where pro.state=1 and (pro.name like ? or pro.code like ?) and (pro.site.code=? or pro.site.parent.code=?) order by pro.id desc";
			return this.findByHql(hql, new String[]{"%" + queryCode + "%","%" + queryCode + "%",sitecode,sitecode});
		}
		return this.findByHql(hql, new String[]{"%" + queryCode + "%","%" + queryCode + "%",sitecode});
	}

	public PageInfo findProjectConstructByConstruct(String str,Construct construct, int pageNo, int pageSize){
		String tmp = str == null ? "" : str;
		String hql = "from ProjectConstruct pc where pc.name like ? and pc.construct.id="+construct.getId()+" order by pc.id desc";
		
		
		return this.findPageInfoByHql(pageNo, pageSize, hql, new String[] {"%"+tmp+"%"});
	}

	public PageInfo findByToDo(String str,User user, int pageNo, int pageSize){
		String tmp = str == null ? "" : str;
		String hql = "from ProjectConstruct pc where pc.name like ? and pc.site.code=? and (pc.approveUser.id="+user.getId()+" or pc.approveUser=null) and pc.state=3 order by pc.id desc";
		return this.findPageInfoByHql(pageNo, pageSize, hql, new String[] {"%"+tmp+"%",user.getSite().getCode()});
	}
	public int findCount(User user){
		String hql = "select count(*) from ProjectConstruct pc where pc.site.id="+user.getSite().getId()+" and (pc.approveUser.id="+user.getId()+" or pc.approveUser=null) and pc.state=3 order by pc.id desc";

		List list = this.findByHql(hql);
		String num = String.valueOf(list.get(0));
		return Integer.parseInt(num);
	}
	/**
	 * 查找当前组织机构及其子类发布数量 
	 */
	public int findDataCount(Site site){
		String hql = "select count(*) from ProjectConstruct pc where ( pc.site.id="+site.getId()+" or (pc.site.parent.id="+site.getId()+" and pc.site.type=0)) and pc.state=1 ";

		List list = this.findByHql(hql);
		String num = String.valueOf(list.get(0));
		return Integer.parseInt(num);
		
	}

	/**
	 * 查找当前组织机构发布数量
	 */
	public int findDataCount(Site site,Date startTime,Date endTime){
		String hql = "select count(*) from ProjectConstruct pc where pc.site.id="+site.getId()+" and pc.state=1 ";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
		String time1="";
		String time2="";
		if(startTime!=null){
			time1=sdf.format(startTime);
			hql+=" and pc.createTime >='"+time1+"'";
		}
		if(endTime!=null){
			time2=sdf.format(endTime);
			hql+=" and pc.createTime <='"+time2+"'";
		}
		List list = this.findByHql(hql);
		String num = String.valueOf(list.get(0));
		return Integer.parseInt(num);
	}

	public int findByUser(User user){

		String hql = "select count(*) from ProjectConstruct pc where pc.site.id="+user.getSite().getId()+" and pc.createUser.id="+user.getId()+"  and pc.state=1 order by pc.id desc";

		List list = this.findByHql(hql);
		String num = String.valueOf(list.get(0));
		return Integer.parseInt(num);
	}

	public int findByUser(User user,Date startTime,Date endTime){

		String hql = "select count(*) from ProjectConstruct pc where pc.site.id="+user.getSite().getId()+" and pc.createUser.id="+user.getId()+"  and pc.state=1 ";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
		String time1="";
		String time2="";
		if(startTime!=null){
			time1=sdf.format(startTime);
			hql+=" and pc.createTime >='"+time1+"'";
		}
		if(endTime!=null){
			time2=sdf.format(endTime);
			hql+=" and pc.createTime <='"+time2+"'";
		}
		List list = this.findByHql(hql);
		String num = String.valueOf(list.get(0));
		return Integer.parseInt(num);
	}
}
