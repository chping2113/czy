package com.kjlink.ahpips.service.system.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.kjlink.ahpips.dao.system.CoderDAO;
import com.kjlink.ahpips.entity.system.Coder;
import com.kjlink.ahpips.service.impl.BaseServiceImpl;
import com.kjlink.ahpips.service.system.CoderService;
import com.kjlink.ahpips.Constants;
import com.kjlink.common.util.DateTypeConvert;

@Service("coderService")
public class CoderServiceImpl extends BaseServiceImpl<Coder> implements CoderService {
	private CoderDAO coderDAO ;
	
	public String generateCoderByPrefix(String prefix,String code){
		Coder coder = new Coder();
		String serialStr = "" ;
		int serialNum = 0 ;
		String year = DateTypeConvert.dateToYear(new Date()) ;
		List<Coder> coderList = coderDAO.getCoderByPrefix(prefix);
		if(coderList.size()>0&&coderList.size()==1){
			coder = coderList.get(0);
			serialNum = coder.getSerialNum();
			serialStr = serialNum + "";
			while(serialStr.length()<Constants.PROJECT_SERIAL_LENGTH){
				serialStr = "0" + serialStr;
			}
			if(year.equals(coder.getYear()) && (code.equals(prefix+year+serialStr)||code.equals("addCode"))){
				coder.setSerialNum(serialNum+1);
				serialNum++;
			}else if(!year.equals(coder.getYear())){
				coder.setYear(year);
				serialNum = 1;
				coder.setSerialNum(1);
			}
			//coderDAO.merge(coder);
		}else if(coderList.size()==0){
			coder.setPrefix(prefix);
			coder.setYear(DateTypeConvert.dateToYear(new Date()));
			coder.setSerialNum(1);
			//coderDAO.merge(coder);
			serialNum = 1;
		}else{
			return "error";
		}
		
		coderDAO.merge(coder);
		serialStr = serialNum + "";
		while(serialStr.length()<Constants.PROJECT_SERIAL_LENGTH){
			serialStr = "0" + serialStr;
		}
		return prefix+year+serialStr; 
	}

	public CoderDAO getCoderDAO() {
		return coderDAO;
	}

	public void setCoderDAO(CoderDAO coderDAO) {
		super.setCommonDAO(coderDAO);
		this.coderDAO = coderDAO;
	}

}
