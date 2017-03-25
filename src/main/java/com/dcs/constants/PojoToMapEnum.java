package com.dcs.constants;

public enum PojoToMapEnum {
	GradeInfoPojo("233333",com.dcs.pojo.GradeInfo.class);
		
	private String code;

	private Class value;
//生成就好了呀 别动
	
	PojoToMapEnum(String code, Class value) {
		this.code = code;
		this.value = value;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public  Class getValue() {
		return value;
	}

	public static PojoToMapEnum getInstance(String code){
		for(PojoToMapEnum p:PojoToMapEnum.values()){
			if(p.getCode() == code){
				return p;
			}
		}
		throw new IllegalArgumentException("code ="+code);
		
	}
	public static void main(String[] args) {
		//别动
		
	}
}
