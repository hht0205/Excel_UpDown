package com.it.action;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.down.WYCP;
import com.it.dto.UploadFileDto;
import com.it.service.TicketService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 票号
 * @author hht
 * @date 2018年7月6日
 */
public class TicketAction extends ActionSupport
{
	private final Log logger = LogFactory.getLog(this.getClass());
	
	private Map<String,Object> responseJson;//返回页面json
	
	private File file;//上传文件
	private String fileFileName;//文件名称
	private String fileContentType;//文件类型
	
	private TicketService ticketService;

	public Map<String, ?> getResponseJson()
	{
		return responseJson;
	}

	public void setResponseJson(Map<String, Object> responseJson)
	{
		this.responseJson = responseJson;
	}

	public File getFile()
	{
		return file;
	}

	public void setFile(File file)
	{
		this.file = file;
	}

	public String getFileFileName()
	{
		return fileFileName;
	}

	public void setFileFileName(String fileFileName)
	{
		this.fileFileName = fileFileName;
	}

	public String getFileContentType()
	{
		return fileContentType;
	}

	public void setFileContentType(String fileContentType)
	{
		this.fileContentType = fileContentType;
	}

	public TicketService getTicketService()
	{
		return ticketService;
	}

	public void setTicketService(TicketService ticketService)
	{
		this.ticketService = ticketService;
	}
	
	/**
	 * 文件上传处理
	 * @return
	 */
	public String uploadFile()
	{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("success", true);
		UploadFileDto uploadFile = new UploadFileDto();
		uploadFile.setFile(file);
		uploadFile.setFileName(fileFileName);
		uploadFile.setContentType(fileContentType);
		try
		{
			if(null!=file)
			{
				ticketService.uploadTicketListFile(uploadFile);
				map.put("uploadFileMessage", "文件上传成功");
				new WYCP().select();
				map.put("uploadFileMessage", "样票抽查文件生成成功");
			}	
			else
				map.put("uploadFileMessage", "上传文件为空！");
		}catch(Exception e)
		{
			handleException(e,map);
		}
		this.setResponseJson(map);
		return Action.SUCCESS;
	}
	
	/**
	 * 处理异常
	 * @param e 异常
	 * @param map Action返回值
	 */
	private void handleException(Exception e, Map<String, Object> map) {
        map.put("success", false);
        String errorMsg = e.getMessage();
        if (errorMsg != null) {        	
        	errorMsg = errorMsg.replace("\n", "<br>");
        }
        
        map.put("errorMsg", e.getMessage());//返回错误信息  TODO 消息需要处理下，不能直接把异常返回给用户看
        logger.error("error", e);
	}
}


