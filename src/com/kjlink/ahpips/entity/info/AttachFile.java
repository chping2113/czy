package com.kjlink.ahpips.entity.info;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.kjlink.ahpips.entity.project.ProjectApprove;

@Entity
@Table(name = "t_attach_file")
public class AttachFile implements java.io.Serializable {
	private static final long serialVersionUID = 0L;
	
	@Id
	@GeneratedValue(generator = "paymentableGenerator")       
	@GenericGenerator(name = "paymentableGenerator", strategy = "native")    
	private Integer id;
	
	@Column(name = "file_name" , length = 200)
	private String fileName; //上传文件名
	
	@Column(name = "real_name" , length = 200)
	private String realName; //上传源文件名
	
	
	
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="projectApprove_id")
	private ProjectApprove projectApprove; //公告管理
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	
	public ProjectApprove getProjectApprove() {
		return projectApprove;
	}

	public void setProjectApprove(ProjectApprove projectApprove) {
		this.projectApprove = projectApprove;
	}

}
