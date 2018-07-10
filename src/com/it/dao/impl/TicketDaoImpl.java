package com.it.dao.impl;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.it.dao.TicketDao;
import com.it.model.TicketEntity;


/**
 *  票号Dao实现
 * @author hht
 * @date 2018年7月6日
 */
public class TicketDaoImpl implements  TicketDao
{
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
	public Session getSession()
	{
		return sessionFactory.getCurrentSession();
	}

	public void createOrUpdateTicket(TicketEntity ticketEntiy)
	{
		Session session = getSession();
		session.saveOrUpdate(ticketEntiy);
	}
	
	public void delLottery() {
		Session session= getSession();
		String sql = "truncate table lottery";
		System.out.println(sql);
		session.createSQLQuery(sql).executeUpdate();
	}

	
	public TicketEntity getTicketByTicketNumber(String ticketNumber)
	{
		Session session = getSession();
		Query query = session.createQuery("select entity from " +TicketEntity.class.getName()+ " entity where entity.ticketNumber = ?");
		query.setParameter(0, ticketNumber);
		List<?> list = query.list();
		return list.size()>0 ? (TicketEntity)list.get(0) : null;
	}
}

