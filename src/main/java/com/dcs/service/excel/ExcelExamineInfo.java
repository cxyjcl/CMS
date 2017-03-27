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
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.util.CellRangeAddress;
import org.junit.Test;

import com.dcs.pojo.ExamineInfo;

public class ExcelExamineInfo {
	private int rowIndex = 4; // The row index start from 5 row.
	private final int column = 5; // All column is 5.

	private HSSFWorkbook workbook;
	private HSSFSheet sheet;
	private HSSFRow row;
	private HSSFCell[] cell = new HSSFCell[column];
	private File file;

	/**
	 * 年度辅导员、班主任测评汇总表
	 * 
	 * @param file
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws IOException
	 */
	@Test
	public void examineInfoServers() throws IOException {

		ArrayList<ExamineInfo> examineInfoList = new ArrayList<ExamineInfo>();

		// 1.导入excel文件
		file = new File("excel/学工办/年度辅导员、班主任测评汇总表.xls");

		if (!file.exists())
			System.out.println("The file is not exist!");
		InputStream in = new FileInputStream(file);

		workbook = new HSSFWorkbook(in);// 创建操作Excel的HSSFWorkbook对象
		sheet = workbook.getSheetAt(0);// 创建HSSFsheet对象。

		/* 配合表格中的格式，从第rowIndex行开始读取 */
		// 用HSSFCell对象的getCell()方法取出每一个的值 sheet.getLastRowNum()
		for (; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
			row = sheet.getRow(rowIndex);
			if (isDigit(row.getCell(1)))
				continue;
			for (int i = 0; i < column; i++) {
				if (row.getCell(i) != null)
					cell[i] = row.getCell(i);
				else
					cell[i] = null;
			}

			ExamineInfo examineInfo = new ExamineInfo();
			examineInfo.setCounselor(cell[0].getStringCellValue());
			examineInfo.setDailyExamine(cell[1].getNumericCellValue());
			examineInfo.setStudentExamine(cell[2].getNumericCellValue());
			examineInfo.setTotalExamine(cell[3].getNumericCellValue());
			examineInfoList.add(examineInfo);

		}
		System.out.println("ExamineInfo中数据导入完毕.");
		System.out.println(examineInfoList);
		// return examineInfoList;
	}

	/**
	 * 判断是否为数字
	 * 
	 * @param value
	 * @return
	 */
	public boolean isDigit(HSSFCell value) {
		try {
			// Integer.parseInt(null, value.CELL_TYPE_NUMERIC);
			value.setCellType(Cell.CELL_TYPE_NUMERIC);
			if (value.getNumericCellValue() > 0)
				return false;
			else
				return true;
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return true;
		}
	}

	/**
	 * 判断是否合并了单元格
	 * 
	 * @param cell
	 * @return
	 */
	public boolean isCombineCell(HSSFCell cell) {
		CellRangeAddress ca = new CellRangeAddress(cell.getRowIndex(), cell.getRowIndex(), 0, cell.getColumnIndex());
		int firstC = 0;
		int lastC = 0;
		// CellRangeAddress ca = cell.getArrayFormulaRange();
		for (int i = 0; i < 2; i++) {
			firstC = ca.getFirstColumn();
			lastC = ca.getLastColumn();
			if (cell.getColumnIndex() <= lastC && cell.getColumnIndex() >= firstC)
				return true;
		}

		return false;
	}
}
