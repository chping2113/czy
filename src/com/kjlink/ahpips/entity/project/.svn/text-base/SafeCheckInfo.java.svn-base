package com.kjlink.ahpips.entity.project;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

@Entity
@Table(name="t_safe_check_info")//质量安全检查信息表
public class SafeCheckInfo implements java.io.Serializable {
	private static final long serialVersionUID = 0L;
	
	@Id
	@GeneratedValue(generator = "paymentableGenerator")       
	@GenericGenerator(name = "paymentableGenerator", strategy = "native")    
	private Integer id;
	
	@Lob
	@Column(name="charge_person")
	private String chargePerson ;//工程项目质量安全监督机构及质量安全监督负责人
	
	@Lob
	@Column(name="check_content")
	private String checkContent ;//评定结果
	
	@Lob
	@Column(name="identify_result")
	private String identifyResult ;//项目质量鉴定

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getChargePerson() {
		return chargePerson;
	}

	public void setChargePerson(String chargePerson) {
		//this.chargePerson = chargePerson;
		this.chargePerson = Jsoup.clean(chargePerson, Whitelist.basic());
	}

	public String getCheckContent() {
		return checkContent;
	}

	public void setCheckContent(String checkContent) {
		//this.checkContent = checkContent;
		this.checkContent = Jsoup.clean(checkContent, Whitelist.basic());
	}

	public String getIdentifyResult() {
		return identifyResult;
	}

	public void setIdentifyResult(String identifyResult) {
		//this.identifyResult = identifyResult;
		this.identifyResult = Jsoup.clean(identifyResult, Whitelist.basic());
	}
	
}
