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
@Table(name = "t_news")
public class News implements java.io.Serializable {
	private static final long serialVersionUID = 0L;
	
	@Id
	@GeneratedValue(generator = "paymentableGenerator")       
	@GenericGenerator(name = "paymentableGenerator", strategy = "native")    
	private Integer id;
	
	@Column(length = 100)
	private String title; //����
	
	@Lob
	private String content; //����
	
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="catelog_id")
	private NewsCatelog catelog; //������Ŀ
	
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="create_user_id")
	private User createUser; //������
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_time")
	private Date createTime; //����ʱ��
	
	@Column(name = "org_from", length=100)
	private String orgFrom; //��Դ
	
	@Column(name = "image_news")
	private Integer imageNews = 0; //�Ƿ�Ϊ����ͼƬ����
	
	@Column(name = "image_file_name", length=50)
	private String imageFileName; //����ͼƬ�ļ���
	
	private Integer hitCount = 0; //��������

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
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public NewsCatelog getCatelog() {
		return catelog;
	}

	public void setCatelog(NewsCatelog catelog) {
		this.catelog = catelog;
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

	public String getOrgFrom() {
		return orgFrom;
	}

	public void setOrgFrom(String orgFrom) {
		//this.orgFrom = orgFrom;
		this.orgFrom = ConvertHtml.convertInputText(orgFrom);
	}

	public Integer getImageNews() {
		return imageNews;
	}

	public void setImageNews(Integer imageNews) {
		this.imageNews = imageNews;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public Integer getHitCount() {
		return hitCount;
	}

	public void setHitCount(Integer hitCount) {
		this.hitCount = hitCount;
	}
	
}
