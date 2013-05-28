package com.kjlink.ahpips.web.action.info;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.ServletDispatcherResult;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import com.brady.common.util.Base64;
import com.kjlink.ahpips.Constants;
import com.kjlink.ahpips.entity.info.AttachFile;
import com.kjlink.ahpips.entity.info.News;
import com.kjlink.ahpips.entity.info.NewsCatelog;
import com.kjlink.ahpips.service.info.AttachFileService;
import com.kjlink.ahpips.service.info.NewsCatelogService;
import com.kjlink.ahpips.service.info.NewsService;
import com.kjlink.ahpips.web.action.BaseAction;
import com.kjlink.common.util.FileUtil;
import com.opensymphony.xwork2.Result;


public class NewsAction extends BaseAction<News> {
	private News model = new News(); //用于保存模型驱动对象
	private NewsService newsService;
	private NewsCatelogService newsCatelogService;
	private Integer catelogId = 0;
	private Integer secondCatelogId = 0;

	private AttachFileService attachFileService;
	private File attachFile ;
	private String attachFileContentType ;
	private String attachFileFileName ;
	
	private List<AttachFile> attachFileListNews ;
	public AttachFileService getAttachFileService() {
		return attachFileService;
	}

	public void setAttachFileService(AttachFileService attachFileService) {
		this.attachFileService = attachFileService;
	}

	public File getAttachFile() {
		return attachFile;
	}

	public void setAttachFile(File attachFile) {
		this.attachFile = attachFile;
	}

	public String getAttachFileContentType() {
		return attachFileContentType;
	}

	public void setAttachFileContentType(String attachFileContentType) {
		this.attachFileContentType = attachFileContentType;
	}

	public String getAttachFileFileName() {
		return attachFileFileName;
	}

	public void setAttachFileFileName(String attachFileFileName) {
		this.attachFileFileName = attachFileFileName;
	}



	public List<AttachFile> getAttachFileListNews() {
		return attachFileListNews;
	}

	public void setAttachFileListNews(List<AttachFile> attachFileListNews) {
		this.attachFileListNews = attachFileListNews;
	}

	/**
	 * 返回模型驱动对象
	 */
	public News getModel() {
		return model;
	}

	/**
	 * 实现Struts2的preparable接口
	 */
	public void prepare() throws Exception {
		if (id != null && id > 0) {
			model = this.newsService.findById(id);
		}
		String stid=this.getRequest().getParameter("id");
		if(stid!=null && !stid.equals("")){
			int tid=Integer.parseInt(stid);
			if( tid > 0) {
				//使用Base64对内容进行解码
				model = this.newsService.findById(tid);
			}
		}
	}
	
	public String list() throws Exception {
		this.getSession().remove("news_queryStr");
		if(catelogId != null && catelogId > 0) {
			this.getContext().put("newsCatelog", this.newsCatelogService.findById(catelogId));
			NewsCatelog newsCatelog=this.newsCatelogService.findById(catelogId).getParent();
			if(newsCatelog!=null){
				this.getContext().put("secondNewsCatelog", this.newsCatelogService.findSecondCatelogsByParentId( newsCatelog.getId()));
			}
			this.pageInfo = this.newsService.findPageByNewsCatelogId(catelogId, getPageNo(), getMaxPageSize());
		} 
		
		this.pageParam = "catelogId=" + catelogId;
		this.pageUrl = "info/news_list.action";
		return "listNews";
	}

	/**
	 * 快速查询方法
	 * @return
	 * @throws Exception
	 */
	public String query()  throws Exception {
		if(queryStr != null)
			this.getSession().put("news_queryStr", queryStr);
		else
			queryStr = (String)this.getSession().get("news_queryStr");
		
		if(catelogId != null && catelogId > 0) {
			this.getContext().put("newsCatelog", this.newsCatelogService.findById(catelogId));
			NewsCatelog newsCatelog=this.newsCatelogService.findById(catelogId).getParent();
			if(newsCatelog!=null){
				this.getContext().put("secondNewsCatelog", this.newsCatelogService.findSecondCatelogsByParentId( newsCatelog.getId()));
			}
			this.pageInfo = this.newsService.quickSearch(catelogId, queryStr, getPageNo(), getMaxPageSize());
		}
		
		this.pageUrl = "info/news_query.action";
		this.pageParam = "catelogId=" + catelogId;
		return "listNews";
	}
	public String upload() throws Exception{
		if(this.attachFile != null && attachFile.exists()){
			File file = new File(ServletActionContext.getServletContext().getRealPath(Constants.UPLOAD_FILE));
			if (!file.exists()) {
				file.mkdir();
			}
			String fileName = this.getLoginUserFromSession().getCode()+"_"+System.currentTimeMillis()+FileUtil.getExtention((this.attachFileFileName));
			//之前的"/"被置换成File.separator,以适应不同操作系统下的分隔符不同
			String filePath = ServletActionContext.getServletContext().getRealPath(File.separator+Constants.UPLOAD_FILE+File.separator+fileName);
			File uploadFile = new File(filePath);
		
			FileUtil.copyFile(this.attachFile, uploadFile);
			
			AttachFile attach = new AttachFile();
			attach.setFileName(fileName);
			System.out.println(fileName);
			attach.setRealName(attachFileFileName);
			attachFileListNews = (List<AttachFile>) this.getSession().get("attachFileListNews");
			if(attachFileListNews!=null && attachFileListNews.size()>0){
				attachFileListNews.add(attach);
			}else{
				attachFileListNews = new ArrayList<AttachFile>();
				attachFileListNews.add(attach);
			}
			this.getSession().put("attachFileListNews", attachFileListNews);
		}else{
			if(attachFile!=null && !attachFile.exists()){
				this.getContext().put("error", "2");
			}
			attachFileListNews = (List<AttachFile>) this.getSession().get("attachFileListNews");
		}
		return "uploadSucc";
	}
	
	public String deleteFile()throws Exception{
		String fileName = this.message;
		String stid=this.getRequest().getParameter("id");
		attachFileListNews = (List<AttachFile>) this.getSession().get("attachFileListNews");
		for(AttachFile attachFile : attachFileListNews){
			if(attachFile.getFileName().equals(fileName)){
				attachFileListNews.remove(attachFile);
				if(stid!=null && !stid.equals("")){
					
				}else{
					//之前的"/"被置换成File.separator,以适应不同操作系统下的分隔符不同
					File file = new File(ServletActionContext.getServletContext().getRealPath(File.separator+Constants.UPLOAD_FILE+File.separator+fileName));
					if(file.exists()){
						file.delete();
					}
				}
				break;
			}
		}
		this.getSession().put("attachFileListNews", attachFileListNews);
		return "uploadSucc";
	}
	
	public Result delete()  throws Exception {
		try {
			List<AttachFile> afList=attachFileService.findAttachFileByNews(model);
			for(AttachFile af : afList){
				//之前的"/"被置换成File.separator,以适应不同操作系统下的分隔符不同
				File file = new File(ServletActionContext.getServletContext().getRealPath(File.separator+Constants.UPLOAD_FILE+File.separator+af.getFileName()));
				if(file.exists()){
					file.delete();
				}
				attachFileService.delete(af);
			}
			this.newsService.delete(model);
		} catch(Exception e) {
			this.message = "对不起，当前记录已经被使用，不能被删除！";
			return new ServletDispatcherResult("/WEB-INF/pages/message.jsp");
		}
		return new ServletRedirectResult("info/news_query.action?pageNo=" 
				+ this.getPageNo() + "&catelogId=" + catelogId);
	}
	
	public String addRequest()  throws Exception {
		this.getSession().put("attachFileListNews", null);
		if(catelogId != null && catelogId > 0) {
			this.getContext().put("newsCatelog", this.newsCatelogService.findById(catelogId));
			this.getContext().put("secondCatelogList", this.newsCatelogService.findSecondCatelogsByParentId(catelogId));
		}
		if(id != null && id > 0) {
			//使用Base64对内容进行解码
			String content = model.getContent();
			if(content != null)
				model.setContent(new String(Base64.decode(content)));
		}
		return "addNews";
	}
	
	public Result add()  throws Exception {
		model.setCreateTime(new Date());
		model.setCreateUser(this.getLoginUserFromSession());
		
		if(secondCatelogId != null && secondCatelogId > 0) {
			model.setCatelog(this.newsCatelogService.findById(secondCatelogId));
		}
		//使用Base64对内容进行编码
		if(model.getContent() != null) {
			model.setContent(Base64.encode(model.getContent().getBytes()));
		}
		this.newsService.save(model);
		attachFileListNews = (List<AttachFile>) this.getSession().get("attachFileListNews");
		if(attachFileListNews!=null){
			for(AttachFile attachFile : attachFileListNews){
				//attachFile.setNews(model);
				attachFileService.merge(attachFile);
			}
		}
		this.getSession().remove("attachFileListNews");
		return new ServletRedirectResult("info/news_query.action?pageNo=" 
				+ this.getPageNo() + "&catelogId=" + catelogId);
	}

	public String largeFile(){
		this.getContext().put("error", "1");
		this.attachFileListNews = (List<AttachFile>) this.getSession().get("attachFileListNews");
		return "uploadSucc";
	}
	public String initFile() throws Exception{
		String stid=this.getRequest().getParameter("id");

		if(stid!=null && !stid.equals("")){
			int tid=Integer.parseInt(stid);
			if( tid > 0) {
		id=tid;
				this.attachFileListNews=attachFileService.findAttachFileByNews(model);
				this.getSession().put("attachFileListNews", attachFileListNews);
			}
		}
			return "uploadSucc";
	}
	public String editRequest()  throws Exception {
		if(catelogId != null && catelogId > 0) {
			this.getContext().put("newsCatelog", this.newsCatelogService.findById(catelogId));
			this.getContext().put("secondCatelogList", this.newsCatelogService.findSecondCatelogsByParentId(catelogId));
		}
		int tid=Integer.parseInt(this.getRequest().getParameter("id"));
		if( tid > 0) {
			//使用Base64对内容进行解码
			String content = model.getContent();
			if(content != null)
				model.setContent(new String(Base64.decode(content)));
		}
		return "addNews";
	}
	
	public Result edit()  throws Exception {
		if(secondCatelogId != null && secondCatelogId > 0) {
			model.setCatelog(this.newsCatelogService.findById(secondCatelogId));
		}
		//使用Base64对内容进行编码
		if(model.getContent() != null) {
			model.setContent(Base64.encode(model.getContent().getBytes()));
		}
		this.newsService.update(model);
		attachFileListNews = (List<AttachFile>) this.getSession().get("attachFileListNews");
		List<AttachFile> afList=attachFileService.findAttachFileByNews(model);
	
		for(AttachFile attachFile : attachFileListNews){
			//attachFile.setNews(model);
			attachFileService.merge(attachFile);
			for(int i=0;i<afList.size();i++){
				AttachFile af=afList.get(i);
				int id1=af.getId();
				if(attachFile.getId()==null){
					continue;
				}
				int id2=attachFile.getId();
				if(id1==id2){
					afList.remove(af);
				}
			}
		}
		for(AttachFile af : afList){	
			//之前的"/"被置换成File.separator,以适应不同操作系统下的分隔符不同
			File file = new File(ServletActionContext.getServletContext().getRealPath(File.separator+Constants.UPLOAD_FILE+File.separator+af.getFileName()));
			if(file.exists()){
				file.delete();
			}
			attachFileService.delete(af);
		}
		this.getSession().remove("attachFileListNews");
		return new ServletRedirectResult("info/news_query.action?pageNo="
				+ this.getPageNo() + "&catelogId=" + catelogId);
	}
	
	
	public NewsService getNewsService() {
		return newsService;
	}

	public void setNewsService(NewsService newsService) {
		this.newsService = newsService;
	}

	public Integer getCatelogId() {
		return catelogId;
	}

	public void setCatelogId(Integer catelogId) {
		this.catelogId = catelogId;
	}

	public NewsCatelogService getNewsCatelogService() {
		return newsCatelogService;
	}

	public void setNewsCatelogService(NewsCatelogService newsCatelogService) {
		this.newsCatelogService = newsCatelogService;
	}

	public Integer getSecondCatelogId() {
		return secondCatelogId;
	}

	public void setSecondCatelogId(Integer secondCatelogId) {
		this.secondCatelogId = secondCatelogId;
	}

}
