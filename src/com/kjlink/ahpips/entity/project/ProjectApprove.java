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

import com.kjlink.ahpips.entity.info.Scolumn;
import com.kjlink.ahpips.entity.system.Site;
import com.kjlink.ahpips.entity.system.User;
import com.kjlink.common.util.ConvertHtml;

@Entity
@Table(name = "t_project_approve")//��Ŀ������Ϣ��
public class ProjectApprove implements java.io.Serializable {
	private static final long serialVersionUID = 0L;

	@Id
	@GeneratedValue(generator = "paymentableGenerator")       
	@GenericGenerator(name = "paymentableGenerator", strategy = "native")    
	private Integer id;
	
	@Column(length = 40)
	private String code; //��Ŀ����
	
	@Column(length = 100)
	private String name; //����
	
	private String scolumnName;
	
	
	
	private String content;  //��������
	
	@Column(length = 1)
	private Integer enable = 0;// ��Ч��:0-δɾ��,1-�Ѿ�ɾ��
	
	@Column(length = 1)
	private Integer renable=0;// 0-δ�Ƽ�,1-�Ѿ��Ƽ�
	
	
	private Integer state = 0; //���״̬��0��δ��ˣ�1�����ͨ����2�����δͨ�� ��3���ύ���(�ؼ�״̬)
	

	
	
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(updatable = false,name="site_id")//�ؼ���֯����id
	private Site site;	//�ؼ���������
	
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_time")
	private Date createTime =  new Date(); //����ʱ��

	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="user_id")
	private User approveUser;//�����Ա
	
	
	
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(updatable = false,name="create_user_id")
	private User createUser;//������Ա
	
	
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name="scolumn_id")//��Ŀid
	private Scolumn scolumn;
	
	public Scolumn getScolumn() {
		return scolumn;
	}

	public void setScolumn(Scolumn scolumn) {
		this.scolumn = scolumn;
	}

	public User getCreateUser() {
		return createUser;
	}

	public void setCreateUser(User createUser) {
		this.createUser = createUser;
	}

	private Integer approveType=0;
	
	public Integer getApproveType() {
		return approveType;
	}

	public void setApproveType(Integer approveType) {
		this.approveType = approveType;
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

	

	
	
//	public String getTitle() {
//		return title;
//	}
//
//	public void setTitle(String title) {
//		//this.name = name;
//		this.title = title;
//	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getScolumnName() {
		return scolumnName;
	}

	public void setScolumnName(String scolumnName) {
		this.scolumnName = scolumnName;
	}

	public Integer getEnable() {
		return enable;
	}

	

	public void setEnable(Integer enable) {
		this.enable = enable;
	}

	public Integer getRenable() {
		return renable;
	}

	public void setRenable(Integer renable) {
		this.renable = renable;
	}
}
