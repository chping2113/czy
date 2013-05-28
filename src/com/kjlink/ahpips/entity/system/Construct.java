package com.kjlink.ahpips.entity.system;

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

import com.kjlink.common.util.ConvertHtml;

@Entity
@Table(name = "t_construct")
public class Construct implements java.io.Serializable {
	private static final long serialVersionUID = 0L;

	@Id
	@GeneratedValue(generator = "paymentableGenerator")       
	@GenericGenerator(name = "paymentableGenerator", strategy = "native")    
	private Integer id;

	@Column(length = 100)
	private String name; // 建设单位名称

	@Column(length = 20, nullable = false, unique = true)
	private String code; // 登录账号

	@Column(length = 50)
	private String password; // 密码， md5形式存放

	@Column(length = 20)
	private String linkman; // 联系人

	@Column(length = 20)
	private String tel; // 联系电话

	@Column(length = 20)
	private String concode; // 组织代码

	@Column(length = 50)
	private String email; // 邮件

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "register_time")
	private Date registerTime; // 注册时间

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "update_time")
	private Date updateTime = new Date(); // 帐户密码更新时间

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "approve_id")
	private Site approveSite; // 审核机构

	private Integer state = 0; // 审核状态，0：未审核，1：审核通过，2：审核未通过

	@Column(name = "valid_state")
	private Integer validState = 0; // 是否有效，0：无效，1：有效

	public Integer getValidState() {
		return validState;
	}

	public void setValidState(Integer validState) {
		this.validState = validState;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		// this.name = name;
		this.name = ConvertHtml.convertInputText(name);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		// this.code = code;
		this.code = ConvertHtml.convertInputText(code);
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLinkman() {
		return linkman;
	}

	public void setLinkman(String linkman) {
		// this.linkman = linkman;
		this.linkman = ConvertHtml.convertInputText(linkman);
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

	public Date getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}

	public Site getApproveSite() {
		return approveSite;
	}

	public void setApproveSite(Site approveSite) {
		this.approveSite = approveSite;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getConcode() {
		return concode;
	}

	public void setConcode(String concode) {
		// this.concode = concode;
		this.concode = ConvertHtml.convertInputText(concode);
	}

}
