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

import com.kjlink.ahpips.entity.system.User;

@Entity
@Table(name = "t_key_project")
public class KeyProject {
	private static final long serialVersionUID = 0L;
	
	@Id
	@GeneratedValue(generator = "paymentableGenerator")       
	@GenericGenerator(name = "paymentableGenerator", strategy = "native")    
	private Integer id;
	
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="key_project_kind_id")
	private KeyProjectKind keyProjectKind; //重点项目类型
	
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="projectConstruct_id")
	private ProjectConstruct projectConstruct; //项目信息表
	
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="creator_id")
	private User user; //项目信息表
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date")
	private Date createDate; //发布日期

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public KeyProjectKind getKeyProjectKind() {
		return keyProjectKind;
	}

	public void setKeyProjectKind(KeyProjectKind keyProjectKind) {
		this.keyProjectKind = keyProjectKind;
	}




	public ProjectConstruct getProjectConstruct() {
		return projectConstruct;
	}

	public void setProjectConstruct(ProjectConstruct projectConstruct) {
		this.projectConstruct = projectConstruct;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
}
