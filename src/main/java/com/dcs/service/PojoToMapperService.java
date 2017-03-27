package com.dcs.service;

import java.io.InputStream;
import java.util.List;

public interface PojoToMapperService {
	
	public int delete(List<String> contents) throws Exception;
		
	public int select(List<String> contents) throws Exception;

	public void insert(String value, InputStream inputStream, int id) throws Exception;

	public void update(String value, String divCode, String changeValue,
			int id) throws Exception;
}
