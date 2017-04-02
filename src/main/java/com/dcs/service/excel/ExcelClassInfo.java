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
import org.apache.poi.ss.usermodel.Cell;
import org.junit.Test;

import com.dcs.pojo.ClassInfo;

public class ExcelClassInfo {
	private int rowIndex = 2; // The row index start from 3 row.
	private final int column = 8; // All column is 8.

	private HSSFWorkbook workbook;
	private HSSFSheet sheet;
	private HSSFRow row;
	private HSSFCell[] cell = new HSSFCell[column];
	private File file;

	/**
	 * 学生班级信息一览表
	 * 
	 * @param file
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws IOException
	 */
	@Test
	public ArrayList<ClassInfo> upload() throws IOException {

		ArrayList<ClassInfo> classInfoList = new ArrayList<ClassInfo>();

		// 1.导入excel文件
		file = new File("excel/学生班级信息一览表.xls");

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

			ClassInfo classInfo = new ClassInfo();
			classInfo.setStudentId((int) cell[0].getNumericCellValue());// Integer
			classInfo.setName(cell[1].getStringCellValue());
			classInfo.setSex(cell[2].getStringCellValue());
			classInfo.setNativePlace(cell[3].getStringCellValue());
			classInfo.setBirthPlace(cell[4].getStringCellValue());
			row.getCell(5).setCellType(Cell.CELL_TYPE_STRING);
			classInfo.setIdCard(cell[5].getStringCellValue());
			row.getCell(6).setCellType(Cell.CELL_TYPE_STRING);
			classInfo.setContacts(cell[6].getStringCellValue());
			row.getCell(7).setCellType(Cell.CELL_TYPE_BOOLEAN);
			classInfo.setPartyMember(cell[7].getBooleanCellValue());// boolean
			classInfoList.add(classInfo);
			rowIndex++;
			row = sheet.getRow(rowIndex);
		}
		System.out.println("ClassInfo中数据导入完毕.");
		System.out.println(classInfoList);
		return classInfoList;
	}

	public OutputStream download(ArrayList<ClassInfo> classInfoList) throws FileNotFoundException, IOException {
		// 选择文件
		file = new File("tempExcel/学生班级信息一览表.xls");
		workbook = new HSSFWorkbook(new FileInputStream(file));// 创建操作Excel的HSSFWorkbook对象
		sheet = workbook.getSheetAt(0);

		int size = classInfoList.size();
		for (int i = 0; i < size; i++) {// 循环，控制总行数
			HSSFRow row = sheet.createRow(i + rowIndex);
			ClassInfo classInfo = classInfoList.get(i);
			HSSFCell cell = row.createCell(0);
			cell.setCellValue(classInfo.getStudentId());
			cell = row.createCell(1);
			cell.setCellValue(classInfo.getName());
			cell = row.createCell(2);
			cell.setCellValue(classInfo.getSex());
			cell = row.createCell(3);
			cell.setCellValue(classInfo.getNativePlace());
			cell = row.createCell(4);
			cell.setCellValue(classInfo.getBirthPlace());
			cell = row.createCell(5);
			cell.setCellValue(classInfo.getIdCard());
			cell = row.createCell(6);
			cell.setCellValue(classInfo.getContacts());
			cell = row.createCell(7);
			cell.setCellValue(classInfo.getPartyMember());

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
