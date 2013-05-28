package com.kjlink.ahpips.entity.system;

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
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

@Entity
@Table(name = "t_home_page")
public class HomePage implements java.io.Serializable {
	private static final long serialVersionUID = 0L;

	@Id
	@GeneratedValue(generator = "paymentableGenerator")       
	@GenericGenerator(name = "paymentableGenerator", strategy = "native")    
	private Integer id;

	@Column(name = "logo_name", length = 50)
	private String logoName; // logo图片文件名

	@Lob
	private String footer;// 首页页脚内容

	private Integer pid;

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	@Lob
	private String report;// 首页显示举报电话

	private Integer approve = 0;// 项目审批信息显示顺序

	private Integer construct = 0;// 项目建设管理信息显示顺序

	private Integer land = 0;// 土地权审批信息显示顺序

	private Integer mining = 0;// 矿业权审批信息显示顺序

	private Integer aim = 0;// 土地矿业权审批信息显示顺序

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "site_id")
	private Site site; // 所属机构

	/*
	 * @ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	 * @JoinColumn(name="permission_id") private Permission permission; //项目ID
	 * 
	 * public Permission getPermission() { return permission; }
	 * 
	 * public void setPermission(Permission permission) { this.permission =
	 * permission; }
	 */
	public Integer getMining() {
		return mining;
	}

	public void setMining(Integer mining) {
		this.mining = mining;
	}

	public Integer getAim() {
		return aim;
	}

	public void setAim(Integer aim) {
		this.aim = aim;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogoName() {
		return logoName;
	}

	public void setLogoName(String logoName) {
		this.logoName = logoName;
	}

	public String getFooter() {
		return footer;
	}

	public void setFooter(String footer) {
		// this.footer = footer;
		this.footer = Jsoup.clean(footer, Whitelist.basic());
	}

	public String getReport() {
		return report;
	}

	public void setReport(String report) {
		// this.report = report;
		this.report = Jsoup.clean(report, Whitelist.basic());
	}

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

	public Integer getApprove() {
		return approve;
	}

	public void setApprove(Integer approve) {
		this.approve = approve;
	}

	public Integer getConstruct() {
		return construct;
	}

	public void setConstruct(Integer construct) {
		this.construct = construct;
	}

	public Integer getLand() {
		return land;
	}

	public void setLand(Integer land) {
		this.land = land;
	}

}
