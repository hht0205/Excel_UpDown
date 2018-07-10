package com.it.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 票号实体
 * @author hht
 * @date 2018年7月6日
 */
@Entity(name = "lottery")
public class TicketEntity implements Serializable
{
	/**
	 * 唯一标识
	 */
	@Id
	@NotBlank
	@Length(max=36)
	private String id;
	
	
	/**
	 * 票号
	 */
	@NotBlank
	@Length(max=36)
	private String ticketNumber;
	
	/**
	 * 期次
	 */
	@NotNull
	@Length(max=36)
	private String period;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(String ticketNumber) {
		this.ticketNumber = ticketNumber;
	}
	

	
}


