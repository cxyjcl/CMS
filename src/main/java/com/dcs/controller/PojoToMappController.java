package com.dcs.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.Message;
import com.alibaba.fastjson.JSON;
import com.dcs.constants.ListCodeEnum;
import com.dcs.pojo.ListInfo;
import com.dcs.pojo.request.Page;
import com.dcs.service.PojoToMapperService;

@RequestMapping("/excel")
public class PojoToMappController {
	
	@Autowired
	private PojoToMapperService pojoToMapperService;
	
	Logger log = Logger.getLogger(PojoToMappController.class);
	
	@RequestMapping("/add")
	public Message addInfo(@RequestParam("code") Integer code,@RequestParam("excel") MultipartFile uploadFile,HttpSession session){
        int id = Integer.parseInt(session.getAttribute("user").toString());
        try {
            ListInfo listInfo = new ListInfo();
            listInfo.setCreator(id);
            listInfo.setExcelName(uploadFile.getOriginalFilename());
            listInfo.setListId(code);
            String value = ListCodeEnum.fromCode(code.toString()).getValue();
			pojoToMapperService.insert(code.toString(),uploadFile.getInputStream(),listInfo);
        } catch (Exception e) {
			log.info("用户id是："+JSON.toJSONString(id)+"报错信息是："+e.getStackTrace().toString());
			return Message.error("添加失败！");    		
        }
		return Message.success("添加成功！");
	}
	
	@RequestMapping("/update")
	public Message updateInfo(@RequestParam("code") String code,@RequestParam("div_id") Integer divId ,@RequestParam("info_map") HashMap infoMap,HttpSession session){
		int id = Integer.parseInt(session.getAttribute("user").toString());
        try {
        	String value = ListCodeEnum.fromCode(code).getValue();
            ListInfo listInfo = new ListInfo();
            listInfo.setReviser(id);
			pojoToMapperService.update(value,divId,infoMap,listInfo);
        } catch (Exception e) {
			log.info("用户id是："+JSON.toJSONString(id)+"报错信息是："+e.getStackTrace().toString());
			return Message.error("更新失败！");    		
        }
		return Message.success("更新成功！");
	}

	@RequestMapping("/delete_list")
	public Message deleteList(@RequestParam("id") Integer id,HttpSession session){
		int reviser = Integer.parseInt(session.getAttribute("user").toString());
        try {
			pojoToMapperService.deleteList(id,reviser);
        } catch (Exception e) {
			log.info("删除list的iD是"+id+"用户id是："+JSON.toJSONString(reviser)+"报错信息是："+e.getStackTrace().toString());
			return Message.error("删除失败！");    		
        }
		return Message.success("删除成功！");
	}
	
	@RequestMapping("/delete")
	public Message deleteInfo(@RequestParam("code") String code,@RequestParam("id") Integer id ,HttpSession session){
		int reviser = Integer.parseInt(session.getAttribute("user").toString());
        try {
        	String table = ListCodeEnum.fromCode(code).getValue();
			pojoToMapperService.delete(table,id, reviser);
			
        } catch (Exception e) {
			log.info("删除list的iD是"+id+"用户id是："+JSON.toJSONString(reviser)+"报错信息是："+e.getStackTrace().toString());
			return Message.error("删除失败！");    		
        }
		return Message.success("删除成功！");
	}
	
	@RequestMapping("/select_info")
	public Message selectInfo(@RequestParam("code") String code,@RequestParam("info_id") Integer infoId){
        try {
        	String table = ListCodeEnum.fromCode(code).getValue();
			List<HashMap> map = pojoToMapperService.selectInfo(table, infoId);
			return Message.success("查找成功！",map);
        } catch (Exception e) {
			log.info("查找list的iD是"+infoId+"报错信息是："+e.getStackTrace().toString());
			return Message.error("查找失败！");    		
        }
	}
	
	@RequestMapping("/select_list")
	public Message selectListInfo(@RequestParam("code") Integer code,@RequestParam("level") String level,@RequestParam("page")Page page){
        try {
        	List<ListInfo> list = pojoToMapperService.selectListInfo(code, level, page);
			return Message.success("查找成功！",list);
        } catch (Exception e) {
			log.info("查找list的listinfo是"+code+"页码是："+JSON.toJSONString(page)+"报错信息是："+e.getStackTrace().toString());
			return Message.error("查找失败！");    		
        }
	}
	
	@RequestMapping("/find_list")
	public Message findListInfo(@RequestParam("code") String code,@RequestParam("creator") Integer creator,@RequestParam("page")Page page){
        try {
        	String table = ListCodeEnum.fromCode(code).getValue();
			pojoToMapperService.findListInfo(creator, page, code);
        } catch (Exception e) {
			log.info("查找list的listinfo是"+code+"页码是："+JSON.toJSONString(page)+"报错信息是："+e.getStackTrace().toString());
			return Message.success("删除失败！");    		
        }
		return Message.success("删除成功！");
	}
}
