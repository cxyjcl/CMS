package com;

import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Test {
	 
    //使用POI读入excel工作簿文件 
    public static void readWorkBook() throws Exception { 
        // poi读取excel 
        //创建要读入的文件的输入流 
    	String url =Test.class.getResource("/").toURI().getPath().replace("classes/","excel/");
        InputStream inp = new FileInputStream(url+"个人成果及获奖情况.xls"); 
         
        //根据上述创建的输入流 创建工作簿对象 
        Workbook wb = WorkbookFactory.create(inp); 
        //得到第一页 sheet 
        //页Sheet是从0开始索引的 
        Sheet sheet = wb.getSheetAt(0); 
        //利用foreach循环 遍历sheet中的所有行 
        for (Row row : sheet) { 
            //遍历row中的所有方格 
            for (Cell cell : row) { 
                //输出方格中的内容，以空格间隔 
                System.out.print(cell.toString() + "  "); 
            } 
            //每一个行输出之后换行 
            System.out.println(); 
        } 
        //关闭输入流 
        inp.close(); 
    } 
 
    public static void main(String[] args) throws Exception {
    	readWorkBook();
	}
}
