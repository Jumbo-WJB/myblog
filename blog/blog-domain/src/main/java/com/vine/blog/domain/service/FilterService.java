package com.vine.blog.domain.service;

import com.vine.blog.domain.entity.ticket.Field;
import com.vine.blog.domain.entity.filter.Filter;
import com.vine.blog.domain.entity.ticket.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FilterService {

    Page<Ticket> getFilterTickets(Filter filter,Pageable pageable);

    List<Field> findFields(List<Ticket> tickets,List<String> showFields);

}
