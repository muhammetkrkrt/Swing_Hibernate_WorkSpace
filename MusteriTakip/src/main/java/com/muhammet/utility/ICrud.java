package com.muhammet.utility;

import java.util.List;
import java.util.Optional;

public interface ICrud<T,ID> extends IRepository<T, ID>{
    /**
     * Musteri(id, ad,soyad)
     * MusteriBasit(id,ad,soyad,adres) extends Musteri
     * MusteriGelismis(id,ad,soyad,telefon,yerki);
     * @param <S>
     * @param entity
     * @return 
     */
    <S extends T> S save(S entity);
    <S extends T> S update(S entity);    
    <S extends T> Iterable<S> saveAll(Iterable<S> entities);
    Optional<T> findById(ID id);
    boolean existById(ID id);
    List<T> findAll();
    List<T> findByEntity(T entity);
    List<T> findByColumAndValue(String column, Object value);
    void deleteById(ID id);
    void delete(T entity);
    
}
