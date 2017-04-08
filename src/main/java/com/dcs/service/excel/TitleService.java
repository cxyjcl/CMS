package com.dcs.service.excel;

import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class TitleService {

	public static String excel(HSSFWorkbook workbook) throws IOException {
		HSSFSheet sheet = workbook.getSheetAt(0);// 创建HSSFsheet对象。
		HSSFRow row = sheet.getRow(0);
		String title = row.getCell(0).getStringCellValue();
		return title;
	}
}
