package com.dcs.util;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.dcs.pojo.CadresInfo;

public class StringToMap {
	public static HashMap  getData(String str){
		String sb = str.substring(1, str.length()-1);
		 String[] name =  sb.split(",");
		 String[] nn =null;
		 HashMap map = new HashMap();
		 for(int i= 0;i<name.length; i++){
			 nn = name[i].split("=");
			 map.put(nn[0], nn[1]);
		 }
		return map;
	}
}
