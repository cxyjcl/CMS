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

import com.dcs.pojo.ContestInfo;

public class ExcelContestInfo {
	private int rowIndex = 2; // The row index start from 3 row.
	private final int column = 7; // All column is 7.

	private HSSFWorkbook workbook;
	private HSSFSheet sheet;
	private HSSFRow row;
	private HSSFCell[] cell = new HSSFCell[column];
	private File file;

	/**
	 * 学科竞赛统计表
	 * 
	 * @param file
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws IOException
	 */
	@Test
	public ArrayList<ContestInfo> upload() throws IOException {

		ArrayList<ContestInfo> contestInfoList = new ArrayList<ContestInfo>();

		// 1.导入excel文件
		file = new File("excel/学科竞赛统计表.xls");

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

			ContestInfo contestInfo = new ContestInfo();
			contestInfo.setSponsor(cell[0].getStringCellValue());
			contestInfo.setContestName(cell[1].getStringCellValue());
			contestInfo.setContestGrade(cell[2].getStringCellValue());
			contestInfo.setWorkName(cell[3].getStringCellValue());
			contestInfo.setContestStudent(cell[4].getStringCellValue());
			contestInfo.setTutor(cell[5].getStringCellValue());
			contestInfo.setRemark(cell[6].getStringCellValue());
			contestInfoList.add(contestInfo);
			rowIndex++;
			row = sheet.getRow(rowIndex);

		}
		System.out.println("ContestInfo中数据导入完毕.");
		System.out.println(contestInfoList);
		return contestInfoList;
	}

	public OutputStream download(ArrayList<ContestInfo> contestInfoList) throws FileNotFoundException, IOException {
		// 选择文件
		file = new File("tempExcel/学科竞赛统计表.xls");
		workbook = new HSSFWorkbook(new FileInputStream(file));// 创建操作Excel的HSSFWorkbook对象
		sheet = workbook.getSheetAt(0);

		int size = contestInfoList.size();
		for (int i = 0; i < size; i++) {// 循环，控制总行数
			HSSFRow row = sheet.createRow(i + rowIndex);
			ContestInfo contestInfo = contestInfoList.get(i);
			HSSFCell cell = row.createCell(0);
			cell.setCellValue(contestInfo.getSponsor());
			cell = row.createCell(1);
			cell.setCellValue(contestInfo.getContestName());
			cell = row.createCell(2);
			cell.setCellValue(contestInfo.getContestGrade());
			cell = row.createCell(3);
			cell.setCellValue(contestInfo.getWorkName());
			cell = row.createCell(4);
			cell.setCellValue(contestInfo.getContestStudent());
			cell = row.createCell(5);
			cell.setCellValue(contestInfo.getTutor());
			cell = row.createCell(6);
			cell.setCellValue(contestInfo.getRemark());

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
