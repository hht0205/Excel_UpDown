package com.it.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.it.dao.TicketDao;
import com.it.dto.TicketDto;
import com.it.dto.UploadFileDto;
import com.it.model.TicketEntity;
import com.it.service.TicketService;
import com.it.util.ExcelCommon;
import com.it.util.ExcelTicket;

/**
 * 票号
 * @author hht
 * @date 2017年9月10日
 */
public class TicketServiceImpl implements TicketService
{
	private final Log logger = LogFactory.getLog(this.getClass());
	
	private TicketDao ticketDao;
	
	public TicketDao getTicketDao()
	{
		return ticketDao;
	}

	public void setTicketDao(TicketDao ticketDao)
	{
		this.ticketDao = ticketDao;
	}

	public void createOrUpdateTicket(TicketDto ticketDto,int count)
	{
		TicketEntity ticketEntity = new TicketEntity();
		try {
			PropertyUtils.copyProperties(ticketEntity, ticketDto);
		} catch (Exception e) {
			//TODO 暂未处理
		} 
		if (StringUtils.isBlank(ticketEntity.getId())) {
			//校验票是否已经存在
			if (StringUtils.isNotBlank(ticketEntity.getTicketNumber())) {
				TicketDto sd = getTicketByTicketNumber(ticketEntity.getTicketNumber());
				if (sd != null) {
					throw new RuntimeException(String.format("票号为[%s]的票已经存在！", sd.getTicketNumber()));
				}
			}
			ticketEntity.setId(String.format("%04d", count));
//			ticketEntity.setId(UUID.randomUUID().toString());
		}
		ticketDao.createOrUpdateTicket(ticketEntity);
	}
	
	public TicketDto getTicketByTicketNumber(String ticketNumber)
	{	
		TicketEntity ticketEntity = ticketDao.getTicketByTicketNumber(ticketNumber);
		if(null==ticketEntity)
			return null;
		TicketDto ticket = new TicketDto();
		try {
			PropertyUtils.copyProperties(ticket,ticketEntity);
		} catch (Exception e) {
			//TODO 暂未处理
		} 
		return ticket;
	}
	
	/**
	 * 上传文件到服务器
	 */
	public void uploadTicketListFile(UploadFileDto uploadFile)
	{
		File file = uploadFile.getFile();
		String fileName = uploadFile.getFileName();
		
		String path = ExcelCommon.LOCAL_UPLOAD_DIRECTORY_PATH;
		File filePath=new File(path);
		filePath.mkdirs();
		File localFile = new File(path,fileName);
		
		try
		{
			InputStream is=new FileInputStream(file);
			OutputStream os=new FileOutputStream(localFile);
			
			byte[] buffer=new byte[2048];
			int length=0;
			while(-1 != (length=is.read(buffer)))
			{
				os.write(buffer,0,length);
			}
			
			is.close();
			os.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		logger.info("文件："+localFile.getAbsolutePath()+" 已经上传至服务器！");
		saveStudents(localFile);
	}
	
	/**
	 * 文件存入数据库
	 * @param localFile
	 */
	private void saveStudents(File localFile)
	{
		int count = 0;
		ExcelTicket excelTicket = new ExcelTicket();
		List<TicketDto> tickets = excelTicket.loadAndAnalysisExcel(localFile.getAbsolutePath());
		ticketDao.delLottery();
		for(TicketDto ticket : tickets)
		{	
			count++;
			createOrUpdateTicket(ticket,count);
		}
		logger.info("文件："+localFile.getAbsolutePath()+" 抽查样票信息已经录入数据库！");
	}

	@Override
	public void createOrUpdateTicket(TicketDto ticketDto) {
		// TODO 自动生成的方法存根
		
	}

}


