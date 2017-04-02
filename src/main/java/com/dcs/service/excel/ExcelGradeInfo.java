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
import org.junit.Test;

import com.dcs.pojo.GradeInfo;

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
	public ArrayList<GradeInfo> upload() throws IOException {

		ArrayList<GradeInfo> gradeInfoList = new ArrayList<GradeInfo>();

		// 1.导入excel文件
		file = new File("excel/年级信息一览表.xls");

		if (!file.exists())
			System.out.println("The file is not exist!");
		InputStream in = new FileInputStream(file);

		workbook = new HSSFWorkbook(in);// 创建操作Excel的HSSFWorkbook对象
		sheet = workbook.getSheetAt(0);// 创建HSSFsheet对象。

		row = sheet.getRow(rowIndex);
		/* 配合表格中的格式，从第rowIndex行开始读取 */
		// 用HSSFCell对象的getCell()方法取出每一个的值 sheet.getLastRowNum()
		while (row != null && row.getCell(0).getStringCellValue() != "") {
			for (int i = 0; i < column; i++) {
				if (row.getCell(i) != null)
					cell[i] = row.getCell(i);
				else
					cell[i] = null;
			}

			GradeInfo gradeInfo = new GradeInfo();
			gradeInfo.setPeople((int) cell[1].getNumericCellValue());
			gradeInfo.setMale((int) cell[2].getNumericCellValue());
			gradeInfo.setFemale((int) cell[3].getNumericCellValue());
			gradeInfo.setPartyMember((int) cell[4].getNumericCellValue());
			gradeInfo.setActivist((int) cell[5].getNumericCellValue());
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
			gradeInfoList.add(gradeInfo);
			rowIndex++;
			row = sheet.getRow(rowIndex);
		}

		System.out.println("GradeInfo中数据导入完毕.");
		System.out.println(gradeInfoList);
		return gradeInfoList;
	}

	public OutputStream download(ArrayList<GradeInfo> gradeInfoList) throws FileNotFoundException, IOException {
		// 选择文件
		file = new File("tempExcel/年级信息一览表.xls");
		workbook = new HSSFWorkbook(new FileInputStream(file));// 创建操作Excel的HSSFWorkbook对象
		sheet = workbook.getSheetAt(0);

		int size = gradeInfoList.size();
		for (int i = 0; i < size; i++) {// 循环，控制总行数
			HSSFRow row = sheet.createRow(i + rowIndex);
			GradeInfo gradeInfo = gradeInfoList.get(i);
			HSSFCell cell = row.createCell(0);
			cell.setCellValue(gradeInfo.getClassroom());
			cell = row.createCell(1);
			cell.setCellValue(gradeInfo.getPeople());
			cell = row.createCell(2);
			cell.setCellValue(gradeInfo.getMale());
			cell = row.createCell(3);
			cell.setCellValue(gradeInfo.getFemale());
			cell = row.createCell(4);
			cell.setCellValue(gradeInfo.getPartyMember());
			cell = row.createCell(5);
			cell.setCellValue(gradeInfo.getActivist());
			cell = row.createCell(6);
			cell.setCellValue(gradeInfo.getTeacher());
			cell = row.createCell(7);
			cell.setCellValue(gradeInfo.getMonitor());
			cell = row.createCell(8);
			cell.setCellValue(gradeInfo.getLeagueSecretary());
			cell = row.createCell(9);
			cell.setCellValue(gradeInfo.getStudiesCommissary());
			cell = row.createCell(10);
			cell.setCellValue(gradeInfo.getSportsCommissary());
			cell = row.createCell(11);
			cell.setCellValue(gradeInfo.getAffairCommissary());
			cell = row.createCell(12);
			cell.setCellValue(gradeInfo.getOrganizationCommissary());
			cell = row.createCell(13);
			cell.setCellValue(gradeInfo.getPublicityCommissary());
			cell = row.createCell(14);
			cell.setCellValue(gradeInfo.getPsychologicalCommissary());
			cell = row.createCell(15);
			cell.setCellValue(gradeInfo.getRemark());

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
