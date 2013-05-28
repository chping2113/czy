package com.kjlink.ahpips.entity.project;

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
import com.kjlink.ahpips.entity.system.User;
import com.kjlink.common.util.ConvertHtml;

@Entity
@Table(name = "t_project_aim")//招标投标信息表
public class ProjectAim implements java.io.Serializable{
	private static final long serialVersionUID = 0L;

	@Id
	@GeneratedValue(generator = "paymentableGenerator")       
	@GenericGenerator(name = "paymentableGenerator", strategy = "native")    
	private Integer id;
	
	@Column(length = 40)
	private String code; //项目编码
	
	@Column(length = 100)
	private String name; //项目名称
	
	@Column(length = 100)
	private String constructName; //项目建设单位名称
	
	@Lob
	private String aimItem ; //招标事项
	
	@Lob
	private String notice ; //招标公告
	
	@Lob
	private String statusNotice ; //投标资格预审公告
	
	@Lob
	private String bidResult ; //中标结果
	
	private Integer state = 0; //审核状态，0：未审核，1：审核通过，2：审核未通过 ，3：提交审核
	
	
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(updatable = false,name="site_id")
	private Site site;	//发布机构
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_time")
	private Date createTime =  new Date(); //发布时间

	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="user_id")
	private User approveUser;//审核人员
	
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(updatable = false,name="create_user_id")
	private User createUser;//发布人员
	
	public User getCreateUser() {
		return createUser;
	}

	public void setCreateUser(User createUser) {
		this.createUser = createUser;
	}

	public User getApproveUser() {
		return approveUser;
	}

	public void setApproveUser(User approveUser) {
		this.approveUser = approveUser;
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

	public String getConstructName() {
		return constructName;
	}

	public void setConstructName(String constructName) {
		//this.constructName = constructName;
		this.constructName = ConvertHtml.convertInputText(constructName); 
	}

	public String getAimItem() {
		return aimItem;
	}

	public void setAimItem(String aimItem) {
		//this.aimItem = aimItem;
		this.aimItem = Jsoup.clean(aimItem, Whitelist.basic()); 
	}

	public String getNotice() {
		return notice;
	}

	public void setNotice(String notice) {
		//this.notice = notice;
		this.notice = Jsoup.clean(notice, Whitelist.basic()); 
	}

	public String getStatusNotice() {
		return statusNotice;
	}

	public void setStatusNotice(String statusNotice) {
		//this.statusNotice = statusNotice;
		this.statusNotice = Jsoup.clean(statusNotice, Whitelist.basic()); 
	}

	public String getBidResult() {
		return bidResult;
	}

	public void setBidResult(String bidResult) {
		//this.bidResult = bidResult;
		this.bidResult = ConvertHtml.convertInputText(bidResult);//Jsoup.clean(bidResult, Whitelist.basic()); 
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	

}
