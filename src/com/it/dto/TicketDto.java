package com.it.dto;

import java.io.Serializable;

/**
 * 票号
 * @author hht
 * @date 2018年7月6日
 */
public class TicketDto implements Serializable
{
	/**
	 * 唯一标识
	 */
	private String id;
	
	
	/**
	 * 票号
	 */
	private String ticketNumber;
	/**
	 * 期号
	 */
	private String period;


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}

	public String getTicketNumber() {
		return ticketNumber;
	}


	public void setTicketNumber(String ticketNumber) {
		this.ticketNumber = ticketNumber;
	}
	public String getPeriod() {
		return period;
	}


	public void setPeriod(String period) {
		this.period = period;
	}

}


