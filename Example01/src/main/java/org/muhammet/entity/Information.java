package org.muhammet.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Information {

    private String name ;
    private String surname;
    private String middleName;

    public Information(String name, String surname, String middleName) {
        this.name = name;
        this.surname = surname;
        this.middleName = middleName;
    }

    public Information() {
    }

    @Override
    public String toString() {
        return "Information{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", middleName='" + middleName + '\'' +
                '}';
    }
}
