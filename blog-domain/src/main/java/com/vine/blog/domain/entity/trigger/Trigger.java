package com.vine.blog.domain.entity.trigger;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.vine.blog.domain.entity.account.Account;
import com.vine.blog.domain.entity.action.Action;
import com.vine.blog.domain.entity.BaseEntity;
import com.vine.blog.domain.entity.condition.Condition;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "triggers")
public class Trigger extends BaseEntity {

    @JsonView(Summary.class)
    private String title;

    @JsonView(Summary.class)
    @Column(nullable = false, columnDefinition = "BOOLEAN default 0")
    private boolean active = false;

    @ManyToOne
    @JsonIgnore
    private Account owner;

    @ManyToMany
    @JsonView(Summary.class)
    private List<Condition> all = new ArrayList<>();

    @ManyToMany
    @JsonView(Summary.class)
    private List<Condition> any = new ArrayList<>();

    @ManyToMany
    @JsonView(Summary.class)
    private List<Action> actions = new ArrayList<>();

    public Trigger() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Account getOwner() {
        return owner;
    }

    public void setOwner(Account owner) {
        this.owner = owner;
    }

    public List<Condition> getAll() {
        return all;
    }

    public void setAll(List<Condition> all) {
        this.all = all;
    }

    public List<Condition> getAny() {
        return any;
    }

    public void setAny(List<Condition> any) {
        this.any = any;
    }

    public List<Action> getActions() {
        return actions;
    }

    public void setActions(List<Action> actions) {
        this.actions = actions;
    }
}
