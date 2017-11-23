package com.mwm.commons.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileUtil {
	static Logger log = LoggerFactory.getLogger(FileUtil.class);

	/**
	 * 删除
	 * 
	 * @param phyFilePath
	 */
	public static void delete(String phyFilePath) {
		File file = new File(phyFilePath);
		if (file.exists()) {
			file.delete();
		}
	}

	/**
	 * 生成目录
	 * @param dirPath
	 */
	public static void mkdirs(String dirPath) {
		File file = new File(dirPath);
		if (!file.exists()) {
			boolean mkdirsOk = file.mkdirs();
			log.error("mkdirs error:{}", dirPath);
		}
	}

	/**
	 * 文件是否存在
	 * 
	 * @param path
	 * @return
	 */
	public static boolean exists(String path) {
		return (new File(path)).exists();
	}

	public static String fileReaderStringHandle(String fileName) {
		return fileReaderStringHandle(fileName, "utf-8");
	}

	public static String fileReaderStringHandle(String fileName, String charset) {
		StringBuilder sb = new StringBuilder();
		BufferedReader in = null;
		try {

			InputStreamReader read = new InputStreamReader(new FileInputStream(fileName), charset);
			in = new BufferedReader(read);
			String line;
			while ((line = in.readLine()) != null) {
				sb.append(line);
				sb.append("\n");
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (Exception ee) {
				}
			}
		}
		return sb.toString();
	}

	/**
	 * 
	 * 
	 * @param fileName
	 * @return byte[]
	 */
	public static byte[] fileReaderByteHandle(String fileName) {
		byte[] data = null;
		try {
			BufferedInputStream bf = new BufferedInputStream(new FileInputStream(fileName));
			try {
				data = new byte[bf.available()];
				bf.read(data);

			} finally {
				bf.close();
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return data == null ? new byte[] {} : data;
	}

	/**
	 *
	 * 
	 * @param fileName
	 * @param text
	 */
	public static void fileWriterHandle(String fileName, String text) {
		try {
			FileOutputStream fos = new FileOutputStream(fileName);
			Writer out = new OutputStreamWriter(fos, "UTF-8");
			try {
				out.write(text);
			} finally {
				out.close();
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static String makeTimePath(boolean date) {
		Calendar cal = Calendar.getInstance();
		return cal.get(Calendar.YEAR) + File.separator + (cal.get(Calendar.MONTH) + 1) + File.separator
				+ (date ? (cal.get(Calendar.DAY_OF_MONTH) + File.separator) : "");
	}

	public static String makeTimePath(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return File.separator + cal.get(Calendar.YEAR) + File.separator + (cal.get(Calendar.MONTH) + 1) + File.separator
				+ cal.get(Calendar.DAY_OF_MONTH) + File.separator;
	}

}
