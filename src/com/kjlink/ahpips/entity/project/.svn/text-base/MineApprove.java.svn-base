package com.kjlink.ahpips.entity.project;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.kjlink.common.util.ConvertHtml;

@Entity
@Table(name="t_mine_approve")//采矿权审批信息表
public class MineApprove implements java.io.Serializable {
	private static final long serialVersionUID = 0L;
	
	@Id
	@GeneratedValue(generator = "paymentableGenerator")       
	@GenericGenerator(name = "paymentableGenerator", strategy = "native")    
	private Integer id;
	
	@Column(length=50,name="license_code")
	private String licenseCode ;//许可证号
	
	@Column(length=50,name="mine_name")
	private String mineName ;//矿山名称
	
	@Column(length=50,name="mine_person")
	private String minePerson ;//采矿权人
	
	@Column(length=50)
	private String period ;//有效期
	
	@Column(length=50)
	private String jingweidu ;//经纬度
	@Column(length=200)
	private String area ;//总面积
	
	@Column(length=50,name="mine_type")
	private String mineType ;//矿种
	
	@Column(length=50,name="certification_site")
	private String certificationSite ;//发证机关

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLicenseCode() {
		return licenseCode;
	}

	public void setLicenseCode(String licenseCode) {
		//this.licenseCode = licenseCode;
		this.licenseCode = ConvertHtml.convertInputText(licenseCode); 
	}

	public String getMineName() {
		return mineName;
	}

	public void setMineName(String mineName) {
		//this.mineName = mineName;
		this.mineName = ConvertHtml.convertInputText(mineName); 
	}

	public String getMinePerson() {
		return minePerson;
	}

	public void setMinePerson(String minePerson) {
		//this.minePerson = minePerson;
		this.minePerson = ConvertHtml.convertInputText(minePerson); 
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		//this.period = period;
		this.period = ConvertHtml.convertInputText(period); 
	}

	public String getJingweidu() {
		return jingweidu;
	}

	public void setJingweidu(String jingweidu) {
		//this.jingweidu = jingweidu;
		this.jingweidu = ConvertHtml.convertInputText(jingweidu); 
	}



	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		//this.area = area;
		this.area = ConvertHtml.convertInputText(area); 
	}

	public String getMineType() {
		return mineType;
	}

	public void setMineType(String mineType) {
		//this.mineType = mineType;
		this.mineType = ConvertHtml.convertInputText(mineType); 
	}

	public String getCertificationSite() {
		return certificationSite;
	}

	public void setCertificationSite(String certificationSite) {
		//this.certificationSite = certificationSite;
		this.certificationSite = ConvertHtml.convertInputText(certificationSite); 
	}
	
}
