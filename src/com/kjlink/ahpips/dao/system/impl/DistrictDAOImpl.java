/** 
  * @title:  
  * @description:   
  * @copyright: 凯捷技术有限公司 
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
 * 作者：brady.zh
 * 创建：2010-11-4
 */

@Component("districtDAO")
public class DistrictDAOImpl extends BaseDAOImpl<District> implements DistrictDAO {
	public DistrictDAOImpl() {
		super(District.class);
	}

	public District findRootDistrict() {
		String hql = "from District d where d.parent is null";
		List<District> list = this.findByHql(hql);
		return list.size() > 0 ? list.get(0) : null;
	}
	
	public List<District> searchDistrictForQucik(String queryCode){
		queryCode = queryCode == null ? "" : queryCode;
		String hql = "from District dis where 1=1 " +
				"and (dis.name like ? or dis.code like ?) order by dis.code desc ";
		return this.findByHql(hql, new String[]{"%" + queryCode + "%", "%" + queryCode + "%"});
	}

}
