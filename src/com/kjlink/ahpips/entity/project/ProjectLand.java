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

import com.kjlink.ahpips.entity.system.Site;
import com.kjlink.ahpips.entity.system.User;
import com.kjlink.common.util.ConvertHtml;

@Entity
@Table(name="t_project_land")//����Ȩ��Ϣ��
public class ProjectLand implements java.io.Serializable {
	private static final long serialVersionUID = 0L;
	
	@Id
	@GeneratedValue(generator = "paymentableGenerator")       
	@GenericGenerator(name = "paymentableGenerator", strategy = "native")    
	private Integer id;
	
	@Column(length = 40)
	private String code; //��Ŀ����
	
	@Column(length = 100)
	private String name; //��Ŀ����
	
	@Column(length = 100)
	private String constructName; //��Ŀ���赥λ����
	
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="project_id")
	private Project project ;//������Ŀ
	
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="land_bid_id")
	private LandBid landBid ;//�����б��������Ƴ�����Ϣ
	
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="land_sell_id")
	private LandSell landSell ;//��������ʹ��Ȩ���ú�ͬ��Ϣ
	
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="land_use_id")
	private LandUse landUse ;//�����õ�������Ϣ
	
	private Integer state = 0; //���״̬��0��δ��ˣ�1�����ͨ����2�����δͨ��
	
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(updatable = false,name="site_id")
	private Site site;	//��������
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_time")
	private Date createTime = new Date(); //����ʱ��

	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="user_id")
	private User approveUser;//�����Ա
	
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(updatable = false,name="create_user_id")
	private User createUser;//������Ա
	
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

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public LandBid getLandBid() {
		return landBid;
	}

	public void setLandBid(LandBid landBid) {
		this.landBid = landBid;
	}

	public LandSell getLandSell() {
		return landSell;
	}

	public void setLandSell(LandSell landSell) {
		this.landSell = landSell;
	}

	public LandUse getLandUse() {
		return landUse;
	}

	public void setLandUse(LandUse landUse) {
		this.landUse = landUse;
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
	
}
