package com.dcs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcs.dao.BaseDao;
import com.dcs.service.PojoToMappService;

@Service
public  class PojoToMappServiceImpl<T> implements PojoToMappService<T>{
	
	@Autowired
	private BaseDao<T> base;

	@Override
	public int insert(List<T> contents) throws Exception {
		
		return base.insertBatch(contents);
	}
	
	
}
