package com.kjlink.ahpips.web.action.info;

import java.io.File;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.apache.struts2.ServletActionContext;

import com.kjlink.ahpips.Constants;
import com.kjlink.ahpips.entity.info.AttachFile;
import com.kjlink.ahpips.service.info.AttachFileService;
import com.kjlink.ahpips.web.action.BaseAction;

public class DownloadExcelAction extends BaseAction<AttachFile> {
	private static final long serialVersionUID = 6329383258366253255L;
	
	private AttachFile attachFile = new AttachFile();
	private AttachFileService attachFileService ;
	private String fileName;
	private String realName;
	
	public void setFileName()
	{
		// 得到请求下载的文件名
		this.fileName = attachFile.getFileName();
		this.realName = attachFile.getRealName();
	}

	public String getFileName() throws UnsupportedEncodingException
	{
		this.realName = new String(this.realName.getBytes(), "ISO-8859-1");
		return this.realName;
	}
	
	//下载文件
	public InputStream getDownloadFile()
	{
		this.setFileName();
		//之前的"/"被置换成File.separator,以适应不同操作系统下的分隔符不同
		return ServletActionContext.getServletContext().getResourceAsStream(File.separator + Constants.UPLOAD_FILE + File.separator+this.fileName);
	}

	public String execute() throws Exception
	{
		//之前的"/"被置换成File.separator,以适应不同操作系统下的分隔符不同
		InputStream in = ServletActionContext.getServletContext().getResourceAsStream(File.separator +Constants.UPLOAD_FILE + File.separator +this.fileName);
		File file = new File(ServletActionContext.getServletContext().getRealPath(File.separator +Constants.UPLOAD_FILE + File.separator+this.fileName));
		if (file.exists()) {
			file.delete();
		}
		if(in!=null){
			return "downloadSuccess";
		}else{
			this.message  = "对不起，当前文件不存在，请联系系统管理员！";
			return "message";
		}
	}
	
	@Override
	public AttachFile getModel() {
		return null;
	}
	@Override
	public void prepare() throws Exception {
		String excelFileName = this.getRequest().getParameter("fileName");
		this.attachFile = new AttachFile();
		this.attachFile.setFileName(excelFileName);
		this.fileName = excelFileName ;
		this.attachFile.setRealName("信息公开统计.xls");
	}

	public AttachFile getAttachFile() {
		return attachFile;
	}

	public void setAttachFile(AttachFile attachFile) {
		this.attachFile = attachFile;
	}

	public AttachFileService getAttachFileService() {
		return attachFileService;
	}

	public void setAttachFileService(AttachFileService attachFileService) {
		this.attachFileService = attachFileService;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}
