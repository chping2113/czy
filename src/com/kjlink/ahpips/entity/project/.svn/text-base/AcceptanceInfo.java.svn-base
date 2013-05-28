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

@Entity
@Table(name="t_acceptance_info")//交竣工验收信息表
public class AcceptanceInfo implements java.io.Serializable {
	private static final long serialVersionUID = 0L;
	
	@Id
	@GeneratedValue(generator = "paymentableGenerator")       
	@GenericGenerator(name = "paymentableGenerator", strategy = "native")    
	private Integer id;
	

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "acceptance_time")
	private Date acceptanceTime; //交竣工验收时间
	
	@Lob
	@Column(name="acceptance_result")
	private String acceptanceResult ;//交竣工验收结果
	
	@Lob
	@Column(name="report_check")
	private String reportCheck ;//环保、档案、消防等专项验收时间信息
	
	@Lob
	@Column(name="fire_report")
	private String fireReport ;//消防单位项目验收报告
	
	@Lob
	@Column(name="supervision_report")
	private String supervisionReport ;//征地补偿和移民安置
	
	@Lob
	@Column(name="environment_report")
	private String environmentReport ;//环保单位项目验收报告
	
	@Lob
	@Column(name="project_audit")
	private String projectAudit ;//项目审计
	
	@Lob
	@Column(name="project_budget")
	private String projectBudget ;//工程决算
	
	@Lob
	@Column(name="document_acceptance")
	private String documentAcceptance ;//档案验收
	
	@Lob
	@Column(name="acceptance_report")
	private String acceptanceReport ;//水保等专项验收时间及结果信息
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "pay_time")
	private Date payTime; //交付使用时间

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAcceptanceResult() {
		return acceptanceResult;
	}

	public void setAcceptanceResult(String acceptanceResult) {
		//this.acceptanceResult = acceptanceResult;
		this.acceptanceResult = Jsoup.clean(acceptanceResult, Whitelist.basic());
	}

	public String getReportCheck() {
		return reportCheck;
	}

	public void setReportCheck(String reportCheck) {
		//this.reportCheck = reportCheck;
		this.reportCheck = Jsoup.clean(reportCheck, Whitelist.basic());
	}

	public String getFireReport() {
		return fireReport;
	}

	public void setFireReport(String fireReport) {
		//this.fireReport = fireReport;
		this.fireReport = Jsoup.clean(fireReport, Whitelist.basic());
	}

	public String getSupervisionReport() {
		return supervisionReport;
	}

	public void setSupervisionReport(String supervisionReport) {
		//this.supervisionReport = supervisionReport;
		this.supervisionReport = Jsoup.clean(supervisionReport, Whitelist.basic());
	}

	public String getEnvironmentReport() {
		return environmentReport;
	}

	public void setEnvironmentReport(String environmentReport) {
		//this.environmentReport = environmentReport;
		this.environmentReport = Jsoup.clean(environmentReport, Whitelist.basic());
	}

	public String getProjectAudit() {
		return projectAudit;
	}

	public void setProjectAudit(String projectAudit) {
		//this.projectAudit = projectAudit;
		this.projectAudit = Jsoup.clean(projectAudit, Whitelist.basic());
	}

	public String getProjectBudget() {
		return projectBudget;
	}

	public void setProjectBudget(String projectBudget) {
		//this.projectBudget = projectBudget;
		this.projectBudget = Jsoup.clean(projectBudget, Whitelist.basic());
	}

	public String getDocumentAcceptance() {
		return documentAcceptance;
	}

	public void setDocumentAcceptance(String documentAcceptance) {
		//this.documentAcceptance = documentAcceptance;
		this.documentAcceptance = Jsoup.clean(documentAcceptance, Whitelist.basic());
	}

	public String getAcceptanceReport() {
		return acceptanceReport;
	}

	public void setAcceptanceReport(String acceptanceReport) {
		//this.acceptanceReport = acceptanceReport;
		this.acceptanceReport = Jsoup.clean(acceptanceReport, Whitelist.basic());
	}

	public Date getAcceptanceTime() {
		return acceptanceTime;
	}

	public void setAcceptanceTime(Date acceptanceTime) {
		this.acceptanceTime = acceptanceTime;
	}

	public Date getPayTime() {
		return payTime;
	}

	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}
	
}
