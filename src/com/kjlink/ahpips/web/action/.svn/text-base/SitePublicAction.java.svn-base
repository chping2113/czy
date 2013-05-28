package com.kjlink.ahpips.web.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.dispatcher.ServletDispatcherResult;

import com.kjlink.ahpips.Constants;

import com.kjlink.ahpips.entity.info.News;
import com.kjlink.ahpips.entity.info.NewsCatelog;
import com.kjlink.ahpips.entity.info.Notice;
import com.kjlink.ahpips.entity.project.KeyProject;
import com.kjlink.ahpips.entity.project.KeyProjectKind;
import com.kjlink.ahpips.entity.project.ProjectApprove;
import com.kjlink.ahpips.entity.project.ProjectConstruct;
import com.kjlink.ahpips.entity.project.ProjectLand;

import com.kjlink.ahpips.entity.system.Site;


import com.kjlink.ahpips.service.info.NewsService;
import com.kjlink.ahpips.service.info.NoticeService;
import com.kjlink.ahpips.service.project.ProjectAegisService;
import com.kjlink.ahpips.service.project.ProjectApproveService;
import com.kjlink.ahpips.service.project.ProjectConstructService;
import com.kjlink.ahpips.service.project.ProjectIssueService;
import com.kjlink.ahpips.service.project.ProjectLandService;

import com.kjlink.ahpips.service.system.SiteService;

import com.kjlink.ahpips.service.system.SiteService;
import com.opensymphony.xwork2.Result;

public class SitePublicAction extends PublicAction{
	private NoticeService noticeService;
	private NewsService newsService;

	private ProjectApproveService projectApproveService ;
	private ProjectConstructService projectConstructService;
	private ProjectLandService projectLandService ;

	private ProjectAegisService projectAegisService;
	private ProjectIssueService projectIssueService;
	private SiteService siteService;
	
	/**
	 * 显示各专栏首页内容
	 * @return
	 * @throws Exception
	 */
	public String index() throws Exception { 
		String[] tmp = this.getContext().getName().split("_");
		String siteCode = tmp[1];
		if("index".equals(siteCode) || "listNewsByCatelogId".equals(siteCode) || "navProjectPublic".equals(siteCode) || "navCreditPublic".equals(siteCode) || "showComplaint".equals(siteCode)){
			siteCode = Constants.ANHUI;
		}
		Site site = this.siteService.findByCode(siteCode);
		this.getSession().put("session_site", site);
		this.getData(site);
		return "index";
	}
	
	private void getData(Site site){
		//取最近发布的通知公告
		List<Notice> noticeList = this.noticeService.findNotice(10);
		this.getContext().put("noticeList", noticeList);
		
		//取最近发布的浮动通知公告
		List<Notice> floatNoticeList = this.noticeService.findFloatNotice(site,5);
		this.getContext().put("floatNoticeList", floatNoticeList);
		
		//取最近发布的标题图片新闻
		List<News> imageNewsList = this.newsService.findImageNews(5);
		this.getContext().put("imageNewsList", imageNewsList);
		
		//取最近发布的非图片标题新闻
		List<News> nonImageNewsList = this.newsService.findNonImageNews(10);
		this.getContext().put("nonImageNewsList", nonImageNewsList);
		
		//取最近项目审批公开信息
		List<ProjectApprove> projectApproveList = projectApproveService.findProjectApproveForPulbic(10,site);
		this.getContext().put("projectApproveList", projectApproveList);
		
		//取最近项目建设管理公开信息
		List<ProjectConstruct> projectConstructList = projectConstructService.findProjectConstructForPulbic(10,site);
		this.getContext().put("projectConstructList", projectConstructList);
		
		//取最近土地矿业审批出让信息
		List<ProjectLand> projectLandList = projectLandService.findProjectLandForPulbic(10,site);
		this.getContext().put("projectLandList", projectLandList);
		
		
		
		//重点项目信息公开
		List<KeyProjectKind> keyProjectKindList = projectAegisService.findKeyAll(site);
		Map keyProjectMap = new HashMap();
		if(keyProjectKindList != null &&keyProjectKindList.size() > 0){
			for(int i=0; i<keyProjectKindList.size(); i++){
				KeyProjectKind keyProjectKind = (KeyProjectKind)keyProjectKindList.get(i);
				List<KeyProject> keyProjectList =  projectIssueService.findProjectIdByKindId(keyProjectKind);
				keyProjectMap.put(keyProjectKind.getId(), keyProjectList);
			}
		}
		this.getContext().put("keyProjectKindList", keyProjectKindList);
		this.getContext().put("keyProjectMap", keyProjectMap);
		
		//组织机构信息
		List<Site> shengzhiSiteList = this.siteService.findAllShengZhiSites();
		this.getContext().put("shengzhiSiteList", shengzhiSiteList);
	}
	
	public NoticeService getNoticeService() {
		return noticeService;
	}

	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}

	public NewsService getNewsService() {
		return newsService;
	}

	public void setNewsService(NewsService newsService) {
		this.newsService = newsService;
	}

	

	public ProjectApproveService getProjectApproveService() {
		return projectApproveService;
	}

	public void setProjectApproveService(ProjectApproveService projectApproveService) {
		this.projectApproveService = projectApproveService;
	}

	public ProjectConstructService getProjectConstructService() {
		return projectConstructService;
	}

	public void setProjectConstructService(
			ProjectConstructService projectConstructService) {
		this.projectConstructService = projectConstructService;
	}

	public ProjectLandService getProjectLandService() {
		return projectLandService;
	}

	public void setProjectLandService(ProjectLandService projectLandService) {
		this.projectLandService = projectLandService;
	}

	public ProjectAegisService getProjectAegisService() {
		return projectAegisService;
	}

	public void setProjectAegisService(ProjectAegisService projectAegisService) {
		this.projectAegisService = projectAegisService;
	}

	public ProjectIssueService getProjectIssueService() {
		return projectIssueService;
	}

	public void setProjectIssueService(ProjectIssueService projectIssueService) {
		this.projectIssueService = projectIssueService;
	}

	public SiteService getSiteService() {
		return siteService;
	}

	public void setSiteService(SiteService siteService) {
		this.siteService = siteService;
	}

}
