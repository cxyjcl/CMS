package com.dcs.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dcs.pojo.User;
import com.dcs.pojo.request.Page;

public interface UserMapper{

	public int insert(User entity) throws Exception;
	
	public int insertBatch(List<User> entityList) throws Exception;

	public User selectById(@Param("id")Object id,@Param("dataStatus") Object dataStatus) throws Exception;

	public List<User> selectAll(Page page) throws Exception;

	public int deleteById(@Param("id")Object id,@Param("reviser")Object reviser) throws Exception;

	public int update(User entity) throws Exception;

	User confirm(@Param("user")User user,@Param("dataStatus") Object dataStatus);

	public String selectLevel(Integer id);

	public List<User> find(@Param("value")String str,@Param("dataStatus") Object dataStatus,@Param("page")Page page);

	public Integer check(@Param("value")String str,@Param("dataStatus") Object dataStatus);

	public Integer countUser();
}