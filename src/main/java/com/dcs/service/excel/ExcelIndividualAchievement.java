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

import com.dcs.pojo.IndividualAchievement;

public class ExcelIndividualAchievement {
	private int rowIndex = 3; // The row index start from 4 row.
	private final int column = 4; // All column is 4.

	private HSSFWorkbook workbook;
	private HSSFSheet sheet;
	private HSSFRow row;
	private HSSFCell[] cell = new HSSFCell[column];
	private File file;

	/**
	 * 个人成果及获奖情况
	 * 
	 * @param file
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws IOException
	 */
	@Test
	public void individualAchievementServers() throws IOException {

		ArrayList<IndividualAchievement> individualAchievementList = new ArrayList<IndividualAchievement>();

		// 1.导入excel文件
		file = new File("excel/个人成果及获奖情况.xls");

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

			IndividualAchievement individualAchievement = new IndividualAchievement();
			individualAchievement.setAchievement(cell[0].getStringCellValue());
			individualAchievement.setReward(cell[1].getStringCellValue());
			individualAchievement.setRewardTime(cell[2].getDateCellValue());
			individualAchievement.setRemark(cell[3].getStringCellValue());
			individualAchievementList.add(individualAchievement);

		}
		System.out.println("IndividualAchievement中数据导入完毕.");
		System.out.println(individualAchievementList);
		// return individualAchievementList;
	}
}
