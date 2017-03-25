package com.vine.blog.domain.entity.attachment;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.vine.blog.domain.entity.ticket.TicketComment;
import com.vine.blog.domain.entity.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "attachments")
public class Attachment extends BaseEntity {

    @JsonView(Summary.class)
    private String name;

    @JsonView(Summary.class)
    private String size;

    @JsonView(Summary.class)
    private String url;

    @JsonView(Summary.class)
    private String token;

    @ManyToOne
    @JsonIgnore
    private TicketComment ticketComment;

    public Attachment() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public TicketComment getTicketComment() {
        return ticketComment;
    }

    public void setTicketComment(TicketComment ticketComment) {
        this.ticketComment = ticketComment;
    }
}
