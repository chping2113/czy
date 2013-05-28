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
@Table(name="t_land_use")//建设用地审批信息表
public class LandUse implements java.io.Serializable {
	private static final long serialVersionUID = 0L;
	
	@Id
	@GeneratedValue(generator = "paymentableGenerator")       
	@GenericGenerator(name = "paymentableGenerator", strategy = "native")    
	private Integer id;
	
	@Column(length=50,name="project_name")
	private String projectName ;//项目名称
	
	@Column(length=50,name="apply_site")
	private String applySite ;//申请单位
	
	@Column(length=200)
	private String location ;//土地位置
	
	@Lob
	@Column(name="land_use")
	private String landUse ;//用地用途
	
	@Column(length=200,name="apply_use_area")
	private String applyUseUrea ;//申请使用面积
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "approval_time")
	private Date approvalTime; //批准时间

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		//this.projectName = projectName;
		this.projectName = ConvertHtml.convertInputText(projectName);
	}

	public String getApplySite() {
		return applySite;
	}

	public void setApplySite(String applySite) {
		//this.applySite = applySite;
		this.applySite = ConvertHtml.convertInputText(applySite);
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		//this.location = location;
		this.location = ConvertHtml.convertInputText(location);
	}

	public String getLandUse() {
		return landUse;
	}

	public String getApplyUseUrea() {
		return applyUseUrea;
	}

	public void setApplyUseUrea(String applyUseUrea) {
		//this.applyUseUrea = applyUseUrea;
		this.applyUseUrea = ConvertHtml.convertInputText(applyUseUrea);
	}

	public void setLandUse(String landUse) {
		//this.landUse = landUse;
		this.landUse = Jsoup.clean(landUse, Whitelist.basic()); 
	}



	public Date getApprovalTime() {
		return approvalTime;
	}

	public void setApprovalTime(Date approvalTime) {
		this.approvalTime = approvalTime;
	}
	
}
