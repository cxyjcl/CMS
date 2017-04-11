package com.dcs.util;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;

import com.artofsolving.jodconverter.DocumentConverter;
import com.artofsolving.jodconverter.openoffice.connection.OpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.connection.SocketOpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.converter.OpenOfficeDocumentConverter;
import com.dcs.service.excel.mainTest;


public class JodUtils {
	public static void transform(InputStream input,String url) throws Exception{
		File file = new File(url+".doc");
		OutputStream os = new FileOutputStream(file);
		int bytesRead = 0;
		byte[] buffer = new byte[8192];
		while ((bytesRead = input.read(buffer, 0, 8192)) != -1) {
		   os.write(buffer, 0, bytesRead);
		}
		os.close();
		input.close();
		File inputFile = new File(url+".doc");
		File outputFile = new File(url+".pdf");
		// connect to an OpenOffice.org instance running on port 8100 
		OpenOfficeConnection connection = new SocketOpenOfficeConnection("127.0.0.1",8100);
		connection.connect();
		// convert 
		DocumentConverter converter = new OpenOfficeDocumentConverter(connection);
		converter.convert(inputFile, outputFile);
		// close the connection 
		connection.disconnect();
	}

}