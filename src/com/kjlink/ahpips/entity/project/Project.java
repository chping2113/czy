package com.kjlink.ahpips.entity.project;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import com.kjlink.ahpips.entity.system.District;
import com.kjlink.ahpips.entity.system.Site;
import com.kjlink.common.util.ConvertHtml;

@Entity
@Table(name = "t_project")//��Ŀ��Ϣ��
public class Project implements java.io.Serializable {
	private static final long serialVersionUID = 0L;
	
	@Id
	@GeneratedValue(generator = "paymentableGenerator")       
	@GenericGenerator(name = "paymentableGenerator", strategy = "native")    
	private Integer id;
	
	@Column(length = 40)
	private String code; //��Ŀ����
	
	@Column(length = 100)
	private String name; //��Ŀ����
	
	private Double money; //��Ŀ���
	
//	@Column(length = 50,name = "district_code")
//	private String districtCode; //��Ŀ������
	
	@Column(length = 50)
	private String owner; //��Ŀҵ��
	
	@Column(length = 50,name="construct_name")
	private String constructName; //���赥λ
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_time")
	private Date createTime; //����ʱ��
	
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="site_id")
	private Site site;	//��������
	

	
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="district_code")
	private District district ;//��Ŀ������
	
	private Integer state = 0; //���״̬��0��δ��ˣ�1�����ͨ����2�����δͨ��

	public String getConstructName() {
		return constructName;
	}

	public void setConstructName(String constructName) {
		//this.constructName = constructName;
		this.constructName = ConvertHtml.convertInputText(constructName); 
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		//this.code = code;
		this.code = ConvertHtml.convertInputText(code); 
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		//this.name = name;
		this.name = ConvertHtml.convertInputText(name); 
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		//this.owner = owner;
		this.owner = ConvertHtml.convertInputText(owner); 
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}



	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}
}
