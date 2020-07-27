package com.ticket.management.dao;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ticket.management.model.Ticket;


@Repository
public class TicketDAOImpl implements TicketDAO {

	// define field for entitymanager	
	private EntityManager entityManager;
		
	//constructor injection
	@Autowired
	public TicketDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	
	@Override
	public void postTicket(Ticket ticket) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(ticket);
		
	}


}







