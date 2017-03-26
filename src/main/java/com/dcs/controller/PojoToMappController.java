package com.dcs.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Message;
import com.dcs.constants.PojoToMapEnum;
import com.dcs.pojo.User;
import com.dcs.service.PojoToMappService;

public class PojoToMappController {
	
	@Autowired
	private PojoToMappService pojoToMappService;
	
	
	@RequestMapping("/add")
	public Message addInfo(@RequestParam("code") String code, @RequestParam("id") String id){
		try {
			Class instance = PojoToMapEnum.getInstance(code).getValue();
			pojoToMappService.insert(new ArrayList<instance>());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Message.success("添加成功！");
	}
}
