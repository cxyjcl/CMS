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

import com.dcs.pojo.PunishInfo;

public class ExcelPunishInfo {
	private int rowIndex = 2; // The row index start from 3 row.
	private final int column = 6; // All column is 6.

	private HSSFWorkbook workbook;
	private HSSFSheet sheet;
	private HSSFRow row;
	private HSSFCell[] cell = new HSSFCell[column];
	private File file;

	/**
	 * 年级受处分学生名单
	 * 
	 * @param file
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws IOException
	 */
	@Test
	public ArrayList<PunishInfo> upload() throws IOException {

		ArrayList<PunishInfo> punishInfoList = new ArrayList<PunishInfo>();

		// 1.导入excel文件
		file = new File("excel/年级受处分学生名单.xls");

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

			PunishInfo punishInfo = new PunishInfo();
			punishInfo.setName(cell[0].getStringCellValue());
			punishInfo.setStudentId((int) cell[1].getNumericCellValue());
			punishInfo.setClassroom(cell[2].getStringCellValue());
			punishInfo.setPunishGrade(cell[3].getStringCellValue());
			punishInfo.setPunishReason(cell[4].getStringCellValue());
			punishInfo.setPunishTime(cell[5].getStringCellValue());
			punishInfoList.add(punishInfo);
			rowIndex++;
			row = sheet.getRow(rowIndex);
		}
		System.out.println("PunishInfo中数据导入完毕.");
		System.out.println(punishInfoList);
		return punishInfoList;
	}

	public OutputStream download(ArrayList<PunishInfo> punishInfoList) throws FileNotFoundException, IOException {
		// 选择文件
		file = new File("tempExcel/年级受处分学生名单.xls");
		workbook = new HSSFWorkbook(new FileInputStream(file));// 创建操作Excel的HSSFWorkbook对象
		sheet = workbook.getSheetAt(0);

		int size = punishInfoList.size();
		for (int i = 0; i < size; i++) {// 循环，控制总行数
			HSSFRow row = sheet.createRow(i + rowIndex);
			PunishInfo punishInfo = punishInfoList.get(i);
			HSSFCell cell = row.createCell(0);
			cell.setCellValue(punishInfo.getName());
			cell = row.createCell(1);
			cell.setCellValue(punishInfo.getStudentId());
			cell = row.createCell(2);
			cell.setCellValue(punishInfo.getClassroom());
			cell = row.createCell(3);
			cell.setCellValue(punishInfo.getPunishGrade());
			cell = row.createCell(4);
			cell.setCellValue(punishInfo.getPunishReason());
			cell = row.createCell(5);
			cell.setCellValue(punishInfo.getPunishTime());

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
