package com.kjlink.ahpips.service.credit.impl;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.kjlink.TestBase;
import com.kjlink.ahpips.entity.credit.CompanyAchieve;
import com.kjlink.ahpips.entity.system.Company;
import com.kjlink.ahpips.service.credit.CompanyAchieveService;


public class CompanyAchieveServiceImplTest extends TestBase{
	@Resource
	private CompanyAchieveService CompanyAchieveService;
	
	@Test
	public void testFindPageAll(){
		Company company = new Company();
		company.setId(2);
		List<CompanyAchieve> list= CompanyAchieveService.findByCompany(company);
		assertTrue("¹þ¹þ",list.isEmpty());
	}
}
