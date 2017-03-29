package com.dcs.service.excel;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class TitleService {
	private String title;
	private HSSFWorkbook workbook;
	private HSSFSheet sheet;
	private HSSFRow row;

	public String excel(FileInputStream in) throws IOException {
		workbook = new HSSFWorkbook(in);// 创建操作Excel的HSSFWorkbook对象
		sheet = workbook.getSheetAt(0);// 创建HSSFsheet对象。
		row = sheet.getRow(0);

		title = row.getCell(0).getStringCellValue();
		System.out.println(title);
		return title;
	}
}
