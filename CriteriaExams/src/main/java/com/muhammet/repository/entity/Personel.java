package com.muhammet.repository.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "tblpersonel")
@Entity
public class Personel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String ad;
    
    /**
     * @Enumareted(EnumType.String)
     * @OneToMany
     * @ElementCollection
     * 
     */
    
    String unvani; // Müdür, Müd. Mdr., Md. MÜDÜR // Enum kullanalım.
    
    String adres; // Adres Listesi
    String telefon; // Telefon liste
    
    
}
