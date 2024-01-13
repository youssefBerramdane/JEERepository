package com.TransfertNational.demo.Entities;

import javax.persistence.*;

@Entity
@Table(name="admins")
public class Admin {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private String fullName;

    @Column(nullable=false)
    private String adminName;

    @Column(nullable=false)
    private String password;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
