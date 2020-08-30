package com.we.springmvcboot.request;

public class addRequest {
    private long appNotesID;

    private String title;

    private String message;

    private String date;

    private int label;

    public long getAppNotesID() {
        return appNotesID;
    }

    public void setAppNotesID(long appNotesID) {
        this.appNotesID = appNotesID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getLabel() {
        return label;
    }

    public void setLabel(int label) {
        this.label = label;
    }
}
