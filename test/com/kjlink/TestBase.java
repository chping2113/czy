package com.kjlink;

import org.apache.log4j.Logger;
import org.apache.struts2.StrutsSpringTestCase;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration( locations={"classpath:applicationContext*.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class TestBase extends StrutsSpringTestCase{
	protected   static  Logger logger = Logger.getLogger(TestBase.class);
	public void throwRunTimeException(String message){
		throw new RuntimeException(message);
	}
	public TestBase(){
		super.initServletMockObjects();
	}
	
}
