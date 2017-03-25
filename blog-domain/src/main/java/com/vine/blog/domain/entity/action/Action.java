package com.vine.blog.domain.entity.action;

import com.fasterxml.jackson.annotation.JsonView;
import com.vine.blog.domain.entity.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "actions")
public class Action extends BaseEntity {

    @JsonView(Summary.class)
    private String source;

    @JsonView(Summary.class)
    private String value;

    @JsonView(Summary.class)
    private String subject;

    @JsonView(Summary.class)
    private String body;

    public Action() {
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
