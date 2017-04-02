package com.dcs.service.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
	public ArrayList<IndividualAchievement> upload() throws IOException {

		ArrayList<IndividualAchievement> individualAchievementList = new ArrayList<IndividualAchievement>();

		// 1.导入excel文件
		file = new File("excel/个人成果及获奖情况.xls");

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

			IndividualAchievement individualAchievement = new IndividualAchievement();
			individualAchievement.setAchievement(cell[0].getStringCellValue());
			individualAchievement.setReward(cell[1].getStringCellValue());
			individualAchievement.setRewardTime(cell[2].getStringCellValue());
			individualAchievement.setRemark(cell[3].getStringCellValue());
			individualAchievementList.add(individualAchievement);
			rowIndex++;
			row = sheet.getRow(rowIndex);
		}
		System.out.println("IndividualAchievement中数据导入完毕.");
		System.out.println(individualAchievementList);
		return individualAchievementList;
	}

	public OutputStream download(ArrayList<IndividualAchievement> individualAchievementList)
			throws FileNotFoundException, IOException {
		// 选择文件
		file = new File("tempExcel/个人成果及获奖情况.xls");
		workbook = new HSSFWorkbook(new FileInputStream(file));// 创建操作Excel的HSSFWorkbook对象
		sheet = workbook.getSheetAt(0);

		int size = individualAchievementList.size();
		for (int i = 0; i < size; i++) {// 循环，控制总行数
			HSSFRow row = sheet.createRow(i + rowIndex);
			IndividualAchievement individualAchievement = individualAchievementList.get(i);
			HSSFCell cell = row.createCell(0);
			cell.setCellValue(individualAchievement.getAchievement());
			cell = row.createCell(1);
			cell.setCellValue(individualAchievement.getReward());
			cell = row.createCell(2);
			cell.setCellValue(individualAchievement.getRewardTime());
			cell = row.createCell(3);
			cell.setCellValue(individualAchievement.getRemark());

		}

		// 利用数据流写入
		OutputStream out = null;
		out = new FileOutputStream(file);
		// try {
		// workbook.write(out);
		// out.close();
		// } catch (FileNotFoundException e) {
		// e.printStackTrace();
		// } catch (IOException e) {
		// e.printStackTrace();
		// }

		System.out.println("数据已经写入excel中。");
		return out;
	}
}
