package com.kjlink.ahpips.entity.project;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.kjlink.common.util.ConvertHtml;

@Entity
@Table(name="t_prospect_approve")//探矿权审批信息表
public class ProspectApprove implements java.io.Serializable {
	private static final long serialVersionUID = 0L;
	
	@Id
	@GeneratedValue(generator = "paymentableGenerator")       
	@GenericGenerator(name = "paymentableGenerator", strategy = "native")    
	private Integer id;
	
	@Column(length=50,name="license_code")
	private String licenseCode ;//许可证号
	
	@Column(length=50,name="project_name")
	private String projectName ;//项目名称
	
	@Column(length=50,name="prospect_person")
	private String prospectPerson ;//探矿权人
	
	@Column(length=50,name="recon_site")
	private String reconSite ;//勘察单位
	
	@Column(length=100,name="recon_mine")
	private String reconMine ;//勘察矿种
	
	@Column(length=50)
	private String period ;//有效期
	
	@Column(length=50)
	private String jingweidu ;//经纬度
	@Column(length=200)
	private String area ;//总面积
	
	@Column(length=200)
	private String location ;//地理位置
	
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

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		//this.projectName = projectName;
		this.projectName = ConvertHtml.convertInputText(projectName); 
	}

	public String getProspectPerson() {
		return prospectPerson;
	}

	public void setProspectPerson(String prospectPerson) {
		//this.prospectPerson = prospectPerson;
		this.prospectPerson = ConvertHtml.convertInputText(prospectPerson); 
	}

	public String getReconSite() {
		return reconSite;
	}

	public void setReconSite(String reconSite) {
		//this.reconSite = reconSite;
		this.reconSite = ConvertHtml.convertInputText(reconSite); 
	}

	public String getReconMine() {
		return reconMine;
	}

	public void setReconMine(String reconMine) {
		//this.reconMine = reconMine;
		this.reconMine = ConvertHtml.convertInputText(reconMine); 
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		//this.location = location;
		this.location = ConvertHtml.convertInputText(location); 
	}

	public String getCertificationSite() {
		return certificationSite;
	}

	public void setCertificationSite(String certificationSite) {
		//this.certificationSite = certificationSite;
		this.certificationSite = ConvertHtml.convertInputText(certificationSite); 
	}
	
}
