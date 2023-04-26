package org.muhammet.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Adress {

    private String street;
    private String country;
    private String city;

    public Adress() {
    }

    public Adress(String street, String country, String city) {
        this.street = street;
        this.country = country;
        this.city = city;
    }
}
