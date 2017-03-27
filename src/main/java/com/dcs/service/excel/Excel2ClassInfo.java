package com.dcs.service.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.junit.Test;

import com.dcs.pojo.ClassInfo;

public class Excel2ClassInfo {
	private int rowIndex = 2; // The row index start from 3 row.
	private final int column = 8; // All column is 8.

	private HSSFWorkbook workbook;
	private HSSFSheet sheet;
	private HSSFRow row;
	private HSSFCell[] cell = new HSSFCell[column];
	private File file;

	/**
	 * 学生班级信息一览表
	 * 
	 * @param file
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws IOException
	 */
	@Test
	public void ClassInfoServers() throws IOException {

		ArrayList<ClassInfo> classInfoList = new ArrayList<ClassInfo>();

		// 1.导入excel文件
		file = new File("excel/学生班级信息一览表.xls");

		if (!file.exists())
			System.out.println("The file is not exist!");
		InputStream in = new FileInputStream(file);

		workbook = new HSSFWorkbook(in);// 创建操作Excel的HSSFWorkbook对象
		sheet = workbook.getSheetAt(0);// 创建HSSFsheet对象。

		/* 配合表格中的格式，从第rowIndex行开始读取 */
		// 用HSSFCell对象的getCell()方法取出每一个的值 sheet.getLastRowNum()
		System.out.println( "row"+rowIndex+"num:"+ sheet.getLastRowNum());
		for (; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
			row = sheet.getRow(rowIndex);
			System.out.println(row.getCell(1).getStringCellValue());
			if (row.getCell(1).getStringCellValue() == "" ||row.getCell(1) == null || row.getCell(1).getStringCellValue() == null)
				continue;
			for (int i = 0; i < column; i++) {
				if (row.getCell(i) != null)
					cell[i] = row.getCell(i);
				else
					cell[i] = null;
			}

			ClassInfo classInfo = new ClassInfo();
			classInfo.setStudentId((int) cell[0].getNumericCellValue());// Integer
			classInfo.setName(cell[1].getStringCellValue());
			classInfo.setSex(cell[2].getStringCellValue());
			classInfo.setNativePlace(cell[3].getStringCellValue());
			classInfo.setBirthPlace(cell[4].getStringCellValue());
			row.getCell(5).setCellType(Cell.CELL_TYPE_STRING);
			classInfo.setIdCard(cell[5].getStringCellValue());
			row.getCell(6).setCellType(Cell.CELL_TYPE_STRING);
			classInfo.setContacts(cell[6].getStringCellValue());
			row.getCell(7).setCellType(Cell.CELL_TYPE_BOOLEAN);
			classInfo.setPartyMember(cell[7].getBooleanCellValue());// boolean
			classInfoList.add(classInfo);

		}
		System.out.println("ClassInfo中数据导入完毕.");
		System.out.println(classInfoList);
		// return classInfoList;
	}
}
