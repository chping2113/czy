package com.kjlink.ahpips.entity.project;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

@Entity
@Table(name = "t_construct_companyinfo")
//��ҵ��λ��Ϊ��Ϣ
public class ConstructCompanyInfo implements java.io.Serializable {
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "native")
	private Integer id;

	@Lob
	@Column(name = "company_credit")
	private String companyCredit;// ���õȼ���Ϣ

	@Lob
	@Column(name = "company_honor")
	private String companyHonor;// ������Ϊ��Ϣ
	@Lob
	@Column(name = "company_badrecord")
	private String companyBadrecord;// ������Ϊ��Ϣ

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCompanyCredit() {
		return companyCredit;
	}

	public void setCompanyCredit(String companyCredit) {
		// this.companyCredit = companyCredit;
		this.companyCredit = Jsoup.clean(companyCredit, Whitelist.basic());
	}

	public String getCompanyHonor() {
		return companyHonor;
	}

	public void setCompanyHonor(String companyHonor) {
		// this.companyHonor = companyHonor;
		this.companyHonor = Jsoup.clean(companyHonor, Whitelist.basic());
	}

	public String getCompanyBadrecord() {
		return companyBadrecord;
	}

	public void setCompanyBadrecord(String companyBadrecord) {
		// this.companyBadrecord = companyBadrecord;
		this.companyBadrecord = Jsoup
				.clean(companyBadrecord, Whitelist.basic());
	}
}
