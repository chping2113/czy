/** 
  * @title:  
  * @description:   
  * @copyright: ���ݼ������޹�˾ 
  * @author: 
  * @version: 1.0
  * @created: 2010-09-20
*/

package com.kjlink.ahpips.dao.system.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.brady.common.page.PageInfo;
import com.kjlink.ahpips.dao.impl.BaseDAOImpl;
import com.kjlink.ahpips.dao.system.*;
import com.kjlink.ahpips.entity.system.*;


/**
 * 
 * ���ߣ�brady.zh
 * ������2010-11-4
 */

@Component("catelogDAO")
public class CatelogDAOImpl extends BaseDAOImpl<Catelog> implements CatelogDAO {
	public CatelogDAOImpl() {
		super(Catelog.class);
	}


}
