package com.dcs.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class InputToFile {
	public static void createFile(InputStream ins,File file) throws Exception{
		   OutputStream os = new FileOutputStream(file);
		   int bytesRead = 0;
		   byte[] buffer = new byte[8192];
		   while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
		      os.write(buffer, 0, bytesRead);
		   }
		   os.close();
		   ins.close();
	}
}
