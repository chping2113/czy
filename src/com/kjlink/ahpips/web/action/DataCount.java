package com.kjlink.ahpips.web.action;

import com.kjlink.ahpips.entity.system.Site;
import com.kjlink.ahpips.entity.system.User;

public class DataCount {
	private Site site;
	private int projectApproveCount;
	private int projectConstructCount;
	private int projectLandCount;
	private int projectMiningCount;
	private int projectAimCount;
	private int companyCreditCount;
	private int companyInfoCount;
	private int companyQualificationCount ;
	private int personQualificationCount;
	private int companyHonorCount;
	private int companyBadrecordCount;
	private int allCount;
	private User user;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getAllCount() {
		return allCount;
	}
	public void setAllCount(int allCount) {
		this.allCount = allCount;
	}
	public int getCompanyCreditCount() {
		return companyCreditCount;
	}
	public void setCompanyCreditCount(int companyCreditCount) {
		this.companyCreditCount = companyCreditCount;
	}
	public int getCompanyInfoCount() {
		return companyInfoCount;
	}
	public void setCompanyInfoCount(int companyInfoCount) {
		this.companyInfoCount = companyInfoCount;
	}
	public int getCompanyQualificationCount() {
		return companyQualificationCount;
	}
	public void setCompanyQualificationCount(int companyQualificationCount) {
		this.companyQualificationCount = companyQualificationCount;
	}
	public int getPersonQualificationCount() {
		return personQualificationCount;
	}
	public void setPersonQualificationCount(int personQualificationCount) {
		this.personQualificationCount = personQualificationCount;
	}
	public int getCompanyHonorCount() {
		return companyHonorCount;
	}
	public void setCompanyHonorCount(int companyHonorCount) {
		this.companyHonorCount = companyHonorCount;
	}
	public int getCompanyBadrecordCount() {
		return companyBadrecordCount;
	}
	public void setCompanyBadrecordCount(int companyBadrecordCount) {
		this.companyBadrecordCount = companyBadrecordCount;
	}
	public int getProjectAimCount() {
		return projectAimCount;
	}
	public void setProjectAimCount(int projectAimCount) {
		this.projectAimCount = projectAimCount;
	}
	public Site getSite() {
		return site;
	}
	public void setSite(Site site) {
		this.site = site;
	}
	public int getProjectApproveCount() {
		return projectApproveCount;
	}
	public void setProjectApproveCount(int projectApproveCount) {
		this.projectApproveCount = projectApproveCount;
	}
	public int getProjectConstructCount() {
		return projectConstructCount;
	}
	public void setProjectConstructCount(int projectConstructCount) {
		this.projectConstructCount = projectConstructCount;
	}
	public int getProjectLandCount() {
		return projectLandCount;
	}
	public void setProjectLandCount(int projectLandCount) {
		this.projectLandCount = projectLandCount;
	}
	public int getProjectMiningCount() {
		return projectMiningCount;
	}
	public void setProjectMiningCount(int projectMiningCount) {
		this.projectMiningCount = projectMiningCount;
	}
}
