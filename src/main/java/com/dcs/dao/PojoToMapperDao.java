package com.dcs.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dcs.dto.ListInfoDto;
import com.dcs.pojo.ListInfo;
import com.dcs.pojo.WordInfo;
import com.dcs.pojo.request.Page;
import com.dcs.vo.UpdateVo;

public interface PojoToMapperDao {
	
	Integer insertList(ListInfo listinfo);
	
	Integer insertInfo(@Param("table")String tableName,@Param("map")HashMap map);
	
	Integer deleteInfo(@Param("table")String tableName, @Param("id")Integer id,@Param("reviser") Integer reviser);
	
	Integer updateInfo(@Param("table")String tableName,@Param("vo")UpdateVo vo);
	
	List<ListInfoDto> findListInfo(@Param("value")String value,@Param("level")String level,@Param("page")Page page,@Param("listId") String listId);
	
	List<LinkedHashMap> selectInfo(@Param("table")String tableName,@Param("infoId")Integer infoId,@Param("page")Page page);
	
	List<ListInfoDto> selectListInfo(@Param("listId") Integer listId,@Param("level")String level,@Param("page")Page page);
	
	Integer selectMax(@Param("table")String tableName,@Param("dataStatus")String dataStatus);

	Integer deleteList(@Param("id")Integer id,@Param("reviser") int reviser);

	List<ListInfoDto> selectLimit();

	String selectTitle(@Param("listId")String listId, @Param("infoId")Integer infoId);

	Integer insertWord(WordInfo info);

	String selectWord(String id);

	Integer countInfo(@Param("table")String table,@Param("id") Integer id);

	Integer countList(@Param("code")Integer code,@Param("level") String level);

	Integer updateUrl(@Param("url")String url,@Param("id") Integer id,@Param("table") String table);

	String selectExcelName(String id);

}
