package com.kjlink.ahpips.entity.info;

import java.io.Serializable;
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

@Entity
@Table(name="t_scolumn")
public class Scolumn implements Serializable {

	/**
	 * ��Ŀ��
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "paymentableGenerator")       
	@GenericGenerator(name = "paymentableGenerator", strategy = "native")    
	private Integer id;//��Ŀ���
	
	@Column(length=100)
	private String name;//��Ŀ����
	
	@Column(length=1)
	private Integer state;//��Ŀ״̬
	
	@Column(length = 1)
	private Integer enable = 0;// ��Ч��:0-δɾ��,1-�Ѿ�ɾ��
	
	@Column(length = 10)
	private String type;// ��Ŀ����:�̶���Ŀ,�Զ�����Ŀ
	
	@Column(length = 2)
	private Integer stick;// �ö�����
	
	@Column(length = 3)
	private Integer expire;// �ö���Ч��
	
	@Column(length = 1)
	private Integer position;// ��ʾ˳��
	
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name="parent_id")
	private Scolumn parent;//����Ŀ���
	
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name="site_id")
	private Site site;//����Ŀ���
		
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name="create_id")
	private User createId;//�����˱��
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_time")
	private Date createTime;//����ʱ��
	
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name="update_id")
	private User updateId;//�����˱��
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "update_time")
	private Date updateTime;//������ʱ��
	
/*	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "t_scolumn_content", joinColumns = @JoinColumn(name = "scolumn_id"), inverseJoinColumns = @JoinColumn(name = "content_id"))
	private Set<Content> contents;*/

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
		this.name = name;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public User getCreateId() {
		return createId;
	}

	public void setCreateId(User createId) {
		this.createId = createId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public User getUpdateId() {
		return updateId;
	}

	public void setUpdateId(User updateId) {
		this.updateId = updateId;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Scolumn getParent() {
		return parent;
	}

	public void setParent(Scolumn parent) {
		this.parent = parent;
	}

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

	public Integer getEnable() {
		return enable;
	}

	public void setEnable(Integer enable) {
		this.enable = enable;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getStick() {
		return stick;
	}

	public void setStick(Integer stick) {
		this.stick = stick;
	}

	public Integer getExpire() {
		return expire;
	}

	public void setExpire(Integer expire) {
		this.expire = expire;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

/*	public Set<Content> getContents() {
		return contents;
	}

	public void setContents(Set<Content> contents) {
		this.contents = contents;
	}*/


	

}