package com.vine.blog.domain.repository;

import com.vine.blog.domain.entity.ticket.TicketComment;
import com.vine.blog.domain.entity.ticket.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketCommentRepository extends JpaRepository<TicketComment, Long> {
    List<TicketComment> findByTicket(Ticket ticket);
    List<TicketComment> findByTicketOrderByIdDesc(Ticket ticket);
}