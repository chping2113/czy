package com.kjlink.ahpips.web.action.system;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;

import com.kjlink.ahpips.Constants;
import com.kjlink.ahpips.entity.system.Alexa;
import com.kjlink.ahpips.service.system.AlexaService;
import com.kjlink.ahpips.web.action.BaseAction;

public class AlexaAction extends BaseAction<Alexa> {
	
	private static final long serialVersionUID = 1L;
	private Alexa model=new Alexa();
	private AlexaService alexaService;
	private String queryCode ;
	@Override
	public Alexa getModel() {
		return model;
	}
	
	@Override
	public void prepare() throws Exception {
		if (id != null && id > 0) {
			model = this.alexaService.findById(id);
		}
	}
	
	public String init(){
		this.pageInfo = this.alexaService.findPageAll(getPageNo(), getMaxPageSize());
		this.pageUrl = "system/alexa_init.action";
		return "alexaList";
	}
	
	public String initAdd(){
		return "alexaAdd";
	}
	
	public String add(){
		this.alexaService.merge(model);
		return this.init();
	}
	
	public String view(){
		return "alexaView";
	}
	
	public String delete(){
		this.alexaService.delete(model);
		return this.init();
	}
	
	public String query(){
		this.pageInfo = this.alexaService.getAlexaByTitle(getPageNo(), getMaxPageSize(),this.queryCode);
		return "alexaList";
	}
	
	public String getData(){
		try{
		Alexa alexa = this.getAlexaData(model);
		this.alexaService.merge(alexa);
		}catch (Exception e) {
			this.message="获取数据失败";
		}
		return "alexaView";
	}
	
	public String getAllData() throws Exception{
		List<Alexa> alexaList = this.alexaService.findAll();
		for(Alexa alexa : alexaList){
			try{
			alexa = this.getAlexaData(alexa);
			this.alexaService.merge(alexa);
			}catch (Exception e) {
			}
		}
		return this.init();
	}
	
	private Alexa getAlexaData(Alexa alexa) throws Exception{
		String url = "http://alexa.chinaz.com/Alexa_More.asp?Domain="+alexa.getUrl();
		HttpClient httpClient = new HttpClient();
		Thread.sleep(300);
		GetMethod method = new GetMethod(url);
		int statusCode = httpClient.executeMethod(method);
		 if (statusCode != HttpStatus.SC_OK) {
			 log.error("Method failed: " + method.getStatusLine());
			 log.info("%%%%%%数据抓取失败："+url);
			 return null;
		 }
		 BufferedReader br = new BufferedReader(new InputStreamReader(method.getResponseBodyAsStream()));
		 StringBuffer strBuf = new StringBuffer();
		 String tmp = "";
		 while((tmp = br.readLine()) != null) {
			 strBuf.append(tmp);
		 }
		 
		 String body = strBuf.toString();
		 int f1 = body.indexOf("每百万人中访问人数:");
		 int f2 = body.indexOf("每百万人访问页面中访问本站的页面数:");
		 int f3 = body.indexOf("页面访问量排名:");
		 int f4 = body.indexOf("平均每个访问者浏览的页面数:");
		 String a1 = body.substring(f1, f2);
		 String a2 = body.substring(f2, f3);
		 String a3 = body.substring(f4, body.length());
		 alexa.setPerson(this.getValue(a1));
		 alexa.setPage(this.getValue(a2));
		 alexa.setPersonPage(this.getValue(a3));
		 return alexa;
	}
	
	private String getValue(String str){
		String regS = "<td class=\"rank_left\">";
		String regE = "</td>";
		int start = str.indexOf(regS);
		String temp = str.substring(start,str.length());
		int end = temp.indexOf(regE);
		return temp.substring(temp.indexOf(regS)+22,end);
	}

	public AlexaService getAlexaService() {
		return alexaService;
	}

	public void setAlexaService(AlexaService alexaService) {
		this.alexaService = alexaService;
	}

	public String getQueryCode() {
		return queryCode;
	}

	public void setQueryCode(String queryCode) {
		this.queryCode = queryCode;
	}

}
