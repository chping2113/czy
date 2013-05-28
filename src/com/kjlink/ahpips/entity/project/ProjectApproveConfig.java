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
@Table(name = "t_project_approve_config")//��Ŀ������Ϣ���ñ�
public class ProjectApproveConfig implements java.io.Serializable {
	private static final long serialVersionUID = 0L;

	@Id
	@GeneratedValue(generator = "paymentableGenerator")       
	@GenericGenerator(name = "paymentableGenerator", strategy = "native")    
	private Integer id;
	
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="site_id")
	private Site site;	//����ƽ̨
	
	@Column(length = 100)
	private String approveName; //������Ϣ����
	
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="approve_site_id")
	private Site approveSite;	//������Ϣ��������

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

	public String getApproveName() {
		return approveName;
	}

	public void setApproveName(String approveName) {
		this.approveName = approveName;
	}

	public Site getApproveSite() {
		return approveSite;
	}

	public void setApproveSite(Site approveSite) {
		this.approveSite = approveSite;
	}

}
