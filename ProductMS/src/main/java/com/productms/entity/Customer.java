package com.productms.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Customer extends User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String password;
    @Column(unique = true)
    private String identity;

    @ManyToMany(mappedBy = "customers")
    private List<Product> products;

    public Customer(String firstName, String lastName, String email, String password, String identity) {
        super(firstName, lastName, email);
        this.password = password;
        this.identity = identity;
    }
    public Customer() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }
}