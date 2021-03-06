package com.dcs.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.dcs.dao.UserMapper;
import com.dcs.pojo.User;
import com.dcs.pojo.request.Page;
import com.dcs.service.UserService;
import com.dcs.util.MD5;


@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	UserMapper userMapper;
	
	public Integer update(User user)  throws Exception{
		String password = user.getPassword();
		//这里不判断password是否为null的原因是即使是null加密之后还是null
		user.setPassword(MD5.encode(password));
		int num = userMapper.update(user);
		return num;
	}

	
	@Override
	public int deleteById(Object id,Object reviser) throws Exception {
		//delete不仅要把userInfo表的status设为000还要把user表的status设为000
		int num= userMapper.deleteById(id,reviser);
		return num;
	}
	
	@Override
	public Integer insert(User user) throws Exception {
		String password = user.getPassword();
		//这里不判断password是否为null的原因是即使是null加密之后还是null
		user.setPassword(MD5.encode(password));
		int num= userMapper.insert(user);
		return num;
	}

	@Override
	public User selectById(Object id,Object dataStatus) throws Exception {
		User user= userMapper.selectById(id,dataStatus);
		return user;
	}
	
	@Override
	public User confirm(User user,Object dataStatus) throws Exception {
		String password = user.getPassword();
		//这里不判断password是否为null的原因是即使是null加密之后还是null
		user.setPassword(MD5.encode(password));
		user= userMapper.confirm(user,dataStatus);
		Assert.isTrue(user!=null,"密码错误");
		return user;
	}

	@Override
	public Integer insertBatch(List<User> entityList) throws Exception {
		return 0;
	}
	
	@Override
	public List<User> selectAll(Page page) throws Exception {
		List<User> userList= userMapper.selectAll(page);
		  return userList;
	}


	@Override
	public List<User> find(String str, String dataStatus,Page page) {
		List<User> userList = userMapper.find(str,dataStatus,page);
		return userList;
	}
	
	public String selectLevel(Integer userId){
		return userMapper.selectLevel(userId);
	}


	@Override
	public Integer check(String value, String code) {
		return userMapper.check(value, code);
	}


	@Override
	public Integer countUser() {
		return userMapper.countUser();
	}
	
}
