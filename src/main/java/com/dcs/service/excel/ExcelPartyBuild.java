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
import org.junit.Test;

import com.dcs.pojo.PartyBuild;

public class ExcelPartyBuild {
	private int rowIndex = 2; // The row index start from 3 row.
	private final int column = 12; // All column is 12.

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
	public void partyBuildServers() throws IOException {

		ArrayList<PartyBuild> partyBuildList = new ArrayList<PartyBuild>();

		// 1.导入excel文件
		file = new File("excel/年级本学期党建学生名单.xls");

		if (!file.exists())
			System.out.println("The file is not exist!");
		InputStream in = new FileInputStream(file);

		workbook = new HSSFWorkbook(in);// 创建操作Excel的HSSFWorkbook对象
		sheet = workbook.getSheetAt(0);// 创建HSSFsheet对象。

		/* 配合表格中的格式，从第rowIndex行开始读取 */
		// 用HSSFCell对象的getCell()方法取出每一个的值 sheet.getLastRowNum()
		for (; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
			row = sheet.getRow(rowIndex);
			if (row.getCell(2).getStringCellValue() == "" || row.getCell(2).getStringCellValue() == null)
				continue;
			for (int i = 0; i < column; i++) {
				if (row.getCell(i) != null)
					cell[i] = row.getCell(i);
				else
					cell[i] = null;
			}

			PartyBuild partyBuild = new PartyBuild();
			// partyBuild.setNameChairman(cell[0].getNumericCellValue());
			partyBuild.setStudentId((int) cell[1].getNumericCellValue());
			partyBuild.setName(cell[2].getStringCellValue());
			partyBuild.setClassroom(cell[3].getStringCellValue());
			partyBuild.setSex(cell[4].getStringCellValue());
			partyBuild.setPartyBranch(cell[5].getStringCellValue());
			partyBuild.setBirthday(cell[6].getStringCellValue());
			partyBuild.setProbationaryPartyMemberDate(cell[7].getDateCellValue());
			partyBuild.setRegularPartyMemberDate(cell[8].getDateCellValue());
			partyBuild.setNation(cell[9].getStringCellValue());
			row.getCell(10).setCellType(Cell.CELL_TYPE_STRING);
			partyBuild.setIdCard(cell[10].getStringCellValue());
			row.getCell(11).setCellType(Cell.CELL_TYPE_STRING);
			partyBuild.setNumParty(cell[11].getStringCellValue());
			partyBuildList.add(partyBuild);

		}
		System.out.println("PartyBuild中数据导入完毕.");
		System.out.println(partyBuildList);
		// return partyBuildList;
	}
}
