package com.vine.blog.domain.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.vine.blog.domain.forum.entity.Thread;


public interface TicketService {
    public void dealBbsData(Thread preForumThread) throws JsonProcessingException;

    public Thread findBBSData(long id);

}
