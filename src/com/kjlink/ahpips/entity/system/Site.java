package com.kjlink.ahpips.entity.system;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "t_site")
public class Site implements Serializable {

	/**
	 * վ���
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "paymentableGenerator")       
	@GenericGenerator(name = "paymentableGenerator", strategy = "native")    
	private Integer id;// վ����

	@Column(length = 30)
	private String code; // վ�����

	@Column(nullable = false, unique = true, length = 100)
	private String name;// վ������

	private Integer type = 0; // ��֯��������(ƽ̨:1 , ר��:0)

	@Lob
	private String content;// վ����ϸ����
	
	@Column(length = 1)
	private Integer enable = 0;// ��Ч��:0-δɾ��,1-�Ѿ�ɾ��

	@Column(length = 4)
	private String grade;// վ������,ʡ,��,��,��

	@Column(length = 1)
	private Integer state = 0;// վ��״̬:0-����,1-δ����

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "parent_site_id")
	private Site parent;// ��վ����

	@Column(length = 1)
	private Integer recommend = 0;// �����Ƽ�:0-����,1-������
	
	@Lob
	private String footer;// ҳ��

	@Column(length = 100)
	private String report;// �ٱ��绰

	@Column(length = 20)
	private String linkman; // ��ϵ��

	@Column(length = 20)
	private String tel; // ��ϵ�绰

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

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}


	
	

	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId() {
		return id;
	}

	public String getLinkman() {
		return linkman;
	}

	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Site getParent() {
		return parent;
	}

	public void setParent(Site parent) {
		this.parent = parent;
	}

	public String getFooter() {
		return footer;
	}

	public void setFooter(String footer) {
		this.footer = footer;
	}

	public String getReport() {
		return report;
	}

	public void setReport(String report) {
		this.report = report;
	}

	public void setEnable(Integer enable) {
		this.enable = enable;
	}

	public Integer getEnable() {
		return enable;
	}

}
