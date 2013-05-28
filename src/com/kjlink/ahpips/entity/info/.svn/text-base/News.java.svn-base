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
	private String title; //标题
	
	@Lob
	private String content; //内容
	
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="catelog_id")
	private NewsCatelog catelog; //所属栏目
	
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="create_user_id")
	private User createUser; //发布人
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_time")
	private Date createTime; //发布时间
	
	@Column(name = "org_from", length=100)
	private String orgFrom; //来源
	
	@Column(name = "image_news")
	private Integer imageNews = 0; //是否为标题图片新闻
	
	@Column(name = "image_file_name", length=50)
	private String imageFileName; //标题图片文件名
	
	private Integer hitCount = 0; //浏览点击数

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
