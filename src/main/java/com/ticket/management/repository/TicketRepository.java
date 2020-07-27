package com.ticket.management.repository;

import org.springframework.data.repository.CrudRepository;

import com.ticket.management.model.Ticket;

public interface TicketRepository extends CrudRepository<Ticket,Integer>{
	
}
