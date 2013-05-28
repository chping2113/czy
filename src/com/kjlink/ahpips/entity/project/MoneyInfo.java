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
@Table(name="t_money_info")//�ʽ������Ϣ��
public class MoneyInfo implements java.io.Serializable {
	private static final long serialVersionUID = 0L;
	
	@Id
	@GeneratedValue(generator = "paymentableGenerator")       
	@GenericGenerator(name = "paymentableGenerator", strategy = "native")    
	private Integer id;
	
	@Lob
	@Column(name="money_present")
	private String moneyPresent ;//��Ŀ�ʽ�λ��ʹ��
	
	@Lob
	@Column(name="money_payment")
	private String moneyPayment ;//���̿�֧�����
	
	@Lob
	@Column(name="budget_execution")
	private String budgetExecution ;//�ʽ��Ԥ��ִ�����

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMoneyPresent() {
		return moneyPresent;
	}

	public void setMoneyPresent(String moneyPresent) {
		//this.moneyPresent = moneyPresent;
		this.moneyPresent = Jsoup.clean(moneyPresent, Whitelist.basic());
	}

	public String getMoneyPayment() {
		return moneyPayment;
	}

	public void setMoneyPayment(String moneyPayment) {
		//this.moneyPayment = moneyPayment;
		this.moneyPayment = Jsoup.clean(moneyPayment, Whitelist.basic());
	}

	public String getBudgetExecution() {
		return budgetExecution;
	}

	public void setBudgetExecution(String budgetExecution) {
		//this.budgetExecution = budgetExecution;
		this.budgetExecution = Jsoup.clean(budgetExecution, Whitelist.basic());
	}
}
