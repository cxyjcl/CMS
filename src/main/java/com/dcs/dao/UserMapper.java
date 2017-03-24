package com.dcs.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.dcs.pojo.User;

public interface UserMapper extends BaseDao<User>{

	Integer confirm(@Param("user")User user,@Param("dataStatus") Object dataStatus);

}