package com.vine.blog.domain.entity.ticket;

import com.fasterxml.jackson.annotation.JsonView;
import com.vine.blog.domain.entity.account.Account;
import com.vine.blog.domain.entity.group.Group;
import com.vine.blog.domain.entity.organization.Organization;
import com.vine.blog.domain.entity.BaseEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tickets")
public class Ticket extends BaseEntity {

    @ManyToOne
    @JsonView(Summary.class)
    private Organization organization;

    @JsonView(Summary.class)
    private String title;

    @JsonView(Summary.class)
    @Column(columnDefinition = "TEXT")
    private String description;

    @JsonView(Summary.class)
    @Enumerated(EnumType.STRING)
    private TicketType type = TicketType.PROBLEM;

    @JsonView(Summary.class)
    @Enumerated(EnumType.STRING)
    private TicketStatus status = TicketStatus.NEW;

    @JsonView(Summary.class)
    @Enumerated(EnumType.STRING)
    private TicketPriority priority;

    @JsonView(Summary.class)
    private String recipient;

    @ManyToOne
    @JsonView(Summary.class)
    private Account requester;

    @ManyToOne
    @JsonView(Summary.class)
    private Account assignee;

    @ManyToOne
    @JsonView(Summary.class)
    private Group group;

    @JsonView(Summary.class)
    private Date dueDate;

    @JsonView(Summary.class)
    private Date assignedAt;

    @JsonView(Summary.class)
    private Date resolvedAt;

    @JsonView(Summary.class)
    private Date closedAt;

    @JsonView(Summary.class)
    private String source;

    @ElementCollection
    @JsonView(Summary.class)
    private Set<String> tags = new HashSet<String>();

    public Ticket() {
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
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

    public TicketType getType() {
        return type;
    }

    public void setType(TicketType type) {
        this.type = type;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }

    public TicketPriority getPriority() {
        return priority;
    }

    public void setPriority(TicketPriority priority) {
        this.priority = priority;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public Account getRequester() {
        return requester;
    }

    public void setRequester(Account requester) {
        this.requester = requester;
    }

    public Account getAssignee() {
        return assignee;
    }

    public void setAssignee(Account assignee) {
        this.assignee = assignee;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getAssignedAt() {
        return assignedAt;
    }

    public void setAssignedAt(Date assignedAt) {
        this.assignedAt = assignedAt;
    }

    public Date getResolvedAt() {
        return resolvedAt;
    }

    public void setResolvedAt(Date resolvedAt) {
        this.resolvedAt = resolvedAt;
    }

    public Date getClosedAt() {
        return closedAt;
    }

    public void setClosedAt(Date closedAt) {
        this.closedAt = closedAt;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }
}
