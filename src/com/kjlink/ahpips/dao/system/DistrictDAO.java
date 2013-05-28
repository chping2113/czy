/** 
  * @title:  
  * @description:   
  * @copyright: 凯捷技术有限公司 
  * @author: 
  * @version: 1.0
  * @created: 2010-09-20
*/

package com.kjlink.ahpips.dao.system;

import java.util.List;

import com.brady.common.dao.CommonDAO;
import com.kjlink.ahpips.entity.system.District;

/**
 * 
 * 作者：brady.zh
 * 创建：2010-11-11
 */
public interface DistrictDAO extends CommonDAO<District> {
	public District findRootDistrict();
	public List<District> searchDistrictForQucik(String queryCode);
}
