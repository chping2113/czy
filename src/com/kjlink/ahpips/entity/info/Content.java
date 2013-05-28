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

import com.kjlink.ahpips.entity.system.User;

@Entity
@Table(name="t_content")
public class Content implements Serializable {

	/**
	 * �������ݱ�
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "paymentableGenerator")       
	@GenericGenerator(name = "paymentableGenerator", strategy = "native")    
	private Integer id;//���ݱ��
	
	@Column(length=100)
	private String content_title;//��������
	
	@Column(length=100)
	private String content_detail;//������Ϣ
	
	@Column(length=1)
	private Integer state;//����״̬
	
	@Column(length=100)
	private String content_file;  //�ϴ��ļ�
		
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
	
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name="scolumn_id")//��Ŀid
	private Scolumn scolumn;

/*	@ManyToMany(mappedBy = "contents", cascade = { CascadeType.PERSIST,
			CascadeType.MERGE })
	private Set<Scolumn> scolumns;*/

	public String getContent_title() {
		return content_title;
	}

	public void setContent_title(String content_title) {
		this.content_title = content_title;
	}

	public String getContent_detail() {
		return content_detail;
	}

	public void setContent_detail(String content_detail) {
		this.content_detail = content_detail;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getCreateId() {
		return createId;
	}

	public void setCreateId(User createId) {
		this.createId = createId;
	}

	public User getUpdateId() {
		return updateId;
	}

	public void setUpdateId(User updateId) {
		this.updateId = updateId;
	}

	public String getContent_file() {
		return content_file;
	}

	public void setContent_file(String content_file) {
		this.content_file = content_file;
	}

	public Scolumn getScolumn() {
		return scolumn;
	}

	public void setScolumn(Scolumn scolumn) {
		this.scolumn = scolumn;
	}

/*	public Set<Scolumn> getScolumns() {
		return scolumns;
	}

	public void setScolumns(Set<Scolumn> scolumns) {
		this.scolumns = scolumns;
	}*/


	


	

}
