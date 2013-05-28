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
import com.kjlink.ahpips.Constants;
import com.kjlink.ahpips.dao.impl.BaseDAOImpl;
import com.kjlink.ahpips.dao.system.UserDAO;
import com.kjlink.ahpips.entity.system.Site;
import com.kjlink.ahpips.entity.system.Site;
import com.kjlink.ahpips.entity.system.User;


/**
 * 
 * 作者：brady.zh
 * 创建：2010-11-4
 */

@Component("userDAO")
public class UserDAOImpl extends BaseDAOImpl<User> implements UserDAO {
	public UserDAOImpl() {
		super(User.class);
	}

	public PageInfo findPageAll(int pageNo, int pageSize) {
		String hql = "from User u order by u.id desc";
		return this.findPageInfoByHql(pageNo, pageSize, hql);
	}

	public PageInfo findPageAllBySite(int pageNo, int pageSize,User user,String queryCode){

		queryCode = queryCode == null ? "" : queryCode;
		String hql = "from  User u where 1=1 " ;
		if(user.getRole().getType()!=1)
			hql += " and u.site.id="+user.getSite().getId();
		hql += " and (u.code like ? or u.site.name like ? ) order by u.id desc";
		return this.findPageInfoByHql(pageNo, pageSize, hql, new String[]{"%" + queryCode + "%","%" + queryCode + "%"});
	}
	public List<User> findUsersByRoleName(String roleName) {
		String hql = "select r.users from SysRole r where r.name=?";
		return this.findByHql(hql, new String[] {roleName});
	}

	public PageInfo searchUsersByCode(String code, int pageNo, int pageSize) {
		code = code == null ? "" : code;
		
		String hql = "from User u where u.code like ? order by u.id desc";
		return this.findPageInfoByHql(pageNo, pageSize, hql, new String[] {"%"+code+"%"});
	}

	/**
	 * 检查邮箱是否已经使用
	 * @param email
	 * @return
	 */
	public boolean checkEmailExists(String email) {
		return this.findUniqueResultByProperty("email", email) != null;
	}

	public boolean checkEmailExistsEdit(String email,int id){

		String hql = "from User u where u.email='"+email+"' and u.id!="+id;

		List<User> list=this.findByHql(hql);
		if(list.size()>0){
			return true;
			
		}else{
			return false;
		}
	}

	public List<User> findApproveUser(Site site){
		String hql="from User u where u.site.id="+site.getId()+" and "+Constants.APPROVE_ROLE;
		return this.findByHql(hql);
	}

	public List<User> findBySite(Site site){
		String hql="from User u where u.site.id="+site.getId();
		return this.findByHql(hql);
	}
}
