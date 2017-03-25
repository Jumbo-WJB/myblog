package com.vine.blog.domain.repository;

import com.vine.blog.domain.entity.ticket.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    Page<Ticket> findByIdIn(List<Long> ticketIds, Pageable pageable);
}
