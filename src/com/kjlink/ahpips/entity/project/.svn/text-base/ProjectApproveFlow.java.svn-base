package com.kjlink.ahpips.entity.project;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.kjlink.ahpips.entity.system.Site;

@Entity
@Table(name = "t_project_approve_flow")//项目审批信息流程表
public class ProjectApproveFlow implements java.io.Serializable {
	private static final long serialVersionUID = 0L;

	@Id
	@GeneratedValue(generator = "paymentableGenerator")       
	@GenericGenerator(name = "paymentableGenerator", strategy = "native")    
	private Integer id;
	
	@Column(length = 50)
	private String type; //审批信息类型
	
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(updatable = false,name="project_approve_id")
	private ProjectApprove projectApprove;	//项目审批信息
	
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(updatable = false,name="site_id")
	private Site site;	//县级发布机构
	
	
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(updatable = false,name="site_cid")
	private Site site_c;	//市级发布机构
	
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(updatable = false,name="site_pid")
	private Site site_p;	//省级发布机构
	
	private Integer state = 0; //审核状态，0：未审核，1：审核通过  2. 发布成功

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public ProjectApprove getProjectApprove() {
		return projectApprove;
	}

	public void setProjectApprove(ProjectApprove projectApprove) {
		this.projectApprove = projectApprove;
	}

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

	public Site getSite_c() {
		return site_c;
	}

	public void setSite_c(Site site_c) {
		this.site_c = site_c;
	}

	public Site getSite_p() {
		return site_p;
	}

	public void setSite_p(Site site_p) {
		this.site_p = site_p;
	}

}
