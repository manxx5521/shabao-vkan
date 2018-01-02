package com.xiaoshabao.vkan.util;

import java.io.IOException;

public class CmdUtil {

	/**
	 * 打开文件
	 * <p>可以是文件夹、文件等</p>
	 * @param path 完整目录
	 * @throws IOException
	 */
	public static void openFile(String path) throws IOException {
		Runtime.getRuntime().exec(new String[] { "cmd.exe", "/c","start", path});
	}
	
	/**
	 * 打开文件所在文件目录，并选中文件
	 * <p>可以是文件夹、文件等。</p>
	 * @param path 完整目录
	 * @throws IOException
	 */
	public static void openFileDir(String path) throws IOException {
		Runtime.getRuntime().exec("explorer /select, " + path.replace(" ", "\" \""));
	}
}
