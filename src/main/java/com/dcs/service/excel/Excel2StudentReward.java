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

import com.dcs.pojo.StudentReward;

public class Excel2StudentReward {
	private int rowIndex = 2; // The row index start from 3 row.
	private final int column = 9; // All column is 9.

	private HSSFWorkbook workbook;
	private HSSFSheet sheet;
	private HSSFRow row;
	private HSSFCell[] cell = new HSSFCell[column];
	private File file;

	/**
	 * 学生荣誉名单（团委）
	 * 
	 * @param file
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws IOException
	 */
	@Test
	public void studentRewardServers() throws IOException {

		ArrayList<StudentReward> studentRewardList = new ArrayList<StudentReward>();

		// 1.导入excel文件
		file = new File("excel/分团委/学生荣誉名单（团委）.xls");

		if (!file.exists())
			System.out.println("The file is not exist!");
		InputStream in = new FileInputStream(file);

		workbook = new HSSFWorkbook(in);// 创建操作Excel的HSSFWorkbook对象
		sheet = workbook.getSheetAt(0);// 创建HSSFsheet对象。

		row = sheet.getRow(rowIndex);
		/* 配合表格中的格式，从第rowIndex行开始读取 */
		// 用HSSFCell对象的getCell()方法取出每一个的值 sheet.getLastRowNum()
		while (row != null && row.getCell(1).getStringCellValue() != "") {
			for (int i = 0; i < column; i++) {
				if (row.getCell(i) != null)
					cell[i] = row.getCell(i);
				else
					cell[i] = null;
			}

			StudentReward studentReward = new StudentReward();
			studentReward.setName(cell[1].getStringCellValue());
			studentReward.setStudentId((int) cell[2].getNumericCellValue());
			studentReward.setGrade(cell[3].getStringCellValue());
			studentReward.setClassroom(cell[4].getStringCellValue());
			studentReward.setRewardName(cell[5].getStringCellValue());
			studentReward.setRewardGrade(cell[6].getStringCellValue());
			studentReward.setRewardTime(cell[7].getStringCellValue());
			studentReward.setRemark(cell[8].getStringCellValue());
			studentReward.setRewardNature(cell[0].getStringCellValue());
			studentRewardList.add(studentReward);
			rowIndex++;
			row = sheet.getRow(rowIndex);
		}
		System.out.println("StudentReward中数据导入完毕.");
		System.out.println(studentRewardList);
		// return studentRewardList;
	}
}
