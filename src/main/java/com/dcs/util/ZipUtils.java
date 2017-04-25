package com.dcs.util;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipOutputStream;

public class ZipUtils {	
	
	private static ZipOutputStream zipStream;
	
	public static void zip(List<LinkedHashMap> mapList,InputStream excel, OutputStream dest) throws IOException {
		zipStream = new ZipOutputStream(dest);
		create(excel,"excel.xls");
	    for (LinkedHashMap map : mapList){
	    	String url= (String) map.get("url");
	    	String id = map.get("id").toString();
	    	InputStream in = new FileInputStream(new File(url));
	    	String type= url.split("\\.")[1];
	    	create(in,id+"."+type);
	    }
	    IOUtils.closeQuietly(zipStream);
	}
	
	private static void create(InputStream in,String name) throws IOException{
		zipStream.putNextEntry(new ZipEntry(name));
        int temp =0;
		while((temp=in.read())!=-1){ // 读取内容  
        	zipStream.write(temp) ;    // 压缩输出  
        }  
	    IOUtils.closeQuietly(in);
	}
}
