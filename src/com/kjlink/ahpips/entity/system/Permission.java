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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "t_permission")
// @Proxy(lazy = false)
public class Permission implements java.io.Serializable {
	/**
	 * 权限表
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "paymentableGenerator")       
	@GenericGenerator(name = "paymentableGenerator", strategy = "native")    
	private Integer id;// 编号

	@Column(length = 50)
	private String title; // 资源标题

	@Column(length = 500)
	private String url; // 访问URL

	private Integer displayed = 1; // 表示该资源是否显示在权限配置页面上,1:显示，0：不显示

	private Integer position = 1; // 用来控制显示的位置，页面按其值从小到大向下排列

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "parent_res_id")
	private Permission parent;

	@Column(length = 1)
	private Integer state;// 状态

	

	@ManyToMany(mappedBy = "permissions", cascade = { CascadeType.PERSIST,
			CascadeType.MERGE })
	private Set<Role> roles;

	// 选中与否
	private Integer checkState = 1;// 0:未选中,1:选中

	public Integer getCheckState() {
		return checkState;
	}

	public void setCheckState(Integer checkState) {
		this.checkState = checkState;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Permission getParent() {
		return parent;
	}

	public void setParent(Permission parent) {
		this.parent = parent;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getDisplayed() {
		return displayed;
	}

	public void setDisplayed(Integer displayed) {
		this.displayed = displayed;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

}
