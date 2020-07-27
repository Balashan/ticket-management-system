package com.ticket.management.service;

import java.sql.Date;
import java.util.List;


import com.ticket.management.model.Ticket;

public interface TicketService{
	
	public List<Ticket> findAll(Ticket ticket);

	public void postTicket(Ticket ticket);
}