package com.ticket.management.dao;

import java.sql.Date;
import java.util.List;

import com.ticket.management.model.Ticket;


public interface TicketDAO {

	public List<Ticket> findAll(Ticket ticket);

	public void postTicket(Ticket bus);
	
	
	
}
