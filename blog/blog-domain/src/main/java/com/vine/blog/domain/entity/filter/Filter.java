package com.vine.blog.domain.entity.filter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.vine.blog.domain.entity.account.Account;
import com.vine.blog.domain.entity.condition.Condition;
import com.vine.blog.domain.entity.BaseEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "filters")
public class Filter extends BaseEntity {

    @JsonView(Summary.class)
    private String title;

    @JsonView(Summary.class)
    @Column(nullable = false, columnDefinition = "BOOLEAN default 0")
    private boolean active = false;

    @ManyToOne
    @JsonIgnore
    private Account owner;

    @ManyToMany
    @JsonIgnore
    private List<Condition> all = new ArrayList<>();

    @ManyToMany
    @JsonIgnore
    private List<Condition> any = new ArrayList<>();

    @JsonView(Summary.class)
    @ElementCollection
    private List<String> showField = new ArrayList<>();

    public Filter() {
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
}
