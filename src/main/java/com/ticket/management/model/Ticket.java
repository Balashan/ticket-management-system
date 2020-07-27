package com.ticket.management.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Ticket{
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private int ticketId;
	
	private String createdBy;
	
	private String description;
	
	private int severity;
	
	private Status status;
	
	private Cancelled cancelled;
	
	private String cancelledOtherDescription;
	
	private String comments;

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getSeverity() {
		return severity;
	}

	public void setSeverity(int severity) {
		this.severity = severity;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Cancelled getCancelled() {
		return cancelled;
	}

	public void setCancelled(Cancelled cancelled) {
		this.cancelled = cancelled;
	}

	public String getCancelledOtherDescription() {
		return cancelledOtherDescription;
	}

	public void setCancelledOtherDescription(String cancelledOtherDescription) {
		this.cancelledOtherDescription = cancelledOtherDescription;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
	
	
}