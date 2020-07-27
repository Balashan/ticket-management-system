package com.ticket.management.controller;


import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ticket.management.model.Cancelled;
import com.ticket.management.model.Status;
import com.ticket.management.model.Ticket;
import com.ticket.management.service.TicketService;

import io.swagger.annotations.ApiOperation;

//import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/ticket-management-system")
public class TicketController {
	
	@Autowired
	private TicketService ticketService;

    @ApiOperation("This is the hello world api")
    @GetMapping("/api/ticket/")
    public Ticket hello() {
    	System.out.println("Enter the Description........");
    	Scanner scanner = new Scanner(System.in);
    	Ticket ticket = new Ticket();
    	ticket.setCreatedBy("balamurugan");
    	ticket.setDescription(scanner.nextLine());
    	ticket.setSeverity(1);
    	System.out.println("Enter the Status you want COMPLETED OR CANCELLED.......");
    	String status = scanner.nextLine();
    	if(!status.equals("")) {
    		if(status.equals("COMPLETED")) {
    			ticket.setStatus(Status.valueOf(status));
    		}else {
    			System.out.println("Enter the Cancelled Reason OTHERS OR ENDUSER");
    			String cancelledReason = scanner.nextLine();
    			if(!cancelledReason.equals("")) {
    				ticket.setCancelled(Cancelled.valueOf(cancelledReason));
    			}else {
    				ticket.setCancelled(null);
    			}
    		}
    	}else {
    		ticket.setStatus(null);
    	}
    	ticket.setCancelledOtherDescription("Nothing");
    	ticket.setComments("check");
    	ticketService.postTicket(ticket);
    	return ticket;
    }
    
}
