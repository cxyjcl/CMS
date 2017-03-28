package com.dcs.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dcs.dto.ListInfoDto;
import com.dcs.pojo.ListInfo;
import com.dcs.pojo.request.Page;

public interface PojoToMapperDao {
	
	HashMap insertInfo(@Param("table")String tableName,@Param("map")HashMap map);
	
	Integer deleteInfo(@Param("table")String tableName, @Param("id")Integer id);

	Integer deleteList(@Param("table")String tableName,@Param("listId") Integer listId);
	
	Integer updateInfo(@Param("table")String tableName,@Param("map")HashMap map, @Param("id")Integer id);

	ListInfo findInfo(@Param("creator")String creator,@Param("listId") Integer listId);
	
	ListInfoDto selectInfo(@Param("table")String tableName, @Param("page")Page page);
	
	List<ListInfo> selectListInfo(@Param("listId") Integer listId,@Param("level")String level);
	
}
