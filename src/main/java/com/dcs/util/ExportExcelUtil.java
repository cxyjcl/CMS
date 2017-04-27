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

import com.Test;

public class ExportExcelUtil {

	public static HSSFWorkbook writeExcelFileAccordingParamInfos(
			HSSFWorkbook workbook, List<AttriInfo> paramInfos,
			List<LinkedHashMap> data2Export, Class<?> clazz, String title) throws Exception {
    	String url =ExportExcelUtil.class.getResource("/").toURI().getPath().replace("classes/","excel/个人成果及获奖情况.xls");
        InputStream input = new FileInputStream(url); 
         
        //根据上述创建的输入流 创建工作簿对象 
        workbook = new HSSFWorkbook(input); 
        //得到第一页 sheet 
        //页Sheet是从0开始索引的 
        Sheet sheet = workbook.getSheetAt(0); 
        System.out.println(sheet.getLastRowNum());
        for (Row row : sheet) { 
            //遍历row中的所有方格 
            for (Cell cell : row) { 
                //输出方格中的内容，以空格间隔 
                System.out.print(cell.toString() + "  "); 
            } 
            //每一个行输出之后换行 
            System.out.println(); 
        } 
//		Row row = sheet.getRow(0);
//		Cell cell = row.getCell(0);
//		cell.setCellValue(title);
//		CellRangeAddress cellRangeAddress = new CellRangeAddress(0, 0, 0,
//				paramInfos.size() - 1);

//		sheet.addMergedRegion(cellRangeAddress);// 合并单元格

//		Row row2 = sheet.getRow(1);
		// 写标题栏
		int j = 0;
//		for (AttriInfo attriInfo : paramInfos) {
//			String excelColumName = attriInfo.getExcelColumName();
//			// 写标题栏
//			Cell cell2 = row2.getCell(j);
//			cell2.setCellValue(excelColumName);
//			j++;
//
//		}
		int i = 2;
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
//
//		//自动调整列宽
//		for (j = 0; j < paramInfos.size(); j++) {
//			sheet.autoSizeColumn(j);
//		}
//		HSSFCellStyle cellStyle = workbook.createCellStyle();
//		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 水平布局：居中
		return workbook;
	}
}
