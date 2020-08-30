package com.we.springmvcboot.Entity;

import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid", nullable = false, unique = true)
    private long id;

    @Column(name = "emailid")
    private String emailID;

    @Where(clause = "deleted = false")
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Notes> usernotes;

    public User() {
    }

    public User(String emailID) {
        super();
        this.emailID = emailID;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }


    public Set<Notes> getUsernotes() {
        return usernotes;
    }

    public void setUsernotes(Set<Notes> usernotes) {
        this.usernotes = usernotes;
    }


}