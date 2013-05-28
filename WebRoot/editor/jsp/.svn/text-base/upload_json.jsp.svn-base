<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*,java.io.*" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="org.apache.commons.fileupload.*" %>
<%@ page import="org.apache.commons.fileupload.disk.*" %>
<%@ page import="org.apache.commons.fileupload.servlet.*" %>
<%@ page import="org.json.simple.*" %>
<%@ page import="org.apache.struts2.dispatcher.multipart.*" %>
<%

/**
 * 用于KindEdiotr 3.5的文件上传处理程序，只能使用于Struts2环境，如果是非struts2环境，则可以直接使用该控件自带的处理程序
 * Created by zhanggj at 2011.3.1 for struts2 context
 */

//之前的"/"被置换成File.separator,以适应不同操作系统下的分隔符不同
//文件保存目录路径
String savePath = pageContext.getServletContext().getRealPath(File.separator) + "upload_images" + File.separator;
//文件保存后的URL
//String saveUrl = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
String saveUrl = "upload_images" + File.separator ;

//定义允许上传的文件扩展名
String[] fileTypes = new String[]{"gif", "jpg", "jpeg", "png", "bmp"};


//最大文件大小
long maxSize = 1024 * 1024 * 5; //5Mb
response.setContentType("text/html; charset=UTF-8");

//检查目录
File uploadDir = new File(savePath);
if(!uploadDir.isDirectory()){
	out.println(getError("上传目录upload_images不存在。"));
	return;
}
//检查目录写权限
if(!uploadDir.canWrite()){
	out.println(getError("没有上传目录upload_images的写权限。"));
	return;
}

//由于Strut2对request做了包装，因此在这里特殊处理
if(! (request instanceof MultiPartRequestWrapper)) {
	out.println(getError("后台Web服务运行环境不是Struts2环境，文件上传失败。"));
	return;
}

MultiPartRequestWrapper reqWrapper = (MultiPartRequestWrapper)request;
String inputFileFieldName = "imgFile"; //imgFile是kindeditor的文件上传表单域字段名
//获得上传的文件名
String uploadFileName = reqWrapper.getFileNames(inputFileFieldName)[0];
//获得上传文件
File uploadFile = reqWrapper.getFiles(inputFileFieldName)[0];

//检查上传的文件是否有效
//检查文件扩展名
String fileExt = uploadFileName.substring(uploadFileName.lastIndexOf(".") + 1).toLowerCase();
if(!Arrays.<String>asList(fileTypes).contains(fileExt)){
	out.println(getError("不允许上传扩展名为" + fileExt + "的文件。"));
	return;
}
//检查文件大小
if(uploadFile.length() > maxSize) {
	out.println(getError("上传的文件大小超过限制。"));
	return;	
}

//重命名上传的文件名
SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
String newFileName = df.format(new Date()) + "_" + new Random().nextInt(1000) + "." + fileExt;
saveUrl += newFileName;
//设置上传后的图片URL

//System.out.println("newFileName:" + newFileName);
//System.out.println("saveUrl:" + saveUrl);

//保存上传文件
BufferedInputStream bis = null;
BufferedOutputStream bos= null;
try{
	byte[] buf = new byte[4096];
	bis = new BufferedInputStream(new FileInputStream(uploadFile));
	bos= new BufferedOutputStream(new FileOutputStream(savePath + newFileName));
	while(true) {
		int len = bis.read(buf);
		if(len <= 0)
			break;
		
		bos.write(buf, 0, len);
	}
}catch(Exception e){
	out.println(getError("保存上传文件失败。"));
	return;
}finally {
	bis.close();
	bos.close();
	uploadFile.delete();
}

//向Kindeditor返回结果信息
JSONObject obj = new JSONObject();
obj.put("error", 0);
obj.put("url", saveUrl);
out.println(obj.toJSONString());
		

%>
<%!
private String getError(String message) {
	JSONObject obj = new JSONObject();
	obj.put("error", 1);
	obj.put("message", message);
	return obj.toJSONString();
}
%>