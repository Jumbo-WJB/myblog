package com.vine.blog.domain.entity.organization;

import com.fasterxml.jackson.annotation.JsonView;
import com.vine.blog.domain.entity.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "organizations")
public class Organization extends BaseEntity {

    @JsonView(Summary.class)
    private String name;

    @JsonView(Summary.class)
    private String domain;

    @JsonView(Summary.class)
    private String description;

    public Organization() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
