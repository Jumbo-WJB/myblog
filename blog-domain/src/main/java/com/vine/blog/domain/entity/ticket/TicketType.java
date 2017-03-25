package com.vine.blog.domain.entity.ticket;

public enum TicketType {
    PROBLEM("故障"), INCIDENT("事务"), QUESTION("问题"), TASK("任务");

    private String title;

    TicketType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return this.title;
    }
}
