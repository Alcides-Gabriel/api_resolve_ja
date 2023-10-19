package org.resolva.model.ticket;

import java.time.LocalDateTime;
import java.util.Objects;

import org.resolva.model.ticket.enums.TicketCategory;
import org.resolva.model.ticket.enums.TicketPriority;
import org.resolva.model.ticket.enums.TicketStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tickets")
public class Ticket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "created_at")
	private LocalDateTime createdAt = LocalDateTime.now();
	private String title;
	private String description;
	private TicketCategory category;
	private TicketPriority priority;
	private TicketStatus status;
	@Column(name = "author_id")
	private int authorId;
	@Column(name = "tech_id")
	private int techId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public TicketCategory getCategory() {
		return category;
	}
	public void setCategory(TicketCategory category) {
		this.category = category;
	}
	public TicketPriority getPriority() {
		return priority;
	}
	public void setPriority(TicketPriority priority) {
		this.priority = priority;
	}
	public TicketStatus getStatus() {
		return status;
	}
	public void setStatus(TicketStatus status) {
		this.status = status;
	}
	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	public int getTechId() {
		return techId;
	}
	public void setTechId(int techId) {
		this.techId = techId;
	}
	@Override
	public int hashCode() {
		return Objects.hash(authorId, category, createdAt, description, id, priority, status, techId, title);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ticket other = (Ticket) obj;
		return authorId == other.authorId && category == other.category && Objects.equals(createdAt, other.createdAt)
				&& Objects.equals(description, other.description) && Objects.equals(id, other.id)
				&& priority == other.priority && status == other.status && techId == other.techId
				&& Objects.equals(title, other.title);
	}
	@Override
	public String toString() {
		return "Ticket [id=" + id + ", createdAt=" + createdAt + ", title=" + title + ", description=" + description
				+ ", category=" + category + ", priority=" + priority + ", status=" + status + ", authorId=" + authorId
				+ ", techId=" + techId + "]";
	}
	
	
	
	
	
	
	

}
