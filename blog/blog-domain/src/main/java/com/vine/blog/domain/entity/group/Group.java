package com.vine.blog.domain.entity.group;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.vine.blog.domain.entity.organization.Organization;
import com.vine.blog.domain.entity.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "groups")
public class Group extends BaseEntity {

    @JsonView(Summary.class)
    private String name;

    @ManyToOne
    @JsonIgnore
    private Organization organization;

    public Group() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }
}
