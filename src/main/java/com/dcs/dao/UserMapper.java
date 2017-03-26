package com.dcs.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.dcs.pojo.User;

public interface UserMapper{

	public int insert(User entity) throws Exception;
	
	public int insertBatch(List<User> entityList) throws Exception;

	public User selectById(@Param("id")Object id,@Param("dataStatus") Object dataStatus) throws Exception;

	public List<User> selectAll(Object dataStatus) throws Exception;

	public int deleteById(@Param("id")Object id,@Param("reviser")Object reviser) throws Exception;

	public int update(User entity) throws Exception;

	Integer confirm(@Param("user")User user,@Param("dataStatus") Object dataStatus);

}