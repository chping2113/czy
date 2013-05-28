package com.kjlink.ahpips;

import java.util.Date;
import java.util.List;

import junit.framework.TestCase;


import org.junit.BeforeClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kjlink.ahpips.entity.info.Scolumn;
import com.kjlink.ahpips.entity.info.ScolumnProperty;
import com.kjlink.ahpips.service.info.ScolumnPropertyService;
import com.kjlink.ahpips.service.info.ScolumnService;

public class ScolumnPropertyTest extends TestCase{

	/**
	 * 8Ä¿ï¿½ï¿½ï¿½ÝµÄ²ï¿½ï¿½ï¿½ï¿½ï¿½
	 */
	private static ApplicationContext ctx ;
	
	@BeforeClass
	public static void beforeClass() throws Exception{
		
			ctx = new ClassPathXmlApplicationContext(new String[] {"config/spring/applicationContext.xml", "config/spring/applicationContext-dao.xml"});
		
	}
	
	
	
	public static void main(String args[]) throws Exception {
		beforeClass();
		
		ScolumnPropertyService service = (ScolumnPropertyService) ctx.getBean("scolumnPropertyService");
		ScolumnService service2 = (ScolumnService) ctx.getBean("scolumnService");
		//ContentService service3 = (ContentService) ctx.getBean("contentService");
		
		List<Scolumn> list = service2.findByName("ÐÂÎÅ");
		
		ScolumnProperty sp = new ScolumnProperty();
		
		for(int i=0;i<list.size();i++){
			Scolumn s = list.get(i);
			sp.setName("×¨À¸");
			sp.setState(1);
			sp.setCreateTime(new Date());
			sp.setScolumnId(s);
			sp.setUpdateTime(new Date());
			
			service.save(sp);
		}
	
	
	/*public static void main(String args[]) throws Exception{
		beforeClass();
		ScolumnPropertyService service = (ScolumnPropertyService) ctx.getBean("scolumnPropertyService");
		ScolumnService service2 = (ScolumnService) ctx.getBean("scolumnService");
		
		//ScolumnProperty sp = new ScolumnProperty();
		
		List<Scolumn> list = service2.findByName("ÓéÀÖ");
		System.out.println(list);
		
		for(int i=0;i<list.size();i++){
			Scolumn s = list.get(i);
			
			List<ScolumnProperty> sp2 =   service.findByScolumnId(s.getId());
			
			for(int j=0;j<list.size();j++){
				ScolumnProperty sp = sp2.get(j);
				//service.update(sp);
				service.delete(sp);
			}
			
		}	*/
	}
	
	

}


