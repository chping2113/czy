/** 
 * @title:  
 * @description:   
 * @copyright: 凯捷技术有限公司 
 * @author: 
 * @version: 1.0
 * @created: 2010-09-20
 */

package com.kjlink.ahpips.entity.system;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "t_role")
@Proxy(lazy = false)
public class Role implements java.io.Serializable {
	/**
	 * 角色表
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "paymentableGenerator")       
	@GenericGenerator(name = "paymentableGenerator", strategy = "native")    
	@Column(length = 32)
	private Integer id;// 编号

	@Column(length = 100)
	private String name;// 名称

	@Column(length = 200)
	private String descrip; // 角色描述

	private Integer type;// 1、管理员角色 2、政府部门用户角色 3、项目建设单位角色

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "t_role_permission", joinColumns = @JoinColumn(name = "role_id"), inverseJoinColumns = @JoinColumn(name = "permission_id"))
	private Set<Permission> permissions;

	// @ManyToMany(mappedBy="roles", cascade={CascadeType.PERSIST,
	// CascadeType.MERGE})
	// private Set<User> users;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Set<Permission> getPermissions() {
		return permissions;
	}

	public Integer getId() {
		return id;
	}

	public void setPermissions(Set<Permission> permissions) {
		this.permissions = permissions;
	}

	public String getDescrip() {
		return descrip;
	}

	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}
}
