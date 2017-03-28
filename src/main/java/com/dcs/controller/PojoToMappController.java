package com.dcs.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.Message;
import com.alibaba.fastjson.JSON;
import com.dcs.constants.ListCodeEnum;
import com.dcs.service.PojoToMapperService;

public class PojoToMappController {
	
	@Autowired
	private PojoToMapperService pojoToMapperService;
	
	Logger log = Logger.getLogger(PojoToMappController.class);
	
	@RequestMapping("/add")
	public Message addInfo(@RequestParam("code") String code, MultipartFile uploadFile,HttpSession session){
        int id = Integer.parseInt(session.getAttribute("user").toString());
        try {
            String value = ListCodeEnum.fromCode(code).getValue();
			pojoToMapperService.insert(value,uploadFile.getInputStream(),id);
        } catch (Exception e) {
			log.info("用户id是："+JSON.toJSONString(id)+"报错信息是："+e.getStackTrace().toString());
			return Message.success("添加失败！");    		
        }
		return Message.success("添加成功！");
	}
	
	@RequestMapping("/update")
	public Message updateInfo(@RequestParam("code") String code,@RequestParam("div_id") Integer divId ,@RequestParam("info_map") HashMap infoMap,HttpSession session){
        //用beanUtils赋值
		int id = Integer.parseInt(session.getAttribute("user").toString());
        try {
        	infoMap.put("reviser", id);
            String value = ListCodeEnum.fromCode(code).getValue();
			pojoToMapperService.update(value,divId,infoMap);
        } catch (Exception e) {
			log.info("用户id是："+JSON.toJSONString(id)+"报错信息是："+e.getStackTrace().toString());
			return Message.success("更新失败！");    		
        }
		return Message.success("更新成功！");
	}
}
