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
public interface NewsDAO extends CommonDAO<News> {
	public PageInfo quickSearch(Integer catelogId, String str, int pageNo, int pageSize);
	
	/**
	 * 根据栏目ID查找新闻
	 */
	public PageInfo findPageByNewsCatelogId(Integer catelogId, int pageNo, int pageSize);
	
	/**
	 * 返回最近发布的取指定数量的非图片新闻
	 */
	public List<News> findNonImageNews(int count);
	
	/**
	 * 返回最近发布的取指定数量的图片新闻
	 */
	public List<News> findImageNews(int count);
}
