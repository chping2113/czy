package com.kjlink.ahpips.entity.system;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * 行业分类代码实体类
 * @author brady
 *
 */
@Entity
@Table(name = "t_catelog")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Catelog {
	private static final long serialVersionUID = 0L;
	
	@Id
	@Column(length = 1)
	private String code; //行业分类代码
	
	@Column(length = 50)
	private String name; //行业分类名称

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
