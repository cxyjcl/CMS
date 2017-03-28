package com.dcs.dao;

import java.util.HashMap;

import org.apache.ibatis.annotations.Param;

public interface PojoToMapperDao {
	
	HashMap insertInfo(@Param("table")String tableName,@Param("map")HashMap map);
	
	Integer deleteInfo(@Param("table")String tableName,@Param("map")HashMap map);
	
	Integer selectInfo(@Param("table")String tableName,@Param("map")HashMap map);

	Integer updateInfo(@Param("table")String tableName,@Param("map")HashMap map, @Param("id")Integer id);
	
}
