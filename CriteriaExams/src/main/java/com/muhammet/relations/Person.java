package com.muhammet.relations;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "tblperson")
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private int age;
    private String phone;
    
    @OneToOne(cascade = CascadeType.ALL)    
    @JoinColumn(name = "arabanin_idsi")
    private Car car;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "tblmusteri_adres_listesi",
            joinColumns = @JoinColumn(name = "tblpersonel_id"),
            inverseJoinColumns = @JoinColumn(name = "tbladdres_id")
            )
    private List<Address> adreslist;
    
    @ManyToOne(cascade = CascadeType.ALL)
    Department department;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Address> getAdreslist() {
        return adreslist;
    }

    public void setAdreslist(List<Address> adreslist) {
        this.adreslist = adreslist;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
    
    
    
}
