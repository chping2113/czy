package com.kjlink.ahpips.web.action.info;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.ServletDispatcherResult;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import com.brady.common.util.Base64;
import com.kjlink.ahpips.Constants;
import com.kjlink.ahpips.entity.info.AttachFile;
import com.kjlink.ahpips.entity.info.Notice;
import com.kjlink.ahpips.entity.project.ProjectApprove;
import com.kjlink.ahpips.entity.system.User;
import com.kjlink.ahpips.service.info.AttachFileService;
import com.kjlink.ahpips.service.info.NoticeService;
import com.kjlink.ahpips.service.project.ProjectApproveService;
import com.kjlink.ahpips.web.action.BaseAction;
import com.kjlink.common.util.FileUtil;
import com.opensymphony.xwork2.Result;


public class NoticeAction extends BaseAction<ProjectApprove> {
	private ProjectApprove model = new ProjectApprove(); //用于保存模型驱动对象
	private ProjectApproveService projectApproveService;
	private AttachFileService attachFileService;
	
	private File attachFile ;
	private String attachFileContentType ;
	private String attachFileFileName ;
	
	private List<AttachFile> attachFileList ;
	
	/**
	 * 返回模型驱动对象
	 */
	public ProjectApprove getModel() {
		return model;
	}

	/**
	 * 实现Struts2的preparable接口
	 */
	public void prepare() throws Exception {
		if (id != null && id > 0) {
			model = this.projectApproveService.findById(id);
		}
		String stid=this.getRequest().getParameter("id");
		if(stid!=null && !stid.equals("")){
			int tid=Integer.parseInt(stid);
			if( tid > 0) {
				//使用Base64对内容进行解码
				model = this.projectApproveService.findById(tid);
			}
		}
		
	}
	
//	public String list() throws Exception {
//		this.getSession().remove("notice_queryStr");
//		User user=(User)this.getSession().get("loginUser");
//		this.pageInfo = this.noticeService.findPageAllSite(getPageNo(), getMaxPageSize(),user.getSite());
//		this.pageUrl = "info/notice_list.action";
//		return "listNotice";
//	}

	/**
	 * 快速查询方法
	 * @return
	 * @throws Exception
	 */
//	public String query()  throws Exception {
//		if(queryStr != null)
//			this.getSession().put("notice_queryStr", queryStr);
//		else
//			queryStr = (String)this.getSession().get("notice_queryStr");
//
//		User user=(User)this.getSession().get("loginUser");
//		this.pageInfo = this.noticeService.quickSearch(queryStr, getPageNo(), getMaxPageSize(),user.getSite());
//		this.pageUrl = "info/notice_query.action";
//		return "listNotice";
//	}
	
	public Result delete()  throws Exception {
		try {	
			List<AttachFile> afList=attachFileService.findAttachFileByProjectApprove(model);
			for(AttachFile af : afList){
				//之前的"/"被置换成File.separator,以适应不同操作系统下的分隔符不同
				File file = new File(ServletActionContext.getServletContext().getRealPath(File.separator+Constants.UPLOAD_FILE+File.separator+af.getFileName()));
				if(file.exists()){
					file.delete();
				}
				attachFileService.delete(af);
			}
			this.projectApproveService.delete(model);
		} catch(Exception e) {
			this.message = "对不起，当前记录已经被使用，不能被删除！";
			return new ServletDispatcherResult("/WEB-INF/pages/message.jsp");
		}
		return new ServletRedirectResult("info/notice_query.action?pageNo=" + this.getPageNo());
	}
	
	public String addRequest()  throws Exception {
		this.getSession().put("attachFileList", null);
		if(id != null && id > 0) {
			//使用Base64对内容进行解码
			String content = model.getContent();
			if(content != null)
				model.setContent(new String(Base64.decode(content)));
		}
		this.getSession().remove("attachFileList");
		return "addNotice";
	}
	
	public Result add()  throws Exception {
		model.setCreateTime(new Date());
		model.setCreateUser(this.getLoginUserFromSession());
		//使用Base64对内容进行编码
		if(model.getContent() != null) {
			model.setContent(Base64.encode(model.getContent().getBytes()));
		}
		//处理浮动显示时间
//		if(model.getFloatShow() != null && model.getFloatShow() == 1) {
//			Calendar cal = Calendar.getInstance();
//			cal.setTime(model.getCreateTime());
//			cal.add(Calendar.DAY_OF_YEAR, model.getFloatDays());
//			model.setFloatEndTime(cal.getTime());
//		}
//		this.noticeService.save(model);
		attachFileList = (List<AttachFile>) this.getSession().get("attachFileList");
		if(attachFileList!=null){
			for(AttachFile attachFile : attachFileList){
				attachFile.setProjectApprove(model);
				attachFileService.merge(attachFile);
			}
		}
		this.getSession().remove("attachFileList");
		return new ServletRedirectResult("info/notice_query.action?pageNo=" + this.getPageNo());
	}
	
	public String upload() throws Exception{
		if(this.attachFile != null && this.attachFile.exists()){
			File file = new File(ServletActionContext.getServletContext().getRealPath(Constants.UPLOAD_FILE));
			if (!file.exists()) {
				file.mkdir();
			}
			String fileName = this.getLoginUserFromSession().getCode()+"_"+System.currentTimeMillis()+FileUtil.getExtention((this.attachFileFileName));
			log.info("JIJIJIJI"+fileName);
			//之前的"/"被置换成File.separator,以适应不同操作系统下的分隔符不同
			String filePath = ServletActionContext.getServletContext().getRealPath(File.separator+Constants.UPLOAD_FILE+File.separator+fileName);
			log.info("JIJIJIJI"+filePath);
			File uploadFile = new File(filePath);
			FileUtil.copyFile(this.attachFile, uploadFile);
			//uploadFile
			AttachFile attach = new AttachFile();
			attach.setFileName(fileName);
			//log.info("添加对象");
			attach.setRealName(attachFileFileName);
			attachFileList = (List<AttachFile>) this.getSession().get("attachFileList");
			if(attachFileList!=null && attachFileList.size()>0){
				attachFileList.add(attach);
			}else{
				attachFileList = new ArrayList<AttachFile>();
				attachFileList.add(attach);
			}
			this.getSession().put("attachFileList", attachFileList);
		}
		else{
			if(attachFile!=null && !attachFile.exists()){
				this.getContext().put("error", "2");
			}
			attachFileList = (List<AttachFile>) this.getSession().get("attachFileList");
//			System.out.println(model.getId());
//			if(model.getId()!=null){
//				this.attachFileList=attachFileService.findAttachFileByNotice(model);
//				this.getSession().put("attachFileList", attachFileList);
//			}
		}
		return "uploadSucc";
	}
	public String largeFile(){
		this.getContext().put("error", "1");
		this.attachFileList = (List<AttachFile>) this.getSession().get("attachFileList");
		return "uploadSucc";
	}
	public String initFile() throws Exception{
		String stid=this.getRequest().getParameter("id");

		if(stid!=null && !stid.equals("")){
			int tid=Integer.parseInt(stid);
			if( tid > 0) {
				
		id=tid;
				this.attachFileList=attachFileService.findAttachFileByProjectApprove(model);
				this.getSession().put("attachFileList", attachFileList);
			}
		}
			return "uploadSucc";
	}
	public String deleteFile()throws Exception{
		String stid=this.getRequest().getParameter("id");
		String fileName = this.message;
		attachFileList = (List<AttachFile>) this.getSession().get("attachFileList");
		for(AttachFile attachFile : attachFileList){
			if(attachFile.getFileName().equals(fileName)){
				attachFileList.remove(attachFile);

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
		this.getSession().put("attachFileList", attachFileList);
		return "uploadSucc";
	}
	
	public String editRequest()  throws Exception {
		int tid=Integer.parseInt(this.getRequest().getParameter("id"));
		if( tid > 0) {
			//使用Base64对内容进行解码
			String content = model.getContent();
			if(content != null)
				model.setContent(new String(Base64.decode(content)));
		}
//		this.attachFileList=attachFileService.findAttachFileByNotice(model);
//		this.getSession().put("attachFileList", attachFileList);
		return "addNotice";
	}
	
	public Result edit()  throws Exception {
		if(model.getContent() != null) {
			model.setContent(Base64.encode(model.getContent().getBytes()));
		}
		//处理浮动显示时间
//		if(model.getFloatShow() != null && model.getFloatShow() == 1) {
//			Calendar cal = Calendar.getInstance();
//			cal.setTime(model.getCreateTime());
//			cal.add(Calendar.DAY_OF_YEAR, model.getFloatDays());
//			model.setFloatEndTime(cal.getTime());
//		}
		this.projectApproveService.update(model);
		attachFileList = (List<AttachFile>) this.getSession().get("attachFileList");
		List<AttachFile> afList=attachFileService.findAttachFileByProjectApprove(model);
	
		for(AttachFile attachFile : attachFileList){
			attachFile.setProjectApprove(model);
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
		this.getSession().remove("attachFileList");
		return new ServletRedirectResult("info/notice_query.action?pageNo=" + this.getPageNo());
	}
	
	

	public ProjectApproveService getProjectApproveService() {
		return projectApproveService;
	}

	public void setProjectApproveService(ProjectApproveService projectApproveService) {
		this.projectApproveService = projectApproveService;
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

	public List<AttachFile> getAttachFileList() {
		return attachFileList;
	}

	public void setAttachFileList(List<AttachFile> attachFileList) {
		this.attachFileList = attachFileList;
	}

	public AttachFileService getAttachFileService() {
		return attachFileService;
	}

	public void setAttachFileService(AttachFileService attachFileService) {
		this.attachFileService = attachFileService;
	}
}
