package com.dcs.service.excel;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.junit.Test;

import com.dcs.pojo.CadresInfo;

public class Excel2CadresInfo {
	
	private int rowIndex = 3; // The row index start from 4 row.
	private final int column = 9; // All column is 9.

	private HSSFWorkbook workbook;
	private HSSFSheet sheet;
	private HSSFRow row;
	private HSSFCell[] cell = new HSSFCell[column];

	/**
	 * 各组织学生干部名单表模板
	 * 
	 * @param file
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws IOException
	 */
	@Test
	public ArrayList<CadresInfo> excel(InputStream in) throws IOException {

		ArrayList<CadresInfo> cadresInfoList = new ArrayList<CadresInfo>();

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
		 return cadresInfoList;
	}
}