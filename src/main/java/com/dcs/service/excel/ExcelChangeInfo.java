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
import org.junit.Test;

import com.dcs.pojo.ChangeInfo;

public class ExcelChangeInfo {
	private int rowIndex = 2; // The row index start from 4 row.
	private final int column = 5; // All column is 9.

	private HSSFWorkbook workbook;
	private HSSFSheet sheet;
	private HSSFRow row;
	private HSSFCell[] cell = new HSSFCell[column];
	private File file;

	/**
	 * 年级学籍异动学生名单和原因
	 * 
	 * @param file
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws IOException
	 */
	@Test
	public void ChangeInfoServers() throws IOException {

		ArrayList<ChangeInfo> changeInfoList = new ArrayList<ChangeInfo>();

		// 1.导入excel文件
		file = new File("excel/年级学籍异动学生名单和原因.xls");

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

			ChangeInfo changeInfo = new ChangeInfo();
			changeInfo.setName(cell[0].getStringCellValue());
			changeInfo.setStudentId((int) cell[1].getNumericCellValue());
			changeInfo.setClassroom(cell[2].getStringCellValue());
			changeInfo.setChangeReason(cell[3].getStringCellValue());
			changeInfo.setChangeTime(cell[4].getDateCellValue());
			changeInfoList.add(changeInfo);

		}
		System.out.println("ChangeInfo中数据导入完毕.");
		System.out.println(changeInfoList);
		// return changeInfoList;
	}
}
