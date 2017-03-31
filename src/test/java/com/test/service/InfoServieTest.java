package com.test.service;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;

import org.junit.Test;
import org.unitils.spring.annotation.SpringBean;

import com.dcs.pojo.ListInfo;
import com.dcs.pojo.request.Page;
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
//			ListInfo list = new ListInfo();
//			list.setCreator(1);
//			list.setExcelName("各组织学生干部名单表模板.xls");
//			list.setTitle("2017各组织学生干部名单表");
//			list.setListId(20001);
			Page page = new Page();
			page.setPageIndex(0);
			page.setPageSize(10);
			page.setOrderType("desc");
			page.setSortField("id");
			System.out.println(service.selectListInfo(10002, "学工办", page));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
