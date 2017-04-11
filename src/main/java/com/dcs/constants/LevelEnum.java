package com.dcs.constants;

import org.apache.commons.lang.StringUtils;

public enum LevelEnum {
	ADMIN("0", "管理员"),SUPERVISOR("1", "辅导员"), Student("2", "学工办"),COMMITTE("3", "分团委");
	
	private String code;

	private final String value;

	LevelEnum(String code, String value) {
		this.code = code;
		this.value = value;
	}
	
	

	public String getCode() {
		return code;
	}



	public void setCode(String code) {
		this.code = code;
	}



	public String getValue() {
		return value;
	}


	public static LevelEnum fromCode(String code) {
		for (LevelEnum c : LevelEnum.values()) {
			if (StringUtils.equals(c.getCode(), code)) {
				return c;
			}
		}
		throw new IllegalArgumentException(code + "");
	}
	
	public static LevelEnum fromValue(String value) {
		for (LevelEnum c : LevelEnum.values()) {
			if (StringUtils.equals(c.getValue(), value)) {
				return c;
			}
		}
		throw new IllegalArgumentException(value + "");
	}

	public static void main(String[] args) {
		String str = null;
		System.out.println(str.toString());
	}
}
