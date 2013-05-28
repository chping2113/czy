/** 
  * @title:  
  * @description:   
  * @copyright: ���ݼ������޹�˾ 
  * @author: 
  * @version: 1.0
  * @created: 2010-09-20
*/

package com.kjlink.ahpips.service.system;

import java.util.*;
import com.brady.common.page.PageInfo;
import com.kjlink.ahpips.entity.system.*;
import com.kjlink.ahpips.service.BaseService;

/**
 * 
 * ���ߣ�brady.zh
 * ������2010-11-11
 */
public interface UserService extends BaseService<User> {
	public PageInfo findPageAll(int pageNo, int pageSize);
	public PageInfo findPageAllBySite(int pageNo, int pageSize,User user ,String queryCode );
	
	public PageInfo searchUsersByCode(String code, int pageNo, int pageSize);
	
	public User findByCode(String code); //�����û��ʺŷ���Ψһ���û�����
	
	public boolean isValidUser(String code, String password); //�����û��ʺź���������ʺ��ǲ�����Ч���ʺ�
	
	public List<User> findUsersByRoleName(String roleName); //���ݽ�ɫ���Ʋ��Ҹý�ɫ������û�
	
	public boolean checkUserInRole(User user, String roleName); //�ж��û��ǲ�����ָ���Ľ�ɫ��
	
	
	/**
	 * ���ݽ�ɫID���ظý�ɫ�µ��û�ID���û������ӳ��
	 * @param roleId
	 * @return
	 */
	public Map<Integer, User> findUserIdNameMapByRoleId(Integer roleId);
	
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
