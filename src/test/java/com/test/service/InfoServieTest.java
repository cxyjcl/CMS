package com.test.service;

import java.util.HashMap;

import org.junit.Test;
import org.unitils.spring.annotation.SpringBean;

import com.dcs.service.PojoToMapperService;
import com.test.BaseTestStarter;

public class InfoServieTest extends BaseTestStarter {
	@SpringBean(value = "infoService")
	PojoToMapperService service;
	
	@Test
	public void test(){
		HashMap infoMap = new HashMap();
		infoMap.put("info_id", "132");
		try {
			service.update("t_cadres_info",1,infoMap);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
