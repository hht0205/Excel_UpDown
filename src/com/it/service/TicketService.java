package com.it.service;

import com.it.dto.TicketDto;
import com.it.dto.UploadFileDto;
/**
 * 票号
 * @author hht
 * @date 2017年9月19日
 */
public interface TicketService
{
	void createOrUpdateTicket(TicketDto ticketDto);
	
	TicketDto getTicketByTicketNumber(String ticketNumber);
	
	void uploadTicketListFile(UploadFileDto uploadFile);
}

