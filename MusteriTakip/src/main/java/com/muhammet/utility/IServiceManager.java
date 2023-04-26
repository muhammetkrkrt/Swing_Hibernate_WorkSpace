package com.muhammet.utility;

import com.muhammet.entity.User;
import java.util.List;
import java.util.Optional;
/**
 * 
 * @author MuhammetAli
 * @param <T>  Type -> 
 */
public interface IServiceManager<T> {
  
    void save(T t);
    void update(T t);
    void delete(Long id);
    List<T> findAll();
    List<T> findByAd(String ad);
    Optional<T> findById(Long id);
    List<T> findByEntity(T entity);
    
}
