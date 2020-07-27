package com.ticket.management.service;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticket.management.dao.TicketDAO;
import com.ticket.management.model.Ticket;

@Service
public class TicketServiceImpl implements TicketService{

	@Autowired
	private TicketDAO ticketDAO;
	
	@Override
	@Transactional
	public void postTicket(Ticket ticket) {
		ticketDAO.postTicket(ticket);
		
	}

}
