package com.it.dto;

import java.io.File;
import java.io.Serializable;

/**
 * 文件上传
 * @author hht
 * @date 2017年9月10日
 */
public class UploadFileDto implements Serializable
{
	/**
	 * 文件
	 */
	private File file;
	
	/**
	 * 文件名称
	 */
	private String fileName;
	
	/**
	 * 文件类型
	 */
	private String ContentType;

	public File getFile()
	{
		return file;
	}

	public void setFile(File file)
	{
		this.file = file;
	}

	public String getFileName()
	{
		return fileName;
	}

	public void setFileName(String fileName)
	{
		this.fileName = fileName;
	}

	public String getContentType()
	{
		return ContentType;
	}

	public void setContentType(String contentType)
	{
		ContentType = contentType;
	}
}
