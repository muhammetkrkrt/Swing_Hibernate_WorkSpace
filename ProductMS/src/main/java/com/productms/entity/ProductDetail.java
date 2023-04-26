package com.productms.entity;

import javax.persistence.*;

@Entity
public class ProductDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String comment;
    private int puan;

    @ManyToOne
    @JoinColumn(name = "product_id" ,referencedColumnName = "id")
    private Product product;

    public ProductDetail(String comment, int puan) {
        this.comment = comment;
        this.puan = puan;
    }
    public ProductDetail() {

    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getPuan() {
        return puan;
    }

    public void setPuan(int puan) {
        this.puan = puan;
    }
}
