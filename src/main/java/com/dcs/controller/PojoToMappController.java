package com.dcs.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.Message;
import com.alibaba.fastjson.JSON;
import com.dcs.constants.InfoCodeEnum;
import com.dcs.pojo.User;
import com.dcs.service.PojoToMapperService;
import com.dcs.util.IpUtils;

public class PojoToMappController {
	
	@Autowired
	private PojoToMapperService pojoToMapperService;
	
	Logger log = Logger.getLogger(PojoToMappController.class);
	
	@RequestMapping("/add")
	public Message addInfo(@RequestParam("code") String code, MultipartFile uploadFile,HttpSession session){
        int id = Integer.parseInt(session.getAttribute("user").toString());
        File file = new File("/"+uploadFile.getOriginalFilename());
        try {
        	uploadFile.transferTo(file);
            String value = InfoCodeEnum.fromCode(code).getValue();
			pojoToMapperService.insert(value,file,id);
        } catch (IOException e) {
			log.info("用户id是："+JSON.toJSONString(id)+"报错信息是："+e.getStackTrace().toString());
    		return Message.success("添加失败！");
        }
		return Message.success("添加成功！");
	}
}
