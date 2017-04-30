package com.dcs.service.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
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

import com.dcs.pojo.ProbationaryMember;
import com.dcs.pojo.RegularMember;
import com.dcs.util.TableUtils;

public class ExcelApplicationMember {
	private int rowIndex = 3; // The row index start from 3 row.
	private final int column = 12; // All column is 11.

	private HSSFWorkbook workbook;
	private HSSFSheet sheet;
	private HSSFRow row;
	private HSSFCell[] cell = new HSSFCell[column];
	private File file;

	/**
	 * 年级本学期党建学生名单
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
		row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
		while (row != null && row.getCell(0).getStringCellValue() != "") {
			for (int i = 0; i < column; i++) {
				if (row.getCell(i) != null){
					row.getCell(i).setCellType(Cell.CELL_TYPE_STRING);
					cell[i] = row.getCell(i);					
				}
				else
					cell[i] = null;
			}
			RegularMember regularMember = new RegularMember();
			regularMember.setCode(cell[0].getStringCellValue());
			regularMember.setPartyName(cell[1].getStringCellValue());
			regularMember.setName(cell[2].getStringCellValue());
			regularMember.setSex(cell[3].getStringCellValue());
			regularMember.setNation(cell[4].getStringCellValue());
			regularMember.setBirthday(cell[5].getStringCellValue());
			regularMember.setIdCard(cell[6].getStringCellValue());
			regularMember.setClassroom(cell[7].getStringCellValue());
			regularMember.setProfession(cell[8].getStringCellValue());
			regularMember.setStudentLevel(cell[9].getStringCellValue());
			regularMember.setProbationaryMemberDate(cell[10].getStringCellValue());
			regularMember.setRegularPartyMemberDate(cell[11].getStringCellValue());
			HashMap<String, Object> map = (HashMap<String, Object>) BeanUtils
			.describe(regularMember);
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
