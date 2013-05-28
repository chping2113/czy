package com.kjlink.ahpips.entity.info;

import java.io.IOException;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

import com.kjlink.ahpips.entity.system.Site;
import com.kjlink.common.util.ConvertHtml;


@Entity
@Table(name = "t_complaint")
public class Complaint implements java.io.Serializable {
private static final long serialVersionUID = 0L;
	
	@Id
	@GeneratedValue(generator = "paymentableGenerator")       
	@GenericGenerator(name = "paymentableGenerator", strategy = "native")    
	private Integer id;
	
	@Column(length = 200, nullable = false)
	private String title; //举报主题
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_time")
	private Date createTime; //举报时间
	
	@Lob
	private String content; //举报内容
	
	@Column(length = 20)
	private String name; //举报人姓名
	
	@Column(length = 50)
	private String dept; //举报人单位
	
	@Column(length = 20)
	private String tel; //联系电话
	
	@Column(length = 50)
	private String email; //电子邮件
	
	@Column(length = 100)
	private String address; //联系地址
	
	@Column(length = 20)
	private String ip; //举报人IP
	
	@Column(length = 200)
	private String deal; //处理意见
	
	@Column(length = 20,name = "complaint_name")
	private String complaintName; //举报人姓名
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "complaint_date")
	private Date complaintDate; //举报时间
	
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="accept_site_id")
	private Site oragan; //受理机构
	
	@Column(name = "deal_state")
	private Integer dealState; //处理状态  0-处理过  1 -未处理
	
	public String getComplaintName() {
		return complaintName;
	}

	public void setComplaintName(String complaintName) {
		this.complaintName = complaintName;
	}

	public Date getComplaintDate() {
		return complaintDate;
	}

	public void setComplaintDate(Date complaintDate) {
		this.complaintDate = complaintDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		//this.title = title;
		this.title = ConvertHtml.convertInputText(title);
		//this.title = Jsoup.clean(title, Whitelist.basic()); 


	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getContent() throws IOException {
		
//		if(content!=null){
//			content=new String(Base64.decode(content));
//		}
		return content;
	}

	public void setContent(String content) {
		//this.content = content;
		//this.content = ConvertHtml.convertTextarea(content);
		this.content = Jsoup.clean(content, Whitelist.basic()); 
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		//this.name = name;
		this.name = ConvertHtml.convertInputText(name);
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		//this.dept = dept;
		this.dept = ConvertHtml.convertInputText(dept);
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		//this.address = address;
		this.address = ConvertHtml.convertInputText(address);
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getDeal() {
		return deal;
	}

	public void setDeal(String deal) {
		this.deal = deal;
	}

	public Site getOragan() {
		return oragan;
	}

	public void setOragan(Site oragan) {
		this.oragan = oragan;
	}

	public Integer getDealState() {
		return dealState;
	}

	public void setDealState(Integer dealState) {
		this.dealState = dealState;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
