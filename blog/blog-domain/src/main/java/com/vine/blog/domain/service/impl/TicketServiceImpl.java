package com.vine.blog.domain.service.impl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.vine.blog.domain.entity.ticket.Ticket;
import com.vine.blog.domain.forum.repository.ForumBaseNativeSqlRepository;
import com.vine.blog.domain.util.JsonUtils;
import com.vine.blog.domain.entity.ticket.TicketStatus;
import com.vine.blog.domain.repository.TicketRepository;
import com.vine.blog.domain.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import com.vine.blog.domain.forum.entity.Thread;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class TicketServiceImpl implements TicketService{

    @Autowired
    private ForumBaseNativeSqlRepository baseNativeSqlRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public void dealBbsData(Thread forumThread) throws JsonProcessingException {
        System.out.println(JsonUtils.toString(forumThread));
        Ticket ticket = new Ticket();
        ticket.setTitle(forumThread.getSubject());
        ticket.setStatus(TicketStatus.NEW);
        ticketRepository.save(ticket);
    }

    @Override
    public Thread findBBSData(long id) {
        String sql = " select * from pre_forum_thread where tid ="+id;
       List<Thread> preForumThreads =  baseNativeSqlRepository.queryListByJdbcTemplate(sql, Thread.class);
        return preForumThreads.get(0);
    }

}
