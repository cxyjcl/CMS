package com.dcs.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.bytebuddy.asm.Advice.This;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.ConvertUtilsBean;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dbunit.dataset.Column;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.excel.XlsDataSet;

/**
 * 从EXCEL数据集文件创建Bean
 */
public class XlsDataSetBeanFactory {

	private static final Log logger = LogFactory.getLog(This.class);

	public final static String excelFilePath = "../../../java/resources/excel/";

	public static <T> List<T> createBeans(String file, InputStream in,
			Class<T> clazz) throws Exception {
		BeanUtilsBean beanUtils = createBeanUtils();
		file = excelFilePath + file;
		logger.info("根据xls创建对象 <开始>加载文件:{" + file + "} " + " class:"
				+ clazz.getName());
		List<Map<String, Object>> propsList = createProps(file, in);
		logger.info("根据xls创建对象 <结束>加载文件:{" + file + "}" + " class:"
				+ clazz.getName());
		List<T> beans = new ArrayList<T>();
		for (Map<String, Object> props : propsList) {
			T bean = clazz.newInstance();
			beanUtils.populate(bean, props);
			beans.add(bean);
		}
		return beans;
	}

	private static List<Map<String, Object>> createProps(String file,
			InputStream in) {
		return new ExeclUtil().read(file, in, true);
	}

	private static BeanUtilsBean createBeanUtils() {
		ConvertUtilsBean convertUtilsBean = createConverUtils();
		return new BeanUtilsBean(convertUtilsBean);
	}

	private static ConvertUtilsBean createConverUtils() {
		DateConverter dateConverter = new DateConverter();
		dateConverter.setPattern("yyyy-MM-dd");
		ConvertUtilsBean convertUtilsBean = new ConvertUtilsBean();
		convertUtilsBean.register(dateConverter, java.util.Date.class);
		convertUtilsBean.register(dateConverter, Timestamp.class);
		convertUtilsBean.register(dateConverter, java.sql.Date.class);
		return convertUtilsBean;
	}

	private static String underlineToCamel(String str) {
		String pattern[] = str.split("_");
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < pattern.length; i++) {
			if (i == 0) {
				builder.append(pattern[i]);
			} else {
				builder.append(pattern[i].substring(0, 1).toUpperCase());
				builder.append(pattern[i].substring(1));
			}
		}
		return builder.toString();
	}

	public static void main(String[] args) {
		try {
//			createProps("../exceldataset/wtlib.SaveUser.xls", "t_user", 1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}