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

import com.dcs.pojo.TeacherInfo;

public class ExcelTeacherInfo {
	private int rowIndex = 2; // The row index start from 3 row.
	private final int column = 6; // All column is 6.

	private HSSFWorkbook workbook;
	private HSSFSheet sheet;
	private HSSFRow row;
	private HSSFCell[] cell = new HSSFCell[column];
	private File file;

	/**
	 * 班主任名单
	 * 
	 * @param file
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws IOException
	 */
	@Test
	public void teacherInfoServers() throws IOException {

		ArrayList<TeacherInfo> teacherInfoList = new ArrayList<TeacherInfo>();

		// 1.导入excel文件
		file = new File("excel/学工办/班主任名单.xls");

		if (!file.exists())
			System.out.println("The file is not exist!");
		InputStream in = new FileInputStream(file);

		workbook = new HSSFWorkbook(in);// 创建操作Excel的HSSFWorkbook对象
		sheet = workbook.getSheetAt(0);// 创建HSSFsheet对象。

		/* 配合表格中的格式，从第rowIndex行开始读取 */
		// 用HSSFCell对象的getCell()方法取出每一个的值 sheet.getLastRowNum()
		for (; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
			row = sheet.getRow(rowIndex);
			if (row.getCell(0).getStringCellValue() == "" || row.getCell(0).getStringCellValue() == null)
				continue;
			for (int i = 0; i < column; i++) {
				if (row.getCell(i) != null)
					cell[i] = row.getCell(i);
				else
					cell[i] = null;
			}

			TeacherInfo teacherInfo = new TeacherInfo();
			teacherInfo.setClassroom(cell[0].getStringCellValue());
			teacherInfo.setTeacher(cell[1].getStringCellValue());
			teacherInfo.setSex(cell[2].getStringCellValue());
			teacherInfo.setNativePlace(cell[3].getStringCellValue());
			teacherInfo.setBirthPlace(cell[4].getStringCellValue());
			row.getCell(5).setCellType(Cell.CELL_TYPE_STRING);
			teacherInfo.setContacts(cell[5].getStringCellValue());
			teacherInfoList.add(teacherInfo);

		}
		System.out.println("TeacherInfo中数据导入完毕.");
		System.out.println(teacherInfoList);
		// return teacherInfoList;
	}
}
