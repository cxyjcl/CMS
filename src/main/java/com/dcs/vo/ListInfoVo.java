package com.dcs.vo;

import java.util.ArrayList;

import com.dcs.pojo.ListInfo;
import com.dcs.pojo.request.Page;

/**
 * 
 * ClassName: ListInfoVo
 * @Description: TODO
 * @author pohoulong
 * @date 2017年3月24日 下午5:55:45
 */
public class ListInfoVo extends Page{
	
	ListInfo info;
	ArrayList voList = new ArrayList();
	
	public ListInfo getInfo() {
		return info;
	}
	public void setInfo(ListInfo info) {
		this.info = info;
	}
	public ArrayList getVoList() {
		return voList;
	}
	public void setVoList(ArrayList voList) {
		this.voList = voList;
	}
	
}
