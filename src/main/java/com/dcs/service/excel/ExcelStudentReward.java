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

import com.dcs.pojo.StudentReward;

public class ExcelStudentReward {
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
	public ArrayList<StudentReward> upload(InputStream in) throws IOException {

		ArrayList<StudentReward> studentRewardList = new ArrayList<StudentReward>();

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
		return studentRewardList;
	}

	public OutputStream download(ArrayList<StudentReward> studentRewardList) throws FileNotFoundException, IOException {
		// 选择文件
		file = new File("tempExcel/分团委/学生荣誉名单（团委）.xls");
		workbook = new HSSFWorkbook(new FileInputStream(file));// 创建操作Excel的HSSFWorkbook对象
		sheet = workbook.getSheetAt(0);

		int size = studentRewardList.size();
		for (int i = 0; i < size; i++) {// 循环，控制总行数
			HSSFRow row = sheet.createRow(i + rowIndex);
			StudentReward studentReward = studentRewardList.get(i);
			HSSFCell cell = row.createCell(1);
			cell.setCellValue(studentReward.getName());
			cell = row.createCell(2);
			cell.setCellValue(studentReward.getStudentId());
			cell = row.createCell(3);
			cell.setCellValue(studentReward.getGrade());
			cell = row.createCell(4);
			cell.setCellValue(studentReward.getClassroom());
			cell = row.createCell(5);
			cell.setCellValue(studentReward.getRewardName());
			cell = row.createCell(6);
			cell.setCellValue(studentReward.getRewardGrade());
			cell = row.createCell(7);
			cell.setCellValue(studentReward.getRewardTime());
			cell = row.createCell(8);
			cell.setCellValue(studentReward.getRemark());
			cell = row.createCell(0);
			cell.setCellValue(studentReward.getRewardNature());

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
