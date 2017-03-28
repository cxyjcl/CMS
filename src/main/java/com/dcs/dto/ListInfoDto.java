package com.dcs.dto;

import java.util.HashMap;

import com.dcs.pojo.ListInfo;
import com.dcs.pojo.request.Page;

/**
 * 
 * ClassName: ListInfoVo
 * @Description: TODO
 * @author pohoulong
 * @date 2017年3月24日 下午5:55:45
 */
public class ListInfoDto{
	
	ListInfo info;
	HashMap voMap = new HashMap();
	
	public ListInfo getInfo() {
		return info;
	}
	public void setInfo(ListInfo info) {
		this.info = info;
	}
	public HashMap getVoMap() {
		return voMap;
	}
	public void setVoMap(HashMap voMap) {
		this.voMap = voMap;
	}
}
