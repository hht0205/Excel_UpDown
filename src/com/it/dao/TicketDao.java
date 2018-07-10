package com.it.dao;

import com.it.model.TicketEntity;

/**
 * 票号Dao
 * @author hht
 * @date 2018年7月6日
 */
public interface TicketDao
{
	void createOrUpdateTicket(TicketEntity ticketNumberEntiy);
	void delLottery();
	TicketEntity getTicketByTicketNumber(String ticketNumber);
}
