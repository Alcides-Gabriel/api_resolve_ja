package org.resolva.services;

import java.util.List;

import org.resolva.model.ticket.Ticket;
import org.resolva.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketServices {

	@Autowired
	private TicketRepository repository;
	
	public List<Ticket> findAll() {
		return repository.findAll();
	}
	
	public Ticket findTicketById(int id) {
		return repository.findById(id)
				.orElseThrow(() -> new RuntimeException());
	}
	
	public Ticket openTicket(Ticket ticket) {
		return repository.save(ticket);
	}
	
	public Ticket update(Ticket ticket) {
		Ticket entity = repository.findById(ticket.getId())
				.orElseThrow(() -> new RuntimeException());
		
		entity.setTitle(ticket.getTitle());
		entity.setDescription(ticket.getDescription());
		
		return repository.save(entity);
	}
	
	public void delete(int id) {
		Ticket entity = repository.findById(id)
				.orElseThrow(() -> new RuntimeException());
		repository.delete(entity);
	}
	
}
