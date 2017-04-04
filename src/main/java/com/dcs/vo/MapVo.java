package com.dcs.vo;

import java.util.LinkedHashMap;
import java.util.List;

import com.dcs.pojo.request.Page;

public class MapVo extends Page{
	
	LinkedHashMap mapString;
	List<LinkedHashMap> mapList;

	public LinkedHashMap getMapString() {
		return mapString;
	}

	public void setMapString(LinkedHashMap mapString) {
		this.mapString = mapString;
	}

	public List<LinkedHashMap> getMapList() {
		return mapList;
	}

	public void setMapList(List<LinkedHashMap> mapList) {
		this.mapList = mapList;
	}

	@Override
	public String toString() {
		return "MapVo [mapString=" + mapString + ", mapList=" + mapList + "]";
	}

	
}
