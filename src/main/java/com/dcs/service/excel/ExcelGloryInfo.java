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

import com.dcs.pojo.GloryInfo;

public class ExcelGloryInfo {
	private int rowIndex = 2; // The row index start from 3 row.
	private final int column = 8; // All column is 8.

	private HSSFWorkbook workbook;
	private HSSFSheet sheet;
	private HSSFRow row;
	private HSSFCell[] cell = new HSSFCell[column];
	private File file;

	/**
	 * 年级各种荣誉名单
	 * 
	 * @param file
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws IOException
	 */
	@Test
	public void gloryInfoServers() throws IOException {

		ArrayList<GloryInfo> gloryInfoList = new ArrayList<GloryInfo>();

		// 1.导入excel文件
		file = new File("excel/年级各种荣誉名单.xls");

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

			GloryInfo gloryInfo = new GloryInfo();
			gloryInfo.setName(cell[1].getStringCellValue());
			gloryInfo.setStudentId((int) cell[2].getNumericCellValue());
			gloryInfo.setClassroom(cell[3].getStringCellValue());
			gloryInfo.setContestName(cell[4].getStringCellValue());
			gloryInfo.setContestGrade(cell[5].getStringCellValue());
			gloryInfo.setRewardTime(cell[6].getDateCellValue());
			gloryInfo.setRemark(cell[7].getStringCellValue());
			gloryInfo.setRewardNature(cell[0].getStringCellValue());
			gloryInfoList.add(gloryInfo);

		}
		System.out.println("GloryInfo中数据导入完毕.");
		System.out.println(gloryInfoList);
		// return gloryInfoList;
	}
}
