package com.vine.blog.domain.entity.ticket;

import java.util.Arrays;
import java.util.List;

public enum TicketPriority {
    LOW("低"),
    MEDIUM("中"),
    HIGH("高"),
    URGENT("紧急");

    private String title;

    TicketPriority(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return this.title;
    }

    public static List<TicketPriority> all() {
        return Arrays.asList(LOW, MEDIUM, HIGH, URGENT);
    }
}
