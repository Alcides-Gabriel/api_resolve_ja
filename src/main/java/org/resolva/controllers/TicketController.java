package org.resolva.controllers;

import java.util.List;

import org.resolva.model.ticket.Ticket;
import org.resolva.services.TicketServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticket")
public class TicketController {
	
	@Autowired
	private TicketServices ticketService;
	
	@GetMapping
	public List<Ticket> findAll() {
		return ticketService.findAll();
	}
	
	@GetMapping("/{id}")
	public Ticket findTicketById(@PathVariable("id") int id) {
		return ticketService.findTicketById(id);
	}
	
	@PostMapping
	public Ticket openTicket(@RequestBody Ticket ticket) {
		return ticketService.openTicket(ticket);
	}
	
	@PutMapping
	public Ticket update(@RequestBody Ticket ticket) {
		return ticketService.update(ticket);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) {
		ticketService.delete(id);
		return ResponseEntity.ok().build();
	}

}
