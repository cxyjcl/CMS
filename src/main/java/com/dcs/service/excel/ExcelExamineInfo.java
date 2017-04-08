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
import java.util.HashMap;
import java.util.LinkedList;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.util.CellRangeAddress;
import org.junit.Test;

import com.dcs.pojo.ExamineInfo;
import com.dcs.util.TableUtils;

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
	public LinkedList<HashMap<String, Object>> upload(InputStream in) throws Exception {

		LinkedList<HashMap<String, Object>> list = new LinkedList<HashMap<String, Object>>();

		workbook = new HSSFWorkbook(in);// 创建操作Excel的HSSFWorkbook对象
		sheet = workbook.getSheetAt(0);// 创建HSSFsheet对象。

		row = sheet.getRow(rowIndex);
		/* 配合表格中的格式，从第rowIndex行开始读取 */
		// 用HSSFCell对象的getCell()方法取出每一个的值 sheet.getLastRowNum()
		while (row != null && isDigit(row.getCell(1))) {
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
			examineInfo.setEvaluationExamine(cell[3].getNumericCellValue());
			examineInfo.setTotalExamine(cell[4].getNumericCellValue());
			HashMap<String, Object> map = (HashMap<String, Object>) BeanUtils
			.describe(examineInfo);
			map.remove("class");
			map = TableUtils.upToLow(map);
			list.add(map);
			rowIndex++;
			row = sheet.getRow(rowIndex);
		}
		HashMap<String, Object> map = new HashMap();
		String title = TitleService.excel(workbook);
		map.put("title", title);
		list.add(map);
		return list;
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
				return true;
			else
				return false;
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return false;
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

	public OutputStream download(ArrayList<ExamineInfo> examineInfoList) throws FileNotFoundException, IOException {
		// 选择文件
		file = new File("tempExcel/学工办/年度辅导员、班主任测评汇总表.xls");
		workbook = new HSSFWorkbook(new FileInputStream(file));// 创建操作Excel的HSSFWorkbook对象
		sheet = workbook.getSheetAt(0);

		int size = examineInfoList.size();
		for (int i = 0; i < size; i++) {// 循环，控制总行数
			HSSFRow row = sheet.createRow(i + rowIndex);
			ExamineInfo examineInfo = examineInfoList.get(i);
			HSSFCell cell = row.createCell(0);
			cell.setCellValue(examineInfo.getCounselor());
			cell = row.createCell(1);
			cell.setCellValue(examineInfo.getDailyExamine());
			cell = row.createCell(2);
			cell.setCellValue(examineInfo.getStudentExamine());
			cell = row.createCell(3);
			cell.setCellValue(examineInfo.getEvaluationExamine());
			cell = row.createCell(4);
			cell.setCellValue(examineInfo.getTotalExamine());

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
