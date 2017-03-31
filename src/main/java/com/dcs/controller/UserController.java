package com.dcs.controller;

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

import com.Message;
import com.alibaba.fastjson.JSON;
import com.dcs.constants.Code;
import com.dcs.constants.DataStatusEnum;
import com.dcs.pojo.User;
import com.dcs.service.UserService;
import com.dcs.util.IpUtils;
import com.dcs.vo.UserVo;

@Controller
@RequestMapping("/user")
public class UserController {

	@Resource(name = "userService")
	UserService userService;

	Logger log = Logger.getLogger(UserController.class);

	@RequestMapping("/index")
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
	
	// login
	@RequestMapping("/login")
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
			Integer id = userService.confirm(user,DataStatusEnum.NORMAL_USED.getCode());
			session.setAttribute("user", id);
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
		String id = session.getAttribute("id").toString();// 以后会改
		String password = user.getPassword();
		String loginId = user.getLoginName();
		if (loginId == null || password == null) {
			return Message.error(Code.PARAMATER, "不得为空");
		}
		if (password.matches("^.*[\\s]+.*$")) {
			return Message.error(Code.PARAMATER, "密码不能包含空格、制表符、换页符等空白字符");
		}
		if ((!password.contains("@"))
				&& (!password.matches("^[1]([0-9][0-9])[0-9]{8}$"))) {
			return Message.error(Code.PARAMATER, "手机号码错误");
		}
		if (password.contains("@")
				&& password
						.matches("^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$")) {
			return Message.error(Code.PARAMATER, "邮箱不正确");
		}
		if (loginId.matches("^.*[\\s]+.*$")) {
			return Message.error(Code.PARAMATER, "账号不能包含空格、制表符、换页符等空白字符");
		}
		user.setCreator(new Integer(id));
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
	public Message deleteUser(@RequestParam("id") Integer id,
			HttpSession session) {
		String reviser = session.getAttribute("id").toString();// 以后会改
		try {
			userService.deleteById(id, reviser);
			return Message.success("删除成功", Code.SUCCESS);
		} catch (Exception e) {
			log.error(JSON.toJSONString(id) + "\n\t" + e.toString());
			return Message.error(Code.ERROR_CONNECTION, "无法删除数据");
		}
	}

	@RequestMapping("/update/user")
	@ResponseBody
	public Message updateUser(@RequestBody User user, HttpServletRequest session) {
		String password = user.getPassword();
		String loginId = user.getLoginName();
		String id = session.getAttribute("id").toString();// 以后会改
		if (loginId == null || password == null) {
			return Message.error(Code.PARAMATER, "不得为空");
		}
		if (password.matches("^.*[\\s]+.*$")) {
			return Message.error(Code.PARAMATER, "密码不能包含空格、制表符、换页符等空白字符");
		}
		if ((!password.contains("@"))
				&& (!password.matches("^[1]([0-9][0-9])[0-9]{8}$"))) {
			return Message.error(Code.PARAMATER, "手机号码错误");
		}
		if (password.contains("@")
				&& password
						.matches("^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$")) {
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
			log.error(JSON.toJSONString(user) + "\n\t" + e.toString());
			return Message.error(Code.ERROR_CONNECTION, "无法更新数据");
		}
	}

	@RequestMapping("/find/user")
	public Message findUser(@RequestBody User user) {
		String loginId = user.getLoginName();
		if (loginId == null) {
			return Message.error(Code.PARAMATER, "账号为空");
		}
		try {
			User dto = userService.find(loginId,
					DataStatusEnum.NORMAL_USED.getCode());
			return Message.success(Code.SUCCESS, "查找成功", dto);
		} catch (Exception e) {
			log.error(JSON.toJSONString(user) + "\n\t" + e.toString());
			return Message.error(Code.ERROR_CONNECTION, "找不到此用户！");
		}
	}
}
