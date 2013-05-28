package com.kjlink.ahpips.entity.info;

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

import com.kjlink.ahpips.entity.system.User;
import com.kjlink.common.util.ConvertHtml;

@Entity
@Table(name = "t_notice")
public class Notice implements java.io.Serializable {
	private static final long serialVersionUID = 0L;

	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "native")
	private Integer id;

	@Column(length = 100)
	private String title; // ����

	@Lob
	private String content; // ����

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "create_user_id")
	private User createUser; // ������

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_time")
	private Date createTime; // ����ʱ��

	@Column(name = "float_show")
	private Integer floatShow; // �Ƿ���ҳ������ʾ

	@Column(name = "float_days")
	private Integer floatDays; // ������ʾ����

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "float_end_time")
	private Date floatEndTime; // ������ʾ�Ľ������ڣ�����floatDays���������

	private Integer hitCount = 0; // ��������

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
		// this.title = title;
		this.title = ConvertHtml.convertInputText(title);
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public User getCreateUser() {
		return createUser;
	}

	public void setCreateUser(User createUser) {
		this.createUser = createUser;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getFloatShow() {
		return floatShow;
	}

	public void setFloatShow(Integer floatShow) {
		this.floatShow = floatShow;
	}

	public Integer getFloatDays() {
		return floatDays;
	}

	public void setFloatDays(Integer floatDays) {
		this.floatDays = floatDays;
	}

	public Integer getHitCount() {
		return hitCount;
	}

	public void setHitCount(Integer hitCount) {
		this.hitCount = hitCount;
	}

	public Date getFloatEndTime() {
		return floatEndTime;
	}

	public void setFloatEndTime(Date floatEndTime) {
		this.floatEndTime = floatEndTime;
	}

}
