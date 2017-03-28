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

import com.dcs.pojo.LectureInfo;

public class Excel2LectureInfo {
	private int rowIndex = 2; // The row index start from 3 row.
	private final int column = 6; // All column is 6.

	private HSSFWorkbook workbook;
	private HSSFSheet sheet;
	private HSSFRow row;
	private HSSFCell[] cell = new HSSFCell[column];
	private File file;

	/**
	 * 机械工程学院讲座统计表
	 * 
	 * @param file
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws IOException
	 */
	@Test
	public void lectureInfoServers() throws IOException {

		ArrayList<LectureInfo> lectureInfoList = new ArrayList<LectureInfo>();

		// 1.导入excel文件
		file = new File("excel/机械工程学院讲座统计表.xls");

		if (!file.exists())
			System.out.println("The file is not exist!");
		InputStream in = new FileInputStream(file);

		workbook = new HSSFWorkbook(in);// 创建操作Excel的HSSFWorkbook对象
		sheet = workbook.getSheetAt(0);// 创建HSSFsheet对象。

		row = sheet.getRow(rowIndex);
		/* 配合表格中的格式，从第rowIndex行开始读取 */
		// 用HSSFCell对象的getCell()方法取出每一个的值 sheet.getLastRowNum()
		while (row != null && row.getCell(0).getStringCellValue() != "") {
			for (int i = 0; i < column; i++) {
				if (row.getCell(i) != null)
					cell[i] = row.getCell(i);
				else
					cell[i] = null;
			}

			LectureInfo lectureInfo = new LectureInfo();
			lectureInfo.setPlay(cell[0].getStringCellValue());
			lectureInfo.setTime(cell[1].getDateCellValue());
			lectureInfo.setPlace(cell[2].getStringCellValue());
			lectureInfo.setObject(cell[3].getStringCellValue());
			lectureInfo.setTalker(cell[4].getStringCellValue());
			lectureInfo.setParticipants(cell[5].getStringCellValue());
			lectureInfoList.add(lectureInfo);
			rowIndex++;
			row = sheet.getRow(rowIndex);
		}
		System.out.println("LectureInfo中数据导入完毕.");
		System.out.println(lectureInfoList);
		// return lectureInfoList;
	}
}
