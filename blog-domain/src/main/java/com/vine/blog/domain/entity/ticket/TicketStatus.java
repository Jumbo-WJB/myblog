package com.vine.blog.domain.entity.ticket;

import java.util.Arrays;
import java.util.List;

public enum TicketStatus {
    NEW("尚未处理"),
    OPEN("受理中"),
    PENDING("等待回复"),
    SOLVED("已解决"),
    CLOSED("已关闭");

    private String title;

    TicketStatus(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return this.title;
    }

    public static List<TicketStatus> all() {
        return Arrays.asList(NEW, OPEN, PENDING, SOLVED, CLOSED);
    }
}
