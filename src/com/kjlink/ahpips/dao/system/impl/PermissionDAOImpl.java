/** 
  * @title:  
  * @description:   
  * @copyright: ���ݼ������޹�˾ 
  * @author: 
  * @version: 1.0
  * @created: 2010-09-20
*/

package com.kjlink.ahpips.dao.system.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.kjlink.ahpips.dao.impl.BaseDAOImpl;
import com.kjlink.ahpips.dao.system.PermissionDAO;
import com.kjlink.ahpips.entity.system.Permission;
import com.kjlink.ahpips.entity.system.Permission;


/**
 * 
 * ���ߣ�brady.zh
 * ������2010-11-4
 */

@Component("permissionDAO")
public class PermissionDAOImpl extends BaseDAOImpl<Permission> implements PermissionDAO {
	public PermissionDAOImpl() {
		super(Permission.class);
	}
	
	public List<Permission> findAll() {
		String hql = "from Permission res  order by res.position";
		return this.findByHql(hql);
	}
	/**
	 * ����ϵͳ��ȫ����һ����Դ�б�
	 * @return
	 */
	public List<Permission> findFirstLevelPermission() {
		String hql = "from Permission res where res.parent is null " +
				" and res.displayed = 1 order by res.position";
		return this.findByHql(hql);
	}

	public List<Permission> findChildPermissions(Integer parentId) {
		String hql = "from Permission res where res.parent.id=? " +
				" and res.displayed = 1 order by res.position";
		return this.findByHql(hql, new Integer[]{parentId});
	}

	public List<Permission> findSecondLevelPermission() {
		String hql = "from Permission res where res.parent.parent is null " +
				" and res.displayed = 1 order by res.parent.position, res.position";
		return this.findByHql(hql);
	}


	public List<Permission> findFirstLevelPermissionByRoleId(Integer roleId) {
		String hql = "select distinct res from Permission res join res.roles r " +
				" where res.parent is null " +
				" and res.displayed = 1  and r.id=" + roleId + " order by res.position";
		return this.findByHql(hql);
	}
	
	/**
	 * ������һ����ԴID����Ӧ��Role ID���صڶ�����Դ�б�
	 * @param firstLevelPermissionId
	 * @param roleIds
	 * @return
	 */
	public List<Permission> findSecondLevelPermissionByRoleId(Integer firstLevelPermissionId, Integer roleId) {
		String hql = "select distinct res from Permission res join res.roles r " +
				" where res.parent.id= " + firstLevelPermissionId +
				" and res.displayed = 1 and res.checkState = 1 and r.id = " + roleId + " order by res.position";
		return this.findByHql(hql);
	}
	
	/**
	 * �鿴ϵͳ�в���Ҫ����Ȩ����֤�����е�URL
	 * @return
	 */
	public List<String> findIgnoreAuthURLs() {
		String hql = "from Permission r where r.ignoreAuth=1";
		List<Permission> resList = this.findByHql(hql);
		List<String> ignores = new ArrayList<String>(resList.size());
		for(Permission r : resList) {
			ignores.add(r.getUrl());
		}
		return ignores;
	}
	
	public int getChildNodesCount(Integer id) {
		String hql = "select count(*) from Permission r where r.parent.id =" + id;
		List list = this.findByHql(hql);
		String num = String.valueOf(list.get(0));
		return Integer.parseInt(num);
	}
	
	//��Ŀ����
	@SuppressWarnings("unchecked")
	public List<Permission> findProjectbyParentId(Integer id) {
		String hql = "from Permission res where res.parent.id= " +id +
				" and res.displayed = 1 order by res.parent.position, res.position";
		return this.findByHql(hql);
	}
	
	@SuppressWarnings("unchecked")
	public List<Permission> findProjectbyParentId2(Integer id) {
		String hql = "from Permission res where res.parent.id= " +id +
				" and res.displayed = 1 and res.checkState=1 order by res.id";
		return this.findByHql(hql);
	}


	
}
