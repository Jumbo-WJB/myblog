package com.vine.blog.domain.entity.ticket;

import com.fasterxml.jackson.annotation.JsonView;
import com.vine.blog.domain.entity.BaseEntity;
import com.vine.blog.domain.entity.account.Account;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ticket_comments")
public class TicketComment extends BaseEntity {

    @ManyToOne
    @JsonView(Summary.class)
    private Account author;

    @ManyToOne
    @JsonView(Summary.class)
    private Ticket ticket;

    @JsonView(Summary.class)
    private String content;

    @JsonView(Summary.class)
    @Column(nullable = false, columnDefinition = "BOOLEAN default 0")
    private boolean published = false;

    public TicketComment() {
    }

    public Account getAuthor() {
        return author;
    }

    public void setAuthor(Account author) {
        this.author = author;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }
}
