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
	public ArrayList<PartyBuild> upload(InputStream in) throws IOException {

		ArrayList<PartyBuild> partyBuildList = new ArrayList<PartyBuild>();


		workbook = new HSSFWorkbook(in);// 创建操作Excel的HSSFWorkbook对象
		sheet = workbook.getSheetAt(0);// 创建HSSFsheet对象。

		row = sheet.getRow(rowIndex);
		/* 配合表格中的格式，从第rowIndex行开始读取 */
		// 用HSSFCell对象的getCell()方法取出每一个的值 sheet.getLastRowNum()
		while (row != null && row.getCell(2).getStringCellValue() != "") {
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
			partyBuild.setProbationaryPartyMemberDate(cell[7].getStringCellValue());
			partyBuild.setRegularPartyMemberDate(cell[8].getStringCellValue());
			partyBuild.setNation(cell[9].getStringCellValue());
			row.getCell(10).setCellType(Cell.CELL_TYPE_STRING);
			partyBuild.setIdCard(cell[10].getStringCellValue());
			row.getCell(11).setCellType(Cell.CELL_TYPE_STRING);
			partyBuild.setNumParty(cell[11].getStringCellValue());
			partyBuildList.add(partyBuild);
			rowIndex++;
			row = sheet.getRow(rowIndex);
		}
		System.out.println("PartyBuild中数据导入完毕.");
		System.out.println(partyBuildList);
		return partyBuildList;
	}

	public OutputStream download(ArrayList<PartyBuild> partyBuildList) throws FileNotFoundException, IOException {
		// 选择文件
		file = new File("tempExcel/年级本学期党建学生名单.xls");
		workbook = new HSSFWorkbook(new FileInputStream(file));// 创建操作Excel的HSSFWorkbook对象
		sheet = workbook.getSheetAt(0);

		int size = partyBuildList.size();
		for (int i = 0; i < size; i++) {// 循环，控制总行数
			HSSFRow row = sheet.createRow(i + rowIndex);
			PartyBuild partyBuild = partyBuildList.get(i);
			HSSFCell cell = row.createCell(1);
			cell.setCellValue(partyBuild.getStudentId());
			cell = row.createCell(2);
			cell.setCellValue(partyBuild.getName());
			cell = row.createCell(3);
			cell.setCellValue(partyBuild.getClassroom());
			cell = row.createCell(4);
			cell.setCellValue(partyBuild.getSex());
			cell = row.createCell(5);
			cell.setCellValue(partyBuild.getPartyBranch());
			cell = row.createCell(6);
			cell.setCellValue(partyBuild.getBirthday());
			cell = row.createCell(7);
			cell.setCellValue(partyBuild.getProbationaryPartyMemberDate());
			cell = row.createCell(8);
			cell.setCellValue(partyBuild.getRegularPartyMemberDate());
			cell = row.createCell(9);
			cell.setCellValue(partyBuild.getNation());
			cell = row.createCell(10);
			cell.setCellValue(partyBuild.getIdCard());
			cell = row.createCell(11);
			cell.setCellValue(partyBuild.getNumParty());
			cell = row.createCell(0);
			cell.setCellValue(partyBuild.getPartyNature());

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
