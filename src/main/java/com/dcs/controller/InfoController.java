package com.dcs.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Message;

@RequestMapping("/info")
public class InfoController {
	
	@RequestMapping("/add")
	public Message addInfo(@RequestParam("info_id") String infoId, @RequestParam("id") String id){
		
		return Message.success("添加成功！");
	}
}
