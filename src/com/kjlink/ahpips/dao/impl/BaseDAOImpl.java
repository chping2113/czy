/** 
  * @title:  
  * @description:   
  * @copyright: ���ݼ������޹�˾ 
  * @author: 
  * @version: 1.0
  * @created: 2010-09-20
*/

package com.kjlink.ahpips.dao.impl;

import org.apache.commons.logging.*;
import com.brady.common.dao.CommonDAOImpl;
import com.kjlink.ahpips.dao.BaseDAO;

/**
 * 
 * ���ߣ�brady.zh
 * ������2010-11-10
 */
public abstract class BaseDAOImpl<T> extends CommonDAOImpl<T> implements BaseDAO<T> {
	protected Log log = LogFactory.getLog(this.getClass()); //ͳһ��Logʵ��
	
	public BaseDAOImpl(Class entityClass) {
		super(entityClass);
	}
	
}
