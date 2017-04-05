package com.dcs.service;

import java.util.List;

import com.dcs.pojo.User;
import com.dcs.pojo.request.Page;

public interface UserService{

	public Integer insert(User entity) throws Exception;

	public Integer insertBatch(List<User> entityList) throws Exception;

	public User selectById(Object id,Object dataStatus) throws Exception;

	public List<User> selectAll(Page page) throws Exception;

	public Integer update(User entity) throws Exception;

	public List<User> find(String str,String dataStatus,Page page);
	
	int deleteById(Object id, Object reviser) throws Exception;

	User confirm(User user, Object dataStatus) throws Exception;
	
	String selectLevel(Integer userId);

	Integer check(String value, String code);

}
