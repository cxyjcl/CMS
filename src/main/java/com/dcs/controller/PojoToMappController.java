package com.dcs.controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.Message;
import com.alibaba.fastjson.JSON;
import com.dcs.constants.LevelEnum;
import com.dcs.constants.ListCodeEnum;
import com.dcs.dto.ListInfoDto;
import com.dcs.pojo.ListInfo;
import com.dcs.pojo.User;
import com.dcs.pojo.request.Page;
import com.dcs.service.PojoToMapperService;
import com.dcs.vo.MapVo;
import com.dcs.vo.UpdateVo;
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
	public Message addInfo(@RequestParam("code") Integer code,@RequestParam("file") MultipartFile uploadFile,HttpSession session){
        User user =(User) session.getAttribute("user");
        try {
            ListInfo listInfo = new ListInfo();
            listInfo.setCreator(user.getId());
            listInfo.setExcelName(uploadFile.getOriginalFilename());
            listInfo.setListId(code);
            listInfo.setUserLevel(user.getLevel());
            String value = ListCodeEnum.fromCode(code.toString()).getValue();
			pojoToMapperService.insert(code.toString(),uploadFile.getInputStream(),listInfo);
        } catch (Exception e) {
        	e.printStackTrace();
			log.error("用户id是："+JSON.toJSONString(user)+"报错信息是："+e.getStackTrace());
			return Message.error("添加失败！");    		
        }
		return Message.success("添加成功！");
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public Message updateInfo(@RequestBody UpdateVo vo,HttpSession session){
		int id = Integer.parseInt(session.getAttribute("user").toString());
        try {
        	String code = vo.getCode();
        	String value = ListCodeEnum.fromCode(code).getValue();
            ListInfo listInfo = new ListInfo();
            listInfo.setReviser(id);
			pojoToMapperService.update(value,vo);
			return Message.success("更新成功！");
        } catch (Exception e) {
        	e.printStackTrace();
			log.error("用户id是："+JSON.toJSONString(id)+"报错信息是："+e.getStackTrace());
			return Message.error("更新失败！");    		
        }
	}

	@RequestMapping("/delete_list")
	@ResponseBody
	public Message deleteList(@RequestBody Integer id,HttpSession session){
		int reviser = Integer.parseInt(session.getAttribute("user").toString());
        try {
			pojoToMapperService.deleteList(id,reviser);
			return Message.success("删除成功！");
        } catch (Exception e) {
			log.info("删除list的iD是"+id+"用户id是："+JSON.toJSONString(reviser)+"报错信息是："+e.getStackTrace().toString());
			return Message.error("删除失败！");    		
        }
	}
	
	@RequestMapping("/delete")
	public Message deleteInfo(@RequestParam("code") String code,@RequestParam("id") Integer id ,HttpSession session){
		int reviser = Integer.parseInt(session.getAttribute("user").toString());
        try {
        	String table = ListCodeEnum.fromCode(code).getValue();
			pojoToMapperService.delete(table,id, reviser);
			
        } catch (Exception e) {
			log.error("删除list的iD是"+id+"用户id是："+JSON.toJSONString(reviser)+"报错信息是："+e.getStackTrace().toString());
			return Message.error("删除失败！");    		
        }
		return Message.success("删除成功！");
	}
	
	@RequestMapping("/select_info")
	public ModelAndView selectInfo(String code,Integer id,Page page){
		Message message;
		ModelAndView view = new ModelAndView();
		try {
        	String table = ListCodeEnum.fromCode(code).getValue();
        	MapVo vo = new MapVo();
        	BeanUtils.copyProperties(vo, page);
        	LinkedHashMap mapString = pojoToMapperService.selectCol(code);
        	vo.setMapString(mapString);
			List<LinkedHashMap> mapList = pojoToMapperService.selectInfo(code, id,page);
			vo.setMapList(mapList);
			vo.setTotalSize(mapList.size());
			System.out.println(vo);
			String title = pojoToMapperService.selectTitle(code,id);
			view.addObject("mapVo",vo);
        	message = Message.success("查找成功！");
        	view.addObject("message",message);
        	view.addObject("code",code);
        	view.addObject("title",title);
        	view.setViewName("/view/component/info");
			return view;
        } catch (Exception e) {
			log.error("查找list的iD是"+id+"报错信息是："+e.getStackTrace().toString());
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
        	e.printStackTrace();
			log.error("报错信息是："+e.getStackTrace());
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
        	List<ListInfoDto> list = pojoToMapperService.selectListInfo(code, level, page);
        	message = Message.success("查找成功！");
        	view.addObject("message",message);
    		view.addObject("list",list);
    		page.setTotalSize(list.size());
    		view.addObject("page",page);
    		view.addObject("code",code);
    		view.addObject("level",level);
			view.setViewName("/view/component/table");
        	return view;
        } catch (Exception e) {
        	e.printStackTrace();
			log.error("查找list的listinfo是"+code+"页码是："+JSON.toJSONString(page)+"报错信息是："+e.getStackTrace().toString());
			message= Message.error("查找失败！");
			view.addObject("message",message);
			view.setViewName("/view/error/error.jsp");
			return view;
        }
	}
	@RequestMapping("/find_list")
	public Message findListInfo(String code,String level,String value,@RequestParam("page")Page page){
        try {
        	List<ListInfoDto> dto = pojoToMapperService.findListInfo(value,level, page, code);
        } catch (Exception e) {
			log.error("查找list的listinfo是"+code+"页码是："+JSON.toJSONString(page)+"报错信息是："+e.getStackTrace().toString());
			return Message.success("查找失败！");    		
        }
		return Message.success("查找成功！");
	}
}
