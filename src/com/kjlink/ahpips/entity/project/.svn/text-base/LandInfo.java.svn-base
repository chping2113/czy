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

import com.kjlink.common.util.ConvertHtml;

@Entity
@Table(name = "t_land_info")//征地拆迁信息表
public class LandInfo implements java.io.Serializable {
	private static final long serialVersionUID = 0L;
	
	@Id
	@GeneratedValue(generator = "paymentableGenerator")       
	@GenericGenerator(name = "paymentableGenerator", strategy = "native")    
	private Integer id;
	
	@Column(length=20,name="charge_person")
	private String chargePerson ; //征地拆迁负责人
	
	@Column(length=200)
	private String link ; //负责人联系方式
	
	@Lob
	private String approve ; //项目用地审批意见
	
	@Lob
	@Column(name="land_notice")
	private String landNotice ; //征地拆迁公告
	
	@Lob
	private String principle ; //工作方法原则
	@Lob
	@Column(name="land_design")
	private String landDesign ; //项目设计征地
	
	@Column(name="recoup_money")
	private Double recoupMoney ;//已支付的拆迁补偿费用总额

	public String getLandDesign() {
		return landDesign;
	}

	public void setLandDesign(String landDesign) {
		this.landDesign = landDesign;
	}

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
		this.chargePerson = ConvertHtml.convertInputText(chargePerson);
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		//this.link = link;
		this.link = ConvertHtml.convertInputText(link);
	}

	public String getApprove() {
		return approve;
	}

	public void setApprove(String approve) {
		//this.approve = approve;
		this.approve = Jsoup.clean(approve, Whitelist.basic());
	}

	public String getLandNotice() {
		return landNotice;
	}

	public void setLandNotice(String landNotice) {
		//this.landNotice = landNotice;
		this.landNotice = Jsoup.clean(landNotice, Whitelist.basic());
	}

	public String getPrinciple() {
		return principle;
	}

	public void setPrinciple(String principle) {
		//this.principle = principle;
		this.principle = Jsoup.clean(principle, Whitelist.basic());
	}

	public Double getRecoupMoney() {
		return recoupMoney;
	}

	public void setRecoupMoney(Double recoupMoney) {
		this.recoupMoney = recoupMoney;
	}
}
