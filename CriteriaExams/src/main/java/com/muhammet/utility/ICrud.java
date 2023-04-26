/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.muhammet.utility;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author scous
 */
public interface ICrud<T,ID> extends IRepository<T, ID>{

    <S extends T > S save(S entity);

    <S extends T> Iterable<S> saveAll(Iterable<S> entities);

    Optional<T> findById(ID id);
    
    boolean existById(ID id);
    
    List<T> findAll();
    List<T> findByEntity (T entity);
    List<T> findColumAndValue(String column , Object value);
    void deleteById (ID id);
    void delete(T entity);

}
