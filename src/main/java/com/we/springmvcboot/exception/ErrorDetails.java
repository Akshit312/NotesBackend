package com.we.springmvcboot.exception;

import java.util.Date;

public class ErrorDetails {
    private Date timestamp;
    private String status;
    private String message;
    private String details;

    public ErrorDetails(Date timestamp, String status, String message, String details) {
        super();
        this.status=status;
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public String getStatus() {
        return status;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
}
