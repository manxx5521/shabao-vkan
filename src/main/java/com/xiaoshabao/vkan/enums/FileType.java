package com.xiaoshabao.vkan.enums;

import org.apache.commons.io.FilenameUtils;

/**
 * 文件类型
 */
public enum FileType {
	/** 文件夹 */
	DIRECTORY(1),
	/** 图片 */
	IMAGE(2),
	/** 视频 */
	VIDEO(3),
	/** 文本 */
	TXT(4),
	/** 压缩包 */
	ZIP(5),
	/** 压缩包 */
	UNKNOWN(9);

	/** 代码 */
	private int code;

	private final static String[] IMAGE_ARRAY = { "jpg", "png", "bmp", "gif" };
	private final static String[] VIDEO_ARRAY = { "avi", "rmvb", "rm", "mpg", "mpeg", "3gp", "mov", "mp4", "mkv", "flv",
			"fl4", };
	private final static String[] TXT_ARRAY = { "txt" };
	private final static String[] ZIP_ARRAY = { "zip", "rar" };

	/**
	 * 根据文件名字获得 代码值
	 * 
	 * @param fileName
	 * @return
	 */
	public static int getCodeByName(String fileName) {
		String ext = FilenameUtils.getExtension(fileName);
		int code = UNKNOWN.getCode();
		if (FileType.hasElement(IMAGE_ARRAY, ext)) {
			code = IMAGE.getCode();
		} else if (FileType.hasElement(VIDEO_ARRAY, ext)) {
			code = VIDEO.getCode();
		} else if (FileType.hasElement(TXT_ARRAY, ext)) {
			code = TXT.getCode();
		} else if (FileType.hasElement(ZIP_ARRAY, ext)) {
			code = ZIP.getCode();
		}
		return code;
	}

	private static boolean hasElement(String[] array, String tag) {
		if (array == null || tag == null) {
			return false;
		}
		for (String element : array) {
			if (tag.equalsIgnoreCase(element)) {
				return true;
			}
		}
		return false;
	}

	private FileType(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}
}
