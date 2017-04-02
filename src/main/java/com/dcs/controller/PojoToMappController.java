package com.dcs.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.Message;
import com.alibaba.fastjson.JSON;
import com.dcs.constants.LevelEnum;
import com.dcs.constants.ListCodeEnum;
import com.dcs.dto.ListInfoDto;
import com.dcs.pojo.ListInfo;
import com.dcs.pojo.request.Page;
import com.dcs.service.PojoToMapperService;
import com.google.gson.annotations.JsonAdapter;

@Controller
@RequestMapping("/excel")
public class PojoToMappController {
	
	@Autowired
	private PojoToMapperService pojoToMapperService;
	
	Logger log = Logger.getLogger(PojoToMappController.class);
	
	@RequestMapping("/counsellor")
	public String counsellor(){
		return "view/component/counsellor";
	}
	
	@RequestMapping("/student_office")
	public String studentOffice(){
		return "view/component/student_office";
	}

	@RequestMapping("/subcommittee")
	public String subcommittee(){
		return "view/component/subcommittee";
	}
	
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
	public Message updateInfo(String code,Integer divId ,HashMap infoMap,HttpSession session){
		int id = Integer.parseInt(session.getAttribute("user").toString());
        try {
        	System.out.println("fafdas");
        	String value = ListCodeEnum.fromCode(code).getValue();
            ListInfo listInfo = new ListInfo();
            listInfo.setReviser(id);
			pojoToMapperService.update(value,divId,infoMap,listInfo);
			return Message.success("更新成功！");
        } catch (Exception e) {
			log.info("用户id是："+JSON.toJSONString(id)+"报错信息是："+e.getStackTrace().toString());
			return Message.error("更新失败！");    		
        }
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
	public ModelAndView selectInfo(@RequestParam("code") String code,@RequestParam("info_id") Integer infoId){
		Message message;
		ModelAndView view = new ModelAndView();
		try {
        	String table = ListCodeEnum.fromCode(code).getValue();
        	System.out.println(table);
        	LinkedHashMap mapString = pojoToMapperService.selectCol(code);
			List<LinkedHashMap> map = pojoToMapperService.selectInfo(code, infoId);
			String title = pojoToMapperService.selectTitle(code,infoId);
			view.addObject("map",mapString);
        	message = Message.success("查找成功！");
        	view.addObject("message",message);
        	view.addObject("list",map);
        	view.addObject("code",code);
        	view.addObject("title",title);
        	view.setViewName("/view/component/info");
			return view;
        } catch (Exception e) {
			log.info("查找list的iD是"+infoId+"报错信息是："+e.getStackTrace().toString());
			message = Message.error("查找失败！");
			view.setViewName("/view/error/error.jsp");
			view.addObject("message",message); 		
			return view;
        }
	}
	
	@RequestMapping("/select_limit")
	public ModelAndView selectLimit(){
		Message message;
		ModelAndView view = new ModelAndView();
		try {
        	List<ListInfoDto> list = pojoToMapperService.selectLimit();
        	message = Message.success("查找成功！"); 
        	view.addObject("message",message);
        	view.addObject("list",list);
        	view.setViewName("/view/component/default");
			return view;
        } catch (Exception e) {
			log.info("报错信息是："+e.getStackTrace().toString());
			message = Message.error("查找失败！");
			view.setViewName("/view/error/error.jsp");
			view.addObject("message",message);
			return view;
        }
	}
	
	@RequestMapping(value = "/select_list", method = RequestMethod.GET)
	public ModelAndView selectListInfo(Integer code,String level,Page page){
		level = LevelEnum.fromCode(level).getValue();
		Message message;
		ModelAndView view = new ModelAndView();
		try {
        	List<ListInfo> list = pojoToMapperService.selectListInfo(code, level, page);
        	message = Message.success("查找成功！",list);
        	view.addObject("message",message);
    		view.addObject("list",list);
			view.setViewName("/view/component/table");
        	return view;
        } catch (Exception e) {
        	e.printStackTrace();
			log.info("查找list的listinfo是"+code+"页码是："+JSON.toJSONString(page)+"报错信息是："+e.getStackTrace().toString());
			message= Message.error("查找失败！");
			view.addObject("message",message);
			view.setViewName("/view/error/error.jsp");
			return view;
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
