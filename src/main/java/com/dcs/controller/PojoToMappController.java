package com.dcs.controller;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
	public String counsellor() {
		return "view/component/counsellor";
	}

	@RequestMapping("/student_office")
	public String studentOffice() {
		return "view/component/student_office";
	}

	@RequestMapping("/subcommittee")
	public String subcommittee() {
		return "view/component/subcommittee";
	}

	@RequestMapping("/add")
	public Message addInfo(@RequestParam("code") Integer code,
			@RequestParam("level") String level,
			@RequestParam("file") MultipartFile uploadFile, HttpSession session) {
		User user = (User) session.getAttribute("user");
		try {
			ListInfo listInfo = new ListInfo();
			listInfo.setCreator(user.getId());
			listInfo.setExcelName(uploadFile.getOriginalFilename());
			listInfo.setListId(code);
			listInfo.setUserLevel(level);
			String value = ListCodeEnum.fromCode(code.toString()).getValue();
			pojoToMapperService.insert(code.toString(),
					uploadFile.getInputStream(), listInfo);			
			return Message.success("添加成功！");
		} catch (Exception e) {
			e.printStackTrace();
			log.error("用户id是：" + JSON.toJSONString(user) + "报错信息是："
					+ e.getStackTrace());
			return Message.error("添加失败！");
		}
	}

	// TODO 这是文件下载，即打印那一块的，没有写只是拿模块进行测试。
	@RequestMapping("/file/download")
    public ModelAndView downloadFile(String code,Integer id,HttpServletResponse response){
		ListCodeEnum codeEnum = ListCodeEnum.fromCode(code);
		String excelName = codeEnum.getExcelName();
		String className = codeEnum.getInstance();
		String fileName = codeEnum.getExcelName();
        String title = pojoToMapperService.selectTitle(code,id);
        Map<String, Object> map = new HashMap<String,Object>();
		try {
			Class<?> pojoClass = Class.forName("com.dcs.pojo." + className);
			List<LinkedHashMap> mapList = pojoToMapperService.selectInfo(
					code, id,null);
			map.put("pojoClass", pojoClass);
			map.put("data2Export", mapList);
			map.put("title", title);
			map.put("fileName",fileName);
			ExcelView ve = new ExcelView();  
	        return new ModelAndView(ve,map);  
		} catch (Exception e) {
			e.printStackTrace();
			log.error("报错的excel是"+excelName+"报错信息是："+e.getStackTrace());
		}
		return null;
    }

	@RequestMapping("/word/download")
	public void wordModel(HttpServletResponse response,
			HttpServletRequest request) {
		String code = request.getParameter("code");
		String id = request.getParameter("id");
		String word = pojoToMapperService.selectWord(id);
		String ctxPath = request.getSession().getServletContext()
				.getRealPath("/")
				+ "WEB-INF\\temp\\" + word;
		response.setContentType("application/x-msdownload;");
		InputStream in;
		try {
			response.setHeader("Content-disposition", "attachment; filename="
					+ new String("excel.xls".getBytes("utf-8"), "ISO8859-1"));
			in = new FileInputStream(new File(ctxPath));
			OutputStream out = new BufferedOutputStream(
					response.getOutputStream());
			int byteread = 0;
			byte[] buffer = new byte[1024];
			while ((byteread = in.read(buffer)) != -1) {
				out.write(buffer, 0, byteread);
			}
			in.close();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
			log.error("报错的word是" + word + "报错信息是：" + e.getStackTrace());
		}
	}
	
	// 这是模板下载，即table主页的那个下载。已经写好的
	@RequestMapping("/model/download")
	public void downloadModel(HttpServletResponse response,
			HttpServletRequest request) {
		String code = request.getParameter("code");
		String excelName = ListCodeEnum.fromCode(code).getExcelName();
		String ctxPath = request.getSession().getServletContext()
				.getRealPath("/")
				+ "WEB-INF\\excel\\" + excelName;
		System.out.println(ctxPath);
		response.setContentType("application/x-msdownload;");
		InputStream in;
		try {
			response.setHeader("Content-disposition", "attachment; filename="
					+ new String("excel.xls".getBytes("utf-8"), "ISO8859-1"));
			in = new FileInputStream(new File(ctxPath));
			OutputStream out = new BufferedOutputStream(
					response.getOutputStream());
			int byteread = 0;
			byte[] buffer = new byte[1024];
			while ((byteread = in.read(buffer)) != -1) {
				out.write(buffer, 0, byteread);
			}
			in.close();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
			log.error("报错的excel是" + excelName + "报错信息是：" + e.getStackTrace());
		}
	}

	@RequestMapping("/update")
	@ResponseBody
	public Message updateInfo(@RequestBody UpdateVo vo, HttpSession session) {
		User user = (User) session.getAttribute("user");
		int id = user.getId();
		try {
			String code = vo.getCode();
			String value = ListCodeEnum.fromCode(code).getValue();
			ListInfo listInfo = new ListInfo();
			listInfo.setReviser(id);
			pojoToMapperService.update(value, vo);
			return Message.success("更新成功！");
		} catch (Exception e) {
			e.printStackTrace();
			log.error("用户id是：" + JSON.toJSONString(id) + "报错信息是："
					+ e.getStackTrace());
			return Message.error("更新失败！");
		}
	}

	@RequestMapping("/delete_list")
	@ResponseBody
	public Message deleteList(@RequestBody Integer id, HttpSession session) {
		User user = (User) session.getAttribute("user");
		int reviser = user.getId();
		try {
			pojoToMapperService.deleteList(id, reviser);
			return Message.success("删除成功！");
		} catch (Exception e) {
			e.printStackTrace();
			log.info("删除list的iD是" + id + "用户id是：" + JSON.toJSONString(reviser)
					+ "报错信息是：" + e.getStackTrace().toString());
			return Message.error("删除失败！");
		}
	}

	@RequestMapping("/delete")
	public Message deleteInfo( String code,
			 Integer id, HttpSession session) {
		User user = (User) session.getAttribute("user");
		int reviser = user.getId();
		try {
			String table = ListCodeEnum.fromCode(code).getValue();
			pojoToMapperService.delete(table, id, reviser);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("删除list的iD是" + id + "用户id是：" + JSON.toJSONString(reviser)
					+ "报错信息是：" + e.getStackTrace().toString());
			return Message.error("删除失败！");
		}
		return Message.success("删除成功！");
	}

	@RequestMapping("/select_info")
	public ModelAndView selectInfo(String code,String level, Integer id, Page page,
			HttpServletResponse response) {
		Message message;
		ModelAndView view = new ModelAndView();
		String table = ListCodeEnum.fromCode(code).getValue();
		String instance = ListCodeEnum.fromCode(code).getInstance();
		view.addObject("level",level);
		try {
			if (instance.equals("WordInfo")) {
				String ctxPath = pojoToMapperService.selectWord(id.toString());
				ctxPath = ctxPath.replace(".doc", ".pdf");
				view.addObject("path","/dcs/temp/"+ctxPath);
				view.setViewName("/view/component/pdf");
			} else{
				MapVo vo = new MapVo();
				vo.setPageIndex(page.getPageIndex());
				LinkedHashMap mapString = pojoToMapperService.selectCol(code);
				vo.setMapString(mapString);
				List<LinkedHashMap> mapList = pojoToMapperService.selectInfo(
						code, id, page);
				vo.setMapList(mapList);
				Integer size = pojoToMapperService.countInfo(table, id);
				vo.setTotalSize(size);
				String title = pojoToMapperService.selectTitle(code, id);
				view.addObject("mapVo", vo);
				view.addObject("title", title);
				view.setViewName("/view/component/info");
			}
			message = Message.success("查找成功！");
			view.addObject("message", message);
			view.addObject("code", code);
			view.addObject("infoId", id);
			return view;
		} catch (Exception e) {
			e.printStackTrace();
			log.error("查找list的iD是" + id + "报错信息是："
					+ e.getStackTrace().toString());
			message = Message.error("查找失败！");
			view.setViewName("/view/error/error.jsp");
			view.addObject("message", message);
			return view;
		}
	}

	@RequestMapping("/select_limit")
	public ModelAndView selectLimit() {
		Message message;
		ModelAndView view = new ModelAndView();
		try {
			List<ListInfoDto> list = pojoToMapperService.selectLimit();
			message = Message.success("查找成功！");
			view.addObject("message", message);
			view.addObject("list", list);
			view.setViewName("/view/component/default");
			return view;
		} catch (Exception e) {
			e.printStackTrace();
			log.error("报错信息是：" + e.getStackTrace());
			message = Message.error("查找失败！");
			view.setViewName("/view/error/error.jsp");
			view.addObject("message", message);
			return view;
		}
	}

	@RequestMapping(value = "/select_list", method = RequestMethod.GET)
	public ModelAndView selectListInfo(Integer code, String level, Page page) {
		String name = LevelEnum.fromCode(level).getValue();
		Message message;
		ModelAndView view = new ModelAndView();
		try {
			List<ListInfoDto> list = pojoToMapperService.selectListInfo(code,
					name, page);
			message = Message.success("查找成功！");
			view.addObject("message", message);
			view.addObject("list", list);
			Integer size = pojoToMapperService.countList(code, level);
			page.setTotalSize(size);
			view.addObject("page", page);
			view.addObject("code", code);
			String instance = ListCodeEnum.fromCode(code.toString())
					.getInstance();
			view.addObject("level", level);
			view.addObject("instance", instance);
			view.setViewName("/view/component/table");
			return view;
		} catch (Exception e) {
			e.printStackTrace();
			log.error("查找list的listinfo是" + code + "页码是："
					+ JSON.toJSONString(page) + "报错信息是："
					+ e.getStackTrace().toString());
			message = Message.error("查找失败！");
			view.addObject("message", message);
			view.setViewName("/view/error/error.jsp");
			return view;
		}
	}

	@RequestMapping("/find_list")
	public ModelAndView findListInfo(String code, String level, String value,
			Page page) {
		Message message;
		ModelAndView view = new ModelAndView();
		String name= LevelEnum.fromCode(level).getValue();
		try {
			List<ListInfoDto> list = pojoToMapperService.findListInfo(value,
					name, page, code);
			message = Message.success("查找成功！");
			view.addObject("list", list);
			view.addObject("message", message);
			page.setTotalSize(list.size());
			view.addObject("page", page);
			view.addObject("code", code);
			view.addObject("level", level);
			view.setViewName("view/component/table");
			return view;
		} catch (Exception e) {
			e.printStackTrace();
			log.error("查找list的listinfo是" + code + "页码是："
					+ JSON.toJSONString(page) + "报错信息是："
					+ e.getStackTrace().toString());
			message = Message.success("查找失败！");
			view.addObject("message", message);
			view.setViewName("/view/error/error.jsp");
			return view;
		}
	}
}
