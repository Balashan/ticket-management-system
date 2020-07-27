package com.ticket.management.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ticket.management.model.Status;
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
	public List<Ticket> findAll(Ticket ticket) {

		Session currentSession = entityManager.unwrap(Session.class);
		String createdBy = ticket.getCreatedBy();
		String description = ticket.getDescription();
		int severity = ticket.getSeverity();
		Status status = ticket.getStatus();
		
		// create a query
		Query<Ticket> theQuery =
				currentSession.createQuery("from Ticket t where t.createdBy=:createdBy AND t.description=:description AND t.severity=:severity AND t.status=:status", Ticket.class);
		
		theQuery.setParameter("createdBy", createdBy);
		theQuery.setParameter("description", description);
		theQuery.setParameter("severity", severity);
		theQuery.setParameter("status", status);
		List<Ticket> tickets = theQuery.getResultList();
		return tickets;
	}


	@Override
	public void postTicket(Ticket ticket) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(ticket);
		
	}


}







