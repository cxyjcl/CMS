package com.dcs.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellRangeAddress;


public class ExportExcelUtil {

	public static HSSFWorkbook writeExcelFileAccordingParamInfos(
			HSSFWorkbook workbook, List<AttriInfo> paramInfos,
			List<LinkedHashMap> data2Export, Class<?> clazz, String title ,String fileName) throws Exception {
		String url =ExportExcelUtil.class.getResource("/").toURI().getPath().replace("classes/","excel/"+fileName);
        InputStream input = new FileInputStream(url); 
         
        //根据上述创建的输入流 创建工作簿对象 
        workbook = new HSSFWorkbook(input); 
        //得到第一页 sheet 
        //页Sheet是从0开始索引的 
        Sheet sheet = workbook.getSheetAt(0); 
		// 写标题栏
		int j = 0;
		int i = 3;
		// 写表格内容
		for (LinkedHashMap map : data2Export) {
			Row row = sheet.createRow(i);
			// 写标题栏
			j = 0;
			for (AttriInfo attriInfo : paramInfos) {
				Cell cell = row.createCell(j);
				String paramName = attriInfo.getParamName();
				String underlineToCamel = WTStringUtils
						.camelToUnderline(paramName);
				Object value = map.get(underlineToCamel);
				if(value!=null)
					cell.setCellValue(map.get(underlineToCamel).toString());
				j++;
			}
			i++;
		}
		return workbook;
	}
}
