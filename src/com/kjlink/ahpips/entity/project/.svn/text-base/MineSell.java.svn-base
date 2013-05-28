package com.kjlink.ahpips.entity.project;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import com.kjlink.common.util.ConvertHtml;

@Entity
@Table(name="t_mine_sell")//采矿权出让信息表
public class MineSell implements java.io.Serializable {
	private static final long serialVersionUID = 0L;
	
	@Id
	@GeneratedValue(generator = "paymentableGenerator")       
	@GenericGenerator(name = "paymentableGenerator", strategy = "native")    
	private Integer id;
	
	@Column(length=50,name="mine_name")
	private String mineName ;//采矿权名称
	
	@Column(length=50,name="mine_type")
	private String mineType ;//矿种
	@Column(length=200)
	private String area ;//面积
	
	@Column(length=150)
	private String jingweidu ;//经纬度拐点坐标
	
	@Column(length=50,name="sell_type")
	private String sellType ;//出让方式
	
	@Column(name="bid_base_money")
	private Double bidBaseMoney ;//起拍价
	
	@Column(name="bid_margin")
	private Double bidMargin ;//竞买保证金
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "bid_time")
	private Date bidTime; //拍卖时间

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMineName() {
		return mineName;
	}

	public void setMineName(String mineName) {
		//this.mineName = mineName;
		this.mineName = ConvertHtml.convertInputText(mineName); 
	}

	public String getMineType() {
		return mineType;
	}

	public void setMineType(String mineType) {
		//this.mineType = mineType;
		this.mineType = ConvertHtml.convertInputText(mineType); 
	}



	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		//this.area = area;
		this.area = ConvertHtml.convertInputText(area); 
	}

	public String getJingweidu() {
		return jingweidu;
	}

	public void setJingweidu(String jingweidu) {
		//this.jingweidu = jingweidu;
		this.jingweidu = ConvertHtml.convertInputText(jingweidu); 
	}

	public String getSellType() {
		return sellType;
	}

	public void setSellType(String sellType) {
		//this.sellType = sellType;
		this.sellType = ConvertHtml.convertInputText(sellType); 
	}

	public Double getBidBaseMoney() {
		return bidBaseMoney;
	}

	public void setBidBaseMoney(Double bidBaseMoney) {
		this.bidBaseMoney = bidBaseMoney;
	}

	public Double getBidMargin() {
		return bidMargin;
	}

	public void setBidMargin(Double bidMargin) {
		this.bidMargin = bidMargin;
	}

	public Date getBidTime() {
		return bidTime;
	}

	public void setBidTime(Date bidTime) {
		this.bidTime = bidTime;
	}
	
	
}
