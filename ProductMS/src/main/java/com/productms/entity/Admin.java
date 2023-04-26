package com.productms.entity;

import javax.persistence.*;

@Entity
@Table(name = "admins")
public class Admin extends User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public Admin(String firstName, String lastName, String email) {
        super(firstName, lastName, email);
    }
    public Admin() {

    }
}
