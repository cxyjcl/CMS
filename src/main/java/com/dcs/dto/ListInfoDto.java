package com.dcs.dto;

import java.util.HashMap;

import com.dcs.pojo.request.Page;

/**
 * 
 * ClassName: ListInfoVo
 * @Description: TODO
 * @author pohoulong
 * @date 2017年3月24日 下午5:55:45
 */
public class ListInfoDto{
	
	String title;
	HashMap dtoMap = new HashMap();
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public HashMap getDtoMap() {
		return dtoMap;
	}
	public void setDtoMap(HashMap dtoMap) {
		this.dtoMap = dtoMap;
	}
	
}
