package com.vine.blog.domain.entity.condition;

import com.fasterxml.jackson.annotation.JsonView;
import com.vine.blog.domain.entity.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "conditions")
public class Condition extends BaseEntity {

    @JsonView(Summary.class)
    private String source;

    @JsonView(Summary.class)
    private String operator;

    @JsonView(Summary.class)
    private String value;

    public Condition() {
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
