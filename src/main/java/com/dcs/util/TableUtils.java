package com.dcs.util;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class TableUtils {

	public static HashMap upToLow(HashMap<String,Object> map){
		HashMap<String,Object> newMap = new HashMap();
		for(String key : map.keySet()){
			String newKey = "";
			char[] ch = key.toCharArray();
			for(int i=0;i<ch.length;i++){
				if((((int)ch[i]>64) && ((int)ch[i]<91))){
					newKey+="_"+(char)(ch[i]+32);
				} else{
					newKey+=ch[i];
				}
			}
			newMap.put(newKey,map.get(key));
		}
		System.out.println(newMap);
		return newMap;
	}
}
