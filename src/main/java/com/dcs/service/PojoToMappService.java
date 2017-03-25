package com.dcs.service;

import java.util.List;

public interface PojoToMappService<T> {
	int insert(List<T> contents) throws Exception;
}
