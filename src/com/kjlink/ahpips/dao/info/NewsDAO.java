/** 
  * @title:  
  * @description:   
  * @copyright: ���ݼ������޹�˾ 
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
 * ���ߣ�brady.zh
 * ������2010-11-11
 */
public interface NewsDAO extends CommonDAO<News> {
	public PageInfo quickSearch(Integer catelogId, String str, int pageNo, int pageSize);
	
	/**
	 * ������ĿID��������
	 */
	public PageInfo findPageByNewsCatelogId(Integer catelogId, int pageNo, int pageSize);
	
	/**
	 * �������������ȡָ�������ķ�ͼƬ����
	 */
	public List<News> findNonImageNews(int count);
	
	/**
	 * �������������ȡָ��������ͼƬ����
	 */
	public List<News> findImageNews(int count);
}
