package com.dcs.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;





import org.springframework.web.servlet.ModelAndView;

import com.Message;
import com.alibaba.fastjson.JSON;
import com.dcs.constants.Code;
import com.dcs.constants.DataStatusEnum;
import com.dcs.constants.LevelEnum;
import com.dcs.pojo.User;
import com.dcs.pojo.request.Page;
import com.dcs.service.UserService;
import com.dcs.util.IpUtils;
import com.dcs.vo.UserVo;

@Controller
public class UserController {

	@Resource(name = "userService")
	UserService userService;

	Logger log = Logger.getLogger(UserController.class);

	@RequestMapping("/login")
	public String index(){
		return "view/user/login";
	}
	
	@RequestMapping("/change")
	public String change(){
		return "view/user/change";
	}
	
	@RequestMapping("/management")
	public String user(){
		return "view/user/management";
	}
	
	@RequestMapping("/exit")
	public String exit(HttpSession session){
		session.removeAttribute("user");
		return "view/user/login";
	}
	
	// login
	@RequestMapping("/confirm")
	@ResponseBody
	public Message login(@RequestBody UserVo vo, HttpSession session,
			HttpServletRequest request) {
		String password = vo.getPassword();
		String loginId = vo.getLoginName();
		String code = vo.getCode();
		String generatorCode = session.getAttribute("generateCode").toString();
		// 其他的null都提示的是不得为空，只有这里会记录ip的原因是防止入侵。
		if (password == null || loginId == null) {
			// 恶意侵入，记录ip，并禁止其再次登录
			String ip = IpUtils.getIp(request);
			log.error("ip:" + JSON.toJSON(ip) + "\n\t username:"
					+ vo.getLoginName());
			return Message.error(Code.FATAL_ERROR, "别搞事情", ip);
		}
		if (password.matches("^.*[\\s]+.*$")) {
			return Message.error(Code.PARAMATER, "密码不能包含空格、制表符、换页符等空白字符");
		}
		if (loginId.matches("^.*[\\s]+.*$")) {
			return Message.error(Code.PARAMATER, "昵称不能包含空格、制表符、换页符等空白字符");
		}
		if (!code.equals(generatorCode)){
			return Message.error(Code.PARAMATER, "验证码错误");
		}
		User user = new User();
		try {
			BeanUtils.copyProperties(user, vo);
			user = userService.confirm(user,DataStatusEnum.NORMAL_USED.getCode());
			session.setAttribute("user", user);
			String userLevel = LevelEnum.fromValue(user.getLevel()).getCode();
			session.setAttribute("userLevel", userLevel);
			session.setMaxInactiveInterval(60 * 30);
			log.info(JSON.toJSONString(user) + "登陆了\n\t ip:"
					+ IpUtils.getIp(request));
			return Message.success("登陆成功！");
		} catch (Exception e) {
			log.error(JSON.toJSONString(user) + "\n\t" + e.toString());
			return Message.error(Code.PARAMATER, "账号或密码错误");
		}
	}

	// user
	@RequestMapping("/add/user")
	@ResponseBody
	public Message addUser(@RequestBody User user, HttpSession session) {
		User nowUser = (User) session.getAttribute("user");
		int id = nowUser.getId();
		String password = user.getPassword();
		String loginId = user.getLoginName();
		String email = user.getEmail();
		String realName = user.getRealName();
		if (loginId == null || password == null || realName == null) {
			return Message.error(Code.PARAMATER, "不得为空");
		}
		if (password.matches("^.*[\\s]+.*$")) {
			return Message.error(Code.PARAMATER, "密码不能包含空格、制表符、换页符等空白字符");
		}
		if (!email.matches("^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$")) {
			return Message.error(Code.PARAMATER, "邮箱不正确");
		}
		if (loginId.matches("^.*[\\s]+.*$")) {
			return Message.error(Code.PARAMATER, "账号不能包含空格、制表符、换页符等空白字符");
		}
		if (realName.matches("^.*[\\s]+.*$")) {
			return Message.error(Code.PARAMATER, "账号不能包含空格、制表符、换页符等空白字符");
		}
		user.setCreator(id);
		try {
			userService.insert(user);
			return Message.success("插入成功", Code.SUCCESS);
		} catch (Exception e) {
			log.error(JSON.toJSONString(user) + "\n\t" + e.toString());
			return Message.error(Code.ERROR_CONNECTION, "无法插入数据");
		}
	}

	@RequestMapping("/delete/user")
	@ResponseBody
	public Message deleteUser(@RequestBody Integer id,
			HttpSession session) {
		User nowUser = (User) session.getAttribute("user");
		int reviser = nowUser.getId();
		try {
			userService.deleteById(id, reviser);
			return Message.success("删除成功", Code.SUCCESS);
		} catch (Exception e) {
			log.error(JSON.toJSONString(id) + "\n\t" + e.toString());
			return Message.error(Code.ERROR_CONNECTION, "无法删除数据");
		}
	}
	@RequestMapping("/change/user")
	@ResponseBody
	public Message changeUser(@RequestBody User user, HttpSession session) {
		String password = user.getPassword();
		String loginId = user.getLoginName();
		String email = user.getEmail();
		User nowUser = (User) session.getAttribute("user");
		int id = nowUser.getId();
		if (password.matches("^.*[\\s]+.*$")) {
			return Message.error(Code.PARAMATER, "密码不能包含空格、制表符、换页符等空白字符");
		}
		if (email != null &&!email.matches("^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$")) {
			return Message.error(Code.PARAMATER, "邮箱不正确");
		}
		try {
			user.setId(id);
			user.setReviser(id);
			userService.update(user);
			return Message.success("更新成功", Code.SUCCESS);
		} catch (Exception e) {
			
			log.error(JSON.toJSONString(user) + "\n\t" + e.toString());
			return Message.error(Code.ERROR_CONNECTION, "无法更新数据");
		}
	}
	
	@RequestMapping("/update/user")
	@ResponseBody
	public Message updateUser(@RequestBody User user, HttpSession session) {
		String password = user.getPassword();
		String loginId = user.getLoginName();
		String email = user.getEmail();
		User nowUser = (User) session.getAttribute("user");
		int id = nowUser.getId();
		String dataStatus = DataStatusEnum.fromValue(user.getDataStatus()).getCode();
		user.setDataStatus(dataStatus);
		if (password.matches("^.*[\\s]+.*$")) {
			return Message.error(Code.PARAMATER, "密码不能包含空格、制表符、换页符等空白字符");
		}
		if (email != null &&!email.matches("^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$")) {
			return Message.error(Code.PARAMATER, "邮箱不正确");
		}
		if (loginId.matches("^.*[\\s]+.*$")) {
			return Message.error(Code.PARAMATER, "账号不能包含空格、制表符、换页符等空白字符");
		}
		try {
			user.setReviser(new Integer(id));
			userService.update(user);
			return Message.success("更新成功", Code.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			log.error(JSON.toJSONString(user) + "\n\t" + e.toString());
			return Message.error(Code.ERROR_CONNECTION, "无法更新数据");
		}
	}

	@RequestMapping("/check")
	@ResponseBody
	public Message checkUser(String value) {
		try {
		    Integer	num= userService.check(value,
					DataStatusEnum.NORMAL_USED.getCode());
			if(num==null || num==0){
				return Message.error(Code.NO_DATA,"此登录名可用");
			} else{
				return Message.success("有相同的登录名");				
			}
		} catch (Exception e) {
			log.error(JSON.toJSONString(value) + "\n\t" + e.toString());
			return Message.error(Code.ERROR_CONNECTION, "找不到此用户！");
		}
	}
	
	@RequestMapping("/find/user")
	public ModelAndView findUser(String value,Page page) {
		ModelAndView view = new ModelAndView();
		Message message = new Message();
		if (value == null) {
			view.setViewName("/get/user");
			return view;
		}
		try {
			List<User> userList = userService.find(value,
					DataStatusEnum.NORMAL_USED.getCode(),page);
				view.setViewName("/view/user/list");
				view.addObject("list",userList);
				page.setTotalSize(userList.size());
				view.addObject("page",page);
				view.addObject("message",message);
				return view;
		} catch (Exception e) {
			log.error("查找list的value是"+value+"报错信息是："+e.getStackTrace().toString());
			message = Message.error("查找失败！");
			view.setViewName("/view/error/error.jsp");
			view.addObject("message",message); 		
			return view;
		}
	}
	
	@RequestMapping("/get/user")
	public ModelAndView getUser(Page page){
		ModelAndView view = new ModelAndView();
		Message message = new Message();
		try {
			List<User> userList = userService.selectAll(page);
			message = Message.success("查找成功");
			view.addObject("list",userList);
			Integer size = userService.countUser();
			page.setTotalSize(size);
			view.addObject("page",page);
			view.addObject("message",message);
			view.setViewName("/view/user/list");
			return view;
		} catch (Exception e) {
			log.error(e.toString());
			view.setViewName("/view/error/error");
			message = Message.error(Code.ERROR_CONNECTION, "查询数据库失败");
			view.addObject("message",message);
			return view;
		}
	}
}
