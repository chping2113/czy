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
@Table(name = "t_audit_statistics")//审计统计信息表
public class AuditStatistics  implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "paymentableGenerator")       
	@GenericGenerator(name = "paymentableGenerator", strategy = "native")    
	private Integer id;
	
	
	@Lob
	@Column(name="audit_statistics")
	private String auditStatistics;

	public String getAuditStatistics() {
		return auditStatistics;
	}

	public void setAuditStatistics(String auditStatistics) {
		//this.auditStatistics = auditStatistics;
		this.auditStatistics = Jsoup.clean(auditStatistics, Whitelist.basic());
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	

}
