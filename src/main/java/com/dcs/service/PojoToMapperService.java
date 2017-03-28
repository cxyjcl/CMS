package com.dcs.service;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import com.dcs.dto.ListInfoDto;
import com.dcs.pojo.ListInfo;
import com.dcs.pojo.request.Page;

public interface PojoToMapperService {
	
	public int delete(String value,Integer infoId) throws Exception;
	
	public int deleteList(String value,Integer listId) throws Exception;
	
	public ListInfoDto select(String value,Page page) throws Exception;

	public void insert(String value, InputStream inputStream, int id) throws Exception;
	
	public int update(String value, Integer divId, HashMap infoMap) throws Exception ;

	public ListInfo findInfo(String creator,Integer listId) throws Exception;
	
	public List<ListInfo> selectListInfo(Integer listId,String level) throws Exception;
	
}
