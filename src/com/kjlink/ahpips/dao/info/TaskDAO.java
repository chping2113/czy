/** 
  * @title:  
  * @description:   
  * @copyright: ���ݼ������޹�˾ 
  * @author: 
  * @version: 1.0
  * @created: 2010-09-20
*/

package com.kjlink.ahpips.dao.info;

import com.brady.common.dao.CommonDAO;
import com.brady.common.page.PageInfo;
import com.kjlink.ahpips.entity.info.Task;
import com.kjlink.ahpips.entity.system.Site;
import com.kjlink.ahpips.entity.system.Site;

/**
 * 
 * ���ߣ�brady.zh
 * ������2010-11-11
 */
public interface TaskDAO extends CommonDAO<Task> {
	public PageInfo quickSearch(String str, int pageNo, int pageSize);
	public PageInfo todoList(String str,int pageNo, int pageSize,Site site);
	public int findCount(Site site);
	
	
}
