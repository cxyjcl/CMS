package com.test.service;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;

import org.junit.Test;
import org.unitils.spring.annotation.SpringBean;

import com.dcs.service.PojoToMapperService;
import com.test.BaseTestStarter;

public class InfoServieTest extends BaseTestStarter {
	@SpringBean(value = "infoService")
	PojoToMapperService service;
	
	@Test
	public void insert(){
		HashMap infoMap = new HashMap();
		infoMap.put("info_id", "132");
		try {
			service.insert("CadresInfo",new FileInputStream(new File("excel/分团委/各组织学生干部名单表模板.xls")),1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
