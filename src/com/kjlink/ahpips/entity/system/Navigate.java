package com.kjlink.ahpips.entity.system;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.kjlink.common.util.ConvertHtml;

@Entity
@Table(name = "t_navigate")
public class Navigate implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator = "paymentableGenerator")       
	@GenericGenerator(name = "paymentableGenerator", strategy = "native")    
	private Integer id;
	@Column(length = 200)
	private String name;
	@Column(length = 100)
	private String url;
	@Column(name = "show_order")
	private Integer showOrder; // 显示顺序
	private Integer type; //

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "parent_navigate_id")
	private Navigate parent; // 上级机构

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "site_id")
	private Site site; // 所属机构

	public Navigate getParent() {
		return parent;
	}

	public void setParent(Navigate parent) {
		this.parent = parent;
	}

	public Integer getShowOrder() {
		return showOrder;
	}

	public void setShowOrder(Integer showOrder) {
		this.showOrder = showOrder;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		// this.name = name;
		this.name = ConvertHtml.convertInputText(name);
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		// this.url = url;
		this.url = ConvertHtml.convertInputText(url);
	}

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

}
