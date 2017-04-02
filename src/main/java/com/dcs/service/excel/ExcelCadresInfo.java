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

import com.dcs.pojo.CadresInfo;

public class ExcelCadresInfo {
	private int rowIndex = 3; // The row index start from 4 row.
	private final int column = 9; // All column is 9.

	private HSSFWorkbook workbook;
	private HSSFSheet sheet;
	private HSSFRow row;
	private HSSFCell[] cell = new HSSFCell[column];
	private File file;

	/**
	 * 各组织学生干部名单表模板
	 * 
	 * @param file
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws IOException
	 */
	@Test
	public ArrayList<CadresInfo> upload() throws IOException {

		ArrayList<CadresInfo> cadresInfoList = new ArrayList<CadresInfo>();

		// 1.导入excel文件
		file = new File("excel/分团委/各组织学生干部名单表模板.xls");

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

			CadresInfo cadresInfo = new CadresInfo();
			cadresInfo.setNameChairman(cell[0].getStringCellValue());
			cadresInfo.setFunctionChairman(cell[1].getStringCellValue());
			row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
			cadresInfo.setContactsChairman(cell[2].getStringCellValue());
			cadresInfo.setDepartmentCharge(cell[3].getStringCellValue());
			cadresInfo.setNameSecretary(cell[4].getStringCellValue());
			cadresInfo.setFunctionSecretary(cell[5].getStringCellValue());
			row.getCell(6).setCellType(Cell.CELL_TYPE_STRING);
			cadresInfo.setContactsSecretary(cell[6].getStringCellValue());
			cadresInfo.setStudentOrganization(cell[7].getStringCellValue());
			cadresInfo.setRemark(cell[8].getStringCellValue());
			cadresInfoList.add(cadresInfo);
			rowIndex++;
			row = sheet.getRow(rowIndex);
		}
		System.out.println("CadresInfo中数据导入完毕.");
		System.out.println(cadresInfoList);
		return cadresInfoList;
	}

	public OutputStream download(ArrayList<CadresInfo> cadresInfoList) throws FileNotFoundException, IOException {
		// 选择文件
		file = new File("tempExcel/分团委/各组织学生干部名单表模板.xls");
		workbook = new HSSFWorkbook(new FileInputStream(file));// 创建操作Excel的HSSFWorkbook对象
		sheet = workbook.getSheetAt(0);

		int size = cadresInfoList.size();
		for (int i = 0; i < size; i++) {// 循环，控制总行数
			HSSFRow row = sheet.createRow(i + rowIndex);
			CadresInfo cadresInfo = cadresInfoList.get(i);
			HSSFCell cell = row.createCell(0);
			cell.setCellValue(cadresInfo.getNameChairman());
			cell = row.createCell(1);
			cell.setCellValue(cadresInfo.getFunctionChairman());
			cell = row.createCell(2);
			cell.setCellValue(cadresInfo.getContactsChairman());
			cell = row.createCell(3);
			cell.setCellValue(cadresInfo.getDepartmentCharge());
			cell = row.createCell(4);
			cell.setCellValue(cadresInfo.getNameSecretary());
			cell = row.createCell(5);
			cell.setCellValue(cadresInfo.getFunctionSecretary());
			cell = row.createCell(6);
			cell.setCellValue(cadresInfo.getContactsSecretary());
			cell = row.createCell(7);
			cell.setCellValue(cadresInfo.getStudentOrganization());
			cell = row.createCell(8);
			cell.setCellValue(cadresInfo.getRemark());

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
