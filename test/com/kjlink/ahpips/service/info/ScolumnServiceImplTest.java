package com.kjlink.ahpips.service.info;

import javax.annotation.Resource;

import org.junit.Test;

import com.kjlink.TestBase;
import com.kjlink.ahpips.entity.info.Scolumn;

public class ScolumnServiceImplTest extends TestBase{
	
	
	private ScolumnService scolumnService;

	@Test
	public void testSave() {
		Scolumn s = new Scolumn();
		s.setName("ÐÂÎÅ");
		System.out.print(s.getName());
		scolumnService.save(s);
		
	}

	public ScolumnService getScolumnService() {
		return scolumnService;
	}

	@Resource(name="scolumnService")
	public void setScolumnService(ScolumnService scolumnService) {
		this.scolumnService = scolumnService;
	}

}
