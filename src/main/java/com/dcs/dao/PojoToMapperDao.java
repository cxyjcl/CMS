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

	Integer deleteList(@Param("infoId") Integer infoId);
	
	Integer updateInfo(@Param("table")String tableName,@Param("map")HashMap map, @Param("id")Integer id);

	List<ListInfo> findListInfo(@Param("creator")String creator,@Param("page")Page page,@Param("listId") Integer listId);
	
	HashMap selectInfo(@Param("table")String tableName,@Param("infoId")String infoId);
	
	List<ListInfo> selectListInfo(@Param("listId") Integer listId,@Param("level")String level,@Param("page")Page page);
	
}
