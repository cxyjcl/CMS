package com;

import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.dcs.constants.ListCodeEnum;

public class Test {
	 
    //使用POI读入excel工作簿文件 
    public static void readWorkBook() throws Exception { 
		String excelName = "新闻上传情况.doc".replaceAll("(?:.doc|.xls)", "");
				System.out.println(excelName);
    } 
 
    public static void main(String[] args) throws Exception {
    	readWorkBook();
	}
}
