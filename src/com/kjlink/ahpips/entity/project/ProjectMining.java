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
@Table(name="t_project_Mining")//��ҵȨ��Ϣ��
public class ProjectMining implements java.io.Serializable {
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
	@JoinColumn(name="prospect_approve_id")
	private ProspectApprove prospectApprove ;//̽��Ȩ������Ϣ
	
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="prospect_sell_id")
	private ProspectSell prospectSell ;//̽��Ȩ������Ϣ
	
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="mine_approve_id")
	private MineApprove mineApprove ;//�ɿ�Ȩ������Ϣ
	
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="mine_sell_id")
	private MineSell mineSell ;//�ɿ�Ȩ������Ϣ
	
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

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public ProspectApprove getProspectApprove() {
		return prospectApprove;
	}

	public void setProspectApprove(ProspectApprove prospectApprove) {
		this.prospectApprove = prospectApprove;
	}

	public ProspectSell getProspectSell() {
		return prospectSell;
	}

	public void setProspectSell(ProspectSell prospectSell) {
		this.prospectSell = prospectSell;
	}

	public MineApprove getMineApprove() {
		return mineApprove;
	}

	public void setMineApprove(MineApprove mineApprove) {
		this.mineApprove = mineApprove;
	}

	public MineSell getMineSell() {
		return mineSell;
	}

	public void setMineSell(MineSell mineSell) {
		this.mineSell = mineSell;
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
