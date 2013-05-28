/** 
  * @title:  
  * @description:   
  * @copyright: 凯捷技术有限公司 
  * @author: 
  * @version: 1.0
  * @created: 2010-09-20
*/

package com.kjlink.ahpips.dao.info.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.brady.common.page.PageInfo;
import com.kjlink.ahpips.Constants;
import com.kjlink.ahpips.dao.impl.BaseDAOImpl;
import com.kjlink.ahpips.dao.info.*;
import com.kjlink.ahpips.entity.info.*;
import com.kjlink.ahpips.entity.system.Site;
import com.kjlink.ahpips.entity.system.Site;


/**
 * 
 * 作者：brady.zh
 * 创建：2010-11-4
 */

@Component("noticeDAO")
public class NoticeDAOImpl extends BaseDAOImpl<Notice> implements NoticeDAO {
	public NoticeDAOImpl() {
		super(Notice.class);
	}
	
	public PageInfo findPageAllSite(int pageNo, int pageSize,Site site) {
		String hql = "from Notice u where u.createUser.site.id="+site.getId()+" order by u.id desc";
		if(site.getCode().equals(Constants.ANHUI) || site.getCode().equals("340000099")){
			hql=" from Notice u order by u.id desc ";
		}
		return this.findPageInfoByHql(pageNo, pageSize, hql);
	}

	public PageInfo quickSearch(String str, int pageNo, int pageSize,Site  site) {
		String tmp = str == null ? "" : str;
		
		String hql = "from Notice u where u.title like ? and u.createUser.site.id="+site.getId()+"  order by u.id desc";
		if(site.getCode().equals(Constants.ANHUI) || site.getCode().equals("340000099")){
			hql = "from Notice u where u.title like ?  order by u.id desc";
		}
		return this.findPageInfoByHql(pageNo, pageSize, hql, new String[] {"%"+tmp+"%"});
	}
	
	/**
	 * 返回最近发布的取指定数量的公告
	 */
	public List<Notice> findNotice(int count) {
		String hql = "from Notice u order by u.createTime desc";
		return this.findByHql(hql, count);
	}

	public PageInfo findParentNotice(String str, int pageNo, int pageSize,Site site){
		String tmp = str == null ? "" : str;
		String hql = "from Notice n where n.title like ? and  n.createUser.site.id in (select o.id from Site o where o.id="+site.getId();
		if(site.getParent()!=null){
			hql+=" or o.id="+site.getParent().getId();
			if(site.getParent().getParent()!=null){
				hql+=" or o.id="+site.getParent().getParent().getId();
				if(site.getParent().getParent().getParent()!=null){
					hql+=" or o.id="+site.getParent().getParent().getParent().getId();
				}
			}
		}
		hql+=" or o.code='340000099' ) order by n.createTime desc";
		return this.findPageInfoByHql(pageNo, pageSize, hql, new String[] {"%"+tmp+"%"});
	}

	public List<Notice> findBySite(Site site,int count){
		String hql = "from Notice n where n.createUser.site.id in (select o.id from Site o where o.id="+site.getId();
		if(site.getParent()!=null){
			hql+=" or o.id="+site.getParent().getId();
			if(site.getParent().getParent()!=null){
				hql+=" or o.id="+site.getParent().getParent().getId();
				if(site.getParent().getParent().getParent()!=null){
					hql+=" or o.id="+site.getParent().getParent().getParent().getId();
				}
			}
		}
		hql+=" or o.code='340000099' ) order by n.createTime desc";
		return this.findByHql(hql, count);
		
	}
	
	/**
	 * 返回最近发布的指定的浮动公告
	 * @param count
	 * @return
	 */
	public List<Notice> findFloatNotice(Site site,int count) {
		String hql = "from Notice n where n.floatShow=1 and n.floatEndTime >= ? and n.createUser.site.id in (select o.id from Site o where o.id="+site.getId();
		if(site.getParent()!=null){
			hql+=" or o.id="+site.getParent().getId();
			if(site.getParent().getParent()!=null){
				hql+=" or o.id="+site.getParent().getParent().getId();
				if(site.getParent().getParent().getParent()!=null){
					hql+=" or o.id="+site.getParent().getParent().getParent().getId();
				}
			}
		}
		hql+=" or o.code='340000099' ) order by n.createTime desc";
		return this.findByHql(hql, new Date[] {new java.util.Date()}, count);
	}
}
