package com.kjlink.ahpips.entity.system;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * ������������ʵ����
 * @author brady
 *
 */
@Entity
@Table(name = "t_district")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class District  implements java.io.Serializable {
	private static final long serialVersionUID = 0L;
	
	@Id
	@Column(length = 6)
	private String code; //��������
	
	@Column(length = 50)
	private String name; //��������
	
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="parent_code")
	private District parent; //�ϼ�����

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

	public District getParent() {
		return parent;
	}

	public void setParent(District parent) {
		this.parent = parent;
	}
}
