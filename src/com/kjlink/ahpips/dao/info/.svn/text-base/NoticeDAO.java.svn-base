/** 
  * @title:  
  * @description:   
  * @copyright: 凯捷技术有限公司 
  * @author: 
  * @version: 1.0
  * @created: 2010-09-20
*/

package com.kjlink.ahpips.dao.info;

import java.util.List;
import com.brady.common.dao.CommonDAO;
import com.brady.common.page.PageInfo;
import com.kjlink.ahpips.entity.info.*;
import com.kjlink.ahpips.entity.system.*;

/**
 * 
 * 作者：brady.zh
 * 创建：2010-11-11
 */
public interface NoticeDAO extends CommonDAO<Notice> {
	public PageInfo quickSearch(String str, int pageNo, int pageSize,Site site);
	
	/**
	 * 返回最近发布的取指定数量的公告
	 */
	public List<Notice> findNotice(int count);

	public PageInfo findPageAllSite(int pageNo, int pageSize,Site site) ;
	/**
	 * 返回最近发布的指定的浮动公告
	 * @param count
	 * @return
	 */
	public List<Notice> findFloatNotice(Site site,int count);
	public List<Notice> findBySite(Site site,int count);

	public PageInfo findParentNotice(String str, int pageNo, int pageSize,Site site);
}
