package com.muhammet.repository.entity;

import javax.persistence.Embeddable;

/**
 * Bu sınıf başka bir enitity içine alan olarak eklenebilir. Bu sınıf eklendiğinde 
 * DB de sınıf adı ya da ilişki olarak görünmez. içinde bulunan alanları tabloya 
 * yansıtılır.
 * @author MuhammetAli
 */
@Embeddable
public class BaseEntity {
    
    private Long createat;
    private Long updateat;
    private int state;

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
