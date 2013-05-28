package com.kjlink.ahpips.entity.project;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

import com.kjlink.common.util.ConvertHtml;

@Entity
@Table(name="t_land_sell")//国有土地使用权出让合同信息表
public class LandSell implements java.io.Serializable {
	private static final long serialVersionUID = 0L;
	
	@Id
	@GeneratedValue(generator = "paymentableGenerator")       
	@GenericGenerator(name = "paymentableGenerator", strategy = "native")    
	private Integer id;
	
	@Column(length=100,name="transferee_name")
	private String transfereeName ;//受让方名称
	
	@Column(length=200)
	private String location ;//土地位置
	@Column(length=200)
	private String area ;//土地面积
	
	@Column(name="capacity_rate")
	private String capacityRate ;//容积率
	
	@Lob
	@Column(name="plan_application")
	private String planApplication ;//规划用途
	
	@Column(name="transaction_price")
	private String transactionPrice ;//土地成交价格
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "sign_time")
	private Date signTime; //签约时间

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTransfereeName() {
		return transfereeName;
	}

	public void setTransfereeName(String transfereeName) {
		//this.transfereeName = transfereeName;
		this.transfereeName = ConvertHtml.convertInputText(transfereeName);
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		//this.location = location;
		this.location = ConvertHtml.convertInputText(location);
	}



	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		//this.area = area;
		this.area = ConvertHtml.convertInputText(area);
	}


	public String getPlanApplication() {
		return planApplication;
	}

	public void setPlanApplication(String planApplication) {
		//this.planApplication = planApplication;
		this.planApplication = Jsoup.clean(planApplication, Whitelist.basic());
	}

	
	public String getCapacityRate() {
		return capacityRate;
	}

	public void setCapacityRate(String capacityRate) {
		//this.capacityRate = capacityRate;
		this.capacityRate = ConvertHtml.convertInputText(capacityRate);
	}

	public String getTransactionPrice() {
		return transactionPrice;
	}

	public void setTransactionPrice(String transactionPrice) {
		//this.transactionPrice = transactionPrice;
		this.transactionPrice = ConvertHtml.convertInputText(transactionPrice);
	}

	public Date getSignTime() {
		return signTime;
	}

	public void setSignTime(Date signTime) {
		this.signTime = signTime;
	}
	
}
