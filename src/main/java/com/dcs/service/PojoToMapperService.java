package com.dcs.service;

import java.io.File;
import java.util.List;

public interface PojoToMapperService {
	
	public int delete(List<String> contents) throws Exception;
	
	public int update(List<String> contents) throws Exception;
	
	public int select(List<String> contents) throws Exception;

	public void insert(String value, File file, int id);
}
