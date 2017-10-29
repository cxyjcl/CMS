package com.dcs.service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import com.dcs.dto.ListInfoDto;
import com.dcs.pojo.ListInfo;
import com.dcs.pojo.request.Page;
import com.dcs.vo.UpdateVo;

public interface PojoToMapperService {
		
	public int deleteList(Integer id, Integer reviser) throws Exception;
	
	public List<LinkedHashMap> selectInfo(String code,Integer infoId,Page page) throws Exception;

	public int insert(String code, InputStream inputStream,String fileName, ListInfo listInfo) throws Exception;
	
	public List<ListInfoDto> findListInfo(String value,String levels, Page page, String listId)
			throws Exception;

	List<ListInfoDto> selectListInfo(Integer listId, String level, Page page)
			throws Exception;

	int delete(String table, int id,Integer reviser) throws Exception;

	public List<ListInfoDto> selectLimit() throws Exception;
	
	public LinkedHashMap selectCol(String code) throws Exception;

	public String selectTitle(String code, Integer infoId) throws Exception;

	public int update(String value, UpdateVo vo) throws Exception ;

	public String selectWord(String id) throws Exception;

	public Integer countInfo(String table, Integer id) throws Exception;

	public Integer countList(Integer code, String level) throws Exception;

	public Integer addExtraFile(String string, InputStream inputStream, Integer id,String type) throws Exception;

	public String selectExcelName(String id) throws Exception;

	
}
