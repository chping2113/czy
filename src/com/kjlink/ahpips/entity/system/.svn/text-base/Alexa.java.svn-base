package com.kjlink.ahpips.entity.system;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.kjlink.common.util.ConvertHtml;



@Entity
@Table(name = "t_alexa")
public class Alexa implements java.io.Serializable {
	private static final long serialVersionUID = 0L;
	
	@Id
	@GeneratedValue(generator = "paymentableGenerator")       
	@GenericGenerator(name = "paymentableGenerator", strategy = "native")    
	private Integer id;
	
	@Column(length = 200)
	private String title;
	
	@Column(length = 200)
	private String url;
	
	@Column(length = 20)
	private String type;
	
	@Column(length = 20)
	private String person;
	
	@Column(length = 20)
	private String page;
	
	@Column(length = 20)
	private String personPage;
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		//this.title = title;
		this.title = ConvertHtml.convertInputText(title);
	}
	public String getPerson() {
		return person;
	}
	public void setPerson(String person) {
		this.person = person;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public String getPersonPage() {
		return personPage;
	}
	public void setPersonPage(String personPage) {
		this.personPage = personPage;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		//this.url = url;
		this.url = ConvertHtml.convertInputText(url);
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
