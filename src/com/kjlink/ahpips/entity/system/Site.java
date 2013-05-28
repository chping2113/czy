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
	 * 站点表
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "paymentableGenerator")       
	@GenericGenerator(name = "paymentableGenerator", strategy = "native")    
	private Integer id;// 站点编号

	@Column(length = 30)
	private String code; // 站点代码

	@Column(nullable = false, unique = true, length = 100)
	private String name;// 站点名称

	private Integer type = 0; // 组织机构类型(平台:1 , 专栏:0)

	@Lob
	private String content;// 站点详细内容
	
	@Column(length = 1)
	private Integer enable = 0;// 有效性:0-未删除,1-已经删除

	@Column(length = 4)
	private String grade;// 站点类型,省,市,县,镇

	@Column(length = 1)
	private Integer state = 0;// 站点状态:0-启用,1-未启用

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "parent_site_id")
	private Site parent;// 父站点编号

	@Column(length = 1)
	private Integer recommend = 0;// 接受推荐:0-接受,1-不接受
	
	@Lob
	private String footer;// 页脚

	@Column(length = 100)
	private String report;// 举报电话

	@Column(length = 20)
	private String linkman; // 联系人

	@Column(length = 20)
	private String tel; // 联系电话

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
