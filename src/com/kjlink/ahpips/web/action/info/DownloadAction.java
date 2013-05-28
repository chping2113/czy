package com.kjlink.ahpips.web.action.info;

import java.io.File;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kjlink.ahpips.Constants;
import com.kjlink.ahpips.entity.info.AttachFile;
import com.kjlink.ahpips.service.info.AttachFileService;
import com.kjlink.ahpips.web.action.BaseAction;

public class DownloadAction extends BaseAction<AttachFile> {
	private static final long serialVersionUID = 6329383258366253255L;
	private static final Logger logger = LoggerFactory.getLogger(DownloadAction.class);
	private AttachFile attachFile = new AttachFile();
	private AttachFileService attachFileService ;
	private String fileName;
	private String realName;	
	
	public void setFileName()
	{	
		// �õ��������ص��ļ���
		this.fileName = attachFile.getFileName();
		this.realName = attachFile.getRealName();
	}

	public String getFileName() throws UnsupportedEncodingException
	{
		this.realName = new String(this.realName.getBytes(), "ISO-8859-1");
		return this.realName;
	}
	
	//�����ļ�
	public InputStream getDownloadFile() throws UnsupportedEncodingException
	{

		this.setFileName();
		
		//֮ǰ��"/"���û���File.separator,����Ӧ��ͬ����ϵͳ�µķָ�����ͬ
		return ServletActionContext.getServletContext().getResourceAsStream(File.separator +Constants.UPLOAD_FILE + File.separator + fileName);
	}

	public String execute() throws Exception
	{
		String fname = attachFile.getFileName();
		
		//֮ǰ��"/"���û���File.separator,����Ӧ��ͬ����ϵͳ�µķָ�����ͬ
		InputStream in = ServletActionContext.getServletContext().getResourceAsStream(File.separator + Constants.UPLOAD_FILE + File.separator  + fname);
		if(in!=null){
			return "downloadSuccess";
		}else{
			this.message  = "�Բ��𣬵�ǰ�ļ������ڣ�����ϵϵͳ����Ա��";
			return "message";
		}
	}
	
	@Override
	public AttachFile getModel() {
		return null;
	}
	@Override
	public void prepare() {
		try{
			if(id != null && id>0){
				attachFile = this.attachFileService.findById(id);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
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
