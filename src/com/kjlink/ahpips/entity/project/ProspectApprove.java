package com.kjlink.ahpips.entity.project;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.kjlink.common.util.ConvertHtml;

@Entity
@Table(name="t_prospect_approve")//̽��Ȩ������Ϣ��
public class ProspectApprove implements java.io.Serializable {
	private static final long serialVersionUID = 0L;
	
	@Id
	@GeneratedValue(generator = "paymentableGenerator")       
	@GenericGenerator(name = "paymentableGenerator", strategy = "native")    
	private Integer id;
	
	@Column(length=50,name="license_code")
	private String licenseCode ;//���֤��
	
	@Column(length=50,name="project_name")
	private String projectName ;//��Ŀ����
	
	@Column(length=50,name="prospect_person")
	private String prospectPerson ;//̽��Ȩ��
	
	@Column(length=50,name="recon_site")
	private String reconSite ;//���쵥λ
	
	@Column(length=100,name="recon_mine")
	private String reconMine ;//�������
	
	@Column(length=50)
	private String period ;//��Ч��
	
	@Column(length=50)
	private String jingweidu ;//��γ��
	@Column(length=200)
	private String area ;//�����
	
	@Column(length=200)
	private String location ;//����λ��
	
	@Column(length=50,name="certification_site")
	private String certificationSite ;//��֤����

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
