package com.test.component;

import java.io.File;
import java.util.Arrays;
import java.util.Properties;

import net.bytebuddy.asm.Advice.This;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.unitils.core.UnitilsException;
import org.unitils.dbunit.datasetfactory.DataSetFactory;
import org.unitils.dbunit.util.MultiSchemaDataSet;

/**
 * ClassName: MultiSchemaXlsDataSetFactory
 * 
 * @author zongzi
 * @date 2017年2月4日 下午2:17:45
 */
public class MultiSchemaXlsDataSetFactory implements DataSetFactory {

	private static final Log logger = LogFactory.getLog(This.class);
	protected String dafaultSchemaName;

	// 初始化数据集工厂
	public void init(Properties configuration, String defaultSchemaName) {
		this.dafaultSchemaName = defaultSchemaName;
	}

	// 从excel文件中创建数据集
	@Override
	public MultiSchemaDataSet createDataSet(File... dataSetFiles) {
		try {
			logger.info("创建数据集<开始>:" + Arrays.toString(dataSetFiles));
			MultiSchemaXlsDataSetReader xlsDataSetReader = new MultiSchemaXlsDataSetReader(
					dafaultSchemaName);
			return xlsDataSetReader.readDataSetXls(dataSetFiles);
		} catch (Exception e) {
			throw new UnitilsException("创建数据集失败:"
					+ Arrays.toString(dataSetFiles), e);
		}
	}

	// 获取数据集文件的扩展名
	@Override
	public String getDataSetFileExtension() {
		return "xls";
	}
}
