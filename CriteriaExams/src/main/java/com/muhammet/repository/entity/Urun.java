package com.muhammet.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tblurun")
public class Urun {
    @Id
    /**
     * id nin bellir bir düzen içinde otomatik paramtetre alması için
     * kullanılır. Burada id nin 1,2,3,4.... şeklinde atanması 
     * planlamıştır.
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)        
    private Long id;
    /**
     * DİKKAT!!! bu işlem sadece sequence oluşturur.
     * Bunun kullanmak için atamanız gereklidir.
     */
    @SequenceGenerator(name = "sq_urun_otherid",
            initialValue = 100,allocationSize = 3, sequenceName = "sq_urun_otherid")
    @GeneratedValue(generator = "sq_urun_otherid")
    private Long otherid;
    
    /**
     * DİKKAT!!!!!
     * Alan adlarınızı yazarken kısıtlarını ve sınırlarını belirlemez iseniz
     * default değerler alırlar. mesela;
     * uzunluk olarak : String 255 karakterdir.
     */
    @Column(length = 200, // alan adının kaç karakter olacağını belirler
            name = "ad", // kolon adını değiştirir.
            unique = true, // bu alanın benzersiz olup olmayacağını belirtir.
            nullable = false, // bu alanın NULL değer alıp almayacağını belitir.
            insertable = true) // bu alana değer girilip girililmeyeceğini kısıtlar
    private String ad;
    
    private String marka;
    private String model;
    private Double fiyat;
    private int stok;
    private String barkod;
    private Long createat;
    private Long updateat;
    private int state;

    public Urun() {
    }

    public Urun(Long otherid, String ad, String marka, String model, Double fiyat, int stok, String barkod, Long createat, Long updateat, int state) {
        this.otherid = otherid;
        this.ad = ad;
        this.marka = marka;
        this.model = model;
        this.fiyat = fiyat;
        this.stok = stok;
        this.barkod = barkod;
        this.createat = createat;
        this.updateat = updateat;
        this.state = state;
    }

    public Urun(Long id, Long otherid, String ad, String marka, String model, Double fiyat, int stok, String barkod, Long createat, Long updateat, int state) {
        this.id = id;
        this.otherid = otherid;
        this.ad = ad;
        this.marka = marka;
        this.model = model;
        this.fiyat = fiyat;
        this.stok = stok;
        this.barkod = barkod;
        this.createat = createat;
        this.updateat = updateat;
        this.state = state;
    }

    @Override
    public String toString() {
        return "Urun{" + "id=" + id + ", otherid=" + otherid + ", ad=" + ad + ", marka=" + marka + ", model=" + model + ", fiyat=" + fiyat + ", stok=" + stok + ", barkod=" + barkod + ", createat=" + createat + ", updateat=" + updateat + ", state=" + state + '}';
    }

    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOtherid() {
        return otherid;
    }

    public void setOtherid(Long otherid) {
        this.otherid = otherid;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getFiyat() {
        return fiyat;
    }

    public void setFiyat(Double fiyat) {
        this.fiyat = fiyat;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public String getBarkod() {
        return barkod;
    }

    public void setBarkod(String barkod) {
        this.barkod = barkod;
    }

    public Long getCreateat() {
        return createat;
    }

    public void setCreateat(Long createat) {
        this.createat = createat;
    }

    public Long getUpdateat() {
        return updateat;
    }

    public void setUpdateat(Long updateat) {
        this.updateat = updateat;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
    
    
            
}
