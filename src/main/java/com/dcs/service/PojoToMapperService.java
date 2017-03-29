package com.dcs.service;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import com.dcs.dto.ListInfoDto;
import com.dcs.pojo.ListInfo;
import com.dcs.pojo.request.Page;

public interface PojoToMapperService {
		
	public int deleteList(Integer id, Integer reviser) throws Exception;
	
	public HashMap selectInfo(String value,String infoId) throws Exception;

	public int insert(String code, InputStream inputStream,ListInfo listInfo) throws Exception;
	
	public int update(String value, Integer divId, HashMap infoMap,ListInfo listInfo) throws Exception ;
	
	public ListInfo findListInfo(String creator, Page page, Integer listId)
			throws Exception;

	List<ListInfo> selectListInfo(Integer listId, String level, Page page)
			throws Exception;

	int delete(String table, int id,Integer reviser) throws Exception;
	
}
