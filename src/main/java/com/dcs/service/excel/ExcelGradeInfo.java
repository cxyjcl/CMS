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
import org.junit.Test;

import com.dcs.pojo.GradeInfo;
import com.dcs.util.TableUtils;

public class ExcelGradeInfo {
	private int rowIndex = 2; // The row index start from 3 row.
	private final int column = 16; // All column is 16.

	private HSSFWorkbook workbook;
	private HSSFSheet sheet;
	private HSSFRow row;
	private HSSFCell[] cell = new HSSFCell[column];
	private File file;

	/**
	 * 年级信息一览表
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
		while (row != null && row.getCell(0).getStringCellValue() != "") {
			for (int i = 0; i < column; i++) {
				if (row.getCell(i) != null){
					row.getCell(i).setCellType(Cell.CELL_TYPE_STRING);
					cell[i] = row.getCell(i);					
				}
				else
					cell[i] = null;
			}

			GradeInfo gradeInfo = new GradeInfo();
			gradeInfo.setClassroom(cell[0].getStringCellValue());
			gradeInfo.setPeople(Integer.parseInt(cell[1].getStringCellValue()));
			gradeInfo.setMale(Integer.parseInt(cell[2].getStringCellValue()));
			gradeInfo.setFemale(Integer.parseInt(cell[3].getStringCellValue()));
			gradeInfo.setPartyMember(Integer.parseInt(cell[4].getStringCellValue()));
			gradeInfo.setActivist(Integer.parseInt(cell[5].getStringCellValue()));
			gradeInfo.setTeacher(cell[6].getStringCellValue());
			gradeInfo.setMonitor(cell[7].getStringCellValue());
			gradeInfo.setLeagueSecretary(cell[8].getStringCellValue());
			gradeInfo.setStudiesCommissary(cell[9].getStringCellValue());
			gradeInfo.setSportsCommissary(cell[10].getStringCellValue());
			gradeInfo.setAffairCommissary(cell[11].getStringCellValue());
			gradeInfo.setOrganizationCommissary(cell[12].getStringCellValue());
			gradeInfo.setPublicityCommissary(cell[13].getStringCellValue());
			gradeInfo.setPsychologicalCommissary(cell[14].getStringCellValue());
			gradeInfo.setRemark(cell[15].getStringCellValue());
			HashMap<String, Object> map = (HashMap<String, Object>) BeanUtils
			.describe(gradeInfo);
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

}
