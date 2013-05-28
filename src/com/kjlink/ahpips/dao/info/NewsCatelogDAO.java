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
public interface NewsCatelogDAO extends CommonDAO<NewsCatelog> {
	/**
	 * 显示全部栏目
	 */
	public PageInfo findPageAll(int pageNo, int pageSize) ;
	
	/**
	 * 显示全部一级栏目
	 */
	public PageInfo findFirstLevelPageAll(int pageNo, int pageSize) ;
	
	/**
	 * 显示全部二级栏目
	 */
	public PageInfo findSecondLevelPageAll(Integer parentId, int pageNo, int pageSize) ;
	
	public PageInfo quickSearch(String str, int pageNo, int pageSize);
	
	public List<NewsCatelog> findSecondCatelogsByParentId(Integer parentId);
}
