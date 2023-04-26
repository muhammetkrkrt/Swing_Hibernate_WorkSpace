package com.muhammet.repository;

import com.muhammet.entity.Musteri;
import com.muhammet.utility.MyFactoryRepository;

public class MusteriRepository extends MyFactoryRepository<Musteri, Long>{
    
    public MusteriRepository(){
        super(new Musteri());
    }
}
