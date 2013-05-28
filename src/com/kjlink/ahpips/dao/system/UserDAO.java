/** 
  * @title:  
  * @description:   
  * @copyright: ���ݼ������޹�˾ 
  * @author: 
  * @version: 1.0
  * @created: 2010-09-20
*/

package com.kjlink.ahpips.dao.system;

import java.util.List;

import com.brady.common.dao.CommonDAO;
import com.brady.common.page.PageInfo;
import com.kjlink.ahpips.entity.system.Site;
import com.kjlink.ahpips.entity.system.Site;
import com.kjlink.ahpips.entity.system.User;

/**
 * 
 * ���ߣ�brady.zh
 * ������2010-11-11
 */
public interface UserDAO extends CommonDAO<User> {
	public PageInfo findPageAll(int pageNo, int pageSize);

	public PageInfo findPageAllBySite(int pageNo, int pageSize,User user,String queryCode);
	
	List<User> findUsersByRoleName(String roleName); //���ݽ�ɫ���Ʋ��Ҹý�ɫ������û�
	
	public PageInfo searchUsersByCode(String code, int pageNo, int pageSize);
	
	/**
	 * ��������Ƿ��Ѿ�ʹ��
	 * @param email
	 * @return
	 */
	public boolean checkEmailExists(String email);

	public boolean checkEmailExistsEdit(String email,int id);

	public List<User> findApproveUser(Site site);
	public List<User> findBySite(Site site);
}
