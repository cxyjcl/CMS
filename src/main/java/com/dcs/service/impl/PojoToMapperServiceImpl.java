package com.dcs.service.impl;

import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcs.dao.PojoToMapperDao;
import com.dcs.dto.ListInfoDto;
import com.dcs.pojo.ListInfo;
import com.dcs.pojo.request.Page;
import com.dcs.service.PojoToMapperService;

/**
 * 
 * ClassName: PojoToMapperServiceImpl
 * @Description: TODO
 * @author pohoulong
 * @date 2017年3月28日 下午2:09:16
 */
@Service("infoService")
public class PojoToMapperServiceImpl implements PojoToMapperService{
	
	@Autowired
	private PojoToMapperDao dao;

	public int deleteList(String value,Integer listId) throws Exception {		
		int num = dao.deleteList(value, listId);
		return num;
	}
	
	public int delete(String value,Integer infoId) throws Exception{
		int num = dao.deleteInfo(value, infoId);
		return num;
	}

	public ListInfoDto select(String value,Page page) throws Exception {		
		ListInfoDto dto = dao.selectInfo(value, page);
		return dto;
	}
	
	@Override
	public void insert(String value, InputStream inputStream, int id) {
			
	}

	@Override
	public int update(String value, Integer divId, HashMap infoMap)
			throws Exception {
		Integer id= dao.updateInfo(value,infoMap,divId);
		return id;
	}

	@Override
	public ListInfo findInfo(String creator, Integer listId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ListInfo> selectListInfo(Integer listId, String level)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}
