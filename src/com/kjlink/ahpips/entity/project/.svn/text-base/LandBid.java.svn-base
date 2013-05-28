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
@Table(name="t_land_bid")//土地招标拍卖挂牌出让信息表
public class LandBid implements java.io.Serializable {
	private static final long serialVersionUID = 0L;
	
	@Id
	@GeneratedValue(generator = "paymentableGenerator")       
	@GenericGenerator(name = "paymentableGenerator", strategy = "native")    
	private Integer id;
	
	@Column(length=200)
	private String location ; //位置
	@Column(length=200)
	private String area ; //土地面积
	
	private String density ; //建筑密度
	
	@Column(name="capacity_rate")
	private String capacityRate ;//容积率
	
	@Lob
	@Column(name="plan_application")
	private String planApplication ;//规划用途
	
	@Column(name="sell_years")
	private String sellRears ;//出让年限
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "bid_begin_time")
	private Date bidBeginTime; //竞价起始时间
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "bid_end_time")
	private Date bidEndTime; //竞价截止时间
	
	@Column(name="bid_base_money")
	private String bidBaseMoney ;//拍卖起叫价
	
	@Column(name="bid_margin")
	private String bidMargin ;//竞买保证金

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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



	public String getSellRears() {
		return sellRears;
	}

	public void setSellRears(String sellRears) {
		//this.sellRears = sellRears;
		this.sellRears = ConvertHtml.convertInputText(sellRears); 
	}

	public Date getBidBeginTime() {
		return bidBeginTime;
	}

	public void setBidBeginTime(Date bidBeginTime) {
		this.bidBeginTime = bidBeginTime;
	}

	public Date getBidEndTime() {
		return bidEndTime;
	}

	public void setBidEndTime(Date bidEndTime) {
		this.bidEndTime = bidEndTime;
	}

	public String getDensity() {
		return density;
	}

	public void setDensity(String density) {
		//this.density = density;
		this.density = ConvertHtml.convertInputText(density); 
	}

	public String getCapacityRate() {
		return capacityRate;
	}

	public void setCapacityRate(String capacityRate) {
		//this.capacityRate = capacityRate;
		this.capacityRate = ConvertHtml.convertInputText(capacityRate); 
	}

	public String getBidBaseMoney() {
		return bidBaseMoney;
	}

	public void setBidBaseMoney(String bidBaseMoney) {
		//this.bidBaseMoney = bidBaseMoney;
		this.bidBaseMoney = ConvertHtml.convertInputText(bidBaseMoney); 
	}

	public String getBidMargin() {
		return bidMargin;
	}

	public void setBidMargin(String bidMargin) {
		//this.bidMargin = bidMargin;
		this.bidMargin = ConvertHtml.convertInputText(bidMargin); 
	}

}
