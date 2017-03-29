package com.test.service;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;

import org.junit.Test;
import org.unitils.spring.annotation.SpringBean;

import com.dcs.pojo.ListInfo;
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
			ListInfo list = new ListInfo();
			list.setCreator(1);
			list.setExcelName("各组织学生干部名单表模板.xls");
			list.setTitle("2017各组织学生干部名单表");
			list.setListId(20001);
			service.insert("20001",new FileInputStream(new File("excel/分团委/各组织学生干部名单表模板.xls")),list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
