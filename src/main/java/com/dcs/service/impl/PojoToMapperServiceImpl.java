package com.dcs.service.impl;

import java.io.File;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcs.dao.DeleteInfoDao;
import com.dcs.dao.InsertInfoDao;
import com.dcs.dao.SelectInfoDao;
import com.dcs.dao.UpdateInfoDao;
import com.dcs.service.PojoToMapperService;

@Service
public class PojoToMapperServiceImpl implements PojoToMapperService{
	
	@Autowired
	private DeleteInfoDao deleteInfoDao;
	
	@Autowired
	private InsertInfoDao insertInfoDao;
	
	@Autowired
	private SelectInfoDao selectInfoDao;
	
	@Autowired
	private UpdateInfoDao updateInfoDao;

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
	public void update(String value, String divCode, String changeValue, int id)
			throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	
}
