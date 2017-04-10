package com.dcs.util;

import com.dcs.service.excel.mainTest;

public class WTStringUtils {
	public static String underlineToCamel(String str) {
		String pattern[] = str.split("_");
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < pattern.length; i++) {
			if (i == 0) {
				builder.append(pattern[i]);
			} else {
				builder.append(pattern[i].substring(0, 1).toUpperCase());
				builder.append(pattern[i].substring(1));
			}
		}
		return builder.toString();
	}
	 
	public static String camelToUnderline(String str) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			if (i == 0) {
				builder.append(str.charAt(0));
			} else {
				char charAt = str.charAt(i);
				if (Character.isUpperCase(charAt)) {
					builder.append("_").append(Character.toLowerCase(charAt));
				} else {
					builder.append(charAt);
				}

			}
		}
		return builder.toString();
	}

	
	public static void main(String[] args) {
		System.out.println(camelToUnderline("excelName"));
	}
}
