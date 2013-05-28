package com.kjlink.ahpips.entity.project;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

import com.kjlink.common.util.ConvertHtml;

@Entity
@Table(name = "t_base_info")//��Ŀ������Ϣ��
public class BaseInfo implements java.io.Serializable {
	private static final long serialVersionUID = 0L;
	
	@Id
	@GeneratedValue(generator = "paymentableGenerator")       
	@GenericGenerator(name = "paymentableGenerator", strategy = "native")    
	private Integer id;
	
	@Column(length = 100)
	private String name; //��Ŀ����
	
	@Column(length = 500)
	private String memo ;//��Ŀ�ſ�

	private Double money ;//Ͷ�ʹ�ģ
	
	@Column(length = 100)
	private String manager ;//��Ŀ����
	
	@Column(length = 100,name = "construct_company")
	private String constructCompany ;//���赥λ
	
	@Column(length = 500,name = "other_companys")
	private String otherCompanys ;//�ν���λ
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "construct_begin_date")
	private Date constructBeginDate; //������ʼʱ��
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "construct_end_date")
	private Date constructEndDate; //�������ʱ��

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		//this.memo = memo;
		this.memo = ConvertHtml.convertInputText(memo);
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		//this.manager = manager;
		this.manager = ConvertHtml.convertInputText(manager);
	}

	public String getConstructCompany() {
		return constructCompany;
	}

	public void setConstructCompany(String constructCompany) {
		//this.constructCompany = constructCompany;
		this.constructCompany = ConvertHtml.convertInputText(constructCompany);
	}

	public String getOtherCompanys() {
		return otherCompanys;
	}

	public void setOtherCompanys(String otherCompanys) {
		//this.otherCompanys = otherCompanys;
		this.otherCompanys = Jsoup.clean(otherCompanys, Whitelist.basic());
	}

	public Date getConstructBeginDate() {
		return constructBeginDate;
	}

	public void setConstructBeginDate(Date constructBeginDate) {
		this.constructBeginDate = constructBeginDate;
	}

	public Date getConstructEndDate() {
		return constructEndDate;
	}

	public void setConstructEndDate(Date constructEndDate) {
		this.constructEndDate = constructEndDate;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		//this.name = name;
		this.name = ConvertHtml.convertInputText(name);
	}
}
