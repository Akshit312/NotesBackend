package com.we.springmvcboot.Entity;


import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;

@Entity
@Table(name = "Notes")
@SQLDelete(sql = "UPDATE Notes SET deleted = true WHERE id=?")
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String Title;

    @Column(name = "message", length=4000)
    private String Message;

    @Column(name = "date", columnDefinition="char(10)")
    private String date;

    @Column(name = "deleted", columnDefinition = "tinyint(1) default 0")
    private boolean deleted;

    @Column(name = "label")
    private int label = 1;

    @ManyToOne()
    @JoinColumn(name = "userid", nullable = false)

    private User user;


    public Notes() {
    }


    public Notes(String title, String message, String date, User user, int label) {
        super();
        Title = title;
        Message = message;
        this.date = date;
        this.user = user;
        this.label = label;
    }


    public Notes(Long id, String title, String message, String date, int label) {
        super();
        this.id = id;
        Title = title;
        Message = message;
        this.date = date;
        this.label = label;
    }

    public boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public int getLabel() {
        return label;
    }

    public void setLabel(int label) {
        this.label = label;
    }

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getTitle() {
        return Title;
    }


    public void setTitle(String title) {
        Title = title;
    }


    public String getMessage() {
        return Message;
    }


    public void setMessage(String message) {
        Message = message;
    }


    public String getDate() {
        return date;
    }


    public void setDate(String date) {
        this.date = date;
    }


    public void setUser(User user) {
        this.user = user;
    }


}