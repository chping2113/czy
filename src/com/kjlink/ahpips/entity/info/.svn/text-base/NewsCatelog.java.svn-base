package com.kjlink.ahpips.entity.info;

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
@Table(name = "t_news_catelog")
public class NewsCatelog implements java.io.Serializable {
	private static final long serialVersionUID = 0L;
	
	@Id
	@GeneratedValue(generator = "paymentableGenerator")       
	@GenericGenerator(name = "paymentableGenerator", strategy = "native")    
	private Integer id;
	
	@Column(length = 50)
	private String title; //标题
	
	@Column(length = 200)
	private String descrip; //描述
	
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="parent_id")
	private NewsCatelog parent; //上级栏目
	
	private Integer state = 1; //有效状态,1:有效，0：无效
	
	@Column(name="show_order")
	private Integer showOrder = 1; //显示位置顺序

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		//this.title = title;
		this.title = ConvertHtml.convertInputText(title);
	}

	public String getDescrip() {
		return descrip;
	}

	public void setDescrip(String descrip) {
		//this.descrip = descrip;
		this.descrip = ConvertHtml.convertInputText(descrip);
	}

	public NewsCatelog getParent() {
		return parent;
	}

	public void setParent(NewsCatelog parent) {
		this.parent = parent;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getShowOrder() {
		return showOrder;
	}

	public void setShowOrder(Integer showOrder) {
		this.showOrder = showOrder;
	}


}
