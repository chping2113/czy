/** 
  * @title:  
  * @description:   
  * @copyright: 凯捷技术有限公司 
  * @author: 
  * @version: 1.0
  * @created: 2010-09-20
*/

package com.kjlink.ahpips.dao.info.impl;

import org.springframework.stereotype.Component;

import com.brady.common.page.PageInfo;
import com.kjlink.ahpips.dao.impl.BaseDAOImpl;
import com.kjlink.ahpips.dao.info.TaskDAO;
import com.kjlink.ahpips.entity.info.Task;
import com.kjlink.ahpips.entity.system.Site;
import com.kjlink.ahpips.entity.system.Site;


/**
 * 
 * 作者：brady.zh
 * 创建：2010-11-4
 */

@Component("taskDAO")
public class TaskDAOImpl extends BaseDAOImpl<Task> implements TaskDAO {
	public TaskDAOImpl() {
		super(Task.class);
	}

	public PageInfo findPageAll(int pageNo, int pageSize) {
		String hql = "from Task u order by u.id desc";
		return this.findPageInfoByHql(pageNo, pageSize, hql);
	}

	public PageInfo todoList(String str,int pageNo, int pageSize,Site site){
		String tmp = str == null ? "" : str;
		String hql = "from Task u where u.title like ? and  u.state!=1 and u.site.id="+site.getId()+" order by u.id desc";

		return this.findPageInfoByHql(pageNo, pageSize, hql, new Object[]{ "%"+tmp+"%"});
		
	}
	public PageInfo quickSearch( String str, int pageNo, int pageSize) {
		String tmp = str == null ? "" : str;
		
		String hql = "from Task u where  u.title like ? order by u.id desc";
		return this.findPageInfoByHql(pageNo, pageSize, hql, new Object[]{ "%"+tmp+"%"});
	}
	public int findCount(Site site){
		String hql = "from Task u where u.state!=1 and u.site.id="+site.getId()+" order by u.id desc";
		return this.findByHql(hql).size();
	}
	

}
