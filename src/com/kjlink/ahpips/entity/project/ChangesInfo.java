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
@Table(name="t_changes_info")//重大设计变更信息表
public class ChangesInfo implements java.io.Serializable {
	private static final long serialVersionUID = 0L;
	
	@Id
	@GeneratedValue(generator = "paymentableGenerator")       
	@GenericGenerator(name = "paymentableGenerator", strategy = "native")    
	private Integer id;
	
	@Lob
	@Column(name="change_basis")
	private String changeBasis ;//设计变更管理依据
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "change_date")
	private Date changeDate; //项目变更时间
	
	@Lob
	@Column(name="change_resean")
	private String changeResean ;//变更原因
	
	@Column(length=200,name="change_money")
	private String changeMoney ;//资金变更
	
	@Lob
	@Column(name="change_content")
	private String changeContent ;//变更内容
	
	@Column(length=50,name="approve_site")
	private String approveSite ;//审批单位

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getChangeBasis() {
		return changeBasis;
	}

	public void setChangeBasis(String changeBasis) {
		//this.changeBasis = changeBasis;
		this.changeBasis = Jsoup.clean(changeBasis, Whitelist.basic());
	}

	public Date getChangeDate() {
		return changeDate;
	}

	public void setChangeDate(Date changeDate) {
		this.changeDate = changeDate;
	}

	public String getChangeResean() {
		return changeResean;
	}

	public void setChangeResean(String changeResean) {
		//this.changeResean = changeResean;
		this.changeResean = Jsoup.clean(changeResean, Whitelist.basic());
	}

	public String getChangeMoney() {
		return changeMoney;
	}

	public void setChangeMoney(String changeMoney) {
		//this.changeMoney = changeMoney;
		this.changeMoney = Jsoup.clean(changeMoney, Whitelist.basic());
	}

	public String getChangeContent() {
		return changeContent;
	}

	public void setChangeContent(String changeContent) {
		this.changeContent = changeContent;
	}

	public String getApproveSite() {
		return approveSite;
	}

	public void setApproveSite(String approveSite) {
		//this.approveSite = approveSite;
		this.approveSite = ConvertHtml.convertInputText(approveSite);
	}
}
