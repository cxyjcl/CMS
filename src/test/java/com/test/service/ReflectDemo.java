package com.test.service;

public class ReflectDemo {
		 public static void main(String[] args) {
		  // TODO Auto-generated method stub
		  //通过反射来获得类所实现的接口
		     Class<?> c=null;
		     try {
		  c=Class.forName("com.dcs.service.UserService");
		 } catch (ClassNotFoundException e) {
		  // TODO Auto-generated catch block
		  e.printStackTrace();
		 }
		 Class<?> inter[]=null;//声明一个对象数组
		 inter=c.getInterfaces();//获取类实现的所有接口
		 for(int i=0;i<inter.length;i++){
		  System.out.println(inter[i].getName());//打印出完整的包名+接口
		 }
		 }
}
