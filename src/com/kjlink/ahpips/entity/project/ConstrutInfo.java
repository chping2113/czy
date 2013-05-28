package com.kjlink.ahpips.entity.project;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.kjlink.common.util.ConvertHtml;

@Entity
@Table(name="t_construt_info")//施工管理信息表
public class ConstrutInfo implements java.io.Serializable {
	private static final long serialVersionUID = 0L;
	
	@Id
	@GeneratedValue(generator = "paymentableGenerator")       
	@GenericGenerator(name = "paymentableGenerator", strategy = "native")    
	private Integer id;

//	@Lob
//	@Column(name="process_plan")
//	private Integer processPlan ;//项目进度计划
//	
//	@Lob
//	@Column(name="finish_result")
//	private Integer finishResult ;//完成情况
	
	@Column (length=20,name="oneYear")
	private String oneYear;		//第一年

	@Column(length=20,name="yiFir_plan")
	private String yiFirPlan;   //第一年第一季度投资项
	
	@Column(length=20,name="yiFir_Finish")
	private String yiFirFinish;  //完成部分所占比例
	
	@Column(length=20,name="yiLiang_plan")
	private String yiLiangPlan;		//第二季度投资项
	
	@Column(length=20,name="yiLiang_Finish")
	private String yiLiangFinish;	//完成部分所占比例
	
	@Column(length=20,name="yiThi_plan")
	private String yiThiPlan;
	
	@Column(length=20,name="yiThi_Finish")
	private String yiThiFinish;
	
	@Column(length=20,name="yiFor_plan")
	private String yiForPlan;
	
	@Column(length=20,name="yiFor_Finish")
	private String yiForFinish;
	
	@Column (length=20,name="twoYear")
	private String twoYear;		//第二年
	
	@Column(length=20,name="twoFir_plan")
	private String twoFirPlan;   //第二年第一季度投资项
	
	@Column(length=20,name="twoFir_Finish")
	private String twoFirFinish;  //完成部分所占比例
	
	@Column(length=20,name="twoSec_plan")
	private String twoSecPlan;		//第二年第二季度投资项
	
	@Column(length=20,name="twoSec_Finish")
	private String twoSecFinish;	//完成部分所占比例
	
	@Column(length=20,name="twoThi_plan")
	private String twoThiPlan;
	
	@Column(length=20,name="twoThi_Finish")
	private String twoThiFinish;
	
	@Column(length=20,name="twoFor_plan")
	private String twoForPlan;
	
	@Column(length=20,name="twoFor_Finish")
	private String twoForFinish;
	


	public String getYiFirPlan() {
		return yiFirPlan;
	}

	public void setYiFirPlan(String yiFirPlan) {
		this.yiFirPlan = yiFirPlan;
		this.yiFirPlan = ConvertHtml.convertInputText(yiFirPlan);
	}

	public String getYiFirFinish() {
		return yiFirFinish;
	}

	public void setYiFirFinish(String yiFirFinish) {
		//this.yiFirFinish = yiFirFinish;
		this.yiFirFinish = ConvertHtml.convertInputText(yiFirFinish);
	}
	
	
	public String getYiLiangPlan() {
		return yiLiangPlan;
	}

	public void setYiLiangPlan(String yiLiangPlan) {
		//this.yiLiangPlan = yiLiangPlan;
		this.yiLiangPlan = ConvertHtml.convertInputText(yiLiangPlan);
	}

	public String getYiLiangFinish() {
		return yiLiangFinish;
	}

	public void setYiLiangFinish(String yiLiangFinish) {
		//this.yiLiangFinish = yiLiangFinish;
		this.yiLiangFinish = ConvertHtml.convertInputText(yiLiangFinish);
	}

	public String getYiThiPlan() {
		return yiThiPlan;
	}

	public void setYiThiPlan(String yiThiPlan) {
		//this.yiThiPlan = yiThiPlan;
		this.yiThiPlan = ConvertHtml.convertInputText(yiThiPlan);
	}

	public String getYiThiFinish() {
		return yiThiFinish;
	}

	public void setYiThiFinish(String yiThiFinish) {
		//this.yiThiFinish = yiThiFinish;
		this.yiThiFinish = ConvertHtml.convertInputText(yiThiFinish);
	}

	public String getYiForPlan() {
		return yiForPlan;
	}

	public void setYiForPlan(String yiForPlan) {
		this.yiForPlan = yiForPlan;
		this.yiForPlan = ConvertHtml.convertInputText(yiForPlan);
	}

	public String getYiForFinish() {
		return yiForFinish;
	}

	public void setYiForFinish(String yiForFinish) {
		//this.yiForFinish = yiForFinish;
		this.yiForFinish = ConvertHtml.convertInputText(yiForFinish);
	}

	public String getTwoFirPlan() {
		return twoFirPlan;
	}

	public void setTwoFirPlan(String twoFirPlan) {
		//this.twoFirPlan = twoFirPlan;
		this.twoFirPlan = ConvertHtml.convertInputText(twoFirPlan);
	}

	public String getTwoFirFinish() {
		return twoFirFinish;
	}

	public void setTwoFirFinish(String twoFirFinish) {
		//this.twoFirFinish = twoFirFinish;
		this.twoFirFinish = ConvertHtml.convertInputText(twoFirFinish);
	}

	public String getTwoSecPlan() {
		return twoSecPlan;
	}

	public void setTwoSecPlan(String twoSecPlan) {
		//this.twoSecPlan = twoSecPlan;
		this.twoSecPlan = ConvertHtml.convertInputText(twoSecPlan);
	}

	public String getTwoSecFinish() {
		return twoSecFinish;
	}

	public void setTwoSecFinish(String twoSecFinish) {
		//this.twoSecFinish = twoSecFinish;
		this.twoSecFinish = ConvertHtml.convertInputText(twoSecFinish);
	}

	public String getTwoThiPlan() {
		return twoThiPlan;
	}

	public void setTwoThiPlan(String twoThiPlan) {
		//this.twoThiPlan = twoThiPlan;
		this.twoThiPlan = ConvertHtml.convertInputText(twoThiPlan);
	}

	public String getTwoThiFinish() {
		return twoThiFinish;
	}

	public void setTwoThiFinish(String twoThiFinish) {
		//this.twoThiFinish = twoThiFinish;
		this.twoThiFinish = ConvertHtml.convertInputText(twoThiFinish);
	}

	public String getTwoForPlan() {
		return twoForPlan;
	}

	public void setTwoForPlan(String twoForPlan) {
		//this.twoForPlan = twoForPlan;
		this.twoForPlan = ConvertHtml.convertInputText(twoForPlan);
	}

	public String getTwoForFinish() {
		return twoForFinish;
	}

	public void setTwoForFinish(String twoForFinish) {
		//this.twoForFinish = twoForFinish;
		this.twoForFinish = ConvertHtml.convertInputText(twoForFinish);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getTwoYear() {
		return twoYear;
	}

	public void setTwoYear(String twoYear) {
		this.twoYear = twoYear;
	}

	public String getOneYear() {
		return oneYear;
	}

	public void setOneYear(String oneYear) {
		this.oneYear = oneYear;
	}



}
