package com.ticket.management.controller;


import java.math.BigInteger;
import java.util.Map;

import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ticket.management.model.Cancelled;
import com.ticket.management.model.Status;
import com.ticket.management.model.Ticket;
import com.ticket.management.service.TicketService;

import io.swagger.annotations.ApiOperation;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/ticket-management-system")
public class TicketController {
	
	@Autowired
	private TicketService ticketService;

    @ApiOperation("This is the hello world api")
    @PostMapping("/api/ticket/")
    public String hello( @RequestBody String param) throws ParseException {
    	JSONParser parser = new JSONParser(param);
    	Map<String,Object> parsedMap = (Map<String, Object>)parser.parse();
    	Map<String,Object> map = (Map<String, Object>)parsedMap.get("param");
    	Ticket ticket = new Ticket();
    	ticket.setCreatedBy((String) map.get("createdBy"));
    	ticket.setDescription((String) map.get("description"));
    	ticket.setSeverity(((BigInteger) map.get("severity")).intValue());
    	String status = (String)map.get("status")!=null? (String)map.get("status"): null;
    	if(status!=null) {
    		ticket.setStatus(Status.valueOf(status));
    	}
    	String cancelledReson = (String)map.get("cancelledReason")!=null? (String)map.get("cancelledReason"): null;
    	if(cancelledReson!=null) {
    		ticket.setCancelled(Cancelled.valueOf(cancelledReson));
    	}
    	Object cancelledOtherDescription = map.get("cancelledDescription")!=null? map.get("cancelledDescription"):null ;
    	ticket.setCancelledOtherDescription((String) cancelledOtherDescription);
    	ticket.setComments((String) map.get("comments"));
    	ticketService.postTicket(ticket);
    	return "success";
    }
    
}
