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
@Table(name="t_contract_info")//��ͬ��Լ��Ϣ��
public class ContractInfo implements java.io.Serializable {
	private static final long serialVersionUID = 0L;
	
	@Id
	@GeneratedValue(generator = "paymentableGenerator")       
	@GenericGenerator(name = "paymentableGenerator", strategy = "native")    
	private Integer id;
	
	@Lob
	@Column(name="project_examine")
	private String projectExamine ;//ʩ����λ��Ŀ����
	
	@Lob
	@Column(name="contract_present")
	private String contractPresent ;//�ν���λ��Ҫ�����Ա����ͬ��Լ������Ϣ
	
	@Lob
	private String payment ;//���赥λ����֧ͬ���ʽ����
	
	@Lob
	@Column(name="money_use")
	private String moneyUse ;//�豸���ϲɹ��ʽ�ʹ�����

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProjectExamine() {
		return projectExamine;
	}

	public void setProjectExamine(String projectExamine) {
		//this.projectExamine = projectExamine;
		this.projectExamine = Jsoup.clean(projectExamine, Whitelist.basic());
	}

	public String getContractPresent() {
		return contractPresent;
	}

	public void setContractPresent(String contractPresent) {
		//this.contractPresent = contractPresent;
		this.contractPresent = Jsoup.clean(contractPresent, Whitelist.basic());
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		//this.payment = payment;
		this.payment = Jsoup.clean(payment, Whitelist.basic());
	}

	public String getMoneyUse() {
		return moneyUse;
	}

	public void setMoneyUse(String moneyUse) {
		//this.moneyUse = moneyUse;
		this.moneyUse = Jsoup.clean(moneyUse, Whitelist.basic());
	}
	
}
