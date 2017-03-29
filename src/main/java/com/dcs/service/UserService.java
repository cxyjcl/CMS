package com.dcs.service;

import java.util.List;

import com.dcs.pojo.User;

public interface UserService{

	public Integer insert(User entity) throws Exception;

	public Integer insertBatch(List<User> entityList) throws Exception;

	public User selectById(Object id,Object dataStatus) throws Exception;

	public List<User> selectAll(Object dataStatus) throws Exception;

	public Integer deleteById(Object id) throws Exception;

	public Integer update(User entity) throws Exception;

	public User find(Object str,Object dataStatus);
	
	int deleteById(Object id, Object reviser) throws Exception;

	Integer confirm(User user, Object dataStatus) throws Exception;
	
	String selectLevel(Integer userId);
}
