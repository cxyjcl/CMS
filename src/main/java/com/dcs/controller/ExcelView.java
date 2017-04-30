package com.dcs.controller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.dcs.util.AttriInfo;
import com.dcs.util.AttributeBuildExcel;
import com.dcs.util.AttributeBuildExcelUtils;
import com.dcs.util.ExportExcelUtil;
import com.dcs.util.ZipUtils;

public class ExcelView extends AbstractExcelView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model,
			HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		Class<?> pojoClass = (Class<?>) model.get("pojoClass");
		List<LinkedHashMap> data2Export = (List<LinkedHashMap>) model
				.get("data2Export");
		String fileName = (String) model.get("fileName");
		String title = (String) model.get("title");
		Field[] params = pojoClass.getDeclaredFields();
		List<AttriInfo> paramsAttriInfo = AttributeBuildExcelUtils
				.parseParamsAttriInfo(params);
		workbook = ExportExcelUtil.writeExcelFileAccordingParamInfos(workbook,
				paramsAttriInfo, data2Export, pojoClass,title,fileName);

		// web浏览通过MIME类型判断文件是excel类型
		response.setCharacterEncoding("utf-8");

		// 对文件名进行处理。防止文件名乱码
		fileName = URLEncoder.encode(fileName, "utf-8");
		// Content-disposition属性设置成以附件方式进行下载
		OutputStream os = response.getOutputStream();
		String code = (String) model.get("code");
		if(code.equals("20003") || code.equals("10009") || code.equals("10005")){
			response.setContentType("application/x-zip-compressed" );
			  //inline;参数让浏览器弹出下载窗口,而不是在网页中打开文件.filename设定文件名
			response.setHeader( "Content-Disposition" , "inline; filename=download.zip" );
			ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
			workbook.write(byteStream);
			byte[] b = byteStream.toByteArray();
			ByteArrayInputStream in = new ByteArrayInputStream(b);
			ZipUtils.zip(data2Export,in,os);
		} else{
			response.setContentType("application/vnd.ms-excel;charset=utf-8");
			response.setHeader("Content-disposition", "attachment;filename="
					+ fileName);
			workbook.write(os);
		}
		os.flush();
		os.close();
	}
}
