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
import com.kjlink.ahpips.entity.system.*;

/**
 * 
 * ���ߣ�brady.zh
 * ������2010-11-11
 */
public interface RoleDAO extends CommonDAO<Role> {
	/**
	 * �������Ʋ�Ψһ�Ķ���
	 * @param name
	 * @return
	 */
	public Role findByName(String name);
	 
	/**
	 * ��������ģ����ѯ
	 * @param pageNo
	 * @param pageSize
	 * @param name
	 * @return
	 */
	public PageInfo searchByName(int pageNo, int pageSize, String name);
	
	/**
	 * ���ݽ�ɫID�鿴���Ӧ���û���Ϣ
	 * @param pageNo
	 * @param pageSize
	 * @param code
	 * @param name
	 * @return
	 */
	public PageInfo findUsersByRoleId(int pageNo, int pageSize, Integer roleId); 

	public PageInfo findUsersByRoleId(int pageNo, int pageSize, int roleId,String str);
	public List<User> findUsersByRoleId(Integer roleId);
}
