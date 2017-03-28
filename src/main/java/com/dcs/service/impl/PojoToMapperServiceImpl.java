package com.dcs.service.impl;

import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcs.dao.PojoToMapperDao;
import com.dcs.service.PojoToMapperService;

@Service("infoService")
public class PojoToMapperServiceImpl implements PojoToMapperService{
	
	@Autowired
	private PojoToMapperDao dao;

	public int delete(List<String> contents) throws Exception {		
		return 0;
	}

	public int select(List<String> contents) throws Exception {		
		return 0;
	}
	
	@Override
	public void insert(String value, InputStream inputStream, int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(String value, Integer divId, HashMap infoMap)
			throws Exception {
		Integer id= dao.updateInfo(value,infoMap,divId);
		System.out.println(id);
	}
	
}
