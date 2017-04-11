package com.dcs.util;

import java.util.LinkedHashMap;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;

public class ExportExcelUtil {

	public static HSSFWorkbook writeExcelFileAccordingParamInfos(
			HSSFWorkbook workbook, List<AttriInfo> paramInfos,
			List<LinkedHashMap> data2Export, Class<?> clazz, String title) {
		// create column's
		HSSFSheet sheetAt = workbook.createSheet();
		HSSFRow row = sheetAt.createRow(0);
		HSSFCell cell = row.createCell(0);
		cell.setCellValue(title);
		CellRangeAddress cellRangeAddress = new CellRangeAddress(0, 0, 0,
				paramInfos.size() - 1);

		sheetAt.addMergedRegion(cellRangeAddress);// 合并单元格

		HSSFRow row2 = sheetAt.createRow(1);
		// 写标题栏
		int j = 0;
		for (AttriInfo attriInfo : paramInfos) {
			String excelColumName = attriInfo.getExcelColumName();
			// 写标题栏
			HSSFCell cell2 = row2.createCell(j);
			cell2.setCellValue(excelColumName);
			j++;

		}
		j = 0;
		int i = 2;
		// 写表格内容
		for (LinkedHashMap map : data2Export) {
			HSSFRow row3 = sheetAt.createRow(i);
			// 写标题栏
			for (AttriInfo attriInfo : paramInfos) {
				HSSFCell cell2 = row3.createCell(j);
				String paramName = attriInfo.getParamName();
				String underlineToCamel = WTStringUtils
						.camelToUnderline(paramName);
				Object value = map.get(underlineToCamel);
				if(value!=null)
					cell2.setCellValue(map.get(underlineToCamel).toString());
				j++;
			}
			i++;
		}

		//自动调整列宽
		for (j = 0; j < paramInfos.size(); j++) {
			sheetAt.autoSizeColumn(j);
		}
		HSSFCellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 水平布局：居中
		return workbook;
	}
}
