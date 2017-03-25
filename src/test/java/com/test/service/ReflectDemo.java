package com.test.service;

import com.dcs.constants.InfoCodeEnum;

public class ReflectDemo {
		 public static void main(String[] args) {
		  // TODO Auto-generated method stub
		  //通过反射来获得类所实现的接口
	     String infoId = "10001";
		 Class<?> c=null;
		 InfoCodeEnum c = InfoCodeEnum.fromCode(infoId);
		 System.out.println(c.getValue());
		 try {
			 c=Class.forName("com.dcs.service.UserService");
		 } catch (ClassNotFoundException e) {
		  e.printStackTrace();
		 }		     
	}
}
