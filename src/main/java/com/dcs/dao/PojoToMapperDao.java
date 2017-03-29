package com.dcs.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dcs.dto.ListInfoDto;
import com.dcs.pojo.ListInfo;
import com.dcs.pojo.request.Page;

public interface PojoToMapperDao {
	
	Integer insertList(ListInfo listinfo);
	
	Integer insertInfo(@Param("table")String tableName,@Param("map")HashMap map);
	
	Integer deleteInfo(@Param("table")String tableName, @Param("id")Integer id,@Param("reviser") Integer reviser);
	
	Integer updateInfo(@Param("table")String tableName,@Param("map")HashMap map, @Param("id")Integer id);

	List<ListInfo> findListInfo(@Param("creator")Integer creator,@Param("page")Page page,@Param("listId") String listId);
	
	List<HashMap> selectInfo(@Param("table")String tableName,@Param("infoId")Integer infoId);
	
	List<ListInfo> selectListInfo(@Param("listId") Integer listId,@Param("level")String level,@Param("page")Page page);
	
	Integer selectMax(@Param("table")String tableName);

	Integer deleteList(@Param("id")Integer id,@Param("reviser") int reviser);

}
